package pr1;

import android.webkit.WebView;
import ib.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Object, Unit> f530354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<String, Throwable, Unit> f530355b;

    @Override // ib.f
    public final void onLoadStart(String r100, WebView r101) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function1<Object, Unit> r100, Function2<? super String, ? super Throwable, Unit> r101) {
        this.f530354a = r100;
        this.f530355b = r101;
    }

    @Override // ib.f
    public final void onLoadUriSuccess(String r100, WebView r101) {
        Function1<Object, Unit> r102 = this.f530354a;
        if (r102 == null) goto L6;
        Unit r103 = r102.invoke(r101);
        return;
    }

    @Override // ib.f
    public final void onLoadFail(String r100, WebView r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r102, "e");
        Function2<String, Throwable, Unit> r103 = this.f530355b;
        if (r103 == null) goto L6;
        Unit r104 = r103.invoke(r100, r102);
        return;
    }
}
