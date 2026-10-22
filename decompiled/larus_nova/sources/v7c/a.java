package v7c;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f553582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f553583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f553584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f553585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f553586e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f553582a == r101.f553582a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f553583b, r101.f553583b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f553584c, r101.f553584c) == true) goto L18;
        return false;
    L18:
        if (this.f553585d == r101.f553585d) goto L21;
        return false;
    L21:
        if (this.f553586e == r101.f553586e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f553582a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f553583b.hashCode()) * 31) + this.f553584c.hashCode()) * 31;
        if (this.f553585d == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f553586e;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "TodoChatItem(isChatItemShow=" + this.f553582a + ", chatMsgStr=" + this.f553583b + ", chatId=" + this.f553584c + ", chatIsThread=" + this.f553585d + ", position=" + this.f553586e + ')';
    }

    public a(boolean r100, String r101, String r102, boolean r103, int r104) {
        Intrinsics.checkNotNullParameter(r101, "chatMsgStr");
        Intrinsics.checkNotNullParameter(r102, "chatId");
        this.f553582a = r100;
        this.f553583b = r101;
        this.f553584c = r102;
        this.f553585d = r103;
        this.f553586e = r104;
    }
}
