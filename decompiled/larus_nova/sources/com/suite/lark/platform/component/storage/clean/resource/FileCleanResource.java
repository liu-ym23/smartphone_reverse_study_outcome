package com.suite.lark.platform.component.storage.clean.resource;

import android.content.Context;
import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.storage.clean.PersistentResource;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import voc.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0019\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/resource/FileCleanResource;", "Lcom/suite/lark/platform/component/storage/clean/PersistentResource;", "Lcom/suite/lark/platform/component/storage/clean/resource/HasFilePath;", "filePaths", "", "", "biz", "Lcom/ss/android/lark/diskmanage/Biz;", "<init>", "(Ljava/util/List;Lcom/ss/android/lark/diskmanage/Biz;)V", "filePath", "(Ljava/lang/String;Lcom/ss/android/lark/diskmanage/Biz;)V", "getFilePaths", "()Ljava/util/List;", "getBiz", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "toString", "equals", "", "other", "", "hashCode", "", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FileCleanResource implements PersistentResource, a {
    private final Biz biz;
    private final List<String> filePaths;

    @Override // com.suite.lark.platform.component.storage.clean.f
    public long progressWeight() {
        return 1;
    }

    public int hashCode() {
        return (this.filePaths.hashCode() * 31) + this.biz.hashCode();
    }

    public String toString() {
        return "paths:" + this.filePaths + ", biz:" + this.biz + ", weight:" + progressWeight();
    }

    public Biz getBiz() {
        return this.biz;
    }

    public final List<String> getFilePaths() {
        return this.filePaths;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileCleanResource) == true) goto L8;
        return false;
    L8:
        FileCleanResource r101 = (FileCleanResource) r100;
        if (Intrinsics.areEqual(this.filePaths, r101.filePaths) == true) goto L12;
        return false;
    L12:
        if (this.biz == r101.biz) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // voc.a
    public List<String> getFilePaths(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.filePaths;
    }

    public FileCleanResource(String r100, Biz r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        Intrinsics.checkNotNullParameter(r101, "biz");
        this(CollectionsKt.listOf(r100), r101);
    }

    public FileCleanResource(List<String> r100, Biz r101) {
        Intrinsics.checkNotNullParameter(r100, "filePaths");
        Intrinsics.checkNotNullParameter(r101, "biz");
        this.filePaths = r100;
        this.biz = r101;
    }
}
