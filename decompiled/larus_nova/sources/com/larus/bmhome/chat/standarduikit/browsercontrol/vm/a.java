package com.larus.bmhome.chat.standarduikit.browsercontrol.vm;

import com.larus.im.bean.message.block.BrowserControlUserAction;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f308946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BrowserControlUserAction f308947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f308948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f308949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f308950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f308951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f308952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Boolean> f308953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f308954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Boolean f308955j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f308946a, r101.f308946a) == true) goto L12;
        return false;
    L12:
        if (this.f308947b == r101.f308947b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f308948c, r101.f308948c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f308949d, r101.f308949d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f308950e, r101.f308950e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f308951f, r101.f308951f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f308952g, r101.f308952g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f308953h, r101.f308953h) == true) goto L33;
        return false;
    L33:
        if (this.f308954i == r101.f308954i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f308955j, r101.f308955j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((this.f308946a.hashCode() * 31) + this.f308947b.hashCode()) * 31) + this.f308948c.hashCode()) * 31) + this.f308949d.hashCode()) * 31) + this.f308950e.hashCode()) * 31) + this.f308951f.hashCode()) * 31) + this.f308952g.hashCode()) * 31;
        Function0<Boolean> r101 = this.f308953h;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.f308954i == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        Boolean r107 = this.f308955j;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BrowserControlVMData(dataIdentifier=" + this.f308946a + ", userAction=" + this.f308947b + ", toolCallId=" + this.f308948c + ", title=" + this.f308949d + ", url=" + this.f308950e + ", leftDarkIcon=" + this.f308951f + ", leftLightIcon=" + this.f308952g + ", interceptClickCard=" + this.f308953h + ", disableFoldExpandClick=" + this.f308954i + ", initialFoldState=" + this.f308955j + ')';
    }

    public a(String r100, BrowserControlUserAction r101, String r102, String r103, String r104, String r105, String r106, dj8.b r107, boolean r110, Boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "dataIdentifier");
        Intrinsics.checkNotNullParameter(r101, "userAction");
        Intrinsics.checkNotNullParameter(r102, "toolCallId");
        Intrinsics.checkNotNullParameter(r103, "title");
        Intrinsics.checkNotNullParameter(r104, "url");
        Intrinsics.checkNotNullParameter(r105, "leftDarkIcon");
        Intrinsics.checkNotNullParameter(r106, "leftLightIcon");
        this.f308946a = r100;
        this.f308947b = r101;
        this.f308948c = r102;
        this.f308949d = r103;
        this.f308950e = r104;
        this.f308951f = r105;
        this.f308952g = r106;
        this.f308953h = r107;
        this.f308954i = r110;
        this.f308955j = r111;
    }
}
