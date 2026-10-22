package t52;

import android.content.Context;
import com.bytedance.android.livesdkapi.depend.model.broadcast.IBroadcastStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface a {

    /* JADX INFO: renamed from: t52.a$a, reason: collision with other inner class name */
    public static class C7687a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f544618a;

        public C7687a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            this.f544618a = r100;
        }
    }

    public interface b {
        void a(C7687a r100);

        void b(C7687a r100);

        void c(C7687a r100);
    }

    C7687a getPlaying();

    boolean isPlaying();

    void playAudioByPath(Context r100, C7687a r101);

    void playAudioByUrl(Context r100, C7687a r101);

    void register(b r100);

    void setLiveStream(IBroadcastStream r100);

    void stopAudio();

    void unregister(b r100);
}
