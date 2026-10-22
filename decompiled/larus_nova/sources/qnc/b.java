package qnc;

import android.os.Bundle;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f534129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.suite.lark.component.navroute.fragment.a<? extends com.suite.lark.component.navroute.api.b<?>, ? extends Object> f534130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.suite.lark.component.navroute.api.g f534131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.suite.lark.component.navroute.api.d f534132e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f534128a, r101.f534128a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f534129b, r101.f534129b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f534130c, r101.f534130c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f534131d, r101.f534131d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f534132e, r101.f534132e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f534128a.hashCode() * 31;
        Bundle r101 = this.f534129b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        com.suite.lark.component.navroute.fragment.a<? extends com.suite.lark.component.navroute.api.b<?>, ? extends Object> r105 = this.f534130c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        com.suite.lark.component.navroute.api.g r108 = this.f534131d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        com.suite.lark.component.navroute.api.d r111 = this.f534132e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        StringBuilder r100 = new StringBuilder("route='");
        r100.append(this.f534128a);
        r100.append("', options=");
        r100.append(this.f534131d);
        r100.append(", targetGraph=");
        com.suite.lark.component.navroute.api.d r101 = this.f534132e;
        if (r101 == null) goto L5;
        String r102 = r101.getClass().getSimpleName();
    L6:
        r100.append(r102);
        r100.append(", args=");
        boolean r103 = true;
        if (this.f534129b == null) goto L9;
        boolean r104 = true;
    L10:
        r100.append(r104);
        r100.append(", dynamic=");
        if (this.f534130c != null) goto L14;
        r103 = false;
    L14:
        r100.append(r103);
        r100.append(')');
        return r100.toString();
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public static b a(b r100, com.suite.lark.component.navroute.api.g r101, com.suite.lark.component.navroute.api.d r110, int r111) {
        com.suite.lark.component.navroute.fragment.a<? extends com.suite.lark.component.navroute.api.b<?>, ? extends Object> r102 = null;
        if ((r111 & 1) == 0) goto L5;
        String r103 = r100.f534128a;
    L7:
        if ((r111 & 2) == 0) goto L9;
        Bundle r104 = r100.f534129b;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = r100.f534130c;
    L13:
        com.suite.lark.component.navroute.fragment.a<? extends com.suite.lark.component.navroute.api.b<?>, ? extends Object> r105 = r102;
        if ((r111 & 8) == 0) goto L16;
        r101 = r100.f534131d;
    L16:
        com.suite.lark.component.navroute.api.g r106 = r101;
        if ((r111 & 16) == 0) goto L19;
        r110 = r100.f534132e;
    L19:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, CloudControlInf.ROUTE);
        return new b(r103, r104, r105, r106, r110);
    L9:
        r104 = null;
        goto L11
    L5:
        r103 = null;
        goto L7
    }

    public b(String r100, Bundle r101, com.suite.lark.component.navroute.fragment.a<? extends com.suite.lark.component.navroute.api.b<?>, ? extends Object> r102, com.suite.lark.component.navroute.api.g r103, com.suite.lark.component.navroute.api.d r104) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        this.f534128a = r100;
        this.f534129b = r101;
        this.f534130c = r102;
        this.f534131d = r103;
        this.f534132e = r104;
    }

    public /* synthetic */ b(String r100, Bundle r110, com.suite.lark.component.navroute.fragment.c r111, com.suite.lark.component.navroute.api.g r112, com.suite.lark.component.navroute.api.d r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        Bundle r101 = null;
    L7:
        if ((r114 & 4) == 0) goto L9;
        com.suite.lark.component.navroute.fragment.c r102 = null;
    L11:
        if ((r114 & 8) == 0) goto L13;
        com.suite.lark.component.navroute.api.g r103 = null;
    L15:
        if ((r114 & 16) == 0) goto L17;
        com.suite.lark.component.navroute.api.d r104 = null;
    L18:
        this(r100, r101, r102, r103, r104);
        return;
    L17:
        r104 = r113;
        goto L18
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
