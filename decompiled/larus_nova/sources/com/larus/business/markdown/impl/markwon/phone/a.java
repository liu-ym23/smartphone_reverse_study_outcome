package com.larus.business.markdown.impl.markwon.phone;

import androidx.autofill.HintConstants;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f320709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Pattern f320710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Pattern f320711c;

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.markwon.phone.a$a, reason: collision with other inner class name */
    public static final class C4144a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f320712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f320713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f320714c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4144a) == true) goto L8;
            return false;
        L8:
            C4144a r101 = (C4144a) r100;
            if (this.f320712a == r101.f320712a) goto L12;
            return false;
        L12:
            if (this.f320713b == r101.f320713b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f320714c, r101.f320714c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f320712a * 31) + this.f320713b) * 31) + this.f320714c.hashCode();
        }

        public final String toString() {
            return "PhoneInfo(start=" + this.f320712a + ", end=" + this.f320713b + ", phoneNumber=" + this.f320714c + ')';
        }

        public C4144a(int r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, HintConstants.AUTOFILL_HINT_PHONE_NUMBER);
            this.f320712a = r100;
            this.f320713b = r101;
            this.f320714c = r102;
        }
    }

    static {
        f320709a = new a();
    }

    public a() {
    }
}
