package com.larus.bmhome.chat.deepresearch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.layout.widget.MaxHeightRelativeLayout;
import com.larus.im.bean.message.block.Block;
import com.larus.mainbot.impl.databinding.LarusBlockItemCodeTextBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class d0 extends AbsFoldableBlockView {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RecyclerView f302354k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LarusBlockItemCodeTextBinding f302355l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Block f302356m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f302357n;

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void c() {
        this.f302356m = null;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableBlockView
    public View getContentBlockView() {
        LarusBlockItemCodeTextBinding r100 = this.f302355l;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f358438a;
    }

    public d0(Context r100, RecyclerView r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f302354k = r101;
        this.f302357n = i5.w();
    }

    public static View f(View r100, Class r101) {
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L19;
        View r105 = r102.getChildAt(r104);
        if (r101.isInstance(r105) == true) goto L8;
        Intrinsics.checkNotNull(r105);
        View r106 = f(r105, r101);
        if (r106 != null) goto L12;
        r104 = r104 + 1;
        goto L5
    L12:
        return r106;
    L8:
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type T of com.larus.bmhome.chat.deepresearch.view.MarkdownCodeBlockView.findChildViewByType");
        return r105;
    L19:
        return null;
    L14:
        return null;
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableBlockView, com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void a(Block r100, Map<String, Object> r101) {
        this.f302356m = r100;
        LarusBlockItemCodeTextBinding r102 = this.f302355l;
        if (r102 == null) goto L7;
        MaxHeightRelativeLayout r103 = r102.f358443f;
        if (r103 == null) goto L7;
        r103.setMaxHeight(this.f302357n);
    L7:
        LarusBlockItemCodeTextBinding r104 = this.f302355l;
        if (r104 == null) goto L16;
        CardView r105 = r104.f358439b;
        if (r105 == null) goto L16;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L15;
        r106.height = -2;
        r105.setLayoutParams(r106);
        goto L16
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L16:
        post(new b0(this));
        LarusBlockItemCodeTextBinding r107 = this.f302355l;
        if (r107 == null) goto L21;
        MarkdownIconTextBlockView r108 = r107.f358442e;
        if (r108 == null) goto L21;
        r108.a(r100, r101);
    L21:
        super.a(r100, r101);
    }

    @Override // com.larus.bmhome.chat.deepresearch.view.AbsFoldableBlockView, com.larus.bmhome.chat.deepresearch.view.AbsBlockView
    public final void b(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.b(r110, r111);
        View r112 = LayoutInflater.from(r110).inflate(R.layout.larus_block_item_code_text, this, false);
        addView(r112);
        CardView r100 = (CardView) r112;
        int r113 = R.id.deepResearchMask;
        View r101 = ViewBindings.findChildViewById(r112, R.id.deepResearchMask);
        if (r101 == null) goto L13;
        r113 = R.id.markdownCodeClickMask;
        View r102 = ViewBindings.findChildViewById(r112, R.id.markdownCodeClickMask);
        if (r102 == null) goto L13;
        r113 = R.id.markdownIconTextBlockView;
        MarkdownIconTextBlockView r103 = (MarkdownIconTextBlockView) ViewBindings.findChildViewById(r112, R.id.markdownIconTextBlockView);
        if (r103 == null) goto L13;
        r113 = R.id.markdownIconTextBlockViewContainer;
        MaxHeightRelativeLayout r104 = (MaxHeightRelativeLayout) ViewBindings.findChildViewById(r112, R.id.markdownIconTextBlockViewContainer);
        if (r104 == null) goto L13;
        this.f302355l = new LarusBlockItemCodeTextBinding(r100, r100, r101, r102, r103, r104);
        r103.f302274k = this.f302354k;
        com.larus.utils.e1.d(r102, new c0(this));
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r112.getResources().getResourceName(r113)));
    }
}
