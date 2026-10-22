package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Radius;
import com.bytedance.android.shopping.anchorv4.dto.components.LongContentLabelComponent;
import com.bytedance.android.shopping.anchorv4.dto.components.TagsScrollBoxComponent;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.voavhs.base.components.LongContentLabelComponentView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ExtensionsKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/receivingnotice/AnchorV4ReceivingNoticeView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4ReceivingNoticeView extends LinearLayout {
    public Map<Integer, View> a;
    public View b;
    public AnchorV4Tab c;
    public final com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b d;

    public AnchorV4ReceivingNoticeView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4ReceivingNoticeView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final View a(int r3) {
        if (this.a != null) goto L5;
        this.a = new LinkedHashMap();
    L5:
        View r0 = this.a.get(Integer.valueOf(r3));
        if (r0 != null) goto L12;
        View r1 = findViewById(r3);
        if (r1 == null) goto L10;
        this.a.put(Integer.valueOf(r3), r1);
        return r1;
    L10:
        return null;
    L12:
        return r0;
    }

    public AnchorV4ReceivingNoticeView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.a = new LinkedHashMap();
        com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b r5 = new com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.b(this);
        this.d = r5;
        LinearLayout.inflate(r2, 2131564614, this);
        setOrientation(1);
        setBackgroundColor(-1);
        r5.f(new Radius(8, 8, 8, 8));
        ((LinearLayout) a(2131382264)).setShowDividers(2);
        ((LinearLayout) a(2131382264)).setDividerDrawable(com.bytedance.commerce.base.drawable.a.a(AnonymousClass1.INSTANCE));
        ((LinearLayout) a(2131383852)).setShowDividers(2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final void b(List r21, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r22, boolean r23) {
        ((LinearLayout) a(2131383852)).removeAllViews();
        if (r21 == null) goto L61;
        Iterator r2 = r21.iterator();
        ?? r3 = 0;
        int r4 = 0;
    L6:
        if (r2.hasNext() == false) goto L61;
        Object r5 = r2.next();
        int r6 = r4 + 1;
        if (r4 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        Group r7 = (Group) r5;
        View r8 = th.a.c(getContext(), 2131564615, (ViewGroup) a(2131383852), r3);
        if (r23 == false) goto L13;
        r8.setPadding(r3, com.bytedance.android.shopping.extensions.b.b(16), r3, com.bytedance.android.shopping.extensions.b.b(16));
    L13:
        int r9 = 2131374014;
        ((LinearLayout) r8.findViewById(2131374014)).setShowDividers(2);
        ((LinearLayout) r8.findViewById(2131374014)).setDividerDrawable(com.bytedance.commerce.base.drawable.a.a(AnchorV4ReceivingNoticeView$updateReceiveDescription$1$1.INSTANCE));
        ((TextElementView) r8.findViewById(2131373984)).x(r7.getGroupName());
        List<LongContentLabelComponent> r10 = r7.getGroupTips();
        if (r10 == null) goto L60;
        Iterator<T> r11 = r10.iterator();
        int r12 = 0;
        LongContentLabelComponent r13 = null;
    L17:
        if (r11.hasNext() == false) goto L60;
        Object r14 = r11.next();
        int r15 = r12 + 1;
        if (r12 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        LongContentLabelComponent r16 = (LongContentLabelComponent) r14;
        LongContentLabelComponentView r17 = new LongContentLabelComponentView(getContext(), null, null, 6, null);
        r17.bind(r16);
        TagsScrollBoxComponent r18 = r16.getHeadButtons();
        if (r18 == null) goto L28;
        List r19 = r18.getButtonList();
        if (r19 == null) goto L28;
        TextWithOneIconElement r110 = (TextWithOneIconElement) CollectionsKt.firstOrNull(r19);
        if (r110 == null) goto L28;
        ImageModel r111 = r110.getIcon();
    L29:
        if (r111 == null) goto L31;
        boolean r112 = true;
    L32:
        LinearLayout r113 = (LinearLayout) r8.findViewById(r9);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-1, -2);
        if (r12 == 0) goto L56;
        if (r13 == null) goto L54;
        if (r112 == true) goto L54;
        TagsScrollBoxComponent r20 = r13.getHeadButtons();
        if (r20 == null) goto L54;
        List r24 = r20.getButtonList();
        if (r24 == null) goto L54;
        TextWithOneIconElement r25 = (TextWithOneIconElement) CollectionsKt.firstOrNull(r24);
        if (r25 == null) goto L54;
        ImageModel r26 = r25.getIcon();
        if (r26 == null) goto L54;
        ECUrlModel r27 = r26.getRemote();
        if (r27 == null) goto L48;
        int r28 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r27.getWidth()));
    L49:
        TagsScrollBoxComponent r29 = r13.getHeadButtons();
        if (r29 == null) goto L52;
        int r30 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r29.getSpace()));
    L53:
        int r31 = (r28 + r30) - com.bytedance.android.shopping.extensions.b.b(Double.valueOf(0.5d));
    L55:
        r114.leftMargin = r31;
        goto L56
    L52:
        r30 = 0;
        goto L53
    L48:
        r28 = 0;
    L54:
        r31 = 0;
    L56:
        Unit r32 = Unit.INSTANCE;
        r113.addView(r17, r114);
        if (r112 == false) goto L59;
        r13 = r16;
    L59:
        r12 = r15;
        r9 = 2131374014;
        goto L17
    L31:
        r112 = false;
    L28:
        r111 = null;
    L60:
        ((LinearLayout) a(2131383852)).addView(r8);
        r4 = r6;
        r3 = 0;
    L61:
        ExtensionsKt.e((ViewGroup) a(2131383852), r22);
    }

    public final void c(TextWithOneIconElementView r7, AnchorV4Tab r8, Boolean r9) {
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L6;
        TextWithOneIconElementView.b(r7, r8.getTabName(), TabSelection.SELECTED.getValue(), false, null, 12);
        this.b = r7;
        this.c = r8;
        return;
    L6:
        if (Intrinsics.areEqual(r9, Boolean.FALSE) == false) goto L8;
        TextWithOneIconElementView.b(r7, r8.getTabName(), TabSelection.UNSELECTED.getValue(), false, null, 12);
        return;
    L8:
        if (r9 != null) goto L19;
        TextWithOneIconElementView.b(r7, r8.getTabName(), null, false, null, 14);
        TextWithOneIconElement r0 = r8.getTabName();
        if (r0 == null) goto L12;
        String r1 = r0.getStatusId();
    L14:
        if (Intrinsics.areEqual(r1, TabSelection.SELECTED.getValue()) == false) goto L20;
        this.b = r7;
        this.c = r8;
        return;
    L20:
        return;
    L12:
        r1 = null;
        goto L14
    }

    public /* synthetic */ AnchorV4ReceivingNoticeView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
