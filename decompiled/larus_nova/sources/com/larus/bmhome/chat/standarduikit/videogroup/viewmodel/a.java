package com.larus.bmhome.chat.standarduikit.videogroup.viewmodel;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import zn8.l;
import zn8.q;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f309851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<q> f309852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Message f309853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f309854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f309855e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f309851a, r101.f309851a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309852b, r101.f309852b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309853c, r101.f309853c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309854d, r101.f309854d) == true) goto L21;
        return false;
    L21:
        if (this.f309855e == r101.f309855e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f309851a.hashCode() * 31) + this.f309852b.hashCode()) * 31;
        Message r101 = this.f309853c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f309854d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (r104 + r102) * 31;
        if (this.f309855e == false) goto L13;
        int r107 = 1231;
    L15:
        return r106 + r107;
    L13:
        r107 = 1237;
        goto L15
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RelatedVideoVMData(sizeData=" + this.f309851a + ", videoDataList=" + this.f309852b + ", message=" + this.f309853c + ", cardPosition=" + this.f309854d + ", videoInfinite=" + this.f309855e + ')';
    }

    public final String a() {
        Message r100 = this.f309853c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMessageId();
    }

    public a(l r100, List<q> r101, Message r102, Integer r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "sizeData");
        Intrinsics.checkNotNullParameter(r101, "videoDataList");
        this.f309851a = r100;
        this.f309852b = r101;
        this.f309853c = r102;
        this.f309854d = r103;
        this.f309855e = r104;
    }
}
