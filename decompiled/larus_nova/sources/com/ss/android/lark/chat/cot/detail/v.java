package com.ss.android.lark.chat.cot.detail;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class v {

    public static final class a extends v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f415011a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f415012b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f415011a, r101.f415011a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f415012b, r101.f415012b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f415011a.hashCode() * 31;
            String r101 = this.f415012b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Code(code=" + this.f415011a + ", language=" + this.f415012b + ')';
        }

        public a(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            this.f415011a = r100;
            this.f415012b = r101;
        }
    }

    public static final class b extends v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<w> f415013a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f415013a, ((b) r100).f415013a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f415013a.hashCode();
        }

        public final String toString() {
            return "ListArea(items=" + this.f415013a + ')';
        }

        public b(List<w> r100) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f415013a = r100;
        }
    }

    public static final class c extends v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f415014a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f415014a, ((c) r100).f415014a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f415014a.hashCode();
        }

        public final String toString() {
            return "Text(text=" + this.f415014a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f415014a = r100;
        }
    }

    public v() {
    }
}
