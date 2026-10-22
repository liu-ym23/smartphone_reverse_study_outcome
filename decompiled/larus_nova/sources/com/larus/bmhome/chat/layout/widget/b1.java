package com.larus.bmhome.chat.layout.widget;

import androidx.fragment.app.Fragment;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f304964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f304965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f304966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f304967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f304968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f304969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f304970g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f304971h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r101 = (b1) r100;
        if (Intrinsics.areEqual(this.f304964a, r101.f304964a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f304965b, r101.f304965b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f304966c, r101.f304966c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f304967d, r101.f304967d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f304968e, r101.f304968e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f304969f, r101.f304969f) == true) goto L27;
        return false;
    L27:
        if (this.f304970g == r101.f304970g) goto L30;
        return false;
    L30:
        if (this.f304971h == r101.f304971h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f304964a.hashCode() * 31;
        String r101 = this.f304965b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f304966c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f304967d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f304968e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Fragment r114 = this.f304969f;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        int r115 = (((r113 + r102) * 31) + this.f304970g) * 31;
        if (this.f304971h == false) goto L25;
        int r116 = 1231;
    L27:
        return r115 + r116;
    L25:
        r116 = 1237;
        goto L27
    L17:
        r112 = r111.hashCode();
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
        return "RecycleData(msgId=" + this.f304964a + ", senderId=" + this.f304965b + ", convId=" + this.f304966c + ", sectionId=" + this.f304967d + ", replyId=" + this.f304968e + ", hostFragment=" + this.f304969f + ", layoutPosition=" + this.f304970g + ", enableRecycle=" + this.f304971h + ')';
    }

    public b1(String r100, String r101, String r102, String r103, String r104, Fragment r105, int r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.MSGID);
        this.f304964a = r100;
        this.f304965b = r101;
        this.f304966c = r102;
        this.f304967d = r103;
        this.f304968e = r104;
        this.f304969f = r105;
        this.f304970g = r106;
        this.f304971h = r107;
    }
}
