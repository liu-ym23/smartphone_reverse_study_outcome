package ln1;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragment;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface a {

    /* JADX INFO: renamed from: ln1.a$a, reason: collision with other inner class name */
    public static final class C6715a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f509979a = 0;

        static {
        }

        public static boolean a(String r100) {
            if (r100 != null) goto L4;
        L6:
            return false;
        L4:
            if (r100.length() <= 0) goto L6;
            return true;
        }

        public static JSONObject b(String r100) {
            if (a(r100) == false) goto L6;
            return new JSONObject(r100);
        L6:
            return null;
        L11:
            return null;
        }
    }

    boolean a();

    boolean b(int r100, int r101);

    void c(IRoom r100, Object r101);

    void d(int r100, int r101, int r102, int r103, ILiveRoomPlayFragment r104);

    boolean e();

    boolean f();

    void preload(Long r100);
}
