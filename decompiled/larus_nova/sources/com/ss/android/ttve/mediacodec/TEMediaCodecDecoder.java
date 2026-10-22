package com.ss.android.ttve.mediacodec;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Range;
import android.view.Surface;
import androidx.camera.core.processing.util.GLUtils;
import androidx.camera.video.AudioStats;
import com.alibaba.gaiax.template.GXMode;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.lynx.canvas.recorder.KryptonDefaultMediaRecorder;
import com.ss.android.medialib.util.VEPlatformUtils;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ttve.common.TEImageUtils;
import com.ss.android.ttve.common.TESharedContext;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.ttve.model.e;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VELogUtil;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public class TEMediaCodecDecoder implements SurfaceTexture.OnFrameAvailableListener, ImageReader.OnImageAvailableListener {
    private static final int ERROR_CONFIGURE_EXCEPTION = -4;
    private static final int ERROR_CREATE_FAIL_BECAUSE_OF_HW_OVERLOAD = -104;
    private static final int ERROR_CREATE_FAIL_GL_ERROR = -105;
    private static final int ERROR_EOF = -1;
    private static final int ERROR_MEDIA_CODEC_FAILED = -2;
    private static final int ERROR_MEDIA_FORMAT_ERROR = -5;
    private static final int ERROR_NEW_IMAGE_WAIT_FAIL = -103;
    private static final int ERROR_NONE = 0;
    private static final int ERROR_RECEIVE_OUTPUT_TRY_AGAIN = -102;
    private static final int ERROR_SEND_INPUT_FAIL = -101;
    private static final int ERROR_UNUSUAL = -3;
    private static final double FIX_VERSION = 0.18041d;
    private static final int PAGEMODE_COMPILE_CROP = 1;
    private static final int PAGEMODE_COMPILE_DOWNLOAD = 2;
    private static final int PAGEMODE_COMPILE_DOWNLOAD_SHARED = 3;
    private static final int PAGEMODE_COMPILE_IM = 12;
    private static final int PAGEMODE_COMPILE_PUBLISH = 0;
    private static final int PAGEMODE_COMPILE_UNKNOWN = -1;
    private static final int PAGEMODE_EDIRTOR_SAVE_LOCAL = 10;
    private static final int PAGEMODE_PREVIEW_EDITOR = 100;
    private static final int PAGEMODE_PREVIEW_PUBLISH_PREVIEW = 101;
    private static final int PAGEMODE_PREVIEW_PUBLISH_SELECT_COVER = 102;
    private static final int PAGEMODE_WATERMARK = 11;
    private static final String TAG = "TEMediaCodecDecoder";
    private static final String VERSION_PROPERTY = "ro.config.hw_codec_support";
    private static int file_count = 0;
    private static Object mCodecListLock = null;
    private static boolean mIsByteVC1Blocklist = false;
    private static ArrayList<MediaCodecInfo> mVideoHWDecoderCodecs = null;
    private static boolean m_useCreateDecoderByName = false;
    private static volatile boolean sDequeueHWDecodeInputBufferOpt = false;
    private static int sDequeueOutputTimeoutUs = 10000;
    private static boolean sHWDecodeSupportRtAndOr = false;
    private static int sPendingInputBufferThreshold = 5;
    private final int MAX_DELAY_COUNT;
    private final long MAX_SLEEP_MS;
    private final float Max_Playback_Speed;
    private final float Normal_Video_Fps;
    private String VIDEO_MIME_TYPE;
    private VEFrame mConvertFrame;
    private Image mImage;
    private ImageReader mImageReader;
    private boolean mIs10bit;
    private int mMinCompressionRatio;
    private HandlerThread mReaderHandlerThread;
    private VEFrame mScaleFrame;
    private Handler m_MediaCodechandler;
    private ConditionVariable m_ReEncodeOptCV;
    private volatile boolean m_awaitNewImageSuccess;
    private int m_bGlobalDecoderPoolOption;
    private boolean m_bHWOverload;
    private boolean m_bNeedConfigure;
    private volatile boolean m_bReEnableOpt;
    private boolean m_bUseImageReader;
    private MediaCodec.BufferInfo m_bufferInfo;
    private ByteBuffer m_codecSpecificData;
    private MediaCodec m_decoder;
    private volatile boolean m_decoderStarted;
    private com.ss.android.ttve.common.b m_eglStateSaver;
    private ByteBuffer m_extraDataBuf;
    private MediaFormat m_format;
    private boolean m_frameAvailable;
    private final Object m_frameSyncObject;
    private HandlerThread m_handleThread;
    private int m_iCodecID;
    private int m_iCurCount;
    private int m_iFps;
    private int m_iHeight;
    private int m_iOutputHeight;
    private int m_iOutputWidth;
    private int m_iRotateDegree;
    private int m_iWidth;
    private int m_indexOfOutputBuffer;
    private volatile boolean m_inputBufferQueued;
    private long m_nativeHandler;
    private boolean m_needSendPacketAgain;
    private int m_pageMode;
    private volatile int m_pendingInputFrameCount;
    private a m_renderParam;
    private volatile boolean m_sawInputEOS;
    private volatile boolean m_sawOutputEOS;
    private TESharedContext m_sharedContext;
    private Surface m_surface;
    private int[] m_surfaceTexID;
    private SurfaceTexture m_surfaceTexture;
    private OESTextureRender m_textureRender;
    private volatile long m_timestampOfCurTexFrame;
    private volatile long m_timestampOfLastDecodedFrame;

    public static class OESTextureRender {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float[] f449865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FloatBuffer f449866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float[] f449867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f449868d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f449869e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f449870f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f449871g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f449872h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f449873i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f449874j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f449875k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int[] f449876l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f449877m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public TextureMinFilterType f449878n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f449879o;

        public static final enum TextureMinFilterType extends Enum<TextureMinFilterType> {
            public static final TextureMinFilterType LINEAR = null;
            public static final TextureMinFilterType NEAREST = null;
            public static final TextureMinFilterType UNKNOWN = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ TextureMinFilterType[] f449880a = null;

            static {
                TextureMinFilterType r100 = new TextureMinFilterType("UNKNOWN", 0);
                UNKNOWN = r100;
                TextureMinFilterType r101 = new TextureMinFilterType("NEAREST", 1);
                NEAREST = r101;
                TextureMinFilterType r102 = new TextureMinFilterType("LINEAR", 2);
                LINEAR = r102;
                f449880a = new TextureMinFilterType[]{r100, r101, r102};
            }

            public static TextureMinFilterType[] values() {
                return (TextureMinFilterType[]) f449880a.clone();
            }

            public static TextureMinFilterType valueOf(String r100) {
                return (TextureMinFilterType) r27.a.a(TextureMinFilterType.class, r100);
            }

            public TextureMinFilterType(String r100, int r101) {
                super(r100, r101);
            }
        }

        public OESTextureRender(SurfaceTexture r100) {
            float[] r101 = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
            this.f449865a = r101;
            this.f449867c = new float[16];
            float[] r102 = new float[16];
            this.f449868d = r102;
            this.f449876l = new int[1];
            this.f449877m = 0;
            this.f449878n = TextureMinFilterType.UNKNOWN;
            this.f449879o = 2;
            FloatBuffer r103 = ByteBuffer.allocateDirect(80).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f449866b = r103;
            r103.put(r101).position(0);
            if (r100 == null) goto L5;
            r100.getTransformMatrix(r102);
            return;
        L5:
            Matrix.setIdentityM(r102, 0);
        }

        public static int a(String r100) {
            int r101 = c(35633, "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n");
            if (r101 != 0) goto L5;
            return 0;
        L5:
            int r102 = c(35632, r100);
            if (r102 != 0) goto L8;
            return 0;
        L8:
            int r103 = GLES20.glCreateProgram();
            if (r103 != 0) goto L11;
            VELogUtil.e(TEMediaCodecDecoder.TAG, "Could not create program");
        L11:
            GLES20.glAttachShader(r103, r101);
            GLES20.glAttachShader(r103, r102);
            GLES20.glLinkProgram(r103);
            int[] r104 = new int[1];
            GLES20.glGetProgramiv(r103, 35714, r104, 0);
            if (r104[0] == 1) goto L15;
            VELogUtil.e(TEMediaCodecDecoder.TAG, "Could not link program: " + GLES20.glGetProgramInfoLog(r103));
            GLES20.glDeleteProgram(r103);
            return 0;
        L15:
            return r103;
        }

        public static int c(int r100, String r101) {
            int r102 = GLES20.glCreateShader(r100);
            GLES20.glShaderSource(r102, r101);
            GLES20.glCompileShader(r102);
            int[] r103 = new int[1];
            GLES20.glGetShaderiv(r102, 35713, r103, 0);
            if (r103[0] != 0) goto L6;
            VELogUtil.e(TEMediaCodecDecoder.TAG, "Could not compile shader " + r100 + ":");
            StringBuilder r104 = new StringBuilder(" ");
            r104.append(GLES20.glGetShaderInfoLog(r102));
            VELogUtil.e(TEMediaCodecDecoder.TAG, r104.toString());
            GLES20.glDeleteShader(r102);
            return 0;
        L6:
            return r102;
        }

        public final void d(int r310, boolean r311, int r312, int r313, int r314, int r410) {
            if (r312 <= 0) goto L39;
            if (r313 <= 0) goto L39;
            if (r314 <= 0) goto L39;
            if (r410 <= 0) goto L39;
            if (this.f449877m != r310) goto L16;
            if (r311 == true) goto L16;
            if (r312 != 0) goto L16;
            if (r313 != 0) goto L16;
            if (r314 != 0) goto L16;
            if (r410 != 0) goto L16;
            return;
        L16:
            this.f449877m = r310;
            float[] r110 = new float[16];
            Matrix.setIdentityM(r110, 0);
            Matrix.rotateM(r110, 0, r310, 0.0f, 0.0f, 1.0f);
            if (r311 == false) goto L20;
            Matrix.rotateM(r110, 0, 180.0f, 1.0f, 0.0f, 0.0f);
        L20:
            if (Math.abs(r310) != 90) goto L22;
        L25:
            float r100 = r313;
        L27:
            if (Math.abs(r310) != 90) goto L29;
        L32:
            float r101 = r312;
        L33:
            float r102 = r314;
            float r103 = r102 / r100;
            float r111 = r410;
            float r104 = r111 / r101;
            if (r103 > r104) goto L37;
            r103 = r104;
        L37:
            Matrix.scaleM(r110, 0, (r312 / 2.0f) * r103, (r313 / 2.0f) * r103, 1.0f);
            float[] r105 = new float[16];
            Matrix.setIdentityM(r105, 0);
            Matrix.setLookAtM(r105, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
            float[] r106 = new float[16];
            Matrix.setIdentityM(r106, 0);
            Matrix.orthoM(r106, 0, (-r314) / 2.0f, r102 / 2.0f, (-r410) / 2.0f, r111 / 2.0f, -2.0f, 2.0f);
            float[] r107 = new float[16];
            Matrix.setIdentityM(r107, 0);
            Matrix.multiplyMM(r107, 0, r105, 0, r110, 0);
            Matrix.setIdentityM(this.f449867c, 0);
            Matrix.multiplyMM(this.f449867c, 0, r106, 0, r107, 0);
            return;
        L29:
            if (Math.abs(r310) == 270) goto L32;
            r101 = r313;
            goto L33
        L22:
            if (Math.abs(r310) == 270) goto L25;
            r100 = r312;
        L39:
            Matrix.setIdentityM(this.f449867c, 0);
        }

        public final void e(int r100, int r101, int r102, int r103, int r104, int r105) {
            if (r100 <= 0) goto L11;
            if (r101 <= 0) goto L12;
            if (r103 < r102) goto L13;
            if (r105 < r104) goto L14;
            if (r105 > r100) goto L15;
            if (r103 > r101) goto L16;
            float[] r106 = this.f449865a;
            float r107 = r100;
            float r108 = (r104 * 1.0f) / r107;
            r106[3] = r108;
            float r109 = r101;
            float r110 = (r102 * 1.0f) / r109;
            r106[4] = r110;
            float r111 = (r105 * 1.0f) / r107;
            r106[8] = r111;
            r106[9] = r110;
            r106[13] = r108;
            float r112 = (r103 * 1.0f) / r109;
            r106[14] = r112;
            r106[18] = r111;
            r106[19] = r112;
            this.f449866b.clear();
            this.f449866b.put(this.f449865a).position(0);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        L13:
            return;
        L12:
            return;
        }

        public final void b(int r210, int r211, int r212, int r213, int r214, int r310, int r311) {
            GLES20.glViewport(0, 0, r212, r213);
            if (VEConfigCenter.getInstance().getValue("veabtest_mediacodec_fix_powervr", false).booleanValue() == false) goto L5;
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
            GLES20.glBindFramebuffer(36160, 0);
        L5:
            GLES20.glBindFramebuffer(36160, this.f449876l[0]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, r310, 0);
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16640);
            GLES20.glUseProgram(this.f449869e);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(36197, r214);
            if (Math.min(r210, r211) < (Math.min(r212, r213) * 2)) goto L8;
            boolean r100 = true;
        L10:
            if (VEConfigCenter.getInstance().getValue("ve_editor_gbu_size_opt", 0) != 2) goto L12;
        L22:
            int r101 = r210 * r211;
            int r102 = r212 * r213;
            if (r101 != r102) goto L29;
            TextureMinFilterType r110 = this.f449878n;
            if (r110 != TextureMinFilterType.UNKNOWN) goto L27;
        L28:
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            this.f449878n = TextureMinFilterType.NEAREST;
        L43:
            this.f449866b.position(0);
            GLES20.glVertexAttribPointer(this.f449872h, 3, 5126, false, 20, this.f449866b);
            GLES20.glEnableVertexAttribArray(this.f449872h);
            this.f449866b.position(3);
            GLES20.glVertexAttribPointer(this.f449873i, 2, 5126, false, 20, this.f449866b);
            GLES20.glEnableVertexAttribArray(this.f449873i);
            if (VEConfigCenter.getInstance().getValue("ve_enable_hw_decoder_support_rotate", false).booleanValue() == true) goto L46;
            int r111 = 1;
            float r112 = 1.0f;
            Matrix.setIdentityM(this.f449867c, 0);
        L50:
            GLES20.glUniformMatrix4fv(this.f449870f, r111, false, this.f449867c, 0);
            GLES20.glUniformMatrix4fv(this.f449871g, r111, false, this.f449868d, 0);
            if (VEConfigCenter.getInstance().getValue("ve_enable_opt_hwdecode_moire", false).booleanValue() == true) goto L53;
        L62:
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.f449872h);
            GLES20.glDisableVertexAttribArray(this.f449873i);
            GLES20.glBindTexture(36197, 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
            GLES20.glBindFramebuffer(36160, 0);
            GLES20.glFinish();
            return;
        L53:
            if (this.f449879o < 3) goto L62;
            float r103 = r210 * r112;
            float r104 = r212;
            float r105 = r103 / r104;
            float r106 = r211 * r112;
            float r107 = r213;
            float r108 = r106 / r107;
            if (VEConfigCenter.getInstance().getValue("ve_enable_hw_decoder_support_rotate", false).booleanValue() == true) goto L57;
        L61:
            GLES20.glUniform2f(this.f449875k, r105, r108);
            GLES20.glUniform2f(this.f449874j, r103, r106);
            goto L62
        L57:
            if (Math.abs(r311) != 90) goto L59;
        L60:
            r105 = r103 / r107;
            r108 = r106 / r104;
            goto L61
        L59:
            if (Math.abs(r311) != 270) goto L61;
        L46:
            if (VEConfigCenter.getInstance().getValue("ve_enable_hw_decoder_use_surfacetexture_matrix", false).booleanValue() == false) goto L48;
            r111 = 1;
            r112 = 1.0f;
            d(r311, true, r210, r211, r212, r213);
            goto L50
        L48:
            r111 = 1;
            r112 = 1.0f;
            d(r311, false, r210, r211, r212, r213);
            goto L50
        L27:
            if (r110 == TextureMinFilterType.LINEAR) goto L28;
        L29:
            if (r101 == r102) goto L43;
            TextureMinFilterType r109 = this.f449878n;
            if (r109 == TextureMinFilterType.UNKNOWN) goto L35;
            if (r109 != TextureMinFilterType.NEAREST) goto L43;
        L35:
            if (VEConfigCenter.getInstance().getValue("ve_enable_opt_hwdecode_moire", false).booleanValue() == true) goto L37;
        L42:
            GLES20.glTexParameterf(36197, 10241, 9729.0f);
            this.f449878n = TextureMinFilterType.LINEAR;
            goto L43
        L37:
            if (this.f449879o < 3) goto L42;
            if (r100 == false) goto L43;
            TextureMinFilterType r113 = this.f449878n;
            TextureMinFilterType r114 = TextureMinFilterType.NEAREST;
            if (r113 == r114) goto L43;
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            this.f449878n = r114;
            goto L43
        L12:
            if (2 == (VEConfigCenter.getInstance().getValue("ve_enable_odd_display", 0) & 2)) goto L22;
            if (VEConfigCenter.getInstance().getValue("ve_enable_opt_hwdecode_moire", false).booleanValue() == false) goto L43;
            if (this.f449879o < 3) goto L43;
            if (r100 == false) goto L43;
            TextureMinFilterType r115 = this.f449878n;
            TextureMinFilterType r116 = TextureMinFilterType.NEAREST;
            if (r115 == r116) goto L43;
            GLES20.glTexParameterf(36197, 10241, 9728.0f);
            this.f449878n = r116;
            goto L43
        L8:
            r100 = false;
            goto L10
        }
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RectF f449881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f449882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f449883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f449884d;

        public final String toString() {
            return "cropRect: " + this.f449881a + ", rotate: " + this.f449882b;
        }

        public a() {
            this.f449881a = null;
            this.f449882b = 0;
            this.f449883c = 0;
            this.f449884d = 0;
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static boolean codecNeedsFlushWorkaround(String r100) {
        return false;
    }

    private boolean isHarmonyOS() {
        Class r100 = INVOKESTATIC_com_ss_android_ttve_mediacodec_TEMediaCodecDecoder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.huawei.system.BuildEx");     // Catch: Exception -> L5
        return RomUtils.OS_HARMONY.equals(r100.getMethod("getOsBrand", new Class[0]).invoke(r100, new Object[0]));
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean isSupportByteVC10bit() {
        return isSupportFormat("video/hevc", 2, 16384);
    }

    private native boolean nativeOnFrameAvailable(long r100, ByteBuffer r101, int r102);

    private static void setHWDecodeBoolConfigFromNative(String r100, boolean r101) {
    }

    private static void setHWDecodeIntConfigFromNative(String r100, int r101) {
    }

    static {
        mCodecListLock = new Object();
        mVideoHWDecoderCodecs = new ArrayList();
        mIsByteVC1Blocklist = false;
        m_useCreateDecoderByName = true;
        sDequeueHWDecodeInputBufferOpt = true;
        sHWDecodeSupportRtAndOr = false;
    }

    private boolean IsValid() {
        if (this.m_decoder == null) goto L5;
        return true;
    L5:
        return false;
    }

    private int configureMediaFormat() {
        MediaCodecInfo r100 = getMediaCodecInfo21(this.VIDEO_MIME_TYPE);     // Catch: Exception -> L101
        if (r100 != null) goto L8;
        VELogUtil.e(TAG, "MediaCodecInfo is null!");     // Catch: Exception -> L101
        return -2;
    L8:
        if (this.m_iCodecID != 28) goto L15;
        VELogUtil.i(TAG, "mediacodec supports adaptive playback: " + r100.getCapabilitiesForType(this.VIDEO_MIME_TYPE).isFeatureSupported("adaptive-playback"));     // Catch: Exception -> L101
        if (this.mIs10bit == false) goto L15;
        if (isSupportFormat(this.VIDEO_MIME_TYPE, 16, 0) == true) goto L15;
        VELogUtil.e(TAG, "avc 10bit is not suppport!");     // Catch: Exception -> L101
        return -5;
    L15:
        VELogUtil.d(TAG, "configureMediaFormat , size: " + this.m_iWidth + " x " + this.m_iHeight);     // Catch: Exception -> L101
        int r101 = this.m_iCodecID;     // Catch: Exception -> L101
        if (r101 == 28) goto L22;
        if (r101 == 174) goto L22;
        if (r100.getCapabilitiesForType(this.VIDEO_MIME_TYPE).getVideoCapabilities().isSizeSupported(this.m_iWidth, this.m_iHeight) == true) goto L22;
        VELogUtil.e(TAG, "is not size support! width: " + this.m_iWidth + " height: " + this.m_iHeight);     // Catch: Exception -> L101
        return -3;
    L22:
        this.m_format = MediaFormat.createVideoFormat(this.VIDEO_MIME_TYPE, this.m_iWidth, this.m_iHeight);     // Catch: Exception -> L101
        VELogUtil.i(TAG, "isSupport10bit = " + isSupportByteVC10bit());     // Catch: Exception -> L101
        ByteBuffer r102 = this.m_codecSpecificData;     // Catch: Exception -> L101
        if (r102 == null) goto L26;
        this.m_format.setByteBuffer("csd-0", r102);     // Catch: Exception -> L101
    L26:
        if (this.m_bUseImageReader == false) goto L28;
        this.m_format.setInteger("color-format", 2135033992);     // Catch: Exception -> L101
    L28:
        int r103 = this.m_iCodecID;     // Catch: Exception -> L101
        if (174 != r103) goto L32;
        this.m_format.setInteger("max-input-size", this.m_iWidth * this.m_iHeight);     // Catch: Exception -> L101
    L34:
        boolean r104 = VEConfigCenter.getInstance().getValue("ve_hwdecode_support_rt_and_or", false).booleanValue();     // Catch: Exception -> L101
        sHWDecodeSupportRtAndOr = r104;     // Catch: Exception -> L101
        if (r104 == true) goto L38;
    L45:
        String r105 = VEConfigCenter.getInstance().getValue("ve_decode_support_operating_rate", "");     // Catch: Exception -> L101
        if (r105 == null) goto L94;
        if (r105.isEmpty() == true) goto L94;
        JSONObject r110 = new JSONObject(r105);     // Catch: JSONException -> L91 Exception -> L101
        int r106 = r110.optInt("synthesis");     // Catch: JSONException -> L91 Exception -> L101
        int r111 = r110.optInt(GXMode.MODE_TYPE_CROP);     // Catch: JSONException -> L91 Exception -> L101
        int r112 = r110.optInt("editSave");     // Catch: JSONException -> L91 Exception -> L101
        int r113 = r110.optInt("previewEditor");     // Catch: JSONException -> L91 Exception -> L101
        int r114 = r110.optInt("previewPublish");     // Catch: JSONException -> L91 Exception -> L101
        int r107 = r110.optInt("compileOther");     // Catch: JSONException -> L91 Exception -> L101
        VELogUtil.i(TAG, "decode operatingRateStr synthesisOpt:" + r106 + ", cropOpt:" + r111 + ", editSaveOpt:" + r112 + ", previewEditorOpt:" + r113 + ", previewPublishOpt:" + r114 + ", compileOtherOpt:" + r107);     // Catch: JSONException -> L91 Exception -> L101
        int r108 = this.m_pageMode;     // Catch: JSONException -> L91 Exception -> L101
        if (r108 != 0) goto L54;
        if (r106 <= 0) goto L54;
    L105:
        int r109 = ((Double) r100.getCapabilitiesForType(this.VIDEO_MIME_TYPE).getVideoCapabilities().getSupportedFrameRatesFor(this.m_iWidth, this.m_iHeight).getUpper()).intValue();     // Catch: IllegalArgumentException -> L80 JSONException -> L91 Exception -> L101
    L82:
        if (r109 >= 60) goto L84;
        int r115 = 0;
    L85:
        int r116 = Math.min(r115, r106);     // Catch: JSONException -> L91 Exception -> L101
        VELogUtil.i(TAG, String.format(Locale.getDefault(), "decode operating libra val = %d, final val = %d, max_fps = %d pageMode val = %d", new Object[]{Integer.valueOf(r106), Integer.valueOf(r116), Integer.valueOf(r109), Integer.valueOf(this.m_pageMode)}));     // Catch: JSONException -> L91 Exception -> L101
        if (r116 == 0) goto L94;
        if (Math.max(this.m_iWidth, this.m_iHeight) > 1920) goto L94;
        this.m_format.setInteger("operating-rate", r116);     // Catch: JSONException -> L91 Exception -> L101
    L84:
        r115 = r109;
    L80:
        VELogUtil.w(TAG, "getSupportedFrameRate unsupported size");     // Catch: JSONException -> L91 Exception -> L101
        r109 = 0;
    L54:
        if (r108 != 10) goto L57;
        if (r112 <= 0) goto L57;
        r106 = r112;
    L57:
        if (r108 != 1) goto L61;
        if (r111 <= 0) goto L61;
        r106 = r111;
    L61:
        if (r108 != 100) goto L65;
        if (r113 <= 0) goto L65;
        r106 = r113;
    L65:
        if (r108 != 101) goto L67;
    L68:
        if (r114 <= 0) goto L71;
        r106 = r114;
    L71:
        if (r108 != 11) goto L73;
    L74:
        if (r107 <= 0) goto L76;
        r106 = r107;
    L76:
        r106 = 0;
        goto L105
    L73:
        if (r108 != 12) goto L76;
    L67:
        if (r108 != 102) goto L71;
    L91:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L101
    L94:
        if (174 == this.m_iCodecID) goto L96;
    L100:
        return 0;
    L96:
        if (isSupportSize(r100) == true) goto L100;
        VELogUtil.e(TAG, "configureMediaFormat, failed, case VIDEO_MIME_TYPE = " + this.VIDEO_MIME_TYPE + ", size = " + this.m_iWidth + " x " + this.m_iHeight + " is not supported.");     // Catch: Exception -> L101
        return -5;
    L38:
        if (VEConfigCenter.getInstance().getValue("ve_mediacodec_resource_reasonable_distribute", false).booleanValue() == true) goto L40;
    L44:
        this.m_format.setInteger("priority", 0);     // Catch: Exception -> L101
        VELogUtil.i(TAG, "set real-time and operating-rate");     // Catch: Exception -> L101
        goto L45
    L40:
        if (TEMediaCodecResourceManager.sExistHWEncoder == true) goto L44;
        if (Math.max(this.m_iWidth, this.m_iHeight) > 1920) goto L44;
        this.m_format.setFloat("operating-rate", 120.0f);     // Catch: Exception -> L101
        goto L44
    L32:
        if (28 != r103) goto L34;
        this.m_format.setInteger("max-input-size", (((((this.m_iWidth + 16) - 1) / 16) * (((this.m_iHeight + 16) - 1) / 16)) * 16) * 16);     // Catch: Exception -> L101
    L101:
        e = move-exception;
        VELogUtil.e(TAG, "reconfigureMediaFormat: " + e.getMessage());
        e.printStackTrace();
        return -4;
    }

    private int createTexture() {
        GLES20.glGenTextures(1, this.m_surfaceTexID, 0);
        int r100 = this.m_surfaceTexID[0];
        if (r100 > 0) goto L6;
        VELogUtil.e(TAG, "createTexture failed");
        return 0;
    L6:
        GLES20.glBindTexture(36197, r100);
        GLES20.glTexParameterf(36197, 10241, 9728.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        return this.m_surfaceTexID[0];
    }

    private void deleteTexture() {
        int[] r100 = this.m_surfaceTexID;
        if (r100[0] == 0) goto L6;
        GLES20.glDeleteTextures(1, r100, 0);
        this.m_surfaceTexID[0] = 0;
        return;
    }

    public static int getMaxBlocksSizePerSecond() {
        if (VEPlatformUtils.a() != VEPlatformUtils.VEPlatform.PLATFORM_HISI) goto L5;
        return -1;
    L5:
        int r100 = Build.VERSION.SDK_INT;
        MediaCodecInfo r101 = getMediaCodecInfo21(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE);
        if (r101 == null) goto L32;
        MediaCodecInfo.CodecCapabilities r102 = r101.getCapabilitiesForType(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE);
        Class<?> r103 = r102.getVideoCapabilities().getClass();     // Catch: Exception -> L30
        Class<?>[] r104 = new Class[0];     // Catch: Exception -> L30
        if (r100 < 28) goto L13;
        Method r105 = ffc.a.f476784a;     // Catch: Exception -> L30
        if (r105 == null) goto L14;
        Method r106 = (Method) r105.invoke(r103, new Object[]{"getBlocksPerSecondRange", r104});     // Catch: Exception -> L30
    L15:
        if (r106 != null) goto L17;
        r106 = r103.getDeclaredMethod("getBlocksPerSecondRange", r104);     // Catch: Exception -> L30
    L17:
        r106.setAccessible(true);     // Catch: Exception -> L30
        Range r107 = (Range) r106.invoke(r102.getVideoCapabilities(), new Object[0]);     // Catch: Exception -> L30
        JSONObject r108 = new JSONObject();     // Catch: JSONException -> L25 Exception -> L30
        r108.put("maxBlocksSizePerSecond", ((Long) r107.getUpper()).longValue() * ((long) 256));     // Catch: JSONException -> L25 Exception -> L30
        Class r109 = INVOKESTATIC_com_ss_android_ttve_mediacodec_TEMediaCodecDecoder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.ttve.monitor.ApplogUtils");     // Catch: Exception -> L22
        r109.getDeclaredMethod("onEvent", new Class[]{String.class, JSONObject.class, String.class}).invoke(null, new Object[]{String.valueOf(r109.getField("VESDK_EVENT_COMMON_HW_RESOURCE_LIMIT_SIZE")), r108, String.valueOf(r109.getField("EVENT_TYPE_PERFORMANCE"))});     // Catch: Exception -> L22
    L27:
        return (int) (((Long) r107.getUpper()).longValue() * ((long) 256));
    L22:
        e = move-exception;
        VELogUtil.e(TAG, "call ApplogUtils.onEvent method err " + e.getMessage());     // Catch: JSONException -> L25 Exception -> L30
        e.printStackTrace();     // Catch: JSONException -> L25 Exception -> L30
    L25:
        e = move-exception;
        VELogUtil.e(TAG, "report maxBlocksSizePerSecond json err " + e.getMessage());     // Catch: Exception -> L30
    L14:
        r106 = null;
        goto L15
    L13:
        Method r110 = ffc.a.f476784a;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        VELogUtil.e(TAG, e.getMessage());
    L32:
        return -1;
    }

    private boolean isMtkByteVC1BlockList() {
        String r100 = Build.HARDWARE.toLowerCase(Locale.US);
        if (r100.startsWith("mt6763") == false) goto L5;
    L12:
        return true;
    L5:
        if (r100.startsWith("mt6757") == true) goto L12;
        if (r100.startsWith("mt6739") == true) goto L12;
        if (r100.startsWith("mt6750") == true) goto L12;
        return false;
    }

    private void onImageFrameAvailable() {
        if (this.mImage.getFormat() != 35) goto L31;
        int r100 = this.mImage.getWidth();
        int r101 = this.mImage.getHeight();
        if (this.mImage.getPlanes() != null) goto L7;
    L12:
        VEFrame r102 = VEFrame.createYUVPlanFrame(new e(this.mImage.getPlanes()), r100, r101, 0, 0, VEFrame.ETEPixelFormat.TEPixFmt_YUV420P);
    L14:
        if (r100 != this.m_iOutputWidth) goto L22;
        if (r101 != this.m_iOutputHeight) goto L22;
        if ((r102.getFrame() instanceof VEFrame.ByteBufferFrame) == false) goto L22;
        ByteBuffer r103 = ((VEFrame.ByteBufferFrame) r102.getFrame()).getByteBuffer();
        nativeOnFrameAvailable(this.m_nativeHandler, r103, r103.remaining());
        return;
    L22:
        if (this.mScaleFrame != null) goto L25;
        ByteBuffer r104 = ByteBuffer.allocateDirect(((this.m_iOutputWidth * this.m_iOutputHeight) * 3) / 2);
        r104.clear();
        this.mScaleFrame = VEFrame.createByteBufferFrame(r104, this.m_iOutputWidth, this.m_iOutputHeight, 0, 0, VEFrame.ETEPixelFormat.TEPixFmt_YUV420P);
    L25:
        if (this.m_iWidth == this.m_iOutputWidth) goto L27;
    L29:
        TEImageUtils.a(r102, this.mScaleFrame, VEFrame.Operation.OP_SCALE);
    L30:
        ByteBuffer r105 = ((VEFrame.ByteBufferFrame) this.mScaleFrame.getFrame()).getByteBuffer();
        nativeOnFrameAvailable(this.m_nativeHandler, r105, r105.remaining());
        return;
    L27:
        if (this.m_iHeight != this.m_iOutputHeight) goto L29;
        TEImageUtils.a(r102, this.mScaleFrame, VEFrame.Operation.OP_COPY);
        goto L30
    L7:
        if (this.mImage.getPlanes()[1].getPixelStride() <= 1) goto L12;
        VEFrame r106 = VEFrame.createYUVPlanFrame(new e(this.mImage.getPlanes()), r100, r101, 0, 0, VEFrame.ETEPixelFormat.TEPixFmt_NV12);
        if (this.mConvertFrame != null) goto L11;
        ByteBuffer r107 = ByteBuffer.allocateDirect(((r100 * r101) * 3) / 2);
        r107.clear();
        this.mConvertFrame = VEFrame.createByteBufferFrame(r107, r100, r101, 0, 0, VEFrame.ETEPixelFormat.TEPixFmt_YUV420P);
    L11:
        TEImageUtils.a(r106, this.mConvertFrame, VEFrame.Operation.OP_CONVERT);
        r102 = this.mConvertFrame;
        goto L14
    L31:
        VELogUtil.e(TAG, "image format: " + this.mImage.getFormat());
    }

    private int startDecoder() {
        if (IsValid() == false) goto L7;
        VELogUtil.e(TAG, "You can't call startDecoder() twice!");
        return -1;
    L7:
        if (this.m_bUseImageReader == true) goto L13;
        int r100 = this.m_surfaceTexID[0];
        if (r100 != 0) goto L11;
        r100 = createTexture();
    L11:
        if (r100 != 0) goto L76;
        return -1;
    L76:
    L73:
        e = move-exception;
        VELogUtil.e(TAG, "" + e.getMessage());
        e.printStackTrace();
        stopDecoder();
        return -1;
    L15:
        if (this.m_bUseImageReader == true) goto L17;
        this.m_surfaceTexture = new SurfaceTexture(r100);     // Catch: Exception -> L73
        VELogUtil.i(TAG, "Surface texture with texture (id=" + r100 + ") has been created.");     // Catch: Exception -> L73
    L17:
        ThreadMethodProxy.start(this.m_handleThread);     // Catch: Exception -> L73
        Handler r101 = new Handler(this.m_handleThread.getLooper());     // Catch: Exception -> L73
        this.m_MediaCodechandler = r101;     // Catch: Exception -> L73
        if (this.m_bUseImageReader == true) goto L20;
        this.m_surfaceTexture.setOnFrameAvailableListener(this, r101);     // Catch: Exception -> L73
        this.m_surface = new Surface(this.m_surfaceTexture);     // Catch: Exception -> L73
    L22:
        if (this.m_bUseImageReader == true) goto L62;
        OESTextureRender r102 = new OESTextureRender(this.m_surfaceTexture);
        this.m_textureRender = r102;
        com.ss.android.ttve.common.b r103 = this.m_eglStateSaver;
        if (r103 == null) goto L27;
        r102.f449879o = r103.f449840e;
    L27:
        if (VEConfigCenter.getInstance().getValue("ve_enable_opt_hwdecode_moire", false).booleanValue() == true) goto L29;
    L31:
        r102.f449869e = OESTextureRender.a("#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
    L33:
        if (r102.f449869e != 0) goto L35;
        VELogUtil.e(TAG, "failed create program");
    L35:
        int r104 = GLES20.glGetAttribLocation(r102.f449869e, "aPosition");
        r102.f449872h = r104;
        if (r104 != (-1)) goto L38;
        VELogUtil.e(TAG, "Could not get attrib location for aPosition");
    L38:
        int r105 = GLES20.glGetAttribLocation(r102.f449869e, "aTextureCoord");
        r102.f449873i = r105;
        if (r105 != (-1)) goto L41;
        VELogUtil.e(TAG, "Could not get attrib location for aTextureCoord");
    L41:
        int r106 = GLES20.glGetUniformLocation(r102.f449869e, "uMVPMatrix");
        r102.f449870f = r106;
        if (r106 != (-1)) goto L44;
        VELogUtil.e(TAG, "Could not get attrib location for uMVPMatrix");
    L44:
        r102.f449871g = GLES20.glGetUniformLocation(r102.f449869e, "uSTMatrix");
        VELogUtil.d(TAG, "glGetUniformLocation uSTMatrix");
        if (r102.f449871g != (-1)) goto L48;
        VELogUtil.w(TAG, "Could not get attrib location for uSTMatrix");
    L48:
        if (VEConfigCenter.getInstance().getValue("ve_enable_opt_hwdecode_moire", false).booleanValue() == true) goto L50;
    L60:
        GLES20.glGenFramebuffers(1, r102.f449876l, 0);
        VELogUtil.d(TAG, "glGenFramebuffers");
        goto L62
    L50:
        if (r102.f449879o < 3) goto L60;
        int r107 = GLES20.glGetUniformLocation(r102.f449869e, "uTexelScale");
        r102.f449875k = r107;
        if (r107 != (-1)) goto L54;
        VELogUtil.e(TAG, "Could not get uniform location for uTexelScale");
    L54:
        r102.f449874j = GLES20.glGetUniformLocation(r102.f449869e, "uTexelSrc");
        if (r102.f449875k != (-1)) goto L57;
        VELogUtil.e(TAG, "Could not get uniform location for uTexelSrc");
    L57:
        r102.f449874j = GLES20.glGetUniformLocation(r102.f449869e, "uTexelSrc");
        if (r102.f449875k != (-1)) goto L60;
        VELogUtil.e(TAG, "Could not get uniform location for uTexelSrc");
        goto L60
    L29:
        if (r102.f449879o < 3) goto L31;
        r102.f449869e = OESTextureRender.a("#extension GL_OES_EGL_image_external : require\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform vec2 uTexelScale;\nuniform vec2 uTexelSrc;\nuniform samplerExternalOES sTexture;\nvec4 texture2DArea(vec2 coord)\n    {\n        vec4 color = vec4(0.0);\n        vec2 p = max(coord * uTexelSrc - 0.5, 0.0);\n        vec2 q = min(p + uTexelScale, uTexelSrc);\n        vec2 r = 1.0 / uTexelSrc;\n        vec2 r2 = r * 0.5;\n        vec2 s = ceil(p);\n        vec2 t = floor(q);\n        vec2 c0 = s - p;\n        vec2 c1 = q - t;\n        float e = 1.5e-2;\n        if (c0.y > e)\n        {\n            vec4 c = vec4(0.0);\n            if (c0.x > e)\n                c += texture2D(sTexture, (s - 1.0) * r + r2) * c0.x;\n            for (float x = s.x; x < t.x; x += 1.0)\n                c += texture2D(sTexture, vec2(x, s.y - 1.0) * r + r2);\n            if (c1.x > e)\n                c += texture2D(sTexture, vec2(t.x, s.y - 1.0) * r + r2) * c1.x;\n            color += c * c0.y;\n        }\n        for (float y = s.y; y < t.y; y += 1.0)\n        {\n            if (c0.x > e)\n                color += texture2D(sTexture, vec2(s.x - 1.0, y) * r + r2) * c0.x;\n            for (float x = s.x; x < t.x; x += 1.0)\n                color += texture2D(sTexture, vec2(x, y) * r + r2);\n            if (c1.x > e)\n                color += texture2D(sTexture, vec2(t.x, y) * r + r2) * c1.x;\n        }\n        if (c1.y > e)\n        {\n            vec4 c = vec4(0.0);\n            if (c0.x > e)\n                c += texture2D(sTexture, vec2(s.x - 1.0, t.y) * r + r2) * c0.x;\n            for (float x = s.x; x < t.x; x += 1.0)\n                c += texture2D(sTexture, vec2(x, t.y) * r + r2);\n            if (c1.x > e)\n                c += texture2D(sTexture, t * r + r2) * c1.x;\n            color += c * c1.y;\n        }\n        return clamp(color / (uTexelScale.x * uTexelScale.y), 0.0, 1.0);\n    }\nvoid main() {\n  if (uTexelScale.x >= 2.0)\n  {\n     gl_FragColor = texture2DArea(vTextureCoord);\n  } else {\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n  }\n}\n");
    L62:
        if (setupDecoder(this.VIDEO_MIME_TYPE) == true) goto L72;
        stopDecoder();
        if (this.m_bHWOverload == false) goto L71;
        this.m_bHWOverload = false;
        if (VEConfigCenter.getInstance().getValue("ve_enable_video_reader_hw_overload_fallback_opt", false).booleanValue() == false) goto L68;
        return -104;
    L68:
        if (VEConfigCenter.getInstance().getValue("veabtest_aboffline_jy_android", false).booleanValue() == false) goto L71;
        return -104;
    L71:
        return -1;
    L72:
        return 0;
    L20:
        this.mReaderHandlerThread = new PthreadHandlerThreadV2("VE-ImageReaderHandler");     // Catch: Exception -> L73
        VELogUtil.i(TAG, "getVideoFramesHW: mReaderHandlerThread = " + this.mReaderHandlerThread.getThreadId());     // Catch: Exception -> L73
        ThreadMethodProxy.start(this.mReaderHandlerThread);     // Catch: Exception -> L73
        Handler r108 = new Handler(this.mReaderHandlerThread.getLooper());     // Catch: Exception -> L73
        ImageReader r109 = ImageReader.newInstance(this.m_iWidth, this.m_iHeight, 35, 2);     // Catch: Exception -> L73
        this.mImageReader = r109;     // Catch: Exception -> L73
        r109.setOnImageAvailableListener(this, r108);     // Catch: Exception -> L73
        goto L22
    L13:
        r100 = 0;
        goto L76
    }

    public void cleanupDecoder() {
        VELogUtil.i(TAG, "cleanupDecoder, this: " + this);
        if (this.m_decoder == null) goto L16;
        if (this.m_decoderStarted == true) goto L20;
    L14:
        this.m_decoder.release();
        this.m_decoder = null;
        this.m_iRotateDegree = 0;
        goto L16
    L20:
    L11:
        e = move-exception;
        VELogUtil.e(TAG, "" + e.getMessage());
        e.printStackTrace();
    L13:
        this.m_decoderStarted = false;
        goto L14
    L7:
        if (this.m_inputBufferQueued == false) goto L9;
        this.m_decoder.flush();     // Catch: Exception -> L11
        this.m_inputBufferQueued = false;     // Catch: Exception -> L11
    L9:
        this.m_decoder.stop();     // Catch: Exception -> L11
    L16:
        if (VEConfigCenter.getInstance().getValue("ve_mediacodec_resource_reasonable_distribute", false).booleanValue() == false) goto L18;
        TEMediaCodecResourceManager.freeCodecBlocksSize((this.m_iWidth * this.m_iHeight) * this.m_iFps, hashCode());
    L18:
        this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = Long.MIN_VALUE;
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
    }

    public int closeDecoder() {
        VELogUtil.w(TAG, "closeHwDecoder");
        stopDecoder();
        deleteTexture();
        return 0;
    }

    public int getOESTexture() {
        return this.m_surfaceTexID[0];
    }

    public void signalReEncodeOptCV() {
        if (this.m_bReEnableOpt == true) goto L5;
        return;
    L5:
        this.m_ReEncodeOptCV.open();
        VELogUtil.d(TAG, "signalReEncodeOptCV...");
    }

    public TEMediaCodecDecoder() {
        this.VIDEO_MIME_TYPE = KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE;
        this.m_bUseImageReader = false;
        this.mIs10bit = false;
        this.m_iRotateDegree = 0;
        this.m_iCodecID = 28;
        this.m_iWidth = 0;
        this.m_iHeight = 0;
        this.m_iFps = 0;
        this.m_iOutputWidth = 0;
        this.m_iOutputHeight = 0;
        this.m_extraDataBuf = null;
        this.m_codecSpecificData = null;
        this.m_bNeedConfigure = false;
        this.m_bGlobalDecoderPoolOption = 0;
        this.m_format = null;
        this.m_surfaceTexID = new int[1];
        this.m_surfaceTexture = null;
        this.m_surface = null;
        this.m_pageMode = -1;
        this.m_bufferInfo = new MediaCodec.BufferInfo();
        this.m_decoder = null;
        this.m_decoderStarted = false;
        this.m_frameSyncObject = new Object();
        this.m_frameAvailable = false;
        this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;
        this.m_timestampOfCurTexFrame = Long.MIN_VALUE;
        this.m_inputBufferQueued = false;
        this.m_pendingInputFrameCount = 0;
        this.m_sawInputEOS = false;
        this.m_sawOutputEOS = false;
        this.m_textureRender = null;
        this.m_sharedContext = null;
        this.m_eglStateSaver = null;
        this.m_handleThread = new PthreadHandlerThreadV2("VE-MediaCodecHandler");
        this.mReaderHandlerThread = null;
        this.mImageReader = null;
        this.mImage = null;
        this.mConvertFrame = null;
        this.mScaleFrame = null;
        this.MAX_SLEEP_MS = 0;
        this.MAX_DELAY_COUNT = 10;
        this.m_iCurCount = 0;
        this.m_needSendPacketAgain = false;
        this.m_awaitNewImageSuccess = false;
        this.m_indexOfOutputBuffer = -1;
        this.m_bReEnableOpt = false;
        this.m_ReEncodeOptCV = new ConditionVariable(true);
        this.m_renderParam = new a();
        this.mMinCompressionRatio = 1;
        this.m_bHWOverload = false;
        this.Max_Playback_Speed = 4.0f;
        this.Normal_Video_Fps = 30.0f;
    }

    public static int getMaxMediaCodecVideoDecoderCount() {
        MediaCodecInfo r100 = getMediaCodecInfo21(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE);
        if (r100 != null) goto L6;
        VELogUtil.e(TAG, "MediaCodecInfo is null!");
        return -2;
    L6:
        int r101 = r100.getCapabilitiesForType(KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE).getMaxSupportedInstances();
        VELogUtil.i(TAG, "getMaxMediaCodecVideoDecoderCount " + r101);
        return r101;
    }

    private boolean isHisiByteVC1BlockList() {
        String r100 = getProperty("ro.board.platform", null);
        if (Build.VERSION.SDK_INT != 26) goto L19;
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.startsWith("kirin960") == true) goto L17;
        if (r100.startsWith("hi3660") == true) goto L17;
        return false;
    L17:
        double r101 = CastDoubleProtector.parseDouble(getProperty(VERSION_PROPERTY, GLUtils.VERSION_UNKNOWN));     // Catch: NumberFormatException -> L12
    L14:
        if (r101 >= FIX_VERSION) goto L22;
        return true;
    L22:
        return false;
    L12:
        r101 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L14
    L19:
        return false;
    }

    private int restartDecoder() {
        stopDecoder();
        return startDecoder();
    }

    private int stopDecoder() {
        cleanupDecoder();
        this.m_handleThread.quit();
        HandlerThread r100 = this.mReaderHandlerThread;
        if (r100 == null) goto L5;
        r100.quit();
        this.mReaderHandlerThread = null;
    L5:
        OESTextureRender r101 = this.m_textureRender;
        if (r101 == null) goto L20;
        monitor-enter(r101);
        int r102 = r101.f449869e;     // Catch: Throwable -> L16
        if (r102 == 0) goto L11;
        GLES20.glDeleteProgram(r102);     // Catch: Throwable -> L16
        r101.f449869e = 0;     // Catch: Throwable -> L16
    L11:
        int[] r103 = r101.f449876l;     // Catch: Throwable -> L16
        if (r103[0] == 0) goto L14;
        GLES20.glDeleteFramebuffers(1, r103, 0);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r101);
        this.m_textureRender = null;
    L16:
        th = move-exception;
        throw th;
    L20:
        if (VEConfigCenter.getInstance().getValue("veabtest_mediacodec_fix_powervr", false).booleanValue() == false) goto L22;
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
        GLES20.glBindFramebuffer(36160, 0);
    L22:
        Surface r104 = this.m_surface;
        if (r104 == null) goto L25;
        r104.release();
        this.m_surface = null;
    L25:
        SurfaceTexture r105 = this.m_surfaceTexture;
        if (r105 == null) goto L28;
        r105.setOnFrameAvailableListener(null);
        this.m_surfaceTexture.release();
        this.m_surfaceTexture = null;
    L28:
        VELogUtil.i(TAG, "stopDecoder, this: " + this);
        return 0;
    }

    private boolean isNeedSendPacketAgain() {
        return this.m_needSendPacketAgain;
    }

    public a getRenderParam() {
        return this.m_renderParam;
    }

    private boolean AwaitNewImage(int r100) {
        Object r101 = this.m_frameSyncObject;
        monitor-enter(r101);
    L24:
    L19:
        th = move-exception;
        throw th;
    L6:
        if (this.m_frameAvailable == true) goto L15;
        this.m_frameSyncObject.wait(r100);     // Catch: InterruptedException -> L11 Throwable -> L19
        if (this.m_frameAvailable == true) goto L24;
        monitor-exit(r101);     // Catch: Throwable -> L19
        return false;
    L11:
        e = move-exception;
        e.getMessage();     // Catch: Throwable -> L19
        e.printStackTrace();     // Catch: Throwable -> L19
        return false;
    L15:
        this.m_frameAvailable = false;     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        return true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_ttve_mediacodec_TEMediaCodecDecoder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private ByteBuffer getInputBufferByIdx(int r100) {
        return this.m_decoder.getInputBuffer(r100);
    }

    private static MediaCodecInfo getMediaCodecInfo(String r100) {
        int r101 = MediaCodecList.getCodecCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L22;
        MediaCodecInfo r103 = MediaCodecList.getCodecInfoAt(r102);
        if (r103.isEncoder() == true) goto L21;
        String r104 = r103.getName();
        if (r104.startsWith("OMX.google.") == true) goto L21;
        if (r104.startsWith("OMX.Nvidia.") == true) goto L21;
        if (r104.equals("OMX.TI.DUCATI1.VIDEO.H264E") == true) goto L21;
        String[] r105 = r103.getSupportedTypes();
        int r106 = 0;
    L16:
        if (r106 >= r105.length) goto L21;
        if (r105[r106].equalsIgnoreCase(r100) == true) goto L19;
        r106 = r106 + 1;
        goto L16
    L19:
        return r103;
    L21:
        r102 = r102 + 1;
        goto L3
    L22:
        return null;
    }

    private static MediaCodecInfo getMediaCodecInfo21(String r100) {
        MediaCodecInfo[] r101 = new MediaCodecList(1).getCodecInfos();     // Catch: Throwable -> L31
        if (r101 == null) goto L30;
        if (r101.length == 0) goto L30;
        int r102 = r101.length;     // Catch: Throwable -> L31
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L30;
        MediaCodecInfo r104 = r101[r103];     // Catch: Throwable -> L31
        if (r104 == null) goto L29;
        if (r104.isEncoder() == true) goto L29;
        String r105 = r104.getName();     // Catch: Throwable -> L31
        if (r105.startsWith("OMX.google.") == true) goto L29;
        if (r105.startsWith("OMX.Nvidia.") == true) goto L29;
        if (r105.equals("OMX.TI.DUCATI1.VIDEO.H264E") == true) goto L29;
        String[] r106 = r104.getSupportedTypes();     // Catch: Throwable -> L31
        int r107 = 0;
    L24:
        if (r107 >= r106.length) goto L29;
        if (r106[r107].equalsIgnoreCase(r100) == true) goto L27;
        r107 = r107 + 1;
        goto L24
    L27:
        return r104;
    L29:
        r103 = r103 + 1;
    L30:
        return null;
    }

    private boolean isSupportSize(MediaCodecInfo r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
        return false;
    L5:
        Range<Integer> r102 = r100.getCapabilitiesForType(this.VIDEO_MIME_TYPE).getVideoCapabilities().getSupportedWidths();
        Range<Integer> r103 = r100.getCapabilitiesForType(this.VIDEO_MIME_TYPE).getVideoCapabilities().getSupportedHeights();
        if (((Integer) r102.getUpper()).intValue() >= ((Integer) r103.getUpper()).intValue()) goto L8;
        Range<Integer> r104 = r102;
    L10:
        if (((Integer) r102.getUpper()).intValue() <= ((Integer) r103.getUpper()).intValue()) goto L12;
        Range<Integer> r105 = r102;
    L13:
        int r106 = this.m_iWidth;
        int r107 = this.m_iHeight;
        if (r106 >= r107) goto L16;
        int r108 = r106;
    L17:
        if (r106 > r107) goto L21;
        r106 = r107;
    L21:
        if (r104.contains(Integer.valueOf(r108)) == true) goto L23;
    L25:
        Objects.toString(r102.getLower());
        Objects.toString(r102.getUpper());
        Objects.toString(r103.getLower());
        Objects.toString(r103.getUpper());
        return r101;
    L23:
        if (r105.contains(Integer.valueOf(r106)) == false) goto L25;
        r101 = true;
        goto L25
    L16:
        r108 = r107;
        goto L17
    L12:
        r105 = r103;
        goto L13
    L8:
        r104 = r103;
        goto L10
    }

    private void setProcessFlag(int r100) {
        boolean r101 = true;
        if ((r100 & 1) != 0) goto L6;
        r101 = false;
    L6:
        this.m_bReEnableOpt = r101;
    }

    private void setRenderParam(int r100) {
        this.m_renderParam.f449882b = r100;
    }

    private boolean setupDecoder(String r110) {
        boolean r100 = true;
        if (VEConfigCenter.getInstance().getValue("ve_mediacodec_resource_reasonable_distribute", false).booleanValue() == true) goto L5;
    L29:
    L20:
        e = move-exception;
        VELogUtil.e(TAG, "" + e.getMessage());
        if (e.getMessage() != null) goto L24;
    L26:
        r100 = false;
    L27:
        this.m_bHWOverload = r100;
        e.printStackTrace();
        cleanupDecoder();
        return false;
    L24:
        if (e.getMessage().contains("0xffffec77") == false) goto L26;
    L11:
        if (m_useCreateDecoderByName == true) goto L13;
        this.m_decoder = MediaCodec.createDecoderByType(r110);     // Catch: Exception -> L20
    L14:
        VELogUtil.i(TAG, "setupDecoder, m_useCreateDecoderByName = " + m_useCreateDecoderByName);     // Catch: Exception -> L20
        Surface r111 = this.m_surface;     // Catch: Exception -> L20
        if (r111 == null) goto L17;
        this.m_decoder.configure(this.m_format, r111, null, 0);     // Catch: Exception -> L20
    L18:
        this.m_decoder.start();     // Catch: Exception -> L20
        this.m_decoderStarted = true;     // Catch: Exception -> L20
        return true;
    L17:
        this.m_decoder.configure(this.m_format, this.mImageReader.getSurface(), null, 0);     // Catch: Exception -> L20
        goto L18
    L13:
        String r112 = getBestCodecName(r110);     // Catch: Exception -> L20
        this.m_decoder = MediaCodec.createByCodecName(r112);     // Catch: Exception -> L20
        VELogUtil.i(TAG, "setupDecoder, codecName = " + r112);     // Catch: Exception -> L20
        goto L14
    L5:
        if (TEMediaCodecResourceManager.tryUseCodecBlocksSize((this.m_iWidth * this.m_iHeight) * this.m_iFps, hashCode()) == true) goto L29;
        VELogUtil.w(TAG, VELogUtil.formatLog(TAG, "setupDecoder ERROR_HW_OVERLOAD", new VELogUtil.a[]{new VELogUtil.a("MaxCodecBlocksSize is", Integer.valueOf(TEMediaCodecResourceManager.getMaxCodecBlocksSize())), new VELogUtil.a("UsedCodecBlocksSize is", Integer.valueOf(TEMediaCodecResourceManager.getUsedCodecBlocksSize()))}));
        if (TEMediaCodecResourceManager.sHWEncoderStateIsBeforeRunning == false) goto L29;
        VELogUtil.i(TAG, "guarantee HWEncoder strategy");
        return false;
    }

    public int flushDecoder(boolean r100) {
        if (this.m_decoder != null) goto L5;
        return -3;
    L5:
        if (r100 == false) goto L16;
    L24:
        e = move-exception;
        e.printStackTrace();
        return -3;
    L7:
        if (this.m_sawInputEOS == false) goto L9;
    L10:
        cleanupDecoder();     // Catch: Exception -> L24
        if (setupDecoder(this.VIDEO_MIME_TYPE) == false) goto L29;
        VELogUtil.w(TAG, "Decoder has been recreated.");     // Catch: Exception -> L24
    L30:
        return 0;
    L29:
        return -2;
    L9:
        if (this.m_sawOutputEOS == true) goto L10;
    L16:
        if (this.m_inputBufferQueued == false) goto L31;
        if (r100 == true) goto L19;
        this.m_timestampOfLastDecodedFrame = Long.MIN_VALUE;     // Catch: Exception -> L24
        this.m_timestampOfCurTexFrame = Long.MIN_VALUE;     // Catch: Exception -> L24
        this.m_pendingInputFrameCount = 0;     // Catch: Exception -> L24
        this.m_sawInputEOS = false;     // Catch: Exception -> L24
        this.m_sawOutputEOS = false;     // Catch: Exception -> L24
    L19:
        this.m_decoder.flush();     // Catch: Exception -> L24
        this.m_inputBufferQueued = false;     // Catch: Exception -> L24
        this.m_pendingInputFrameCount = 0;     // Catch: Exception -> L24
        if (VEConfigCenter.getInstance().getValue("ve_mediacodec_resource_reasonable_distribute", false).booleanValue() == false) goto L22;
        TEMediaCodecResourceManager.freeCodecBlocksSize((this.m_iWidth * this.m_iHeight) * this.m_iFps, hashCode());     // Catch: Exception -> L24
    L22:
        VELogUtil.i(TAG, "media decoder has been flushed.");     // Catch: Exception -> L24
        goto L30
    L31:
        return -3;
    }

    public String getBestCodecName(String r110) {
        if (TextUtils.isEmpty(r110) == false) goto L6;
        return null;
    L6:
        if (r110.equals("video/hevc") == true) goto L8;
    L11:
        ArrayList r100 = new ArrayList();
        Object r101 = mCodecListLock;
        monitor-enter(r101);
    L92:
        th = move-exception;
        throw th;
    L14:
        boolean r102 = !mVideoHWDecoderCodecs.isEmpty();
        if (r102 == false) goto L17;
        int r103 = mVideoHWDecoderCodecs.size();     // Catch: Exception -> L90 Throwable -> L92
    L18:
        int r104 = 0;
    L19:
        if (r104 >= r103) goto L78;
        if (r102 == true) goto L22;
    L24:
        if (r102 == false) goto L26;
        MediaCodecInfo r105 = mVideoHWDecoderCodecs.get(r104);     // Catch: Throwable -> L92
    L27:
        String r106 = r105.getName();     // Catch: Throwable -> L92
        if (r105.isEncoder() == false) goto L31;
    L76:
        r104 = r104 + 1;     // Catch: Throwable -> L92
        goto L19
    L31:
        if (r106.startsWith("OMX.google") == true) goto L76;
        if (r106.startsWith("c2.android") == true) goto L76;
        String[] r111 = r105.getSupportedTypes();     // Catch: Throwable -> L92
        if (r111 == null) goto L76;
        int r112 = r111.length;     // Catch: Throwable -> L92
        int r113 = 0;
    L39:
        if (r113 >= r112) goto L76;
        String r114 = r111[r113];     // Catch: Throwable -> L92
        if (TextUtils.isEmpty(r114) == true) goto L75;
        if (r102 == true) goto L48;
        if (r114.startsWith("video/") == false) goto L48;
        mVideoHWDecoderCodecs.add(r105);     // Catch: Throwable -> L92
    L48:
        if (r114.equalsIgnoreCase(r110) == false) goto L75;
        if (r106.startsWith("OMX.") == true) goto L55;
        if (r106.startsWith("c2.") == false) goto L75;
    L55:
        if (r106.startsWith("OMX.pv") == true) goto L75;
        if (r106.startsWith("OMX.ittiam") == true) goto L75;
        if (r106.contains("ffmpeg") == true) goto L75;
        if (r106.contains("avcodec") == true) goto L75;
        if (r106.contains("secure") == true) goto L75;
        r106.startsWith("OMX.MTK.");     // Catch: Throwable -> L92
        if (codecNeedsFlushWorkaround(r106) == true) goto L75;
        com.ss.android.ttve.mediacodec.a r115 = com.ss.android.ttve.mediacodec.a.a(r105, r110);     // Catch: Throwable -> L92
        if (r115 == null) goto L75;
        r115.f449888a.getName();     // Catch: Throwable -> L92
        if (r115.f449889b == 20) goto L75;
        r100.add(r115);     // Catch: Throwable -> L92
    L75:
        r113 = r113 + 1;     // Catch: Throwable -> L92
        goto L39
    L26:
        r105 = MediaCodecList.getCodecInfoAt(r104);     // Catch: Throwable -> L92
        goto L27
    L22:
        if (r100.isEmpty() == true) goto L24;
    L78:
        if (r100.isEmpty() == false) goto L81;
        monitor-exit(r101);     // Catch: Throwable -> L92
        return null;
    L81:
        com.ss.android.ttve.mediacodec.a r107 = (com.ss.android.ttve.mediacodec.a) r100.get(0);     // Catch: Throwable -> L92
        Iterator r108 = r100.iterator();     // Catch: Throwable -> L92
    L83:
        if (r108.hasNext() == false) goto L87;
        com.ss.android.ttve.mediacodec.a r109 = (com.ss.android.ttve.mediacodec.a) r108.next();     // Catch: Throwable -> L92
        if (r109.f449889b <= r107.f449889b) goto L83;
        r107 = r109;
        goto L83
    L87:
        String r116 = r107.f449888a.getName();     // Catch: Throwable -> L92
        monitor-exit(r101);     // Catch: Throwable -> L92
        return r116;
        goto L91
    L17:
        r103 = MediaCodecList.getCodecCount();     // Catch: Exception -> L90 Throwable -> L92
    L91:
        return null;
    L8:
        if (mIsByteVC1Blocklist == false) goto L11;
        String r117 = Build.HARDWARE;
        return null;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture r100) {
        Object r101 = this.m_frameSyncObject;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.m_frameAvailable == false) goto L7;
        VELogUtil.d(TAG, "m_frameAvailable already set, frame could be dropped!");     // Catch: Throwable -> L10
    L7:
        this.m_frameAvailable = true;     // Catch: Throwable -> L10
        this.m_frameSyncObject.notifyAll();     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public void onImageAvailable(ImageReader r100) {
        Object r101 = this.m_frameSyncObject;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.m_frameAvailable == false) goto L7;
        VELogUtil.d(TAG, "m_frameAvailable already set, frame could be dropped!");     // Catch: Throwable -> L13
    L7:
        Image r102 = r100.acquireNextImage();     // Catch: Throwable -> L13
        Image r103 = this.mImage;     // Catch: Throwable -> L13
        if (r103 == null) goto L10;
        r103.close();     // Catch: Throwable -> L13
    L10:
        this.mImage = r102;     // Catch: Throwable -> L13
        this.m_frameAvailable = true;     // Catch: Throwable -> L13
        this.m_frameSyncObject.notifyAll();     // Catch: Throwable -> L13
        monitor-exit(r101);     // Catch: Throwable -> L13
    }

    public int releaseOutBuffer(boolean r100) {
        if (this.m_bGlobalDecoderPoolOption <= 1) goto L27;
    L4:
        int r101 = GLES20.glGetError();
        if (r101 == 0) goto L27;
        VELogUtil.e(TAG, "before releaseOutBuffer, glError:" + r101);
    L27:
        this.m_pendingInputFrameCount--;     // Catch: Exception -> L9
        this.m_decoder.releaseOutputBuffer(this.m_indexOfOutputBuffer, r100);     // Catch: Exception -> L9
    L12:
        if (r100 == true) goto L14;
    L26:
        return 0;
    L14:
        if (AwaitNewImage(500) == true) goto L17;
        VELogUtil.e(TAG, "release output buffer to surface texture failed!");
        return -103;
    L17:
        this.m_awaitNewImageSuccess = true;
        if (this.m_bGlobalDecoderPoolOption <= 1) goto L26;
        boolean r102 = false;
    L20:
        int r103 = GLES20.glGetError();
        if (r103 == 0) goto L23;
        VELogUtil.e(TAG, "after releaseOutBuffer, glError:" + r103);
        r102 = true;
        goto L20
    L23:
        if (r102 == false) goto L26;
        return -105;
    L9:
        e = move-exception;
        e.printStackTrace();
        VELogUtil.e(TAG, e.getMessage());
        goto L12
    }

    public static String getProperty(String r100, String r101) {
        Class r102 = INVOKESTATIC_com_ss_android_ttve_mediacodec_TEMediaCodecDecoder_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L4 Throwable -> L7
        return (String) r102.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, r101});
    L4:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L7
    L6:
        return r101;
    }

    public int getInfoByFlag(long[] r100, int r101) {
        if (r101 != 1) goto L6;
        r100[0] = this.m_timestampOfLastDecodedFrame;
    L8:
        return 0;
    L6:
        if (r101 != 2) goto L8;
        r100[0] = this.m_timestampOfCurTexFrame;
        goto L8
    }

    public static boolean checkHDVideoCanFastImport(int r100, int r101, int r102) {
        if (VEConfigCenter.getInstance().getValue("ve_mediacodec_resource_reasonable_distribute", false).booleanValue() == true) goto L6;
        return false;
    L6:
        return TEMediaCodecResourceManager.checkCanFastImport(r100, r101, r102);
    }

    public static Bitmap convertTexToBitmap(int r100, int r101, int r102) {
        ByteBuffer r103 = readTextureToByteBuffer(r100, r101, r102);
        Bitmap r104 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        r104.copyPixelsFromBuffer(r103);
        return r104;
    }

    private int decodeFrame2Surface(byte[] r210, int r211, long r212) throws IOException {
        int r100 = sPendingInputBufferThreshold;
        int r110 = sDequeueOutputTimeoutUs;
        boolean r111 = false;
        this.m_needSendPacketAgain = false;
        if (r211 != 0) goto L5;
        int r101 = r110;
    L6:
        boolean r102 = this.m_sawInputEOS;
        int r112 = -2;
        int r113 = 1;
        String r114 = TAG;
        if (r102 == true) goto L36;
        MediaCodec r103 = this.m_decoder;
        if (sDequeueHWDecodeInputBufferOpt == false) goto L11;
        long r104 = r101;
    L12:
        int r105 = r103.dequeueInputBuffer(r104);
        int r106 = 0;
    L13:
        if (r105 >= 0) goto L25;
        if (sDequeueHWDecodeInputBufferOpt == false) goto L112;
        if (r211 != 0) goto L25;
    L112:
        Thread.sleep(5, 0);     // Catch: InterruptedException -> L20
    L22:
        r105 = this.m_decoder.dequeueInputBuffer(r110);
        r106 = r106 + 1;
        if (r106 < 20) goto L13;
        VELogUtil.e(TAG, VELogUtil.formatLog(TAG, "decodeFrame2Surface try dequeueInputBuffer timeout --", new VELogUtil.a[]{new VELogUtil.a("tryCount =", Integer.valueOf(r106))}));
    L20:
        e = move-exception;
        e.printStackTrace();
    L25:
        if (r105 < 0) goto L34;
        ByteBuffer r107 = getInputBufferByIdx(r105);
        if (r211 != 0) goto L29;
        this.m_decoder.queueInputBuffer(r105, 0, 0, 0, 4);
        this.m_sawInputEOS = true;
        VELogUtil.i(TAG, "RenderInput EOS");
        goto L36
    L29:
        r107.clear();
        if (r107.capacity() >= r211) goto L33;
        VELogUtil.e(TAG, "inputBuf.capacity(): " + r107.capacity() + " < inputSize: " + r211 + ", m_pendingInputFrameCount" + this.m_pendingInputFrameCount + ", width * height: " + this.m_iWidth + "*" + this.m_iHeight);
        return -2;
    L33:
        r107.put(r210, 0, r211);
        this.m_decoder.queueInputBuffer(r105, 0, r211, r212, 0);
        this.m_inputBufferQueued = true;
        this.m_pendingInputFrameCount++;
        goto L36
    L34:
        this.m_needSendPacketAgain = true;
        VELogUtil.d(TAG, "RenderInput buffer not available");
        goto L36
    L11:
        r104 = r110;
    L36:
        if (this.m_sawOutputEOS == false) goto L39;
        r110 = r110 * 20;
    L42:
        int r108 = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, r110);
        if (r108 == (-3)) goto L42;
        if (r108 != r112) goto L73;
        MediaFormat r109 = this.m_decoder.getOutputFormat();
        int r115 = r109.getInteger("width");
        int r116 = r109.getInteger("height");
        int r117 = r109.getInteger("crop-left");
        int r118 = r109.getInteger("crop-right") + r113;
        int r119 = r109.getInteger("crop-top");
        int r120 = r109.getInteger("crop-bottom") + r113;
        int r121 = r118 - r117;
        this.m_iWidth = r121;
        int r122 = r120 - r119;
        this.m_iHeight = r122;
        if (VEConfigCenter.getInstance().getValue("ve_anable_codec2_output_format_align_16", r111).booleanValue() == false) goto L62;
        if (Build.VERSION.SDK_INT < 29) goto L53;
        VELogUtil.i(r114, "outputFormat width: " + r115 + ", height: " + r116 + ", align to 16");
        r115 = (((r115 + 16) + (-1)) / 16) * 16;
        r116 = (((r116 + 16) + (-1)) / 16) * 16;
    L53:
        if (this.m_iCodecID != 174) goto L62;
        if ("OMX.hisi.video.decoder.hevc".equals(getBestCodecName(this.VIDEO_MIME_TYPE)) == false) goto L62;
        if ((this.m_iWidth % 16) != 0) goto L62;
        if ((this.m_iHeight % 16) != 0) goto L62;
        VELogUtil.i(r114, "outputFormat width: " + r115 + ", height: " + r116 + ", m_iWidth: " + this.m_iWidth + ", m_iHeight: " + this.m_iHeight);
        r115 = this.m_iWidth;
        r116 = this.m_iHeight;
    L62:
        if (this.m_bReEnableOpt == false) goto L68;
        if (r115 <= 0) goto L68;
        if (r116 <= 0) goto L68;
        float r123 = r115;
        float r124 = r116;
        this.m_renderParam.f449881a = new RectF((r117 * 1.0f) / r123, (r119 * 1.0f) / r124, (r118 * 1.0f) / r123, (r120 * 1.0f) / r124);
        a r125 = this.m_renderParam;
        r125.f449883c = r121;
        r125.f449884d = r122;
    L68:
        if (this.m_textureRender != null) goto L70;
    L72:
        r110 = r110;
        r114 = r114;
        r111 = false;
        r112 = -2;
        r113 = 1;
        goto L42
    L70:
        if (VEConfigCenter.getInstance().getValue("ve_enable_hw_decoder_use_surfacetexture_matrix", false).booleanValue() == true) goto L72;
        this.m_textureRender.e(r115, r116, r119, r120, r117, r118);
        goto L72
    L73:
        String r213 = r114;
        if (r108 != (-1)) goto L78;
        VELogUtil.d(r213, "No output from decoder available");
        return -102;
    L78:
        if (r108 >= 0) goto L81;
        VELogUtil.e(r213, VELogUtil.formatLog(r213, "Unexpected result from decoder.dequeueOutputBuffer", new VELogUtil.a[]{new VELogUtil.a("decoderStatus", Integer.valueOf(r108))}));
        return -2;
    L81:
        VELogUtil.d(r213, "Surface decoder given buffer " + r108 + " (size=" + this.m_bufferInfo.size + ")  (pts=" + this.m_bufferInfo.presentationTimeUs + ") ");
        if ((this.m_bufferInfo.flags & 4) == 0) goto L84;
        VELogUtil.i(r213, "DisplayView EOS");
        int r126 = 1;
        this.m_sawOutputEOS = true;
    L86:
        if (this.m_sawOutputEOS == true) goto L88;
        this.m_timestampOfLastDecodedFrame = this.m_bufferInfo.presentationTimeUs;
        this.m_pendingInputFrameCount -= r126;
        VELogUtil.d(r213, "Pending input frame count decreased: " + this.m_pendingInputFrameCount);
        boolean r127 = true;
    L90:
        if (this.m_bGlobalDecoderPoolOption <= 1) goto L94;
    L91:
        int r128 = GLES20.glGetError();
        if (r128 == 0) goto L94;
        VELogUtil.e(r213, "before releaseOutputBuffer, glError:" + r128);
    L94:
        this.m_decoder.releaseOutputBuffer(r108, r127);
        if (r127 == false) goto L111;
        VELogUtil.d(r213, "Rendering decoded frame to surface texture.");
        if (AwaitNewImage(500) == false) goto L109;
        this.m_timestampOfCurTexFrame = this.m_bufferInfo.presentationTimeUs;
        boolean r129 = false;
    L99:
        int r130 = GLES20.glGetError();
        if (r130 == 0) goto L102;
        VELogUtil.e(r213, "after releaseOutputBuffer, glError:" + r130);
        r129 = true;
        goto L99
    L102:
        if (r129 == true) goto L104;
    L107:
        VELogUtil.d(r213, "Surface texture updated, pts=" + this.m_timestampOfCurTexFrame);
        return 0;
    L104:
        if (this.m_bGlobalDecoderPoolOption <= 1) goto L107;
        return -105;
    L109:
        VELogUtil.e(r213, VELogUtil.formatLog(r213, "Render decoded frame to surface texture failed!", new VELogUtil.a[0]));
        return -103;
    L111:
        return -1;
    L88:
        r127 = false;
        goto L90
    L84:
        r126 = 1;
        goto L86
    L39:
        if (this.m_pendingInputFrameCount > r100) goto L42;
        r110 = 0;
        goto L42
    L5:
        r101 = 0;
        goto L6
    }

    private int decodeFrameWithInputOutput(byte[] r210, int r211, long r212) throws IOException {
        int r110 = sPendingInputBufferThreshold;
        int r111 = sDequeueOutputTimeoutUs;
        boolean r112 = false;
        this.m_needSendPacketAgain = false;
        if (r211 != 0) goto L5;
        int r100 = r111;
    L6:
        boolean r101 = this.m_sawInputEOS;
        int r113 = -2;
        int r114 = 1;
        String r115 = TAG;
        if (r101 == true) goto L36;
        MediaCodec r102 = this.m_decoder;
        if (sDequeueHWDecodeInputBufferOpt == false) goto L11;
        long r103 = r100;
    L12:
        int r104 = r102.dequeueInputBuffer(r103);
        int r105 = 0;
    L13:
        if (r104 >= 0) goto L25;
        if (sDequeueHWDecodeInputBufferOpt == false) goto L104;
        if (r211 != 0) goto L25;
    L104:
        Thread.sleep(5, 0);     // Catch: InterruptedException -> L20
    L22:
        r104 = this.m_decoder.dequeueInputBuffer(r111);
        r105 = r105 + 1;
        if (r105 < 20) goto L13;
        VELogUtil.e(TAG, VELogUtil.formatLog(TAG, "decodeFrameWithInputOutput", new VELogUtil.a[]{new VELogUtil.a("try dequeueInputBuffer timeout", r105 + "")}));
    L20:
        e = move-exception;
        e.printStackTrace();
    L25:
        if (r104 < 0) goto L34;
        ByteBuffer r106 = getInputBufferByIdx(r104);
        if (r211 != 0) goto L29;
        this.m_decoder.queueInputBuffer(r104, 0, 0, 0, 4);
        this.m_sawInputEOS = true;
        VELogUtil.i(TAG, "RenderInput EOS");
        goto L36
    L29:
        r106.clear();
        if (r106.capacity() >= r211) goto L33;
        VELogUtil.e(TAG, "inputBuf.capacity(): " + r106.capacity() + " < inputSize: " + r211 + ", m_pendingInputFrameCount" + this.m_pendingInputFrameCount + ", width * height: " + this.m_iWidth + "*" + this.m_iHeight);
        return -2;
    L33:
        r106.put(r210, 0, r211);
        this.m_decoder.queueInputBuffer(r104, 0, r211, r212, 0);
        this.m_inputBufferQueued = true;
        this.m_pendingInputFrameCount++;
        goto L36
    L34:
        this.m_needSendPacketAgain = true;
        VELogUtil.d(TAG, "RenderInput buffer not available, inputSize:" + r211);
        goto L36
    L11:
        r103 = r111;
    L36:
        if (this.m_sawOutputEOS == false) goto L39;
        r111 = r111 * 20;
    L42:
        int r107 = this.m_decoder.dequeueOutputBuffer(this.m_bufferInfo, r111);
        if (r107 == (-3)) goto L42;
        if (r107 != r113) goto L81;
        MediaFormat r108 = this.m_decoder.getOutputFormat();
        int r109 = r108.getInteger("width");
        int r116 = r108.getInteger("height");
        int r117 = r108.getInteger("crop-left");
        int r118 = r108.getInteger("crop-right") + r114;
        int r119 = r108.getInteger("crop-top");
        int r120 = r108.getInteger("crop-bottom") + r114;
        int r121 = r118 - r117;
        this.m_iWidth = r121;
        int r122 = r120 - r119;
        this.m_iHeight = r122;
        if (VEConfigCenter.getInstance().getValue("ve_anable_codec2_output_format_align_16", r112).booleanValue() == true) goto L49;
        int r213 = r111;
    L70:
        if (this.m_bReEnableOpt == false) goto L76;
        if (r109 <= 0) goto L76;
        if (r116 <= 0) goto L76;
        float r123 = r109;
        float r124 = r116;
        this.m_renderParam.f449881a = new RectF((r117 * 1.0f) / r123, (r119 * 1.0f) / r124, (r118 * 1.0f) / r123, (r120 * 1.0f) / r124);
        a r125 = this.m_renderParam;
        r125.f449883c = r121;
        r125.f449884d = r122;
    L76:
        if (this.m_textureRender != null) goto L78;
    L80:
        r111 = r213;
        r115 = r115;
        r112 = false;
        r113 = -2;
        r114 = 1;
        goto L42
    L78:
        if (VEConfigCenter.getInstance().getValue("ve_enable_hw_decoder_use_surfacetexture_matrix", false).booleanValue() == true) goto L80;
        this.m_textureRender.e(r109, r116, r119, r120, r117, r118);
        goto L80
    L49:
        if (r108.containsKey("color-transfer") == false) goto L51;
        int r126 = r108.getInteger("color-transfer");
    L52:
        r213 = r111;
        if (Build.VERSION.SDK_INT < 29) goto L56;
        VELogUtil.i(r115, "outputFormat width: " + r109 + ", height: " + r116 + ", align to 16, colorTransfer: " + r126);
        r109 = (((r109 + 16) + (-1)) / 16) * 16;
        r116 = (((r116 + 16) + (-1)) / 16) * 16;
    L56:
        if (this.m_iCodecID != 174) goto L70;
        if ("OMX.hisi.video.decoder.hevc".equals(getBestCodecName(this.VIDEO_MIME_TYPE)) == false) goto L70;
        if ((this.m_iWidth % 16) != 0) goto L64;
        if ((this.m_iHeight % 16) != 0) goto L64;
    L67:
        VELogUtil.i(r115, "outputFormat width: " + r109 + ", height: " + r116 + ", m_iWidth: " + this.m_iWidth + ", m_iHeight: " + this.m_iHeight);
        r109 = this.m_iWidth;
        r116 = this.m_iHeight;
    L64:
        if (isHarmonyOS() == false) goto L70;
        if (r126 == 6) goto L70;
    L51:
        r126 = 0;
        goto L52
    L81:
        String r214 = r115;
        if (r107 != (-1)) goto L86;
        VELogUtil.d(r214, "No output from decoder available, inputSize:" + r211);
        return -102;
    L86:
        if (r107 >= 0) goto L89;
        VELogUtil.e(r214, VELogUtil.formatLog(r214, "Unexpected result from decoder.dequeueOutputBuffer", new VELogUtil.a[]{new VELogUtil.a("decoderStatus", Integer.valueOf(r107))}));
        return -2;
    L89:
        VELogUtil.d(r214, "Surface decoder given buffer " + r107 + " (size=" + this.m_bufferInfo.size + ")  (pts=" + this.m_bufferInfo.presentationTimeUs + ") ");
        this.m_indexOfOutputBuffer = r107;
        if ((this.m_bufferInfo.flags & 4) == 0) goto L92;
        boolean r127 = true;
    L93:
        this.m_sawOutputEOS = r127;
        if (this.m_sawOutputEOS == false) goto L97;
        VELogUtil.i(r214, "get MediaCodec BUFFER_FLAG_END_OF_STREAM");
    L97:
        if (this.m_sawOutputEOS == true) goto L100;
        this.m_timestampOfLastDecodedFrame = this.m_bufferInfo.presentationTimeUs;
        this.m_timestampOfCurTexFrame = this.m_bufferInfo.presentationTimeUs;
        VELogUtil.d(r214, "Pending input frame count decreased: " + this.m_pendingInputFrameCount);
    L100:
        if (this.m_sawOutputEOS == true) goto L102;
        return 0;
    L102:
        return -1;
    L92:
        r127 = false;
        goto L93
    L39:
        if (this.m_pendingInputFrameCount > r110) goto L42;
        r111 = 0;
        goto L42
    L5:
        r100 = 0;
        goto L6
    }

    public static boolean dumpOESTexture(int r110, int r111, int r112) {
        int[] r113 = new int[1];
        int[] r114 = new int[1];
        GLES20.glGetIntegerv(36006, r114, 0);
        GLES20.glGenFramebuffers(1, r113, 0);
        GLES20.glViewport(0, 0, r111, r112);
        GLES20.glBindTexture(36197, r110);
        GLES20.glBindFramebuffer(36160, r113[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 36197, r110, 0);
        ByteBuffer r100 = ByteBuffer.allocateDirect((r111 * r112) * 4);
        r100.order(ByteOrder.nativeOrder());
        r100.position(0);
        GLES20.glReadPixels(0, 0, r111, r112, 6408, 5121, r100);
        GLES20.glFinish();
        GLES20.glBindFramebuffer(36160, r114[0]);
        GLES20.glBindTexture(36197, 0);
        GLES20.glDeleteFramebuffers(1, r113, 0);
        Bitmap r101 = Bitmap.createBitmap(r111, r112, Bitmap.Config.ARGB_8888);
        r101.copyPixelsFromBuffer(r100);
        String r102 = "/data/data/com.lemon.lv/files/OES_" + file_count + "_" + r110 + ".jpg";
        file_count++;
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102);
        if (r103.exists() == false) goto L22;
        r103.delete();
    L22:
        PolarisFileOutputStreamWrapper r104 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L10 Exception -> L12
        r101.compress(Bitmap.CompressFormat.JPEG, 20, r104);     // Catch: Throwable -> L10 Exception -> L12
        r104.flush();     // Catch: Throwable -> L10 Exception -> L12
        r104.close();     // Catch: Throwable -> L10 Exception -> L12
    L7:
        if (r101.isRecycled() == true) goto L9;
        r101.recycle();
    L9:
        return true;
    L10:
        th = move-exception;
        if (r101.isRecycled() == true) goto L21;
        r101.recycle();
    L21:
        throw th;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        if (r101.isRecycled() == true) goto L17;
        r101.recycle();
    L17:
        return false;
    }

    private static boolean isSupportFormat(String r100, int r101, int r102) {
        MediaCodecInfo r103 = getMediaCodecInfo21(r100);
        if (r103 != null) goto L6;
        VELogUtil.e(TAG, "MediaCodecInfo is null!");
        return false;
    L6:
        MediaCodecInfo.CodecProfileLevel[] r104 = r103.getCapabilitiesForType(r100).profileLevels;
        int r105 = r104.length;
        int r106 = 0;
    L7:
        if (r106 >= r105) goto L16;
        MediaCodecInfo.CodecProfileLevel r107 = r104[r106];
        if (r107.profile != r101) goto L15;
        if (r107.level < r102) goto L15;
        return true;
    L15:
        r106 = r106 + 1;
        goto L7
    L16:
        return false;
    }

    public static ByteBuffer readTextureToByteBuffer(int r110, int r111, int r112) {
        int[] r100 = new int[1];
        int[] r101 = new int[1];
        GLES20.glGetIntegerv(36006, r101, 0);
        GLES20.glGenFramebuffers(1, r100, 0);
        GLES20.glBindFramebuffer(36160, r100[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, r110, 0);
        ByteBuffer r113 = ByteBuffer.allocate((r111 * r112) * 4);
        GLES20.glReadPixels(0, 0, r111, r112, 6408, 5121, r113);
        GLES20.glFinish();
        GLES20.glBindFramebuffer(36160, r101[0]);
        GLES20.glDeleteFramebuffers(1, r100, 0);
        return r113;
    }

    public static boolean saveFrameToFile(int r100, int r101, int r102) {
        Bitmap r103 = convertTexToBitmap(r100, r101, r102);
        String r104 = "/data/data/com.lemon.lv/files/2D_" + file_count + "_" + r100 + ".jpg";
        file_count++;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104);
        if (r105.exists() == false) goto L23;
        r105.delete();
    L23:
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r105);     // Catch: Throwable -> L10 Exception -> L12
        r103.compress(Bitmap.CompressFormat.JPEG, 20, r106);     // Catch: Throwable -> L10 Exception -> L12
        r106.flush();     // Catch: Throwable -> L10 Exception -> L12
        r106.close();     // Catch: Throwable -> L10 Exception -> L12
    L7:
        if (r103.isRecycled() == true) goto L9;
        r103.recycle();
    L9:
        return true;
    L10:
        th = move-exception;
        if (r103.isRecycled() == true) goto L22;
        r103.recycle();
    L22:
        throw th;
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L10
        if (r103.isRecycled() == true) goto L26;
        r103.recycle();
        return false;
    L26:
        return false;
    }

    public int decodeFrameWithoutDraw(byte[] r100, int r101, long r102) throws IOException {
        if (this.m_decoder != null) goto L6;
        return -2;
    L6:
        if (VEConfigCenter.getInstance().getValue("ve_mediacodec_resource_reasonable_distribute", false).booleanValue() == true) goto L8;
    L15:
        return decodeFrameWithInputOutput(r100, r101, r102);
    L12:
        e = move-exception;
        e.printStackTrace();
        return -2;
    L8:
        if (TEMediaCodecResourceManager.tryUseCodecBlocksSize((this.m_iWidth * this.m_iHeight) * this.m_iFps, hashCode()) == true) goto L15;
        VELogUtil.d(TAG, VELogUtil.formatLog(TAG, "decodeFrameWithoutDraw ERROR_HW_OVERLOAD", new VELogUtil.a[]{new VELogUtil.a("MaxCodecBlocksSize is", Integer.valueOf(TEMediaCodecResourceManager.getMaxCodecBlocksSize())), new VELogUtil.a("UsedCodecBlocksSize is", Integer.valueOf(TEMediaCodecResourceManager.getUsedCodecBlocksSize()))}));
        goto L15
    }

    public void updateAndRenderOES(int r100, int r110, int r111, int r112) {
        this.m_iOutputWidth = r110;
        this.m_iOutputHeight = r111;
        this.m_iRotateDegree = r112;
        if (this.m_bUseImageReader == true) goto L8;
        if (this.m_eglStateSaver != null) goto L8;
        com.ss.android.ttve.common.b r113 = new com.ss.android.ttve.common.b();
        this.m_eglStateSaver = r113;
        r113.c();
        this.m_textureRender.f449879o = this.m_eglStateSaver.f449840e;
    L8:
        if (this.m_bUseImageReader == true) goto L13;
        if (EGL14.eglGetCurrentContext().equals(this.m_eglStateSaver.f449836a) == true) goto L13;
        VELogUtil.w(TAG, "eglGetCurrentContext = " + EGL14.eglGetCurrentContext() + " getSavedEGLContext = " + this.m_eglStateSaver.f449836a);
    L13:
        if (this.m_sawOutputEOS == true) goto L37;
        VELogUtil.d(TAG, "Rendering decoded frame to surface texture.");
        if (this.m_awaitNewImageSuccess == false) goto L36;
        this.m_timestampOfCurTexFrame = this.m_bufferInfo.presentationTimeUs;
        if (this.m_bReEnableOpt == false) goto L19;
        this.m_ReEncodeOptCV.block();
    L19:
        SurfaceTexture r114 = this.m_surfaceTexture;
        if (r114 == null) goto L25;
        r114.updateTexImage();
        if (VEConfigCenter.getInstance().getValue("ve_enable_hw_decoder_use_surfacetexture_matrix", false).booleanValue() == false) goto L25;
        this.m_surfaceTexture.getTransformMatrix(this.m_textureRender.f449868d);
    L25:
        if (this.m_bReEnableOpt == false) goto L28;
        this.m_ReEncodeOptCV.close();
        this.m_awaitNewImageSuccess = false;
        return;
    L28:
        OESTextureRender r101 = this.m_textureRender;
        if (r101 == null) goto L33;
        if (r100 <= 0) goto L33;
        r101.b(this.m_iWidth, this.m_iHeight, this.m_iOutputWidth, this.m_iOutputHeight, this.m_surfaceTexID[0], r100, this.m_iRotateDegree);
    L33:
        if (this.m_bUseImageReader == false) goto L35;
        onImageFrameAvailable();
    L35:
        this.m_awaitNewImageSuccess = false;
        return;
    L36:
        VELogUtil.e(TAG, "Render OES to 2D texture failed: m_awaitNewImageSuccess is false!");
        return;
    L37:
        VELogUtil.d(TAG, "Render OES to 2D texture failed: m_sawOutputEOS");
    }

    public int decodeFrame(byte[] r110, int r111, long r112, int r113, int r114, int r210, int r211) throws IOException {
        this.m_iOutputWidth = r114;
        this.m_iOutputHeight = r210;
        this.m_iRotateDegree = r211;
        if (this.m_bUseImageReader == true) goto L8;
        if (this.m_eglStateSaver != null) goto L8;
        com.ss.android.ttve.common.b r100 = new com.ss.android.ttve.common.b();
        this.m_eglStateSaver = r100;
        r100.c();
    L8:
        if (this.m_bUseImageReader == true) goto L13;
        if (EGL14.eglGetCurrentContext().equals(this.m_eglStateSaver.f449836a) == true) goto L13;
        Objects.toString(EGL14.eglGetCurrentContext());
        Objects.toString(this.m_eglStateSaver.f449836a);
        this.m_bNeedConfigure = true;
    L13:
        if (this.m_bNeedConfigure == true) goto L15;
    L18:
        int r101 = -2;
        if (this.m_decoder != null) goto L22;
        return -2;
    L22:
        if (VEConfigCenter.getInstance().getValue("ve_mediacodec_resource_reasonable_distribute", false).booleanValue() == true) goto L24;
    L51:
        r101 = decodeFrame2Surface(r110, r111, r112);     // Catch: IllegalStateException -> L28
    L30:
        if (r101 == 0) goto L32;
    L50:
        return r101;
    L32:
        if (this.m_bReEnableOpt == false) goto L34;
        this.m_ReEncodeOptCV.block();
    L34:
        SurfaceTexture r102 = this.m_surfaceTexture;
        if (r102 == null) goto L40;
        r102.updateTexImage();
        if (VEConfigCenter.getInstance().getValue("ve_enable_hw_decoder_use_surfacetexture_matrix", false).booleanValue() == false) goto L40;
        this.m_surfaceTexture.getTransformMatrix(this.m_textureRender.f449868d);
    L40:
        if (this.m_bReEnableOpt == false) goto L43;
        this.m_ReEncodeOptCV.close();
        return r101;
    L43:
        OESTextureRender r103 = this.m_textureRender;
        if (r103 == null) goto L48;
        if (r113 <= 0) goto L48;
        r103.b(this.m_iWidth, this.m_iHeight, this.m_iOutputWidth, this.m_iOutputHeight, this.m_surfaceTexID[0], r113, this.m_iRotateDegree);
    L48:
        if (this.m_bUseImageReader == false) goto L50;
        onImageFrameAvailable();
    L28:
        e = move-exception;
        e.printStackTrace();
        goto L30
    L24:
        if (TEMediaCodecResourceManager.tryUseCodecBlocksSize((this.m_iWidth * this.m_iHeight) * this.m_iFps, hashCode()) == true) goto L51;
        VELogUtil.d(TAG, VELogUtil.formatLog(TAG, "decodeFrame ERROR_HW_OVERLOAD", new VELogUtil.a[]{new VELogUtil.a("MaxCodecBlocksSize is", Integer.valueOf(TEMediaCodecResourceManager.getMaxCodecBlocksSize())), new VELogUtil.a("UsedCodecBlocksSize is", Integer.valueOf(TEMediaCodecResourceManager.getUsedCodecBlocksSize()))}));
        goto L51
    L15:
        if (this.m_bUseImageReader == true) goto L17;
        this.m_eglStateSaver.c();
    L17:
        restartDecoder();
        this.m_bNeedConfigure = false;
        goto L18
    }

    public int setDecoderParams(int r100, int r101, int r102, byte[] r103, int r104, int r105, int r106, int r107) {
        this.m_iWidth = r100;
        this.m_iHeight = r101;
        this.m_iFps = r102;
        this.m_iOutputWidth = r105;
        this.m_iOutputHeight = r106;
        this.m_codecSpecificData = null;
        this.m_iCodecID = r107;
        if (r107 != 2) goto L5;
        this.VIDEO_MIME_TYPE = "video/mpeg2";
    L22:
        if (r104 <= 0) goto L24;
        this.m_codecSpecificData = ByteBuffer.wrap(r103, 0, r104);
    L24:
        this.m_bNeedConfigure = true;
        return 0;
    L5:
        if (r107 != 13) goto L7;
        this.VIDEO_MIME_TYPE = "video/mp4v-es";
        goto L22
    L7:
        if (r107 != 28) goto L9;
        this.VIDEO_MIME_TYPE = KryptonDefaultMediaRecorder.VIDEO_MIME_TYPE;
        this.mMinCompressionRatio = 2;
        goto L22
    L9:
        if (r107 != 140) goto L11;
        this.VIDEO_MIME_TYPE = "video/x-vnd.on2.vp8";
        goto L22
    L11:
        if (r107 != 168) goto L13;
        this.VIDEO_MIME_TYPE = "video/x-vnd.on2.vp9";
        goto L22
    L13:
        if (r107 != 174) goto L22;
        this.VIDEO_MIME_TYPE = "video/hevc";
        this.mMinCompressionRatio = 4;
        goto L22
    }

    public int initDecoder(long r110, int r111, int r112, int r113, byte[] r114, int r115, int r116, int r210, int r211, boolean r212, boolean r213, boolean r214, int r215) {
        this.m_nativeHandler = r110;
        this.m_bUseImageReader = r213;
        this.mIs10bit = r214;
        this.m_pageMode = r215;
        this.m_bGlobalDecoderPoolOption = VEConfigCenter.getInstance().getValue("ve_enable_global_decoder_pool", 0);
        m_useCreateDecoderByName = r212;
        if (174 == r211) goto L5;
    L9:
        int r100 = setDecoderParams(r111, r112, r113, r114, r115, r116, r210, r211);
        if (this.m_bNeedConfigure == false) goto L12;
        r100 = configureMediaFormat();
    L12:
        if (r100 == 0) goto L15;
        return r100;
    L15:
        if (this.m_eglStateSaver != null) goto L20;
        if (this.m_bUseImageReader == true) goto L20;
        com.ss.android.ttve.common.b r101 = new com.ss.android.ttve.common.b();
        this.m_eglStateSaver = r101;
        r101.c();
    L20:
        if (this.m_bNeedConfigure == false) goto L24;
        r100 = restartDecoder();
        if (r100 != 0) goto L24;
        this.m_bNeedConfigure = false;
    L24:
        VELogUtil.w(TAG, "initHwDecoder srcSize:(" + r111 + "," + r112 + "), dstSize:(" + r116 + "," + r210 + ") ret=" + r100);
        return r100;
    L5:
        if (isHisiByteVC1BlockList() == false) goto L7;
    L8:
        mIsByteVC1Blocklist = true;
        goto L9
    L7:
        if (isMtkByteVC1BlockList() == false) goto L9;
        goto L8
    }
}
