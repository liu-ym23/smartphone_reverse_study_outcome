package com.ss.android.ugc.effectmanager.model;

import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R0\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R0\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u000f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/ss/android/ugc/effectmanager/model/ExtendedUrlModel;", "Lcom/ss/android/ugc/effectmanager/model/ExtendedUrlModelTemplate;", "Ljava/io/Serializable;", "kUrlModel", "Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "(Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;)V", "getKUrlModel", "()Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "value", "", "uri", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "", "urlList", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", ScoreTags.STAR_URL_LIST, "getUrl_list", "setUrl_list", "zipUrlList", "getZipUrlList", "setZipUrlList", "zip_url_list", "getZip_url_list", "setZip_url_list", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class ExtendedUrlModel extends ExtendedUrlModelTemplate {
    private final transient com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel kUrlModel;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtendedUrlModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel
    public String getUri() {
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100 = getKUrlModel();
        if (r100 == null) goto L8;
        String r101 = r100.getUri();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUri();
    }

    @Override // com.ss.android.ugc.effectmanager.model.ExtendedUrlModelTemplate
    public List<String> getUrlList() {
        return super.getUrlList();
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel
    public List<String> getUrl_list() {
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100 = getKUrlModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_list();
    }

    @Override // com.ss.android.ugc.effectmanager.model.ExtendedUrlModelTemplate
    public List<String> getZipUrlList() {
        return super.getZipUrlList();
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel
    public List<String> getZip_url_list() {
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100 = getKUrlModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getZip_url_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getZip_url_list();
    }

    @Override // com.ss.android.ugc.effectmanager.model.ExtendedUrlModelTemplate
    public com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel getKUrlModel() {
        return this.kUrlModel;
    }

    public ExtendedUrlModel(com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100) {
        super(r100);
        this.kUrlModel = r100;
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r101 = getKUrlModel();
        if (r101 == null) goto L14;
        String r102 = r101.getUri();
        if (r102 == null) goto L7;
        super.setUri(r102);
    L7:
        List<String> r103 = r101.getUrl_list();
        if (r103 == null) goto L10;
        super.setUrl_list(r103);
    L10:
        List<String> r104 = r101.getZip_url_list();
        if (r104 == null) goto L15;
        super.setZip_url_list(r104);
        return;
    L15:
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel
    public void setUri(String r100) {
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r101 = getKUrlModel();
        if (r101 == null) goto L5;
        r101.setUri(r100);
    L5:
        super.setUri(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.model.ExtendedUrlModelTemplate
    public void setUrlList(List<String> r100) {
        super.setUrlList(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel
    public void setUrl_list(List<String> r100) {
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r101 = getKUrlModel();
        if (r101 == null) goto L5;
        r101.setUrl_list(r100);
    L5:
        super.setUrl_list(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.model.ExtendedUrlModelTemplate
    public void setZipUrlList(List<String> r100) {
        super.setZipUrlList(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel
    public void setZip_url_list(List<String> r100) {
        com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r101 = getKUrlModel();
        if (r101 == null) goto L5;
        r101.setZip_url_list(r100);
    L5:
        super.setZip_url_list(r100);
    }

    public /* synthetic */ ExtendedUrlModel(com.ss.ugc.effectplatform.model.algorithm.ExtendedUrlModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
