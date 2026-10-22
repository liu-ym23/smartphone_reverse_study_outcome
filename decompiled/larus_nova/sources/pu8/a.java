package pu8;

import com.larus.bot.impl.bean.BotPolishDescResp;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f530760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BotPolishDescResp f530761b;

    public a() {
        this(null, null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f530760a, r101.f530760a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f530761b, r101.f530761b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f530760a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        BotPolishDescResp r104 = this.f530761b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotPolishDescUpdateResp(errorMsg=" + this.f530760a + ", result=" + this.f530761b + ')';
    }

    public a(String r100, BotPolishDescResp r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f530760a = r100;
        this.f530761b = r101;
    }
}
