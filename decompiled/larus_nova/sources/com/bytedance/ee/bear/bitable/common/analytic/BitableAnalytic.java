package com.bytedance.ee.bear.bitable.common.analytic;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.TableDataModel;
import com.bytedance.ee.bear.bitable.common.l;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.model.field.FieldCompositeType;
import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.bitable.itemview.util.ReportEvent;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kr4.a;
import kr4.b;
import sbb.e;

/* JADX INFO: loaded from: classes15.dex */
public class BitableAnalytic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f209805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f209806b;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AddToWorkBenchEvent {
        public static final String BITABLE_ADD_WORKPLACE_TOAST_VIEW = "ccm_bitable_add_to_workplace_toast_view";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttachmentChooseAction {
        public static final String ALBUM = "album";
        public static final String CAMERA = "camera";
        public static final String CANCEL = "cancel";
        public static final String FILE = "file";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttachmentClickAction {
        public static final String ADD = "add";
        public static final String DELETE = "delete";
        public static final String UPLOAD = "upload";
        public static final String UPLOAD_DELETE = "upload_delete";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AttachmentOperationAction {
        public static final String DELETE = "delete_attachment";
        public static final String PREVIEW = "preview";
        public static final String SWITCH = "switch";
        public static final String UPLOAD = "upload_new_attachment";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EditParamKey {
        public static final String BITABLE_EDIT_SEARCH = "bitable_edit_search";
        public static final String CELL_ITEM_CHANGE = "cell_item_change";
        public static final String CLICK_CLEAR_BTN = "click_clear_btn";
        public static final String CLICK_DONE_BTN = "click_done_btn";
        public static final String DELETE_ITEM_SOURCE = "delete_item_source";
        public static final String IS_EDIT_PANEL_OPEN = "is_edit_panel_open";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface KeyboardEvent {
        public static final String BITABLE_KEYBOARD_CLICK_EVENT = "ccm_bitable_keyboard_click";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LinkSceneClickType {
        public static final String ADD_RECORD = "add_record";
        public static final String CLICK_RECORD = "click_record";
        public static final String CREATE_RECORD = "create_record";
        public static final String DELETE = "delete";
        public static final String EXPAND = "expand";
        public static final String SEARCH = "search";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LocationClickType {
        public static final String BLANK = "blank";
        public static final String DELETE = "delete";
        public static final String EDIT = "edit";
        public static final String ICON = "icon";
        public static final String WORDS = "words";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MemberItemSource {
        public static final String BOTTOM_LIST_SOURCE = "bottom_list";
        public static final String CONFIRM = "confirm";
        public static final String TOP_BAR_SOURCE = "top_bar";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuClickAction {
        public static final String CLICK_SHOW_MENU = "more";
        public static final String COPY = "copy";
        public static final String CUT = "cut";
        public static final String DELETE_RECORD = "delete_record";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuEvent {
        public static final String BITABLE_MOBILE_EDIT_MENU_CLICK = "ccm_bitable_mobile_edit_menu_click";
        public static final String BITABLE_MOBILE_READ_MENU_CLICK = "ccm_bitable_mobile_read_menu_click";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MobileScreenMode {
        public static final String HORIZONTAL = "horizontal";
        public static final String VERTICAL = "vertical";
    }

    public @interface ProgressInputType {
        public static final String DRAG = "drag";
        public static final String INPUT = "input";
        public static final String NONE = "none";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RecordCardEvent {
        public static final String BITABLE_RECORD_ADD_TIP_CLOSE = "ccm_bitable_card_limited_tips_click";
        public static final String BITABLE_RECORD_ADD_TIP_SHOW = "ccm_bitable_card_limited_tips_view";
        public static final String BITABLE_RECORD_CARD_CLICK = "ccm_bitable_card_click";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectSceneClickType {
        public static final String ADD = "add";
        public static final String CANCEL = "cancel";
        public static final String CHANGE_COLOR = "change_color";
        public static final String CHANGE_SATURATION = "change_saturation";
        public static final String COMPLETE = "complete";
        public static final String CREATE_OPTION = "create_option";
        public static final String DELETE = "delete";
        public static final String EDIT = "edit";
        public static final String OPTION_MORE = "option_more";
        public static final String SEARCH = "search";
        public static final String SELECT_OPTION = "select_option";
        public static final String SIMILAR_OPTION = "similar_option";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SelectSceneEvent {
        public static final String BITABLE_OPTION_FIELD_DELETE_CLICK = "ccm_bitable_option_field_delete_click";
        public static final String BITABLE_OPTION_FIELD_DELETE_VIEW = "ccm_bitable_option_field_delete_view";
        public static final String BITABLE_OPTION_FIELD_EDIT_CLICK = "ccm_bitable_option_field_edit_click";
        public static final String BITABLE_OPTION_FIELD_EDIT_VIEW = "ccm_bitable_option_field_edit_view";
        public static final String BITABLE_OPTION_FIELD_MORE_CLICK = "ccm_bitable_option_field_more_click";
        public static final String BITABLE_OPTION_FIELD_MORE_VIEW = "ccm_bitable_option_field_more_view";
        public static final String BITABLE_OPTION_FIELD_PANEL_CLICK = "ccm_bitable_option_field_panel_click";
        public static final String BITABLE_OPTION_FIELD_PANEL_VIEW = "ccm_bitable_option_field_panel_view";
    }

    public final void I() {
        HashMap r100 = new HashMap();
        r100.put("click", "contact");
        r100.put("tel_permission", "true");
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        t("ccm_bitable_tel_contact_icon_click", r100);
    }

    public final void K() {
        HashMap r100 = new HashMap();
        r100.put("click", AttachmentClickAction.UPLOAD_DELETE);
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        t("ccm_bitable_attachment_operate_click", r100);
    }

    public final void L() {
        ((HashMap) this.f209806b).put(EventConstant.Key.MODULE, "base_add");
        ((HashMap) this.f209806b).put("file_type", "base_add");
    }

    public final Map<String, Object> b() {
        Map<String, Object> r100 = this.f209806b;
        HashMap r101 = (HashMap) r100;
        r101.put("is_sync_table", Boolean.valueOf(this.f209805a.f()));
        return this.f209806b;
    }

    public final void f() {
        HashMap r100 = new HashMap();
        r100.put("click", "add");
        r100.put(PickerReporterConstants.KEY.TARGET, "ccm_bitable_card_attachment_choose_view");
        t("ccm_bitable_card_attachment_operate_click", r100);
    }

    public final void i() {
        HashMap r100 = new HashMap();
        r100.put("scene", "form_view");
        r100.put("is_red_dot", "false");
        r100.put("form_version", "form_v1");
        t("ccm_bitable_form_ai_polish_button_view", r100);
    }

    public final void o() {
        HashMap r100 = new HashMap();
        r100.put("link_type", "jira");
        r100.put("source", "recordinfilter");
        r100.put("view_status", BrowserDependency.UrlClickType.CARD);
        s("click_openorigin_link", r100);
    }

    public final void r() {
        HashMap r100 = new HashMap();
        r100.put("click", "delete");
        r100.put(PickerReporterConstants.KEY.TARGET, "none");
        t("ccm_bitable_card_attachment_operate_click", r100);
    }

    public BitableAnalytic(b r100) {
        this.f209806b = new HashMap();
        this.f209805a = r100;
        HashMap<String, Object> r101 = r100.f505705a.m("docCommonParams");
        if (r101.isEmpty() == true) goto L8;
        Iterator<Map.Entry<String, Object>> r102 = r101.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, Object> r103 = r102.next();
        Map<String, Object> r104 = this.f209806b;
        HashMap r105 = (HashMap) r104;
        r105.put(r103.getKey(), r103.getValue());
    L8:
        Map<String, Object> r106 = this.f209806b;
        HashMap r107 = (HashMap) r106;
        r107.put(EventConstant.Key.MODULE, r100.h());
        Map<String, Object> r108 = this.f209806b;
        HashMap r109 = (HashMap) r108;
        r109.put("file_type", e.f541298i.getType());
        Map<String, Object> r110 = this.f209806b;
        HashMap r111 = (HashMap) r110;
        r111.put("bitable_type", r100.g());
        ((HashMap) this.f209806b).put("is_full_screen", "true");
    }

    public final void H(String r100) {
        HashMap r101 = new HashMap();
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        t("ccm_bitable_tel_card_icon_click", r101);
    }

    public final void J(boolean r100) {
        HashMap r101 = new HashMap();
        r101.put("click", "upload");
        r101.put("is_phone_restricted", Boolean.valueOf(r100));
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        t("ccm_bitable_card_attachment_operate_click", r101);
    }

    public final void M(int r100) {
        Map<String, Object> r101 = this.f209806b;
        if (r100 != 2) goto L5;
        String r102 = "horizontal";
    L6:
        ((HashMap) r101).put("mobile_screen_mode", r102);
        return;
    L5:
        r102 = "vertical";
        goto L6
    }

    public final void a(xr4.a r100) {
        if (r100 == null) goto L5;
        Map<String, Object> r101 = this.f209806b;
        HashMap r102 = (HashMap) r101;
        r102.put("is_bitable_solo", Boolean.valueOf(r100.f564854a));
        Map<String, Object> r103 = this.f209806b;
        HashMap r104 = (HashMap) r103;
        r104.put("is_user_from_bitable_solo", Boolean.valueOf(r100.f564855b));
        ((HashMap) this.f209806b).put("bitable_solo_user_agent", "null");
        return;
    }

    public final void d(TableDataModel.ReportEvent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        tt5.a.b("BitableAnalytic", "reportAiRecord: event = " + r100.event);
        HashMap r101 = new HashMap();
        if (hu5.a.e(r100.params) == true) goto L7;
        r101.putAll(r100.params);
    L7:
        t(r100.event, r101);
    }

    public final void e(ReportEvent r100) {
        tt5.a.b("BitableAnalytic", "reportAiRecord: event = " + r100.getEvent());
        HashMap r101 = new HashMap();
        if (hu5.a.e(r100.getParams()) == true) goto L5;
        r101.putAll(r100.getParams());
    L5:
        t(r100.getEvent(), r101);
    }

    public final void h(String r100) {
        HashMap r101 = new HashMap();
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        t("ccm_bitable_add_record_timeout_click", r101);
    }

    public final void j(String r100) {
        HashMap r101 = new HashMap();
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        t("ccm_bitable_card_attachment_choose_click", r101);
    }

    public final void m(String r100) {
        HashMap r101 = new HashMap();
        r101.put("click", "discussion");
        r101.put(PickerReporterConstants.KEY.TARGET, r100);
        r101.put("share_type", "record");
        t(RecordCardEvent.BITABLE_RECORD_CARD_CLICK, r101);
    }

    public final void n(FieldCompositeType r100) {
        HashMap r101 = new HashMap();
        r101.put("click", "link");
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        if (r100 == null) goto L5;
        String r102 = r100.getReportValue();
    L6:
        r101.put("field_type", r102);
        t(RecordCardEvent.BITABLE_RECORD_CARD_CLICK, r101);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void x(String r100) {
        HashMap r101 = new HashMap();
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        String r102 = this.f209805a.getDocType();
        if (r102 == null) goto L5;
        r101.put("file_id", r102);
    L5:
        L();
        t("ccm_bitable_no_permission_add_record_click", r101);
    }

    public final void y(String r100) {
        HashMap r101 = new HashMap();
        r101.put("click", "progress_content_change");
        r101.put("input_type", r100);
        t("ccm_bitable_progress_cell_edit_click", r101);
    }

    public final void z(String r100) {
        HashMap r101 = new HashMap(2);
        r101.put("click", r100);
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        r101.put("file_type", "bitable_share");
        r101.put("source", "share_record");
        t(RecordCardEvent.BITABLE_RECORD_CARD_CLICK, r101);
    }

    public final void A(String r100, boolean r101) {
        HashMap r102 = new HashMap();
        r102.put("field_type", r100);
        r102.put("is_empty", Boolean.valueOf(r101));
        t("ccm_bitable_field_input_mobile_view", r102);
    }

    public final void B(EFieldUIType r100, Map<String, Object> r101) {
        HashMap r102 = new HashMap();
        r102.put("bitable_field_type", r100.getReportValue());
        r102.put("bitable_editor_type", BrowserDependency.UrlClickType.CARD);
        if (r101 == null) goto L5;
        r102.putAll(r101);
    L5:
        s("bitable_record_edit", r102);
        if (r100 == EFieldUIType.DATE_TIME) goto L8;
        return;
    L8:
        if (TextUtils.equals(r101.get(EditParamKey.CLICK_CLEAR_BTN).toString(), String.valueOf(true)) == false) goto L12;
        HashMap r103 = new HashMap();
        r103.put("bitable_editor_type", BrowserDependency.UrlClickType.CARD);
        s("click_bitable_clear_date", r103);
        return;
    }

    public final void F(String r100, boolean r101) {
        HashMap r102 = new HashMap();
        if (l.a(r100) == false) goto L5;
        String r103 = "form";
    L6:
        r102.put("entry_type", r103);
        if (r101 == false) goto L9;
        String r104 = "manual_on";
    L10:
        r102.put("scan_manual", r104);
        t("ccm_bitable_scan_camera_view", r102);
        return;
    L9:
        r104 = "manual_off";
        goto L10
    L5:
        r103 = BrowserDependency.UrlClickType.CARD;
        goto L6
    }

    public final void g(String r100, boolean r101) {
        HashMap r102 = new HashMap();
        r102.put("click", r100);
        r102.put(PickerReporterConstants.KEY.TARGET, "none");
        if (r101 == false) goto L5;
        String r103 = "individual_page";
    L6:
        r102.put("type", r103);
        t("ccm_bitable_add_record_quit_click", r102);
        return;
    L5:
        r103 = "inside_base";
        goto L6
    }

    public final void k(String r100, int r101) {
        HashMap r102 = new HashMap();
        r102.put("bitable_editor_type", BrowserDependency.UrlClickType.CARD);
        r102.put("action", r100);
        r102.put("attach_number", String.valueOf(r101));
        s("bitable_attachment_operation", r102);
    }

    public final void l(String r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("click", r100);
        r102.put(PickerReporterConstants.KEY.TARGET, r101);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, BrowserDependency.UrlClickType.CARD);
        t(RecordCardEvent.BITABLE_RECORD_CARD_CLICK, r102);
    }

    public final void p(boolean r100, FieldCompositeType r101) {
        HashMap<String, Object> r102 = new HashMap();
        if (r100 == false) goto L5;
        String r103 = "open";
    L6:
        r102.put("status", r103);
        r102.put("field_type", r101.getReportValue());
        w(LinkSceneClickType.CLICK_RECORD, r102);
        return;
    L5:
        r103 = "close";
        goto L6
    }

    public final void s(String r100, Map<String, Object> r101) {
        r101.putAll(b());
        tt5.a.b("BitableAnalytic", "reportEvent: event = " + r100 + ", params = " + r101);
        this.f209805a.a().v(r100, r101);
    }

    public final void t(String r100, Map<String, Object> r101) {
        r101.putAll(b());
        tt5.a.b("BitableAnalytic", "reportEventV2: event = " + r100 + ", params = " + r101);
        this.f209805a.a().n(r100, r101);
    }

    public final void v(String r100, FieldCompositeType r101) {
        HashMap<String, Object> r102 = new HashMap();
        r102.put("field_type", r101.getReportValue());
        w(r100, r102);
    }

    public final void w(String r100, HashMap<String, Object> r101) {
        r101.put("click", r100);
        if (TextUtils.equals(r100, LinkSceneClickType.EXPAND) == false) goto L5;
    L8:
        String r102 = "ccm_bitable_card_view";
    L9:
        r101.put(PickerReporterConstants.KEY.TARGET, r102);
        if (TextUtils.equals(r100, LinkSceneClickType.ADD_RECORD) == false) goto L12;
        r101.put("location", "plus_sign");
    L12:
        t("ccm_bitable_relation_field_modify_click", r101);
        return;
    L5:
        if (TextUtils.equals(r100, LinkSceneClickType.CREATE_RECORD) == true) goto L8;
        r102 = "none";
        goto L9
    }

    public final void D(String r100, String r101, FieldCompositeType r102) {
        HashMap r103 = new HashMap();
        r103.put("click", r101);
        if (r102 == null) goto L5;
        String r104 = r102.getReportValue();
    L6:
        r103.put("field_type", r104);
        if (r101.equals("add") == false) goto L9;
    L28:
        String r105 = SelectSceneEvent.BITABLE_OPTION_FIELD_EDIT_VIEW;
    L29:
        r103.put(PickerReporterConstants.KEY.TARGET, r105);
        t(r100, r103);
        return;
    L9:
        if (r101.equals("edit") == true) goto L28;
        if (r101.equals(SelectSceneClickType.OPTION_MORE) == false) goto L15;
        r105 = SelectSceneEvent.BITABLE_OPTION_FIELD_MORE_VIEW;
        goto L29
    L15:
        if (r100.equals(SelectSceneEvent.BITABLE_OPTION_FIELD_DELETE_CLICK) == false) goto L20;
        if (r101.equals("delete") == false) goto L20;
        r105 = SelectSceneEvent.BITABLE_OPTION_FIELD_DELETE_VIEW;
    L20:
        if (r101.equals(SelectSceneClickType.CREATE_OPTION) == false) goto L22;
    L27:
        r105 = SelectSceneEvent.BITABLE_OPTION_FIELD_PANEL_VIEW;
        goto L29
    L22:
        if (r101.equals(SelectSceneClickType.COMPLETE) == true) goto L27;
        if (r101.equals(SelectSceneClickType.SIMILAR_OPTION) == true) goto L27;
        r105 = "none";
        goto L29
    L5:
        r104 = null;
        goto L6
    }

    public final void E(String r100, boolean r101, boolean r102) {
        HashMap r103 = new HashMap();
        r103.put(PickerReporterConstants.KEY.TARGET, "none");
        r103.put("is_field_hidden", r100);
        if (r101 == false) goto L5;
        r103.put("file_type", "bitable_share");
        r103.put("source", "share_record");
    L5:
        r103.put("is_new_bottom_bar", Boolean.valueOf(r102));
        t("ccm_bitable_card_view", r103);
    }

    public final void G(String r100, String r101, Boolean r102) {
        HashMap r103 = new HashMap();
        r103.put("click", r100);
        r103.put("signature_mode", r101);
        r103.put("is_content_empty", r102);
        t("ccm_bitable_signature_panel_click", r103);
    }

    public final void q(String r100, Boolean r101, boolean r102) {
        HashMap r103 = new HashMap();
        if (r101.booleanValue() == false) goto L5;
        String r104 = "scan";
    L6:
        r103.put("click", r104);
        if (r102 == false) goto L9;
        String r105 = "manual_on";
    L10:
        r103.put("scan_manual", r105);
        if (r101.booleanValue() == false) goto L13;
        String r106 = "ccm_bitable_scan_camera_view";
    L14:
        r103.put(PickerReporterConstants.KEY.TARGET, r106);
        if (l.a(r100) == false) goto L17;
        String r107 = "ccm_bitable_form_click";
    L18:
        t(r107, r103);
        return;
    L17:
        r107 = RecordCardEvent.BITABLE_RECORD_CARD_CLICK;
        goto L18
    L13:
        r106 = "none";
        goto L14
    L9:
        r105 = "manual_off";
        goto L10
    L5:
        r104 = "scan_input";
        goto L6
    }

    public final void C(String r100, boolean r101, boolean r102, boolean r103) {
        HashMap r104 = new HashMap();
        if (r101 == false) goto L5;
        String r105 = "success";
    L6:
        r104.put("scan_status", r105);
        if (l.a(r100) == false) goto L9;
        String r106 = "form";
    L10:
        r104.put("entry_type", r106);
        if (r103 == false) goto L13;
        String r107 = "manual_on";
    L14:
        r104.put("scan_manual", r107);
        if (r102 == false) goto L17;
        String r108 = "camera";
    L18:
        r104.put("scan_method", r108);
        r104.put(PickerReporterConstants.KEY.TARGET, "none");
        t("bitable_scan_camera_operate", r104);
        return;
    L17:
        r108 = "album";
        goto L18
    L13:
        r107 = "manual_off";
        goto L14
    L9:
        r106 = BrowserDependency.UrlClickType.CARD;
        goto L10
    L5:
        r105 = "fail_input";
        goto L6
    }

    public final Map<String, String> c(String r100, boolean r101, String r102, boolean r103) {
        HashMap r104 = new HashMap();
        String r105 = this.f209805a.c();
        String r106 = this.f209805a.getDocType();
        r104.put("file_id", r105);
        r104.put(EventConstant.Key.MODULE, r106);
        if (r102 != null) goto L5;
        String r107 = DocumentType.SHEET_NAME;
    L6:
        r104.put("file_type", r107);
        r104.put("source", r100);
        if (r101 == false) goto L9;
        String r108 = "portrait_locked";
    L10:
        r104.put("op_item", r108);
        if (r103 == false) goto L13;
        String r109 = "1";
    L14:
        r104.put("recordOpen", r109);
        if (r102 == null) goto L17;
        r104.put("bitable_view_type", r102);
    L17:
        return r104;
    L13:
        r109 = "0";
        goto L14
    L9:
        r108 = "default";
        goto L10
    L5:
        r107 = DocumentType.BITABLE_NAME;
        goto L6
    }

    public final void u(String r100, String r101, String r102, Boolean r103) {
        HashMap r104 = new HashMap();
        r104.put("click", r100);
        r104.put("field_type", r102);
        if (r103 == null) goto L5;
        r104.put("is_in_full_screen", Boolean.valueOf(r103.booleanValue()));
    L5:
        if (r101 == null) goto L7;
        r104.put(PickerReporterConstants.KEY.TARGET, r101);
    L7:
        t("ccm_bitable_relation_field_card_inside_click", r104);
    }

    public final void N(String r100, String r101, String r102, String r103, String r104) {
        Map<String, Object> r105 = this.f209806b;
        HashMap r106 = (HashMap) r105;
        r106.put("bitable_id", du5.b.g(r100));
        ((HashMap) this.f209806b).put("table_id", r101);
        ((HashMap) this.f209806b).put(BitableResourceData.KEY_VIEW_ID, r102);
        ((HashMap) this.f209806b).put("bitable_data_source", r104);
        ((HashMap) this.f209806b).put("bitable_view_type", r103);
        ((HashMap) this.f209806b).put(BytedCertConstant.IntentKey.VIEW_TYPE, r103);
    }
}
