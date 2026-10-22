package com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice;

import android.view.View;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ AnchorV4Tab b;
    public final /* synthetic */ TextWithOneIconElementView c;
    public final /* synthetic */ AnchorV4ReceivingNoticeView d;
    public final /* synthetic */ com.bytedance.android.shopping.anchorv4.voavhs.base.design.a e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ a g;
    public final /* synthetic */ AnchorV4ReceivingNoticeMeta h;

    public d(int r1, AnchorV4Tab r2, TextWithOneIconElementView r3, AnchorV4ReceivingNoticeView r4, com.bytedance.android.shopping.anchorv4.voavhs.base.design.a r5, boolean r6, b r7, AnchorV4ReceivingNoticeMeta r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        if (Intrinsics.areEqual(this.d.b, r6) == false) goto L5;
        return;
    L5:
        AnchorV4ReceivingNoticeView r0 = this.d;
        View r1 = r0.b;
        if (r1 == null) goto L13;
        AnchorV4Tab r3 = r0.c;
        if (r3 == null) goto L13;
        if (r1 == null) goto L12;
        Intrinsics.checkNotNull(r3);
        r0.c((TextWithOneIconElementView) r1, r3, Boolean.FALSE);
        goto L13
    L12:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView");
    L13:
        AnchorV4ReceivingNoticeView r2 = this.d;
        if (r6 == null) goto L28;
        r2.c((TextWithOneIconElementView) r6, this.b, Boolean.TRUE);
        this.d.b(this.b.getGroups(), this.e, this.f);
        AnchorV4ReceivingNoticeView r7 = this.d;
        r7.b = this.c;
        r7.c = this.b;
        a r8 = this.g;
        AnchorV4ReceivingNoticeMeta r4 = this.h;
        if (r4 == null) goto L22;
        AnchorV4ReceivingNoticeBusinessMeta r5 = r4.getBusinessMeta();
        if (r5 == null) goto L22;
        List<String> r9 = r5.getLogisticTypes();
        if (r9 == null) goto L22;
        String r10 = (String) CollectionsKt.getOrNull(r9, this.a);
    L23:
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        r8.a(r10);
        return;
    L22:
        r10 = null;
        goto L23
    L28:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView");
    }
}
