package ka0;

import android.view.View;
import com.bytedance.android.annie.api.card.HybridCard;

/* JADX INFO: loaded from: classes45.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f502172a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f502173a = null;

        public a() {
        }

        static {
            f502173a = new a();
        }
    }

    static {
        f502172a = a.f502173a;
    }

    void a(HybridCard r100, String r101);

    void b(HybridCard r100, View r101, int r102);

    void loadUrl(String r100);

    void release();

    <T> void sendJsEvent(String r100, T r101);
}
