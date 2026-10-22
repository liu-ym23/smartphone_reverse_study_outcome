package com.obric.assistant.interaction.impl.window;

import android.os.Bundle;
import com.bytedance.map.api.monitor.MapMonitorConst;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000b\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowLifecycleController;", "", "<init>", "()V", "activity", "Lcom/obric/assistant/interaction/impl/window/ChatWindowActivity;", "bind", "", "create", "savedInstanceState", "Landroid/os/Bundle;", "show", "start", "resume", "hide", MapMonitorConst.EVENT_DESTROY, "moveToStashedStateAfterRecreate", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class WindowLifecycleController {
    public static final Companion Companion = null;
    private static final String TAG = "WindowLifecycleController";
    private ChatWindowActivity activity;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowLifecycleController$Companion;", "", "<init>", "()V", "TAG", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    public WindowLifecycleController() {
    }

    public final void destroy() {
        FLogger.f375446a.i(TAG, MapMonitorConst.EVENT_DESTROY);
        ChatWindowActivity r100 = this.activity;
        if (r100 == null) goto L6;
        r100.performDestroy$impl_mainlandRelease();
        return;
    }

    public final void hide() {
        FLogger.f375446a.i(TAG, "hide");
        ChatWindowActivity r100 = this.activity;
        if (r100 == null) goto L6;
        r100.performStop$impl_mainlandRelease();
        return;
    }

    public final void moveToStashedStateAfterRecreate() {
        FLogger.f375446a.i(TAG, "moveToStashedStateAfterRecreate");
        ChatWindowActivity r100 = this.activity;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.performResume$impl_mainlandRelease();
        r100.performStop$impl_mainlandRelease();
    }

    public final void resume() {
        FLogger.f375446a.i(TAG, "resume");
        ChatWindowActivity r100 = this.activity;
        if (r100 == null) goto L6;
        r100.performResume$impl_mainlandRelease();
        return;
    }

    public final void show() {
        FLogger.f375446a.i(TAG, "show");
        ChatWindowActivity r100 = this.activity;
        if (r100 == null) goto L6;
        r100.performResume$impl_mainlandRelease();
        return;
    }

    public final void start() {
        FLogger.f375446a.i(TAG, "start");
        ChatWindowActivity r100 = this.activity;
        if (r100 == null) goto L6;
        r100.performStart$impl_mainlandRelease();
        return;
    }

    public final void bind(ChatWindowActivity r100) {
        this.activity = r100;
    }

    public final void create(Bundle r100) {
        FLogger.f375446a.i(TAG, "create");
        ChatWindowActivity r101 = this.activity;
        if (r101 == null) goto L6;
        r101.performCreate$impl_mainlandRelease(r100);
        return;
    }
}
