package ws7;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.config.AndroidClientConfig;
import com.dtf.face.log.RecordService;
import com.dtf.face.network.APICallback;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.sva.sdk.controller.Global;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes22.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, CopyOnWriteArrayList<APICallback<String>>> f561081a = null;

    public static class a implements APICallback<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f561082a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ APICallback f561083b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f561084c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f561085d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ List f561086e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ boolean f561087f;

        @Override // com.dtf.face.network.APICallback
        public final void onSuccess(String r100) {
            String r101 = r100;
            if ("RAW".equals(this.f561082a[0]) == false) goto L7;
            APICallback r102 = this.f561083b;
            if (r102 == null) goto L9;
            r102.onSuccess(r101);
            return;
        L9:
            return;
        L7:
            o.c(this.f561084c, this.f561085d, this.f561086e, this.f561087f, this.f561083b);
        }

        @Override // com.dtf.face.network.APICallback
        public final void onError(String r100, String r101, String r102) {
            if (this.f561083b != null) goto L5;
            return;
        L5:
            if ("RAW".equals(this.f561082a[0]) == false) goto L7;
            this.f561083b.onSuccess("SUCCESS");
            return;
        L7:
            this.f561083b.onError(r100, r101, r102);
        }

        public a(String[] r100, APICallback r101, Context r102, List r103, List r104, boolean r105) {
            this.f561082a = r100;
            this.f561083b = r101;
            this.f561084c = r102;
            this.f561085d = r103;
            this.f561086e = r104;
            this.f561087f = r105;
        }
    }

    static {
        f561081a = new ConcurrentHashMap();
    }

    public o() {
    }

    public static void a(String r100) {
        monitor-enter(o.class);
        List r101 = (List) ((ConcurrentHashMap) f561081a).remove(r100);     // Catch: Throwable -> L12
        monitor-exit(o.class);     // Catch: Throwable -> L12
        if (r101 == null) goto L11;
        Iterator r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L18;
        ((APICallback) r102.next()).onSuccess("SUCCESS");
        goto L9
    L18:
        return;
    L11:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void e(Context r100) {
        RecordService.getInstance().recordEvent(4, "modelDownload", new String[]{"status", Global.RECORDING_TYPE_CLEAN});
        h.c("faceModelURL", null);
        String r101 = f(r100);
        if (TextUtils.isEmpty(r101) == true) goto L8;
        ArrayList r102 = (ArrayList) f.d(r101);
        if (r102.size() <= 0) goto L9;
        RecordService.getInstance().recordEvent(2, "modelDownload", new String[]{"deleteFailList", Arrays.toString(r102.toArray())});
        return;
    L9:
        return;
    }

    public static String f(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        File r101 = r100.getFilesDir();
        if (r101 == null) goto L8;
        String r102 = r101.getAbsolutePath();
    L9:
        if (r102 == null) goto L14;
        StringBuilder r103 = new StringBuilder();
        r103.append(r102);
        String r104 = File.separator;
        r103.append(r104);
        r103.append("dtf");
        r103.append(r104);
        r103.append(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        String r105 = r103.toString();
        PolarisFileWrapper r106 = new PolarisFileWrapper(r105);
        if (r106.exists() == true) goto L13;
        r106.mkdirs();
    L13:
        return r105;
    L14:
        return null;
    L8:
        r102 = null;
        goto L9
    }

    public static File d(Context r100, String r101, boolean r102) {
        String r103 = f(r100);
        if (TextUtils.isEmpty(r103) == true) goto L28;
        if (r101 != null) goto L7;
        if (r102 == false) goto L28;
    L7:
        File[] r104 = new PolarisFileWrapper(r103).listFiles();
        if (r104 == null) goto L28;
        if (r104.length <= 0) goto L28;
        int r105 = r104.length;
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L28;
        File r107 = r104[r106];
        if (r102 == true) goto L16;
    L19:
        boolean r108 = true;
    L20:
        if (r108 == false) goto L27;
        if (TextUtils.isEmpty(r101) == true) goto L23;
        if (r101.equals(i.e(r107.getAbsolutePath())) == false) goto L27;
        return r107;
    L23:
        return r107;
    L27:
        r106 = r106 + 1;
        goto L12
    L16:
        if (r107.getName().endsWith("_high") == true) goto L19;
        r108 = false;
    L28:
        return null;
    }

    public static void b(String r100, String r101, String r102, String r103) {
        monitor-enter(o.class);
        List r104 = (List) ((ConcurrentHashMap) f561081a).remove(r100);     // Catch: Throwable -> L12
        monitor-exit(o.class);     // Catch: Throwable -> L12
        if (r104 == null) goto L11;
        Iterator r105 = r104.iterator();
    L9:
        if (r105.hasNext() == false) goto L18;
        ((APICallback) r105.next()).onError(r101, r102, r103);
        goto L9
    L18:
        return;
    L11:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static void c(Context r110, List<String> r111, List<String> r112, boolean r113, APICallback<String> r114) {
        String[] r115 = new String[1];
        a r116 = new a(r115, r114, r110, r111, r112, r113);
        AssetFileDescriptor r100 = r110.getAssets().openFd(faceverify.q.ASSET_FACE);     // Catch: Throwable -> L88
        if (r100 == null) goto L7;
        r100.close();     // Catch: Throwable -> L85
    L6:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L24;
        r115[0] = "FACE";
        HashMap r103 = new HashMap();
        if (r111 != null) goto L21;
    L23:
        ts7.c.d(new k(r110, "FACE", r113, r103, r116));
        return;
    L21:
        if (r111.size() <= 0) goto L23;
        r103.put("fd4ddd72c85fd5fe2913be520df32ed0", r111);
        goto L23
    L24:
        AndroidClientConfig r104 = hs7.a.h().c();
        if (r104 != null) goto L27;
    L28:
        if (r113 == true) goto L96;
    L42:
        boolean r105 = false;
    L43:
        if (r105 == false) goto L51;
        r115[0] = "e047462a83518c799c4082850d19c250";
        HashMap r106 = new HashMap();
        if (r112 != null) goto L47;
    L49:
        ts7.c.d(new k(r110, "QUALITY", r113, r106, r116));
        return;
    L47:
        if (r112.size() <= 0) goto L49;
        r106.put("e047462a83518c799c4082850d19c250", r112);
        goto L49
    L51:
        if (r104 == null) goto L83;
        JSONObject r107 = r104.clientExtParams;
        if (r107 == null) goto L83;
        if (r107.containsKey("LV_FACE_MODEL") == false) goto L83;
        r115[0] = "RAW";
        JSONObject r108 = r104.clientExtParams.getJSONObject("LV_FACE_MODEL");
    L81:
        th = move-exception;
        RecordService.getInstance().recordException(th);
        r116.onSuccess("SUCCESS");
        return;
    L59:
        if (r108.getBooleanValue("disable") == false) goto L64;
        String r109 = f(r110);     // Catch: Throwable -> L81
        if (TextUtils.isEmpty(r109) == true) goto L63;
        f.b(new PolarisFileWrapper(r109), null, "_high");     // Catch: Throwable -> L81
    L63:
        r116.onSuccess("SUCCESS");     // Catch: Throwable -> L81
        return;
    L64:
        JSONArray r117 = r108.getJSONArray("urls");     // Catch: Throwable -> L81
        ArrayList r118 = new ArrayList();     // Catch: Throwable -> L81
        Iterator<Object> r119 = r117.iterator();     // Catch: Throwable -> L81
    L66:
        if (r119.hasNext() == false) goto L68;
        r118.add(r119.next().toString());     // Catch: Throwable -> L81
        goto L66
    L68:
        String r120 = r108.getString("md5");     // Catch: Throwable -> L81
        HashMap r121 = new HashMap();     // Catch: Throwable -> L81
        r121.put("urls", r118);     // Catch: Throwable -> L81
        r121.put("md5", r120);     // Catch: Throwable -> L81
        r121.put("fileName", r120 + "_high");     // Catch: Throwable -> L81
        File r122 = d(r110, null, true);     // Catch: Throwable -> L81
        if (r122 != null) goto L73;
    L79:
        ts7.c.d(new k(r110, "RAW", r113, r121, r116));     // Catch: Throwable -> L81
        return;
    L73:
        if (r120.equals(i.e(r122.getAbsolutePath())) == false) goto L76;
        r116.onSuccess("SUCCESS");     // Catch: Throwable -> L81
        return;
    L76:
        String r123 = f(r110);     // Catch: Throwable -> L81
        if (TextUtils.isEmpty(r123) == true) goto L79;
        f.b(new PolarisFileWrapper(r123), null, "_high");     // Catch: Throwable -> L81
    L83:
        r115[0] = "RAW";
        r116.onSuccess("SUCCESS");
        return;
    L96:
        AssetFileDescriptor r124 = r110.getAssets().openFd(faceverify.q.ASSET_QUALITY);     // Catch: Throwable -> L87
        if (r124 == null) goto L34;
        r124.close();     // Catch: Throwable -> L86
    L33:
        boolean r125 = true;
    L35:
        if (r125 == true) goto L42;
        if (d(r110, "e047462a83518c799c4082850d19c250", false) == null) goto L39;
        boolean r126 = true;
    L40:
        if (r126 == true) goto L42;
        r105 = true;
        goto L43
    L39:
        r126 = false;
    L34:
        r125 = false;
        goto L35
    L27:
        if (r104.enableQualityConfig() == true) goto L96;
    L11:
        if (d(r110, "fd4ddd72c85fd5fe2913be520df32ed0", false) == null) goto L13;
        boolean r127 = true;
    L14:
        if (r127 == true) goto L16;
        r102 = true;
        goto L17
    L13:
        r127 = false;
    L7:
        r101 = false;
        goto L9
    }
}
