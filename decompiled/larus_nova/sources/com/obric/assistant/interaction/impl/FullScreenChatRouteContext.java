package com.obric.assistant.interaction.impl;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.product.platform.api.app.ObricActivityManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/interaction/impl/FullScreenChatRouteContext;", "Landroid/content/ContextWrapper;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "forceUseDefaultDisplay", "", "<init>", "(Landroid/content/Context;Z)V", "startActivity", "", "intent", "Landroid/content/Intent;", "options", "Landroid/os/Bundle;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullScreenChatRouteContext extends ContextWrapper {
    private static final Companion Companion = null;
    public static final String KEY_LAUNCH_DISPLAY_ID = "android.activity.launchDisplayId";
    private final boolean forceUseDefaultDisplay;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/impl/FullScreenChatRouteContext$Companion;", "", "<init>", "()V", "KEY_LAUNCH_DISPLAY_ID", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        startActivity(r100, null);
    }

    public FullScreenChatRouteContext(Context r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.forceUseDefaultDisplay = r101;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        w9a.a.f558792a.getClass();
        w9a.a.C8084a.a().getClass();
        ObricActivityManager.f385005a.b(r100);
        if (this.forceUseDefaultDisplay == true) goto L5;
    L10:
        FLogger.f375446a.i("FullScreenChatRouteContext", "start routed activity, defaultDisplay=" + this.forceUseDefaultDisplay);
        getBaseContext().startActivity(r100, r101);
        return;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        if (r101 == null) goto L8;
        r101 = new Bundle(r101);
    L9:
        r101.putInt(KEY_LAUNCH_DISPLAY_ID, 0);
        goto L10
    L8:
        r101 = new Bundle();
        goto L9
    }
}
