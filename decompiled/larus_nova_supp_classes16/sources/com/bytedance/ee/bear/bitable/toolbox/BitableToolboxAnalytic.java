package com.bytedance.ee.bear.bitable.toolbox;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kr4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class BitableToolboxAnalytic extends BitableAnalytic {
    public String c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/BitableToolboxAnalytic$ToolboxEvent;", "", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ToolboxEvent {
        public static final String BITABLE_MOBILE_CARD_COVER_NUM_VIEW = "ccm_bitable_mobile_card_cover_num_view";
        public static final String BITABLE_MOBILE_GRID_FORMAT = "ccm_bitable_mobile_grid_format_view";
        public static final String BITABLE_MOBILE_GRID_FORMAT_CLICK = "ccm_bitable_mobile_grid_format_click";
        public static final String BOTTOM_TOOLBAR_CLICK = "ccm_bitable_mobile_bottom_toolbar_click";
        public static final String BOTTOM_TOOLBAR_VIEW = "ccm_bitable_mobile_bottom_toolbar_view";
        public static final a Companion = null;
        public static final String FILTER_PANEL_VIEW = "ccm_bitable_filter_set_view";
        public static final String LAYOUR_PANEL_CLICK = "ccm_bitable_mobile_grid_format_view";
        public static final String NO_PERMISSION_CLICK = "ccm_bitable_toolbar_click";
        public static final String NO_PERMISSION_VIEW = "ccm_bitable_toolbar_limited_tips_view";
        public static final String SORT_PANEL_CLICK = "ccm_bitable_sort_set_click";
        public static final String SORT_PANEL_VIEW = "ccm_bitable_sort_set_view";
        public static final String SORT_SET_HALFWAY_CLICK = "ccm_bitable_sort_set_halfway_click";

        public static final class a {
            public static final /* synthetic */ a a = null;

            static {
                a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.a;
        }
    }

    public BitableToolboxAnalytic(b r2) {
        Intrinsics.checkNotNullParameter(r2, "analyticConfig");
        super(r2);
        this.c = "";
    }

    public final void P(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "clickEvent");
        Intrinsics.checkNotNullParameter(r5, "setting_type");
        HashMap r1 = new HashMap();
        r1.put("click", r4);
        r1.put("target", "none");
        r1.put("setting_type", r5);
        t(ToolboxEvent.SORT_SET_HALFWAY_CLICK, r1);
    }

    public final void Q(Boolean r4, Integer r5, Boolean r6) {
        HashMap r0 = new HashMap();
        int r1 = 0;
        if (r4 == null) goto L5;
        boolean r7 = r4.booleanValue();
    L6:
        r0.put("is_auto_sort", Boolean.valueOf(r7));
        if (r5 == null) goto L9;
        r1 = r5.intValue();
    L9:
        r0.put("sort_count", Integer.valueOf(r1));
        if (r6 == null) goto L12;
        r0.put("is_premium_limited", Boolean.valueOf(r6.booleanValue()));
    L12:
        String r8 = ((BitableAnalytic) this).a.b();
        if (r8 == null) goto L15;
        r0.put("mobile_grid_type", r8);
    L15:
        r0.put("building_type", ((BitableAnalytic) this).a.d());
        t(ToolboxEvent.SORT_PANEL_VIEW, r0);
        return;
    L5:
        r7 = false;
        goto L6
    }

    public static void O(BitableToolboxAnalytic r2, String r3, Boolean r4, FieldCompositeType r5, Boolean r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = null;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "clickEvent");
        HashMap r8 = new HashMap();
        r8.put("click", r3);
        r8.put("target", "none");
        if (r4 != null) goto L14;
    L18:
        if (r5 == null) goto L22;
        String r9 = r5.getReportValue();
        if (r9 == null) goto L22;
        r8.put("field_type", r9);
    L22:
        if (r6 != null) goto L24;
    L28:
        String r10 = ((BitableAnalytic) r2).a.b();
        if (r10 == null) goto L31;
        r8.put("mobile_grid_type", r10);
    L31:
        r8.put("building_type", ((BitableAnalytic) r2).a.d());
        r2.t(ToolboxEvent.SORT_PANEL_CLICK, r8);
        return;
    L24:
        if (r6.booleanValue() == false) goto L26;
        String r11 = "option_inverse_order";
    L27:
        r8.put("rule", r11);
        goto L28
    L26:
        r11 = "option_order";
        goto L27
    L14:
        if (r4.booleanValue() == false) goto L16;
        String r12 = "open";
    L17:
        r8.put("status", r12);
        goto L18
    L16:
        r12 = "close";
        goto L17
    }
}
