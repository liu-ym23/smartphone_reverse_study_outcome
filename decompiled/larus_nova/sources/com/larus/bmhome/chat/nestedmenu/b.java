package com.larus.bmhome.chat.nestedmenu;

import com.larus.bmhome.actionbar.model.ModelItemIdentity;
import com.larus.bmhome.actionbar.model.b2;
import com.larus.bmhome.actionbar.model.t0;
import com.larus.bmhome.actionbar.model.v1;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import di8.f0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C4065b f308229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f308230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f308231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f308232d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t0 f308233a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f308233a, ((a) r100).f308233a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f308233a.hashCode();
        }

        public final String toString() {
            return "ModePayload(sourceItem=" + this.f308233a + ')';
        }

        public a(t0 r100) {
            Intrinsics.checkNotNullParameter(r100, "sourceItem");
            this.f308233a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.nestedmenu.b$b, reason: collision with other inner class name */
    public static final class C4065b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b2 f308234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ModelItemIdentity f308235b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4065b) == true) goto L8;
            return false;
        L8:
            C4065b r101 = (C4065b) r100;
            if (Intrinsics.areEqual(this.f308234a, r101.f308234a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f308235b, r101.f308235b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f308234a.hashCode() * 31) + this.f308235b.hashCode();
        }

        public final String toString() {
            return "ModelPayload(sourceItem=" + this.f308234a + ", identity=" + this.f308235b + ')';
        }

        public C4065b(b2 r100, ModelItemIdentity r101) {
            Intrinsics.checkNotNullParameter(r100, "sourceItem");
            Intrinsics.checkNotNullParameter(r101, DownloadHelper.IDENTITY);
            this.f308234a = r100;
            this.f308235b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b2 f308236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ModelItemIdentity f308237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final v1 f308238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f308239d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f308236a, r101.f308236a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f308237b, r101.f308237b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f308238c, r101.f308238c) == true) goto L18;
            return false;
        L18:
            if (this.f308239d == r101.f308239d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f308236a.hashCode() * 31) + this.f308237b.hashCode()) * 31) + this.f308238c.hashCode()) * 31) + this.f308239d;
        }

        public final String toString() {
            return "ReasoningEffortPayload(sourceModelItem=" + this.f308236a + ", modelIdentity=" + this.f308237b + ", option=" + this.f308238c + ", level=" + this.f308239d + ')';
        }

        public c(b2 r100, ModelItemIdentity r101, v1 r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "sourceModelItem");
            Intrinsics.checkNotNullParameter(r101, "modelIdentity");
            Intrinsics.checkNotNullParameter(r102, "option");
            this.f308236a = r100;
            this.f308237b = r101;
            this.f308238c = r102;
            this.f308239d = r103;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f308229a, r101.f308229a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f308230b, r101.f308230b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f308231c, r101.f308231c) == true) goto L18;
        return false;
    L18:
        if (this.f308232d == r101.f308232d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        C4065b r100 = this.f308229a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c r104 = this.f308230b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.f308231c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        int r108 = (r106 + r101) * 31;
        if (this.f308232d == false) goto L17;
        int r109 = 1231;
    L19:
        return r108 + r109;
    L17:
        r109 = 1237;
        goto L19
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "NestedMenuActionBarPayload(modelPayload=" + this.f308229a + ", reasoningEffortPayload=" + this.f308230b + ", modePayload=" + this.f308231c + ", isFolded=" + this.f308232d + ')';
    }

    public /* synthetic */ b(C4065b r100, c r101, a r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102, false);
    }

    public b(C4065b r100, c r101, a r102, boolean r103) {
        this.f308229a = r100;
        this.f308230b = r101;
        this.f308231c = r102;
        this.f308232d = r103;
    }
}
