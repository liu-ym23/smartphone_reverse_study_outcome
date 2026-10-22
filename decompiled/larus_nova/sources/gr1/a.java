package gr1;

import com.bytedance.android.livesdk.chatroom.vsplayer.api.b;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.c;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public interface a {
    b provideVSPlayerTipService(DataCenter r100);

    c provideVSPlayerViewControlService(DataCenter r100);

    void releaseService(DataCenter r100);
}
