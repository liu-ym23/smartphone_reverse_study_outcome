package com.bytedance.gkfs.io;

import com.bytedance.gkfs.GeckoFileSystem;
import java.io.File;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSFile;", "Ljava/io/File;", "path", "", "(Ljava/lang/String;)V", "delete", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
public final class GkFSFile extends File {
    @Override // java.io.File
    public boolean delete() {
        return GeckoFileSystem.f245106f.delete(this);
    }

    public GkFSFile(String r100) {
        super(r100);
    }
}
