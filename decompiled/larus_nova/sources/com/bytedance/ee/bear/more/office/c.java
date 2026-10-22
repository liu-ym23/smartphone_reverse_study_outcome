package com.bytedance.ee.bear.more.office;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.list.dto.Document;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f234687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OfficeLongPressLarkAction f234688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f234689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FragmentActivity f234690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Fragment f234691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Document f234692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final oj5.c f234693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f234694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f234695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f234696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function0<Unit> f234697k;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f234687a, r101.f234687a) == true) goto L12;
        return false;
    L12:
        if (this.f234688b == r101.f234688b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f234689c, r101.f234689c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f234690d, r101.f234690d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f234691e, r101.f234691e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f234692f, r101.f234692f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f234693g, r101.f234693g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f234694h, r101.f234694h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f234695i, r101.f234695i) == true) goto L36;
        return false;
    L36:
        if (this.f234696j == r101.f234696j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f234697k, r101.f234697k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f234687a.hashCode() * 31) + this.f234688b.hashCode()) * 31;
        String r101 = this.f234689c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        FragmentActivity r105 = this.f234690d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Fragment r108 = this.f234691e;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        int r109 = (((((((((r107 + r102) * 31) + this.f234692f.hashCode()) * 31) + this.f234693g.hashCode()) * 31) + this.f234694h.hashCode()) * 31) + this.f234695i.hashCode()) * 31;
        if (this.f234696j == false) goto L17;
        int r110 = 1231;
    L19:
        return ((r109 + r110) * 31) + this.f234697k.hashCode();
    L17:
        r110 = 1237;
        goto L19
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "OfficeLongPressLarkActionRequest(actionId=" + this.f234687a + ", action=" + this.f234688b + ", refreshKey=" + this.f234689c + ", activity=" + this.f234690d + ", fragment=" + this.f234691e + ", document=" + this.f234692f + ", moreInfo=" + this.f234693g + ", module=" + this.f234694h + ", source=" + this.f234695i + ", isRestrictedWikiHomePage=" + this.f234696j + ", onOperationStarted=" + this.f234697k + ')';
    }

    public final FragmentActivity getActivity() {
        return this.f234690d;
    }

    public c(String r100, OfficeLongPressLarkAction r101, String r102, FragmentActivity r103, Fragment r104, Document r105, oj5.c r106, String r110, String r111, boolean r112) {
        OfficeLongPressLarkActionRequest$1 r107 = OfficeLongPressLarkActionRequest$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "actionId");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r105, "document");
        Intrinsics.checkNotNullParameter(r106, "moreInfo");
        Intrinsics.checkNotNullParameter(r110, EventConstant.Key.MODULE);
        Intrinsics.checkNotNullParameter(r111, "source");
        Intrinsics.checkNotNullParameter(r107, "onOperationStarted");
        this.f234687a = r100;
        this.f234688b = r101;
        this.f234689c = r102;
        this.f234690d = r103;
        this.f234691e = r104;
        this.f234692f = r105;
        this.f234693g = r106;
        this.f234694h = r110;
        this.f234695i = r111;
        this.f234696j = r112;
        this.f234697k = r107;
    }
}
