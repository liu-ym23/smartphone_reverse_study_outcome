package kc0;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.revlink.impl.control.LinkRevControlWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: classes45.dex */
public interface r {

    public interface a {
        void a(LiveWidget r100);

        void b(Widget r100);

        vc0.a getLiveVideoClientFactory();
    }

    void a(View r100, MotionEvent r101);

    void b0(String r100);

    LinkRevControlWidget getWidget();

    void onSei(String r100);

    void p3(IRoom r100);

    void q3(vc0.a r100);
}
