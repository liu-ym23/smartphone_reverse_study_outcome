package com.bytedance.awemeopen.apps.framework.comment.widget.view;

import android.content.Context;
import android.graphics.Canvas;
import android.text.SpannableString;
import android.util.AttributeSet;
import com.amap.api.col.s.ce;
import com.bytedance.awemeopen.apps.framework.comment.view.widget.ClickSpanWorkaroundTextView;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001:\u0005k\r\u0015\u001d!B\u0013\b\u0016\u0012\b\u0010c\u001a\u0004\u0018\u00010b¢\u0006\u0004\bd\u0010eB\u001d\b\u0016\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u0012\b\u0010g\u001a\u0004\u0018\u00010f¢\u0006\u0004\bd\u0010hB%\b\u0016\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u0012\u0006\u0010i\u001a\u00020\f¢\u0006\u0004\bd\u0010jJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R$\u0010'\u001a\u0004\u0018\u00010 8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00102\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u000e\u001a\u0004\b0\u0010\u0010\"\u0004\b1\u0010\u0012R\"\u00106\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u000e\u001a\u0004\b4\u0010\u0010\"\u0004\b5\u0010\u0012R\"\u0010:\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010*\u001a\u0004\b8\u0010,\"\u0004\b9\u0010.R\"\u0010>\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010*\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\"\u0010B\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010*\u001a\u0004\b@\u0010,\"\u0004\bA\u0010.R\"\u0010E\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u000e\u001a\u0004\bC\u0010\u0010\"\u0004\bD\u0010\u0012R\u0014\u0010I\u001a\u00020F8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\"\u0010J\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010*\u001a\u0004\bJ\u0010,\"\u0004\bK\u0010.R$\u0010L\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010R\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR$\u0010X\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R$\u0010^\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b^\u0010\u000e\u001a\u0004\b_\u0010\u0010R$\u0010`\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b`\u0010\u000e\u001a\u0004\ba\u0010\u0010¨\u0006l"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView;", "Lcom/bytedance/awemeopen/apps/framework/comment/view/widget/ClickSpanWorkaroundTextView;", "", "getText", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$c;", "l", "", "setSpanClickListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$d;", "setSpanLongClickListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$e;", "setSpanShowListener", "", "b", "I", "getSpanStyle", "()I", "setSpanStyle", "(I)V", "spanStyle", "", "c", FaceService.girlLabel, "getSpanSize", "()F", "setSpanSize", "(F)V", "spanSize", "<set-?>", "d", "getSpanColor", "spanColor", "Landroid/text/SpannableString;", "e", "Landroid/text/SpannableString;", "getSpannableString", "()Landroid/text/SpannableString;", "setSpannableString", "(Landroid/text/SpannableString;)V", "spannableString", "", "f", "Z", "isCanScroll", "()Z", "setCanScroll", "(Z)V", ce.f26391f, "getOutSetSpanColor", "setOutSetSpanColor", "outSetSpanColor", "h", "getPrefixSpanColor", "setPrefixSpanColor", "prefixSpanColor", RXScreenCaptureService.KEY_INDEX, "getMCanTopicAndSearchEntityBold", "setMCanTopicAndSearchEntityBold", "mCanTopicAndSearchEntityBold", ce.f26395j, "getMIsHashTagEnhance", "setMIsHashTagEnhance", "mIsHashTagEnhance", ce.f26396k, "getMIsHashTagClickable", "setMIsHashTagClickable", "mIsHashTagClickable", "getTopicSpanColor", "setTopicSpanColor", "topicSpanColor", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$b;", "getCustomSpanBuilder", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$b;", "customSpanBuilder", "isShowUnderline", "setShowUnderline", "onSpanClickListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$c;", "getOnSpanClickListener", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$c;", "setOnSpanClickListener", "(Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$c;)V", "onSpanLongClickListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$d;", "getOnSpanLongClickListener", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$d;", "setOnSpanLongClickListener", "(Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$d;)V", "mOnSpanShowListener", "Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$e;", "getMOnSpanShowListener", "()Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$e;", "setMOnSpanShowListener", "(Lcom/bytedance/awemeopen/apps/framework/comment/widget/view/CommentTextView$e;)V", "preMeasuredWidth", "getPreMeasuredWidth", "preMeasuredHeight", "getPreMeasuredHeight", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public class CommentTextView extends ClickSpanWorkaroundTextView {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f194316b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f194317c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f194318d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SpannableString f194319e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f194320f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f194321g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f194322h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f194323i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f194324j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f194325k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f194326l;

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

    public final void init() {
        this.f194316b = 0;
        this.f194317c = getTextSize();
        this.f194318d = getCurrentTextColor();
        setHighlightColor(0);
    }

    public final void setMOnSpanShowListener(e r100) {
    }

    public final void setOnSpanClickListener(c r100) {
    }

    public final void setOnSpanLongClickListener(d r100) {
    }

    public final void setShowUnderline(boolean r100) {
    }

    public final void setSpanClickListener(c r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
    }

    public final void setSpanLongClickListener(d r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
    }

    public final void setSpanShowListener(e r100) {
        Intrinsics.checkNotNullParameter(r100, "l");
    }

    private final b getCustomSpanBuilder() {
        return new f();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public CharSequence getText() {
        return super.getText();
    L5:
        return super.getText();
    }

    public final boolean getMCanTopicAndSearchEntityBold() {
        return this.f194323i;
    }

    public final boolean getMIsHashTagClickable() {
        return this.f194325k;
    }

    public final boolean getMIsHashTagEnhance() {
        return this.f194324j;
    }

    public final int getOutSetSpanColor() {
        return this.f194321g;
    }

    public final int getPrefixSpanColor() {
        return this.f194322h;
    }

    public final int getSpanColor() {
        return this.f194318d;
    }

    public final float getSpanSize() {
        return this.f194317c;
    }

    public final int getSpanStyle() {
        return this.f194316b;
    }

    public final SpannableString getSpannableString() {
        return this.f194319e;
    }

    public final int getTopicSpanColor() {
        return this.f194326l;
    }

    public CommentTextView(Context r100) {
        new LinkedHashMap();
        super(r100);
        this.f194320f = true;
        this.f194323i = true;
        this.f194324j = true;
        this.f194325k = true;
        init();
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int r100) {
        if (this.f194320f == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r100) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f194320f == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollVertically(r100) == false) goto L7;
        return true;
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView, android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
    }

    public final void setCanScroll(boolean r100) {
        this.f194320f = r100;
    }

    public final void setMCanTopicAndSearchEntityBold(boolean r100) {
        this.f194323i = r100;
    }

    public final void setMIsHashTagClickable(boolean r100) {
        this.f194325k = r100;
    }

    public final void setMIsHashTagEnhance(boolean r100) {
        this.f194324j = r100;
    }

    public final void setOutSetSpanColor(int r100) {
        this.f194321g = r100;
    }

    public final void setPrefixSpanColor(int r100) {
        this.f194322h = r100;
    }

    public final void setSpanSize(float r100) {
        this.f194317c = r100;
    }

    public final void setSpanStyle(int r100) {
        this.f194316b = r100;
    }

    public final void setSpannableString(SpannableString r100) {
        this.f194319e = r100;
    }

    public final void setTopicSpanColor(int r100) {
        this.f194326l = r100;
    }

    public CommentTextView(Context r100, AttributeSet r101) {
        new LinkedHashMap();
        super(r100, r101);
        this.f194320f = true;
        this.f194323i = true;
        this.f194324j = true;
        this.f194325k = true;
        init();
    }

    @Override // com.bytedance.awemeopen.apps.framework.base.view.refresh.DmtTextView, androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        if ((e instanceof IllegalArgumentException) == false) goto L11;
        super.onMeasure(r100, r101);
        return;
    }

    public CommentTextView(Context r100, AttributeSet r101, int r102) {
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f194320f = true;
        this.f194323i = true;
        this.f194324j = true;
        this.f194325k = true;
        init();
    }
}
