package tg5;

import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f545875a;

    public g(b r100) {
        this.f545875a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        CharSequence r101 = (CharSequence) r100;
        Intrinsics.checkNotNull(r101);
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L8;
        b r103 = this.f545875a;
        r103.f545858h = true;
        r103.A8();
        return;
    L8:
        b r104 = this.f545875a;
        if (r104.f545858h == false) goto L13;
        r104.f545858h = false;
        r104.A8();
        return;
    L13:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
