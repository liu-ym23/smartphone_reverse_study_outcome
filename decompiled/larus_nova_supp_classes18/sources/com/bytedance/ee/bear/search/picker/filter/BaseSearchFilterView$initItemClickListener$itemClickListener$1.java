package com.bytedance.ee.bear.search.picker.filter;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BaseSearchFilterView$initItemClickListener$itemClickListener$1 implements FilterViewV2.c {
    public final /* synthetic */ BaseSearchFilterView a;

    public BaseSearchFilterView$initItemClickListener$itemClickListener$1(BaseSearchFilterView r1) {
        this.a = r1;
    }

    public final void a(cpc.a r4) {
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        String r0 = r4.a;
        switch(r0.hashCode()) {
            case -1058114788: goto L34;
            case -862523263: goto L28;
            case -287027157: goto L22;
            case -286430077: goto L16;
            case 797302193: goto L10;
            case 1502331690: goto L6;
            default: goto L50;
        };
    L50:
        return;
    L6:
        if (r0.equals("doc/my_own") == false) goto L51;
        em5.b r1 = this.a.getFilterDataHolder();
        final BaseSearchFilterView r2 = this.a;
        r1.c("doc/my_own", null, new BaseSearchFilterView$initItemClickListener$itemClickListener$1$onFilterItemClick$1(r2));
        return;
    L51:
        return;
    L10:
        if (r0.equals("doc/type") == false) goto L52;
        a r3 = this.a.getListener();
        if (r3 == null) goto L41;
        r3.Hj((em5.a) r4);
        return;
    L41:
        return;
    L52:
        return;
    L16:
        if (r0.equals("doc/in/wiki") == false) goto L53;
        a r5 = this.a.getListener();
        if (r5 == null) goto L43;
        r5.WZ((em5.a) r4);
        return;
    L43:
        return;
    L53:
        return;
    L22:
        if (r0.equals("doc/in/chat") == false) goto L54;
        a r6 = this.a.getListener();
        if (r6 == null) goto L45;
        r6.lZ((em5.a) r4);
        return;
    L45:
        return;
    L54:
        return;
    L28:
        if (r0.equals("doc/in/folder") == false) goto L55;
        a r7 = this.a.getListener();
        if (r7 == null) goto L47;
        r7.PF((em5.a) r4);
        return;
    L47:
        return;
    L55:
        return;
    L34:
        if (r0.equals("doc/owner") == false) goto L56;
        a r8 = this.a.getListener();
        if (r8 == null) goto L49;
        r8.j20((em5.a) r4);
        return;
    L49:
        return;
    }

    public final void b(cpc.a r4) {
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        em5.b r0 = this.a.getFilterDataHolder();
        String r5 = r4.a;
        final BaseSearchFilterView r2 = this.a;
        r0.c(r5, null, new BaseSearchFilterView$initItemClickListener$itemClickListener$1$onFilterItemCancelClick$1(r2));
    }
}
