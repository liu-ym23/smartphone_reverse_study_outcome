package com.ss.android.lark.newemoji.emoji_list.adapter.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.flexbox.FlexboxLayout;
import com.ss.android.lark.newemoji.emoji_list.adapter.e;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ssb.a;
import ssb.b;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0014J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u0007J&\u0010\u0013\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/newemoji/emoji_list/adapter/view/RecentUsedEmojiView;", "Lcom/google/android/flexbox/FlexboxLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "params", "Lcom/ss/android/lark/newemoji/emoji_list/CreateItemParams;", GXTemplateKey.STYLE_FONT_LINES, "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setItemParams", "setLines", "bindData", "emojis", "", "Lcom/ss/android/lark/newemoji/emoji_list/EmojiItemData$Emoji;", "enableEmojiSkin", "", "listener", "Lcom/ss/android/lark/newemoji/emoji_list/adapter/OnEmojiSelectListener;", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecentUsedEmojiView extends FlexboxLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public a f432948r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f432949s;

    public RecentUsedEmojiView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RecentUsedEmojiView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setItemParams(a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f432948r = r100;
    }

    public final void setLines(int r100) {
        this.f432949s = r100;
    }

    @Override // com.google.android.flexbox.FlexboxLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        int r102 = this.f432949s;
        if (r102 >= 0) goto L5;
        super.onMeasure(r100, r101);
        return;
    L5:
        a r103 = this.f432948r;
        if (r103 == null) goto L8;
        int r104 = r103.f543496b;
    L9:
        super.onMeasure(r100, View.MeasureSpec.makeMeasureSpec(r104 * r102, 1073741824));
        return;
    L8:
        r104 = 0;
        goto L9
    }

    public RecentUsedEmojiView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setFlexDirection(0);
        setFlexWrap(1);
    }

    public final void v(List<b.c> r100, boolean r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "emojis");
        removeAllViews();
        a r103 = this.f432948r;
        if (r103 == null) goto L11;
        int r104 = this.f432949s;
        if (r104 >= 0) goto L7;
        int r105 = r100.size();
    L8:
        int r106 = 0;
    L9:
        if (r106 >= r105) goto L13;
        SingleEmojiView r107 = new SingleEmojiView(getContext());
        r107.b(r103);
        addView(r107);
        r107.a((b.c) ListProtector.get(r100, r106), r101, r102);
        r106 = r106 + 1;
        goto L9
    L13:
        return;
    L7:
        r105 = Math.min(r103.f543502h * r104, r100.size());
        goto L8
    }

    public /* synthetic */ RecentUsedEmojiView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
