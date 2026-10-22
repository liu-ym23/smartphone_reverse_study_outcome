package com.bytedance.awemeopen.apps.framework.comment.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.util.AttributeSet;
import com.bytedance.awemeopen.apps.framework.comment.view.widget.ClickSpanWorkaroundTextView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0005k\r\u0015\u001d!B\u0013\b\u0016\u0012\b\u0010c\u001a\u0004\u0018\u00010b¢\u0006\u0004\bd\u0010eB\u001d\b\u0016\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u0012\b\u0010g\u001a\u0004\u0018\u00010f¢\u0006\u0004\bd\u0010hB%\b\u0016\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u0012\u0006\u0010i\u001a\u00020\f¢\u0006\u0004\bd\u0010jJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R$\u0010'\u001a\u0004\u0018\u00010 8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000e\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\"\u00106\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000e\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0012R\"\u0010:\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010*\u001a\u0004\b8\u0010,\"\u0004\b9\u0010.R\"\u0010>\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010*\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\"\u0010B\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010*\u001a\u0004\b@\u0010,\"\u0004\bA\u0010.R\"\u0010E\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R\u0014\u0010I\u001a\u00020F8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\"\u0010J\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010*\u001a\u0004\bJ\u0010,\"\u0004\bK\u0010.R$\u0010L\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010X\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010^\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b^\u0010\u000e\u001a\u0004\b_\u0010\u0010R$\u0010`\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b`\u0010\u000e\u001a\u0004\ba\u0010\u0010¨\u0006l"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView;", "Lcom/bytedance/awemeopen/apps/framework/comment/view/widget/ClickSpanWorkaroundTextView;", "", "getText", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$c;", "l", "", "setSpanClickListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$d;", "setSpanLongClickListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$e;", "setSpanShowListener", "", "b", "I", "getSpanStyle", "()I", "setSpanStyle", "(I)V", "spanStyle", "", "c", "F", "getSpanSize", "()F", "setSpanSize", "(F)V", "spanSize", "<set-?>", "d", "getSpanColor", "spanColor", "Landroid/text/SpannableString;", "e", "Landroid/text/SpannableString;", "getSpannableString", "()Landroid/text/SpannableString;", "setSpannableString", "(Landroid/text/SpannableString;)V", "spannableString", "", "f", "Z", "isCanScroll", "()Z", "setCanScroll", "(Z)V", "g", "getOutSetSpanColor", "setOutSetSpanColor", "outSetSpanColor", "h", "getPrefixSpanColor", "setPrefixSpanColor", "prefixSpanColor", "i", "getMCanTopicAndSearchEntityBold", "setMCanTopicAndSearchEntityBold", "mCanTopicAndSearchEntityBold", "j", "getMIsHashTagEnhance", "setMIsHashTagEnhance", "mIsHashTagEnhance", "k", "getMIsHashTagClickable", "setMIsHashTagClickable", "mIsHashTagClickable", "getTopicSpanColor", "setTopicSpanColor", "topicSpanColor", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$b;", "getCustomSpanBuilder", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$b;", "customSpanBuilder", "isShowUnderline", "setShowUnderline", "onSpanClickListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$c;", "getOnSpanClickListener", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$c;", "setOnSpanClickListener", "(Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$c;)V", "onSpanLongClickListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$d;", "getOnSpanLongClickListener", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$d;", "setOnSpanLongClickListener", "(Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$d;)V", "mOnSpanShowListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$e;", "getMOnSpanShowListener", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$e;", "setMOnSpanShowListener", "(Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$e;)V", "preMeasuredWidth", "getPreMeasuredWidth", "preMeasuredHeight", "getPreMeasuredHeight", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class CommentTextView extends ClickSpanWorkaroundTextView {
    public int b;
    public float c;
    public int d;
    public SpannableString e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public int l;

    public static final class a {
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
    }

    public interface e {
    }

    public static final class f implements b {
        public f() {
        }
    }

    static {
    }

    public final e getMOnSpanShowListener() {
        return null;
    }

    public final c getOnSpanClickListener() {
        return null;
    }

    public final d getOnSpanLongClickListener() {
        return null;
    }

    public final int getPreMeasuredHeight() {
        return 0;
    }

    public final int getPreMeasuredWidth() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void init() {
        this.b = 0;
        this.c = getTextSize();
        this.d = getCurrentTextColor();
        setHighlightColor(0);
    }

    public final void setMOnSpanShowListener(e r1) {
    }

    public final void setOnSpanClickListener(c r1) {
    }

    public final void setOnSpanLongClickListener(d r1) {
    }

    public final void setShowUnderline(boolean r1) {
    }

    public final void setSpanClickListener(c r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
    }

    public final void setSpanLongClickListener(d r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
    }

    public final void setSpanShowListener(e r2) {
        Intrinsics.checkNotNullParameter(r2, "l");
    }

    private final b getCustomSpanBuilder() {
        return new f();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView
    public CharSequence getText() {
        return super.getText();
    L5:
        return super.getText();
    }

    public final boolean getMCanTopicAndSearchEntityBold() {
        return this.i;
    }

    public final boolean getMIsHashTagClickable() {
        return this.k;
    }

    public final boolean getMIsHashTagEnhance() {
        return this.j;
    }

    public final int getOutSetSpanColor() {
        return this.g;
    }

    public final int getPrefixSpanColor() {
        return this.h;
    }

    public final int getSpanColor() {
        return this.d;
    }

    public final float getSpanSize() {
        return this.c;
    }

    public final int getSpanStyle() {
        return this.b;
    }

    public final SpannableString getSpannableString() {
        return this.e;
    }

    public final int getTopicSpanColor() {
        return this.l;
    }

    public CommentTextView(Context r2) {
        new LinkedHashMap();
        super(r2);
        this.f = true;
        this.i = true;
        this.j = true;
        this.k = true;
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollHorizontally(int r2) {
        if (this.f == true) goto L5;
    L7:
        return false;
    L5:
        if (super/*android.widget.TextView*/.canScrollHorizontally(r2) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollVertically(int r2) {
        if (this.f == true) goto L5;
    L7:
        return false;
    L5:
        if (super/*android.widget.TextView*/.canScrollVertically(r2) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.onDraw(r2);
    }

    public final void setCanScroll(boolean r1) {
        this.f = r1;
    }

    public final void setMCanTopicAndSearchEntityBold(boolean r1) {
        this.i = r1;
    }

    public final void setMIsHashTagClickable(boolean r1) {
        this.k = r1;
    }

    public final void setMIsHashTagEnhance(boolean r1) {
        this.j = r1;
    }

    public final void setOutSetSpanColor(int r1) {
        this.g = r1;
    }

    public final void setPrefixSpanColor(int r1) {
        this.h = r1;
    }

    public final void setSpanSize(float r1) {
        this.c = r1;
    }

    public final void setSpanStyle(int r1) {
        this.b = r1;
    }

    public final void setSpannableString(SpannableString r1) {
        this.e = r1;
    }

    public final void setTopicSpanColor(int r1) {
        this.l = r1;
    }

    public CommentTextView(Context r2, AttributeSet r3) {
        new LinkedHashMap();
        super(r2, r3);
        this.f = true;
        this.i = true;
        this.j = true;
        this.k = true;
        init();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView
    public final void onMeasure(int r2, int r3) {
        super.onMeasure(r2, r3);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        if ((e instanceof IllegalArgumentException) == false) goto L11;
        super.onMeasure(r2, r3);
        return;
    }

    public CommentTextView(Context r2, AttributeSet r3, int r4) {
        new LinkedHashMap();
        super(r2, r3, r4);
        this.f = true;
        this.i = true;
        this.j = true;
        this.k = true;
        init();
    }
}
