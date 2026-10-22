package com.ss.android.lark.filedetail.impl.folder.manage.service;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@AppConfig(key = "lark_messenger_file")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/filedetail/impl/folder/manage/service/FileConfigValue;", "", "extractConfig", "Lcom/ss/android/lark/filedetail/impl/folder/manage/service/ExtractPackageConfig;", "<init>", "(Lcom/ss/android/lark/filedetail/impl/folder/manage/service/ExtractPackageConfig;)V", "getExtractConfig", "()Lcom/ss/android/lark/filedetail/impl/folder/manage/service/ExtractPackageConfig;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "file-detail-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileConfigValue {

    @SerializedName("extract_package")
    private final ExtractPackageConfig extractConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public FileConfigValue() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FileConfigValue copy$default(FileConfigValue r100, ExtractPackageConfig r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.extractConfig;
    L6:
        return r100.copy(r101);
    }

    public final ExtractPackageConfig component1() {
        return this.extractConfig;
    }

    public final FileConfigValue copy(ExtractPackageConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "extractConfig");
        return new FileConfigValue(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FileConfigValue) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.extractConfig, ((FileConfigValue) r100).extractConfig) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.extractConfig.hashCode();
    }

    public String toString() {
        return "FileConfigValue(extractConfig=" + this.extractConfig + ')';
    }

    public final ExtractPackageConfig getExtractConfig() {
        return this.extractConfig;
    }

    public FileConfigValue(ExtractPackageConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "extractConfig");
        this.extractConfig = r100;
    }

    public /* synthetic */ FileConfigValue(ExtractPackageConfig r100, int r101, DefaultConstructorMarker r110) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new ExtractPackageConfig(0, null, 0, 7, null);
    L5:
        this(r100);
    }
}
