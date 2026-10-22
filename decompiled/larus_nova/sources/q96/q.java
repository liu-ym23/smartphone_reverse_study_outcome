package q96;

import com.bytedance.kmp.crypto.AlgorithmId;
import com.bytedance.kmp.crypto.PaddingModeRsa;

/* JADX INFO: loaded from: classes19.dex */
public interface q extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f532126a = null;

    public static final class a extends AlgorithmId<q> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f532127b = null;

        static {
            f532127b = new a();
        }

        public a() {
            super(com.alipay.sdk.m.n.d.f25615a);
        }
    }

    static {
        f532126a = a.f532127b;
    }

    byte[] a(byte[] r100, r96.g r101);

    void c(PaddingModeRsa r100);
}
