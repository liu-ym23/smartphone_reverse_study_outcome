package uob;

import android.view.View;
import com.suite.lark.emm.design.edittext.SCAppCompatEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f550978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SCAppCompatEditText f550979b;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        this.f550978a.removeOnAttachStateChangeListener(this);
        this.f550979b.setCursorVisible(false);
        this.f550979b.setCursorVisible(true);
        this.f550979b.setOnTouchListener(com.ss.android.lark.keyboard.plugin.tool.voice.vote.b.f430841a);
    }

    public b(SCAppCompatEditText r100, SCAppCompatEditText r101) {
        this.f550978a = r100;
        this.f550979b = r101;
    }
}
