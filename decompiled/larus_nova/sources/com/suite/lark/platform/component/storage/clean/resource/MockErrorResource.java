package com.suite.lark.platform.component.storage.clean.resource;

import com.ss.android.lark.diskmanage.Biz;
import com.suite.lark.platform.component.storage.clean.PersistentResource;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/resource/MockErrorResource;", "Lcom/suite/lark/platform/component/storage/clean/PersistentResource;", "<init>", "()V", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MockErrorResource implements PersistentResource {
    public MockErrorResource() {
    }

    @Override // com.suite.lark.platform.component.storage.clean.f
    public long progressWeight() {
        return 1;
    }

    public Biz getBiz() {
        return Biz.DEFAULT;
    }
}
