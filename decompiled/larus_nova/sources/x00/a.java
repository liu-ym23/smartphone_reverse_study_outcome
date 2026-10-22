package x00;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes45.dex */
public interface a {
    IVoiceLiveTheme a(int r100);

    void c(IVoiceLiveTheme r100, int r101);

    void d(long r100, IVoiceLiveTheme r101);

    int e();

    void f(Observer<IVoiceLiveTheme> r100, int r101);

    void g(int r100, Function2<? super List<? extends IVoiceLiveTheme>, ? super Boolean, Unit> r101);

    void h(int r100);

    String[] i();

    void j(LifecycleOwner r100, Observer<IVoiceLiveTheme> r101, int r102);

    void k(int r100, long r101, Function2 r102);

    void l(int r100);

    void m(long r100, IVoiceLiveTheme r101, int r102);

    boolean n(int r100);

    boolean o(int r100);

    void p(LifecycleOwner r100, Observer<ArrayList<IVoiceLiveTheme>> r101, int r102);

    IVoiceLiveTheme q(int r100);

    String[] s();
}
