package tg5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ b a;

    public g(b r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        CharSequence r4 = (CharSequence) r3;
        Intrinsics.checkNotNull(r4);
        if (r4.length() != 0) goto L5;
        boolean r5 = true;
    L6:
        if (r5 == false) goto L8;
        b r6 = this.a;
        r6.h = true;
        r6.A8();
        return;
    L8:
        b r7 = this.a;
        if (r7.h == false) goto L13;
        r7.h = false;
        r7.A8();
        return;
    L13:
        return;
    L5:
        r5 = false;
        goto L6
    }
}
