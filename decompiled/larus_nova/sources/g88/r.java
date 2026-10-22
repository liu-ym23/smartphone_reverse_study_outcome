package g88;

import android.content.Intent;
import com.larus.audio.call.mgr.MajorState;
import com.larus.im.service.audio.z0;

/* JADX INFO: loaded from: classes24.dex */
public interface r {
    void A0();

    void D9(z0.a r100);

    void I6(jd9.c r100);

    void o1(MajorState r100, int r101, MajorState r102, int r103);

    void onActivityResult(int r100, int r101, Intent r102);

    void onAppBackground();

    void onAppForeground();

    void z2(String r100, Object r101);
}
