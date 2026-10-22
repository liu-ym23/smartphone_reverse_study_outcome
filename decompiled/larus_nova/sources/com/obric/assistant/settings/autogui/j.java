package com.obric.assistant.settings.autogui;

import com.obric.assistant.AutoGuiAppScopeConfig;
import com.obric.assistant.settings.ObricAppListMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f391931a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<com.obric.assistant.settings.b> f391932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<com.obric.assistant.settings.b> f391933b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f391932a, r101.f391932a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f391933b, r101.f391933b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f391932a.hashCode() * 31) + this.f391933b.hashCode();
        }

        public final String toString() {
            return "Result(availableApps=" + this.f391932a + ", unavailableApps=" + this.f391933b + ')';
        }

        public a(List<com.obric.assistant.settings.b> r100, List<com.obric.assistant.settings.b> r101) {
            Intrinsics.checkNotNullParameter(r100, "availableApps");
            Intrinsics.checkNotNullParameter(r101, "unavailableApps");
            this.f391932a = r100;
            this.f391933b = r101;
        }
    }

    static {
    }

    public static a a(List r110, List r210, Set r211, Set r212, Set r213, Set r214, ObricAppListMode r215, AutoGuiAppScopeConfig r216) {
        Intrinsics.checkNotNullParameter(r110, "launcherApps");
        Intrinsics.checkNotNullParameter(r211, "systemBlockedPackages");
        Intrinsics.checkNotNullParameter(r215, "cloudMode");
        Intrinsics.checkNotNullParameter(r216, "config");
        boolean r100 = true;
        if (r210 == null) goto L24;
        ArrayList r111 = new ArrayList();
        Iterator r112 = r210.iterator();
    L6:
        if (r112.hasNext() == false) goto L23;
        com.obric.assistant.settings.r r113 = (com.obric.assistant.settings.r) r112.next();
        String r114 = r113.e();
        if (r114 == null) goto L20;
        String r115 = StringsKt.trim(r114).toString();
        if (r115 == null) goto L20;
        if (r115.length() <= 0) goto L14;
        boolean r116 = true;
    L15:
        if (r116 == true) goto L18;
        r115 = null;
    L18:
        if (r115 == null) goto L20;
        Pair r117 = TuplesKt.to(r115, r113);
    L21:
        if (r117 == null) goto L6;
        r111.add(r117);
        goto L6
    L14:
        r116 = false;
    L20:
        r117 = null;
        goto L21
    L23:
        Map r118 = MapsKt.toMap(r111);
    L25:
        if (r118 != null) goto L28;
        r118 = MapsKt.emptyMap();
    L28:
        if (r215 != ObricAppListMode.WHITE_LIST) goto L30;
        boolean r101 = true;
    L31:
        ArrayList r119 = new ArrayList();
        ArrayList r120 = new ArrayList();
        Iterator r102 = r110.iterator();
    L33:
        if (r102.hasNext() == false) goto L93;
        com.obric.assistant.settings.b r121 = (com.obric.assistant.settings.b) r102.next();
        com.obric.assistant.settings.r r122 = (com.obric.assistant.settings.r) r118.get(r121.f391987a);
        if (r216.getEnableSaepRestrictedPackages() == false) goto L44;
        if (r212 != null) goto L38;
    L40:
        boolean r123 = false;
    L41:
        if (r123 == false) goto L44;
        com.obric.assistant.settings.b r103 = com.obric.assistant.settings.b.a(r121, null, 0, 63);
    L89:
        if (r103 == null) goto L90;
        r120.add(r103);
        goto L33
    L90:
        r119.add(r121);
        goto L33
    L38:
        if (r212.contains(r121.f391987a) != r100) goto L40;
        r123 = true;
    L44:
        if (r216.getEnableSaepRestrictedPackages() == false) goto L52;
        if (r213 != null) goto L47;
    L49:
        boolean r124 = false;
    L50:
        if (r124 == false) goto L52;
    L88:
        r103 = null;
        goto L89
    L47:
        if (r213.contains(r121.f391987a) != r100) goto L49;
        r124 = true;
    L52:
        if (r122 == null) goto L79;
        List<String> r104 = r122.c();
        if (r104 == null) goto L72;
        ArrayList r125 = new ArrayList();
        Iterator<T> r105 = r104.iterator();
    L57:
        if (r105.hasNext() == false) goto L73;
        String r126 = (String) r105.next();
        if (r126 == null) goto L68;
        String r127 = StringsKt.trim(r126).toString();
        if (r127 == null) goto L68;
        if (r127.length() <= 0) goto L65;
        boolean r128 = true;
    L66:
        if (r128 == false) goto L68;
        String r106 = r127;
    L69:
        if (r106 == null) goto L57;
        r125.add(r106);
        goto L57
    L65:
        r128 = false;
    L68:
        r106 = null;
    L73:
        Integer r107 = r122.d();
        if (r107 == null) goto L76;
        int r108 = r107.intValue();
    L77:
        r103 = com.obric.assistant.settings.b.a(r121, r125, r108, 55);
    L81:
        r100 = true;
        goto L89
    L76:
        r108 = 0;
        goto L77
    L72:
        r125 = null;
        goto L73
    L79:
        if (r211.contains(r121.f391987a) == false) goto L82;
        r103 = com.obric.assistant.settings.b.a(r121, null, 2, 63);
        goto L81
    L82:
        if (r101 == false) goto L87;
        if (r214 != null) goto L85;
    L86:
        r100 = true;
        r103 = com.obric.assistant.settings.b.a(r121, null, 1, 63);
        goto L89
    L85:
        if (r214.contains(r121.f391987a) == false) goto L86;
    L87:
        r100 = true;
        goto L88
    L93:
        return new a(r119, r120);
    L30:
        r101 = false;
        goto L31
    L24:
        r118 = null;
        goto L25
    }
}
