package rj0;

import android.graphics.Bitmap;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;

/* JADX INFO: loaded from: classes46.dex */
public interface e {
    boolean G7();

    t Hk();

    void Jj();

    void Yg();

    boolean isLinkCasting();

    boolean isSupportLinkCastMiniApp();

    void kh(t.b r100);

    void ll(LinkScreenCastType r100, String r101, int r102, int r103, Bitmap r104, String r105, String r106);

    void logMiniAppShareIconClick(String r100, String r101, boolean r102);

    void logMiniAppShareIconShow(String r100, String r101, boolean r102);

    void ne(LinkScreenCastType r100, String r101, String r102, boolean r103);

    void onProgramFrameErr();

    void onProgramHide();

    void onProgramShow();

    void onProgramStop();
}
