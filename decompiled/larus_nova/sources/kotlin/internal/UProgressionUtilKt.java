package kotlin.internal;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u0000\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u000f\u0010\u0006\u001a'\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"differenceModulo", "Lkotlin/UInt;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UProgressionUtilKt {
    /* JADX INFO: renamed from: differenceModulo-WZ9TVnA, reason: not valid java name */
    private static final int m10659differenceModuloWZ9TVnA(int r100, int r101, int r102) {
        long r103 = ((long) r100) & BodyPartID.bodyIdMax;
        long r104 = ((long) r102) & BodyPartID.bodyIdMax;
        int r105 = (int) (r103 % r104);
        int r106 = (int) ((((long) r101) & BodyPartID.bodyIdMax) % r104);
        int r107 = Integer.compare(r105 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ r106);
        int r108 = UInt.m9544constructorimpl(r105 - r106);
        if (r107 < 0) goto L6;
        return r108;
    L6:
        return UInt.m9544constructorimpl(r108 + r102);
    }

    /* JADX INFO: renamed from: differenceModulo-sambcqE, reason: not valid java name */
    private static final long m10660differenceModulosambcqE(long r110, long r111, long r112) {
        long r100 = 0;
        if (r112 >= 0) goto L9;
        if ((r110 ^ Long.MIN_VALUE) >= (r112 ^ Long.MIN_VALUE)) goto L7;
        long r101 = r110;
    L16:
        if (r112 >= 0) goto L22;
        if ((r111 ^ Long.MIN_VALUE) >= (r112 ^ Long.MIN_VALUE)) goto L20;
        long r102 = r111;
    L28:
        int r103 = Long.compare(r101 ^ Long.MIN_VALUE, r102 ^ Long.MIN_VALUE);
        long r104 = ULong.m9623constructorimpl(r101 - r102);
        if (r103 < 0) goto L32;
        return r104;
    L32:
        return ULong.m9623constructorimpl(r104 + r112);
    L20:
        r102 = r111 - r112;
        goto L28
    L22:
        if (r111 < 0) goto L24;
        r102 = r111 % r112;
        goto L28
    L24:
        long r105 = r111 - ((((r111 >>> 1) / r112) << 1) * r112);
        if ((r105 ^ Long.MIN_VALUE) < (r112 ^ Long.MIN_VALUE)) goto L27;
        r100 = r112;
    L27:
        r102 = r105 - r100;
        goto L28
    L7:
        r101 = r110 - r112;
        goto L16
    L9:
        if (r110 < 0) goto L11;
        r101 = r110 % r112;
        goto L16
    L11:
        long r106 = r110 - ((((r110 >>> 1) / r112) << 1) * r112);
        if ((r106 ^ Long.MIN_VALUE) < (r112 ^ Long.MIN_VALUE)) goto L14;
        long r107 = r112;
    L15:
        r101 = r106 - r107;
        goto L16
    L14:
        r107 = 0;
        goto L15
    }

    /* JADX INFO: renamed from: getProgressionLastElement-7ftBX0g, reason: not valid java name */
    public static final long m10661getProgressionLastElement7ftBX0g(long r100, long r101, long r110) {
        if (r110 > 0) goto L5;
        if (r110 >= 0) goto L15;
        if (Long.compare(r100 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ r101) > 0) goto L13;
        return r101;
    L13:
        return ULong.m9623constructorimpl(r101 + m10660differenceModulosambcqE(r100, r101, ULong.m9623constructorimpl(-r110)));
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (Long.compare(r100 ^ Long.MIN_VALUE, Long.MIN_VALUE ^ r101) < 0) goto L16;
        return r101;
    L16:
        return ULong.m9623constructorimpl(r101 - m10660differenceModulosambcqE(r101, r100, ULong.m9623constructorimpl(r110)));
    }

    /* JADX INFO: renamed from: getProgressionLastElement-Nkh28Cs, reason: not valid java name */
    public static final int m10662getProgressionLastElementNkh28Cs(int r100, int r101, int r102) {
        if (r102 > 0) goto L5;
        if (r102 >= 0) goto L15;
        if (Integer.compare(r100 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ r101) > 0) goto L13;
        return r101;
    L13:
        return UInt.m9544constructorimpl(r101 + m10659differenceModuloWZ9TVnA(r100, r101, UInt.m9544constructorimpl(-r102)));
    L15:
        throw new IllegalArgumentException("Step is zero.");
    L5:
        if (Integer.compare(r100 ^ Integer.MIN_VALUE, Integer.MIN_VALUE ^ r101) < 0) goto L16;
        return r101;
    L16:
        return UInt.m9544constructorimpl(r101 - m10659differenceModuloWZ9TVnA(r101, r100, UInt.m9544constructorimpl(r102)));
    }
}
