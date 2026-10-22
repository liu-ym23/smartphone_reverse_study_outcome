package com.bytedance.ee.bear.middleground.comment.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020$J\u000e\u0010.\u001a\u00020)2\u0006\u0010-\u001a\u00020$J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/input/InputCommentVisibleView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "commentVisibleIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getCommentVisibleIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setCommentVisibleIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "commentVisibleTitleFromXml", "Landroidx/appcompat/widget/AppCompatTextView;", "getCommentVisibleTitleFromXml", "()Landroidx/appcompat/widget/AppCompatTextView;", "setCommentVisibleTitleFromXml", "(Landroidx/appcompat/widget/AppCompatTextView;)V", "commentVisibleArrowFromXml", "getCommentVisibleArrowFromXml", "setCommentVisibleArrowFromXml", "commentVisibleContentFromXml", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getCommentVisibleContentFromXml", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setCommentVisibleContentFromXml", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "isEnableClick", "", "()Z", "setEnableClick", "(Z)V", "show", "", "visible", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/VisibilityBean;", "isEnable", "isLandscapeMode", "landspaceChange", "showPublic", "showPart", "showPrivate", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputCommentVisibleView extends LinearLayout {
    public AppCompatImageView a;
    public AppCompatTextView b;
    public AppCompatImageView c;
    public ConstraintLayout d;
    public boolean e;

    public final AppCompatImageView getCommentVisibleArrowFromXml() {
        AppCompatImageView r0 = this.c;
        if (r0 != null) goto L6;
        r0 = findViewById(2131367469);
        this.c = r0;
    L6:
        return r0;
    }

    public final ConstraintLayout getCommentVisibleContentFromXml() {
        ConstraintLayout r0 = this.d;
        if (r0 != null) goto L6;
        r0 = findViewById(2131367471);
        this.d = r0;
    L6:
        return r0;
    }

    public final AppCompatImageView getCommentVisibleIconFromXml() {
        AppCompatImageView r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131367472);
        this.a = r0;
    L6:
        return r0;
    }

    public final AppCompatTextView getCommentVisibleTitleFromXml() {
        AppCompatTextView r0 = this.b;
        if (r0 != null) goto L6;
        r0 = findViewById(2131367473);
        this.b = r0;
    L6:
        return r0;
    }

    public InputCommentVisibleView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setCommentVisibleArrowFromXml(AppCompatImageView r1) {
        this.c = r1;
    }

    public final void setCommentVisibleContentFromXml(ConstraintLayout r1) {
        this.d = r1;
    }

    public final void setCommentVisibleIconFromXml(AppCompatImageView r1) {
        this.a = r1;
    }

    public final void setCommentVisibleTitleFromXml(AppCompatTextView r1) {
        this.b = r1;
    }

    public final void setEnableClick(boolean r1) {
        this.e = r1;
    }

    public InputCommentVisibleView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public InputCommentVisibleView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4, 0);
        this.e = true;
        LayoutInflater.from(r2).inflate(2131559865, this, true);
        getCommentVisibleIconFromXml().setImageResource(2131255046);
        getCommentVisibleTitleFromXml().setText(com.bytedance.ee.util.ui.n.x(getContext(), 2131889010));
    }
}
