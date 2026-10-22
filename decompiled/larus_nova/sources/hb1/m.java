package hb1;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f484480a = 0;

    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f484481a;

        public final Context getContext() {
            return this.f484481a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f484481a = r100;
        }

        @Override // hb1.j
        public final i<rh0.a> a(i<rh0.a> r100) {
            return new hb1.a(this.f484481a, r100);
        }
    }

    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f484482a;

        public final Context getContext() {
            return this.f484482a;
        }

        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f484482a = r100;
        }

        @Override // hb1.j
        public final i<rh0.a> a(i<rh0.a> r100) {
            return new e(this.f484482a, r100);
        }
    }

    static {
    }
}
