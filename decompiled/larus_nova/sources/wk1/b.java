package wk1;

import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.ttvideoengine.model.VideoRef;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import xk1.i;
import xk1.l;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements lm1.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, VideoRef> f560072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f560073b = null;

    public static final class a implements js0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f560074a;

        public a(String r100) {
            this.f560074a = r100;
        }

        @Override // js0.b
        public final void onSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TRACK);
            i r101 = i.f();
            String r102 = this.f560074a;
            r101.getClass();
            l r103 = new l(r101, r102);
            r101.d();
            r103.run();
        }
    }

    public b() {
    }

    static {
        f560073b = new b();
        f560072a = new HashMap();
    }

    public static List c() {
        LivePluginSPIManager.f85856e.getClass();
        if (LivePluginSPIManager.b() == true) goto L5;
    L8:
        i r100 = i.f();
        r100.getClass();
        ArrayList r101 = new ArrayList();
        r100.d();
        ArrayList r102 = new ArrayList();
    L41:
        e = move-exception;
        ALogger.e("DownloadManager", e);
    L43:
        return r101;
    L10:
        if (r100.f564145a.values().size() <= 0) goto L32;
        Iterator<tp1.a> r103 = r100.f564145a.values().iterator();     // Catch: Exception -> L41
    L13:
        if (r103.hasNext() == false) goto L32;
        tp1.a r104 = r103.next();     // Catch: Exception -> L41
        if (r104 == null) goto L27;
        tp1.b r105 = r104.f547013n;     // Catch: Exception -> L41
        if (r105.f547020c == 3) goto L20;
    L22:
        String r106 = r100.g(r104.f547000a);     // Catch: Exception -> L41
        if (TextUtils.isEmpty(r106) == true) goto L27;
        if (new PolarisFileWrapper(r106).exists() == false) goto L27;
    L26:
        boolean r107 = true;
    L28:
        if (r107 == true) goto L29;
        r102.add(r104);     // Catch: Exception -> L41
        goto L13
    L29:
        r101.add(r104);     // Catch: Exception -> L41
        goto L13
    L20:
        if (r105.f547018a != 0) goto L22;
    L27:
        r107 = false;
    L32:
        if (r102.size() <= 0) goto L43;
        Iterator r108 = r102.iterator();     // Catch: Exception -> L41
    L34:
        if (r108.hasNext() == false) goto L43;
        tp1.a r109 = (tp1.a) r108.next();     // Catch: Exception -> L41
        String r110 = r109.f547000a;     // Catch: Exception -> L41
        if (r100.f564145a.containsKey(r110) == false) goto L39;
        r100.f564147c.d(r110);     // Catch: Exception -> L41
    L39:
        r100.f564145a.remove(r109.f547000a);     // Catch: Exception -> L41
        tp1.a.delete("video_id=?", new String[]{r109.f547000a});     // Catch: Exception -> L41
        goto L34
    L5:
        if (LivePluginSPIManager.c() == true) goto L8;
        LivePluginSPIManager.a().requireByUser("VSCacheDataManager");
        return null;
    }

    @Override // lm1.a
    public final long getCacheSize() {
        List r100 = c();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return ((ArrayList) r100).size();
    }

    @Override // lm1.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "videoId");
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new a(r100)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("VSCacheDataManager");
    }

    @Override // lm1.a
    public final Boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "videoId");
        LivePluginSPIManager.f85856e.getClass();
        tp1.a r101 = null;
        if (LivePluginSPIManager.b() == true) goto L5;
    L8:
        i r102 = i.f();
        r102.d();
        if (r102.f564145a == null) goto L12;
        r101 = r102.f564145a.get(r100);
    L12:
        if (r101 == null) goto L16;
        boolean r103 = true;
        if (r101.f547012m != 1) goto L16;
    L18:
        return Boolean.valueOf(r103);
    L16:
        r103 = false;
        goto L18
    L5:
        if (LivePluginSPIManager.c() == true) goto L8;
        LivePluginSPIManager.a().requireByUser("VSCacheDataManager");
        return null;
    }

    @Override // lm1.a
    public final String getCachedVideoId(long r100) {
        LivePluginSPIManager.f85856e.getClass();
        if (LivePluginSPIManager.b() == true) goto L5;
    L8:
        i r101 = i.f();
        r101.d();
        if (r101.f564145a == null) goto L17;
        Iterator<Map.Entry<String, tp1.a>> r102 = r101.f564145a.entrySet().iterator();
    L13:
        if (r102.hasNext() == false) goto L17;
        Map.Entry<String, tp1.a> r103 = r102.next();
        if (r103.getValue().f547011l != r100) goto L13;
        tp1.a r104 = r103.getValue();
    L18:
        if (r104 != null) goto L21;
        return null;
    L21:
        return r104.f547000a;
    L17:
        r104 = null;
        goto L18
    L5:
        if (LivePluginSPIManager.c() == true) goto L8;
        LivePluginSPIManager.a().requireByUser("VSCacheDataManager");
        return null;
    }

    @Override // lm1.a
    public final Map<String, Pair<String, String>> getLocalVideoPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "videoId");
        LivePluginSPIManager.f85856e.getClass();
        String r101 = null;
        if (LivePluginSPIManager.b() == true) goto L5;
    L8:
        String r102 = i.f().e(r100);
        if (r102 != null) goto L11;
    L14:
        boolean r103 = true;
    L15:
        if (r103 == false) goto L18;
        return null;
    L18:
        if (new PolarisFileWrapper(r102).exists() == false) goto L29;
        HashMap r104 = new HashMap();
        i r105 = i.f();
        r105.d();
        if (r105.f564145a != null) goto L22;
        tp1.a r106 = null;
    L23:
        if (r106 == null) goto L25;
        r101 = r106.f547007h;
    L25:
        if (r101 == null) goto L28;
        r104.put(r101, TuplesKt.to(r106.f547013n.f547023f, r102));
    L28:
        return r104;
    L22:
        r106 = r105.f564145a.get(r100);
        goto L23
    L29:
        return null;
    L11:
        if (r102.length() == 0) goto L14;
        r103 = false;
        goto L15
    L5:
        if (LivePluginSPIManager.c() == true) goto L8;
        LivePluginSPIManager.a().requireByUser("VSCacheDataManager");
        return null;
    }
}
