package com.larus.bmhome.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.larus.chat.common.databinding.LarusLayoutMessageRiskWarningTextBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015J\u0006\u0010\u0019\u001a\u00020\u000eR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/view/MessageRiskWarningTextView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/chat/common/databinding/LarusLayoutMessageRiskWarningTextBinding;", "bottomPadding", BasicTestActionHandler.TEST_ACTION_RESET, "", "setUrlVisible", "isVisible", "", "setTextVisible", "setWarningUrl", "textOfUrl", "", "url", "setWarningText", "text", "checkPadding", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageRiskWarningTextView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutMessageRiskWarningTextBinding f315580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f315581b;

    public MessageRiskWarningTextView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public MessageRiskWarningTextView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setTextVisible(boolean r100) {
        LarusLayoutMessageRiskWarningTextBinding r101 = this.f315580a;
        if (r101 == null) goto L11;
        TextView r102 = r101.f324036b;
        if (r102 == null) goto L12;
        if (r100 == false) goto L8;
        int r103 = 0;
    L9:
        r102.setVisibility(r103);
        return;
    L8:
        r103 = 8;
        goto L9
    L12:
        return;
    }

    public final void setUrlVisible(boolean r100) {
        LarusLayoutMessageRiskWarningTextBinding r101 = this.f315580a;
        if (r101 == null) goto L11;
        TextView r102 = r101.f324037c;
        if (r102 == null) goto L12;
        if (r100 == false) goto L8;
        int r103 = 0;
    L9:
        r102.setVisibility(r103);
        return;
    L8:
        r103 = 8;
        goto L9
    L12:
        return;
    }

    public final void setWarningText(String r100) {
        if (r100 == null) goto L9;
        LarusLayoutMessageRiskWarningTextBinding r101 = this.f315580a;
        if (r101 == null) goto L10;
        TextView r102 = r101.f324036b;
        if (r102 == null) goto L11;
        r102.setText(r100);
        return;
    L11:
        return;
    L10:
        return;
    }

    public MessageRiskWarningTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f315581b = getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_12, null, R.dimen.larus_dp_12));
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_message_risk_warning_text, this);
        int r103 = R.id.risk_warning_text;
        TextView r104 = (TextView) ViewBindings.findChildViewById(this, R.id.risk_warning_text);
        if (r104 == null) goto L9;
        r103 = R.id.risk_warning_url;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.risk_warning_url);
        if (r105 == null) goto L9;
        this.f315580a = new LarusLayoutMessageRiskWarningTextBinding(this, r104, r105);
        setVisibility(8);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ MessageRiskWarningTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
