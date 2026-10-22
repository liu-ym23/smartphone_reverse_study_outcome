package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.ies.sdk.widgets.Widget;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/widget/KtvRoomSceneBaseWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "<init>", "()V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public abstract class KtvRoomSceneBaseWidget extends MiddlewareRoomRecyclableWidget {
    public int a;
    public int b;

    public final void onUnload() {
        ALogger.i("KtvRoomSceneBaseWidget", "onUnload");
    }

    public KtvRoomSceneBaseWidget() {
    }

    public final void onInit(Object[] r1) {
        setRecyclable();
    }

    public void onLoad(Object[] r1) {
        ((Widget) this).subWidgetManager = null;
        enableSubWidgetManager();
    }
}
