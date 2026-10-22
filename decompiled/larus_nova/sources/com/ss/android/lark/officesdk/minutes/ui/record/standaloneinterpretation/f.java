package com.ss.android.lark.officesdk.minutes.ui.record.standaloneinterpretation;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoBehaviors;
import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.vm.k;

/* JADX INFO: loaded from: classes37.dex */
public abstract class f implements k {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f436764a = null;

        static {
            f436764a = new a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return 262121608;
        }

        public final String toString() {
            return CancelRetainContactInfoBehaviors.ClosePage;
        }

        public a() {
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f436765a = null;

        static {
            f436765a = new b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return 459732080;
        }

        public final String toString() {
            return "ShowLanguagePanel";
        }

        public b() {
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f436766a = null;

        static {
            f436766a = new c();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return 573477803;
        }

        public final String toString() {
            return "ShowSettingsFailedToast";
        }

        public c() {
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f436767a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f436767a == ((d) r100).f436767a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f436767a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "ShowSpeakerToast(soundOn=" + this.f436767a + ')';
        }

        public d(boolean r100) {
            this.f436767a = r100;
        }
    }

    public f() {
    }
}
