package com.obric.assistant.interaction.impl.window.behaviors;

import android.app.NotificationManager;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import com.bytedance.ai.api.AppletService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0002J\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/ClearNotificationBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "init", "", "onWindowShow", "onWindowHide", "clearAllNotifications", "tryToKeepAlarms", "notificationManager", "Landroid/app/NotificationManager;", "keepAlarmList", "", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClearNotificationBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final String TAG = "ClearNotificationBehavior";

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/ClearNotificationBehavior$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ClearNotificationBehavior() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void init() {
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowHide() {
    }

    private final void clearAllNotifications() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService("notification");
        List<String> r101 = null;
        if ((r100 instanceof NotificationManager) == false) goto L5;
        NotificationManager r102 = (NotificationManager) r100;
    L6:
        if (r102 == null) goto L14;
        AppletService r103 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r103 == null) goto L10;
        r101 = r103.d();
    L10:
        if (r101 != null) goto L12;
        r102.cancelAll();
        return;
    L12:
        tryToKeepAlarms(r102, r101);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowShow() {
        FLogger.f375446a.i(TAG, "onWindowShow, clearAllNotifications");
        clearAllNotifications();
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    private final void tryToKeepAlarms(NotificationManager r100, List<String> r101) {
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        r100.cancelAll();
        return;
    L6:
        if ((!r101.isEmpty()) == false) goto L13;
        StatusBarNotification[] r102 = r100.getActiveNotifications();
        Intrinsics.checkNotNull(r102);
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L19;
        StatusBarNotification r105 = r102[r104];
        if (r101.contains(r105.getNotification().getChannelId()) == true) goto L12;
        r100.cancel(r105.getId());
    L12:
        r104 = r104 + 1;
        goto L8
    L19:
        return;
    L13:
        r100.cancelAll();
    }

    @Override // com.obric.assistant.interaction.api.window.IBehavior
    public void onScreenRotationChanged(int r100, int r101) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r100, r101);
    }
}
