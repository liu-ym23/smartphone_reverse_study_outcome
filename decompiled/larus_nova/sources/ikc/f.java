package ikc;

import com.bytedance.apm.ApmAgent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f490295a = null;

    public static final class a implements ikc.c {
        public a() {
        }

        @Override // ikc.c
        public final /* synthetic */ void a() {
        }

        @Override // ikc.c
        public final /* synthetic */ void b() {
        }

        @Override // ikc.c
        public final /* synthetic */ void c() {
        }
    }

    public static final class b implements ikc.b {
        public b() {
        }

        @Override // ikc.b
        public final void a(String r100, Map r101, Map r102, Map r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            JSONObject r105 = null;
            if (r101 != null) goto L5;
            JSONObject r106 = null;
        L6:
            if (r102 != null) goto L8;
            JSONObject r107 = null;
        L9:
            if (r103 == null) goto L12;
            r105 = new JSONObject(r103);
        L12:
            ApmAgent.monitorStatusAndEvent(r100, r104, r106, r107, r105);
            return;
        L8:
            r107 = new JSONObject(r102);
            goto L9
        L5:
            r106 = new JSONObject(r101);
            goto L6
        }
    }

    public static final class c implements d {
        public c() {
        }

        @Override // ikc.d
        public final /* synthetic */ void isLogin() {
        }

        @Override // ikc.d
        public final void sendEvent(String r100) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
        }
    }

    static {
        f490295a = new e(new a(), new b(), new c());
    }
}
