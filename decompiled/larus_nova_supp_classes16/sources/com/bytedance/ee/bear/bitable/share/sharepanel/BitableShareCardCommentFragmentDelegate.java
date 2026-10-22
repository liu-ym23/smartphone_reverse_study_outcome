package com.bytedance.ee.bear.bitable.share.sharepanel;

import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareState;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.util.info.AppInfoUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableShareCardCommentFragmentDelegate extends BitableShareCardV2FragmentDelegate {
    public final String h;
    public final String i;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final Map<String, String> s() {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = this.h;
        if (r1 == null) goto L5;
        String r2 = (String) r0.put("comment_id", r1);
    L5:
        String r3 = this.i;
        if (r3 == null) goto L8;
        String r4 = (String) r0.put("reply_id", r3);
    L8:
        r0.putAll(MapsKt.emptyMap());
        return r0;
    }

    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareCardV2FragmentDelegate, com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void onViewCreated() {
        super.onViewCreated();
        int r0 = com.bytedance.ee.bear.bitable.c.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.d("base.comment_optimization.enable") == false) goto L5;
        p().Ax(2131886346);
        return;
    L5:
        p().Ax(2131886342);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.ee.bear.bitable.share.sharepanel.BitableShareCardV2FragmentDelegate, com.bytedance.ee.bear.bitable.share.sharepanel.a
    public final void y(boolean r10) {
        if (v() == true) goto L5;
        return;
    L5:
        this.e = r10;
        List r0 = p().ul();
        boolean r1 = AppInfoUtils.f().booleanValue();
        final BitableShareCardCommentFragmentDelegate$updateExternalShareView$config$1 r2 = BitableShareCardCommentFragmentDelegate$updateExternalShareView$config$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r0, "externalConfig");
        Intrinsics.checkNotNullParameter(r2, "defaultItemProvider");
        if (r1 == false) goto L20;
        ArrayList r3 = new ArrayList();
        Iterator r4 = r0.iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        Object r5 = r4.next();
        ShareItemModel r6 = (ShareItemModel) r5;
        if (r6.getType() != ShareType.CopyLink) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L9;
        r3.add(r5);
        goto L9
    L13:
        if (r6.getType() == ShareType.QRCode) goto L16;
        r7 = false;
        goto L17
    L19:
        List r8 = com.bytedance.ee.bear.bitable.share.sharepanel.a.C0018a.a(r3, true, true, new BitableShareCardCommentFragmentDelegate$Companion$getCommentShareItemConfig$1(r2));
    L21:
        if (r10 == true) goto L26;
        Iterator r11 = r8.iterator();
    L24:
        if (r11.hasNext() == false) goto L30;
        ((ShareItemModel) r11.next()).setState(ShareState.NOT_CLICK);
    L30:
        p().L30(r8);
        p().YH();
        return;
    L26:
        Iterator r12 = r8.iterator();
    L28:
        if (r12.hasNext() == false) goto L30;
        ((ShareItemModel) r12.next()).setState(ShareState.SHOW);
        goto L28
    L20:
        r8 = CollectionsKt.mutableListOf(new ShareItemModel[]{r2.invoke(ShareType.Lark), r2.invoke(ShareType.CopyLink), r2.invoke(ShareType.QRCode)});
        goto L21
    }

    public BitableShareCardCommentFragmentDelegate(com.bytedance.ee.bear.share.export.e r1, String r2, String r3, String r4) {
        super(r1, r2);
        this.h = r3;
        this.i = r4;
    }
}
