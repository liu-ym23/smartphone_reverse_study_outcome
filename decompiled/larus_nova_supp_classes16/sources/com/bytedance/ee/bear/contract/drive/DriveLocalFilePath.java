package com.bytedance.ee.bear.contract.drive;

import com.bytedance.ee.bear.diskmanager.Biz;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007J\b\u0010\f\u001a\u00020\u0001H\u0016J\b\u0010\r\u001a\u00020\u0007H\u0016R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/contract/drive/DriveLocalFilePath;", "Lcom/bytedance/ee/bear/contract/drive/DriveFilePath;", "", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "value", "", "localFilePath", "getLocalFilePath", "()Ljava/lang/String;", "filePath", "clone", "toString", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveLocalFilePath extends DriveFilePath implements Cloneable {
    private String localFilePath;

    public DriveLocalFilePath() {
        super(Biz.DRIVE, "", "", false);
        this.localFilePath = "";
    }

    public DriveFilePath clone() {
        return new DriveLocalFilePath().localFilePath(this.localFilePath);
    }

    @Override // com.bytedance.ee.bear.contract.drive.DriveFilePath
    public String toString() {
        return "DriveLocalFilePath(biz=" + getBiz() + ", relativePath='" + getRelativePath() + "', empty=" + getEmpty() + ", fileName='" + getFileName() + "', localFilePath='" + this.localFilePath + "')";
    }

    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m113clone() {
        return clone();
    }

    public final DriveLocalFilePath localFilePath(String r1) {
        if (r1 == null) goto L4;
        this.localFilePath = r1;
    L4:
        return this;
    }
}
