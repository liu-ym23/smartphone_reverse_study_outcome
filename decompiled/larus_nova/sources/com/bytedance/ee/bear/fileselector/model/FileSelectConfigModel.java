package com.bytedance.ee.bear.fileselector.model;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\b\u0010\t\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/fileselector/model/FileSelectConfigModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "mFileSelectConfig", "Lcom/bytedance/ee/bear/fileselector/api/FileSelectConfig;", "setFileSelectConfig", "", "config", "getFileSelectConfig", "framework-file-selector_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileSelectConfigModel extends ViewModel {
    private FileSelectConfig mFileSelectConfig;

    public FileSelectConfigModel() {
    }

    public final FileSelectConfig getFileSelectConfig() {
        return this.mFileSelectConfig;
    }

    public final void setFileSelectConfig(FileSelectConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.mFileSelectConfig = r100;
    }
}
