package com.ss.android.ugc.effectmanager.model;

import com.larus.bmhome.share.panel.ShareType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\n\u00100\u001a\u0004\u0018\u00010\u0015H\u0016R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\r8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR$\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010%\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020$8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\u00020\u001e2\u0006\u0010\u0006\u001a\u00020\u001e8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R$\u0010-\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001a¨\u00061"}, d2 = {"Lcom/ss/android/ugc/effectmanager/model/ModelInfo;", "Lcom/ss/android/ugc/effectmanager/model/ModelInfoTemplate;", "Ljava/io/Serializable;", "kModelInfo", "Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;", "(Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;)V", "value", "Lcom/ss/android/ugc/effectmanager/model/ExtendedUrlModel;", "fileUrl", "getFileUrl", "()Lcom/ss/android/ugc/effectmanager/model/ExtendedUrlModel;", "setFileUrl", "(Lcom/ss/android/ugc/effectmanager/model/ExtendedUrlModel;)V", "Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", ShareType.FILE_URL, "getFile_url", "()Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "setFile_url", "(Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;)V", "getKModelInfo", "()Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "name_sec", "getName_sec", "setName_sec", "", "status", "getStatus", "()I", "setStatus", "(I)V", "", "totalSize", "getTotalSize", "()J", "setTotalSize", "(J)V", "type", "getType", "setType", "version", "getVersion", "setVersion", "getMD5", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class ModelInfo extends ModelInfoTemplate implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.algorithm.ModelInfo kModelInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelInfo() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.android.ugc.effectmanager.model.ModelInfoTemplate
    public ExtendedUrlModel getFileUrl() {
        return super.getFileUrl();
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel getFile_url() {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100 = getKModelInfo();
        if (r100 == null) goto L8;
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r101 = r100.getFile_url();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getFile_url();
    }

    @Override // com.ss.android.ugc.effectmanager.model.ModelInfoTemplate
    public String getMD5() {
        return super.getMD5();
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public String getName() {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100 = getKModelInfo();
        if (r100 == null) goto L8;
        String r101 = r100.getName();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getName();
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public String getName_sec() {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100 = getKModelInfo();
        if (r100 == null) goto L8;
        String r101 = r100.getName_sec();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getName_sec();
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public int getStatus() {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100 = getKModelInfo();
        if (r100 == null) goto L6;
        return r100.getStatus();
    L6:
        return super.getStatus();
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public long getTotalSize() {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100 = getKModelInfo();
        if (r100 == null) goto L6;
        return r100.getTotalSize();
    L6:
        return super.getTotalSize();
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public int getType() {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100 = getKModelInfo();
        if (r100 == null) goto L6;
        return r100.getType();
    L6:
        return super.getType();
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public String getVersion() {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100 = getKModelInfo();
        if (r100 == null) goto L8;
        String r101 = r100.getVersion();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getVersion();
    }

    @Override // com.ss.android.ugc.effectmanager.model.ModelInfoTemplate
    public com.ss.ugc.effectplatform.model.algorithm.ModelInfo getKModelInfo() {
        return this.kModelInfo;
    }

    public ModelInfo(com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100) {
        super(r100);
        this.kModelInfo = r100;
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r101 = getKModelInfo();
        if (r101 == null) goto L17;
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r102 = r101.getFile_url();
        if (r102 == null) goto L7;
        super.setFile_url(r102);
    L7:
        String r103 = r101.getName();
        if (r103 == null) goto L10;
        super.setName(r103);
    L10:
        String r104 = r101.getName_sec();
        if (r104 == null) goto L13;
        super.setName_sec(r104);
    L13:
        super.setStatus(r101.getStatus());
        super.setTotalSize(r101.getTotalSize());
        super.setType(r101.getType());
        String r105 = r101.getVersion();
        if (r105 == null) goto L18;
        super.setVersion(r105);
        return;
    L18:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.model.ModelInfoTemplate
    public void setFileUrl(ExtendedUrlModel r100) {
        super.setFileUrl(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public void setFile_url(com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100) {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r101 = getKModelInfo();
        if (r101 == null) goto L5;
        r101.setFile_url(r100);
    L5:
        super.setFile_url(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public void setName(String r100) {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r101 = getKModelInfo();
        if (r101 == null) goto L5;
        r101.setName(r100);
    L5:
        super.setName(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public void setName_sec(String r100) {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r101 = getKModelInfo();
        if (r101 == null) goto L5;
        r101.setName_sec(r100);
    L5:
        super.setName_sec(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public void setStatus(int r100) {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r101 = getKModelInfo();
        if (r101 == null) goto L5;
        r101.setStatus(r100);
    L5:
        super.setStatus(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public void setTotalSize(long r100) {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r101 = getKModelInfo();
        if (r101 == null) goto L5;
        r101.setTotalSize(r100);
    L5:
        super.setTotalSize(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public void setType(int r100) {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r101 = getKModelInfo();
        if (r101 == null) goto L5;
        r101.setType(r100);
    L5:
        super.setType(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ModelInfo
    public void setVersion(String r100) {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r101 = getKModelInfo();
        if (r101 == null) goto L5;
        r101.setVersion(r100);
    L5:
        super.setVersion(r100);
    }

    public /* synthetic */ ModelInfo(com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
