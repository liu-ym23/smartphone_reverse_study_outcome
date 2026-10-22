package fd2;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessLifecycleOwner;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusMainViewWidget$initIsPlayingMusicObserver$$inlined$let$lambda$1;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public interface s {
    void Ch(String r100, long r101, Function0<Unit> r102);

    e0 D7();

    void Fi(MusicPanel r100, Function1<Object, Unit> r101, Function1<? super Throwable, Unit> r102);

    String Kb();

    String Mm();

    void Pa();

    xe2.c Qe();

    long Qm();

    void W8(String r100);

    boolean Y5();

    void cp(LifecycleOwner r100, Observer<Integer> r101);

    int f8();

    int i0();

    boolean isPlaying();

    boolean k8();

    void kj(LifecycleOwner r100, Observer<Boolean> r101);

    void km(double r100, int r101, Function1<? super Boolean, Unit> r102);

    boolean ko();

    nd2.d oj();

    void pn(LifecycleOwner r100, Observer<Integer> r101);

    void qf(boolean r100);

    int sb();

    void setChorusCDNInfo(com.bytedance.android.livesdk.chatroom.model.v r100);

    long u7();

    void y9(RealTimeChorusBusinessLifecycleOwner r100, RealTimeChorusMainViewWidget$initIsPlayingMusicObserver$$inlined$let$lambda$1 r101);

    void yj(String r100, boolean r101);
}
