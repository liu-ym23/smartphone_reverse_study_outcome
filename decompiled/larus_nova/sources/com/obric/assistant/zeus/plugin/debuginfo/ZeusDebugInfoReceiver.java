package com.obric.assistant.zeus.plugin.debuginfo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.sharedstate.StateKey;
import com.obric.assistant.state.ObricSharedStateDelegate;
import com.obric.assistant.zeus.plugin.IZeusPluginService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gia.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/zeus/plugin/debuginfo/ZeusDebugInfoReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZeusDebugInfoReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f395043a = 0;

    public static final class a {
    }

    static {
    }

    public ZeusDebugInfoReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        AppHost.Companion r102 = AppHost.f326268a;
        Bundle r103 = r102.getApplication().getPackageManager().getApplicationInfo(r102.getApplication().getPackageName(), 128).metaData;
        Intrinsics.checkNotNull(r103);
        int r104 = r103.getInt("ZEUS_HOST_PROTOCOL_VERSION");
        ObricSharedStateDelegate r105 = ObricSharedStateDelegate.f392933c;
        Integer r106 = r105.b(StateKey.KEY_ZEUS_MEMORY_VERSION);
        int r107 = -1;
        if (r106 == null) goto L5;
        int r108 = r106.intValue();
    L6:
        Integer r109 = r105.b(StateKey.KEY_ZEUS_AIAGENT_VERSION);
        if (r109 == null) goto L9;
        r107 = r109.intValue();
    L9:
        b r110 = new b("com.obric.aiagent.plugin", r107);
        boolean r111 = true;
        List r112 = CollectionsKt.listOf(new b[]{new b("com.obric.memorydata.plugin", r108), r110});
        IZeusPluginService r113 = (IZeusPluginService) ServiceManager.get().getService(IZeusPluginService.class);
        if (r113 != null) goto L12;
    L14:
        r111 = false;
    L15:
        String r114 = com.larus.utils.gson.b.a(new gia.a(r104, r112, r111));
        FLogger.f375446a.i("ZeusDebugInfoReceiver", "generate debuginfo\n" + r114);
        setResult(0, r114, Bundle.EMPTY);
        return;
    L12:
        if (r113.e() != true) goto L14;
    L5:
        r108 = -1;
        goto L6
    }
}
