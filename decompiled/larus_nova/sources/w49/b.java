package w49;

import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlActionOption;
import com.larus.dora.impl.device.settings.lab.headcontrol.HeadControlGestureType;
import kotlin.NoWhenBranchMatchedException;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558266a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f558267a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f558268b = null;

        static {
            int[] r100 = new int[HeadControlGestureType.values().length];
            r100[HeadControlGestureType.NOD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[HeadControlGestureType.SHAKE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            f558267a = r100;
            int[] r101 = new int[HeadControlActionOption.values().length];
            r101[HeadControlActionOption.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r101[HeadControlActionOption.ACCEPT_CONFIRM.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r101[HeadControlActionOption.REJECT_CLOSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f558268b = r101;
        }
    }

    static {
    }

    public static String a(byte[] r100) {
        if (r100 == null) goto L4;
        String r101 = ArraysKt.joinToString$default(r100, null, "[", "]", 0, null, new w49.a(), 25, null);
    L5:
        if (r101 != null) goto L8;
        return "";
    L8:
        return r101;
    L4:
        r101 = null;
        goto L5
    }

    public static c b(byte[] r110) {
        Intrinsics.checkNotNullParameter(r110, "config");
        if ((r110.length % 2) == 0) goto L6;
        g49.d.e("HeadControlOptionProtocol", "Invalid head gesture config size, size=" + r110.length);
        return null;
    L6:
        int r100 = 0;
        int r101 = ProgressionUtilKt.getProgressionLastElement(0, r110.length - 1, 2);
        HeadControlActionOption r102 = null;
        HeadControlActionOption r103 = null;
        if (r101 < 0) goto L36;
    L8:
        int r104 = r110[r100] & UByte.MAX_VALUE;
        if (r104 != 3) goto L11;
        HeadControlGestureType r105 = HeadControlGestureType.NOD;
    L15:
        int r106 = r100 + 1;
        int r107 = r110[r106] & UByte.MAX_VALUE;
        if (r107 == 0) goto L22;
        if (r107 == 1) goto L21;
        if (r107 == 2) goto L20;
        HeadControlActionOption r108 = null;
    L23:
        if (r105 == null) goto L33;
        if (r108 == null) goto L33;
        int r109 = a.f558267a[r105.ordinal()];
        if (r109 == 1) goto L32;
        if (r109 != 2) goto L31;
        r103 = r108;
    L34:
        if (r100 == r101) goto L36;
        r100 = r100 + 2;
        goto L8
    L31:
        throw new NoWhenBranchMatchedException();
    L32:
        r102 = r108;
    L33:
        g49.d.e("HeadControlOptionProtocol", "Skip unknown head gesture pair, gesture=" + (r110[r100] & UByte.MAX_VALUE) + ", action=" + (r110[r106] & UByte.MAX_VALUE));
        goto L34
    L20:
        r108 = HeadControlActionOption.REJECT_CLOSE;
        goto L23
    L21:
        r108 = HeadControlActionOption.ACCEPT_CONFIRM;
        goto L23
    L22:
        r108 = HeadControlActionOption.NONE;
        goto L23
    L11:
        if (r104 == 4) goto L13;
        r105 = null;
        goto L15
    L13:
        r105 = HeadControlGestureType.SHAKE;
    L36:
        if (r102 != null) goto L40;
        if (r103 != null) goto L40;
        return null;
    L40:
        if (r102 != null) goto L42;
        r102 = HeadControlActionOption.NONE;
    L42:
        if (r103 != null) goto L45;
        r103 = HeadControlActionOption.NONE;
    L45:
        return new c(r102, r103);
    }
}
