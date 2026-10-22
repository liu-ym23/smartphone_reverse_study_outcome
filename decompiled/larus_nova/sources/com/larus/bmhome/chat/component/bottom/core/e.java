package com.larus.bmhome.chat.component.bottom.core;

import com.larus.platform.api.creation.TplType;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes25.dex */
public final /* synthetic */ class e implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f298480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CoreInputAbility f298481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f298482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f298483d;

    public /* synthetic */ e(boolean r100, CoreInputAbility r101, boolean r102, String r103) {
        this.f298480a = r100;
        this.f298481b = r101;
        this.f298482c = r102;
        this.f298483d = r103;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        boolean r100 = this.f298480a;
        CoreInputAbility r101 = this.f298481b;
        boolean r102 = this.f298482c;
        String r103 = this.f298483d;
        if (r100 == false) goto L5;
        float r104 = 45.0f;
    L6:
        r101.f298313f.on(r104);
        r101.f298313f.EG(r100);
        r101.F().updateShowBottomMenu(r100);
        r101.f298313f.qy();
        r101.f298319l.invoke(Boolean.valueOf(r100), Boolean.valueOf(r102));
        fx9.a r105 = r101.A().Z60();
        if (r105 == null) goto L9;
        r105.Nk(fx9.b.a.f479118b);
    L9:
        com.larus.bmhome.instruction.g r106 = r101.A().vc();
        if (r106 == null) goto L12;
        r106.Vm(r100, r103);
    L12:
        com.larus.bmhome.a0 r107 = com.larus.bmhome.b0.a(r101.f298314g);
        if (r107 == null) goto L15;
        r107.ED(!r100, TplType.MENU);
    L15:
        ci8.d r108 = ci8.e.a(r101.f298314g);
        if (r108 == null) goto L19;
        r108.hp(!r100);
    L19:
        return Unit.INSTANCE;
    L5:
        r104 = 0.0f;
        goto L6
    }
}
