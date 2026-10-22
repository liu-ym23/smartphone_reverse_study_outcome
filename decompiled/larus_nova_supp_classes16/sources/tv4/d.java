package tv4;

import android.app.Dialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends tv4.a {
    public final DialogFragment e;

    public static final class a implements tv4.a.InterfaceC0299a {
        public final /* synthetic */ DialogFragment a;

        @Override // tv4.a.InterfaceC0299a
        public FragmentActivity getActivity() {
            return this.a.getActivity();
        }

        @Override // tv4.a.InterfaceC0299a
        public final Dialog getDialog() {
            return this.a.getDialog();
        }

        public a(DialogFragment r1) {
            this.a = r1;
        }
    }

    public static final class b {
    }

    static {
    }

    public d(DialogFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "dialogFragment");
        super(new a(r2));
        this.e = r2;
    }
}
