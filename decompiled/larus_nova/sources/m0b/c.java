package m0b;

import android.content.Context;
import com.ss.android.lark.chameleon.AbsChameleonJsRuntime;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends c0c.b implements AbsChameleonJsRuntime {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsChameleonJsRuntime f511547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f511548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<AbsChameleonJsRuntime> f511549d;

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void destroy() {
        this.f511547b.destroy();
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void init(Context r100, String r101, ChameleonBizType r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "bizType");
        this.f511547b.init(r100, r101, r102);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void registerService(AbsChameleonService r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        this.f511547b.registerService(r100);
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonJsRuntime
    public final void run() {
        this.f511547b.run();
    }

    @Override // c0c.b
    public final void lf(f0c.b r100) {
        Intrinsics.checkNotNullParameter(r100, "toState");
        this.f511549d.b().destroy();
        Intrinsics.checkNotNullParameter(r100, "toState");
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        v r102 = this.f511548c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        AbsChameleonJsRuntime r104 = (AbsChameleonJsRuntime) k.b(r102.c(r103), AbsChameleonJsRuntime.class);
        this.f511549d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }

    @Inject
    public c(j r100, v r101, com.ss.android.lark.passportc.convention.b<AbsChameleonJsRuntime> r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r102, "proxy");
        super(r100);
        this.f511547b = r102.b();
        this.f511548c = r101;
        this.f511549d = r102;
    }
}
