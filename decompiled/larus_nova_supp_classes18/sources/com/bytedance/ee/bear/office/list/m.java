package com.bytedance.ee.bear.office.list;

import android.view.View;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceItem;
import com.bytedance.ee.bear.office.list.adapter.OfficeLongPressActionContextFactory;
import com.bytedance.ee.bear.office.list.adapter.u;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m {
    public final Function0<OfficeLongPressActionContextFactory> a;
    public final Function0<u> b;
    public final Function0<View> c;
    public final Function1<Document, Integer> d;
    public final Function0<Boolean> e;
    public final Function0<Boolean> f;
    public final Function1<Document, OfficeSpaceItem> g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m) == true) goto L8;
        return false;
    L8:
        m r6 = (m) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode();
    }

    public final String toString() {
        return "OfficeLongPressActionEnvironment(contextFactoryProvider=" + this.a + ", dispatchPolicyProvider=" + this.b + ", anchorProvider=" + this.c + ", positionProvider=" + this.d + ", copyLinkEnabledProvider=" + this.e + ", networkConnectedProvider=" + this.f + ", itemProvider=" + this.g + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(Function0<OfficeLongPressActionContextFactory> r2, Function0<u> r3, Function0<? extends View> r4, Function1<? super Document, Integer> r5, Function0<Boolean> r6, Function0<Boolean> r7, Function1<? super Document, OfficeSpaceItem> r8) {
        Intrinsics.checkNotNullParameter(r2, "contextFactoryProvider");
        Intrinsics.checkNotNullParameter(r3, "dispatchPolicyProvider");
        Intrinsics.checkNotNullParameter(r4, "anchorProvider");
        Intrinsics.checkNotNullParameter(r5, "positionProvider");
        Intrinsics.checkNotNullParameter(r6, "copyLinkEnabledProvider");
        Intrinsics.checkNotNullParameter(r7, "networkConnectedProvider");
        Intrinsics.checkNotNullParameter(r8, "itemProvider");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
