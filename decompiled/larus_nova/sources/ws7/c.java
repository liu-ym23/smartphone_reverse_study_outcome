package ws7;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Base64;
import androidx.camera.video.AudioStats;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.config.FaceConfig;
import com.dtf.face.config.GuideConfig;
import com.dtf.face.ui.overlay.CommAlertOverlay;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static FaceConfig f561062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static GuideConfig f561063b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f561064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f561065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f561066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f561067d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f561068e;

        public a() {
            this.f561064a = 1;
            this.f561065b = 1;
            this.f561066c = 1;
            this.f561067d = 1;
            this.f561068e = 0.25f;
        }
    }

    static {
        f561062a = new FaceConfig();
        f561063b = new GuideConfig();
        new JSONObject();
        new JSONObject();
    }

    public static void a(CommAlertOverlay r100, a r101) {
        int r102 = r101.f561064a;
        if (1 == r102) goto L5;
        r100.setTitleColor(r102);
    L5:
        int r103 = r101.f561065b;
        if (1 == r103) goto L8;
        r100.setMsgColor(r103);
    L8:
        int r104 = r101.f561066c;
        if (1 == r104) goto L11;
        r100.setConfirmColor(r104);
    L11:
        int r105 = r101.f561067d;
        if (1 == r105) goto L14;
        r100.setCancelColor(r105);
    L14:
        r100.setBackgroundShadowAlpha(r101.f561068e);
    }

    public static Bitmap b(String r100, String r101) {
        Bitmap r102 = null;
        if (TextUtils.isEmpty(r100) == true) goto L11;
        String[] r103 = r100.split(",");
        if (r103.length <= 1) goto L23;
        r100 = r103[1];
    L23:
        byte[] r104 = Base64.decode(r100, 0);     // Catch: Throwable -> L10
        r102 = BitmapFactory.decodeByteArray(r104, 0, r104.length);     // Catch: Throwable -> L10
    L11:
        if (r102 == null) goto L13;
        return r102;
    L13:
        if (TextUtils.isEmpty(r101) == true) goto L26;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r101);     // Catch: Exception -> L20
        if (r105.exists() == false) goto L17;
        InputStream r106 = new PolarisFileInputStreamWrapper(r105);     // Catch: Exception -> L20
    L18:
        return BitmapFactory.decodeStream(r106);
    L17:
        r106 = hs7.a.h().getContext().getAssets().open(r101);     // Catch: Exception -> L20
    L27:
        return r102;
    L26:
        return r102;
    }

    public static List<String> c(List<String> r110, JSONObject r111, StringBuilder r112) {
        ArrayList r100 = new ArrayList();
        Iterator<String> r101 = r111.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L47;
        String r102 = r101.next();
        if (r110 != null) goto L8;
    L10:
        boolean r103 = false;
        if (r102.contains("Color") == false) goto L18;
        Color.parseColor(r111.getString(r102));     // Catch: Throwable -> L14
        boolean r104 = true;
    L15:
        if (r104 == true) goto L18;
        r100.add(r102);
    L14:
        r112.append(r102);
        r112.append("非法.\n");
        r104 = false;
    L18:
        if (r102.contains("Alpha") == false) goto L29;
        Double r105 = Double.valueOf(Double.parseDouble(r111.getString(r102)));     // Catch: Throwable -> L48
        if (r105.doubleValue() < AudioStats.AUDIO_AMPLITUDE_NONE) goto L25;
        if (r105.doubleValue() > 1.0d) goto L25;
        boolean r106 = true;
    L26:
        if (r106 == true) goto L29;
        r100.add(r102);
    L25:
        r112.append(r102);
        r112.append("非法.\n");
        r106 = false;
    L29:
        if (r102.contains("Base64") == false) goto L4;
        String r107 = r111.getString(r102);     // Catch: Throwable -> L43
        if (TextUtils.isEmpty(r107) == true) goto L44;
        if (r107.startsWith("data:image/jpeg;base64,") == true) goto L44;
        if (r107.startsWith("data:image/jpg;base64,") == true) goto L44;
        if (r107.startsWith("data:image/png;base64,") == true) goto L44;
        r112.append(r102);     // Catch: Throwable -> L43
        r112.append("图片base64格式不支持.\n");     // Catch: Throwable -> L43
    L45:
        if (r103 == true) goto L4;
        r100.add(r102);
    L44:
        r103 = true;
        goto L45
    L8:
        if (((ArrayList) r110).contains(r102) == true) goto L10;
        r112.append(r102 + "没有匹配.\n");
        goto L10
    L47:
        return r100;
    }
}
