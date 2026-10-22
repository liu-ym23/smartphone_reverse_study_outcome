package com.ss.android.ugc.effectmanager.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R*\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/model/ModelInfoTemplate;", "Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;", "kModelInfo", "(Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;)V", "value", "Lcom/ss/android/ugc/effectmanager/model/ExtendedUrlModel;", "fileUrl", "getFileUrl", "()Lcom/ss/android/ugc/effectmanager/model/ExtendedUrlModel;", "setFileUrl", "(Lcom/ss/android/ugc/effectmanager/model/ExtendedUrlModel;)V", "getKModelInfo", "()Lcom/ss/ugc/effectplatform/model/algorithm/ModelInfo;", "getMD5", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class ModelInfoTemplate extends com.ss.ugc.effectplatform.model.algorithm.ModelInfo {
    private ExtendedUrlModel fileUrl;
    private final transient com.ss.ugc.effectplatform.model.algorithm.ModelInfo kModelInfo;

    /* JADX WARN: Multi-variable type inference failed */
    public ModelInfoTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ExtendedUrlModel getFileUrl() {
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100 = getKModelInfo();
        if (r100 == null) goto L7;
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r101 = r100.getFile_url();
        if (r101 == null) goto L7;
    L9:
        return new ExtendedUrlModel(r101);
    L7:
        r101 = super.getFile_url();
        goto L9
    }

    public String getMD5() {
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100 = getFile_url();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getUri();
    }

    public com.ss.ugc.effectplatform.model.algorithm.ModelInfo getKModelInfo() {
        return this.kModelInfo;
    }

    public ModelInfoTemplate(com.ss.ugc.effectplatform.model.algorithm.ModelInfo r110) {
        super(null, null, null, null, 0, 0, 0, 127, null);
        this.kModelInfo = r110;
    }

    public void setFileUrl(ExtendedUrlModel r100) {
        this.fileUrl = r100;
        com.ss.ugc.effectplatform.model.algorithm.ModelInfo r101 = getKModelInfo();
        if (r101 == null) goto L5;
        r101.setFile_url(r100);
    L5:
        super.setFile_url(r100);
    }

    public /* synthetic */ ModelInfoTemplate(com.ss.ugc.effectplatform.model.algorithm.ModelInfo r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
