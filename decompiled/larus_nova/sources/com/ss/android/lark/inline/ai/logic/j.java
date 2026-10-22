package com.ss.android.lark.inline.ai.logic;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public interface j {

    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f427308a;

        public final String toString() {
            return "NormalText(text=" + this.f427308a + ')';
        }

        public final int hashCode() {
            return this.f427308a.hashCode();
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f427308a = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.logic.UserInputText.NormalText");
            if (Intrinsics.areEqual(this.f427308a, ((a) r100).f427308a) == true) goto L15;
            return false;
        L15:
            return true;
        L8:
            r101 = null;
            goto L10
        }
    }

    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f427309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<a> f427310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f427311c;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f427312a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f427313b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f427314c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f427315d;

            public final String toString() {
                return "Template(key=" + this.f427312a + ", name=" + this.f427313b + ", placeHolder=" + this.f427314c + ", userInput=" + this.f427315d + ')';
            }

            public a() {
                this("", "", "", "");
            }

            public final int hashCode() {
                int r100 = ((this.f427312a.hashCode() * 31) + this.f427313b.hashCode()) * 31;
                String r101 = this.f427314c;
                if (r101 == null) goto L5;
                int r102 = r101.hashCode();
            L7:
                return ((r100 + r102) * 31) + this.f427315d.hashCode();
            L5:
                r102 = 0;
                goto L7
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if (r100 == null) goto L8;
                Class<?> r101 = r100.getClass();
            L10:
                if (Intrinsics.areEqual(a.class, r101) == true) goto L12;
                return false;
            L12:
                Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.logic.UserInputText.TemplateText.Template");
                a r102 = (a) r100;
                if (Intrinsics.areEqual(this.f427312a, r102.f427312a) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.f427313b, r102.f427313b) == true) goto L19;
                return false;
            L19:
                if (Intrinsics.areEqual(this.f427314c, r102.f427314c) == true) goto L22;
                return false;
            L22:
                if (Intrinsics.areEqual(this.f427315d, r102.f427315d) == true) goto L24;
                return false;
            L24:
                return true;
            L8:
                r101 = null;
                goto L10
            }

            public a(String r100, String r101, String r102, String r103) {
                Intrinsics.checkNotNullParameter(r100, "key");
                Intrinsics.checkNotNullParameter(r101, "name");
                Intrinsics.checkNotNullParameter(r103, "userInput");
                this.f427312a = r100;
                this.f427313b = r101;
                this.f427314c = r102;
                this.f427315d = r103;
            }
        }

        public final String toString() {
            return "TemplateText(templatePrefix=" + this.f427309a + ", templateList=" + this.f427310b + ", displayContent=" + this.f427311c + ')';
        }

        public final int hashCode() {
            return (this.f427309a.hashCode() * 31) + this.f427310b.hashCode();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.inline.ai.logic.UserInputText.TemplateText");
            b r102 = (b) r100;
            if (Intrinsics.areEqual(this.f427309a, r102.f427309a) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.f427310b, r102.f427310b) == true) goto L18;
            return false;
        L18:
            return true;
        L8:
            r101 = null;
            goto L10
        }

        public b(String r100, List<a> r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "templatePrefix");
            Intrinsics.checkNotNullParameter(r101, "templateList");
            Intrinsics.checkNotNullParameter(r102, "displayContent");
            this.f427309a = r100;
            this.f427310b = r101;
            this.f427311c = r102;
        }
    }
}
