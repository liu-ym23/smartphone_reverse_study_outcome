package com.bytedance.assem.arch.reused;

import android.view.View;
import android.view.ViewStub;
import com.bytedance.assem.arch.core.InflateMode;
import com.bytedance.tiktok.proxy.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/assem/arch/reused/ReusedUIContentAssem;", "Lcom/bytedance/tiktok/proxy/a;", "RECEIVER", "Lcom/bytedance/assem/arch/reused/ReusedUIAssem;", "<init>", "()V", "assem_release"}, k = 1, mv = {1, 4, 0})
public abstract class ReusedUIContentAssem<RECEIVER extends com.bytedance.tiktok.proxy.a> extends ReusedUIAssem<RECEIVER> {
    public int x;
    public int y;
    public final Lazy z;

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onDestroy() {
        new AnonymousClass1(this).invoke();
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onPause() {
        new C02141(this).invoke();
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onResume() {
        new C02151(this).invoke();
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onStart() {
        new C02161(this).invoke();
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem, com.bytedance.assem.arch.core.Assem
    public final void onStop() {
        new C02171(this).invoke();
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem
    public final void u() {
        if (this.h == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        p(r());
        r();
        return;
    L10:
        if (this.x == 0) goto L24;
        View r1 = j().f;
        if (r1 == null) goto L25;
        View r2 = r1.findViewById(this.x);
        if (r2 == null) goto L23;
        if ((r2 instanceof ViewStub) == false) goto L21;
        int r3 = this.y;
        if (r3 == 0) goto L20;
        ((ViewStub) r2).setLayoutResource(r3);
    L20:
        this.h = ((ViewStub) r2).inflate();
        p(r());
        r();
        return;
    L21:
        this.h = r2;
        p(r2);
        return;
    L23:
        throw new IllegalStateException("Required value was null.".toString());
    L25:
        return;
    L24:
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.assem.arch.reused.ReusedUIAssem
    public final void v() {
        if (this.h == null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r().setVisibility(8);
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public ReusedUIContentAssem() {
        InflateMode r0 = InflateMode.SYNC;
        this.z = LazyKt.lazy(LazyThreadSafetyMode.NONE, ReusedUIContentAssem$handler$2.INSTANCE);
    }

    public static final /* synthetic */ void A(ReusedUIContentAssem r0) {
        super.onStart();
    }

    public static final /* synthetic */ void B(ReusedUIContentAssem r0) {
        super.onStop();
    }

    public static final /* synthetic */ void x(ReusedUIContentAssem r0) {
        super.onDestroy();
    }

    public static final /* synthetic */ void y(ReusedUIContentAssem r0) {
        super.onPause();
    }

    public static final /* synthetic */ void z(ReusedUIContentAssem r0) {
        super.onResume();
    }
}
