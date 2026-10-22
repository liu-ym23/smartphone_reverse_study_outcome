package ln0;

import android.content.Context;
import androidx.core.util.Preconditions;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pn0.b f509969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nn0.b f509970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final nn0.a f509971e;

    public static final class a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ int f509972g = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f509973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f509974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public pn0.b f509975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public nn0.b f509976d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public nn0.a f509977e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Context f509978f;

        /* JADX INFO: renamed from: ln0.b$a$a, reason: collision with other inner class name */
        public static final class C6714a {
        }

        static {
        }

        public final Context getContext() {
            return this.f509978f;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this.f509978f = r100;
        }
    }

    public b(a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Context r101 = (Context) Preconditions.checkNotNull(r100.getContext());
        this.f509967a = (String) Preconditions.checkNotNull(r100.f509974b);
        this.f509968b = (String) Preconditions.checkNotNull(r100.f509973a);
        this.f509969c = (pn0.b) Preconditions.checkNotNull(r100.f509975c);
        this.f509970d = (nn0.b) Preconditions.checkNotNull(r100.f509976d);
        this.f509971e = (nn0.a) Preconditions.checkNotNull(r100.f509977e);
    }
}
