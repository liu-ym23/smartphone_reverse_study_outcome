package wj5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ int e;

    public k(a r1, boolean r2, String r3, String r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final void accept(Object r4) {
        Boolean r5 = (Boolean) r4;
        tt5.a.h("DocMoreInfoBehavior", "manualOfflineFlow ok. ");
        a r0 = this.a;
        oj5.a r1 = r0.c();
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r5);
        r1.f = r5.booleanValue();
    L6:
        r0.e(r1);
        a r2 = this.a;
        if (this.b == false) goto L9;
        String r3 = this.c;
    L10:
        Intrinsics.checkNotNull(r3);
        int r6 = this.e;
        Intrinsics.checkNotNull(r5);
        r2.d(r3, r6, r5.booleanValue());
        return;
    L9:
        r3 = this.d;
        goto L10
    L5:
        r1 = null;
        goto L6
    }
}
