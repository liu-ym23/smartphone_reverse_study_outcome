package com.larus.profile.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.nova.R;
import com.larus.profile.impl.databinding.LarusCommonRedDotImageViewBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J!\u0010\u0013\u001a\u00020\u000f2\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\b\u0001\u0010\u0015\u001a\u00020\n¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0010\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\nH\u0007J\u000e\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\nJ\u0006\u0010!\u001a\u00020\nR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0011¨\u0006\""}, d2 = {"Lcom/larus/profile/impl/view/CommonRedDotImageView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/profile/impl/databinding/LarusCommonRedDotImageViewBinding;", "init", "", "selectResId", "Ljava/lang/Integer;", "unselectResId", "setIconRes", "selectId", "unselectId", "(Ljava/lang/Integer;I)V", "setTabText", "text", "", "updateSelectStatus", "select", "", "updateRedPointVisibility", RemoteMessageConst.Notification.VISIBILITY, "updateUnreadCount", "count", "getUnreadCount", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonRedDotImageView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusCommonRedDotImageViewBinding f366875a;

    @Deprecated(message = "not use")
    public final void setTabText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
    }

    public final int getUnreadCount() {
        LarusCommonRedDotImageViewBinding r100 = this.f366875a;
        if (r100 == null) goto L9;
        RedDotTextView r101 = r100.f366432d;
        if (r101 == null) goto L9;
        if (r101.getVisibility() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L17;
        LarusCommonRedDotImageViewBinding r103 = this.f366875a;
        if (r103 == null) goto L18;
        RedDotTextView r104 = r103.f366432d;
        if (r104 != null) goto L16;
        return 0;
    L16:
        return r104.getRedDotCount();
    L18:
        return 0;
    L17:
        return 0;
    L9:
        r102 = false;
        goto L10
    }

    public CommonRedDotImageView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        R5(r100, null);
    }

    public CommonRedDotImageView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        R5(r100, r101);
    }

    public final void R5(Context r100, AttributeSet r101) {
        LayoutInflater.from(r100).inflate(R.layout.larus_common_red_dot_image_view, this);
        int r102 = R.id.anchor;
        if (((Space) ViewBindings.findChildViewById(this, R.id.anchor)) == null) goto L13;
        r102 = R.id.tab_icon;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(this, R.id.tab_icon);
        if (r103 == null) goto L13;
        r102 = R.id.tab_red_point;
        View r104 = ViewBindings.findChildViewById(this, R.id.tab_red_point);
        if (r104 == null) goto L13;
        r102 = R.id.tab_unread_count;
        RedDotTextView r105 = (RedDotTextView) ViewBindings.findChildViewById(this, R.id.tab_unread_count);
        if (r105 == null) goto L13;
        this.f366875a = new LarusCommonRedDotImageViewBinding(this, r103, r104, r105);
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public CommonRedDotImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        R5(r100, r101);
    }
}
