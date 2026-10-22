package com.obric.assistant.interaction.impl.screen;

import android.hardware.display.DisplayManager;
import android.view.Display;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.IScreenState;
import com.obric.assistant.interaction.api.OnScreenStateChangedListener;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u0007H\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/interaction/impl/screen/ScreenStateImpl;", "Lcom/obric/assistant/interaction/api/IScreenState;", "<init>", "()V", "TAG", "", "screenState", "", "listeners", "", "Lcom/obric/assistant/interaction/api/OnScreenStateChangedListener;", "updateScreenState", "getScreenState", "isScreenOn", "", "registerScreenStateChangedListener", "", "listener", "unregisterScreenStateChangedListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScreenStateImpl implements IScreenState {
    private final String TAG;
    private final List<OnScreenStateChangedListener> listeners;
    private int screenState;

    public static /* synthetic */ void a(ScreenStateImpl r100, OnScreenStateChangedListener r101) {
        unregisterScreenStateChangedListener$lambda$1(r100, r101);
    }

    public static /* synthetic */ void b(ScreenStateImpl r100, OnScreenStateChangedListener r101) {
        registerScreenStateChangedListener$lambda$0(r100, r101);
    }

    private final int updateScreenState() {
        Object r100 = AppHost.f326268a.getApplication().getSystemService("display");
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        Display r101 = ((DisplayManager) r100).getDisplay(0);
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getState());
    L6:
        if (r102 != null) goto L8;
        FLogger.f375446a.w(this.TAG, "got null state");
    L8:
        if (r102 != null) goto L10;
        return 0;
    L10:
        return r102.intValue();
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.obric.assistant.interaction.api.IScreenState
    public boolean isScreenOn() {
        if (this.screenState != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public ScreenStateImpl() {
        this.TAG = "ScreenStateImpl";
        this.listeners = new ArrayList();
        this.screenState = updateScreenState();
        FLogger.f375446a.i("ScreenStateImpl", "init screenState = " + this.screenState);
        DisplayManager.DisplayListener r100 = new ScreenStateImpl$displayListener$1(this);
        Object r101 = AppHost.f326268a.getApplication().getSystemService("display");
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        ((DisplayManager) r101).registerDisplayListener(r100, t0.f375468a);
    }

    @Override // com.obric.assistant.interaction.api.IScreenState
    public int getScreenState() {
        return this.screenState;
    }

    public static final /* synthetic */ List access$getListeners$p(ScreenStateImpl r100) {
        return r100.listeners;
    }

    public static final /* synthetic */ int access$getScreenState$p(ScreenStateImpl r100) {
        return r100.screenState;
    }

    public static final /* synthetic */ String access$getTAG$p(ScreenStateImpl r100) {
        return r100.TAG;
    }

    public static final /* synthetic */ int access$updateScreenState(ScreenStateImpl r100) {
        return r100.updateScreenState();
    }

    @Override // com.obric.assistant.interaction.api.IScreenState
    public void registerScreenStateChangedListener(final OnScreenStateChangedListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        t0.e(new a(this, r100));
    }

    @Override // com.obric.assistant.interaction.api.IScreenState
    public void unregisterScreenStateChangedListener(final OnScreenStateChangedListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        t0.e(new b(this, r100));
    }

    public static final /* synthetic */ void access$setScreenState$p(ScreenStateImpl r100, int r101) {
        r100.screenState = r101;
    }

    private static final void registerScreenStateChangedListener$lambda$0(ScreenStateImpl r100, OnScreenStateChangedListener r101) {
        if (r100.listeners.contains(r101) == true) goto L6;
        r100.listeners.add(r101);
        return;
    }

    private static final void unregisterScreenStateChangedListener$lambda$1(ScreenStateImpl r100, OnScreenStateChangedListener r101) {
        r100.listeners.remove(r101);
    }
}
