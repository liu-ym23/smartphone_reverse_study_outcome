package gd4;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public interface a {

    /* JADX INFO: renamed from: gd4.a$a, reason: collision with other inner class name */
    public static final class C6010a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f480934a;

        @Override // gd4.a
        public Context getContext() {
            return this.f480934a;
        }

        public C6010a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f480934a = r100;
        }
    }

    Context getContext();
}
