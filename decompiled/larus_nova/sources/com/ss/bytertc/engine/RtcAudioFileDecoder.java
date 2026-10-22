package com.ss.bytertc.engine;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.bytedance.bdlocation.utils.DimLocationCheckUtil;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.realx.base.ContextUtils;
import com.bytedance.realx.base.RXLogging;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.a;
import f06.b;
import f06.d;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Vector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes40.dex */
class RtcAudioFileDecoder {
    private static final int MAX_DECODER_RETRY_COUNT = 100;
    private static final String TAG = "RtcAudioFileDecoder";
    private boolean eoInputStream;
    private boolean eoOutputStream;
    private int mChannels;
    private byte[] mDecodedData;
    private MediaExtractor mExtractor;
    private long mFileLength;
    private ByteBuffer[] mInputBuffers;
    private MediaCodec mMediaCodec;
    private ByteBuffer[] mOutputBuffers;
    private int mRetryCount;
    private int mSampleRate;
    private Vector<Integer> mTrackIds;
    private MediaFormat mUsedTrackFormat;
    private int mUsedTrackIdx;

    /* JADX INFO: renamed from: oc, reason: collision with root package name */
    private HttpURLConnection f456193oc;

    private boolean checkInfoChange() {
        MediaFormat r100 = this.mMediaCodec.getOutputFormat();     // Catch: Exception -> L12
        int r101 = r100.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);     // Catch: Exception -> L12
        int r102 = r100.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);     // Catch: Exception -> L12
        if (this.mSampleRate == r101) goto L6;
    L9:
        boolean r103 = true;
    L10:
        this.mSampleRate = r101;     // Catch: Exception -> L12
        this.mChannels = r102;     // Catch: Exception -> L12
        return r103;
    L6:
        if (this.mChannels != r102) goto L9;
        r103 = false;
    L12:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when checking file's new format");
        return false;
    }

    public void disConnectURL() {
        RXLogging.e(TAG, "disConnectURL");
        HttpURLConnection r100 = this.f456193oc;
        if (r100 == null) goto L6;
        r100.disconnect();
        return;
    }

    public int getAudioTrackCount() {
        Vector<Integer> r100 = this.mTrackIds;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    public long getCurrentFilePosition() {
        return this.mExtractor.getSampleTime() / 1000;
    L4:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when getCurrentFilePosition");
        return 0;
    }

    public long getFileLength() {
        return this.mFileLength / 1000;
    }

    public boolean readAudioData() {
        MediaCodec r100 = this.mMediaCodec;     // Catch: Exception -> L63
        if (r100 == null) goto L62;
        if (this.mExtractor == null) goto L62;
        if (this.eoInputStream == true) goto L24;
        int r110 = r100.dequeueInputBuffer(0);     // Catch: Exception -> L63
        if (r110 < 0) goto L24;
        ByteBuffer r101 = this.mMediaCodec.getInputBuffer(r110);     // Catch: Exception -> L63
        if (r101 == null) goto L15;
        int r102 = this.mExtractor.readSampleData(r101, 0);     // Catch: Exception -> L63
    L16:
        if (r102 > 0) goto L18;
        this.eoInputStream = true;     // Catch: Exception -> L63
        int r111 = 0;
    L19:
        long r112 = this.mExtractor.getSampleTime();     // Catch: Exception -> L63
        int r103 = this.mExtractor.getSampleFlags();     // Catch: Exception -> L63
        if (this.eoInputStream == false) goto L22;
        r103 = r103 | 4;     // Catch: Exception -> L63
    L22:
        this.mMediaCodec.queueInputBuffer(r110, 0, r111, r112, r103);     // Catch: Exception -> L63
        this.mExtractor.advance();     // Catch: Exception -> L63
        goto L24
    L18:
        r111 = r102;
        goto L19
    L15:
        r102 = 0;
    L24:
        if (this.eoOutputStream == true) goto L66;
        MediaCodec.BufferInfo r104 = new MediaCodec.BufferInfo();     // Catch: Exception -> L63
        int r105 = this.mMediaCodec.dequeueOutputBuffer(r104, 0);     // Catch: Exception -> L63
        this.mDecodedData = null;     // Catch: Exception -> L63
        if (r105 != (-3)) goto L28;
    L60:
        this.mDecodedData = new byte[0];     // Catch: Exception -> L63
        goto L66
    L28:
        if (r105 == (-2)) goto L60;
        if (r105 == (-1)) goto L48;
        this.mRetryCount = 0;     // Catch: Exception -> L63
        if (r105 < 0) goto L66;
        if ((r104.flags & 4) != 4) goto L36;
        this.eoOutputStream = true;     // Catch: Exception -> L63
    L36:
        ByteBuffer r106 = this.mMediaCodec.getOutputBuffer(r105);     // Catch: Exception -> L63
        int r107 = this.mUsedTrackFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);     // Catch: Exception -> L63
        int r108 = this.mChannels;     // Catch: Exception -> L63
        if (r107 != r108) goto L39;
    L45:
        if (r107 != r108) goto L47;
        byte[] r109 = new byte[r106.limit()];     // Catch: Exception -> L63
        this.mDecodedData = r109;     // Catch: Exception -> L63
        r106.get(r109, r104.offset, r104.size);     // Catch: Exception -> L63
        r106.clear();     // Catch: Exception -> L63
    L47:
        this.mMediaCodec.releaseOutputBuffer(r105, false);     // Catch: Exception -> L63
        goto L66
    L39:
        if (r108 != 2) goto L45;
        this.mDecodedData = new byte[r106.limit() * 2];     // Catch: Exception -> L63
        int r113 = 0;
    L42:
        if (r113 >= (r104.size / 2)) goto L44;
        int r114 = r113 * 4;     // Catch: Exception -> L63
        this.mDecodedData[r114] = r106.get();     // Catch: Exception -> L63
        byte[] r115 = this.mDecodedData;     // Catch: Exception -> L63
        r115[r114 + 2] = r115[r114];     // Catch: Exception -> L63
        int r116 = r114 + 1;     // Catch: Exception -> L63
        r115[r116] = r106.get();     // Catch: Exception -> L63
        byte[] r117 = this.mDecodedData;     // Catch: Exception -> L63
        r117[r114 + 3] = r117[r116];     // Catch: Exception -> L63
        r113 = r113 + 1;     // Catch: Exception -> L63
        goto L42
    L44:
        r106.clear();     // Catch: Exception -> L63
        goto L47
    L48:
        int r118 = this.mRetryCount + 1;     // Catch: Exception -> L63
        this.mRetryCount = r118;     // Catch: Exception -> L63
        if (r118 < 100) goto L59;
        String r119 = Build.BRAND;     // Catch: Exception -> L63
        if (r119.toLowerCase().contains("meizu") == true) goto L58;
        String r120 = Build.MANUFACTURER;     // Catch: Exception -> L63
        if (r120.toLowerCase().contains("meizu") == true) goto L58;
        if (r119.toLowerCase().contains(DimLocationCheckUtil.VIVO) == true) goto L58;
        if (r120.toLowerCase().contains(DimLocationCheckUtil.VIVO) == false) goto L59;
    L58:
        RXLogging.e(TAG, "EAGAIN count=" + this.mRetryCount + " presentationTimeUs=" + r104.presentationTimeUs + " totalUs=" + this.mFileLength + " Force EOS");     // Catch: Exception -> L63
        this.eoOutputStream = true;     // Catch: Exception -> L63
        this.mRetryCount = 0;     // Catch: Exception -> L63
    L59:
        this.mDecodedData = new byte[0];     // Catch: Exception -> L63
        Thread.sleep(3);     // Catch: Exception -> L63
    L66:
        return this.eoOutputStream;
    L62:
        return this.eoInputStream;
    L63:
        e = move-exception;
        e.printStackTrace();
        goto L66
    }

    public void uninit() {
        MediaCodec r100 = this.mMediaCodec;     // Catch: Exception -> L9
        if (r100 == null) goto L5;
        r100.stop();     // Catch: Exception -> L9
        this.mMediaCodec.release();     // Catch: Exception -> L9
        this.mMediaCodec = null;     // Catch: Exception -> L9
    L5:
        MediaExtractor r101 = this.mExtractor;     // Catch: Exception -> L9
        if (r101 == null) goto L11;
        r101.release();     // Catch: Exception -> L9
        this.mExtractor = null;     // Catch: Exception -> L9
    L11:
        this.eoOutputStream = false;
        this.eoInputStream = false;
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when releasing audio file stream" + e.getMessage());
        goto L11
    }

    public RtcAudioFileDecoder() {
        this.mSampleRate = 0;
        this.mChannels = 0;
        RXLogging.e(TAG, "AudioMix RtcAudioFileDecoder");
    }

    public int getChannelCount() {
        return this.mChannels;
    }

    public byte[] getDecodedData() {
        return this.mDecodedData;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public int getUsedTrackIdx() {
        return this.mUsedTrackIdx;
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection INVOKEVIRTUAL_com_ss_bytertc_engine_RtcAudioFileDecoder_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        a.b(a.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    private boolean checkUrlEncoded(String r100) {
        return !TextUtils.equals(r100, URLDecoder.decode(r100, "UTF-8"));
    L5:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when releasing audio file stream");
        return false;
    }

    private String encodeUrl(String r110) {
        RXLogging.e(TAG, "encodedUrl");
        URL r100 = new URL(r110);     // Catch: Exception -> L5
        return new URI(r100.getProtocol(), r100.getUserInfo(), r100.getHost(), r100.getPort(), r100.getPath(), r100.getQuery(), r100.getRef()).toASCIIString();
    L5:
        e = move-exception;
        e.printStackTrace();
        return r110;
    }

    private boolean isAvailableOnlineURL(String r100) {
        RXLogging.e(TAG, "isAvailableOnlineURL");
        this.f456193oc = null;
        HttpURLConnection r101 = (HttpURLConnection) INVOKEVIRTUAL_com_ss_bytertc_engine_RtcAudioFileDecoder_com_obric_assistant_network_okhttp_UrlConnLancet_openConnection(new URL(r100));     // Catch: Throwable -> L14 Exception -> L16
        this.f456193oc = r101;     // Catch: Throwable -> L14 Exception -> L16
        r101.setUseCaches(false);     // Catch: Throwable -> L14 Exception -> L16
        this.f456193oc.setConnectTimeout(4000);     // Catch: Throwable -> L14 Exception -> L16
        RXLogging.e(TAG, "connect done....");     // Catch: Throwable -> L14 Exception -> L16
        int r102 = this.f456193oc.getResponseCode();     // Catch: Throwable -> L14 Exception -> L16
        if (200 != r102) goto L6;
        boolean r103 = true;
    L7:
        InputStream r104 = this.f456193oc.getInputStream();     // Catch: Throwable -> L14 Exception -> L16
        if (r104 == null) goto L10;
        r104.close();     // Catch: Throwable -> L14 Exception -> L16
    L10:
        HttpURLConnection r105 = this.f456193oc;
        if (r105 == null) goto L29;
        r105.disconnect();
    L29:
        return r103;
    L6:
        RXLogging.e(TAG, "url is not available, error:" + r102);     // Catch: Throwable -> L14 Exception -> L16
        r103 = false;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        RXLogging.e(TAG, "++Error when test online url: " + e.getMessage());     // Catch: Throwable -> L14
        HttpURLConnection r106 = this.f456193oc;
        if (r106 == null) goto L30;
        r106.disconnect();
        return false;
    L30:
        return false;
    L14:
        th = move-exception;
        HttpURLConnection r107 = this.f456193oc;
        if (r107 == null) goto L25;
        r107.disconnect();
    L25:
        throw th;
    }

    public boolean selectTrack(int r100) {
        Vector<Integer> r101 = this.mTrackIds;     // Catch: Exception -> L25
        if (r101 != null) goto L7;
        return false;
    L7:
        if ((r100 + 1) <= r101.size()) goto L10;
        return false;
    L10:
        if (this.mUsedTrackIdx != r100) goto L12;
        return false;
    L12:
        MediaExtractor r102 = this.mExtractor;     // Catch: Exception -> L25
        if (r102 != null) goto L15;
    L23:
        RXLogging.e(TAG, "mExtractor or mMediaCodec is null, mExtractor = " + this.mExtractor + ", mMediaCodec = " + this.mMediaCodec);     // Catch: Exception -> L25
        return false;
    L15:
        if (this.mMediaCodec == null) goto L23;
        MediaFormat r103 = r102.getTrackFormat(this.mTrackIds.get(r100).intValue());     // Catch: Exception -> L25
        if (this.mSampleRate == r103.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE)) goto L21;
        RXLogging.e(TAG, "mSampleRate = " + this.mSampleRate + ", used_SampleRate = " + r103.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE));     // Catch: Exception -> L25
        return false;
    L21:
        long r104 = this.mExtractor.getSampleTime();     // Catch: Exception -> L25
        RXLogging.e(TAG, "++current_postion = " + r104);     // Catch: Exception -> L25
        this.mExtractor.unselectTrack(this.mTrackIds.get(this.mUsedTrackIdx).intValue());     // Catch: Exception -> L25
        this.mMediaCodec.stop();     // Catch: Exception -> L25
        r103.getString("mime");     // Catch: Exception -> L25
        this.mExtractor.selectTrack(this.mTrackIds.get(r100).intValue());     // Catch: Exception -> L25
        this.mExtractor.seekTo(r104, 2);     // Catch: Exception -> L25
        this.mMediaCodec.configure(r103, null, null, 0);     // Catch: Exception -> L25
        this.mMediaCodec.start();     // Catch: Exception -> L25
        this.mUsedTrackFormat = r103;     // Catch: Exception -> L25
        this.mUsedTrackIdx = r100;     // Catch: Exception -> L25
        return true;
    L25:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when selectTrack");
        return false;
    }

    public void setCurrentFilePosition(long r100) {
        if (this.eoOutputStream == false) goto L15;
        this.mMediaCodec.flush();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when setCurrentFilePosition, mMediaCodec.flush");
    L15:
        this.mExtractor.seekTo(r100 * 1000, 2);     // Catch: Exception -> L10
        this.eoInputStream = false;     // Catch: Exception -> L10
        this.eoOutputStream = false;     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when setCurrentFilePosition, mExtractor.seekTo");
    }

    public boolean init(String r110, int r111) {
        RXLogging.i(TAG, "Try to decode audio file : " + r110);     // Catch: Exception -> L45
        this.mTrackIds = new Vector();     // Catch: Exception -> L45
        if (URLUtil.isNetworkUrl(r110) == true) goto L6;
    L13:
        this.mRetryCount = 0;     // Catch: Exception -> L45
        this.mExtractor = new MediaExtractor();     // Catch: Exception -> L45
        Context r100 = ContextUtils.getApplicationContext();     // Catch: Exception -> L45
        if (r110.startsWith("/assets/") == false) goto L18;
        if (r100 == null) goto L18;
        AssetFileDescriptor r112 = r100.getAssets().openFd(r110.substring(8));     // Catch: Exception -> L45
        this.mExtractor.setDataSource(r112.getFileDescriptor(), r112.getStartOffset(), r112.getLength());     // Catch: Exception -> L45
    L22:
        int r113 = this.mExtractor.getTrackCount();     // Catch: Exception -> L45
        int r101 = 0;
    L23:
        if (r101 >= r113) goto L26;
        this.mExtractor.unselectTrack(r101);     // Catch: Exception -> L45
        r101 = r101 + 1;     // Catch: Exception -> L45
        goto L23
    L26:
        if ((r111 + 1) <= r113) goto L29;
        RXLogging.e(TAG, "useTrack > trackCount");     // Catch: Exception -> L45
        return false;
    L29:
        this.mChannels = 0;     // Catch: Exception -> L45
        int r102 = 0;
        int r103 = 0;
    L30:
        if (r102 >= r113) goto L39;
        MediaFormat r104 = this.mExtractor.getTrackFormat(r102);     // Catch: Exception -> L45
        String r105 = r104.getString("mime");     // Catch: Exception -> L45
        if (r105.contains("audio/") == false) goto L38;
        if (r111 != r103) goto L35;
        this.mExtractor.selectTrack(r102);     // Catch: Exception -> L45
        MediaCodec r106 = MediaCodec.createDecoderByType(r105);     // Catch: Exception -> L45
        this.mMediaCodec = r106;     // Catch: Exception -> L45
        r106.configure(r104, null, null, 0);     // Catch: Exception -> L45
        this.mUsedTrackFormat = r104;     // Catch: Exception -> L45
        this.mUsedTrackIdx = r103;     // Catch: Exception -> L45
    L35:
        r103 = r103 + 1;     // Catch: Exception -> L45
        this.mTrackIds.addElement(new Integer(r102));     // Catch: Exception -> L45
        int r107 = r104.getInteger(com.ss.ttm.player.MediaFormat.KEY_CHANNEL_COUNT);     // Catch: Exception -> L45
        if (r107 <= this.mChannels) goto L38;
        this.mChannels = r107;     // Catch: Exception -> L45
    L38:
        r102 = r102 + 1;     // Catch: Exception -> L45
        goto L30
    L39:
        MediaCodec r114 = this.mMediaCodec;     // Catch: Exception -> L45
        if (r114 == null) goto L43;
        r114.start();     // Catch: Exception -> L45
        this.mSampleRate = this.mUsedTrackFormat.getInteger(com.ss.ttm.player.MediaFormat.KEY_SAMPLE_RATE);     // Catch: Exception -> L45
        this.mFileLength = this.mUsedTrackFormat.getLong("durationUs");     // Catch: Exception -> L45
        return true;
    L43:
        RXLogging.e(TAG, "mMediaCodec is null");     // Catch: Exception -> L45
        return false;
    L18:
        if (r110.startsWith("content://") == false) goto L21;
        if (r100 == null) goto L21;
        this.mExtractor.setDataSource(com_ss_bytertc_engine_RtcAudioFileDecoder_android_content_ContentResolver_openFileDescriptor(r100.getContentResolver(), UriProtector.parse(r110), "r").getFileDescriptor());     // Catch: Exception -> L45
    L21:
        this.mExtractor.setDataSource(r110);     // Catch: Exception -> L45
        goto L22
    L6:
        if (checkUrlEncoded(r110) == true) goto L9;
        r110 = encodeUrl(r110);     // Catch: Exception -> L45
    L9:
        if (r110 != null) goto L11;
    L12:
        return false;
    L11:
        if (isAvailableOnlineURL(r110) == true) goto L13;
    L45:
        e = move-exception;
        e.printStackTrace();
        RXLogging.e(TAG, "Error when creating audio file decode, error:" + e.getMessage());
        RXLogging.e(TAG, "stack track: " + Log.getStackTraceString(e));
        return false;
    }

    private static ParcelFileDescriptor com_ss_bytertc_engine_RtcAudioFileDecoder_android_content_ContentResolver_openFileDescriptor(ContentResolver r110, Uri r111, String r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        b r112 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r110, r101, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r110, r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }
}
