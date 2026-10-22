package kotlin.text;

import com.ss.ttvideoengine.model.SubInfo;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u000b\u001a\u001c\u0010\f\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u000e\u001a\u001c\u0010\u000f\u001a\u00020\u0010*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a2\u0010\u0012\u001a\u00020\u0002*\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\n2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u001e\u0010\u0012\u001a\u00020\u0002*\u00020\u00102\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b \u0010!¨\u0006\""}, d2 = {"hexToUByte", "Lkotlin/UByte;", "", SubInfo.KEY_FORMAT, "Lkotlin/text/HexFormat;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)B", "hexToUByteArray", "Lkotlin/UByteArray;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)[B", "hexToUInt", "Lkotlin/UInt;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)I", "hexToULong", "Lkotlin/ULong;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)J", "hexToUShort", "Lkotlin/UShort;", "(Ljava/lang/String;Lkotlin/text/HexFormat;)S", "toHexString", "toHexString-ZQbaR00", "(BLkotlin/text/HexFormat;)Ljava/lang/String;", "startIndex", "", "endIndex", "toHexString-lZCiFrA", "([BIILkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-zHuV2wU", "([BLkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-8M7LxHw", "(ILkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-8UJCm-I", "(JLkotlin/text/HexFormat;)Ljava/lang/String;", "toHexString-r3ox_E0", "(SLkotlin/text/HexFormat;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UHexExtensionsKt {
    private static final byte hexToUByte(String r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return UByte.m9467constructorimpl(HexExtensionsKt.hexToByte(r100, r101));
    }

    private static final byte[] hexToUByteArray(String r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return UByteArray.m9520constructorimpl(HexExtensionsKt.hexToByteArray(r100, r101));
    }

    private static final int hexToUInt(String r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return UInt.m9544constructorimpl(HexExtensionsKt.hexToInt(r100, r101));
    }

    private static final long hexToULong(String r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return ULong.m9623constructorimpl(HexExtensionsKt.hexToLong(r100, r101));
    }

    private static final short hexToUShort(String r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return UShort.m9730constructorimpl(HexExtensionsKt.hexToShort(r100, r101));
    }

    /* JADX INFO: renamed from: toHexString-8M7LxHw, reason: not valid java name */
    private static final String m10767toHexString8M7LxHw(int r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101);
    }

    /* JADX INFO: renamed from: toHexString-8UJCm-I, reason: not valid java name */
    private static final String m10769toHexString8UJCmI(long r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101);
    }

    /* JADX INFO: renamed from: toHexString-ZQbaR00, reason: not valid java name */
    private static final String m10771toHexStringZQbaR00(byte r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101);
    }

    /* JADX INFO: renamed from: toHexString-r3ox_E0, reason: not valid java name */
    private static final String m10775toHexStringr3ox_E0(short r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101);
    }

    /* JADX INFO: renamed from: toHexString-zHuV2wU, reason: not valid java name */
    private static final String m10777toHexStringzHuV2wU(byte[] r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101);
    }

    public static /* synthetic */ byte hexToUByte$default(String r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return UByte.m9467constructorimpl(HexExtensionsKt.hexToByte(r100, r101));
    }

    public static /* synthetic */ byte[] hexToUByteArray$default(String r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return UByteArray.m9520constructorimpl(HexExtensionsKt.hexToByteArray(r100, r101));
    }

    public static /* synthetic */ int hexToUInt$default(String r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return UInt.m9544constructorimpl(HexExtensionsKt.hexToInt(r100, r101));
    }

    public static /* synthetic */ long hexToULong$default(String r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return ULong.m9623constructorimpl(HexExtensionsKt.hexToLong(r100, r101));
    }

    public static /* synthetic */ short hexToUShort$default(String r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return UShort.m9730constructorimpl(HexExtensionsKt.hexToShort(r100, r101));
    }

    /* JADX INFO: renamed from: toHexString-8M7LxHw$default, reason: not valid java name */
    public static /* synthetic */ String m10768toHexString8M7LxHw$default(int r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101);
    }

    /* JADX INFO: renamed from: toHexString-8UJCm-I$default, reason: not valid java name */
    public static /* synthetic */ String m10770toHexString8UJCmI$default(long r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101);
    }

    /* JADX INFO: renamed from: toHexString-ZQbaR00$default, reason: not valid java name */
    public static /* synthetic */ String m10772toHexStringZQbaR00$default(byte r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101);
    }

    /* JADX INFO: renamed from: toHexString-lZCiFrA, reason: not valid java name */
    private static final String m10773toHexStringlZCiFrA(byte[] r100, int r101, int r102, HexFormat r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r103, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101, r102, r103);
    }

    /* JADX INFO: renamed from: toHexString-r3ox_E0$default, reason: not valid java name */
    public static /* synthetic */ String m10776toHexStringr3ox_E0$default(short r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101);
    }

    /* JADX INFO: renamed from: toHexString-zHuV2wU$default, reason: not valid java name */
    public static /* synthetic */ String m10778toHexStringzHuV2wU$default(byte[] r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = HexFormat.Companion.getDefault();
    L5:
        Intrinsics.checkNotNullParameter(r100, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101);
    }

    /* JADX INFO: renamed from: toHexString-lZCiFrA$default, reason: not valid java name */
    public static /* synthetic */ String m10774toHexStringlZCiFrA$default(byte[] r100, int r101, int r102, HexFormat r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = UByteArray.m9526getSizeimpl(r100);
    L9:
        if ((r104 & 4) == 0) goto L11;
        r103 = HexFormat.Companion.getDefault();
    L11:
        Intrinsics.checkNotNullParameter(r100, "$this$toHexString");
        Intrinsics.checkNotNullParameter(r103, SubInfo.KEY_FORMAT);
        return HexExtensionsKt.toHexString(r100, r101, r102, r103);
    }
}
