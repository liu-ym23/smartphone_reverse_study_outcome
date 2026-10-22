package com.ss.android.lark.chat.chatwindow.biz.component.keyboardtop;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.larus.nova.R;
import com.ss.android.lark.view.SizeDetectConstraintLayout;

/* JADX INFO: loaded from: classes35.dex */
public class BaseKeyboardTopExtendComponent_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseKeyboardTopExtendComponent f412105a;

    @Override // butterknife.Unbinder
    public final void unbind() {
        BaseKeyboardTopExtendComponent r100 = this.f412105a;
        if (r100 == null) goto L7;
        this.f412105a = null;
        r100.mTimeZoneContainer = null;
        r100.mButtonExtendContainer = null;
        r100.mTextExtendContainer = null;
        r100.mRootLayout = null;
        return;
    L7:
        throw new IllegalStateException("Bindings already cleared.");
    }

    public BaseKeyboardTopExtendComponent_ViewBinding(BaseKeyboardTopExtendComponent r100, View r101) {
        this.f412105a = r100;
        r100.mTimeZoneContainer = (ViewGroup) Utils.findRequiredViewAsType(r101, R.id.fl_timezone_container, "field 'mTimeZoneContainer'", ViewGroup.class);
        r100.mButtonExtendContainer = (FrameLayout) Utils.findRequiredViewAsType(r101, R.id.button_extend_container, "field 'mButtonExtendContainer'", FrameLayout.class);
        r100.mTextExtendContainer = (FrameLayout) Utils.findRequiredViewAsType(r101, R.id.text_extend_container, "field 'mTextExtendContainer'", FrameLayout.class);
        r100.mRootLayout = (SizeDetectConstraintLayout) Utils.findRequiredViewAsType(r101, R.id.root_container, "field 'mRootLayout'", SizeDetectConstraintLayout.class);
    }
}
