package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.AbsFullSpanVH;
import com.bytedance.android.shopping.anchorv4.dto.base.Action;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.helper.q;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/AnchorV4ReceivingNoticeVH;", "Lcom/bytedance/android/shopping/anchorv3/detail/viewholder/AbsFullSpanVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/c;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/base/design/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ReceivingNoticeVH extends AbsFullSpanVH<c> implements com.bytedance.android.shopping.anchorv4.log.d, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a {
    public final b m;
    public final ViewGroup n;
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d o;
    public final Context p;
    public final e q;

    public final int M0() {
        return 0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void l0(Action r1, Object r2) {
    }

    public final void onScan() {
    }

    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final Function0<Unit> p0(Action r1) {
        return null;
    }

    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    public final void a4(Object r22) {
        c r10 = (c) r22;
        Intrinsics.checkNotNullParameter(r10, "item");
        View r1 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r1 instanceof AnchorV4ReceivingNoticeView) == true) goto L5;
        r1 = null;
    L5:
        AnchorV4ReceivingNoticeView r11 = (AnchorV4ReceivingNoticeView) r1;
        if (r11 == null) goto L62;
        AnchorV4ReceivingNoticeDisplay r2 = r10.b;
        AnchorV4ReceivingNoticeMeta r12 = r10.c;
        b r13 = this.m;
        CommonMeta r3 = this.q.a();
        if (r3 == null) goto L10;
        Boolean r4 = Boolean.valueOf(r3.getEnablePDPOptimize());
    L11:
        boolean r14 = k.i(r4);
        Intrinsics.checkNotNullParameter(r10, "item");
        Intrinsics.checkNotNullParameter(this, "actionHub");
        Intrinsics.checkNotNullParameter(r13, "logAction");
        if (r2 == null) goto L61;
        List<AnchorV4Tab> r0 = r2.getTabs();
        int r5 = 0;
        if (r0 != null) goto L16;
    L19:
        boolean r6 = true;
    L20:
        if (r6 == true) goto L61;
        r11.getClass();
        r11.setVisibility(0);
        ((LongContentLabelComponentView) r11.a(2131383858)).bind(r2.getTitle());
        ((LinearLayout) r11.a(2131382264)).removeAllViews();
        Iterator<T> r16 = r2.getTabs().iterator();
        int r7 = 0;
    L24:
        if (r16.hasNext() == false) goto L56;
        Object r8 = r16.next();
        int r18 = r7 + 1;
        if (r7 >= 0) goto L28;
        CollectionsKt.throwIndexOverflow();
    L28:
        AnchorV4Tab r9 = (AnchorV4Tab) r8;
        TextWithOneIconElementView r15 = new TextWithOneIconElementView(r11.getContext(), null, 0, null, 30);
        c r19 = r10;
        b r20 = r13;
        r15.setOnClickListener(new d(r7, r9, r15, r11, this, r14, r13, r12));
        ViewGroup.LayoutParams r17 = null;
        r11.c(r15, r9, null);
        TextWithOneIconElement r21 = r9.getTabName();
        if (r21 == null) goto L31;
        String r23 = r21.getStatusId();
    L33:
        if (Intrinsics.areEqual(r23, TabSelection.SELECTED.getValue()) == false) goto L35;
        r11.b(r9.getGroups(), this, r14);
    L35:
        ((LinearLayout) r11.a(2131382264)).addView(r15, new LinearLayout.LayoutParams(0, com.bytedance.android.shopping.extensions.b.b(28), 1.0f));
        if (r20 == null) goto L39;
        r20.b();
    L39:
        if (r14 == false) goto L54;
        View r24 = r11.a(2131382264);
        ViewGroup.LayoutParams r25 = r24.getLayoutParams();
        if ((r25 instanceof ViewGroup.MarginLayoutParams) == true) goto L43;
        r25 = null;
    L43:
        ViewGroup.MarginLayoutParams r26 = (ViewGroup.MarginLayoutParams) r25;
        if (r26 == null) goto L46;
        r26.topMargin = com.bytedance.android.shopping.extensions.b.b(16);
        r24.setLayoutParams(r26);
    L46:
        View r27 = r11.a(2131383852);
        ViewGroup.LayoutParams r28 = r27.getLayoutParams();
        if ((r28 instanceof ViewGroup.MarginLayoutParams) == false) goto L50;
        r17 = r28;
    L50:
        ViewGroup.MarginLayoutParams r29 = (ViewGroup.MarginLayoutParams) r17;
        if (r29 == null) goto L53;
        r29.topMargin = com.bytedance.android.shopping.extensions.b.b(0);
        r27.setLayoutParams(r29);
    L53:
        ((LinearLayout) r11.a(2131383852)).setDividerDrawable(com.bytedance.commerce.base.drawable.a.a(AnchorV4ReceivingNoticeView$bind$1$4.INSTANCE));
        r11.d.f(new Radius(12, 12, 12, 12));
        r11.setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), 0);
    L55:
        r7 = r18;
        r10 = r19;
        r13 = r20;
        r5 = 0;
        goto L24
    L54:
        ((LinearLayout) r11.a(2131383852)).setDividerDrawable(com.bytedance.commerce.base.drawable.a.a(AnchorV4ReceivingNoticeView$bind$1$5.INSTANCE));
        r11.setPadding(com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(12), com.bytedance.android.shopping.extensions.b.b(16));
        goto L55
    L31:
        r23 = null;
        goto L33
    L56:
        c r110 = r10;
        if (r14 == false) goto L59;
        Integer[] r30 = new Integer[4];
        r30[r5] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        r30[1] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        r30[2] = Integer.valueOf(r5);
        r30[3] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        List r31 = CollectionsKt.listOf(r30);
        int r32 = 12;
    L60:
        int r33 = q.a;
        c r34 = r110;
        q.a(r11, r34.e, r11.d, r32, -1, r31);
    L63:
        this.o.b(this, r34);
        View r35 = ((RecyclerView.ViewHolder) this).itemView;
        if (r35 == null) goto L68;
        ExtensionsKt.e((ViewGroup) r35, this);
        return;
    L68:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L59:
        Integer[] r36 = new Integer[4];
        r36[r5] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        r36[1] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        r36[2] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(16));
        r36[3] = Integer.valueOf(com.bytedance.android.shopping.extensions.b.b(12));
        r31 = CollectionsKt.listOf(r36);
        r32 = 8;
        goto L60
    L16:
        if (r0.isEmpty() == true) goto L19;
        r6 = false;
    L61:
        r34 = r10;
        r11.setVisibility(8);
        goto L63
    L10:
        r4 = null;
        goto L11
    L62:
        r34 = r10;
        goto L63
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.base.design.a
    public final void O0(View r9, Action r10, Object r11) {
        Intrinsics.checkNotNullParameter(r9, FreqActions.ACTION_VIEW);
        Intrinsics.checkNotNullParameter(r10, "action");
        String r12 = r10.getId();
        AnchorV4ReceivingNoticeDisplay r13 = ((c) getItem()).b;
        if (r13 == null) goto L35;
        List<AnchorV4Tab> r14 = r13.getTabs();
        if (r14 == null) goto L46;
        Iterator<T> r15 = r14.iterator();
        int r0 = 0;
    L8:
        if (r15.hasNext() == false) goto L47;
        Object r1 = r15.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        List<Group> r3 = ((AnchorV4Tab) r1).getGroups();
        if (r3 == null) goto L34;
        Iterator<T> r4 = r3.iterator();
        int r5 = 0;
    L16:
        if (r4.hasNext() == false) goto L34;
        Object r6 = r4.next();
        int r7 = r5 + 1;
        if (r5 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        Group r8 = (Group) r6;
        if (Intrinsics.areEqual("receiving_notices_tab_" + r0 + "_group_" + r5, r12) == false) goto L33;
        AnchorV4ReceivingNoticeMeta r16 = ((c) getItem()).c;
        if (r16 == null) goto L33;
        AnchorV4ReceivingNoticeBusinessMeta r17 = r16.getBusinessMeta();
        if (r17 == null) goto L33;
        Map<String, String> r18 = r17.getJumpUrls();
        if (r18 == null) goto L33;
        String r19 = r18.get(r12);
        if (r19 == null) goto L33;
        String r20 = a2.d(r19);
        if (r20 == null) goto L33;
        JSONObject r21 = new JSONObject();
        r21.put("selectedIndex", r0);
        Context r22 = this.p;
        this.q.j();
        com.bytedance.android.shopping.anchorv4.containers.b.b(r22, r20, r21, this.q.d());
    L33:
        r5 = r7;
    L34:
        r0 = r2;
        goto L8
    L47:
        return;
    L46:
        return;
    }

    public AnchorV4ReceivingNoticeVH(ViewGroup r6, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r7, FragmentActivity r8, e r9) {
        Intrinsics.checkNotNullParameter(r6, "viewGroup");
        Intrinsics.checkNotNullParameter(r7, "logManager");
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        AttributeSet r4 = null;
        super(new AnchorV4ReceivingNoticeView(r6.getContext(), r4, 6, 0), true);
        this.n = r6;
        this.o = r7;
        this.p = r8;
        this.q = r9;
        this.m = new b(this);
    }
}
