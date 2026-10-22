package nd7;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.cn.auth.PermissionConfigV2Parser;
import com.bytedance.sdk.xbridge.cn.auth.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import ld7.f;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends nd7.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<Class<? extends nd7.a>> f518799f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<Class<? extends nd7.a>> f518800g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<nd7.a> f518801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f518802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.sdk.xbridge.cn.auth.c.a f518803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f518804e;

    public static final class a {
        public static d a(boolean r100, g r101, boolean r102, com.bytedance.sdk.xbridge.cn.auth.c.a r103) {
            Intrinsics.checkNotNullParameter(r101, "permissionConfigProvider");
            pd7.a.f528685a = r101;
            if (r100 == false) goto L5;
            List<Class<? extends nd7.a>> r104 = d.f518800g;
        L6:
            List<Class<? extends nd7.a>> r105 = r104;
            ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator<T> r107 = r105.iterator();
        L8:
            if (r107.hasNext() == false) goto L11;
            nd7.a r108 = (nd7.a) ((Class) r107.next()).newInstance();
            r108.c(r101);
            r106.add(r108);
            goto L8
        L11:
            return new d(r106, r101, r102, r103);
        L5:
            r104 = d.f518799f;
            goto L6
        }
    }

    @Override // nd7.a
    public final void c(g r100) {
    }

    static {
        f518799f = CollectionsKt.mutableListOf(new Class[]{c.class, b.class});
        f518800g = CollectionsKt.mutableListOf(new Class[]{e.class, c.class, b.class});
    }

    @Override // nd7.a
    public final JSONObject b() {
        Iterator<nd7.a> r100 = this.f518801b.iterator();     // Catch: Throwable -> L24
    L5:
        if (r100.hasNext() == false) goto L13;
        nd7.a r101 = r100.next();     // Catch: Throwable -> L24
        JSONObject r102 = r101.b();     // Catch: Throwable -> L24
        HybridLogger r103 = HybridLogger.f246343a;     // Catch: Throwable -> L24
        StringBuilder r104 = new StringBuilder();     // Catch: Throwable -> L24
        r104.append("loaderList size:");     // Catch: Throwable -> L24
        r104.append(this.f518801b.size());     // Catch: Throwable -> L24
        r104.append(" loader=");     // Catch: Throwable -> L24
        r104.append(r101.a());     // Catch: Throwable -> L24
        r104.append(" resp==null: ");     // Catch: Throwable -> L24
        if (r102 != null) goto L9;
        boolean r105 = true;
    L10:
        r104.append(r105);     // Catch: Throwable -> L24
        HybridLogger.m("PermissionConfigLoaderChain", r104.toString(), null, null, 12);     // Catch: Throwable -> L24
        if (r102 == null) goto L5;
        String r106 = r101.a();     // Catch: Throwable -> L24
    L14:
        if (r102 == null) goto L22;
        g r107 = pd7.a.f528685a;     // Catch: Throwable -> L24
        g r108 = pd7.b.f528686a;     // Catch: Throwable -> L24
        pd7.b.f528686a = pd7.a.f528685a;     // Catch: Throwable -> L24
        g r109 = pd7.a.f528685a;     // Catch: Throwable -> L24
        if (r109 == null) goto L18;
        String r110 = r109.d();     // Catch: Throwable -> L24
    L19:
        ConcurrentHashMap<String, f> r111 = PermissionConfigV2Parser.f269801a;     // Catch: Throwable -> L24
        PermissionConfigV2Parser.h(r102, r110, this.f518802c, r106);     // Catch: Throwable -> L24
        com.bytedance.ies.argus.api.d.f245634a.getClass();     // Catch: Throwable -> L24
        com.bytedance.ies.argus.api.d.b();     // Catch: Throwable -> L24
        com.bytedance.sdk.xbridge.cn.auth.c.a r112 = this.f518803d;     // Catch: Throwable -> L24
        if (r112 == null) goto L29;
        r112.onSuccess();     // Catch: Throwable -> L24
    L29:
        return null;
    L18:
        r110 = null;
        goto L19
    L22:
        HybridLogger.m("PermissionConfigLoaderChain", "finalResp is null", null, null, 12);     // Catch: Throwable -> L24
        goto L29
    L9:
        r105 = false;
        goto L10
    L13:
        r106 = null;
        r102 = null;
    L24:
        th = move-exception;
        HybridLogger r113 = HybridLogger.f246343a;
        String r114 = th.getMessage();
        if (r114 != null) goto L28;
        r114 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
    L28:
        HybridLogger.m("PermissionConfigLoaderChain", "load error, e=".concat(r114), null, null, 12);
        goto L29
    }

    @Override // nd7.a
    public final String a() {
        return this.f518804e;
    }

    public d(List r100, g r101, boolean r102, com.bytedance.sdk.xbridge.cn.auth.c.a r103) {
        this.f518801b = r100;
        this.f518802c = r102;
        this.f518803d = r103;
        this.f518804e = "PermissionConfigLoaderChain";
    }
}
