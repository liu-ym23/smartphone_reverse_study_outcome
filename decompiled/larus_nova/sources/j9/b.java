package j9;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r110, View r111, String r112, String r113, JSONObject r114, JSONObject r115, JSONObject r116, JSONObject r117, int r118, int r210) {
            if ((r210 & 64) == 0) goto L5;
            JSONObject r100 = null;
        L6:
            r110.b(r111, r112, r113, r114, r115, r116, r100, r118, null);
            return;
        L5:
            r100 = r117;
            goto L6
        }
    }

    /* JADX INFO: renamed from: j9.b$b, reason: collision with other inner class name */
    public static final class C6405b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6405b f497758a = null;

        static {
            f497758a = new C6405b();
        }

        public C6405b() {
        }

        @Override // j9.b
        public final void a(View r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105, int r106) {
            Intrinsics.checkNotNullParameter(r100, "view");
        }

        @Override // j9.b
        public final void b(View r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105, JSONObject r106, int r107, String r108) {
        }
    }

    void a(View r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105, int r106);

    void b(View r100, String r101, String r102, JSONObject r103, JSONObject r104, JSONObject r105, JSONObject r106, int r107, String r108);
}
