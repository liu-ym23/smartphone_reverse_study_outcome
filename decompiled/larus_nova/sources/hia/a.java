package hia;

import by7.e;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.im.bean.bot.SpeakerVoice;
import com.obric.audio.continuous_talk.k0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.CallbackFlowBuilder;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.i1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C6151a f485361a = null;

    /* JADX INFO: renamed from: hia.a$a, reason: collision with other inner class name */
    public static final class C6151a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C6151a f485362a = null;

        static {
            f485362a = new C6151a();
        }

        public C6151a() {
        }
    }

    public interface b {
        CallbackFlowBuilder a(long r100);

        void b();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f485363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f485364b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f485363a, r101.f485363a) == true) goto L12;
            return false;
        L12:
            if (this.f485364b == r101.f485364b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f485363a.hashCode() * 31;
            if (this.f485364b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "LLMContextInfo(params=" + this.f485363a + ", isFinish=" + this.f485364b + ')';
        }

        public c(Map<String, String> r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "params");
            this.f485363a = r100;
            this.f485364b = r101;
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: hia.a$d$a, reason: collision with other inner class name */
        public static final class C6152a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f485365a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f485366b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C6152a) == true) goto L8;
                return false;
            L8:
                C6152a r101 = (C6152a) r100;
                if (this.f485365a == r101.f485365a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f485366b, r101.f485366b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f485365a * 31) + this.f485366b.hashCode();
            }

            public final String toString() {
                return "FAILURE(errorCode=" + this.f485365a + ", errorMsg=" + this.f485366b + ')';
            }

            public C6152a(int r100, String r101) {
                Intrinsics.checkNotNullParameter(r101, "errorMsg");
                this.f485365a = r100;
                this.f485366b = r101;
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f485367a = null;

            static {
                f485367a = new b();
            }

            public b() {
            }
        }

        public d() {
        }
    }

    static {
        f485361a = C6151a.f485362a;
    }

    d I0(JSONObject r100);

    boolean a(String r100);

    boolean a0();

    void b();

    d.b c();

    d d(JSONObject r100);

    void e(k0 r100);

    d f(String r100, String r101, Integer r102, Integer r103, String r104, String r105, SpeakerVoice r106, de8.c r107, e r108, String r110, String r111, String r112, RealtimeCallParam.l r113);

    void g();

    i1<AVKitDuplexState> h();

    Flow<r58.d> i();

    boolean isActive();

    void j(boolean r100);

    boolean k();

    Flow<hia.b> s();
}
