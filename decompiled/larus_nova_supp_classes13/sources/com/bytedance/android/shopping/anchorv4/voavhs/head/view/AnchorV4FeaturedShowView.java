package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.n1;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/AnchorV4FeaturedShowView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4FeaturedShowView extends FrameLayout {
    public final int a;

    public AnchorV4FeaturedShowView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4FeaturedShowView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r1);
    }

    public AnchorV4FeaturedShowView(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        n1.i.getClass();
        this.a = (n1.a.d() - com.bytedance.android.shopping.extensions.b.b(32)) / 2;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r9).aU(2131560490, this, true).setBackgroundColor(com.bytedance.android.shopping.extensions.j.b(2131106003));
        List r12 = CollectionsKt.listOf(new Integer[]{2131372205, 2131372207, 2131372206, 2131372204});
        ArrayList r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator r14 = r12.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        r13.add(findViewById(((Number) r14.next()).intValue()));
        goto L4
    L6:
        Iterator r15 = r13.iterator();
        int r16 = 0;
    L8:
        if (r15.hasNext() == false) goto L24;
        Object r3 = r15.next();
        int r4 = r16 + 1;
        if (r16 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        View r5 = (View) r3;
        ViewGroup.LayoutParams r6 = r5.getLayoutParams();
        int r7 = this.a;
        r6.width = r7;
        if (r16 == 0) goto L23;
        if (r16 == 1) goto L21;
        if (r16 == 2) goto L20;
        if (r16 == 3) goto L19;
        r7 = 0;
        goto L23
    L19:
        r7 = (r7 * 74) / 171;
        goto L23
    L20:
        n1.i.getClass();
        int r17 = n1.a.d() - this.a;
        int r8 = com.bytedance.android.shopping.extensions.j.a(2131165695);
    L22:
        r7 = r17 - r8;
        goto L23
    L21:
        n1.i.getClass();
        r17 = n1.a.d() - ((this.a * 74) / 171);
        r8 = com.bytedance.android.shopping.extensions.j.a(2131165695);
    L23:
        r6.height = r7;
        Unit r18 = Unit.INSTANCE;
        r5.setLayoutParams(r6);
        r16 = r4;
        goto L8
    }

    public final void a(com.bytedance.android.shopping.anchorv4.voavhs.head.holder.d r10, com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r11, boolean r12) {
        List r0 = CollectionsKt.listOf(new Integer[]{2131372204, 2131372205, 2131372207, 2131372206});
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(findViewById(((Number) r2.next()).intValue()));
        goto L4
    L6:
        Iterator r3 = r1.iterator();
        int r4 = 0;
    L8:
        if (r3.hasNext() == false) goto L22;
        Object r5 = r3.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        SimpleDraweeView r7 = (SimpleDraweeView) r5;
        if (r10 == null) goto L21;
        w r8 = r10.a;
        if (r8 == null) goto L21;
        List<ImageModel> r9 = r8.c();
        if (r9 == null) goto L21;
        ImageModel r13 = (ImageModel) CollectionsKt.getOrNull(r9, r4);
        if (r13 == null) goto L21;
        y.a(r7, r13.getRemote());
    L21:
        r4 = r6;
        goto L8
    L22:
        TextWithOneIconElementView r14 = (TextWithOneIconElementView) findViewById(2131372208);
        if (r12 == false) goto L25;
        r14.setVisibility(8);
    L32:
        if (r10 == null) goto L36;
        String r15 = r10.b;
        if (r15 == null) goto L36;
    L37:
        setContentDescription(r15);
        if (r12 == false) goto L48;
        setBackgroundColor(-1);
        postDelayed(new f(this), 300);
        return;
    L48:
        return;
    L36:
        r15 = "图片，商品评论";
        goto L37
    L25:
        r14.setVisibility(0);
        if (r10 == null) goto L30;
        w r16 = r10.a;
        if (r16 == null) goto L30;
        TextWithOneIconElement r17 = r16.d();
    L31:
        TextWithOneIconElementView.b(r14, r17, null, false, null, 14);
        r14.setOnClickListener(new e(r11));
    L30:
        r17 = null;
        goto L31
    }

    public /* synthetic */ AnchorV4FeaturedShowView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
