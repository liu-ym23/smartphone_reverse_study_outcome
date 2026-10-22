package wp1;

import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.RecyclableWidgetManager;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.c;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.chatroom.widget.PlayerVisibilityControllerWidget;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VSPlayerViewControlContext f560551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PlayerVisibilityControllerWidget f560552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.bytedance.android.livesdk.chatroom.vsplayer.api.a> f560553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WidgetManager f560554d;

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void clearControlWidget() {
        this.f560552b = null;
        ALogger.w(k(), "clear activeWidget!");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void releaseService() {
        this.f560552b = null;
        this.f560554d = null;
        this.f560553c.clear();
        ALogger.w(k(), "release service");
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final boolean getLockStatus() {
        return this.f560551a.isLocked().getValue().booleanValue();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final boolean getVisibilityStatus() {
        return this.f560551a.getPlayerViewVisible().getValue().booleanValue();
    }

    public final String k() {
        return "VSPlayerViewControlService#" + hashCode();
    }

    public final boolean l() {
        Iterator<com.bytedance.android.livesdk.chatroom.vsplayer.api.a> r100 = this.f560553c.iterator();
    L4:
        if (r100.hasNext() == false) goto L9;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.a r101 = r100.next();
        if (r101.intercept() == false) goto L4;
        ALogger.w(k(), "visibility control intercepted by " + r101.getName());
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void resetHideTask() {
        this.f560551a.getResetHideTaskEvent().post(Unit.INSTANCE);
    }

    public a() {
        this.f560551a = new VSPlayerViewControlContext();
        this.f560553c = new CopyOnWriteArrayList();
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void changeVisibilityStatus() {
        if (l() == false) goto L5;
        return;
    L5:
        this.f560551a.getPlayerViewVisible().setValue(Boolean.valueOf(!this.f560551a.getPlayerViewVisible().getValue().booleanValue()));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void markVisibilityStatusChangeByUser() {
        if (l() == false) goto L5;
        return;
    L5:
        this.f560551a.getPlayerViewVisibleTriggeredByUser().setValue(Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final WidgetManager getWidgetManager() {
        return this.f560554d;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final VSPlayerViewControlContext provideContext() {
        return this.f560551a;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void c(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        PlayerVisibilityControllerWidget r101 = this.f560552b;
        if (r101 == null) goto L12;
        if (r101 == null) goto L6;
        r101.Mq(r100);
    L6:
        String r102 = k();
        StringBuilder r103 = new StringBuilder("activeWidget[");
        PlayerVisibilityControllerWidget r104 = this.f560552b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        r103.append(r105);
        r103.append("] not null,do remove, key:");
        r103.append(r100.getDescribe());
        ALogger.d(r102, r103.toString());
        return;
    L9:
        r105 = 0;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void e(com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        PlayerVisibilityControllerWidget r101 = this.f560552b;
        if (r101 == null) goto L9;
        r101.Bq(r100);
        String r102 = k();
        StringBuilder r103 = new StringBuilder("activeWidget[");
        PlayerVisibilityControllerWidget r104 = this.f560552b;
        if (r104 == null) goto L7;
        int r105 = r104.hashCode();
    L8:
        r103.append(r105);
        r103.append("] not null,do direct add, key:");
        r103.append(r100.f118405g.getDescribe());
        ALogger.d(r102, r103.toString());
        return;
    L7:
        r105 = 0;
        goto L8
    L9:
        this.f560551a.getTmpControlItemList().add(r100);
        ALogger.w(k(), "activeWidget null,add to tmp list,key:" + r100.f118405g.getDescribe());
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void f(Widget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        this.f560552b = (PlayerVisibilityControllerWidget) r100;
        String r101 = k();
        StringBuilder r102 = new StringBuilder("register activeWidget![");
        PlayerVisibilityControllerWidget r103 = this.f560552b;
        if (r103 == null) goto L5;
        int r104 = r103.hashCode();
    L6:
        r102.append(r104);
        r102.append(']');
        ALogger.w(r101, r102.toString());
        return;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final NextLiveData<Integer> g(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        PlayerVisibilityControllerWidget r101 = this.f560552b;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r102 = (com.bytedance.android.livesdk.chatroom.vsplayer.model.c) ((LinkedHashMap) r101.f118636k).get(r100);
        if (r102 != null) goto L8;
        return null;
    L8:
        return r102.f118404f;
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void h(PlayerViewControl.KEY r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        PlayerVisibilityControllerWidget r101 = this.f560552b;
        if (r101 == null) goto L6;
        r101.Pq(r100, false, 0, true);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void i(RecyclableWidgetManager r100) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        this.f560552b = null;
        this.f560554d = r100;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void j(boolean r100) {
        if (l() == false) goto L5;
        return;
    L5:
        ALogger.w(k(), "setVisibilityStatus[" + r100 + "] with customDuration:0");
        this.f560551a.getCustomAnimDuration().setValue(0L);
        this.f560551a.getPlayerViewVisible().setValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void setVisibilityStatus(boolean r100) {
        if (l() == false) goto L5;
        return;
    L5:
        this.f560551a.getPlayerViewVisible().setValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void a(PlayerViewControl.KEY r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        PlayerVisibilityControllerWidget r102 = this.f560552b;
        if (r102 == null) goto L6;
        int r103 = PlayerVisibilityControllerWidget.A;
        r102.Pq(r100, r101, 0, false);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void d(PlayerViewControl.KEY r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        PlayerVisibilityControllerWidget r102 = this.f560552b;
        if (r102 == null) goto L6;
        int r103 = PlayerVisibilityControllerWidget.A;
        r102.Pq(r100, r101, 300, false);
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vsplayer.api.c
    public final void b(PlayerViewControl.KEY r110, PlayerViewControl.Type r111, PlayerViewControl.Style r112, View r113, float r114, boolean r115, boolean r116, com.bytedance.android.livesdk.chatroom.vsplayer.model.a r117, boolean r210) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r112, "style");
        Intrinsics.checkNotNullParameter(r113, "view");
        if (r117 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.vsplayer.model.c r100 = new com.bytedance.android.livesdk.chatroom.vsplayer.model.c(r110, r117, r113, r111, r112, r114, r115, r116, r210);
    L6:
        e(r100);
        return;
    L5:
        r100 = new com.bytedance.android.livesdk.chatroom.vsplayer.model.c(r110, null, r113, r111, r112, r114, r115, r116, r210);
        goto L6
    }
}
