package com.bytedance.ee.util.db.container;

import android.content.Context;
import androidx.room.RoomDatabase;
import com.bytedance.ee.util.db.DBController;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import f0c.g;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class DBControllerProxy extends c0c.b implements com.bytedance.ee.util.db.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.util.db.a f243110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f243111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<com.bytedance.ee.util.db.a> f243112d;

    @Override // com.bytedance.ee.util.db.a
    public final String Aa(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "sourceName");
        return this.f243110b.Aa(r100, r101);
    }

    @Override // com.bytedance.ee.util.db.a
    public final void M0(boolean r100) {
        this.f243110b.M0(r100);
    }

    @Override // com.bytedance.ee.util.db.a
    public final void e2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("offlineData.db", "sourceName");
        this.f243110b.e2(r100);
    }

    @Override // com.bytedance.ee.util.db.a
    public final String getKey() {
        return this.f243110b.getKey();
    }

    @Override // com.bytedance.ee.util.db.a
    public final void init(String r100) {
        this.f243110b.init(r100);
    }

    @Override // com.bytedance.ee.util.db.a
    public final <T extends RoomDatabase> T r1(String r100) {
        return (T) this.f243110b.r1(r100);
    }

    @Override // com.bytedance.ee.util.db.a
    public final void x7(final DBController.b r100) {
        com.ss.android.lark.passportc.convention.b<com.bytedance.ee.util.db.a> r101 = this.f243112d;
        if (r100 != null) goto L5;
        Object r102 = "";
    L6:
        r101.a(new com.ss.android.lark.passportc.convention.b.C5239b(DBController.b.class, r102), new com.ss.android.lark.passportc.convention.b.c(new DBControllerProxy$registerKeyChangedListener$1(r100), DBControllerProxy$registerKeyChangedListener$2.INSTANCE));
        return;
    L5:
        r102 = r100;
        goto L6
    }

    public DBControllerProxy(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<com.bytedance.ee.util.db.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), com.bytedance.ee.util.db.a.class), com.bytedance.ee.util.db.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f243110b = r103.b();
        this.f243111c = r101;
        this.f243112d = r103;
    }

    @Override // com.bytedance.ee.util.db.a
    public final void W3(final String r100, final DBController.a r101) {
        Intrinsics.checkNotNullParameter(r101, "wrapper");
        com.ss.android.lark.passportc.convention.b<com.bytedance.ee.util.db.a> r102 = this.f243112d;
        if (r100 != null) goto L5;
        String r103 = "";
    L6:
        r102.a(new com.ss.android.lark.passportc.convention.b.C5239b(DBController.a.class, r103), new com.ss.android.lark.passportc.convention.b.c(new DBControllerProxy$registerDBBuildType$1(r100, r101), DBControllerProxy$registerDBBuildType$2.INSTANCE));
        return;
    L5:
        r103 = r100;
        goto L6
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f243111c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        com.bytedance.ee.util.db.a r104 = (com.bytedance.ee.util.db.a) k.b(r102.c(r103), com.bytedance.ee.util.db.a.class);
        this.f243112d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
