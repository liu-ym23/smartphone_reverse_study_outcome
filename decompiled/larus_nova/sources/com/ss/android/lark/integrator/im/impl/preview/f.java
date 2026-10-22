package com.ss.android.lark.integrator.im.impl.preview;

import com.ss.android.lark.export.entity.PreviewHangPoint;
import com.ss.android.lark.export.entity.UrlCardPreviewEntity;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f428016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f428017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PreviewHangPoint f428018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final UrlCardPreviewEntity f428019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<g, t6c.d> f428020e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f428016a, r101.f428016a) == true) goto L12;
            return false;
        L12:
            if (this.f428017b == r101.f428017b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f428018c, r101.f428018c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f428019d, r101.f428019d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f428016a.hashCode() * 31;
            long r101 = this.f428017b;
            return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f428018c.hashCode()) * 31) + this.f428019d.hashCode();
        }

        public final String toString() {
            return "EntityReady(previewId=" + this.f428016a + ", generation=" + this.f428017b + ", hangPoint=" + this.f428018c + ", entity=" + this.f428019d + ')';
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final UrlCardPreviewEntity a() {
            return this.f428019d;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final long b() {
            return this.f428017b;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final PreviewHangPoint c() {
            return this.f428018c;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final String d() {
            return this.f428016a;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final Map<g, t6c.d> e() {
            return this.f428020e;
        }

        public a(String r100, long r101, PreviewHangPoint r102, UrlCardPreviewEntity r103) {
            Intrinsics.checkNotNullParameter(r100, "previewId");
            Intrinsics.checkNotNullParameter(r102, "hangPoint");
            Intrinsics.checkNotNullParameter(r103, "entity");
            this.f428016a = r100;
            this.f428017b = r101;
            this.f428018c = r102;
            this.f428019d = r103;
            this.f428020e = MapsKt.emptyMap();
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f428021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f428022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PreviewHangPoint f428023c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Map<g, t6c.d> f428024d;

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final UrlCardPreviewEntity a() {
            return null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f428021a, r101.f428021a) == true) goto L12;
            return false;
        L12:
            if (this.f428022b == r101.f428022b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f428023c, r101.f428023c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f428021a.hashCode() * 31;
            long r101 = this.f428022b;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f428023c.hashCode();
        }

        public final String toString() {
            return "Pending(previewId=" + this.f428021a + ", generation=" + this.f428022b + ", hangPoint=" + this.f428023c + ')';
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final long b() {
            return this.f428022b;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final PreviewHangPoint c() {
            return this.f428023c;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final String d() {
            return this.f428021a;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final Map<g, t6c.d> e() {
            return this.f428024d;
        }

        public b(String r100, long r101, PreviewHangPoint r102) {
            Intrinsics.checkNotNullParameter(r100, "previewId");
            Intrinsics.checkNotNullParameter(r102, "hangPoint");
            this.f428021a = r100;
            this.f428022b = r101;
            this.f428023c = r102;
            this.f428024d = MapsKt.emptyMap();
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f428025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f428026b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PreviewHangPoint f428027c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final UrlCardPreviewEntity f428028d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<g, t6c.d> f428029e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f428025a, r101.f428025a) == true) goto L12;
            return false;
        L12:
            if (this.f428026b == r101.f428026b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f428027c, r101.f428027c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f428028d, r101.f428028d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f428029e, r101.f428029e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f428025a.hashCode() * 31;
            long r101 = this.f428026b;
            return ((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f428027c.hashCode()) * 31) + this.f428028d.hashCode()) * 31) + this.f428029e.hashCode();
        }

        public final String toString() {
            return "RenderReady(previewId=" + this.f428025a + ", generation=" + this.f428026b + ", hangPoint=" + this.f428027c + ", entity=" + this.f428028d + ", renders=" + this.f428029e + ')';
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final UrlCardPreviewEntity a() {
            return this.f428028d;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final long b() {
            return this.f428026b;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final PreviewHangPoint c() {
            return this.f428027c;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final String d() {
            return this.f428025a;
        }

        @Override // com.ss.android.lark.integrator.im.impl.preview.f
        public final Map<g, t6c.d> e() {
            return this.f428029e;
        }

        public c(String r100, long r101, PreviewHangPoint r102, UrlCardPreviewEntity r103, Map<g, t6c.d> r104) {
            Intrinsics.checkNotNullParameter(r100, "previewId");
            Intrinsics.checkNotNullParameter(r102, "hangPoint");
            Intrinsics.checkNotNullParameter(r103, "entity");
            Intrinsics.checkNotNullParameter(r104, "renders");
            this.f428025a = r100;
            this.f428026b = r101;
            this.f428027c = r102;
            this.f428028d = r103;
            this.f428029e = r104;
        }
    }

    public f() {
    }

    public abstract UrlCardPreviewEntity a();

    public abstract long b();

    public abstract PreviewHangPoint c();

    public abstract String d();

    public abstract Map<g, t6c.d> e();
}
