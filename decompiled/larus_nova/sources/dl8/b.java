package dl8;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.FileOperationBlock;
import kc8.y;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f469142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pair<Integer, Integer> f469143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f469144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FileOperationBlock f469145d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f469146e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f469147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f469148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final y f469149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f469150i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f469151j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Boolean> f469152k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f469153l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f469154m;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f469142a, r101.f469142a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f469143b, r101.f469143b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f469144c, r101.f469144c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f469145d, r101.f469145d) == true) goto L21;
        return false;
    L21:
        if (this.f469146e == r101.f469146e) goto L24;
        return false;
    L24:
        if (this.f469147f == r101.f469147f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f469148g, r101.f469148g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f469149h, r101.f469149h) == true) goto L33;
        return false;
    L33:
        if (this.f469150i == r101.f469150i) goto L36;
        return false;
    L36:
        if (this.f469151j == r101.f469151j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f469152k, r101.f469152k) == true) goto L42;
        return false;
    L42:
        if (this.f469153l == r101.f469153l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f469154m, r101.f469154m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f469142a.hashCode() * 31;
        Pair<Integer, Integer> r101 = this.f469143b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Message r105 = this.f469144c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        FileOperationBlock r108 = this.f469145d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        int r111 = 1231;
        if (this.f469146e == false) goto L17;
        int r112 = 1231;
    L18:
        int r113 = (((r110 + r112) * 31) + this.f469147f) * 31;
        Integer r114 = this.f469148g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        y r117 = this.f469149h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (((r116 + r118) * 31) + this.f469150i) * 31;
        if (this.f469151j == false) goto L29;
        int r120 = 1231;
    L30:
        int r121 = (r119 + r120) * 31;
        Function0<Boolean> r122 = this.f469152k;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        if (this.f469153l == true) goto L38;
        r111 = 1237;
    L38:
        int r125 = (r124 + r111) * 31;
        Boolean r126 = this.f469154m;
        if (r126 == null) goto L43;
        r102 = r126.hashCode();
    L43:
        return r125 + r102;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = 1237;
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "FileOperateVMData(dataIdentifier=" + this.f469142a + ", topAndBottomMarginPair=" + this.f469143b + ", message=" + this.f469144c + ", fileOperationBlock=" + this.f469145d + ", isFinish=" + this.f469146e + ", cardPosition=" + this.f469147f + ", backgroundRes=" + this.f469148g + ", globalConfig=" + this.f469149h + ", startIndex=" + this.f469150i + ", isDeepThinkArea=" + this.f469151j + ", interceptClickCard=" + this.f469152k + ", disableFoldExpandClick=" + this.f469153l + ", initialFoldState=" + this.f469154m + ')';
    }

    public b(String r100, Pair r101, Message r102, FileOperationBlock r103, boolean r104, int r105, Integer r106, y r107, int r110, boolean r111, bl8.b r112, boolean r113, Boolean r114) {
        Intrinsics.checkNotNullParameter(r100, "dataIdentifier");
        this.f469142a = r100;
        this.f469143b = r101;
        this.f469144c = r102;
        this.f469145d = r103;
        this.f469146e = r104;
        this.f469147f = r105;
        this.f469148g = r106;
        this.f469149h = r107;
        this.f469150i = r110;
        this.f469151j = r111;
        this.f469152k = r112;
        this.f469153l = r113;
        this.f469154m = r114;
    }
}
