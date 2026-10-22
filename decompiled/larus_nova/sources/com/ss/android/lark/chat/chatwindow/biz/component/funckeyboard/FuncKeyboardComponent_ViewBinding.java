package com.ss.android.lark.chat.chatwindow.biz.component.funckeyboard;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes35.dex */
public final class FuncKeyboardComponent_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FuncKeyboardComponent f412012a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        FuncKeyboardComponent r100 = this.f412012a;
        if (r100 == null) goto L7;
        this.f412012a = null;
        r100.mSwitcherContainer = null;
        r100.mMenuContainer = null;
        r100.mRootContainer = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public FuncKeyboardComponent_ViewBinding(FuncKeyboardComponent r100, View r101) {
        this.f412012a = r100;
        r100.mSwitcherContainer = (ConstraintLayout) Utils.findRequiredViewAsType(r101, R.id.switch_container, "field 'mSwitcherContainer'", ConstraintLayout.class);
        r100.mMenuContainer = (FrameLayout) Utils.findRequiredViewAsType(r101, R.id.menu_container, "field 'mMenuContainer'", FrameLayout.class);
        r100.mRootContainer = (ConstraintLayout) Utils.findRequiredViewAsType(r101, R.id.func_keyboard_root, "field 'mRootContainer'", ConstraintLayout.class);
    }
}
