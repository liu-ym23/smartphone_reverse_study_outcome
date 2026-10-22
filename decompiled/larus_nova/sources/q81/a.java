package q81;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.chatroom.room.RoomSession;
import com.bytedance.android.livesdkapi.roomplayer.AbsLivePlayerView;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;

/* JADX INFO: loaded from: classes47.dex */
public interface a {

    /* JADX INFO: renamed from: q81.a$a, reason: collision with other inner class name */
    public static final class C7298a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutableLiveData<Boolean> f532019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MutableLiveData<String> f532020b;

        public C7298a() {
            this.f532019a = new MutableLiveData();
            this.f532020b = new MutableLiveData();
        }
    }

    void a();

    void b(ILivePlayerClient r100);

    void c(ILivePlayerClient r100, gs0.c r101, View r102, View r103);

    void d(RoomSession r100, AbsLivePlayerView r101);

    void e();

    void f();

    void g(boolean r100);

    C7298a getEventHub();

    void reset();
}
