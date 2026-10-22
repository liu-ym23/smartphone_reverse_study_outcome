package com.larus.bmhome.music.edit;

import com.larus.im.bean.message.block.MusicCreationContent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f312821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f312822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MusicCreationContent f312823c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f312821a, r101.f312821a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f312822b, r101.f312822b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f312823c, r101.f312823c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f312821a.hashCode() * 31;
        String r101 = this.f312822b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        MusicCreationContent r105 = this.f312823c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MusicEditInfo(messageId=" + this.f312821a + ", creationId=" + this.f312822b + ", musicContent=" + this.f312823c + ')';
    }

    public /* synthetic */ j(String r100, MusicCreationContent r101) {
        this(r100, "", r101);
    }

    public j(String r100, String r101, MusicCreationContent r102) {
        Intrinsics.checkNotNullParameter(r100, "messageId");
        this.f312821a = r100;
        this.f312822b = r101;
        this.f312823c = r102;
    }
}
