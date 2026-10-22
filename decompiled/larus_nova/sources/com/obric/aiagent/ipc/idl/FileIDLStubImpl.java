package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import com.obric.aiagent.platform.depend.ILogDepend;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/obric/aiagent/ipc/idl/FileIDLStubImpl;", "Lcom/obric/aiagent/ipc/idl/IFileIDLSPI;", "<init>", "()V", "openFile", "Landroid/os/ParcelFileDescriptor;", "filePath", "Lcom/obric/aiagent/ipc/idl/FilePath;", "mode", "", "deleteFile", "", "listDir", "", "listAllFile", "ipc-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileIDLStubImpl implements IFileIDLSPI {
    public FileIDLStubImpl() {
    }

    public static /* synthetic */ FilePath a(FilePath r100, File r101, File r102) {
        return listAllFile$lambda$2(r100, r101, r102);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDLSPI, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public boolean deleteFile(FilePath r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        File r101 = r100.a();
        if (r101 != null) goto L7;
        ILogDepend.f384986a.e("FileIDLStubImpl", "Invalid path: " + r100);
        return false;
    L7:
        if (r101.exists() == true) goto L11;
        ILogDepend.f384986a.d("FileIDLStubImpl", "file " + r101.getPath() + " is not exists.");
        return false;
    L11:
        if (r101.isDirectory() == false) goto L13;
        boolean r102 = FilesKt.deleteRecursively(r101);
    L14:
        ILogDepend.f384986a.d("FileIDLStubImpl", "deleteFile " + r100 + " result " + r102);
        return r102;
    L13:
        r102 = r101.delete();
        goto L14
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List<FilePath> listAllFile(final FilePath r100) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        ILogDepend.Companion r101 = ILogDepend.f384986a;
        r101.d("FileIDLStubImpl", "listAllFile filePath " + r100.f384702b);
        final File r102 = r100.a();
        if (r102 == null) goto L5;
        r101.d("FileIDLStubImpl", "listAllFile localFile " + r102.getAbsoluteFile());
        if (r102.exists() == true) goto L9;
    L13:
        r101.d("FileIDLStubImpl", "localFile " + r102.getAbsoluteFile() + " is not exists or is not directory.");
        return CollectionsKt.emptyList();
    L9:
        if (r102.isDirectory() == false) goto L13;
        return SequencesKt.toList(SequencesKt.map(FilesKt.walkTopDown(r102), new d(r100, r102)));
    L5:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List<FilePath> listDir(FilePath r110) {
        Intrinsics.checkNotNullParameter(r110, "filePath");
        File r100 = r110.a();
        if (r100 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r100.exists() == false) goto L21;
        if (r100.isDirectory() == false) goto L21;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L16;
        ArrayList r102 = new ArrayList(r101.length);
        int r103 = r101.length;
        int r104 = 0;
    L14:
        if (r104 >= r103) goto L17;
        File r105 = r101[r104];
        int r106 = r110.f384701a;
        StringBuilder r107 = new StringBuilder();
        r107.append(r110.f384702b);
        r107.append('/');
        Intrinsics.checkNotNull(r105);
        r107.append(FilesKt.toRelativeString(r105, r100));
        r102.add(new FilePath(r106, r107.toString(), r105.isDirectory()));
        r104 = r104 + 1;
    L17:
        if (r102 == null) goto L19;
        return r102;
    L19:
        return CollectionsKt.emptyList();
    L16:
        r102 = null;
    L21:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public ParcelFileDescriptor openFile(FilePath r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "filePath");
        File r102 = r100.a();
        if (r102 != null) goto L6;
        return null;
    L6:
        if (r102.exists() == true) goto L8;
    L12:
        return null;
    L8:
        if (r102.isFile() == false) goto L12;
        return ParcelFileDescriptor.open(r102, r101);
    }

    private static final FilePath listAllFile$lambda$2(FilePath r100, File r101, File r102) {
        Intrinsics.checkNotNullParameter(r102, "it");
        return new FilePath(r100.f384701a, r100.f384702b + '/' + FilesKt.toRelativeString(r102, r101), r102.isDirectory());
    }
}
