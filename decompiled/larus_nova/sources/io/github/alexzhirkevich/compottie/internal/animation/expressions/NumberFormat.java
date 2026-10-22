package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\f\n\u0002\b\u000e\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fj\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lio/github/alexzhirkevich/compottie/internal/animation/expressions/NumberFormat;", "", "radix", "", "alphabet", "", "prefix", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/Character;)V", "getRadix", "()I", "getAlphabet", "()Ljava/lang/String;", "getPrefix", "()Ljava/lang/Character;", "Ljava/lang/Character;", "Dec", "Hex", "Oct", "Bin", "compottie_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum NumberFormat extends Enum<NumberFormat> {
    public static final NumberFormat Bin = null;
    public static final NumberFormat Dec = null;
    public static final NumberFormat Hex = null;
    public static final NumberFormat Oct = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ NumberFormat[] f490811a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f490812b = null;
    private final String alphabet;
    private final Character prefix;
    private final int radix;

    public static EnumEntries<NumberFormat> getEntries() {
        return f490812b;
    }

    static {
        NumberFormat r100 = new NumberFormat("Dec", 0, 10, ".0123456789", null);
        Dec = r100;
        NumberFormat r101 = new NumberFormat("Hex", 1, 16, "0123456789abcdef", Character.valueOf(Permission.EXECUTE));
        Hex = r101;
        NumberFormat r102 = new NumberFormat("Oct", 2, 8, "01234567", 'o');
        Oct = r102;
        NumberFormat r103 = new NumberFormat("Bin", 3, 2, HiAnalyticsConstant.KeyAndValue.NUMBER_01, Character.valueOf(BlockDevice.UNIX_ID));
        Bin = r103;
        NumberFormat[] r104 = {r100, r101, r102, r103};
        f490811a = r104;
        f490812b = EnumEntriesKt.enumEntries(r104);
    }

    public static NumberFormat[] values() {
        return (NumberFormat[]) f490811a.clone();
    }

    public final String getAlphabet() {
        return this.alphabet;
    }

    public final Character getPrefix() {
        return this.prefix;
    }

    public final int getRadix() {
        return this.radix;
    }

    public static NumberFormat valueOf(String r100) {
        return (NumberFormat) r27.a.a(NumberFormat.class, r100);
    }

    public NumberFormat(String r100, int r101, int r102, String r103, Character r104) {
        super(r100, r101);
        this.radix = r102;
        this.alphabet = r103;
        this.prefix = r104;
    }
}
