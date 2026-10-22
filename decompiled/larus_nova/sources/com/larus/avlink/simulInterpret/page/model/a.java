package com.larus.avlink.simulInterpret.page.model;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import hq9.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f294491e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f294492f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f294493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f294494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f294495c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f294496d;

    /* JADX INFO: renamed from: com.larus.avlink.simulInterpret.page.model.a$a, reason: collision with other inner class name */
    public static final class C4011a {
        public C4011a() {
        }

        public static /* synthetic */ a b(String r100) {
            return a(r100, CollectionsKt.emptyList());
        }

        public static List c(List r100) {
            Intrinsics.checkNotNullParameter(r100, "configList");
            ArrayList r101 = new ArrayList();
            LinkedHashSet r102 = new LinkedHashSet();
            a r103 = a.f294491e;
            r101.add(r103);
            r102.add(r103.f294494b);
            a r104 = a.f294492f;
            r101.add(r104);
            r102.add(r104.f294494b);
            Iterator r105 = r100.iterator();
        L4:
            if (r105.hasNext() == false) goto L21;
            z0 r106 = (z0) r105.next();
            String r107 = r106.a();
            String r108 = r106.b();
            Boolean r109 = r106.d();
            if (r109 == null) goto L8;
            boolean r110 = r109.booleanValue();
        L9:
            if (r107 == null) goto L4;
            if (r108 == null) goto L4;
            if (r102.contains(r107) == true) goto L4;
            if (r110 == false) goto L17;
            String r111 = r106.c();
            if (r111 == null) goto L19;
        L20:
            r101.add(new a(r108, r107, r111, r110));
            r102.add(r107);
        L19:
            r111 = "Listening...";
            goto L20
        L17:
            r111 = r106.c();
            if (r111 != null) goto L20;
        L8:
            r110 = false;
            goto L9
        L21:
            return r101;
        }

        public static a a(String r100, List r101) {
            Intrinsics.checkNotNullParameter(r101, "configList");
            if (Intrinsics.areEqual(r100, "zh") == false) goto L7;
            return a.f294491e;
        L7:
            if (Intrinsics.areEqual(r100, "en") == true) goto L9;
            if (r100 == null) goto L26;
            Iterator r102 = r101.iterator();
        L13:
            if (r102.hasNext() == false) goto L34;
            z0 r103 = (z0) r102.next();
            String r104 = r103.b();
            if (Intrinsics.areEqual(r103.a(), r100) == false) goto L13;
            if (r104 == null) goto L13;
            String r105 = r103.c();
            if (r105 != null) goto L20;
            r105 = "Listening...";
        L20:
            Boolean r106 = r103.d();
            if (r106 == null) goto L23;
            boolean r107 = r106.booleanValue();
        L25:
            return new a(r104, r100, r105, r107);
        L23:
            r107 = false;
            goto L25
        L34:
            return null;
        L26:
            return null;
        L9:
            return a.f294492f;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f294493a, r101.f294493a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f294494b, r101.f294494b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f294495c, r101.f294495c) == true) goto L18;
        return false;
    L18:
        if (this.f294496d == r101.f294496d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f294493a.hashCode() * 31) + this.f294494b.hashCode()) * 31) + this.f294495c.hashCode()) * 31;
        if (this.f294496d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "Language(showText=" + this.f294493a + ", code=" + this.f294494b + ", waitingText=" + this.f294495c + ", isPrimary=" + this.f294496d + ')';
    }

    static {
        new C4011a();
        AppHost.Companion r100 = AppHost.f326268a;
        f294491e = new a(r100.getApplication().getString(R.string.larus_chinese_language), "zh", (String) ea8.b.f471628a.getValue(), true);
        f294492f = new a(r100.getApplication().getString(R.string.larus_english_language), "en", "Listening...", true);
    }

    public a(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "showText");
        Intrinsics.checkNotNullParameter(r101, "code");
        Intrinsics.checkNotNullParameter(r102, "waitingText");
        this.f294493a = r100;
        this.f294494b = r101;
        this.f294495c = r102;
        this.f294496d = r103;
    }
}
