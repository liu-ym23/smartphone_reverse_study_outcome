package p36;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.view.Window;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window f527591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f527592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f527593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceC7146a f527594d;

    public b(Window r100, Context r101, Ref.IntRef r102, com.bytedance.ies.bullet.service.popup.ui.a r103) {
        this.f527591a = r100;
        this.f527592b = r101;
        this.f527593c = r102;
        this.f527594d = r103;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        int r100 = a.f527590a;
        int r101 = a.a(this.f527591a, this.f527592b);
        if (this.f527593c.element == r101) goto L6;
        this.f527594d.a(r101);
        this.f527593c.element = r101;
        return;
    }
}
