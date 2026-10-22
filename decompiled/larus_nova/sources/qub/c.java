package qub;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface c extends IOfficeSDKProtocol {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f534853a = null;

        static {
            f534853a = new a();
        }

        public a() {
        }

        @Override // qub.c
        public final void u0(Context r100, rub.b r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "config");
        }

        @Override // qub.c
        public final void B(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }
    }

    void B(Context r100);

    void u0(Context r100, rub.b r101);
}
