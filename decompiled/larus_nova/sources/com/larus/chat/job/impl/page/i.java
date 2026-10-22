package com.larus.chat.job.impl.page;

import com.larus.im.bean.job.AIJob;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AIJob f325375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f325376b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f325375a, r101.f325375a) == true) goto L12;
            return false;
        L12:
            if (this.f325376b == r101.f325376b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f325375a.hashCode() * 31;
            if (this.f325376b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Job(job=" + this.f325375a + ", isRecommend=" + this.f325376b + ')';
        }

        public a(AIJob r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "job");
            this.f325375a = r100;
            this.f325376b = r101;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f325377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f325378b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f325377a, r101.f325377a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f325378b, r101.f325378b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f325377a.hashCode() * 31) + this.f325378b.hashCode();
        }

        public final String toString() {
            return "Section(key=" + this.f325377a + ", title=" + this.f325378b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "title");
            this.f325377a = r100;
            this.f325378b = r101;
        }
    }

    public i() {
    }
}
