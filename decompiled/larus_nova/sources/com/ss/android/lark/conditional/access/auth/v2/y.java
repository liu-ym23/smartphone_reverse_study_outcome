package com.ss.android.lark.conditional.access.auth.v2;

import androidx.room.util.TableInfo;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.utils.LarkContext;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.ss.android.lark.storage.kv.repo.a f417932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static com.ss.android.lark.storage.kv.repo.a f417933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static com.ss.android.lark.storage.kv.repo.a f417934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f417935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f417936e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f417937f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ScheduledExecutorService f417938g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static j f417939h;

    public y() {
    }

    static {
        f417936e = 500;
        f417938g = CoreThreadPool.getDefault().getSingleScheduledThreadPool("dynamic_point_thread");
    }

    public static boolean b() {
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a == true) goto L5;
    L7:
        return false;
    L5:
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440410b == true) goto L7;
        return true;
    }

    public static void c() {
        f417932a = com.ss.android.lark.security.compliance.infra.storage.d.b("file_auth_policy", 2);
        f417934c = com.ss.android.lark.security.compliance.infra.storage.d.b("file_auth_policy_object", 2);
        if (w4c.c.a().j() == false) goto L6;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "initStorage(), disableDynamicCache is true");
        return;
    L6:
        boolean r100 = com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a;
        com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a = idb.f.a().isEnable("lark.security.file_messenger_share_optimization");
        com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440410b = w4c.c.a().I();
        com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440411c = w4c.c.a().H();
        int r101 = ScsLogger.f440428a;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "initStorage(), isImShareOptEnabled=" + com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a + ", enableImReadPolicyCenter=" + com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440410b + ", enableImReadInvalidDataOpt=" + com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440411c + ", enableImFileReadOpt=" + com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a);
        if (b() == false) goto L9;
        String r102 = u4c.a.f548750a;
        u4c.a.a("file_auth_im_share_opt", MapsKt.mapOf(new Pair("enabled", 1)), null, null, 0, 28);
        ScsLogger.d("SecurityPolicy_PolicyStorage", "im file read opt enabled");
        f417939h = new j(w4c.c.a().v().a(), ((yzb.b) LarkContext.spiByDwarf(yzb.b.class)).d());
        return;
    L9:
        String r103 = u4c.a.f548750a;
        int r110 = 0;
        u4c.a.a("file_auth_im_share_opt", MapsKt.mapOf(new Pair("enabled", 0)), null, null, 0, 28);
        ScsLogger.d("SecurityPolicy_PolicyStorage", "im file read opt disabled");
        com.ss.android.lark.storage.kv.repo.a r104 = com.ss.android.lark.security.compliance.infra.storage.d.b("imFileRead_repo", 2);
        f417933b = r104;
        f417935d = r104.getInt("IM_FILE_READ_HEAD", 0);
        com.ss.android.lark.storage.kv.repo.a r105 = f417933b;
        if (r105 == null) goto L12;
        r110 = r105.getInt("IM_FILE_READ_COUNT", 0);
    L12:
        f417937f = r110;
        com.ss.android.lark.storage.kv.repo.a r106 = f417933b;
        int r107 = 500;
        if (r106 == null) goto L15;
        r107 = r106.getInt("IM_FILE_READ_MAX_CAPACITY", 500);
    L15:
        f417936e = r107;
        int r108 = w4c.c.a().w().a();
        if (r108 == f417936e) goto L24;
        ScsLogger.d("SecurityPolicy_PolicyStorage", "initStorage(), imFileReadCurrentMaxCapacity is " + f417936e + ", newSize is " + r108);
        if (com.ss.android.lark.security.compliance.api.model.filepolicy.g.f440409a == true) goto L25;
        int r109 = f417936e;
        int r111 = w4c.c.a().w().a();
        Ref.IntRef r112 = new Ref.IntRef();
        r112.element = f417935d;
        com.ss.android.lark.storage.kv.repo.a r113 = f417933b;
        if (r113 == null) goto L26;
        f417938g.execute(new m(r109, r112, r113, r111));
        return;
    L26:
        return;
    L25:
        return;
    }

    public static final Pair a(int r100) {
        if (b() == true) goto L22;
        com.ss.android.lark.storage.kv.repo.a r101 = f417933b;
        if (r101 == null) goto L19;
        String r102 = TableInfo.Index.DEFAULT_PREFIX + r100;
        if (r101.a(r102, String.class) == false) goto L20;
        String r103 = r101.getString(r102, null);
        if (r103 != null) goto L13;
        r103 = "";
    L13:
        if (r103.length() <= 0) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L18;
        return null;
    L18:
        return TuplesKt.to(r103, r101.getJSONObject(r103, d.class));
    L15:
        r104 = false;
        goto L16
    L20:
        return null;
    L19:
        return null;
    L22:
        return null;
    }
}
