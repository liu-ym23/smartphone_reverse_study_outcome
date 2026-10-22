package com.larus.ugc.feed.impl.spi;

import com.larus.ugc.feed.api.spi.ITemplateCreationFragmentFactory;
import com.larus.ugc.feed.impl.template.TemplateCreationFragment;
import kotlin.Metadata;
import zp9.m;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/larus/ugc/feed/impl/spi/TemplateCreationFragmentFactoryImpl;", "Lcom/larus/ugc/feed/api/spi/ITemplateCreationFragmentFactory;", "<init>", "()V", "create", "Landroidx/fragment/app/Fragment;", "interceptor", "Lcom/larus/platform/api/creation/ICreationFeedActionInterceptor;", "feed_kmp_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TemplateCreationFragmentFactoryImpl implements ITemplateCreationFragmentFactory {
    public TemplateCreationFragmentFactoryImpl() {
    }

    @Override // com.larus.ugc.feed.api.spi.ITemplateCreationFragmentFactory
    public final TemplateCreationFragment a(m r100) {
        TemplateCreationFragment r101 = new TemplateCreationFragment();
        r101.f374923w = r100;
        return r101;
    }
}
