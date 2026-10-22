package com.obric.assistant.cocreationreview;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public abstract class z4 {

    public static final class a extends z4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f387820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f387821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e f387822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a5 f387823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<y4> f387824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final List<x4> f387825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f387826g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f387827h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f387820a, r101.f387820a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f387821b, r101.f387821b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f387822c, r101.f387822c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f387823d, r101.f387823d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f387824e, r101.f387824e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f387825f, r101.f387825f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f387826g, r101.f387826g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f387827h, r101.f387827h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((this.f387820a.hashCode() * 31) + this.f387821b.hashCode()) * 31) + this.f387822c.hashCode()) * 31) + this.f387823d.hashCode()) * 31) + this.f387824e.hashCode()) * 31) + this.f387825f.hashCode()) * 31;
            String r101 = this.f387826g;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f387827h;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Content(recordId=" + this.f387820a + ", pageTitle=" + this.f387821b + ", title=" + this.f387822c + ", feedback=" + this.f387823d + ", sections=" + this.f387824e + ", pages=" + this.f387825f + ", initialAnchor=" + this.f387826g + ", leadingTitleLabel=" + this.f387827h + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(String r100, String r101, e r102, a5 r103, List<? extends y4> r104, List<x4> r105, String r106, String r107) {
            Intrinsics.checkNotNullParameter(r100, "recordId");
            Intrinsics.checkNotNullParameter(r101, "pageTitle");
            Intrinsics.checkNotNullParameter(r102, "title");
            Intrinsics.checkNotNullParameter(r103, "feedback");
            Intrinsics.checkNotNullParameter(r104, "sections");
            Intrinsics.checkNotNullParameter(r105, "pages");
            this.f387820a = r100;
            this.f387821b = r101;
            this.f387822c = r102;
            this.f387823d = r103;
            this.f387824e = r104;
            this.f387825f = r105;
            this.f387826g = r106;
            this.f387827h = r107;
        }

        public /* synthetic */ a(String r110, String r111, e r112, a5 r113, List r114, List r115, String r116, int r117) {
            if ((r117 & 32) == 0) goto L5;
            List r100 = CollectionsKt.emptyList();
        L7:
            if ((r117 & 128) == 0) goto L9;
            String r118 = null;
        L10:
            this(r110, r111, r112, r113, r114, r100, null, r118);
            return;
        L9:
            r118 = r116;
            goto L10
        L5:
            r100 = r115;
            goto L7
        }
    }

    public z4() {
    }
}
