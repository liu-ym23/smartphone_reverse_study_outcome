package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.view.View;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f extends a {
    public final /* synthetic */ Function0 f;
    public final /* synthetic */ Function0 g;
    public final /* synthetic */ Function0 h;
    public final /* synthetic */ View i;
    public final /* synthetic */ Function0 j;

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void a() {
        Function0 r0 = this.g;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void b() {
        Function0 r0 = this.f;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.intro.manager.a
    public final void c() {
        Function0 r0 = this.h;
        if (r0 == null) goto L6;
        Unit r1 = (Unit) r0.invoke();
        return;
    }

    public f(Function0 r1, Function0 r2, Function0 r3, View r4, Function0 r5, View r6, Function2 r7) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        super(BDLocationException.ERROR_BEACON_ADVERTISING, r6, 1, r7);
    }
}
