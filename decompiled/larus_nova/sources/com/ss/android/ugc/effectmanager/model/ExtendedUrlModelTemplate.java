package com.ss.android.ugc.effectmanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R2\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/effectmanager/model/ExtendedUrlModelTemplate;", "Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "Ljava/io/Serializable;", "kUrlModel", "(Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;)V", "getKUrlModel", "()Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "value", "", "", "urlList", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "zipUrlList", "getZipUrlList", "setZipUrlList", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class ExtendedUrlModelTemplate extends com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel implements Serializable {
    private final transient com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel kUrlModel;
    private List<String> urlList;
    private List<String> zipUrlList;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtendedUrlModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public List<String> getUrlList() {
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100 = getKUrlModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_list();
    }

    public List<String> getZipUrlList() {
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100 = getKUrlModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getZip_url_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getZip_url_list();
    }

    public com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel getKUrlModel() {
        return this.kUrlModel;
    }

    public ExtendedUrlModelTemplate(com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100) {
        super(null, null, null, 7, null);
        this.kUrlModel = r100;
        this.zipUrlList = new ArrayList();
        this.urlList = new ArrayList();
    }

    public void setUrlList(List<String> r100) {
        this.urlList = r100;
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r101 = getKUrlModel();
        if (r101 == null) goto L5;
        r101.setUrl_list(r100);
    L5:
        super.setUrl_list(r100);
    }

    public void setZipUrlList(List<String> r100) {
        this.zipUrlList = r100;
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r101 = getKUrlModel();
        if (r101 == null) goto L5;
        r101.setZip_url_list(r100);
    L5:
        super.setZip_url_list(r100);
    }

    public /* synthetic */ ExtendedUrlModelTemplate(com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
