package com.larus.dora.impl.device.settings.gesture.options;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoBehaviors;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface m {

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334474a = null;

        static {
            f334474a = new a();
        }

        public a() {
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
            return 37259595;
        }

        public final String toString() {
            return CancelRetainContactInfoBehaviors.ClosePage;
        }
    }

    public static final class b implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f334475a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f334475a == ((b) r100).f334475a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334475a;
        }

        public final String toString() {
            return "SetGestureOptionFailed(toastResId=" + this.f334475a + ')';
        }

        public b() {
            this.f334475a = R.string.larus_dora_onboarding_button_setting_failed_cn;
        }
    }

    public static final class c implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f334476a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f334476a, ((c) r100).f334476a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f334476a.hashCode();
        }

        public final String toString() {
            return "ShowQuickControlGuideDialog(dialog=" + this.f334476a + ')';
        }

        public c(p r100) {
            Intrinsics.checkNotNullParameter(r100, "dialog");
            this.f334476a = r100;
        }
    }
}
