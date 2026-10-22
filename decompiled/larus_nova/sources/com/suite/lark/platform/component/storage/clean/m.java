package com.suite.lark.platform.component.storage.clean;

import com.suite.lark.platform.component.storage.clean.f;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface m<T extends f> {

    public static final class a {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int f460609h = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f460610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f460611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f460612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<String> f460613d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<String> f460614e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f460615f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f460616g;

        /* JADX INFO: renamed from: com.suite.lark.platform.component.storage.clean.m$a$a, reason: collision with other inner class name */
        public static final class C5527a {
        }

        static {
        }

        public a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f460610a == r101.f460610a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f460611b, r101.f460611b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f460612c, r101.f460612c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f460613d, r101.f460613d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f460614e, r101.f460614e) == true) goto L24;
            return false;
        L24:
            if (this.f460615f == r101.f460615f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f460616g, r101.f460616g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            if (this.f460610a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            i r102 = this.f460611b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            String r106 = this.f460612c;
            if (r106 != null) goto L13;
            int r107 = 0;
        L14:
            int r108 = (((((r105 + r107) * 31) + this.f460613d.hashCode()) * 31) + this.f460614e.hashCode()) * 31;
            long r109 = this.f460615f;
            int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
            String r111 = this.f460616g;
            if (r111 == null) goto L19;
            r103 = r111.hashCode();
        L19:
            return r110 + r103;
        L13:
            r107 = r106.hashCode();
            goto L14
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "EraserResult(success=" + this.f460610a + ", code=" + this.f460611b + ", message=" + this.f460612c + ", successList=" + this.f460613d + ", errors=" + this.f460614e + ", cleanSize=" + this.f460615f + ", cleanFailedPath=" + this.f460616g + ')';
        }

        public a(boolean r100, i r101, String r102, long r103, String r110, int r111) {
            if ((r111 & 2) == 0) goto L6;
            r101 = i.f460606a;
        L6:
            if ((r111 & 4) == 0) goto L9;
            r102 = "";
        L9:
            if ((r111 & 8) == 0) goto L11;
            List<String> r104 = CollectionsKt.emptyList();
        L13:
            if ((r111 & 16) == 0) goto L15;
            List<String> r105 = CollectionsKt.emptyList();
        L17:
            if ((r111 & 32) == 0) goto L20;
            r103 = 0;
        L20:
            if ((r111 & 64) == 0) goto L22;
            r110 = null;
        L22:
            Intrinsics.checkNotNullParameter(r104, "successList");
            Intrinsics.checkNotNullParameter(r105, "errors");
            this.f460610a = r100;
            this.f460611b = r101;
            this.f460612c = r102;
            this.f460613d = r104;
            this.f460614e = r105;
            this.f460615f = r103;
            this.f460616g = r110;
            return;
        L15:
            r105 = null;
            goto L17
        L11:
            r104 = null;
            goto L13
        }
    }

    Class<T> a();
}
