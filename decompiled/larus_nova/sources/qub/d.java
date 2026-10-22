package qub;

import android.content.Context;
import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface d extends IOfficeSDKProtocol {

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f534854a = null;

        static {
            f534854a = new a();
        }

        public a() {
        }

        @Override // qub.d
        public final void t0(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        }
    }

    void t0(Context r100);
}
