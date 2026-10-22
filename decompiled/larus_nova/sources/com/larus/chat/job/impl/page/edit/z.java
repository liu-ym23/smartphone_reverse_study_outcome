package com.larus.chat.job.impl.page.edit;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class z {

    public static final class a extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f325362a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<a0> f325363b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f325362a, r101.f325362a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f325363b, r101.f325363b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f325362a.hashCode() * 31) + this.f325363b.hashCode();
        }

        public final String toString() {
            return "OptionSection(sectionKey=" + this.f325362a + ", rows=" + this.f325363b + ')';
        }

        public a(String r100, List<a0> r101) {
            Intrinsics.checkNotNullParameter(r100, "sectionKey");
            Intrinsics.checkNotNullParameter(r101, "rows");
            this.f325362a = r100;
            this.f325363b = r101;
        }
    }

    public static final class b extends z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChatJobEditTextKey f325364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f325365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f325366c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f325364a == r101.f325364a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f325365b, r101.f325365b) == true) goto L15;
            return false;
        L15:
            if (this.f325366c == r101.f325366c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f325364a.hashCode() * 31) + this.f325365b.hashCode()) * 31;
            if (this.f325366c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "TextInput(key=" + this.f325364a + ", text=" + this.f325365b + ", multiline=" + this.f325366c + ')';
        }

        public b(ChatJobEditTextKey r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f325364a = r100;
            this.f325365b = r101;
            this.f325366c = r102;
        }
    }

    public z() {
    }
}
