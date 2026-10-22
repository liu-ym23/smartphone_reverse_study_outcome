package com.obric.assistant.settings.provider;

import android.content.Context;
import com.larus.nova.R;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/settings/provider/AutoEndConversationSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoEndConversationSettingProvider implements IObricSettingProvider {
    public AutoEndConversationSettingProvider() {
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final List<com.obric.assistant.settings.spi.c> a(com.obric.assistant.settings.spi.b r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_auto_end_conversation"));
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(com.obric.assistant.settings.spi.b r110, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r111) {
        final Context r100 = r110.getHostContext();
        if (r100 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.a("group_auto_end_conversation", "auto_end_conversation", r100.getString(R.string.obric_setting_auto_end_conversation), 80, new e(), new f(r100), null, null, null, false, null, null, 8128));
    }
}
