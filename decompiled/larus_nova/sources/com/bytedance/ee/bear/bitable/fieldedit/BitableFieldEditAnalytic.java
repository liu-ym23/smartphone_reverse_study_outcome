package com.bytedance.ee.bear.bitable.fieldedit;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldProperty;
import com.bytedance.ee.bear.bitable.fieldedit.view.edit.modifiedtime.ModifiedTimeWatch;
import com.bytedance.ee.bear.bitable.filter.model.EFilterConjunction;
import com.bytedance.ee.bear.bitable.filter.model.FilterInfo;
import com.bytedance.ee.bear.bitable.n;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
import kr4.b;

/* JADX INFO: loaded from: classes15.dex */
public final class BitableFieldEditAnalytic extends BitableAnalytic {

    @Retention(RetentionPolicy.SOURCE)
    public @interface FieldEditScene {
        public static final String ADD_RIGHT_MOST = "rightmost";
        public static final String INSERT_FIELD_FROM_GRID_BOARD = "insert_field";
        public static final String MODIFY_FROM_GRID_BOARD = "grid_board";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FieldEditSceneEvent {
        public static final String BITABLE_ATTACHMENT_FIELD_MODIFY_CLICK = "ccm_bitable_attachment_field_modify_click";
        public static final String BITABLE_AUTONUMBER_CHECK_CLICK = "ccm_bitable_auto_number_check_click";
        public static final String BITABLE_AUTONUMBER_CHECK_VIEW = "ccm_bitable_auto_number_check_view";
        public static final String BITABLE_AUTONUMBER_FIELD_MODIFY_CLICK = "ccm_bitable_auto_number_field_modify_click";
        public static final String BITABLE_AUTONUMBER_FIELD_MODIFY_VIEW = "ccm_bitable_auto_number_field_modify_view";
        public static final String BITABLE_COLOR_BOARD_VIEW = "ccm_bitable_color_board_view";
        public static final String BITABLE_CURRENCY_FIELD_MODIFY_CLICK = "ccm_bitable_currency_field_modify_click";
        public static final String BITABLE_DATABASE_SWITCH_TOAST_CLICK = "ccm_bitable_database_switch_toast_click";
        public static final String BITABLE_DATABASE_SWITCH_TOAST_VIEW = "ccm_bitable_database_switch_toast_view";
        public static final String BITABLE_DUPLEX_RELATION_MODIFY_CLICK = "ccm_bitable_duplex_relation_modify_click";
        public static final String BITABLE_EXTENDABLE_FIELD_FORMAT_MODIFY_CLICK = "ccm_bitable_extendable_field_format_modify_click";
        public static final String BITABLE_FIELD_CAL_NO_PERMISSION_OPT = "ccm_bitable_calculation_operate_limited_view";
        public static final String BITABLE_FIELD_CREATE = "bitable_field_create";
        public static final String BITABLE_FIELD_DELETE_VIEW = "ccm_bitable_field_delete_view";
        public static final String BITABLE_FIELD_EXTEND_MODIFY_CLICK = "ccm_bitable_field_extend_modify_click";
        public static final String BITABLE_FIELD_EXTEND_MODIFY_VIEW = "ccm_bitable_field_extend_modify_view";
        public static final String BITABLE_FIELD_EXTEND_SYNC_ERROR_CLICK = "ccm_bitable_field_extend_sync_error_click";
        public static final String BITABLE_FIELD_EXTEND_SYNC_ERROR_VIEW = "ccm_bitable_field_extend_sync_error_view";
        public static final String BITABLE_FIELD_MODIFY_BOARD_EXTEND_WARNING_VIEW = "ccm_bitable_field_modify_board_extend_warning_view";
        public static final String BITABLE_FIELD_MODIFY_CANCEL_CONFIRM_CLICK = "ccm_bitable_field_modify_cancel_confirm_click";
        public static final String BITABLE_FIELD_MODIFY_CANCEL_CONFIRM_VIEW = "ccm_bitable_field_modify_cancel_confirm_view";
        public static final String BITABLE_FIELD_MODIFY_CLICK = "ccm_bitable_field_modify_click";
        public static final String BITABLE_FIELD_MODIFY_DURATION_VUEW = "ccm_bitable_field_modify_duration_view";
        public static final String BITABLE_FIELD_MODIFY_VIEW = "ccm_bitable_field_modify_view";
        public static final String BITABLE_FIELD_OPERATE_CLICK = "ccm_bitable_field_operate_click";
        public static final String BITABLE_FIELD_OPERATE_VIEW = "ccm_bitable_field_operate_view";
        public static final String BITABLE_FIELD_TYPE_MODIFY_CLICK = "ccm_bitable_field_type_modify_click";
        public static final String BITABLE_FIELD_TYPE_MODIFY_DURATION_VUEW = "ccm_bitable_field_type_modify_duration_view";
        public static final String BITABLE_FIELD_TYPE_MODIFY_VIEW = "ccm_bitable_field_type_modify_view";
        public static final String BITABLE_FILTER_SELECT_CLICK = "ccm_bitable_filter_select_click";
        public static final String BITABLE_GEOGRAPHY_FIELD_MODIFY_CLICK = "ccm_bitable_geography_field_modify_click";
        public static final String BITABLE_GROUP_FIELD_MODIFY_CLICK = "ccm_bitable_group_field_modify_click";
        public static final String BITABLE_GROUP_STATISTICS_VIEW = "ccm_bitable_group_statistics_view";
        public static final String BITABLE_MEMBER_FIELD_FORMAT_MODIFY_CLICK = "ccm_bitable_member_field_format_modify_click";
        public static final String BITABLE_MODIFY_FIELD_QUOTE_WARNING_CLICK = "ccm_bitable_modify_field_quote_warning_click";
        public static final String BITABLE_MODIFY_FIELD_QUOTE_WARNING_VIEW = "ccm_bitable_modify_field_quote_warning_view";
        public static final String BITABLE_NUMBER_FIELD_FORMAT_MODIFY_CLICK = "ccm_bitable_number_field_format_modify_click";
        public static final String BITABLE_NUMBER_FIELD_FORMAT_MODIFY_VIEW = "ccm_bitable_number_field_format_modify_view";
        public static final String BITABLE_OPTION_FIELD_MODIFY_CLICK = "ccm_bitable_option_field_modify_click";
        public static final String BITABLE_OPTION_FIELD_MODIFY_DURATION_VIEW = "ccm_bitable_option_field_modify_duration_view";
        public static final String BITABLE_PROGRESS_FIELD_MODIFY_CLICK = "ccm_bitable_progress_field_modify_click";
        public static final String BITABLE_RATING_FIELD_MODIFY_CLICK = "ccm_bitable_rating_field_modify_click";
        public static final String BITABLE_RELATION_SWITCH_CAN_ADD_WARNING_TOAST_CLICK = "ccm_bitable_relation_switch_can_add_warning_toast_click";
        public static final String BITABLE_RELATION_SWITCH_CAN_ADD_WARNING_TOAST_VIEW = "ccm_bitable_relation_switch_can_add_warning_toast_view";
        public static final String BITABLE_RELATION_SWITCH_NO_ADD_WARNING_TOAST_CLICK = "ccm_bitable_relation_switch_no_add_warning_toast_click";
        public static final String BITABLE_RELATION_SWITCH_NO_ADD_WARNING_TOAST_VIEW = "ccm_bitable_relation_switch_no_add_warning_toast_view";
        public static final String BITABLE_SCAN_FIELD_MODIFY_CLICK = "ccm_bitable_scan_field_modify_click";
        public static final String BITABLE_STATISTICS_METHOD_MODIFY_VIEW = "ccm_bitable_statistics_method_modify_view";
        public static final String BITABLE_STATISTICS_VIEW = "ccm_bitable_statistics_view";
        public static final String BITABLE_TIME_FIELD_FORMAT_MODIFY_CLICK = "ccm_bitable_time_field_format_modify_click";
        public static final String BITABLE_TIME_FIELD_FORMAT_MODIFY_VIEW = "ccm_bitable_time_field_format_modify_view";
        public static final String BITABLE_TIME_FIELD_MODIFY_CLICK = "ccm_bitable_time_field_modify_click";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FieldModifyAction {
        public static final String EXISTED_FIELD = "existed_field";
        public static final String NEW_FIELD = "new_field";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FieldSubSettingAction {
        public static final String ADD_NEW_FILTER_CONDITION = "add_new_filter_condition";
        public static final String AUTO_RULE_CHANGED = "auto_rule_changed";
        public static final String CHANGE_OPTION_COLOR = "change_option_color";
        public static final String CHECK_CHANGED = "check_changed";
        public static final String CREATE_NEW_OPTION = "create_new_option";
        public static final String CUSTOMIZED_PROGRESS_RANGE = "customized_progress_range";
        public static final String DELETE_FILTER_CONDITION = "delete_filter_condition";
        public static final String DELETE_OPTION = "delete_option";
        public static final String DRAG_OPTION = "drag_option";
        public static final String FOCUS_CHANGE = "focus_change";
        public static final String OPEN_DATETIME_FORMAT_SELECT = "open_datetime_format_select";
        public static final String OPEN_SELECT = "open_select";
        public static final String SELECT_DATA_RANGE = "select_data_range";
        public static final String SELECT_DECIMAL_LENGTH = "select_decimal_length";
        public static final String SELECT_NUMBER_TYPE = "select_number_type";
        public static final String SELECT_PROGRESS_COLOR = "select_progress_color";
        public static final String SELECT_RATING_MAX = "select_rating_max";
        public static final String SELECT_RATING_MIN = "select_rating_min";
        public static final String SELECT_RATING_SYMBOL = "select_rating_symbol";
        public static final String SELECT_RECORD_RANGE = "select_record_range";
        public static final String SELECT_RELEATED_TABLE = "select_releated_table";
        public static final String SET_PROGRESS_MAX = "set_progress_max";
        public static final String SET_PROGRESS_MIN = "set_progress_min";
        public static final String SHOW_FILTER_CONDITION_PANEL = "show_filter_condition_panel";
        public static final String SHOW_FILTER_CONJUNCTION_CONDITION = "show_filter_conjunction_condition";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface FieldTypeModifiAction {
        public static final String ADD_NEW_FIELD = "new_field";
        public static final String SWITCH = "switch";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressFieldEditScene {
        public static final String COLOR = "color";
        public static final String CONFIRM = "confirm";
        public static final String CUSTOMIZED_PROGRESS = "customized_progress";
        public static final String DECIMAL_DIGITS = "decimal_digits";
        public static final String MAX = "max";
        public static final String MIN = "min";
        public static final String NUMBER_FORMAT = "number_format";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RatingFieldEditScene {
        public static final String CONFIRM = "confirm";
        public static final String MARK_SHAPRE = "mark_shapre";
        public static final String MAX_SETTING = "max_setting";
        public static final String MIN_SETTING = "min_setting";
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f211121a = null;

        static {
            int[] r100 = new int[EFieldUIType.values().length];
            f211121a = r100;
            r100[EFieldUIType.DATE_TIME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f211121a[EFieldUIType.CREATED_TIME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f211121a[EFieldUIType.MODIFIED_TIME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f211121a[EFieldUIType.ATTACHMENT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f211121a[EFieldUIType.USER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f211121a[EFieldUIType.SINGLE_LINK.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f211121a[EFieldUIType.DUPLEX_LINK.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public BitableFieldEditAnalytic(b r100) {
        super(r100);
    }

    public final void P(boolean r100) {
        HashMap r101 = new HashMap();
        if (r100 == false) goto L5;
        String r102 = "cancel";
    L6:
        r101.put("click", r102);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        t(FieldEditSceneEvent.BITABLE_FIELD_MODIFY_CANCEL_CONFIRM_CLICK, r101);
        return;
    L5:
        r102 = "exit";
        goto L6
    }

    public final void Z(boolean r100) {
        HashMap r101 = new HashMap();
        r101.put("is_multi_group", Boolean.valueOf(r100));
        r101.put("click", "confirm");
        t(FieldEditSceneEvent.BITABLE_GROUP_FIELD_MODIFY_CLICK, r101);
    }

    public final void O(String r100, boolean r101) {
        HashMap r102 = new HashMap();
        r102.put("click", r100);
        r102.put(PickerReporterConstants.KEY.TARGET, "none");
        r102.put("is_phone_restricted", String.valueOf(r101));
        t(FieldEditSceneEvent.BITABLE_ATTACHMENT_FIELD_MODIFY_CLICK, r102);
    }

    public final void T(String r100, boolean r101) {
        HashMap r102 = new HashMap();
        r102.put("click", r100);
        r102.put(PickerReporterConstants.KEY.TARGET, "none");
        r102.put("is_allow_adding_multiple_members", String.valueOf(r101));
        t(FieldEditSceneEvent.BITABLE_MEMBER_FIELD_FORMAT_MODIFY_CLICK, r102);
    }

    public final void U(String r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("click", r100);
        if (r101 != null) goto L5;
        r101 = "none";
    L5:
        r102.put(PickerReporterConstants.KEY.TARGET, r101);
        t(FieldEditSceneEvent.BITABLE_OPTION_FIELD_MODIFY_CLICK, r102);
    }

    public final void a0(FieldCompositeType r100, String r101) {
        HashMap r102 = new HashMap();
        EFieldUIType r103 = r100.getUiType();
        if (r103 != EFieldUIType.DATE_TIME) goto L5;
    L8:
        r102.put("time_type", r100.getReportValue());
    L9:
        t(r101, r102);
        return;
    L5:
        if (r103 == EFieldUIType.CREATED_TIME) goto L8;
        if (r103 != EFieldUIType.MODIFIED_TIME) goto L9;
        goto L8
    }

    public final void b0(FieldCompositeType r100, long r101) {
        HashMap r102 = new HashMap();
        r102.put("field_type", r100.getReportValue());
        r102.put("duration", Long.valueOf(r101));
        t(FieldEditSceneEvent.BITABLE_OPTION_FIELD_MODIFY_DURATION_VIEW, r102);
    }

    public final void c0(String r110, String... r111) {
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return;
    L5:
        HashMap r100 = new HashMap();
        r100.put("click", r110);
        switch(r110.hashCode()) {
            case -1240241772: goto L25;
            case 17860013: goto L21;
            case 94842723: goto L17;
            case 951117504: goto L13;
            case 1721006123: goto L9;
            default: goto L28;
        };
    L28:
        byte r112 = -1;
    L30:
        if (r112 != 0) goto L32;
        r100.put("decimal_digits_type", r111[0]);
    L44:
        t(FieldEditSceneEvent.BITABLE_PROGRESS_FIELD_MODIFY_CLICK, r100);
        return;
    L32:
        if (r112 != 1) goto L34;
        r100.put("number_format_type", r111[0]);
        goto L44
    L34:
        if (r112 != 2) goto L36;
        r100.put("color_id", r111[0]);
        goto L44
    L36:
        if (r112 == 3) goto L40;
        if (r112 != 4) goto L44;
        r100.put("switch_type", r111[0]);
        goto L44
    L40:
        r100.put("number_format_type", r111[0]);
        r100.put("decimal_digits_type", r111[1]);
        r100.put("color_id", r111[2]);
        r100.put("switch_type", r111[3]);
        goto L44
    L9:
        if (r110.equals(ProgressFieldEditScene.CUSTOMIZED_PROGRESS) == false) goto L28;
        r112 = 4;
        goto L30
    L13:
        if (r110.equals("confirm") == false) goto L28;
        r112 = 3;
        goto L30
    L17:
        if (r110.equals("color") == false) goto L28;
        r112 = 2;
        goto L30
    L21:
        if (r110.equals(ProgressFieldEditScene.NUMBER_FORMAT) == false) goto L28;
        r112 = 1;
        goto L30
    L25:
        if (r110.equals(ProgressFieldEditScene.DECIMAL_DIGITS) == false) goto L28;
        r112 = 0;
        goto L30
    }

    public final void d0(String r100, String... r101) {
        HashMap r102 = new HashMap();
        r102.put("click", r100);
        if (TextUtils.equals("confirm", r100) == true) goto L5;
    L7:
        t(FieldEditSceneEvent.BITABLE_RATING_FIELD_MODIFY_CLICK, r102);
        return;
    L5:
        if (r101.length != 3) goto L7;
        r102.put("mark_type", r101[0]);
        r102.put("min_num", r101[1]);
        r102.put("max_num", r101[2]);
        goto L7
    }

    public final void V(FieldCompositeType r100, String r101, boolean r102) {
        HashMap r103 = new HashMap();
        r103.put("click", r101);
        r103.put("field_type", r100.getReportValue());
        r103.put(PickerReporterConstants.KEY.TARGET, "none");
        r103.put("is_auto_add_create_time", String.valueOf(r102));
        t(FieldEditSceneEvent.BITABLE_TIME_FIELD_MODIFY_CLICK, r103);
    }

    public final void W(FieldCompositeType r100, String r101, boolean r102) {
        HashMap r103 = new HashMap();
        if (r102 == false) goto L5;
        String r104 = "confirm";
    L6:
        r103.put("click", r104);
        if (r102 == false) goto L9;
        String r105 = "ccm_bitable_relation_change_toast_view";
    L10:
        r103.put(PickerReporterConstants.KEY.TARGET, r105);
        r103.put("index_field_type", r101);
        r103.put("self_field_type", r100.getReportValue());
        t(FieldEditSceneEvent.BITABLE_RELATION_SWITCH_NO_ADD_WARNING_TOAST_CLICK, r103);
        return;
    L9:
        r105 = "none";
        goto L10
    L5:
        r104 = "cancel";
        goto L6
    }

    public final void R(String r100, String r101, String r102, String r103) {
        HashMap r104 = new HashMap();
        r104.put("click", r100);
        if (r101 != null) goto L5;
        r101 = "none";
    L5:
        r104.put(PickerReporterConstants.KEY.TARGET, r101);
        r104.put("action_type", r102);
        r104.put("scene_type", r103);
        t(FieldEditSceneEvent.BITABLE_FIELD_MODIFY_CLICK, r104);
    }

    public final void S(FieldCompositeType r100, String r101, String r102, Boolean r103) {
        HashMap r104 = new HashMap();
        r104.put("click", r101);
        r104.put("field_type", r100.getReportValue());
        r104.put(PickerReporterConstants.KEY.TARGET, r102);
        if (r103 == null) goto L5;
        r104.put("is_allow_adding_multiple_records", String.valueOf(r103));
    L5:
        t(FieldEditSceneEvent.BITABLE_DUPLEX_RELATION_MODIFY_CLICK, r104);
    }

    public final void X(FieldCompositeType r100, FieldCompositeType r101, boolean r102, boolean r103) {
        HashMap r104 = new HashMap();
        if (r102 == false) goto L5;
        String r105 = "confirm";
    L6:
        r104.put("click", r105);
        String r106 = "";
        if (r100 != null) goto L9;
        String r107 = "";
    L10:
        r104.put("from_field_type", r107);
        if (r101 == null) goto L14;
        r106 = r101.getReportValue();
    L14:
        r104.put("to_field_type", r106);
        if (r103 == false) goto L17;
        String r108 = "true";
    L18:
        r104.put("is_create_new_column", r108);
        t(FieldEditSceneEvent.BITABLE_DATABASE_SWITCH_TOAST_CLICK, r104);
        return;
    L17:
        r108 = "false";
        goto L18
    L9:
        r107 = r100.getReportValue();
        goto L10
    L5:
        r105 = "cancel";
        goto L6
    }

    public final void Y(FieldCompositeType r100, String r101, boolean r102, boolean r103) {
        HashMap r104 = new HashMap();
        if (r102 == false) goto L5;
        String r105 = "confirm";
    L6:
        r104.put("click", r105);
        if (r102 == false) goto L9;
        String r106 = "ccm_bitable_relation_change_toast_view";
    L10:
        r104.put(PickerReporterConstants.KEY.TARGET, r106);
        if (r102 == false) goto L16;
        if (r103 == false) goto L14;
        String r107 = "true";
    L15:
        r104.put("record_keep_type", r107);
        goto L16
    L14:
        r107 = "false";
    L16:
        r104.put("index_field_type", r101);
        r104.put("self_field_type", r100.getReportValue());
        t(FieldEditSceneEvent.BITABLE_RELATION_SWITCH_CAN_ADD_WARNING_TOAST_CLICK, r104);
        return;
    L9:
        r106 = "none";
        goto L10
    L5:
        r105 = "cancel";
        goto L6
    }

    public final void Q(FieldCompositeType r100, String r110, boolean r111, FieldProperty r112, Map r113) {
        HashMap r101 = new HashMap();
        switch(a.f211121a[r100.getUiType().ordinal()]) {
            case 1: goto L33;
            case 2: goto L33;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L34;
        };
    L5:
        if (r112 == null) goto L16;
        FilterInfo r102 = r112.getFilterInfo();
        if (r102 == null) goto L16;
        boolean r103 = EFilterConjunction.Or.getValue().equals(r102.getConjunction());
        if (r102.getConditions() != null) goto L11;
        int r104 = 0;
    L12:
        if (r103 == false) goto L14;
        String r105 = "any_condition";
    L15:
        r101.put(FilterData.FilterOptionItem.Type.RANGE, r105);
        r101.put("condition_num", Integer.valueOf(r104));
        r101.put("link_file_id", du5.b.n(r112.getBaseId()));
        r101.put("link_table_id", du5.b.n(r112.getTableId()));
        goto L16
    L14:
        r105 = "all_condition";
        goto L15
    L11:
        r104 = r102.getConditions().length;
    L16:
        S(r100, r110, "none", Boolean.valueOf(r111));
        goto L34
    L17:
        T(r110, r111);
        goto L34
    L18:
        O(r110, r111);
        goto L34
    L19:
        int r106 = c.f207079a;
        int r107 = n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("base.modified_time_field_specific_fields_enable") == false) goto L32;
        if (r112 == null) goto L27;
        ModifiedTimeWatch r114 = r112.getWatch();
        if (r114 == null) goto L27;
        if (TextUtils.equals(r114.getType(), ModifiedTimeWatch.WATCH_TYPE_SPECIFIC) == false) goto L27;
        String r115 = "selected";
    L28:
        HashMap r116 = new HashMap();
        r116.put("click", r110);
        r116.put("field_type", r100.getReportValue());
        r116.put(PickerReporterConstants.KEY.TARGET, "none");
        if (TextUtils.equals(r110, "confirm") == false) goto L31;
        r116.put("update_time_source", r115);
    L31:
        t(FieldEditSceneEvent.BITABLE_TIME_FIELD_MODIFY_CLICK, r116);
    L27:
        r115 = "any";
        goto L28
    L32:
        V(r100, r110, r111);
        goto L34
    L33:
        V(r100, r110, r111);
    L34:
        r113.put("click", r110);
        r113.put(PickerReporterConstants.KEY.TARGET, "none");
        r113.put("field_type", r100.getReportValue());
        if (r101.isEmpty() == true) goto L37;
        r113.putAll(r101);
    L37:
        t(FieldEditSceneEvent.BITABLE_FIELD_MODIFY_CLICK, r113);
    }
}
