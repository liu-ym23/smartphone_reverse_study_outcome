package oj7;

import com.bytedance.crash.Npth;
import com.bytedance.forest.interceptor.GlobalInterceptor;
import com.bytedance.ies.bullet.service.base.resourceloader.config.IXResourceLoader;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.ug.sdk.luckycat.impl.manager.LuckyCatSettingsManger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f523587a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f523588b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f523589c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicInteger f523590d = null;

    public static final class a implements com.bytedance.ug.sdk.luckycat.impl.manager.g {
        public a() {
        }

        @Override // com.bytedance.ug.sdk.luckycat.impl.manager.g
        public final void a(JSONObject r100) {
            if (r100 == null) goto L5;
            AtomicInteger r101 = d.f523587a;
            d.b(r100);
            return;
        }
    }

    public d() {
    }

    static {
        f523587a = new AtomicInteger(10);
        f523588b = new AtomicBoolean(false);
        f523589c = new AtomicBoolean(false);
        f523590d = new AtomicInteger(0);
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SlardarAscribeManager", "init");
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SlardarAscribeManager", "registerSourceListener invoke");
        List<Class<? extends IXResourceLoader>> r100 = x16.a.f562120a;
        e r101 = new e();
        Intrinsics.checkNotNullParameter(r101, "monitor");
        ((ArrayList) x16.a.f562121b).add(r101);
        GlobalInterceptor.e(new f());
        LuckyCatSettingsManger r102 = LuckyCatSettingsManger.b.f271283a;
        com.bytedance.ug.sdk.luckycat.impl.manager.d r103 = r102.f271282a;
        r103.m();
        JSONObject r104 = r103.f271315c;
        if (r104 == null) goto L5;
        b(r104);
    L5:
        a r105 = new a();
        com.bytedance.ug.sdk.luckycat.impl.manager.d r106 = r102.f271282a;
        List<com.bytedance.ug.sdk.luckycat.impl.manager.g> r107 = r106.f271313a;
        monitor-enter(r107);
        ((CopyOnWriteArrayList) r106.f271313a).add(r105);     // Catch: Throwable -> L10
        monitor-exit(r107);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static final void a(String r100) {
        if (f523589c.get() == false) goto L16;
        if (r100 != null) goto L7;
        return;
    L7:
        if (StringsKt.contains$default(r100, "/ugflow-resource/", false, 2, null) == false) goto L9;
    L10:
        AtomicInteger r101 = f523590d;
        if (r101.get() < f523587a.get()) goto L13;
        r101.set(1);
    L14:
        String r102 = "polaris_last_resource_load_" + r101.get();
        com.bytedance.ug.sdk.luckycat.impl.utils.a.a("SlardarAscribeManager", "add resourceTag:" + r102 + ',' + r100);
        Npth.addTag(r102, r100);
        return;
    L13:
        r101.set(r101.get() + 1);
        goto L14
    L9:
        if (StringsKt.contains$default(r100, "-ugflow/", false, 2, null) == true) goto L10;
        return;
    }

    public static void b(JSONObject r100) {
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SlardarAscribeManager", "updateSetting invoke");
        JSONObject r101 = r100.optJSONObject("common");     // Catch: Exception -> L19
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.has("enable_slardar_tag_proxy") == false) goto L9;
        boolean r102 = JSONObjectProtectorUtils.getBoolean(r101, "enable_slardar_tag_proxy");     // Catch: Exception -> L19
        f523588b.set(r102);     // Catch: Exception -> L19
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SlardarAscribeManager", "set proxy open:" + r102);     // Catch: Exception -> L19
    L9:
        if (r101.has("enable_slardar_tag_resource") == false) goto L12;
        boolean r103 = JSONObjectProtectorUtils.getBoolean(r101, "enable_slardar_tag_resource");     // Catch: Exception -> L19
        f523589c.set(r103);     // Catch: Exception -> L19
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SlardarAscribeManager", "set resource open:" + r103);     // Catch: Exception -> L19
    L12:
        if (r101.has("max_slardar_tag_resource") == false) goto L24;
        int r104 = JSONObjectProtectorUtils.getInt(r101, "max_slardar_tag_resource");     // Catch: Exception -> L19
        if (r104 <= 0) goto L16;
        f523587a.set(r104);     // Catch: Exception -> L19
    L16:
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SlardarAscribeManager", "set max resource count:" + r104);     // Catch: Exception -> L19
        return;
    L24:
        return;
    L19:
        e = move-exception;
        com.bytedance.ug.sdk.luckycat.impl.utils.a.c("SlardarAscribeManager", "updateSetting error:" + e.getLocalizedMessage());
    }
}
