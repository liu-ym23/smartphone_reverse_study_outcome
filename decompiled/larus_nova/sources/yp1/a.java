package yp1;

import com.bytedance.android.livesdk.chatroom.vs.gesture.VSGestureViewManagerHelper;
import com.bytedance.android.livesdk.chatroom.vs.widget.landscape.VSRoomLandscapeResetPlayerViewWidget;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import ko1.c;
import nm1.p;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements p, o {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // nm1.p
    public final void c() {
        c r100 = VSGestureViewManagerHelper.f117687a;
        if (r100 == null) goto L6;
        r100.b("restore_button");
        return;
    }

    @Override // nm1.p
    public final Class<? extends Widget> d() {
        return VSRoomLandscapeResetPlayerViewWidget.class;
    }

    @Override // nm1.p
    public final boolean a(DataCenter r100) {
        aq1.c.f15879c.getClass();
        return aq1.c.a.a(r100);
    }
}
