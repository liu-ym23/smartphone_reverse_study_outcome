package yha;

import com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class u implements IWindowAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f567672a;

    public u(t r100) {
        this.f567672a = r100;
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener
    public final void onWindowAnimationStart(boolean r100, WindowAnimationType r101) {
        Intrinsics.checkNotNullParameter(r101, "type");
        this.f567672a.f567669s = !r100;
    }

    @Override // com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener
    public final void onWindowAnimationEnd(boolean r100, WindowAnimationType r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r100 == true) goto L6;
        this.f567672a.f567669s = false;
        return;
    }
}
