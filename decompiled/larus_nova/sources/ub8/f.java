package ub8;

import com.larus.bmhome.bot.bean.BotLanguage;
import com.larus.im.bean.bot.BotModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f549377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BotLanguage f549378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BotModel f549379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f549380d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f549377a == r101.f549377a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f549378b, r101.f549378b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f549379c, r101.f549379c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f549380d, r101.f549380d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        if (this.f549377a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f549378b.hashCode()) * 31;
        BotModel r102 = this.f549379c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Long r106 = this.f549380d;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "LanguageUpdateResult(success=" + this.f549377a + ", botLanguage=" + this.f549378b + ", botInfo=" + this.f549379c + ", errCode=" + this.f549380d + ')';
    }

    public f(boolean r100, BotLanguage r101, BotModel r102, Long r103) {
        Intrinsics.checkNotNullParameter(r101, "botLanguage");
        this.f549377a = r100;
        this.f549378b = r101;
        this.f549379c = r102;
        this.f549380d = r103;
    }
}
