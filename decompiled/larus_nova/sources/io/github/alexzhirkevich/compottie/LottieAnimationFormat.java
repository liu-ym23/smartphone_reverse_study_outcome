package io.github.alexzhirkevich.compottie;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/github/alexzhirkevich/compottie/LottieAnimationFormat;", "", "<init>", "(Ljava/lang/String;I)V", "Json", "DotLottie", "Undefined", "compottie_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LottieAnimationFormat extends Enum<LottieAnimationFormat> {
    public static final LottieAnimationFormat DotLottie = null;
    public static final LottieAnimationFormat Json = null;
    public static final LottieAnimationFormat Undefined = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LottieAnimationFormat[] f490689a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f490690b = null;

    public static EnumEntries<LottieAnimationFormat> getEntries() {
        return f490690b;
    }

    static {
        LottieAnimationFormat r100 = new LottieAnimationFormat("Json", 0);
        Json = r100;
        LottieAnimationFormat r101 = new LottieAnimationFormat("DotLottie", 1);
        DotLottie = r101;
        LottieAnimationFormat r102 = new LottieAnimationFormat("Undefined", 2);
        Undefined = r102;
        LottieAnimationFormat[] r103 = {r100, r101, r102};
        f490689a = r103;
        f490690b = EnumEntriesKt.enumEntries(r103);
    }

    public static LottieAnimationFormat[] values() {
        return (LottieAnimationFormat[]) f490689a.clone();
    }

    public static LottieAnimationFormat valueOf(String r100) {
        return (LottieAnimationFormat) r27.a.a(LottieAnimationFormat.class, r100);
    }

    public LottieAnimationFormat(String r100, int r101) {
        super(r100, r101);
    }
}
