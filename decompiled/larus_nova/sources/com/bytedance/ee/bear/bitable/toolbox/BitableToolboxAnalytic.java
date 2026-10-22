package com.bytedance.ee.bear.bitable.toolbox;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import kr4.b;

/* JADX INFO: loaded from: classes16.dex */
public final class BitableToolboxAnalytic extends BitableAnalytic {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f215993c;

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

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f215994a = null;

            static {
                f215994a = new a();
            }

            public a() {
            }
        }

        static {
            Companion = a.f215994a;
        }
    }

    public BitableToolboxAnalytic(b r100) {
        Intrinsics.checkNotNullParameter(r100, "analyticConfig");
        super(r100);
        this.f215993c = "";
    }

    public final void P(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "clickEvent");
        Intrinsics.checkNotNullParameter(r101, "setting_type");
        HashMap r102 = new HashMap();
        r102.put("click", r100);
        r102.put(PickerReporterConstants.KEY.TARGET, "none");
        r102.put("setting_type", r101);
        t(ToolboxEvent.SORT_SET_HALFWAY_CLICK, r102);
    }

    public final void Q(Boolean r100, Integer r101, Boolean r102) {
        HashMap r103 = new HashMap();
        int r104 = 0;
        if (r100 == null) goto L5;
        boolean r105 = r100.booleanValue();
    L6:
        r103.put("is_auto_sort", Boolean.valueOf(r105));
        if (r101 == null) goto L9;
        r104 = r101.intValue();
    L9:
        r103.put("sort_count", Integer.valueOf(r104));
        if (r102 == null) goto L12;
        r103.put("is_premium_limited", Boolean.valueOf(r102.booleanValue()));
    L12:
        String r106 = this.f209805a.b();
        if (r106 == null) goto L15;
        r103.put("mobile_grid_type", r106);
    L15:
        r103.put("building_type", this.f209805a.d());
        t(ToolboxEvent.SORT_PANEL_VIEW, r103);
        return;
    L5:
        r105 = false;
        goto L6
    }

    public static void O(BitableToolboxAnalytic r100, String r101, Boolean r102, FieldCompositeType r103, Boolean r104, int r105) {
        if ((r105 & 2) == 0) goto L6;
        r102 = null;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = null;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = null;
    L11:
        Intrinsics.checkNotNullParameter(r101, "clickEvent");
        HashMap r106 = new HashMap();
        r106.put("click", r101);
        r106.put(PickerReporterConstants.KEY.TARGET, "none");
        if (r102 != null) goto L14;
    L18:
        if (r103 == null) goto L22;
        String r107 = r103.getReportValue();
        if (r107 == null) goto L22;
        r106.put("field_type", r107);
    L22:
        if (r104 != null) goto L24;
    L28:
        String r108 = r100.f209805a.b();
        if (r108 == null) goto L31;
        r106.put("mobile_grid_type", r108);
    L31:
        r106.put("building_type", r100.f209805a.d());
        r100.t(ToolboxEvent.SORT_PANEL_CLICK, r106);
        return;
    L24:
        if (r104.booleanValue() == false) goto L26;
        String r109 = "option_inverse_order";
    L27:
        r106.put(com.heytap.mcssdk.constant.b.f276366p, r109);
        goto L28
    L26:
        r109 = "option_order";
        goto L27
    L14:
        if (r102.booleanValue() == false) goto L16;
        String r110 = "open";
    L17:
        r106.put("status", r110);
        goto L18
    L16:
        r110 = "close";
        goto L17
    }
}
