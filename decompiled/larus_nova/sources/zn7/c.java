package zn7;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ug.sdk.share.impl.manager.h;
import com.bytedance.ug.sdk.share.impl.manager.j;
import com.larus.apm.impl.protector.RunnableProtector;
import com.mammon.speechaudiosdk.session.type.SpeechCode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import oo7.f;
import oo7.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f572935b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f572936c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f572937a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ug.sdk.share.impl.model.a f572938a;

        public final void a() {
            ko7.c r100 = ko7.c.b.f504529a;
            String r101 = this.f572938a.f272357a;
            k.e("TokenParseManager", "deal with qrscan result");
            if (TextUtils.isEmpty(r101) == true) goto L9;
            eo7.a r102 = eo7.a.b.f473353a;
            if (ko7.c.b(r101, 3) == true) goto L10;
            r100.f504526a = true;
            new Handler(Looper.getMainLooper()).post(new ko7.d(r101));
            r100.f504526a = false;
            return;
        L10:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(com.bytedance.ug.sdk.share.impl.model.a r100) {
            this.f572938a = r100;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f572939a = null;

        static {
            f572939a = new c();
        }
    }

    static {
        f572935b = new AtomicBoolean(true);
        f572936c = new AtomicBoolean(false);
    }

    public c() {
        Context r100 = h.g.f272345a.f272326a;
        this.f572937a = r100;
        if (r100 != null) goto L5;
        k.c("ImageCheckerManager", "tryRegisterContentObserver() mContext is null, return");
        return;
    L5:
        ContentResolver r101 = r100.getContentResolver();
        if (r101 != null) goto L8;
        k.c("ImageCheckerManager", "tryRegisterContentObserver() mContentResolver is null, return");
        return;
    L8:
        d r102 = new d(Looper.getMainLooper());
        r101.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, new e(r102));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        k.c("ImageCheckerManager", th.getLocalizedMessage());
        th.printStackTrace();
    }

    public static com.bytedance.ug.sdk.share.impl.model.a c(String r210) {
        if (TextUtils.isEmpty(r210) == true) goto L190;
        boolean r100 = true;
        boolean r101 = false;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r210);     // Catch: Exception -> L10
        if (r102.exists() == false) goto L12;
        if (new PolarisFileInputStreamWrapper(r102).available() >= ((Integer) eo7.a.b.f473353a.c("media_parse_max_size", Integer.valueOf(BmLocated.ALIGN_RIGHT_BOTTOM))).intValue()) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L16;
        return null;
    L16:
        if (r210 != null) goto L18;
    L24:
        boolean r104 = false;
    L26:
        if (r104 == false) goto L111;
        k.e("ImageCheckerManager", "read image path : " + r210);
        eo7.a r105 = eo7.a.b.f473353a;
        if (r105.f473344r == true) goto L30;
        boolean r106 = false;
    L31:
        if (r106 == false) goto L33;
    L39:
        boolean r107 = true;
    L40:
        if (r107 == true) goto L42;
    L90:
        String r108 = "";
    L92:
        if (TextUtils.isEmpty(r108) == true) goto L95;
        k.e("ImageCheckerManager", "image token hidden str : " + r108);
        JSONObject r109 = new JSONObject();
        go7.b.a(r109);
        oo7.c.a("ug_sdk_share_hidden_interface_read", r109);
        return new com.bytedance.ug.sdk.share.impl.model.a("", r108, false);
    L95:
        eo7.a r110 = eo7.a.b.f473353a;
        if (r110.f473343q == true) goto L98;
    L100:
        r100 = false;
    L101:
        if (r100 == false) goto L106;
        k.e("ImageCheckerManager", "read image qrcode");
        if (eo7.a.g() == null) goto L105;
        String r111 = eo7.a.g().a();
    L108:
        if (TextUtils.isEmpty(r111) == true) goto L188;
        k.e("ImageCheckerManager", "image token qrscan str : " + r111);
        JSONObject r112 = new JSONObject();
        go7.b.a(r112);
        oo7.c.a("ug_sdk_share_qrcode_interface_read", r112);
        return new com.bytedance.ug.sdk.share.impl.model.a(r111, "", false);
    L188:
        return null;
    L105:
        k.e("ShareConfigManager", "getQrDecodeStr() is null");
        r111 = null;
        goto L108
    L106:
        r111 = "";
        goto L108
    L98:
        if (((Boolean) r110.c("enable_qrcode_parse", Boolean.TRUE)).booleanValue() == false) goto L100;
    L42:
        if (TextUtils.isEmpty(r210) == true) goto L84;
        PolarisFileWrapper r113 = new PolarisFileWrapper(r210);
        if (r113.exists() == false) goto L84;
    L82:
        e = move-exception;
        e.printStackTrace();
        goto L84
    L48:
        if (Build.VERSION.SDK_INT < 29) goto L51;
        Bitmap r114 = f.d(r210);     // Catch: Exception -> L82
    L52:
        if (r114 == null) goto L198;
    L85:
        if (r114 == null) goto L90;
        k.e("ImageCheckerManager", "read image hidden mark");
        Class r115 = zn7.a.a();     // Catch: Throwable -> L89
        r108 = (String) r115.getDeclaredMethod("getHiddenString", new Class[]{Bitmap.class}).invoke(r115, new Object[]{r114});     // Catch: Throwable -> L89
    L89:
        r108 = null;
        goto L92
    L198:
        PolarisFileInputStreamWrapper r116 = new PolarisFileInputStreamWrapper(r113);     // Catch: Throwable -> L63
        Bitmap r117 = BitmapFactory.decodeStream(r116);     // Catch: Throwable -> L61
        r116.close();     // Catch: Exception -> L57
    L60:
        r114 = r117;
        goto L85
    L57:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L82
    L61:
        th = th;
    L213:
        th.printStackTrace();     // Catch: Throwable -> L73
        if (r116 == null) goto L84;
        r116.close();     // Catch: Exception -> L69
    L69:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L82
        goto L84
    L73:
        th = move-exception;
        if (r116 == null) goto L222;
        r116.close();     // Catch: Exception -> L78
    L223:
        throw th;     // Catch: Exception -> L82
    L78:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L82
        throw th;     // Catch: Exception -> L82
    L222:
        throw th;     // Catch: Exception -> L82
    L63:
        th = th;
        r116 = null;
        goto L213
    L51:
        r114 = null;
    L84:
        r114 = null;
        goto L85
    L33:
        if (r105.f473344r == true) goto L35;
        boolean r118 = false;
    L36:
        if (r118 == true) goto L39;
        r107 = false;
        goto L40
    L35:
        r118 = ((Boolean) r105.c("enable_long_image_hidden_watermark", Boolean.FALSE)).booleanValue();
        goto L36
    L30:
        r106 = ((Boolean) r105.c("enable_hidden_watermark", Boolean.TRUE)).booleanValue();
        goto L31
    L111:
        k.e("ImageCheckerManager", "read video path : " + r210);
        eo7.a r119 = eo7.a.b.f473353a;
        if (r119.f473347u == true) goto L114;
    L116:
        boolean r120 = false;
    L117:
        if (r120 == false) goto L169;
        k.e("ImageCheckerManager", "read video qrcode");
        if (TextUtils.isEmpty(r210) == false) goto L121;
    L161:
        k.e("ImageCheckerManager", "deCodeImgFromVideo failed");
    L162:
        String r121 = "";
    L164:
        if (TextUtils.isEmpty(r121) == true) goto L169;
        eo7.a r122 = eo7.a.b.f473353a;
        if (eo7.a.g() == null) goto L168;
        String r123 = eo7.a.g().a();
    L171:
        if (TextUtils.isEmpty(r123) == true) goto L174;
        k.e("ImageCheckerManager", "video token qrscan str : " + r123);
        JSONObject r124 = new JSONObject();
        go7.b.a(r124);
        oo7.c.a("ug_sdk_share_qrcode_interface_read", r124);
        return new com.bytedance.ug.sdk.share.impl.model.a(r123, "", true);
    L174:
        eo7.a r125 = eo7.a.b.f473353a;
        if (r125.f473346t == false) goto L178;
        r101 = ((Boolean) r125.c("enable_video_hidden_watermark", Boolean.TRUE)).booleanValue();
    L178:
        if (r101 == false) goto L183;
        k.e("ImageCheckerManager", "read video hidden mark");
        if (eo7.a.i() == null) goto L182;
        String r126 = eo7.a.i().a();
    L185:
        if (TextUtils.isEmpty(r126) == true) goto L225;
        k.e("ImageCheckerManager", "video token hidden str : " + r126);
        JSONObject r127 = new JSONObject();
        go7.b.a(r127);
        oo7.c.a("ug_sdk_share_hidden_interface_read", r127);
        return new com.bytedance.ug.sdk.share.impl.model.a("", r126, true);
    L225:
        return null;
    L182:
        k.e("ShareConfigManager", "getVideoWatermarkConfig() is null");
        r126 = null;
        goto L185
    L183:
        r126 = "";
        goto L185
    L168:
        k.e("ShareConfigManager", "getQrDecodeStr() is null");
        r123 = null;
        goto L171
    L121:
        if (new PolarisFileWrapper(r210).exists() == false) goto L162;
        MediaMetadataRetriever r128 = new MediaMetadataRetriever();
        r128.setDataSource(r210);     // Catch: Throwable -> L148 Exception -> L150
        if (Build.VERSION.SDK_INT >= 28) goto L216;
    L135:
        Bitmap r129 = null;
    L136:
        if (r129 != null) goto L142;
        k.e("ImageCheckerManager", "MediaMetadataRetriever getFrameAtTime()");     // Catch: Throwable -> L148 Exception -> L150
        long r130 = Long.parseLong(b(r128, 9));     // Catch: Throwable -> L148 Exception -> L150
        long r131 = r130;
    L138:
        if (r129 != null) goto L142;
        if ((r130 - r131) > 120) goto L142;
        r129 = r128.getFrameAtTime(1000 * r131, 2);     // Catch: Throwable -> L148 Exception -> L150
        r131 = r131 - 40;     // Catch: Throwable -> L148 Exception -> L150
    L142:
        if (r129 == null) goto L194;
        k.e("ImageCheckerManager", "deCodeImgFromVideo succeed");     // Catch: Throwable -> L148 Exception -> L150
        String r132 = f.f();     // Catch: Throwable -> L148 Exception -> L150
        String r133 = "decode_image_" + System.currentTimeMillis() + ".jpeg";     // Catch: Throwable -> L148 Exception -> L150
        f.h(r129, r132, r133);     // Catch: Throwable -> L148 Exception -> L150
        r129.recycle();     // Catch: Throwable -> L148 Exception -> L150
        r121 = r132 + File.separator + r133;     // Catch: Throwable -> L148 Exception -> L150
    L209:
        r128.release();     // Catch: IOException -> L146
    L146:
        e = move-exception;
        k.d("ImageCheckerManager", "media release error", e);
    L194:
        r128.release();     // Catch: IOException -> L154
    L154:
        e = move-exception;
        k.d("ImageCheckerManager", "media release error", e);
        goto L161
    L216:
        k.e("ImageCheckerManager", "MediaMetadataRetriever getFrameAtIndex()");     // Catch: Exception -> L133 Throwable -> L148
        int r134 = Integer.parseInt(b(r128, 32));     // Catch: Exception -> L133 Throwable -> L148
        if (r134 <= 0) goto L130;
        int r135 = r134 - 1;     // Catch: Exception -> L133 Throwable -> L148
    L131:
        r129 = r128.getFrameAtIndex(r135);     // Catch: Exception -> L133 Throwable -> L148
        goto L136
    L130:
        r135 = 0;
    L133:
        e = move-exception;
        k.e("ImageCheckerManager", "getFrameAtIndex failed, " + e.toString());     // Catch: Throwable -> L148 Exception -> L150
    L150:
        e = move-exception;
        k.d("ImageCheckerManager", "error", e);     // Catch: Throwable -> L148
    L148:
        th = move-exception;
        r128.release();     // Catch: IOException -> L158
        throw th;
    L158:
        e = move-exception;
        k.d("ImageCheckerManager", "media release error", e);
        throw th;
    L169:
        r123 = "";
        goto L171
    L114:
        if (((Boolean) r119.c("enable_video_qrcode_parse", Boolean.TRUE)).booleanValue() == false) goto L116;
        r120 = true;
        goto L117
    L18:
        if (r210.endsWith(".jpeg") == false) goto L20;
    L23:
        r104 = true;
        goto L26
    L20:
        if (r210.endsWith(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == true) goto L23;
        if (r210.endsWith(".jpg") == false) goto L24;
    L12:
        r103 = false;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L190:
        return null;
    }

    public static void d(com.bytedance.ug.sdk.share.impl.model.a r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r100.f272357a) == true) goto L7;
        String r101 = r100.f272357a;
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L13;
        return;
    L13:
        if (TextUtils.isEmpty(r100.f272357a) == true) goto L16;
        new Handler(Looper.getMainLooper()).post(new a(r100));
    L22:
        j.c.f272350a.getClass();
        return;
    L16:
        if (TextUtils.isEmpty(r100.f272358b) == true) goto L22;
        ko7.c r102 = ko7.c.b.f504529a;
        String r103 = r100.f272358b;
        if (r100.f272359c == false) goto L20;
        int r104 = 2;
    L21:
        r102.c(r103, r104);
        goto L22
    L20:
        r104 = 1;
        goto L21
    L7:
        if (TextUtils.isEmpty(r100.f272358b) == true) goto L9;
        r101 = r100.f272358b;
        goto L11
    L9:
        r101 = "";
        goto L11
    }

    public static String b(MediaMetadataRetriever r110, int r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {Integer.valueOf(r111)};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(Integer.valueOf(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE));
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
        f06.d r107 = r106.preInvoke(SpeechCode.SPEECH_TOKEN_NOT_SUPPORT_ONLINE, "android/media/MediaMetadataRetriever", "extractMetadata", r110, r101, "java.lang.String", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (String) r107.f474983b;
    L21:
        return r110.extractMetadata(r111);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, String r210, String[] r211) {
        f06.c r113 = new f06.c();
        Object[] r114 = {r111, r112, r210, r211, "date_added DESC"};
        f06.b r115 = new f06.b();
        f06.d r100 = r113.b(240004, "android/content/ContentResolver", "query", r110, r114, "android.database.Cursor", r115);
        if (r100.f474982a == false) goto L6;
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, null, r115, false);
        return (Cursor) r100.f474983b;
    L6:
        Cursor r101 = r110.query(r111, r112, r210, r211, "date_added DESC");
        r113.a(240004, "android/content/ContentResolver", "query", r110, r114, r101, r115, true);
        return r101;
    }
}
