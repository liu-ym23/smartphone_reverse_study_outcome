package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2CouponMeta;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class x0 implements am3.c<ECV2CouponMeta> {
    public x0() {
    }

    public static ECV2CouponMeta a(am3.g r6) throws Exception {
        ECV2CouponMeta r0 = new ECV2CouponMeta();
        r0.productIds = new ArrayList();
        long r1 = r6.c();
    L3:
        int r3 = r6.f();
        if (r3 == (-1)) goto L56;
        if (r3 != 45) goto L8;
        r0.kolUserTag = r6.j();
        goto L3
    L8:
        if (r3 != 50) goto L9;
        r0.extraData = am3.h.c(r6);
        goto L3
    L9:
        switch(r3) {
            case 1: goto L53;
            case 2: goto L52;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L49;
            case 6: goto L48;
            case 7: goto L47;
            case 8: goto L46;
            case 9: goto L45;
            case 10: goto L44;
            case 11: goto L43;
            case 12: goto L42;
            case 13: goto L41;
            case 14: goto L40;
            case 15: goto L39;
            case 16: goto L38;
            case 17: goto L37;
            case 18: goto L36;
            case 19: goto L35;
            case 20: goto L34;
            case 21: goto L33;
            case 22: goto L32;
            case 23: goto L31;
            case 24: goto L30;
            case 25: goto L29;
            case 26: goto L28;
            case 27: goto L27;
            case 28: goto L26;
            case 29: goto L25;
            case 30: goto L24;
            case 31: goto L23;
            case 32: goto L22;
            case 33: goto L21;
            case 34: goto L20;
            case 35: goto L19;
            case 36: goto L18;
            case 37: goto L17;
            case 38: goto L16;
            case 39: goto L15;
            case 40: goto L14;
            case 41: goto L13;
            case 42: goto L12;
            case 43: goto L11;
            default: goto L10;
        };
    L11:
        r0.typeTitle = am3.h.c(r6);
        goto L3
    L12:
        r0.hasAvailableGoods = am3.h.a(r6);
        goto L3
    L13:
        r0.platformSubType = r6.j();
        goto L3
    L14:
        r0.productIds.add(Long.valueOf(r6.j()));
        goto L3
    L15:
        r0.kolUid = r6.j();
        goto L3
    L16:
        r0.avatar = am3.h.c(r6);
        goto L3
    L17:
        r0.expireTimeStamp = r6.j();
        goto L3
    L18:
        r0.startTimeStamp = r6.j();
        goto L3
    L19:
        r0.couponReset = am3.h.a(r6);
        goto L3
    L20:
        r0.couponStatus = am3.h.a(r6);
        goto L3
    L21:
        r0.canContinueApply = am3.h.a(r6);
        goto L3
    L22:
        r0.userApplyTimes = r6.j();
        goto L3
    L23:
        r0.couponSource = r6.i();
        goto L3
    L24:
        r0.liveCouponStatus = r6.i();
        goto L3
    L25:
        r0.totalAmount = r6.j();
        goto L3
    L26:
        r0.isShow = r6.j();
        goto L3
    L27:
        r0.shopLogo = am3.h.c(r6);
        goto L3
    L28:
        r0.status = r6.j();
        goto L3
    L29:
        r0.hasApplied = r6.j();
        goto L3
    L30:
        r0.leftAmount = r6.j();
        goto L3
    L31:
        r0.channelId = r6.j();
        goto L3
    L32:
        r0.couponString = am3.h.c(r6);
        goto L3
    L33:
        r0.whatCoupon = am3.h.c(r6);
        goto L3
    L34:
        r0.typeString = am3.h.c(r6);
        goto L3
    L35:
        r0.shopName = am3.h.c(r6);
        goto L3
    L36:
        r0.maxDiscountLimit = r6.j();
        goto L3
    L37:
        r0.payType = r6.j();
        goto L3
    L38:
        r0.shopId = am3.h.c(r6);
        goto L3
    L39:
        r0.discount = Double.longBitsToDouble(r6.h());
        goto L3
    L40:
        r0.typeDetail = am3.h.c(r6);
        goto L3
    L41:
        r0.type = r6.j();
        goto L3
    L42:
        r0.maxApplyTimes = r6.j();
        goto L3
    L43:
        r0.credit = r6.j();
        goto L3
    L44:
        r0.threshold = r6.j();
        goto L3
    L45:
        r0.url = am3.h.c(r6);
        goto L3
    L46:
        r0.couponName = am3.h.c(r6);
        goto L3
    L47:
        r0.endApplyTime = am3.h.c(r6);
        goto L3
    L48:
        r0.startApplyTime = am3.h.c(r6);
        goto L3
    L49:
        r0.validPeriod = r6.j();
        goto L3
    L50:
        r0.periodType = r6.j();
        goto L3
    L51:
        r0.expireTime = am3.h.c(r6);
        goto L3
    L52:
        r0.startTime = am3.h.c(r6);
        goto L3
    L53:
        r0.couponMetaId = am3.h.c(r6);
        goto L3
    L10:
        am3.h.e(r6);
        goto L3
    L56:
        r6.d(r1);
        return r0;
    }

    public final Object decode(am3.g r1) throws Exception {
        return a(r1);
    }
}
