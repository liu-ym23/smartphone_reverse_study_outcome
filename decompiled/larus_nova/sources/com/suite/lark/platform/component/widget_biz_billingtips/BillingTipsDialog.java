package com.suite.lark.platform.component.widget_biz_billingtips;

import com.larus.nova.R;
import com.ss.android.lark.statistics.Statistics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class BillingTipsDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f460787a;

    public static final enum Type extends Enum<Type> {
        public static final Type BUZZ_LIMIT_ADMIN = null;
        public static final Type BUZZ_LIMIT_USER = null;
        public static final Type CHAT_ADD_MEM_NUMBER_LIMIT = null;
        public static final Type CHAT_CREATE_EXTERNEL_GROUP_NUMBER_LIMIT = null;
        public static final Type CHAT_CREATE_GROUP_NUMBER_LIMIT = null;
        public static final Type CHAT_JOIN_EXTERNEL_GROUP_NUMBER_LIMIT = null;
        public static final Type CHAT_JOIN_GROUP_NUMBER_LIMIT = null;
        public static final Type UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Type[] f460788a = null;
        final int defaultTipsRes;
        final int leftBtnRes;
        final String reportType;
        final int rightBtnRes;
        final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, -1, R.string.Lark_Legacy_UnknownErr, R.string.Lark_Group_Cancel, R.string.Lark_Group_UplimitContactSalesButton, "");
            UNKNOWN = r100;
            Type r101 = new Type("CHAT_ADD_MEM_NUMBER_LIMIT", 1, 1, R.string.Lark_Group_UplimitUnableAddTitle, R.string.Lark_Group_Cancel, R.string.Lark_Group_UplimitContactSalesButton, "chat_number_limit");
            CHAT_ADD_MEM_NUMBER_LIMIT = r101;
            Type r102 = new Type("CHAT_CREATE_GROUP_NUMBER_LIMIT", 2, 2, R.string.Lark_Group_UplimitUnableCreateTitle, R.string.Lark_Group_Cancel, R.string.Lark_Group_UplimitContactSalesButton, "chat_number_limit");
            CHAT_CREATE_GROUP_NUMBER_LIMIT = r102;
            Type r103 = new Type("CHAT_JOIN_GROUP_NUMBER_LIMIT", 3, 3, R.string.Lark_Group_UplimitUnableJoinTitle, R.string.Lark_Group_Cancel, R.string.Lark_Group_UplimitContactSalesButton, "chat_number_limit");
            CHAT_JOIN_GROUP_NUMBER_LIMIT = r103;
            Type r104 = new Type("CHAT_CREATE_EXTERNEL_GROUP_NUMBER_LIMIT", 4, 4, R.string.Lark_Group_UnableToCreateUplimitTitle, R.string.Lark_Group_Cancel, R.string.Lark_Group_UplimitContactSalesButton, "chat_number_limit");
            CHAT_CREATE_EXTERNEL_GROUP_NUMBER_LIMIT = r104;
            Type r105 = new Type("CHAT_JOIN_EXTERNEL_GROUP_NUMBER_LIMIT", 5, 5, R.string.Lark_Group_UnableToJoinUplimitTitle, R.string.Lark_Group_Cancel, R.string.Lark_Group_UplimitContactSalesButton, "chat_number_limit");
            CHAT_JOIN_EXTERNEL_GROUP_NUMBER_LIMIT = r105;
            Type r106 = new Type("BUZZ_LIMIT_ADMIN", 6, 6, R.string.Lark_Buzz_CantBuzzContactSupport, R.string.Lark_Buzz_ExceededQuotaButtonClose, R.string.Lark_Buzz_ExceededQuotaButton, "buzz_limit");
            BUZZ_LIMIT_ADMIN = r106;
            Type r107 = new Type("BUZZ_LIMIT_USER", 7, 7, R.string.Lark_Buzz_CantBuzzContactAdmin, -1, R.string.Lark_Legacy_IKnow, "buzz_limit");
            BUZZ_LIMIT_USER = r107;
            f460788a = new Type[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        public static Type[] values() {
            return (Type[]) f460788a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static Type forNumber(int r100) {
            switch(r100) {
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L4;
            };
        L4:
            return UNKNOWN;
        L6:
            return BUZZ_LIMIT_USER;
        L8:
            return BUZZ_LIMIT_ADMIN;
        L10:
            return CHAT_JOIN_EXTERNEL_GROUP_NUMBER_LIMIT;
        L12:
            return CHAT_CREATE_EXTERNEL_GROUP_NUMBER_LIMIT;
        L14:
            return CHAT_JOIN_GROUP_NUMBER_LIMIT;
        L16:
            return CHAT_CREATE_GROUP_NUMBER_LIMIT;
        L18:
            return CHAT_ADD_MEM_NUMBER_LIMIT;
        }

        public static Type valueOf(String r100) {
            return (Type) r27.a.a(Type.class, r100);
        }

        public static Type valueOf(int r100) {
            return forNumber(r100);
        }

        public Type(String r100, int r101, int r102, int r103, int r104, int r105, String r106) {
            super(r100, r101);
            this.value = r102;
            this.defaultTipsRes = r103;
            this.leftBtnRes = r104;
            this.rightBtnRes = r105;
            this.reportType = r106;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f460789a = null;

        static {
            int[] r100 = new int[Type.values().length];
            f460789a = r100;
            r100[Type.BUZZ_LIMIT_ADMIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f460789a[Type.CHAT_CREATE_GROUP_NUMBER_LIMIT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f460789a[Type.CHAT_JOIN_GROUP_NUMBER_LIMIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f460789a[Type.CHAT_ADD_MEM_NUMBER_LIMIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f460789a[Type.CHAT_CREATE_EXTERNEL_GROUP_NUMBER_LIMIT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f460789a[Type.CHAT_JOIN_EXTERNEL_GROUP_NUMBER_LIMIT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public static void a(Type r100) {
        JSONObject r101 = new JSONObject();
        r101.put("function_type", r100.reportType);     // Catch: JSONException -> L5
        r101.put("admin_flag", f460787a);     // Catch: JSONException -> L5
    L7:
        Statistics.sendEvent("common_pricing_popup_click", r101);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static void b(Type r100) {
        JSONObject r101 = new JSONObject();
        r101.put("function_type", r100.reportType);     // Catch: JSONException -> L5
        r101.put("admin_flag", f460787a);     // Catch: JSONException -> L5
    L7:
        Statistics.sendEvent("common_pricing_popup_view", r101);
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }
}
