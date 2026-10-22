package com.ss.android.ugc.effectmanager.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÖ\u0001R8\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078V@VX\u0096\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/model/UrlModelTemplate;", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "urlModel", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "value", "", "", "urlList", "urlList$annotations", "()V", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "getUrlModel", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "isValid", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class UrlModelTemplate extends com.ss.ugc.effectplatform.model.UrlModel implements Parcelable, Serializable {
    public static final Parcelable.Creator CREATOR = null;
    private List<String> urlList;
    private final transient com.ss.ugc.effectplatform.model.UrlModel urlModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static class Creator implements Parcelable.Creator {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            return new UrlModelTemplate((com.ss.ugc.effectplatform.model.UrlModel) r100.readParcelable(UrlModelTemplate.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new UrlModelTemplate[r100];
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UrlModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void urlList$annotations() {
    }

    @Override // com.ss.ugc.effectplatform.model.UrlModel, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.urlModel, r101);
    }

    public List<String> getUrlList() {
        com.ss.ugc.effectplatform.model.UrlModel r100 = getUrlModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_list();
    }

    public final boolean isValid() {
        List<String> r100 = getUrlList();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        return !r101;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L10
    }

    @Override // com.ss.ugc.effectplatform.model.UrlModel
    public String toString() {
        com.ss.ugc.effectplatform.model.UrlModel r100 = getUrlModel();
        if (r100 == null) goto L8;
        String r101 = r100.toString();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.toString();
    }

    public com.ss.ugc.effectplatform.model.UrlModel getUrlModel() {
        return this.urlModel;
    }

    public UrlModelTemplate(com.ss.ugc.effectplatform.model.UrlModel r100) {
        super(null, null, null, null, 15, null);
        this.urlModel = r100;
        this.urlList = new ArrayList();
    }

    public void setUrlList(List<String> r100) {
        this.urlList = r100;
        com.ss.ugc.effectplatform.model.UrlModel r101 = getUrlModel();
        if (r101 == null) goto L5;
        r101.setUrl_list(r100);
    L5:
        super.setUrl_list(r100);
    }

    public /* synthetic */ UrlModelTemplate(com.ss.ugc.effectplatform.model.UrlModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
