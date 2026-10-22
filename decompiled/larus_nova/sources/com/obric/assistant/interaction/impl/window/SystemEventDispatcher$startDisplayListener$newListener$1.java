package com.obric.assistant.interaction.impl.window;

import android.hardware.display.DisplayManager;
import android.view.Display;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/assistant/interaction/impl/window/SystemEventDispatcher$startDisplayListener$newListener$1", "Landroid/hardware/display/DisplayManager$DisplayListener;", "onDisplayAdded", "", "displayId", "", "onDisplayRemoved", "onDisplayChanged", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SystemEventDispatcher$startDisplayListener$newListener$1 implements DisplayManager.DisplayListener {
    final /* synthetic */ int $hostDisplayId;
    final /* synthetic */ Ref.IntRef $previousState;
    final /* synthetic */ SystemEventDispatcher this$0;

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayAdded(int r100) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayRemoved(int r100) {
    }

    @Override // android.hardware.display.DisplayManager.DisplayListener
    public void onDisplayChanged(int r100) {
        if (SystemEventDispatcher.access$getStarted$p(this.this$0) == true) goto L5;
        return;
    L5:
        if (SystemEventDispatcher.access$getDisplayListener$p(this.this$0) == this) goto L7;
        return;
    L7:
        if (r100 != this.$hostDisplayId) goto L29;
        Display r101 = SystemEventDispatcher.access$getDisplayManager$p(this.this$0).getDisplay(r100);
        if (r101 == null) goto L26;
        int r102 = r101.getState();
        if (r102 == this.$previousState.element) goto L14;
        FLogger.f375446a.i("SystemEventDispatcher", "host display state changed, displayId=" + r100 + ", previousState=" + this.$previousState.element + ", state=" + r102);
    L14:
        SystemEventDispatcher.Companion r103 = SystemEventDispatcher.Companion;
        boolean r104 = SystemEventDispatcher.Companion.access$isScreenOffState(r103, this.$previousState.element);
        this.$previousState.element = r102;
        if (r104 == true) goto L17;
    L19:
        if (r104 == false) goto L21;
        return;
    L21:
        if (SystemEventDispatcher.Companion.access$isScreenOffState(r103, r102) == false) goto L28;
        FLogger.f375446a.i("SystemEventDispatcher", "host display screen off, displayId=" + r100 + ", state=" + r102);
        SystemEventDispatcher.access$dispatchScreenOff(this.this$0, "display");
        return;
    L28:
        return;
    L17:
        if (r102 != 2) goto L19;
        FLogger.f375446a.i("SystemEventDispatcher", "host display screen on, displayId=" + r100 + ", reset screen off dispatch");
        SystemEventDispatcher.access$setScreenOffDispatched$p(this.this$0, false);
        goto L19
    L26:
        return;
    }

    public SystemEventDispatcher$startDisplayListener$newListener$1(SystemEventDispatcher r100, int r101, Ref.IntRef r102) {
        this.this$0 = r100;
        this.$hostDisplayId = r101;
        this.$previousState = r102;
    }
}
