package com.bytedance.ee.bear.office.list;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressActionContextFactory;
import com.bytedance.ee.bear.office.list.adapter.u;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<OfficeLongPressActionContextFactory> f235918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<u> f235919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<View> f235920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Document, Integer> f235921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f235922e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Boolean> f235923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<Document, OfficeSpaceItem> f235924g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f235918a, r101.f235918a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f235919b, r101.f235919b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f235920c, r101.f235920c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f235921d, r101.f235921d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f235922e, r101.f235922e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f235923f, r101.f235923f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f235924g, r101.f235924g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f235918a.hashCode() * 31) + this.f235919b.hashCode()) * 31) + this.f235920c.hashCode()) * 31) + this.f235921d.hashCode()) * 31) + this.f235922e.hashCode()) * 31) + this.f235923f.hashCode()) * 31) + this.f235924g.hashCode();
    }

    public final String toString() {
        return "OfficeLongPressActionEnvironment(contextFactoryProvider=" + this.f235918a + ", dispatchPolicyProvider=" + this.f235919b + ", anchorProvider=" + this.f235920c + ", positionProvider=" + this.f235921d + ", copyLinkEnabledProvider=" + this.f235922e + ", networkConnectedProvider=" + this.f235923f + ", itemProvider=" + this.f235924g + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function0<OfficeLongPressActionContextFactory> r100, Function0<u> r101, Function0<? extends View> r102, Function1<? super Document, Integer> r103, Function0<Boolean> r104, Function0<Boolean> r105, Function1<? super Document, OfficeSpaceItem> r106) {
        Intrinsics.checkNotNullParameter(r100, "contextFactoryProvider");
        Intrinsics.checkNotNullParameter(r101, "dispatchPolicyProvider");
        Intrinsics.checkNotNullParameter(r102, "anchorProvider");
        Intrinsics.checkNotNullParameter(r103, "positionProvider");
        Intrinsics.checkNotNullParameter(r104, "copyLinkEnabledProvider");
        Intrinsics.checkNotNullParameter(r105, "networkConnectedProvider");
        Intrinsics.checkNotNullParameter(r106, "itemProvider");
        this.f235918a = r100;
        this.f235919b = r101;
        this.f235920c = r102;
        this.f235921d = r103;
        this.f235922e = r104;
        this.f235923f = r105;
        this.f235924g = r106;
    }
}
