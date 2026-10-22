package com.suite.lark.platform.component.storage.clean.resource;

import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.storage.kv.repo.KVRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/resource/KVRepoFileResource;", "Lcom/suite/lark/platform/component/storage/clean/resource/FileCleanResource;", "kvRepo", "Lcom/ss/android/lark/storage/kv/repo/KVRepo;", "biz", "Lcom/ss/android/lark/diskmanage/Biz;", "<init>", "(Lcom/ss/android/lark/storage/kv/repo/KVRepo;Lcom/ss/android/lark/diskmanage/Biz;)V", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KVRepoFileResource extends FileCleanResource {
    public KVRepoFileResource(KVRepo r100, Biz r101) {
        Intrinsics.checkNotNullParameter(r100, "kvRepo");
        Intrinsics.checkNotNullParameter(r101, "biz");
        super(r100.getFilePaths(), r101);
    }
}
