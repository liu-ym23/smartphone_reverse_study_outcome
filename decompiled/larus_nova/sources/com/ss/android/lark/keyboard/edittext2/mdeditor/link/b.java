package com.ss.android.lark.keyboard.edittext2.mdeditor.link;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v7b.n;

/* JADX INFO: loaded from: classes36.dex */
public interface b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f429191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f429192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f429193c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f429191a, r101.f429191a) == true) goto L12;
            return false;
        L12:
            if (this.f429192b == r101.f429192b) goto L15;
            return false;
        L15:
            if (this.f429193c == r101.f429193c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f429191a.hashCode() * 31) + this.f429192b) * 31) + this.f429193c;
        }

        public final String toString() {
            return "ParsedLink(link=" + this.f429191a + ", start=" + this.f429192b + ", end=" + this.f429193c + ')';
        }

        public a(n r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "link");
            this.f429191a = r100;
            this.f429192b = r101;
            this.f429193c = r102;
        }
    }

    List<a> a(int r100, int r101, CharSequence r102);
}
