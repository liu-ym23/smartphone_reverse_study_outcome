package com.ss.android.lark.chameleon;

import com.ss.android.lark.vfs.VFSPath;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H'J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH'¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleon/ChameleonResourceLoadCallback;", "", "onLoadSuccess", "", "path", "Lcom/ss/android/lark/vfs/VFSPath;", "version", "", "onLoadFail", "code", "", "e", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ChameleonResourceLoadCallback {
    void onLoadFail(int r100, Throwable r101);

    void onLoadSuccess(VFSPath r100, String r101);
}
