package qub;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface h extends IOfficeSDKProtocol {

    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f534856a = null;

        static {
            f534856a = new a();
        }

        public a() {
        }

        @Override // qub.h
        public final void u(Context r100, rub.e r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "config");
        }
    }

    void u(Context r100, rub.e r101);
}
