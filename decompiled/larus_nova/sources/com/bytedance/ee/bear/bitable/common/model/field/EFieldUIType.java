package com.bytedance.ee.bear.bitable.common.model.field;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.plugin.common.ttreader.ITTReaderViewWrapper;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.nova.R;
import com.larus.platform.model.SlashMentionConfig;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\b\u0086\u0081\u0002\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00016B5\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0003\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5¨\u00067"}, d2 = {"Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "", "value", "", "iconRes", "", "reportValue", "nativeCell", "Lcom/bytedance/ee/bear/bitable/common/model/field/NativeCell;", "addValueIcon", "<init>", "(Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;Lcom/bytedance/ee/bear/bitable/common/model/field/NativeCell;I)V", "getValue", "()Ljava/lang/String;", "getIconRes", "()I", "setIconRes", "(I)V", "getReportValue", "getNativeCell", "()Lcom/bytedance/ee/bear/bitable/common/model/field/NativeCell;", "getAddValueIcon", "setAddValueIcon", "NOT_SUPPORT", CardAdapter.TEXT, "NUMBER", "SINGLE_SELECT", "MULTI_SELECT", "DATE_TIME", "CHECKBOX", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "GROUP", "PHONE", CommonConstant.RETKEY.EMAIL, "URL", "ATTACHMENT", "SINGLE_LINK", "LOOKUP", "FORMULA", "DUPLEX_LINK", HTTP.LOCATION, "CREATED_TIME", "MODIFIED_TIME", "CREATED_USER", "MODIFIED_USER", "AUTO_NUMBER", "BARCODE", "CURRENCY", "PROGRESS", "BUTTON", "RATING", "STAGE", "SIGNATURE", "FORM_GRID", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EFieldUIType extends Enum<EFieldUIType> {
    public static final EFieldUIType ATTACHMENT = null;
    public static final EFieldUIType AUTO_NUMBER = null;
    public static final EFieldUIType BARCODE = null;
    public static final EFieldUIType BUTTON = null;
    public static final EFieldUIType CHECKBOX = null;
    public static final EFieldUIType CREATED_TIME = null;
    public static final EFieldUIType CREATED_USER = null;
    public static final EFieldUIType CURRENCY = null;
    public static final a Companion = null;
    public static final EFieldUIType DATE_TIME = null;
    public static final EFieldUIType DUPLEX_LINK = null;
    public static final EFieldUIType EMAIL = null;
    public static final EFieldUIType FORMULA = null;
    public static final EFieldUIType FORM_GRID = null;
    public static final EFieldUIType GROUP = null;
    public static final EFieldUIType LOCATION = null;
    public static final EFieldUIType LOOKUP = null;
    public static final EFieldUIType MODIFIED_TIME = null;
    public static final EFieldUIType MODIFIED_USER = null;
    public static final EFieldUIType MULTI_SELECT = null;
    public static final EFieldUIType NOT_SUPPORT = null;
    public static final EFieldUIType NUMBER = null;
    public static final EFieldUIType PHONE = null;
    public static final EFieldUIType PROGRESS = null;
    public static final EFieldUIType RATING = null;
    public static final EFieldUIType SIGNATURE = null;
    public static final EFieldUIType SINGLE_LINK = null;
    public static final EFieldUIType SINGLE_SELECT = null;
    public static final EFieldUIType STAGE = null;
    public static final EFieldUIType TEXT = null;
    public static final EFieldUIType URL = null;
    public static final EFieldUIType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ EFieldUIType[] f209856a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f209857b = null;
    private int addValueIcon;
    private int iconRes;
    private final NativeCell nativeCell;
    private final String reportValue;
    private final String value;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static EFieldUIType a(String r100) {
            EFieldUIType[] r101 = EFieldUIType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L14;
            EFieldUIType r104 = r101[r103];
            if (TextUtils.equals(r104.getValue(), r100) == false) goto L7;
        L10:
            boolean r105 = true;
        L11:
            if (r105 == true) goto L15;
            r103 = r103 + 1;
        L15:
            if (r104 == null) goto L17;
            return r104;
        L17:
            return EFieldUIType.NOT_SUPPORT;
        L7:
            if (TextUtils.equals(r104.name(), r100) == true) goto L10;
            r105 = false;
            goto L11
        L14:
            r104 = null;
            goto L15
        }
    }

    public static EnumEntries<EFieldUIType> getEntries() {
        return f209857b;
    }

    @JvmStatic
    public static final EFieldUIType lookup(String r100) {
        Companion.getClass();
        return a.a(r100);
    }

    static {
        NativeCell r110 = NativeCell.NOT_SUPPORT;
        EFieldUIType r100 = new EFieldUIType("NOT_SUPPORT", 0, "NotSupport", R.drawable.ud_icon_maybe_outlined, "not_support", r110, R.drawable.ud_icon_maybe_outlined);
        NOT_SUPPORT = r100;
        int r111 = 0;
        int r112 = 16;
        DefaultConstructorMarker r113 = null;
        EFieldUIType r101 = new EFieldUIType(CardAdapter.TEXT, 1, "Text", R.drawable.ud_icon_style_outlined, "multiline", NativeCell.RICHTEXT, r111, r112, r113);
        TEXT = r101;
        NativeCell r102 = NativeCell.SIMPLETEXT;
        int r410 = 16;
        DefaultConstructorMarker r411 = null;
        EFieldUIType r103 = new EFieldUIType("NUMBER", 2, "Number", R.drawable.ud_icon_number_outlined, "number", r102, 0, 16, null);
        NUMBER = r103;
        EFieldUIType r104 = new EFieldUIType("SINGLE_SELECT", 3, "SingleSelect", R.drawable.ud_icon_down_round_outlined, "single_option", NativeCell.SELECT, 0, 16, null);
        SINGLE_SELECT = r104;
        EFieldUIType r105 = new EFieldUIType("MULTI_SELECT", 4, "MultiSelect", R.drawable.ud_icon_group_selection_outlined, "multi_options", NativeCell.MutilSELECT, 0, 16, null);
        MULTI_SELECT = r105;
        NativeCell r310 = NativeCell.DATE_TIME;
        EFieldUIType r106 = new EFieldUIType("DATE_TIME", 5, ExifInterface.TAG_DATETIME, R.drawable.ud_icon_calendar_line_outlined, "date", r310, R.drawable.ud_icon_calendar_add_outlined);
        DATE_TIME = r106;
        EFieldUIType r210 = new EFieldUIType("CHECKBOX", 6, "Checkbox", R.drawable.ud_icon_todo_outlined, "checkbox", NativeCell.CHECKBOX, r111, r112, r113);
        CHECKBOX = r210;
        NativeCell r114 = NativeCell.User;
        EFieldUIType r412 = new EFieldUIType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 7, "User", R.drawable.ud_icon_member_outlined, "person", r114, R.drawable.ud_icon_member_add_outlined);
        USER = r412;
        EFieldUIType r211 = new EFieldUIType("GROUP", 8, "GroupChat", R.drawable.ud_icon_group_outlined, "group", r114, R.drawable.ud_icon_add_chat_outlined);
        GROUP = r211;
        EFieldUIType r212 = new EFieldUIType("PHONE", 9, "Phone", R.drawable.ud_icon_officephone_outlined, "tel", r102, R.drawable.ud_icon_call_message_outlined);
        PHONE = r212;
        EFieldUIType r213 = new EFieldUIType(CommonConstant.RETKEY.EMAIL, 10, "Email", R.drawable.ud_icon_mail_outlined, "email", r102, R.drawable.ud_icon_mail_outlined);
        EMAIL = r213;
        EFieldUIType r214 = new EFieldUIType("URL", 11, "Url", R.drawable.ud_icon_link_copy_outlined, "link", r102, R.drawable.ud_icon_sharelink_outlined);
        URL = r214;
        EFieldUIType r413 = new EFieldUIType("ATTACHMENT", 12, "Attachment", R.drawable.ud_icon_attachment_outlined, SlashMentionConfig.MENTION_CONTENT_ATTACHMENT, NativeCell.ATTACHMENT, R.drawable.ud_icon_upload_outlined);
        ATTACHMENT = r413;
        NativeCell r311 = NativeCell.LINK;
        EFieldUIType r215 = new EFieldUIType("SINGLE_LINK", 13, "SingleLink", R.drawable.ud_icon_sheet_onedatareference_outlined, "relation", r311, R.drawable.ud_icon_sheet_onedatareference_outlined);
        SINGLE_LINK = r215;
        int r115 = 0;
        EFieldUIType r414 = new EFieldUIType("LOOKUP", 14, "Lookup", R.drawable.ud_icon_lookup_outlined, "lookup", r110, r115, r112, r113);
        LOOKUP = r414;
        EFieldUIType r415 = new EFieldUIType("FORMULA", 15, "Formula", R.drawable.ud_icon_base_formula_outlined, ITTReaderViewWrapper.SELECTION_KEY_FORMULA, r110, r115, r112, r113);
        FORMULA = r415;
        EFieldUIType r416 = new EFieldUIType("DUPLEX_LINK", 16, "DuplexLink", R.drawable.ud_icon_sheet_datareference_outlined, "duplex_relation", r311, R.drawable.ud_icon_sheet_datareference_outlined);
        DUPLEX_LINK = r416;
        EFieldUIType r510 = new EFieldUIType(HTTP.LOCATION, 17, "Location", R.drawable.ud_icon_local_outlined, "geography", r102, r115, r112, r113);
        LOCATION = r510;
        int r417 = 0;
        int r312 = 0;
        int r313 = 16;
        DefaultConstructorMarker r314 = null;
        EFieldUIType r511 = new EFieldUIType("CREATED_TIME", 18, "CreatedTime", R.drawable.ud_icon_calendar_add_outlined, "create_time", r310, r312, r313, r314);
        CREATED_TIME = r511;
        EFieldUIType r512 = new EFieldUIType("MODIFIED_TIME", 19, "ModifiedTime", R.drawable.ud_icon_calendar_edit_outlined, "update_time", r310, r312, r313, r314);
        MODIFIED_TIME = r512;
        NativeCell r418 = NativeCell.SingleUser;
        EFieldUIType r216 = new EFieldUIType("CREATED_USER", 20, "CreatedUser", R.drawable.ud_icon_member_add_outlined, "created_by", r418, r115, r112, r113);
        CREATED_USER = r216;
        EFieldUIType r217 = new EFieldUIType("MODIFIED_USER", 21, "ModifiedUser", R.drawable.ud_icon_member_modified_outlined, "modified_by", r418, r417, r410, r411);
        MODIFIED_USER = r217;
        EFieldUIType r218 = new EFieldUIType("AUTO_NUMBER", 22, "AutoNumber", R.drawable.ud_icon_numbered_list_new_outlined, "auto_number", r102, 0, r112, r113);
        AUTO_NUMBER = r218;
        EFieldUIType r219 = new EFieldUIType("BARCODE", 23, "Barcode", R.drawable.ud_icon_barcode_outlined, "scan", r102, R.drawable.ud_icon_scan_outlined);
        BARCODE = r219;
        EFieldUIType r315 = new EFieldUIType("CURRENCY", 24, "Currency", R.drawable.ud_icon_currency_dollar_outlined, "currency", r102, R.drawable.ud_icon_currency_yuan_outlined);
        CURRENCY = r315;
        EFieldUIType r107 = new EFieldUIType("PROGRESS", 25, "Progress", R.drawable.ud_icon_bitable_progress_outlined, "progress", NativeCell.PROGRESS, 0, 16, null);
        PROGRESS = r107;
        EFieldUIType r316 = new EFieldUIType("BUTTON", 26, "Button", R.drawable.ud_icon_button_outlined, "button", NativeCell.BUTTON, 0, 16, null);
        BUTTON = r316;
        EFieldUIType r317 = new EFieldUIType("RATING", 27, "Rating", R.drawable.ud_icon_collection_outlined, "rating", NativeCell.RATINGBAR, 0, r112, r113);
        RATING = r317;
        EFieldUIType r419 = new EFieldUIType("STAGE", 28, "Stage", R.drawable.ud_icon_base_dependency_outlined, "stage", NativeCell.STAGE, r417, r410, r411);
        STAGE = r419;
        EFieldUIType r318 = new EFieldUIType("SIGNATURE", 29, "Signature", R.drawable.ud_icon_pen_outlined, "signature", NativeCell.SIGNATURE, R.drawable.ud_icon_pen_outlined);
        SIGNATURE = r318;
        String r116 = "FORM_GRID";
        int r117 = 30;
        String r118 = "FormGrid";
        int r119 = R.drawable.ud_icon_sheet_bitable_outlined;
        String r120 = "grid_from";
        EFieldUIType r319 = new EFieldUIType(r116, r117, r118, r119, r120, r110, 0, 16, null);
        FORM_GRID = r319;
        EFieldUIType[] r108 = {r100, r101, r103, r104, r105, r106, r210, r412, r211, r212, r213, r214, r413, r215, r414, r415, r416, r510, r511, r512, r216, r217, r218, r219, r315, r107, r316, r317, r419, r318, r319};
        f209856a = r108;
        f209857b = EnumEntriesKt.enumEntries(r108);
        Companion = new a();
    }

    public static EFieldUIType[] values() {
        return (EFieldUIType[]) f209856a.clone();
    }

    public final int getAddValueIcon() {
        return this.addValueIcon;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final NativeCell getNativeCell() {
        return this.nativeCell;
    }

    public final String getReportValue() {
        return this.reportValue;
    }

    public final String getValue() {
        return this.value;
    }

    public static EFieldUIType valueOf(String r100) {
        return (EFieldUIType) r27.a.a(EFieldUIType.class, r100);
    }

    public final void setAddValueIcon(int r100) {
        this.addValueIcon = r100;
    }

    public final void setIconRes(int r100) {
        this.iconRes = r100;
    }

    public EFieldUIType(String r100, int r101, String r102, int r103, String r104, NativeCell r105, int r106) {
        super(r100, r101);
        this.value = r102;
        this.iconRes = r103;
        this.reportValue = r104;
        this.nativeCell = r105;
        this.addValueIcon = r106;
    }

    public /* synthetic */ EFieldUIType(String r110, int r111, String r112, int r113, String r114, NativeCell r115, int r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 16) == 0) goto L5;
        int r100 = R.drawable.ud_icon_add_middle_outlined;
    L6:
        this(r110, r111, r112, r113, r114, r115, r100);
        return;
    L5:
        r100 = r116;
        goto L6
    }
}
