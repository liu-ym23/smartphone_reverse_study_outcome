package zr2;

import android.view.View;
import com.bytedance.android.livesdk.revenue.toolbar.RevRedDot;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILiveEnterRoomCallback;
import com.bytedance.android.livesdkapi.room.handler.enterroom.ILivePreviewBusinessBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes11.dex */
public interface b {
    void R9(View r100, DataCenter r101);

    void a(n r100);

    void d(h r100);

    RevRedDot h7();

    ILiveEnterRoomCallback k(ILivePreviewBusinessBridge r100);

    void onClick(View r100);

    void p4(View r100, DataCenter r101);

    boolean showRedDot();
}
