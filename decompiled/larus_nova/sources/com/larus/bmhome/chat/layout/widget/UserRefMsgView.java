package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.common_ui.widget.roundlayout.RoundTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0016\u0010\u0015\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/UserRefMsgView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/layout/IReferenceMessageBox;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutReferenceMessageViewBinding;", "styleInfo", "Lcom/larus/bmhome/chat/layout/IReferenceMessageBox$ReferenceMessageStyleInfo;", "show", "", "text", "", "setReferenceMessageStyleInfo", "hide", "setClickListener", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "asView", "Landroid/view/View;", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserRefMsgView extends ConstraintLayout implements com.larus.bmhome.chat.layout.l {
    public UserRefMsgView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UserRefMsgView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void setClickListener(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
    }

    public void setReferenceMessageStyleInfo(com.larus.bmhome.chat.layout.l.a r100) {
        Intrinsics.checkNotNullParameter(r100, "styleInfo");
    }

    public UserRefMsgView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_reference_message_view, this);
        int r103 = R.id.ref_hint;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.ref_hint)) == null) goto L11;
        r103 = R.id.ref_text;
        if (((RoundTextView) ViewBindings.findChildViewById(this, R.id.ref_text)) == null) goto L11;
        r103 = R.id.ref_text_container;
        if (((FrameLayout) ViewBindings.findChildViewById(this, R.id.ref_text_container)) == null) goto L11;
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ UserRefMsgView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
