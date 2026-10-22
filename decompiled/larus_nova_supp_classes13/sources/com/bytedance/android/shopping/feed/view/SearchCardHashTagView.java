package com.bytedance.android.shopping.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.ec.core.widget.flow.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/feed/view/SearchCardHashTagView;", "Lcom/bytedance/android/ec/core/widget/flow/TagFlowLayout;", "", "", "n", "Ljava/util/List;", "getRemainedKeywordList", "()Ljava/util/List;", "setRemainedKeywordList", "(Ljava/util/List;)V", "remainedKeywordList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCardHashTagView extends TagFlowLayout {
    public List<String> n;

    public SearchCardHashTagView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public SearchCardHashTagView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final List<String> getRemainedKeywordList() {
        return this.n;
    }

    public final void setRemainedKeywordList(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.n = r2;
    }

    public SearchCardHashTagView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.n = new ArrayList();
    }

    public /* synthetic */ SearchCardHashTagView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
