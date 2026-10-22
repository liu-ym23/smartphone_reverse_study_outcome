package vq1;

import com.bytedance.android.livesdkapi.depend.model.live.episode.EnterVideoResult;

/* JADX INFO: loaded from: classes8.dex */
public interface b {

    public interface a {
        void a(int r100, String r101, String r102, String r103);

        void b(EnterVideoResult r100);

        void c(EnterVideoResult r100);
    }

    void start();

    void stop();
}
