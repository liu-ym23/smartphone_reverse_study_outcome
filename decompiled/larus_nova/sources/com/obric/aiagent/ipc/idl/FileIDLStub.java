package com.obric.aiagent.ipc.idl;

import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0019\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J3\u0010\f\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000e \u000b*\u000b\u0012\u0002\b\u0003\u0018\u00010\u000f¨\u0006\u00010\r¨\u0006\u00012\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J3\u0010\u0010\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u000e \u000b*\u000b\u0012\u0002\b\u0003\u0018\u00010\u000f¨\u0006\u00010\r¨\u0006\u00012\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nH\u0096\u0001J)\u0010\u0011\u001a\n \u000b*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0096\u0001¨\u0006\u0015"}, d2 = {"Lcom/obric/aiagent/ipc/idl/FileIDLStub;", "Lcom/obric/aiagent/ipc/idl/IFileIDL$Stub;", "Lcom/obric/aiagent/ipc/idl/IFileIDL;", "<init>", "()V", "asBinder", "Landroid/os/IBinder;", "deleteFile", "", "filePath", "Lcom/obric/aiagent/ipc/idl/FilePath;", "kotlin.jvm.PlatformType", "listAllFile", "", "", "", "listDir", "openFile", "Landroid/os/ParcelFileDescriptor;", "mode", "", "ipc-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FileIDLStub extends IFileIDL.Stub {
    private final /* synthetic */ IFileIDL $$delegate_0;

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public boolean deleteFile(FilePath r100) {
        return this.$$delegate_0.deleteFile(r100);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listAllFile(FilePath r100) {
        return this.$$delegate_0.listAllFile(r100);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public List listDir(FilePath r100) {
        return this.$$delegate_0.listDir(r100);
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL
    public ParcelFileDescriptor openFile(FilePath r100, int r101) {
        return this.$$delegate_0.openFile(r100, r101);
    }

    public FileIDLStub() {
        IFileIDL r100 = (IFileIDLSPI) ServiceManager.get().getService(IFileIDLSPI.class);
        if (r100 != null) goto L6;
        r100 = new IFileIDL.Default();
    L6:
        this.$$delegate_0 = r100;
    }

    @Override // com.obric.aiagent.ipc.idl.IFileIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        return super.asBinder();
    }
}
