package com.bytedance.ee.bear.more.office;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.dto.Document;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final String a;
    public final OfficeLongPressLarkAction b;
    public final String c;
    public final FragmentActivity d;
    public final Fragment e;
    public final Document f;
    public final oj5.c g;
    public final String h;
    public final String i;
    public final boolean j;
    public final Function0<Unit> k;

    public c() {
        throw null;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((this.a.hashCode() * 31) + this.b.hashCode()) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        FragmentActivity r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Fragment r8 = this.e;
        if (r8 == null) goto L14;
        r2 = r8.hashCode();
    L14:
        int r9 = (((((((((r7 + r2) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31;
        if (this.j == false) goto L17;
        int r10 = 1231;
    L19:
        return ((r9 + r10) * 31) + this.k.hashCode();
    L17:
        r10 = 1237;
        goto L19
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeLongPressLarkActionRequest(actionId=" + this.a + ", action=" + this.b + ", refreshKey=" + this.c + ", activity=" + this.d + ", fragment=" + this.e + ", document=" + this.f + ", moreInfo=" + this.g + ", module=" + this.h + ", source=" + this.i + ", isRestrictedWikiHomePage=" + this.j + ", onOperationStarted=" + this.k + ')';
    }

    public final FragmentActivity getActivity() {
        return this.d;
    }

    public c(String r3, OfficeLongPressLarkAction r4, String r5, FragmentActivity r6, Fragment r7, Document r8, oj5.c r9, String r10, String r11, boolean r12) {
        OfficeLongPressLarkActionRequest$1 r0 = OfficeLongPressLarkActionRequest$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "actionId");
        Intrinsics.checkNotNullParameter(r4, "action");
        Intrinsics.checkNotNullParameter(r8, "document");
        Intrinsics.checkNotNullParameter(r9, "moreInfo");
        Intrinsics.checkNotNullParameter(r10, "module");
        Intrinsics.checkNotNullParameter(r11, "source");
        Intrinsics.checkNotNullParameter(r0, "onOperationStarted");
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
        this.i = r11;
        this.j = r12;
        this.k = r0;
    }
}
