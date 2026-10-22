package com.ss.android.ugc.effectmanager.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 '2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001'B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001cH\u0016R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR0\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R0\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016R(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001c8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006("}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/model/UrlModel;", "Lcom/ss/android/ugc/effectmanager/common/model/UrlModelTemplate;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "urlModel", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "value", "", "md5", "getMd5", "()Ljava/lang/String;", "setMd5", "(Ljava/lang/String;)V", "uri", "getUri", "setUri", "", "urlList", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "getUrlModel", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", ScoreTags.STAR_URL_LIST, "getUrl_list", "setUrl_list", "", "url_type", "getUrl_type", "()Ljava/lang/Integer;", "setUrl_type", "(Ljava/lang/Integer;)V", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class UrlModel extends UrlModelTemplate {
    public static final Parcelable.Creator<UrlModel> CREATOR = null;
    public static final Companion Companion = null;
    private final transient com.ss.ugc.effectplatform.model.UrlModel urlModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/model/UrlModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/effectmanager/common/model/UrlModel;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UrlModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    static {
        Companion = new Companion(null);
        CREATOR = new UrlModel$Companion$CREATOR$1();
    }

    @Override // com.ss.ugc.effectplatform.model.UrlModel
    public String getMd5() {
        com.ss.ugc.effectplatform.model.UrlModel r100 = getUrlModel();
        if (r100 == null) goto L8;
        String r101 = r100.getMd5();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getMd5();
    }

    @Override // com.ss.ugc.effectplatform.model.UrlModel
    public String getUri() {
        com.ss.ugc.effectplatform.model.UrlModel r100 = getUrlModel();
        if (r100 == null) goto L8;
        String r101 = r100.getUri();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUri();
    }

    @Override // com.ss.android.ugc.effectmanager.common.model.UrlModelTemplate
    public List<String> getUrlList() {
        return super.getUrlList();
    }

    @Override // com.ss.ugc.effectplatform.model.UrlModel
    public List<String> getUrl_list() {
        com.ss.ugc.effectplatform.model.UrlModel r100 = getUrlModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_list();
    }

    @Override // com.ss.ugc.effectplatform.model.UrlModel
    public Integer getUrl_type() {
        com.ss.ugc.effectplatform.model.UrlModel r100 = getUrlModel();
        if (r100 == null) goto L8;
        Integer r101 = r100.getUrl_type();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_type();
    }

    @Override // com.ss.android.ugc.effectmanager.common.model.UrlModelTemplate
    public com.ss.ugc.effectplatform.model.UrlModel getUrlModel() {
        return this.urlModel;
    }

    public UrlModel(com.ss.ugc.effectplatform.model.UrlModel r100) {
        super(r100);
        this.urlModel = r100;
        com.ss.ugc.effectplatform.model.UrlModel r101 = getUrlModel();
        if (r101 == null) goto L17;
        String r102 = r101.getMd5();
        if (r102 == null) goto L7;
        super.setMd5(r102);
    L7:
        String r103 = r101.getUri();
        if (r103 == null) goto L10;
        super.setUri(r103);
    L10:
        List<String> r104 = r101.getUrl_list();
        if (r104 == null) goto L13;
        super.setUrl_list(r104);
    L13:
        Integer r105 = r101.getUrl_type();
        if (r105 == null) goto L18;
        super.setUrl_type(Integer.valueOf(r105.intValue()));
        return;
    L18:
        return;
    }

    @Override // com.ss.ugc.effectplatform.model.UrlModel
    public void setMd5(String r100) {
        com.ss.ugc.effectplatform.model.UrlModel r101 = getUrlModel();
        if (r101 == null) goto L5;
        r101.setMd5(r100);
    L5:
        super.setMd5(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.UrlModel
    public void setUri(String r100) {
        com.ss.ugc.effectplatform.model.UrlModel r101 = getUrlModel();
        if (r101 == null) goto L5;
        r101.setUri(r100);
    L5:
        super.setUri(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.common.model.UrlModelTemplate
    public void setUrlList(List<String> r100) {
        super.setUrlList(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.UrlModel
    public void setUrl_list(List<String> r100) {
        com.ss.ugc.effectplatform.model.UrlModel r101 = getUrlModel();
        if (r101 == null) goto L5;
        r101.setUrl_list(r100);
    L5:
        super.setUrl_list(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.UrlModel
    public void setUrl_type(Integer r100) {
        com.ss.ugc.effectplatform.model.UrlModel r101 = getUrlModel();
        if (r101 == null) goto L5;
        r101.setUrl_type(r100);
    L5:
        super.setUrl_type(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.common.model.UrlModelTemplate, com.ss.ugc.effectplatform.model.UrlModel, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        if (getUrlModel() == null) goto L7;
        com.ss.ugc.effectplatform.model.UrlModel r102 = getUrlModel();
        if (r102 == null) goto L9;
        r102.writeToParcel(r100, r101);
        return;
    L9:
        return;
    L7:
        super.writeToParcel(r100, r101);
    }

    public /* synthetic */ UrlModel(com.ss.ugc.effectplatform.model.UrlModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
