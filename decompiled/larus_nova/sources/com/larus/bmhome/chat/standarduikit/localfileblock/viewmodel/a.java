package com.larus.bmhome.chat.standarduikit.localfileblock.viewmodel;

import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f309486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f309487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f309488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f309489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f309490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f309491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f309492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f309493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Message f309494i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f309495j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f309486a, r101.f309486a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309487b, r101.f309487b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309488c, r101.f309488c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309489d, r101.f309489d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f309490e, r101.f309490e) == true) goto L24;
        return false;
    L24:
        if (this.f309491f == r101.f309491f) goto L27;
        return false;
    L27:
        if (this.f309492g == r101.f309492g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f309493h, r101.f309493h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f309494i, r101.f309494i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f309495j, r101.f309495j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f309486a.hashCode() * 31) + this.f309487b.hashCode()) * 31) + this.f309488c.hashCode()) * 31) + this.f309489d.hashCode()) * 31) + this.f309490e.hashCode()) * 31;
        int r101 = 1231;
        if (this.f309491f == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f309492g == true) goto L10;
        r101 = 1237;
    L10:
        int r104 = (r103 + r101) * 31;
        Integer r105 = this.f309493h;
        int r106 = 0;
        if (r105 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r104 + r107) * 31;
        Message r109 = this.f309494i;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f309495j;
        if (r112 == null) goto L23;
        r106 = r112.hashCode();
    L23:
        return r111 + r106;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r105.hashCode();
        goto L14
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "LocalFileCardVMData(darkIcon=" + this.f309486a + ", lightIcon=" + this.f309487b + ", fileName=" + this.f309488c + ", fileType=" + this.f309489d + ", path=" + this.f309490e + ", showFileType=" + this.f309491f + ", showPlayAudioButton=" + this.f309492g + ", rootBackgroundRes=" + this.f309493h + ", message=" + this.f309494i + ", conversationId=" + this.f309495j + ')';
    }

    public a(String r100, String r101, String r102, String r103, String r104, boolean r105, Integer r106, Message r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "darkIcon");
        Intrinsics.checkNotNullParameter(r101, "lightIcon");
        Intrinsics.checkNotNullParameter(r102, "fileName");
        Intrinsics.checkNotNullParameter(r103, "fileType");
        Intrinsics.checkNotNullParameter(r104, "path");
        this.f309486a = r100;
        this.f309487b = r101;
        this.f309488c = r102;
        this.f309489d = r103;
        this.f309490e = r104;
        this.f309491f = false;
        this.f309492g = r105;
        this.f309493h = r106;
        this.f309494i = r107;
        this.f309495j = r110;
    }
}
