package com.ss.android.lark.biz.im.api;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes34.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f410252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f410253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteString f410254c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f410252a, r101.f410252a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410253b, r101.f410253b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f410254c, r101.f410254c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f410252a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.f410253b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ByteString r107 = this.f410254c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DoubaoForwardData(doubaoMsgId=" + this.f410252a + ", subMsgIds=" + this.f410253b + ", contentByte=" + this.f410254c + ')';
    }

    public i(List r100, ByteString r101) {
        this.f410252a = null;
        this.f410253b = r100;
        this.f410254c = r101;
    }
}
