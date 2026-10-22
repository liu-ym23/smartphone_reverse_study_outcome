package com.larus.bmhome.clarification;

import com.larus.im.bean.message.UplinkFileEntity;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f310540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f310541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f310542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<UplinkFileEntity> f310543d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f310544e;

    public i() {
        String r100 = null;
        this(r100, r100, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f310540a, r101.f310540a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f310541b, r101.f310541b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f310542c, r101.f310542c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f310543d, r101.f310543d) == true) goto L21;
        return false;
    L21:
        if (this.f310544e == r101.f310544e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f310540a.hashCode() * 31) + this.f310541b.hashCode()) * 31;
        String r101 = this.f310542c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((r100 + r102) * 31) + this.f310543d.hashCode()) * 31;
        long r104 = this.f310544e;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ClarificationAnswerDraft(selectedOptionIds=" + this.f310540a + ", inputText=" + this.f310541b + ", attachmentLocalMsgId=" + this.f310542c + ", attachments=" + this.f310543d + ", updatedAt=" + this.f310544e + ')';
    }

    public /* synthetic */ i(String r110, String r111, int r112) {
        List r100 = null;
        if ((r112 & 1) == 0) goto L5;
        List r101 = CollectionsKt.emptyList();
    L7:
        if ((r112 & 2) == 0) goto L9;
        r110 = "";
    L9:
        String r102 = r110;
        if ((r112 & 4) == 0) goto L12;
        String r103 = null;
    L14:
        if ((r112 & 8) == 0) goto L16;
        r100 = CollectionsKt.emptyList();
    L16:
        List r104 = r100;
        if ((r112 & 16) == 0) goto L19;
        long r113 = System.currentTimeMillis();
    L20:
        this(r101, r102, r103, r104, r113);
        return;
    L19:
        r113 = 0;
        goto L20
    L12:
        r103 = r111;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public i(List<String> r100, String r101, String r102, List<UplinkFileEntity> r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r101, "inputText");
        Intrinsics.checkNotNullParameter(r103, "attachments");
        this.f310540a = r100;
        this.f310541b = r101;
        this.f310542c = r102;
        this.f310543d = r103;
        this.f310544e = r104;
    }

    public static i a(i r100, List r101, String r102, String r110, List r111, long r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r101 = r100.f310540a;
    L5:
        List r103 = r101;
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.f310541b;
    L8:
        String r104 = r102;
        if ((r113 & 4) == 0) goto L11;
        r110 = r100.f310542c;
    L11:
        String r105 = r110;
        if ((r113 & 8) == 0) goto L14;
        r111 = r100.f310543d;
    L14:
        List r106 = r111;
        if ((r113 & 16) == 0) goto L17;
        r112 = r100.f310544e;
    L17:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "selectedOptionIds");
        Intrinsics.checkNotNullParameter(r104, "inputText");
        Intrinsics.checkNotNullParameter(r106, "attachments");
        return new i(r103, r104, r105, r106, r112);
    }
}
