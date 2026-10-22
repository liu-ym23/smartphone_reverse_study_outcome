package com.bytedance.android.ui.ec.widget.photodraweeview.transition;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ui/ec/widget/photodraweeview/transition/TransitionState;", "", "()V", "STATE_DRAG_TRANSITION", "", "STATE_ENTER_END", "STATE_ENTER_TRANSITION", "STATE_OUT_TRANSITION", "STATE_RESUME_TRANSITION", "UNDEFINE", "ui-ec-widget_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TransitionState {
    public static final TransitionState INSTANCE = null;
    public static final int STATE_DRAG_TRANSITION = 3;
    public static final int STATE_ENTER_END = 3;
    public static final int STATE_ENTER_TRANSITION = 0;
    public static final int STATE_OUT_TRANSITION = 2;
    public static final int STATE_RESUME_TRANSITION = 1;
    public static final int UNDEFINE = -1;

    private TransitionState() {
    }

    static {
        INSTANCE = new TransitionState();
    }
}
