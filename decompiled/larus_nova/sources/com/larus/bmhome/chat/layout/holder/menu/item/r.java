package com.larus.bmhome.chat.layout.holder.menu.item;

import com.larus.im.bean.message.SendFile;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SendFile f303999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f304000b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (Intrinsics.areEqual(this.f303999a, r101.f303999a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f304000b, r101.f304000b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f303999a.hashCode() * 31;
        String r101 = this.f304000b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "DownloadFileSource(sendFile=" + this.f303999a + ", nestedFileIdentifier=" + this.f304000b + ')';
    }

    public r(SendFile r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "sendFile");
        this.f303999a = r100;
        this.f304000b = r101;
    }
}
