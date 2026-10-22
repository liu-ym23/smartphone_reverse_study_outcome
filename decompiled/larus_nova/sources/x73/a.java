package x73;

import android.view.ViewParent;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.api.video.ScaleType;
import fj.e;

/* JADX INFO: loaded from: classes12.dex */
public interface a {
    long a();

    void c(com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c r100);

    void f(boolean r100, boolean r101);

    void g(com.bytedance.android.shopping.anchorv4.video.base.bridge.intf.callback.c r100);

    int getCurrentPosition();

    ViewParent getParentView();

    Object getPlayer();

    c getSharePlayer();

    void h(AVScene r100, boolean r101);

    void i(com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r100, com.bytedance.android.shopping.api.video.d r101, c r102);

    boolean isMute();

    boolean isPlaying();

    void j(e r100);

    void k(AVScene r100, boolean r101, a83.c r102, PlayAbilityCacheScene r103);

    void l(e r100);

    void onDestroy();

    void onPause();

    void onResume();

    void pausePlay();

    void release();

    void seek(float r100);

    void setScaleType(ScaleType r100);

    void startPlay();
}
