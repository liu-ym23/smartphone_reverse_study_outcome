package com.bytedance.ee.bear.middleground.comment.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fJ\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/widget/CommentTimeText;", "Landroidx/appcompat/widget/AppCompatTextView;", "Ljava/lang/Runnable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "data", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentBean$CommentDetail;", "onAttachedToWindow", "", "onDetachedFromWindow", "setTime", MapController.ITEM_LAYER_TAG, "setUi", "run", "Companion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentTimeText extends AppCompatTextView implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CommentBean.CommentDetail f232302a;

    public static final class a {
    }

    static {
    }

    public CommentTimeText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommentTimeText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean$CommentDetail] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean$CommentDetail] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.widget.TextView, com.bytedance.ee.bear.middleground.comment.widget.CommentTimeText] */
    public final void x() {
        ?? r100 = this.f232302a;
        if (r100 == 0) goto L15;
    L9:
        tt5.a.k("Comment#CommentTimeText", "the time isn't right");
        r100 = String.valueOf(r100.getCreate_timestamp());
    L10:
        setText(r100);
        return;
    L5:
        if (r100.getModify() != 1) goto L7;
        r100 = zu5.a.b(getContext(), ((long) r100.getUpdate_timestamp()) * ((long) 1000)) + getResources().getString(R.string.Doc_Comment_Edited);     // Catch: Exception -> L9
    L12:
        goto L10
    L7:
        r100 = zu5.a.b(getContext(), ((long) r100.getCreate_timestamp()) * ((long) 1000));     // Catch: Exception -> L9
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.ee.util.ui.j.c(this);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.ee.util.ui.j.e(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        x();     // Catch: Throwable -> L4
        com.bytedance.ee.util.ui.j.e(this);     // Catch: Throwable -> L4
        com.bytedance.ee.util.ui.j.d(this, 60000);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public final void setTime(CommentBean.CommentDetail r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f232302a = r100;
        x();
    }

    public CommentTimeText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
    }

    public /* synthetic */ CommentTimeText(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
