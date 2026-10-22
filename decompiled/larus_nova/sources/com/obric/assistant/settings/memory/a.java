package com.obric.assistant.settings.memory;

import com.obric.assistant.settings.ToggleName;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.assistant.settings.memory.a$a, reason: collision with other inner class name */
    public static final class C4630a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4630a f392182a = null;

        static {
            f392182a = new C4630a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4630a) == true) goto L9;
            return false;
        L9:
            C4630a r101 = (C4630a) r100;
            return true;
        }

        public final int hashCode() {
            return 936644714;
        }

        public final String toString() {
            return "Banner";
        }

        public C4630a() {
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ToggleName f392183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f392184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f392185c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f392183a == r101.f392183a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f392184b, r101.f392184b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f392185c, r101.f392185c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f392183a.hashCode() * 31) + this.f392184b.hashCode()) * 31) + this.f392185c.hashCode();
        }

        public final String toString() {
            return "DataSourceItem(toggleName=" + this.f392183a + ", title=" + this.f392184b + ", endText=" + this.f392185c + ')';
        }

        public b(ToggleName r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "toggleName");
            Intrinsics.checkNotNullParameter(r101, "title");
            Intrinsics.checkNotNullParameter(r102, "endText");
            this.f392183a = r100;
            this.f392184b = r101;
            this.f392185c = r102;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f392186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f392187b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f392186a, r101.f392186a) == true) goto L12;
            return false;
        L12:
            if (this.f392187b == r101.f392187b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f392186a.hashCode() * 31;
            if (this.f392187b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "LocalDataSearchSwitch(title=" + this.f392186a + ", enabled=" + this.f392187b + ')';
        }

        public c(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f392186a = r100;
            this.f392187b = r101;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f392188a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f392188a, ((d) r100).f392188a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f392188a.hashCode();
        }

        public final String toString() {
            return "SectionHeader(title=" + this.f392188a + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "title");
            this.f392188a = r100;
        }
    }

    public a() {
    }
}
