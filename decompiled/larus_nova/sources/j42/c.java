package j42;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f497346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f497347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f497348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f497349d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f497350e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f497351f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Long f497352g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (this.f497346a == r101.f497346a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f497347b, r101.f497347b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f497348c, r101.f497348c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f497349d, r101.f497349d) == true) goto L14;
        return false;
    L14:
        if (this.f497350e == r101.f497350e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f497351f, r101.f497351f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f497352g, r101.f497352g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f497346a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        String r102 = this.f497347b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f497348c;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        String r109 = this.f497349d;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        long r111 = this.f497350e;
        int r112 = (((r108 + r110) * 31) + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        String r113 = this.f497351f;
        if (r113 == null) goto L17;
        int r114 = r113.hashCode();
    L18:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.f497352g;
        if (r116 == null) goto L22;
        r103 = r116.hashCode();
    L22:
        return r115 + r103;
    L17:
        r114 = 0;
        goto L18
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "PinAnswerData(questionMsgId=" + this.f497346a + ", question=" + this.f497347b + ", questionerId=" + this.f497348c + ", questionerNickname=" + this.f497349d + ", answerMsgId=" + this.f497350e + ", answer=" + this.f497351f + ", answerId=" + this.f497352g + ")";
    }

    public c(long r100, String r101, String r102, String r103, long r104, String r105, Long r110) {
        Intrinsics.checkNotNullParameter(r101, com.bytedance.android.ec.core.event.a.VALUE_QUESTION);
        Intrinsics.checkNotNullParameter(r102, "questionerId");
        Intrinsics.checkNotNullParameter(r103, "questionerNickname");
        Intrinsics.checkNotNullParameter(r105, "answer");
        this.f497346a = r100;
        this.f497347b = r101;
        this.f497348c = r102;
        this.f497349d = r103;
        this.f497350e = r104;
        this.f497351f = r105;
        this.f497352g = r110;
    }
}
