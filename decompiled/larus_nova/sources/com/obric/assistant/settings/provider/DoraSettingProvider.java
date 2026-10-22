package com.obric.assistant.settings.provider;

import android.os.Build;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/obric/assistant/settings/provider/DoraSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraSettingProvider implements IObricSettingProvider {

    public static final class a {
    }

    static {
    }

    public DoraSettingProvider() {
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
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_dora_entrance"));
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(com.obric.assistant.settings.spi.b r100, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r101) {
        return CollectionsKt.emptyList();
    }
}
