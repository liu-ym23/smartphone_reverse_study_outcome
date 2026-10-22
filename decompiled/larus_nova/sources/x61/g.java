package x61;

import android.view.ViewGroup;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1 f562589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Class f562590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function1 f562591d;

    @Override // x61.h
    public final Class<? extends Widget> a(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        return this.f562590c;
    }

    @Override // x61.d
    public final void b(Widget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        Function1 r101 = this.f562589b;
        if (r101 == null) goto L6;
        Unit r102 = (Unit) r101.invoke(r100);
        return;
    }

    @Override // x61.d
    public final ViewGroup c(d.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Function1 r101 = this.f562591d;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (ViewGroup) r101.invoke(r100);
    }

    public g(Function1 r100, Class r101) {
        this.f562589b = r100;
        this.f562590c = r101;
        this.f562591d = null;
    }
}
