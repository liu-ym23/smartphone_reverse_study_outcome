package com.obric.assistant.settings.provider;

import android.content.Context;
import android.os.Build;
import com.larus.nova.R;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000bJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/settings/provider/LockedScreenUseSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVoicePrintManagementClick", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "view", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LockedScreenUseSettingProvider implements IObricSettingProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f392259a = 0;

    public static final class a {
    }

    static {
    }

    public LockedScreenUseSettingProvider() {
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final List<com.obric.assistant.settings.spi.c> a(com.obric.assistant.settings.spi.b r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        if (r100.getHostContext() != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_use_locked"));
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(final com.obric.assistant.settings.spi.b r110, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r111) {
        final Context r100 = r110.getHostContext();
        if (r100 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        ArrayList r101 = new ArrayList();
        r101.add(new com.obric.assistant.settings.spi.a("group_use_locked", "use_locked", r100.getString(R.string.obric_setting_use_locked), 100, new y0(this, r100, r110), new z0(r100), new a1(r100), new LockedScreenUseSettingProvider$getSettingItems$5(null), null, false, null, null, 7936));
        return r101;
    L9:
        return CollectionsKt.emptyList();
    }
}
