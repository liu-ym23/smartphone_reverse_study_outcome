package qub;

import androidx.fragment.app.FragmentManager;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface e extends IOfficeSDKProtocol {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f534855a = null;

        static {
            f534855a = new a();
        }

        public a() {
        }

        @Override // qub.e
        public final void w(FragmentManager r100, rub.d r101) {
            Intrinsics.checkNotNullParameter(r100, "fragmentManager");
            Intrinsics.checkNotNullParameter(r101, "config");
        }

        @Override // qub.e
        public final void T(FragmentManager r100) {
            Intrinsics.checkNotNullParameter(r100, "fragmentManager");
            Intrinsics.checkNotNullParameter("MmStandaloneAIInterpretationLanguagePanel", "id");
        }

        @Override // qub.e
        public final void m0(FragmentManager r100) {
            Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        }
    }

    void T(FragmentManager r100);

    void m0(FragmentManager r100);

    void w(FragmentManager r100, rub.d r101);
}
