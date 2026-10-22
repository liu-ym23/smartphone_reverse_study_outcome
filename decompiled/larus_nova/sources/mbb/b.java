package mbb;

import com.ss.android.lark.larkicon.IconScene;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f512804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IconScene f512805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f512806c;

    public b(boolean r100, IconScene r101, long r102) {
        this.f512804a = r100;
        this.f512805b = r101;
        this.f512806c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        boolean r101 = c.f512807a;
        c.i(this.f512804a, this.f512805b, false, this.f512806c, ((Throwable) r100).getMessage());
    }
}
