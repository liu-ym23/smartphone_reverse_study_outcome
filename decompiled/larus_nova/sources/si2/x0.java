package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2CouponMeta;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes10.dex */
public final class x0 implements am3.c<ECV2CouponMeta> {
    public x0() {
    }

    public static ECV2CouponMeta a(am3.g r100) throws Exception {
        ECV2CouponMeta r101 = new ECV2CouponMeta();
        r101.productIds = new ArrayList();
        long r102 = r100.c();
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L56;
        if (r103 != 45) goto L8;
        r101.kolUserTag = r100.j();
        goto L3
    L8:
        if (r103 != 50) goto L9;
        r101.extraData = am3.h.c(r100);
        goto L3
    L9:
        switch(r103) {
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
        r101.typeTitle = am3.h.c(r100);
        goto L3
    L12:
        r101.hasAvailableGoods = am3.h.a(r100);
        goto L3
    L13:
        r101.platformSubType = r100.j();
        goto L3
    L14:
        r101.productIds.add(Long.valueOf(r100.j()));
        goto L3
    L15:
        r101.kolUid = r100.j();
        goto L3
    L16:
        r101.avatar = am3.h.c(r100);
        goto L3
    L17:
        r101.expireTimeStamp = r100.j();
        goto L3
    L18:
        r101.startTimeStamp = r100.j();
        goto L3
    L19:
        r101.couponReset = am3.h.a(r100);
        goto L3
    L20:
        r101.couponStatus = am3.h.a(r100);
        goto L3
    L21:
        r101.canContinueApply = am3.h.a(r100);
        goto L3
    L22:
        r101.userApplyTimes = r100.j();
        goto L3
    L23:
        r101.couponSource = r100.i();
        goto L3
    L24:
        r101.liveCouponStatus = r100.i();
        goto L3
    L25:
        r101.totalAmount = r100.j();
        goto L3
    L26:
        r101.isShow = r100.j();
        goto L3
    L27:
        r101.shopLogo = am3.h.c(r100);
        goto L3
    L28:
        r101.status = r100.j();
        goto L3
    L29:
        r101.hasApplied = r100.j();
        goto L3
    L30:
        r101.leftAmount = r100.j();
        goto L3
    L31:
        r101.channelId = r100.j();
        goto L3
    L32:
        r101.couponString = am3.h.c(r100);
        goto L3
    L33:
        r101.whatCoupon = am3.h.c(r100);
        goto L3
    L34:
        r101.typeString = am3.h.c(r100);
        goto L3
    L35:
        r101.shopName = am3.h.c(r100);
        goto L3
    L36:
        r101.maxDiscountLimit = r100.j();
        goto L3
    L37:
        r101.payType = r100.j();
        goto L3
    L38:
        r101.shopId = am3.h.c(r100);
        goto L3
    L39:
        r101.discount = Double.longBitsToDouble(r100.h());
        goto L3
    L40:
        r101.typeDetail = am3.h.c(r100);
        goto L3
    L41:
        r101.type = r100.j();
        goto L3
    L42:
        r101.maxApplyTimes = r100.j();
        goto L3
    L43:
        r101.credit = r100.j();
        goto L3
    L44:
        r101.threshold = r100.j();
        goto L3
    L45:
        r101.url = am3.h.c(r100);
        goto L3
    L46:
        r101.couponName = am3.h.c(r100);
        goto L3
    L47:
        r101.endApplyTime = am3.h.c(r100);
        goto L3
    L48:
        r101.startApplyTime = am3.h.c(r100);
        goto L3
    L49:
        r101.validPeriod = r100.j();
        goto L3
    L50:
        r101.periodType = r100.j();
        goto L3
    L51:
        r101.expireTime = am3.h.c(r100);
        goto L3
    L52:
        r101.startTime = am3.h.c(r100);
        goto L3
    L53:
        r101.couponMetaId = am3.h.c(r100);
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L56:
        r100.d(r102);
        return r101;
    }

    @Override // am3.c
    public final ECV2CouponMeta decode(am3.g r100) throws Exception {
        return a(r100);
    }
}
