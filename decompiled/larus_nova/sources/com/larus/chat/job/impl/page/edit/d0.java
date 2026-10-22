package com.larus.chat.job.impl.page.edit;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class d0 {

    public static final class a extends d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f325240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f325241b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f325240a, r101.f325240a) == true) goto L12;
            return false;
        L12:
            if (this.f325241b == r101.f325241b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f325240a.hashCode() * 31;
            if (this.f325241b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Custom(input=" + this.f325240a + ", isLoading=" + this.f325241b + ')';
        }

        public a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "input");
            this.f325240a = r100;
            this.f325241b = r101;
        }
    }

    public static final class b extends d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<ChatJobEditWeekday> f325242a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325242a, ((b) r100).f325242a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325242a.hashCode();
        }

        public final String toString() {
            return "Weekly(selectedWeekdays=" + this.f325242a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Set<? extends ChatJobEditWeekday> r100) {
            Intrinsics.checkNotNullParameter(r100, "selectedWeekdays");
            this.f325242a = r100;
        }
    }

    public d0() {
    }
}
