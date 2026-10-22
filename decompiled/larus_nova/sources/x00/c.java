package x00;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IThemeShowArea;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.depend.model.live.audio.ThemeUpLoadListener;

/* JADX INFO: loaded from: classes45.dex */
public interface c extends x00.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f562036a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f562037a = null;

        public a() {
        }

        static {
            f562037a = new a();
        }
    }

    static {
        f562036a = a.f562037a;
    }

    IVoiceLiveTheme a(int r100);

    void b();

    void r(FragmentActivity r100, long r101, String r102, IThemeShowArea r103, int r104, ThemeUpLoadListener r105);
}
