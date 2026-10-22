package com.ss.android.lark.myai.chat.keyboardtop;

import android.text.SpannableStringBuilder;
import com.huawei.hms.support.feature.result.CommonConstant;
import cya.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends h {

    /* JADX INFO: renamed from: com.ss.android.lark.myai.chat.keyboardtop.a$a, reason: collision with other inner class name */
    public static final class C5144a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f432841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f432842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f432843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f432844d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f432845e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f432846f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final CharSequence f432847g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f432848h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f432841a, r101.f432841a) == true) goto L12;
            return false;
        L12:
            if (this.f432842b == r101.f432842b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f432843c, r101.f432843c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f432844d, r101.f432844d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f432845e, r101.f432845e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f432846f, r101.f432846f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f432847g, r101.f432847g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f432848h, r101.f432848h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f432841a.hashCode() * 31;
            if (this.f432842b == false) goto L5;
            int r101 = 1231;
        L7:
            return ((((((((((((r100 + r101) * 31) + this.f432843c.hashCode()) * 31) + this.f432844d.hashCode()) * 31) + this.f432845e.hashCode()) * 31) + this.f432846f.hashCode()) * 31) + this.f432847g.hashCode()) * 31) + this.f432848h.hashCode();
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "QuickActionParamState(id=" + this.f432841a + ", needUserConfirm=" + this.f432842b + ", name=" + this.f432843c + ", displayName=" + this.f432844d + ", description=" + this.f432845e + ", displayPlaceHolder=" + this.f432846f + ", userInputParamValue=" + this.f432847g + ", defaultValue=" + this.f432848h + ')';
        }

        public b(String r100, String r101, String r102, String r103, String r104, CharSequence r105, String r106) {
            Intrinsics.checkNotNullParameter(r100, "id");
            Intrinsics.checkNotNullParameter(r101, "name");
            Intrinsics.checkNotNullParameter(r102, CommonConstant.KEY_DISPLAY_NAME);
            Intrinsics.checkNotNullParameter(r103, "description");
            Intrinsics.checkNotNullParameter(r104, "displayPlaceHolder");
            Intrinsics.checkNotNullParameter(r105, "userInputParamValue");
            Intrinsics.checkNotNullParameter(r106, "defaultValue");
            this.f432841a = r100;
            this.f432842b = false;
            this.f432843c = r101;
            this.f432844d = r102;
            this.f432845e = r103;
            this.f432846f = r104;
            this.f432847g = r105;
            this.f432848h = r106;
        }
    }

    static {
    }

    @Override // cya.h
    public final int a() {
        return 0;
    }

    public final void update(SpannableStringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "currentEditContent");
        com.ss.android.lark.myai.chat.quickactions.b.a(r100);
        throw null;
    }
}
