package com.ss.android.lark.vfs;

import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0011\u001a\u0004\u0018\u0001H\u0012\"\u0004\b\u0000\u0010\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000bH\u0016J\u0017\u0010\u001c\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0012*\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0015\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/ss/android/lark/vfs/AbsVFSPath;", "Lcom/ss/android/lark/vfs/VFSPath;", "schemeFileSystem", "Lcom/ss/android/lark/vfs/FileSystem;", "<init>", "(Lcom/ss/android/lark/vfs/FileSystem;)V", "realPathTransformer", "Lcom/ss/android/lark/vfs/VFSPath$FinalPathTransformer;", "mKeyedTags", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getMKeyedTags", "()Ljava/util/HashMap;", "mKeyedTags$delegate", "Lkotlin/Lazy;", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "key", "(Ljava/lang/String;)Ljava/lang/Object;", "fileSystemChain", "getFileSystemChain", "()Lcom/ss/android/lark/vfs/FileSystem;", "fileSystemChain$delegate", "setTag", "", "tagObj", "getSchemeFileSystem", "getFileSystem", "getAbsolutePath", "setPathTransformer", "pathTransformer", "toString", "unistore_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AbsVFSPath implements VFSPath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile transient VFSPath.a f444799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Lazy f444800b;
    private final Lazy mKeyedTags$delegate;
    private final FileSystem schemeFileSystem;

    @Override // com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ String getName();

    @Override // com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ VFSPath getParent();

    @Override // com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ String getRealPath();

    @Override // com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ VFSPath getRoot();

    @Override // com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ boolean isParentOf(VFSPath r100);

    @Override // com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ boolean isRoot();

    @Override // com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ VFSPath subPath(String r100);

    @Override // com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ VFSFile toFile();

    @Override // com.ss.android.lark.vfs.VFSPath
    public abstract /* synthetic */ Uri toUri();

    @Override // com.ss.android.lark.vfs.VFSPath
    public String getAbsolutePath() {
        FileSystem r100 = (FileSystem) this.f444800b.getValue();
        VFSPath.a r101 = this.f444799a;
        if (r101 == null) goto L7;
        String r102 = r101.transform(getRealPath());
        if (r102 == null) goto L7;
        return r102;
    L7:
        return getRealPath();
    }

    @Override // com.ss.android.lark.vfs.VFSPath
    public FileSystem getFileSystem() {
        return (FileSystem) this.f444800b.getValue();
    }

    @Override // com.ss.android.lark.vfs.VFSPath
    public <T extends FileSystem> T getSchemeFileSystem() {
        T r100 = (T) this.schemeFileSystem;
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type T of com.ss.android.lark.vfs.AbsVFSPath.getSchemeFileSystem");
        return r100;
    }

    public String toString() {
        return getRealPath();
    }

    public AbsVFSPath(FileSystem r100) {
        Intrinsics.checkNotNullParameter(r100, "schemeFileSystem");
        this.schemeFileSystem = r100;
        this.mKeyedTags$delegate = LazyKt.lazy(AbsVFSPath$mKeyedTags$2.INSTANCE);
        this.f444800b = LazyKt.lazy(new AbsVFSPath$fileSystemChain$2(this));
    }

    public static final /* synthetic */ FileSystem access$getSchemeFileSystem$p(AbsVFSPath r100) {
        return r100.schemeFileSystem;
    }

    @Override // com.ss.android.lark.vfs.VFSPath
    public <T> T getTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return (T) ((HashMap) this.mKeyedTags$delegate.getValue()).get(r100);
    }

    @Override // com.ss.android.lark.vfs.VFSPath
    public void setPathTransformer(VFSPath.a r100) {
        Intrinsics.checkNotNullParameter(r100, "pathTransformer");
        this.f444799a = r100;
    }

    @Override // com.ss.android.lark.vfs.VFSPath
    public void setTag(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "tagObj");
        ((HashMap) this.mKeyedTags$delegate.getValue()).put(r100, r101);
    }
}
