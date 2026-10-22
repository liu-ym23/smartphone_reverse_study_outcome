package com.obric.assistant.interaction.impl.toast;

import android.content.Context;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.common.spi.toast.IToastHelper;
import com.obric.assistant.interaction.api.window.IWindowContextKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import u19.f;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/ToastHelperImpl;", "Lcom/obric/assistant/common/spi/toast/IToastHelper;", "<init>", "()V", "resolveContext", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "createToastHolder", "Lcom/larus/common_ui/toast/abs/IToastHolder;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastHelperImpl implements IToastHelper {
    public static final Companion Companion = null;
    private static WeakReference<Context> activeWindowContext;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/impl/toast/ToastHelperImpl$Companion;", "", "<init>", "()V", "activeWindowContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "registerWindowContext", "", PerfLog.PARAM_KEY_CONTEXT_ID, "unregisterWindowContext", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final void registerWindowContext(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if (IWindowContextKt.isWindowContext(r100) == false) goto L6;
            ToastHelperImpl.access$setActiveWindowContext$cp(new WeakReference(r100));
            return;
        }

        public final void unregisterWindowContext(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            WeakReference r101 = ToastHelperImpl.access$getActiveWindowContext$cp();
            if (r101 == null) goto L5;
            Context r102 = (Context) r101.get();
        L6:
            if (r102 != r100) goto L9;
            ToastHelperImpl.access$setActiveWindowContext$cp(null);
            return;
        L9:
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ToastHelperImpl() {
    }

    public static final /* synthetic */ WeakReference access$getActiveWindowContext$cp() {
        return activeWindowContext;
    }

    public static final /* synthetic */ void access$setActiveWindowContext$cp(WeakReference r100) {
        activeWindowContext = r100;
    }

    @Override // com.obric.assistant.common.spi.toast.IToastHelper
    public f createToastHolder(Context r100) {
        if (IWindowContextKt.isWindowContext(r100) == true) goto L5;
        return null;
    L5:
        return new WindowToastHolder();
    }

    @Override // com.obric.assistant.common.spi.toast.IToastHelper
    public Context resolveContext(Context r100) {
        if (r100 != null) goto L5;
        r100 = AppHost.f326268a.getApplication();
    L5:
        if (IWindowContextKt.isWindowContext(r100) == false) goto L7;
        return r100;
    L7:
        WeakReference<Context> r101 = activeWindowContext;
        if (r101 == null) goto L14;
        Context r102 = r101.get();
        if (r102 != null) goto L13;
        return r100;
    L13:
        return r102;
    L14:
        return r100;
    }

    @Override // com.obric.assistant.common.spi.toast.IToastHelper
    public /* bridge */ /* synthetic */ Object createToastHolder(Context r100) {
        return createToastHolder(r100);
    }
}
