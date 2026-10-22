package com.larus.uaigc.chat.markdown;

import com.larus.business.markdown.api.depend.a;
import com.larus.platform.spi.MarkdownDataHandlersProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, d2 = {"Lcom/larus/uaigc/chat/markdown/CreationDataHandlerProvider;", "Lcom/larus/platform/spi/MarkdownDataHandlersProvider;", "<init>", "()V", "getCustomDataHandlers", "", "Lcom/larus/business/markdown/api/depend/ICustomDataHandler;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationDataHandlerProvider implements MarkdownDataHandlersProvider {
    public CreationDataHandlerProvider() {
    }

    @Override // com.larus.platform.spi.MarkdownDataHandlersProvider
    public final List<a> a() {
        return CollectionsKt.listOf(new dz9.a());
    }
}
