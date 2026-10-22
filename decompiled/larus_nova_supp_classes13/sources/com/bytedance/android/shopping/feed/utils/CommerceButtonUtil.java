package com.bytedance.android.shopping.feed.utils;

import com.bytedance.android.ec.model.response.anchorv3.PromotionAppointment;
import com.bytedance.android.ec.model.response.anchorv3.PromotionPreSale;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.response.anchorv3.SeckillInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CommerceButtonUtil {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/shopping/feed/utils/CommerceButtonUtil$ButtonStatus;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "CAN_BUY", "SELL_OUT", "PRE_SELL", "OFF_SALE", "SEC_KILL", "APPOINTMENT", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum ButtonStatus extends Enum<ButtonStatus> {
        public static final ButtonStatus APPOINTMENT = null;
        public static final ButtonStatus CAN_BUY = null;
        public static final ButtonStatus OFF_SALE = null;
        public static final ButtonStatus PRE_SELL = null;
        public static final ButtonStatus SEC_KILL = null;
        public static final ButtonStatus SELL_OUT = null;
        public static final /* synthetic */ ButtonStatus[] a = null;
        private final String type;

        static {
            ButtonStatus r1 = new ButtonStatus("CAN_BUY", 0, "0");
            CAN_BUY = r1;
            ButtonStatus r2 = new ButtonStatus("SELL_OUT", 1, "1");
            SELL_OUT = r2;
            ButtonStatus r3 = new ButtonStatus("PRE_SELL", 2, "2");
            PRE_SELL = r3;
            ButtonStatus r4 = new ButtonStatus("OFF_SALE", 3, "3");
            OFF_SALE = r4;
            ButtonStatus r5 = new ButtonStatus("SEC_KILL", 4, "4");
            SEC_KILL = r5;
            ButtonStatus r6 = new ButtonStatus("APPOINTMENT", 5, "5");
            APPOINTMENT = r6;
            a = new ButtonStatus[]{r1, r2, r3, r4, r5, r6};
        }

        public static ButtonStatus valueOf(String r1) {
            return (ButtonStatus) r27.a.a(ButtonStatus.class, r1);
        }

        public static ButtonStatus[] values() {
            return (ButtonStatus[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public ButtonStatus(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    static {
    }

    @JvmStatic
    public static final ButtonStatus a(PromotionProductStruct r2) {
        Intrinsics.checkNotNullParameter(r2, "productStruct");
        PromotionProductPrivilegesStruct r0 = r2.getPrivilegeInfo();
        SeckillInfo r1 = null;
        if (r0 == null) goto L7;
        PromotionProductActivitiesStruct r3 = r0.getActivities();
        if (r3 == null) goto L7;
        PromotionPreSale r4 = r3.getPresaleActivity();
    L8:
        if (r4 != null) goto L38;
        PromotionProductPrivilegesStruct r5 = r2.getPrivilegeInfo();
        if (r5 == null) goto L15;
        PromotionProductActivitiesStruct r6 = r5.getActivities();
        if (r6 == null) goto L15;
        PromotionAppointment r7 = r6.getAppointActivity();
    L16:
        if (r7 != null) goto L39;
        PromotionProductPrivilegesStruct r8 = r2.getPrivilegeInfo();
        if (r8 == null) goto L23;
        PromotionProductActivitiesStruct r9 = r8.getActivities();
        if (r9 == null) goto L23;
        r1 = r9.getSecKillActivity();
    L23:
        if (r1 != null) goto L40;
        PromotionProductBaseStruct r10 = r2.getBaseInfo();
        if (r10 == null) goto L37;
        if (r10.getStatus() != 2) goto L37;
        PromotionProductBaseStruct r11 = r2.getBaseInfo();
        if (r11 == null) goto L42;
        if (r11.isSoldOut() != true) goto L42;
        return ButtonStatus.SELL_OUT;
    L42:
        return ButtonStatus.CAN_BUY;
    L37:
        return ButtonStatus.OFF_SALE;
    L40:
        return ButtonStatus.SEC_KILL;
    L39:
        return ButtonStatus.APPOINTMENT;
    L15:
        r7 = null;
        goto L16
    L38:
        return ButtonStatus.PRE_SELL;
    L7:
        r4 = null;
        goto L8
    }
}
