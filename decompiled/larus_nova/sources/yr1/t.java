package yr1;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.business.VSInjectWidgetType;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: classes8.dex */
public interface t {
    c0.b a(Context r100, Episode r101);

    void c(DataCenter r100);

    Class<? extends Widget> getWidgetClass(@VSInjectWidgetType int r100);
}
