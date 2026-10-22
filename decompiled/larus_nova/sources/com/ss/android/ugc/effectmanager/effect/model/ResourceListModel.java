package com.ss.android.ugc.effectmanager.effect.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u000201B\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R(\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR(\u0010\u0016\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\rR0\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR0\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00192\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020 0\u00198V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR0\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00198V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b%\u0010\u001d\"\u0004\b&\u0010\u001fR0\u0010'\u001a\b\u0012\u0004\u0012\u00020\b0\u00192\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00198V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b(\u0010\u001d\"\u0004\b)\u0010\u001f¨\u00062"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/ResourceListModel;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/ResourceListModelTemplate;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "kResourceModel", "Lcom/ss/ugc/effectplatform/model/ResourceListModel;", "(Lcom/ss/ugc/effectplatform/model/ResourceListModel;)V", "value", "", "iconUri", "getIconUri", "()Ljava/lang/String;", "setIconUri", "(Ljava/lang/String;)V", "icon_uri", "getIcon_uri", "setIcon_uri", "getKResourceModel", "()Lcom/ss/ugc/effectplatform/model/ResourceListModel;", "param", "getParam", "setParam", "params", "getParams", "setParams", "", "Lcom/ss/android/ugc/effectmanager/effect/model/ResourceListModel$ResourceListBean;", "resourceList", "getResourceList", "()Ljava/util/List;", "setResourceList", "(Ljava/util/List;)V", "Lcom/ss/ugc/effectplatform/model/ResourceListModel$ResourceListBean;", "resource_list", "getResource_list", "setResource_list", "urlPrefix", "getUrlPrefix", "setUrlPrefix", "url_prefix", "getUrl_prefix", "setUrl_prefix", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "ResourceListBean", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public final class ResourceListModel extends ResourceListModelTemplate implements Serializable, Parcelable {
    public static final Parcelable.Creator<ResourceListModel> CREATOR = null;
    public static final Companion Companion = null;
    private final transient com.ss.ugc.effectplatform.model.ResourceListModel kResourceModel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/ResourceListModel$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/effectmanager/effect/model/ResourceListModel;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001eB\u0011\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR(\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR(\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f¨\u0006\u001f"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/ResourceListModel$ResourceListBean;", "Lcom/ss/android/ugc/effectmanager/effect/model/template/ResourceListModelTemplate$ResourceListBeanTemplate;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "kResourceBean", "Lcom/ss/ugc/effectplatform/model/ResourceListModel$ResourceListBean;", "(Lcom/ss/ugc/effectplatform/model/ResourceListModel$ResourceListBean;)V", "getKResourceBean", "()Lcom/ss/ugc/effectplatform/model/ResourceListModel$ResourceListBean;", "value", "", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "resourceUrl", "getResourceUrl", "setResourceUrl", "resource_uri", "getResource_uri", "setResource_uri", "getValue", "setValue", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "", "Companion", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static final class ResourceListBean extends ResourceListModelTemplate.ResourceListBeanTemplate implements Serializable, Parcelable {
        public static final Parcelable.Creator<ResourceListBean> CREATOR = null;
        public static final Companion Companion = null;
        private final transient com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean kResourceBean;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/ResourceListModel$ResourceListBean$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/effectmanager/effect/model/ResourceListModel$ResourceListBean;", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ResourceListBean() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        static {
            Companion = new Companion(null);
            CREATOR = new ResourceListModel$ResourceListBean$Companion$CREATOR$1();
        }

        @Override // com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean
        public String getName() {
            com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean r100 = getKResourceBean();
            if (r100 == null) goto L8;
            String r101 = r100.getName();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getName();
        }

        @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate.ResourceListBeanTemplate
        public String getResourceUrl() {
            return super.getResourceUrl();
        }

        @Override // com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean
        public String getResource_uri() {
            com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean r100 = getKResourceBean();
            if (r100 == null) goto L8;
            String r101 = r100.getResource_uri();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getResource_uri();
        }

        @Override // com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean
        public String getValue() {
            com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean r100 = getKResourceBean();
            if (r100 == null) goto L8;
            String r101 = r100.getValue();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getValue();
        }

        @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate.ResourceListBeanTemplate
        public com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean getKResourceBean() {
            return this.kResourceBean;
        }

        public ResourceListBean(com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean r100) {
            super(r100);
            this.kResourceBean = r100;
            com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean r101 = getKResourceBean();
            if (r101 == null) goto L14;
            String r102 = r101.getName();
            if (r102 == null) goto L7;
            super.setName(r102);
        L7:
            String r103 = r101.getResource_uri();
            if (r103 == null) goto L10;
            super.setResource_uri(r103);
        L10:
            String r104 = r101.getValue();
            if (r104 == null) goto L15;
            super.setValue(r104);
            return;
        L15:
            return;
        }

        @Override // com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean
        public void setName(String r100) {
            com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean r101 = getKResourceBean();
            if (r101 == null) goto L5;
            r101.setName(r100);
        L5:
            super.setName(r100);
        }

        @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate.ResourceListBeanTemplate
        public void setResourceUrl(String r100) {
            super.setResourceUrl(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean
        public void setResource_uri(String r100) {
            com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean r101 = getKResourceBean();
            if (r101 == null) goto L5;
            r101.setResource_uri(r100);
        L5:
            super.setResource_uri(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean
        public void setValue(String r100) {
            com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean r101 = getKResourceBean();
            if (r101 == null) goto L5;
            r101.setValue(r100);
        L5:
            super.setValue(r100);
        }

        @Override // com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            if (getKResourceBean() == null) goto L7;
            com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean r102 = getKResourceBean();
            if (r102 == null) goto L9;
            r102.writeToParcel(r100, r101);
            return;
        L9:
            return;
        L7:
            super.writeToParcel(r100, r101);
        }

        public /* synthetic */ ResourceListBean(com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceListModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    static {
        Companion = new Companion(null);
        CREATOR = new ResourceListModel$Companion$CREATOR$1();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate
    public String getIconUri() {
        return super.getIconUri();
    }

    @Override // com.ss.ugc.effectplatform.model.ResourceListModel
    public String getIcon_uri() {
        com.ss.ugc.effectplatform.model.ResourceListModel r100 = getKResourceModel();
        if (r100 == null) goto L8;
        String r101 = r100.getIcon_uri();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getIcon_uri();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate
    public String getParam() {
        return super.getParam();
    }

    @Override // com.ss.ugc.effectplatform.model.ResourceListModel
    public String getParams() {
        com.ss.ugc.effectplatform.model.ResourceListModel r100 = getKResourceModel();
        if (r100 == null) goto L8;
        String r101 = r100.getParams();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getParams();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate
    public List<ResourceListBean> getResourceList() {
        return super.getResourceList();
    }

    @Override // com.ss.ugc.effectplatform.model.ResourceListModel
    public List<com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean> getResource_list() {
        com.ss.ugc.effectplatform.model.ResourceListModel r100 = getKResourceModel();
        if (r100 == null) goto L8;
        List<com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean> r101 = r100.getResource_list();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getResource_list();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate
    public List<String> getUrlPrefix() {
        return super.getUrlPrefix();
    }

    @Override // com.ss.ugc.effectplatform.model.ResourceListModel
    public List<String> getUrl_prefix() {
        com.ss.ugc.effectplatform.model.ResourceListModel r100 = getKResourceModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate
    public com.ss.ugc.effectplatform.model.ResourceListModel getKResourceModel() {
        return this.kResourceModel;
    }

    public ResourceListModel(com.ss.ugc.effectplatform.model.ResourceListModel r100) {
        super(r100);
        this.kResourceModel = r100;
        com.ss.ugc.effectplatform.model.ResourceListModel r101 = getKResourceModel();
        if (r101 == null) goto L17;
        String r102 = r101.getIcon_uri();
        if (r102 == null) goto L7;
        super.setIcon_uri(r102);
    L7:
        String r103 = r101.getParams();
        if (r103 == null) goto L10;
        super.setParams(r103);
    L10:
        List<com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean> r104 = r101.getResource_list();
        if (r104 == null) goto L13;
        super.setResource_list(r104);
    L13:
        List<String> r105 = r101.getUrl_prefix();
        if (r105 == null) goto L18;
        super.setUrl_prefix(r105);
        return;
    L18:
        return;
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate
    public void setIconUri(String r100) {
        super.setIconUri(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ResourceListModel
    public void setIcon_uri(String r100) {
        com.ss.ugc.effectplatform.model.ResourceListModel r101 = getKResourceModel();
        if (r101 == null) goto L5;
        r101.setIcon_uri(r100);
    L5:
        super.setIcon_uri(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate
    public void setParam(String r100) {
        super.setParam(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ResourceListModel
    public void setParams(String r100) {
        com.ss.ugc.effectplatform.model.ResourceListModel r101 = getKResourceModel();
        if (r101 == null) goto L5;
        r101.setParams(r100);
    L5:
        super.setParams(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate
    public void setResourceList(List<ResourceListBean> r100) {
        super.setResourceList(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ResourceListModel
    public void setResource_list(List<? extends com.ss.ugc.effectplatform.model.ResourceListModel.ResourceListBean> r100) {
        com.ss.ugc.effectplatform.model.ResourceListModel r101 = getKResourceModel();
        if (r101 == null) goto L5;
        r101.setResource_list(r100);
    L5:
        super.setResource_list(r100);
    }

    @Override // com.ss.android.ugc.effectmanager.effect.model.template.ResourceListModelTemplate
    public void setUrlPrefix(List<String> r100) {
        super.setUrlPrefix(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ResourceListModel
    public void setUrl_prefix(List<String> r100) {
        com.ss.ugc.effectplatform.model.ResourceListModel r101 = getKResourceModel();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    @Override // com.ss.ugc.effectplatform.model.ResourceListModel, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        if (getKResourceModel() == null) goto L7;
        com.ss.ugc.effectplatform.model.ResourceListModel r102 = getKResourceModel();
        if (r102 == null) goto L9;
        r102.writeToParcel(r100, r101);
        return;
    L9:
        return;
    L7:
        super.writeToParcel(r100, r101);
    }

    public /* synthetic */ ResourceListModel(com.ss.ugc.effectplatform.model.ResourceListModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
