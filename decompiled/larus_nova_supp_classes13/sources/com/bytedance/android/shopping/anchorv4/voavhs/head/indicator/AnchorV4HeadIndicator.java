package com.bytedance.android.shopping.anchorv4.voavhs.head.indicator;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import c63.d;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.header.AnchorV4VideoImageIndicator;
import com.bytedance.android.shopping.anchorv4.voavhs.head.CommonFindSameElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.b;
import com.bytedance.android.shopping.anchorv4.voavhs.head.c;
import com.bytedance.android.shopping.extensions.j;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.common.utility.UIUtils;
import f83.e;
import f83.f;
import f83.g;
import f83.h;
import f83.i;
import f83.l;
import f83.n;
import f83.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import wg.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/indicator/AnchorV4HeadIndicator;", "Landroid/widget/FrameLayout;", "Lf83/l;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/CommonFindSameElement;", "getFindSameElement", "Lf83/p;", "j", "Lf83/p;", "getTabLogicInterceptor", "()Lf83/p;", "tabLogicInterceptor", "Lc63/d;", "k", "Lc63/d;", "getLogAction", "()Lc63/d;", "logAction", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4HeadIndicator extends FrameLayout implements l {
    public boolean a;
    public AnchorV4FindSameIndicator b;
    public final boolean c;
    public final boolean d;
    public String e;
    public final AnchorV4TabIndicator f;
    public final AnchorV4FoldableTabIndicator g;
    public final TextView h;
    public View i;
    public final p j;
    public final d k;
    public final CommonFindSameElement l;

    public AnchorV4HeadIndicator(Context r10) {
        this(r10, null, 0, null, null, null, false, 126);
    }

    public AnchorV4HeadIndicator(Context r10, AttributeSet r11) {
        this(r10, r11, 0, null, null, null, false, 124);
    }

    public AnchorV4HeadIndicator(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, null, null, null, false, 120);
    }

    @Override // f83.l
    public CommonFindSameElement getFindSameElement() {
        return this.l;
    }

    public final d getLogAction() {
        return this.k;
    }

    public final p getTabLogicInterceptor() {
        return this.j;
    }

    @Override // f83.l
    public final void a(boolean r2) {
        AnchorV4FindSameIndicator r0 = this.b;
        if (r0 == null) goto L9;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        return;
    L6:
        r3 = 8;
        goto L7
    }

    @Override // f83.l
    public final void h(boolean r3) {
        if (this.c == true) goto L12;
        AnchorV4TabIndicator r0 = this.f;
        if (r3 == true) goto L7;
    L9:
        int r1 = 8;
    L10:
        r0.setVisibility(r1);
        goto L12
    L7:
        if (this.a == false) goto L9;
        r1 = 0;
    L12:
        if (this.d == false) goto L15;
        a.h(this.g, r3);
        return;
    }

    @Override // f83.l
    public final void c(List<String> r22, List<b> r23, List<String> r24) {
        Intrinsics.checkNotNullParameter(r22, "titleTags");
        Intrinsics.checkNotNullParameter(r23, "originTags");
        Intrinsics.checkNotNullParameter(r24, "tabTypes");
        if (this.c == true) goto L10;
        this.f.b(CollectionsKt.filterNotNull(r22), CollectionsKt.filterNotNull(r24));
        AnchorV4TabIndicator r6 = this.f;
        if (((ArrayList) r22).size() <= 1) goto L7;
        int r10 = 0;
    L8:
        r6.setVisibility(r10);
        goto L10
    L7:
        r10 = 8;
    L10:
        if (this.d == false) goto L69;
        AnchorV4FoldableTabIndicator r7 = this.g;
        List r15 = CollectionsKt.filterNotNull(r22);
        List r5 = CollectionsKt.filterNotNull(r24);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r15, "indicatorTags");
        Intrinsics.checkNotNullParameter(r23, "originTags");
        Intrinsics.checkNotNullParameter(r5, "tabTypes");
        r7.a.removeAllViews();
        r7.b.removeAllViews();
        ((ArrayList) r7.e).clear();
        ((ArrayList) r7.i).clear();
        List<b> r2 = r23;
        Iterator<T> r3 = r2.iterator();
    L13:
        if (r3.hasNext() == false) goto L18;
        b r4 = (b) r3.next();
        Iterator<T> r11 = r4.c.iterator();
    L16:
        if (r11.hasNext() == false) goto L13;
        c r12 = (c) r11.next();
        List<String> r13 = r7.i;
        ArrayList r14 = (ArrayList) r13;
        r14.add(r4.a);
        goto L16
    L18:
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r2.iterator();
    L20:
        if (r9.hasNext() == false) goto L27;
        Object r16 = r9.next();
        if (((b) r16).a == null) goto L24;
        boolean r17 = true;
    L25:
        if (r17 == false) goto L20;
        r8.add(r16);
        goto L20
    L24:
        r17 = false;
        goto L25
    L27:
        Iterator r18 = r15.iterator();
        int r19 = 0;
    L29:
        if (r18.hasNext() == false) goto L69;
        Object r110 = r18.next();
        int r111 = r19 + 1;
        if (r19 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        String r112 = (String) r110;
        b r113 = (b) CollectionsKt.getOrNull(r8, r19);
        if (r113 != null) goto L36;
    L41:
        String r114 = null;
    L42:
        int r115 = AnchorV4FoldableTabIndicator.p;
        if (r19 != 0) goto L49;
        Context r116 = r7.getContext();
        StringBuilder r20 = new StringBuilder();
        r20.append(r112);
        p r21 = r7.m;
        if (r21 == null) goto L47;
        Integer r25 = Integer.valueOf(r21.d());
    L48:
        r20.append(j.e(2131914060, 1, Integer.valueOf(k.f(r25))));
        TextView r26 = AnchorV4FoldableTabIndicator.a.a(r116, r20.toString());
        r7.g = r26;
        r7.b.addView(r26, new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20)));
        n r27 = new n(r7.g, r112, r114);
        String r0 = r112;
        r7.g.setOnClickListener(new f83.d(r27, r19, r7, r8, r15, r5));
        ((ArrayList) r7.e).add(r27);
    L50:
        if (r19 != 0) goto L65;
        r7.h = r0;
        if (r15.size() <= 1) goto L54;
        String r117 = r0;
    L56:
        if (r15.size() != 1) goto L58;
        boolean r28 = true;
    L59:
        r7.j = r28;
        Context r29 = r7.getContext();
        StringBuilder r30 = new StringBuilder();
        r30.append(r117);
        p r31 = r7.m;
        if (r31 == null) goto L62;
        Integer r118 = Integer.valueOf(r31.d());
    L63:
        r30.append(j.e(2131914060, 1, Integer.valueOf(k.f(r118))));
        TextView r32 = AnchorV4FoldableTabIndicator.a.a(r29, r30.toString());
        r32.setBackgroundDrawable(ag4.a.c(2131231273));
        Unit r33 = Unit.INSTANCE;
        r7.f = r32;
        r7.a.addView(r32, new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20)));
        f r1 = new f(new n(r7.f, r0, null), r19, r7, r8, r15, r5);
        r7.f.setOnClickListener(r1);
    L67:
        r7.d(0, (String) CollectionsKt.getOrNull(r5, 0), true);
        r19 = r111;
        r18 = r18;
        r15 = r15;
        goto L29
    L62:
        r118 = null;
        goto L63
    L58:
        r28 = false;
        goto L59
    L54:
        r117 = "";
        goto L56
    L65:
        if (r19 != 1) goto L67;
        Context r34 = r7.getContext();
        Intrinsics.checkNotNullParameter(r34, "context");
        ImageView r35 = new ImageView(r34);
        r35.setImageResource(2131234470);
        int r36 = (int) UIUtils.dip2Px(r34, 4.0f);
        r35.setPadding(r36, r36, r36, r36);
        r35.post(new h(r35));
        r35.setOnClickListener(new g(new n(r35, r0, null), r7, r8, r15, r5));
        r7.a.setContentDescription("展开");
        r7.a.addView(r35, new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20)));
        goto L67
    L47:
        r25 = null;
        goto L48
    L49:
        r0 = r112;
        TextView r37 = AnchorV4FoldableTabIndicator.a.a(r7.getContext(), r0);
        n r38 = new n(r37, r0, r114);
        r37.setOnClickListener(new e(r38, r19, r7, r8, r15, r5));
        r7.b.addView(r37, new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20)));
        ((ArrayList) r7.e).add(r38);
        goto L50
    L36:
        if (Intrinsics.areEqual(r113.a, r112) == true) goto L39;
        r113 = null;
    L39:
        if (r113 == null) goto L41;
        r114 = r113.e;
    L69:
        if (((ArrayList) r22).size() <= 1) goto L71;
        boolean r39 = true;
    L72:
        this.a = r39;
        return;
    L71:
        r39 = false;
        goto L72
    }

    @Override // f83.l
    public final void b(Integer r3, int r4, String r5, boolean r6) {
        if (r3 != null) goto L4;
    L9:
        TextView r7 = this.h;
        Integer r8 = Integer.valueOf(r4 + 1);
        p r9 = this.j;
        if (r9 == null) goto L12;
        Integer r10 = Integer.valueOf(r9.d());
    L13:
        r7.setText(j.e(2131914060, r8, Integer.valueOf(k.f(r10))));
        return;
    L12:
        r10 = null;
        goto L13
    L4:
        if (this.c == true) goto L7;
        this.f.a(r3.intValue(), r5, r6);
    L7:
        if (this.d == false) goto L9;
        this.g.b(r3, r4, r5, r6);
        goto L9
    }

    public AnchorV4HeadIndicator(Context r20, AttributeSet r21, int r22, p r23, d r24, CommonFindSameElement r25, boolean r26, int r27) {
        CommonFindSameElement r2 = null;
        if ((r27 & 2) == 0) goto L5;
        AttributeSet r1 = null;
    L7:
        if ((r27 & 4) == 0) goto L9;
        int r3 = 0;
    L11:
        if ((r27 & 8) == 0) goto L13;
        p r5 = null;
    L15:
        if ((r27 & 16) == 0) goto L17;
        d r6 = null;
    L19:
        if ((r27 & 32) != 0) goto L23;
        r2 = r25;
    L23:
        if ((r27 & 64) == 0) goto L25;
        boolean r7 = false;
    L26:
        Intrinsics.checkNotNullParameter(r20, "context");
        super(r20, r1, r3);
        this.j = r5;
        this.k = r6;
        this.l = r2;
        this.a = true;
        boolean r14 = com.bytedance.android.shopping.anchorv4.experiment.d.a();
        this.c = r14;
        boolean r15 = com.bytedance.android.shopping.anchorv4.experiment.d.a();
        this.d = r15;
        AnchorV4TabIndicator r9 = new AnchorV4TabIndicator(r20, null, 0, new f83.j(this), 22);
        this.f = r9;
        AnchorV4FoldableTabIndicator r8 = new AnchorV4FoldableTabIndicator(r20, null, 0, r5, r6, r7, new i(this), 6);
        this.g = r8;
        AnchorV4VideoImageIndicator.d.getClass();
        Intrinsics.checkNotNullParameter(r20, "context");
        Intrinsics.checkNotNullParameter("", "textValue");
        TextView r4 = new TextView(r20);
        r4.setBackgroundResource(2131233420);
        ColorStateList r10 = new ColorStateList(new int[][]{new int[]{R.attr.state_selected}, new int[0]}, new int[]{-16777216, -1});
        int r11 = (int) UIUtils.dip2Px(r4.getContext(), 10.0f);
        int r12 = (int) UIUtils.dip2Px(r4.getContext(), 2.5f);
        r4.setTextSize(12.0f);
        r4.setTypeface(Typeface.DEFAULT_BOLD);
        r4.setTextColor(r10);
        r4.setPadding(r11, r12, r11, r12);
        r4.setText("");
        r4.setGravity(17);
        this.h = r4;
        int r13 = 20;
        if (r15 == false) goto L30;
        FrameLayout.LayoutParams r16 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20));
        r16.gravity = 8388693;
        Unit r17 = Unit.INSTANCE;
        r16.rightMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r8, r16);
        return;
    L30:
        if (r14 == false) goto L32;
        r13 = 24;
    L32:
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r13)));
        r18.gravity = 8388693;
        Unit r19 = Unit.INSTANCE;
        r18.rightMargin = com.bytedance.android.shopping.extensions.b.b(12);
        addView(r4, r18);
        FrameLayout.LayoutParams r28 = new FrameLayout.LayoutParams(-2, -2);
        r28.gravity = 17;
        addView(r9, r28);
        return;
    L25:
        r7 = r26;
        goto L26
    L17:
        r6 = r24;
        goto L19
    L13:
        r5 = r23;
        goto L15
    L9:
        r3 = r22;
        goto L11
    L5:
        r1 = r21;
        goto L7
    }
}
