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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\t\u001a\u00020\nH\u0096@¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/settings/provider/VoiceWakeupSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "shouldHideMigratedSwitch", "", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVoiceWakeupChange", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isChecked", "view", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceWakeupSettingProvider implements IObricSettingProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f392267a = 0;

    public static final class a {
    }

    static {
    }

    public VoiceWakeupSettingProvider() {
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
        if (ega.a.a() == true) goto L15;
        return CollectionsKt.emptyList();
    L15:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_voice"));
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(final com.obric.assistant.settings.spi.b r110, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r111) {
        final Context r100 = r110.getHostContext();
        if (r100 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (ega.a.a() == false) goto L13;
        ArrayList r101 = new ArrayList();
        String r102 = r100.getString(R.string.obric_setting_wakeup);
        String r112 = r100.getString(R.string.obric_setting_wakeup_hint);
        r101.add(new com.obric.assistant.settings.spi.f("group_voice", "voice_wakeup", r102, 100, new x1(), new y1(this, r100, r110), r112, new VoiceWakeupSettingProvider$getSettingItems$4(null), false, null, null, null, 16128));
        return r101;
    L13:
        return CollectionsKt.emptyList();
    }
}
