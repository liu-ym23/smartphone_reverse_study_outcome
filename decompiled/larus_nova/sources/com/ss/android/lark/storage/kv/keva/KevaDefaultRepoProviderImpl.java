package com.ss.android.lark.storage.kv.keva;

import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.keva.KevaConstants;
import com.ss.android.lark.storage.kv.repo.b;
import com.ss.android.lark.storage.kv.repo.e;
import javax.inject.Inject;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@ClaymoreImpl(b.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/storage/kv/keva/KevaDefaultRepoProviderImpl;", "Lcom/ss/android/lark/storage/kv/repo/DefaultRepoProvider;", "<init>", "()V", "getTypeName", "", "provideFactory", "Lcom/ss/android/lark/storage/kv/repo/RepoFactory;", "unistore-keva_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KevaDefaultRepoProviderImpl implements b {
    @Inject
    public KevaDefaultRepoProviderImpl() {
    }

    @Override // com.ss.android.lark.storage.kv.repo.b
    public String getTypeName() {
        return KevaConstants.TAG;
    }

    @Override // com.ss.android.lark.storage.kv.repo.b
    public e provideFactory() {
        return new a();
    }
}
