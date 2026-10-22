package com.bytedance.ee.bear.middleground.comment.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u001e\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020$J\u000e\u0010.\u001a\u00020)2\u0006\u0010-\u001a\u00020$J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\b\u00101\u001a\u00020)H\u0002R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/input/InputCommentVisibleView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "commentVisibleIconFromXml", "Landroidx/appcompat/widget/AppCompatImageView;", "getCommentVisibleIconFromXml", "()Landroidx/appcompat/widget/AppCompatImageView;", "setCommentVisibleIconFromXml", "(Landroidx/appcompat/widget/AppCompatImageView;)V", "commentVisibleTitleFromXml", "Landroidx/appcompat/widget/AppCompatTextView;", "getCommentVisibleTitleFromXml", "()Landroidx/appcompat/widget/AppCompatTextView;", "setCommentVisibleTitleFromXml", "(Landroidx/appcompat/widget/AppCompatTextView;)V", "commentVisibleArrowFromXml", "getCommentVisibleArrowFromXml", "setCommentVisibleArrowFromXml", "commentVisibleContentFromXml", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getCommentVisibleContentFromXml", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setCommentVisibleContentFromXml", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "isEnableClick", "", "()Z", "setEnableClick", "(Z)V", "show", "", "visible", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/VisibilityBean;", "isEnable", "isLandscapeMode", "landspaceChange", "showPublic", "showPart", "showPrivate", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputCommentVisibleView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatImageView f231884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AppCompatTextView f231885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AppCompatImageView f231886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ConstraintLayout f231887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f231888e;

    public final AppCompatImageView getCommentVisibleArrowFromXml() {
        KeyEvent.Callback r100 = this.f231886c;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.comment_visible_arrow);
        this.f231886c = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final ConstraintLayout getCommentVisibleContentFromXml() {
        KeyEvent.Callback r100 = this.f231887d;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.comment_visible_content);
        this.f231887d = (ConstraintLayout) r100;
    L6:
        return (ConstraintLayout) r100;
    }

    public final AppCompatImageView getCommentVisibleIconFromXml() {
        KeyEvent.Callback r100 = this.f231884a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.comment_visible_icon);
        this.f231884a = (AppCompatImageView) r100;
    L6:
        return (AppCompatImageView) r100;
    }

    public final AppCompatTextView getCommentVisibleTitleFromXml() {
        KeyEvent.Callback r100 = this.f231885b;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.comment_visible_title);
        this.f231885b = (AppCompatTextView) r100;
    L6:
        return (AppCompatTextView) r100;
    }

    public InputCommentVisibleView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setCommentVisibleArrowFromXml(AppCompatImageView r100) {
        this.f231886c = r100;
    }

    public final void setCommentVisibleContentFromXml(ConstraintLayout r100) {
        this.f231887d = r100;
    }

    public final void setCommentVisibleIconFromXml(AppCompatImageView r100) {
        this.f231884a = r100;
    }

    public final void setCommentVisibleTitleFromXml(AppCompatTextView r100) {
        this.f231885b = r100;
    }

    public final void setEnableClick(boolean r100) {
        this.f231888e = r100;
    }

    public InputCommentVisibleView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public InputCommentVisibleView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102, 0);
        this.f231888e = true;
        LayoutInflater.from(r100).inflate(R.layout.comment_input_visible, this, true);
        getCommentVisibleIconFromXml().setImageResource(R.drawable.ud_icon_lock_open_filled);
        getCommentVisibleTitleFromXml().setText(com.bytedance.ee.util.ui.n.x(getContext(), R.string.LarkCCM_Docs_CommentPerm_VisibleToAll_Menu));
    }
}
