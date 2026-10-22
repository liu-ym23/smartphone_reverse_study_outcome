package com.bytedance.ee.bear.bitable.itemview.recordpages;

import com.bytedance.ee.bear.bitable.itemview.record.ItemViewRecordContainer2;
import com.bytedance.ee.bear.bitable.itemview.util.ItemViewTracker;
import com.bytedance.ee.bear.bitable.uikit.Action;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class t extends gv4.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u f214234b;

    public t(u r100) {
        this.f214234b = r100;
    }

    @Override // gv4.e
    public final boolean b(Action r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        Intrinsics.checkNotNullParameter(r110, "<this>");
        boolean r100 = false;
        if (com.bytedance.ee.bear.bitable.uikit.a.b(r110) == false) goto L7;
        String r101 = r110.getNativeAction();
        Action.Companion.getClass();
        if (StringsKt.equals$default(r101, Action.access$getTYPE_SCROLL_LEFT$cp(), false, 2, null) == false) goto L7;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L53;
        u r111 = this.f214234b;
        r111.getClass();
        com.bytedance.ee.bear.bitable.itemview.util.l.a("RecordPages.tryScrollLeft", null, null, null, 14);
        ItemViewRecordFooterData r103 = r111.getCurrentRecordFooterData();
        if (r103 != null) goto L13;
    L15:
        boolean r104 = false;
    L16:
        if (r104 == true) goto L122;
        ItemViewRecordFooterData r105 = r111.getCurrentRecordFooterData();
        if (r105 == null) goto L122;
        String r106 = r105.getSwitchLeftToastMsg();
        if (r106 != null) goto L23;
    L28:
        boolean r107 = false;
    L29:
        if (r107 == false) goto L33;
        com.bytedance.ee.bear.bitable.itemview.util.l.a("RecordPages.tryScrollLeft:switchLeftToastMsg", null, null, null, 14);
        String r108 = r105.getSwitchLeftToastMsg();
        if (r108 == null) goto L122;
        Toast.showText(r111.getContext(), r108);
        goto L122
    L33:
        int r109 = r111.f214237b.f210924c.getCurrentItem() - 1;
        String r112 = (String) com.bytedance.ee.bear.bitable.m.j(r111.f214240e.getRecordList(), r109, null);
        if (r112 != null) goto L36;
    L41:
        if (r100 == true) goto L43;
    L52:
        com.bytedance.ee.bear.bitable.itemview.util.l.a("RecordPages.tryScrollLeft:preloadData", null, null, null, 14);
        r111.b();
        Toast.showText(r111.getContext(), R.string.Bitable_Record_LoadingCannotView_Mobile);
        goto L122
    L43:
        if (r111.f214240e.getRecordDataMap().containsKey(r112) == false) goto L52;
        ItemViewRecordPagesAdapter r113 = r111.f214238c;
        ItemViewRecordContainer2 r114 = r113.f214190c.get(r109);
        if (r114 == null) goto L47;
        r113.g(r114);
    L47:
        com.bytedance.ee.bear.bitable.itemview.util.l.a("RecordPages.tryScrollLeft:switchRight " + r109, null, null, null, 14);
        r111.f214237b.f210924c.setCurrentItem(r109, true);
        com.bytedance.ee.bear.bitable.itemview.b r115 = com.bytedance.ee.bear.bitable.itemview.util.i.c(r111);
        if (r115 == null) goto L122;
        ItemViewTracker r116 = r115.R0();
        if (r116 == null) goto L122;
        ((com.bytedance.ee.bear.bitable.statistic.c) r116.f214266f.getValue()).a(5000);
        goto L122
    L36:
        if (r112.length() <= 0) goto L38;
        boolean r117 = true;
    L39:
        if (r117 != true) goto L41;
        r100 = true;
        goto L41
    L38:
        r117 = false;
        goto L39
    L23:
        if (r106.length() <= 0) goto L25;
        boolean r118 = true;
    L26:
        if (r118 != true) goto L28;
        r107 = true;
        goto L29
    L25:
        r118 = false;
    L122:
        return true;
    L13:
        if (r103.enableScrollLeft() == true) goto L15;
        r104 = true;
        goto L16
    L53:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (com.bytedance.ee.bear.bitable.uikit.a.b(r110) == false) goto L58;
        String r119 = r110.getNativeAction();
        Action.Companion.getClass();
        if (StringsKt.equals$default(r119, Action.access$getTYPE_SCROLL_RIGHT$cp(), false, 2, null) == false) goto L58;
        boolean r120 = true;
    L59:
        if (r120 == false) goto L103;
        u r121 = this.f214234b;
        r121.getClass();
        com.bytedance.ee.bear.bitable.itemview.util.l.a("RecordPages.tryScrollRight", null, null, null, 14);
        ItemViewRecordFooterData r122 = r121.getCurrentRecordFooterData();
        if (r122 != null) goto L63;
    L65:
        boolean r123 = false;
    L66:
        if (r123 == true) goto L122;
        ItemViewRecordFooterData r124 = r121.getCurrentRecordFooterData();
        if (r124 == null) goto L122;
        String r125 = r124.getSwitchRightToastMsg();
        if (r125 != null) goto L73;
    L78:
        boolean r126 = false;
    L79:
        if (r126 == false) goto L83;
        com.bytedance.ee.bear.bitable.itemview.util.l.a("RecordPages.tryScrollRight:switchRightToastMsg", null, null, null, 14);
        String r127 = r124.getSwitchRightToastMsg();
        if (r127 == null) goto L122;
        Toast.showText(r121.getContext(), r127);
        goto L122
    L83:
        int r128 = r121.f214237b.f210924c.getCurrentItem() + 1;
        String r129 = (String) com.bytedance.ee.bear.bitable.m.j(r121.f214240e.getRecordList(), r128, null);
        if (r129 != null) goto L86;
    L91:
        if (r100 == true) goto L93;
    L102:
        com.bytedance.ee.bear.bitable.itemview.util.l.a("RecordPages.tryScrollRight:preloadData", null, null, null, 14);
        r121.b();
        Toast.showText(r121.getContext(), R.string.Bitable_Record_LoadingCannotView_Mobile);
        goto L122
    L93:
        if (r121.f214240e.getRecordDataMap().containsKey(r129) == false) goto L102;
        ItemViewRecordPagesAdapter r130 = r121.f214238c;
        ItemViewRecordContainer2 r131 = r130.f214190c.get(r128);
        if (r131 == null) goto L97;
        r130.g(r131);
    L97:
        com.bytedance.ee.bear.bitable.itemview.util.l.a("RecordPages.tryScrollRight:switchRight " + r128, null, null, null, 14);
        r121.f214237b.f210924c.setCurrentItem(r128, true);
        com.bytedance.ee.bear.bitable.itemview.b r132 = com.bytedance.ee.bear.bitable.itemview.util.i.c(r121);
        if (r132 == null) goto L122;
        ItemViewTracker r133 = r132.R0();
        if (r133 == null) goto L122;
        ((com.bytedance.ee.bear.bitable.statistic.c) r133.f214266f.getValue()).a(5000);
        goto L122
    L86:
        if (r129.length() <= 0) goto L88;
        boolean r134 = true;
    L89:
        if (r134 != true) goto L91;
        r100 = true;
        goto L91
    L88:
        r134 = false;
        goto L89
    L73:
        if (r125.length() <= 0) goto L75;
        boolean r135 = true;
    L76:
        if (r135 != true) goto L78;
        r126 = true;
        goto L79
    L75:
        r135 = false;
        goto L76
    L63:
        if (r122.enableScrollRight() == true) goto L65;
        r123 = true;
        goto L66
    L103:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        String r136 = r110.getAction();
        Action.Companion.getClass();
        if (StringsKt.equals$default(r136, Action.access$getTYPE_ADD_COMMENT$cp(), false, 2, null) == false) goto L111;
        String r137 = this.f214234b.getCurrentTableId();
        if (r137 != null) goto L108;
        return true;
    L108:
        com.bytedance.ee.bear.bitable.itemview.b r138 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this.f214234b);
        if (r138 == null) goto L122;
        r138.createNewDiscuss(r137, this.f214234b.getCurrentViewId(), this.f214234b.getCurrentRecordId());
        goto L122
    L111:
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (StringsKt.equals$default(r110.getAction(), Action.access$getTYPE_OPEN_COMMENT$cp(), false, 2, null) == false) goto L123;
        String r139 = this.f214234b.getCurrentRecordId();
        if (r139 != null) goto L116;
        return true;
    L116:
        String r140 = this.f214234b.getCurrentTableId();
        if (r140 != null) goto L119;
        return true;
    L119:
        com.bytedance.ee.bear.bitable.itemview.b r141 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this.f214234b);
        if (r141 == null) goto L122;
        r141.openDiscussDetailsPanel(r139, r140, null, null, 0);
        goto L122
    L123:
        return false;
    L58:
        r120 = false;
    L7:
        r102 = false;
        goto L9
    }
}
