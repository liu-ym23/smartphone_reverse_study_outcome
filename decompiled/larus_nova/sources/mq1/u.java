package mq1;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerTipsContext;

/* JADX INFO: loaded from: classes8.dex */
public interface u {
    void hidePlayerTip(String r100);

    PlayerTipsContext provideVSPlayTipsContext();

    void showPlayerTip(String r100, CharSequence r101, boolean r102);

    void showPlayerTipWithCustomView(String r100, View r101);
}
