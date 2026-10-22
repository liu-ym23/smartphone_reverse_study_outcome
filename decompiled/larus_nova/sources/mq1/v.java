package mq1;

import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.VSRecyclableWidgetManager;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;

/* JADX INFO: loaded from: classes8.dex */
public interface v {

    public static final class a {
        public static /* synthetic */ void a(v r110, PlayerViewControl.KEY r111, PlayerViewControl.Type r112, PlayerViewControl.Style r113, View r114, float r115, boolean r116, com.bytedance.android.livesdk.chatroom.vsplayer.model.a r117, int r210) {
            if ((r210 & 16) == 0) goto L5;
            float r100 = 0.0f;
        L7:
            if ((r210 & 32) == 0) goto L9;
            boolean r101 = false;
        L11:
            if ((r210 & 128) == 0) goto L13;
            com.bytedance.android.livesdk.chatroom.vsplayer.model.a r118 = null;
        L14:
            r110.b(r111, r112, r113, r114, r100, r101, false, r118, false);
            return;
        L13:
            r118 = r117;
            goto L14
        L9:
            r101 = r116;
            goto L11
        L5:
            r100 = r115;
            goto L7
        }
    }

    void a(PlayerViewControl.KEY r100, boolean r101);

    void b(PlayerViewControl.KEY r100, PlayerViewControl.Type r101, PlayerViewControl.Style r102, View r103, float r104, boolean r105, boolean r106, com.bytedance.android.livesdk.chatroom.vsplayer.model.a r107, boolean r108);

    void c(PlayerViewControl.KEY r100);

    void changeVisibilityStatus();

    void clearControlWidget();

    void d(PlayerViewControl.KEY r100, boolean r101);

    void e(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100);

    void f(Widget r100);

    NextLiveData<Integer> g(PlayerViewControl.KEY r100);

    boolean getLockStatus();

    boolean getVisibilityStatus();

    WidgetManager getWidgetManager();

    void h(VSRecyclableWidgetManager r100);

    void markVisibilityStatusChangeByUser();

    VSPlayerViewControlContext provideContext();

    void releaseService();

    void resetHideTask();

    void setVisibilityStatus(boolean r100);
}
