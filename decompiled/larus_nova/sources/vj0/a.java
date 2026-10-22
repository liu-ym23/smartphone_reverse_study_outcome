package vj0;

import com.bytedance.android.live.liveinteract.videotalk.contract.VideoRoomPreApplyContract$View;
import yf0.e;

/* JADX INFO: loaded from: classes46.dex */
public abstract class a extends e<VideoRoomPreApplyContract$View> {
    public abstract void d(String r100);

    public abstract void e(boolean r100, int r101, String r102);

    public a(VideoRoomPreApplyContract$View r100) {
        super(r100);
    }

    public static /* synthetic */ void f(a r100, boolean r101, String r102, int r103) {
        if ((r103 & 2) == 0) goto L5;
        int r104 = 20;
    L7:
        if ((r103 & 4) == 0) goto L9;
        r102 = "";
    L9:
        r100.e(r101, r104, r102);
        return;
    L5:
        r104 = 0;
        goto L7
    }
}
