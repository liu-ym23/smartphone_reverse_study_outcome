package com.obric.assistant.interaction.api;

import android.app.Activity;
import android.os.Bundle;
import android.os.IBinder;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationListener;
import com.obric.assistant.interaction.api.window.animation.IWindowAnimationProvider;
import com.obric.assistant.interaction.api.window.animation.WindowAnimationType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0087\u0001\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\t2\b\b\u0002\u0010\u0014\u001a\u00020\tH&¢\u0006\u0002\u0010\u0015J\b\u0010\u000e\u001a\u00020\u0003H&J\u0012\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u0018H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\b\u0010\u001b\u001a\u00020\tH&J\b\u0010\u001c\u001a\u00020\tH&J\u0012\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001fH&J\u0012\u0010 \u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u001fH&J\b\u0010!\u001a\u00020\tH&J\b\u0010\"\u001a\u00020\tH&J\u0017\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020%H\u0016¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0016J\n\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020\tH\u0016J\u0018\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0012H\u0016J\u0018\u00100\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0007H\u0016J\u0018\u00103\u001a\u00020\u00032\u0006\u00104\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0007H\u0016J \u00105\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u00122\u0006\u00106\u001a\u00020\t2\u0006\u00102\u001a\u00020\u0007H\u0016J\b\u00107\u001a\u00020\u0003H&J\b\u00108\u001a\u00020\tH&J\u0012\u00109\u001a\u00020\u00032\b\u0010:\u001a\u0004\u0018\u00010;H&J\u0010\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H&J\u0010\u0010?\u001a\u00020\u00032\u0006\u0010=\u001a\u00020>H&J\u0010\u0010@\u001a\u00020\u00032\u0006\u0010=\u001a\u00020AH\u0016J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010=\u001a\u00020AH\u0016J\u0010\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020EH&J\u0010\u0010F\u001a\u00020\u00032\u0006\u0010D\u001a\u00020EH&J\b\u0010G\u001a\u00020\u0003H&J\b\u0010H\u001a\u00020\u0003H&J\n\u0010I\u001a\u0004\u0018\u00010\u001aH&Ji\u0010J\u001a\u00020\f2\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0014\u001a\u00020\tH&¢\u0006\u0002\u0010KJ\b\u0010L\u001a\u00020\tH&J\b\u0010M\u001a\u00020\tH&¨\u0006N"}, d2 = {"Lcom/obric/assistant/interaction/api/IAssistantChatWindow;", "", "createChatWindow", "", "preloadWindow", "openChatWindow", "assistantRequestFrom", "", "wakeUp", "", "isMicInUse", "extra", "Landroid/os/Bundle;", "checkScreenLock", "interruptMovingBackground", "args", "", "vuiId", "", "forceUseDefaultDisplay", "forceOpenActivity", "(Ljava/lang/String;ZLjava/lang/Boolean;Landroid/os/Bundle;ZZLjava/util/Map;Ljava/lang/Integer;ZZ)V", "exitVirtualDisplay", "delayMS", "", "provideWindowVContext", "Lcom/larus/ui/arch/context/external/VContext;", "isShowing", "isPreloaded", "stash", GXTemplateKey.GAIAX_ANIMATION, "Lcom/obric/assistant/interaction/api/window/animation/WindowAnimationType;", "pop", "isStashed", "isWindowMode", "isMainBotActivity", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)Ljava/lang/Boolean;", "updateBackgroundDimAmount", "alpha", "", "getWindowLayoutInfo", "Lcom/obric/assistant/interaction/api/WindowLayoutInfo;", "isWindowAnimationRunning", "applyWindowAnimationBoost", "source", "durationMs", "updateWindowAnimationY", "y", "reason", "updateWindowAnimationNoLimitsEnabled", "enabled", "updateWindowAnimationLayout", "noLimitsEnabled", "dismissWindow", "isNewGlobalPanelBlockedByPermission", "setSessionToken", "token", "Landroid/os/IBinder;", "addWindowLifecycleListener", "listener", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "removeWindowLifecycleListener", "addWindowAnimationListener", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationListener;", "removeWindowAnimationListener", "addWindowAnimationCreator", "creator", "Lcom/obric/assistant/interaction/api/window/animation/IWindowAnimationProvider;", "removeWindowAnimationCreator", "dismissAllChildDialogs", "onWakeupBlockedBySystemAlertWindowPermission", "getCurrentVContext", "buildLaunchParams", "(Ljava/lang/String;ZLjava/lang/Boolean;Landroid/os/Bundle;Ljava/util/Map;Ljava/lang/Integer;Z)Landroid/os/Bundle;", "isWindowFeatureEnabled", "hasTopChatActivityMatchingSystemTop", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAssistantChatWindow {

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void addWindowAnimationListener(IAssistantChatWindow r100, IWindowAnimationListener r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
        }

        public static void applyWindowAnimationBoost(IAssistantChatWindow r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "source");
        }

        public static WindowLayoutInfo getWindowLayoutInfo(IAssistantChatWindow r100) {
            return null;
        }

        public static Boolean isMainBotActivity(IAssistantChatWindow r100, Activity r101) {
            Intrinsics.checkNotNullParameter(r101, "activity");
            return null;
        }

        public static boolean isWindowAnimationRunning(IAssistantChatWindow r100) {
            return false;
        }

        public static void removeWindowAnimationListener(IAssistantChatWindow r100, IWindowAnimationListener r101) {
            Intrinsics.checkNotNullParameter(r101, "listener");
        }

        public static void updateBackgroundDimAmount(IAssistantChatWindow r100, float r101) {
        }

        public static void updateWindowAnimationLayout(IAssistantChatWindow r100, int r101, boolean r102, String r103) {
            Intrinsics.checkNotNullParameter(r103, "reason");
        }

        public static void updateWindowAnimationNoLimitsEnabled(IAssistantChatWindow r100, boolean r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "reason");
        }

        public static void updateWindowAnimationY(IAssistantChatWindow r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "reason");
        }

        public static /* synthetic */ void exitVirtualDisplay$default(IAssistantChatWindow r100, long r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            r100.exitVirtualDisplay(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitVirtualDisplay");
        }

        public static /* synthetic */ void pop$default(IAssistantChatWindow r100, WindowAnimationType r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = WindowAnimationType.None;
        L6:
            r100.pop(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pop");
        }

        public static /* synthetic */ void stash$default(IAssistantChatWindow r100, WindowAnimationType r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = WindowAnimationType.None;
        L6:
            r100.stash(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stash");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Bundle buildLaunchParams$default(IAssistantChatWindow r100, String r101, boolean r102, Boolean r103, Bundle r104, Map r110, Integer r111, boolean r112, int r113, Object r114) {
            if (r114 != null) goto L33;
            if ((r113 & 1) == 0) goto L6;
            r101 = "";
        L6:
            boolean r105 = false;
            if ((r113 & 2) == 0) goto L9;
            boolean r115 = false;
        L10:
            Integer r106 = null;
            if ((r113 & 4) == 0) goto L13;
            Boolean r107 = null;
        L15:
            if ((r113 & 8) == 0) goto L17;
            Bundle r108 = null;
        L19:
            if ((r113 & 16) == 0) goto L21;
            Map r109 = null;
        L23:
            if ((r113 & 32) != 0) goto L27;
            r106 = r111;
        L27:
            if ((r113 & 64) != 0) goto L31;
            r105 = r112;
        L31:
            return r100.buildLaunchParams(r101, r115, r107, r108, r109, r106, r105);
        L21:
            r109 = r110;
            goto L23
        L17:
            r108 = r104;
            goto L19
        L13:
            r107 = r103;
            goto L15
        L9:
            r115 = r102;
            goto L10
        L33:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildLaunchParams");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void openChatWindow$default(IAssistantChatWindow r110, String r111, boolean r112, Boolean r113, Bundle r114, boolean r115, boolean r116, Map r117, Integer r118, boolean r210, boolean r211, int r212, Object r213) {
            if (r213 != null) goto L47;
            if ((r212 & 1) == 0) goto L7;
            String r100 = "";
        L8:
            boolean r101 = false;
            if ((r212 & 2) == 0) goto L11;
            boolean r102 = false;
        L12:
            Integer r103 = null;
            if ((r212 & 4) == 0) goto L15;
            Boolean r104 = null;
        L17:
            if ((r212 & 8) == 0) goto L19;
            Bundle r105 = null;
        L20:
            boolean r106 = true;
            if ((r212 & 16) == 0) goto L23;
            boolean r107 = true;
        L25:
            if ((r212 & 32) != 0) goto L29;
            r106 = r116;
        L29:
            if ((r212 & 64) == 0) goto L31;
            Map r108 = null;
        L33:
            if ((r212 & 128) != 0) goto L37;
            r103 = r118;
        L37:
            if ((r212 & 256) == 0) goto L39;
            boolean r119 = false;
        L41:
            if ((r212 & 512) != 0) goto L44;
            r101 = r211;
        L44:
            r110.openChatWindow(r100, r102, r104, r105, r107, r106, r108, r103, r119, r101);
            return;
        L39:
            r119 = r210;
            goto L41
        L31:
            r108 = r117;
            goto L33
        L23:
            r107 = r115;
            goto L25
        L19:
            r105 = r114;
            goto L20
        L15:
            r104 = r113;
            goto L17
        L11:
            r102 = r112;
            goto L12
        L7:
            r100 = r111;
            goto L8
        L47:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openChatWindow");
        }
    }

    void addWindowAnimationCreator(IWindowAnimationProvider r100);

    void addWindowAnimationListener(IWindowAnimationListener r100);

    void addWindowLifecycleListener(wga.b r100);

    void applyWindowAnimationBoost(String r100, int r101);

    Bundle buildLaunchParams(String r100, boolean r101, Boolean r102, Bundle r103, Map<String, ? extends Object> r104, Integer r105, boolean r106);

    void createChatWindow();

    void dismissAllChildDialogs();

    void dismissWindow();

    void exitVirtualDisplay(long r100);

    t1a.b getCurrentVContext();

    WindowLayoutInfo getWindowLayoutInfo();

    boolean hasTopChatActivityMatchingSystemTop();

    void interruptMovingBackground();

    Boolean isMainBotActivity(Activity r100);

    boolean isNewGlobalPanelBlockedByPermission();

    boolean isPreloaded();

    boolean isShowing();

    boolean isStashed();

    boolean isWindowAnimationRunning();

    boolean isWindowFeatureEnabled();

    boolean isWindowMode();

    void onWakeupBlockedBySystemAlertWindowPermission();

    void openChatWindow(String r100, boolean r101, Boolean r102, Bundle r103, boolean r104, boolean r105, Map<String, ? extends Object> r106, Integer r107, boolean r108, boolean r110);

    void pop(WindowAnimationType r100);

    void preloadWindow();

    t1a.b provideWindowVContext();

    void removeWindowAnimationCreator(IWindowAnimationProvider r100);

    void removeWindowAnimationListener(IWindowAnimationListener r100);

    void removeWindowLifecycleListener(wga.b r100);

    void setSessionToken(IBinder r100);

    void stash(WindowAnimationType r100);

    void updateBackgroundDimAmount(float r100);

    void updateWindowAnimationLayout(int r100, boolean r101, String r102);

    void updateWindowAnimationNoLimitsEnabled(boolean r100, String r101);

    void updateWindowAnimationY(int r100, String r101);
}
