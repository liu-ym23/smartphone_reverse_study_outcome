package jm1;

import android.content.res.Configuration;
import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;

/* JADX INFO: loaded from: classes7.dex */
public interface e {
    void a(IRoom r100);

    void onConfigurationChanged(Configuration r100);

    void onDislikeItem(long r100);

    void onFirsFrame();

    void onInteractionViewsAdapt(boolean r100, View r101, View r102, View r103, View r104);

    void onLiveEnd(View r100, View r101);

    void onMaskLayerChanged(String r100, boolean r101);

    void onNotSmoothLeave();

    void onSmoothLeaveRoom();
}
