package com.bytedance.assem.arch.reused;

import android.view.View;
import android.view.ViewStub;
import com.bytedance.assem.arch.core.InflateMode;
import com.bytedance.tiktok.proxy.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedUIContentAssem;", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "Lcom/bytedance/assem/arch/reused/ReusedUIAssem;", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class ReusedUIContentAssem<RECEIVER extends com.bytedance.tiktok.proxy.a> extends ReusedUIAssem<RECEIVER> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f193000x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f193001y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f193002z;

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onDestroy() {
        new AnonymousClass1(this).invoke();
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onPause() {
        new C104211(this).invoke();
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onResume() {
        new C104221(this).invoke();
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onStart() {
        new C104231(this).invoke();
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onStop() {
        new C104241(this).invoke();
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem
    public final void u() {
        if (this.f192984h == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L10;
        p(r());
        r();
        return;
    L10:
        if (this.f193000x == 0) goto L24;
        View r101 = j().f192875f;
        if (r101 == null) goto L25;
        View r102 = r101.findViewById(this.f193000x);
        if (r102 == null) goto L23;
        if ((r102 instanceof ViewStub) == false) goto L21;
        int r103 = this.f193001y;
        if (r103 == 0) goto L20;
        ((ViewStub) r102).setLayoutResource(r103);
    L20:
        this.f192984h = ((ViewStub) r102).inflate();
        p(r());
        r();
        return;
    L21:
        this.f192984h = r102;
        p(r102);
        return;
    L23:
        throw new IllegalStateException("Required value was null.".toString());
    L25:
        return;
    L24:
        return;
    L5:
        r100 = false;
        goto L6
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem
    public final void v() {
        if (this.f192984h == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        r().setVisibility(8);
        return;
    L9:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public ReusedUIContentAssem() {
        InflateMode r100 = InflateMode.SYNC;
        this.f193002z = LazyKt.lazy(LazyThreadSafetyMode.NONE, ReusedUIContentAssem$handler$2.INSTANCE);
    }

    public static final /* synthetic */ void A(ReusedUIContentAssem r100) {
        super.onStart();
    }

    public static final /* synthetic */ void B(ReusedUIContentAssem r100) {
        super.onStop();
    }

    public static final /* synthetic */ void x(ReusedUIContentAssem r100) {
        super.onDestroy();
    }

    public static final /* synthetic */ void y(ReusedUIContentAssem r100) {
        super.onPause();
    }

    public static final /* synthetic */ void z(ReusedUIContentAssem r100) {
        super.onResume();
    }
}
