package com.larus.navigation.api.kmp;

import com.larus.navigation.api.c;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f359668a = 0;

    /* JADX INFO: renamed from: com.larus.navigation.api.kmp.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC4425a {

        /* JADX INFO: renamed from: com.larus.navigation.api.kmp.a$a$a, reason: collision with other inner class name */
        public static final class C4426a extends AbstractC4425a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f359669a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f359670b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f359671c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final KmpInstructionActionType f359672d;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4426a) == true) goto L8;
                return false;
            L8:
                C4426a r101 = (C4426a) r100;
                if (Intrinsics.areEqual(this.f359669a, r101.f359669a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f359670b, r101.f359670b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f359671c, r101.f359671c) == true) goto L18;
                return false;
            L18:
                if (this.f359672d == r101.f359672d) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                return (((((this.f359669a.hashCode() * 31) + this.f359670b.hashCode()) * 31) + this.f359671c.hashCode()) * 31) + this.f359672d.hashCode();
            }

            public final String toString() {
                return "Arrival(title=" + this.f359669a + ", content=" + this.f359670b + ", speech=" + this.f359671c + ", iconTurnKind=" + this.f359672d + ')';
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String a() {
                return this.f359670b;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final KmpInstructionActionType b() {
                return this.f359672d;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String c() {
                return this.f359671c;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String d() {
                return this.f359669a;
            }

            public C4426a(String r100, String r101, String r102, KmpInstructionActionType r103) {
                Intrinsics.checkNotNullParameter(r100, "title");
                Intrinsics.checkNotNullParameter(r101, "content");
                Intrinsics.checkNotNullParameter(r102, "speech");
                Intrinsics.checkNotNullParameter(r103, "iconTurnKind");
                this.f359669a = r100;
                this.f359670b = r101;
                this.f359671c = r102;
                this.f359672d = r103;
            }
        }

        /* JADX INFO: renamed from: com.larus.navigation.api.kmp.a$a$b */
        public static final class b extends AbstractC4425a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f359673a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f359674b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f359675c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final KmpInstructionActionType f359676d;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f359673a, r101.f359673a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f359674b, r101.f359674b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f359675c, r101.f359675c) == true) goto L18;
                return false;
            L18:
                if (this.f359676d == r101.f359676d) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                return (((((this.f359673a.hashCode() * 31) + this.f359674b.hashCode()) * 31) + this.f359675c.hashCode()) * 31) + this.f359676d.hashCode();
            }

            public final String toString() {
                return "Override(title=" + this.f359673a + ", content=" + this.f359674b + ", speech=" + this.f359675c + ", iconTurnKind=" + this.f359676d + ')';
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String a() {
                return this.f359674b;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final KmpInstructionActionType b() {
                return this.f359676d;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String c() {
                return this.f359675c;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String d() {
                return this.f359673a;
            }

            public b(KmpInstructionActionType r100) {
                Intrinsics.checkNotNullParameter("您已偏离路线", "title");
                Intrinsics.checkNotNullParameter("", "content");
                Intrinsics.checkNotNullParameter("您已偏离路线", "speech");
                Intrinsics.checkNotNullParameter(r100, "iconTurnKind");
                this.f359673a = "您已偏离路线";
                this.f359674b = "";
                this.f359675c = "您已偏离路线";
                this.f359676d = r100;
            }
        }

        /* JADX INFO: renamed from: com.larus.navigation.api.kmp.a$a$c */
        public static final class c extends AbstractC4425a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f359677a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f359678b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f359679c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final KmpInstructionActionType f359680d;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (Intrinsics.areEqual(this.f359677a, r101.f359677a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f359678b, r101.f359678b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f359679c, r101.f359679c) == true) goto L18;
                return false;
            L18:
                if (this.f359680d == r101.f359680d) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                return (((((this.f359677a.hashCode() * 31) + this.f359678b.hashCode()) * 31) + this.f359679c.hashCode()) * 31) + this.f359680d.hashCode();
            }

            public final String toString() {
                return "Straight(title=" + this.f359677a + ", content=" + this.f359678b + ", speech=" + this.f359679c + ", iconTurnKind=" + this.f359680d + ')';
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String a() {
                return this.f359678b;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final KmpInstructionActionType b() {
                return this.f359680d;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String c() {
                return this.f359679c;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String d() {
                return this.f359677a;
            }

            public c(String r100, String r101, String r102, KmpInstructionActionType r103) {
                Intrinsics.checkNotNullParameter(r100, "title");
                Intrinsics.checkNotNullParameter(r101, "content");
                Intrinsics.checkNotNullParameter(r102, "speech");
                Intrinsics.checkNotNullParameter(r103, "iconTurnKind");
                this.f359677a = r100;
                this.f359678b = r101;
                this.f359679c = r102;
                this.f359680d = r103;
            }
        }

        /* JADX INFO: renamed from: com.larus.navigation.api.kmp.a$a$d */
        public static final class d extends AbstractC4425a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f359681a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f359682b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f359683c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final KmpInstructionActionType f359684d;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L8;
                return false;
            L8:
                d r101 = (d) r100;
                if (Intrinsics.areEqual(this.f359681a, r101.f359681a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f359682b, r101.f359682b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f359683c, r101.f359683c) == true) goto L18;
                return false;
            L18:
                if (this.f359684d == r101.f359684d) goto L20;
                return false;
            L20:
                return true;
            }

            public final int hashCode() {
                return (((((this.f359681a.hashCode() * 31) + this.f359682b.hashCode()) * 31) + this.f359683c.hashCode()) * 31) + this.f359684d.hashCode();
            }

            public final String toString() {
                return "Turn(title=" + this.f359681a + ", content=" + this.f359682b + ", speech=" + this.f359683c + ", iconTurnKind=" + this.f359684d + ')';
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String a() {
                return this.f359682b;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final KmpInstructionActionType b() {
                return this.f359684d;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String c() {
                return this.f359683c;
            }

            @Override // com.larus.navigation.api.kmp.a.AbstractC4425a
            public final String d() {
                return this.f359681a;
            }

            public d(String r100, String r101, String r102, KmpInstructionActionType r103) {
                Intrinsics.checkNotNullParameter(r100, "title");
                Intrinsics.checkNotNullParameter(r101, "content");
                Intrinsics.checkNotNullParameter(r102, "speech");
                Intrinsics.checkNotNullParameter(r103, "iconTurnKind");
                this.f359681a = r100;
                this.f359682b = r101;
                this.f359683c = r102;
                this.f359684d = r103;
            }
        }

        public AbstractC4425a() {
        }

        public abstract String a();

        public abstract KmpInstructionActionType b();

        public abstract String c();

        public abstract String d();
    }

    static {
    }

    public static String b(int r100) {
        if (r100 >= 1000) goto L7;
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        r101.append(31859);
        return r101.toString();
    L7:
        return String.format(Locale.ROOT, "%.1f公里", Arrays.copyOf(new Object[]{Double.valueOf(((double) r100) / 1000.0d)}, 1));
    }

    public static AbstractC4425a.c a(String r100, String r101, int r102, KmpInstructionActionType r103) {
        boolean r104 = false;
        if (r101.length() <= 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L8;
        String r106 = "沿".concat(r101);
    L9:
        if (r102 <= 0) goto L12;
        r100 = r100 + b(r102);
    L12:
        if (r106.length() != 0) goto L14;
        r104 = true;
    L14:
        if (r104 == false) goto L16;
        String r107 = r100;
    L18:
        return new AbstractC4425a.c(r106, r100, r107, r103);
    L16:
        r107 = r106 + r100;
        goto L18
    L8:
        r106 = "";
        goto L9
    L5:
        r105 = false;
        goto L6
    }

    public static void c(String r100, int r101, int r102, String r103, String r104, String r105, int r106, int r107, AbstractC4425a r110) {
        int r108 = c.f359656a;
        c.d("kmp_text_composer", "scene=" + r100 + " flag=" + r101 + " turnKind=" + r102 + " verb='" + r103 + "' assist='" + r104 + "' road='" + r105 + "' d2c=" + r106 + " remain=" + r107 + " → title='" + r110.d() + "' content='" + r110.a() + "' speech='" + StringsKt.take(r110.c(), 60) + '\'');
    }
}
