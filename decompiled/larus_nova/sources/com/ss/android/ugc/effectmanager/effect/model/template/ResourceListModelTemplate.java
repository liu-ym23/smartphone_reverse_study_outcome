package com.ss.android.ugc.effectmanager.effect.model.template;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.ugc.effectplatform.model.ResourceListModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R*\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR*\u0010\r\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00058V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R2\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/ResourceListModelTemplate;", "Lcom/ss/ugc/effectplatform/model/ResourceListModel;", "kResourceModel", "(Lcom/ss/ugc/effectplatform/model/ResourceListModel;)V", "value", "", "iconUri", "getIconUri", "()Ljava/lang/String;", "setIconUri", "(Ljava/lang/String;)V", "getKResourceModel", "()Lcom/ss/ugc/effectplatform/model/ResourceListModel;", "param", "getParam", "setParam", "", "Lcom/ss/android/ugc/effectmanager/effect/model/ResourceListModel$ResourceListBean;", "resourceList", "getResourceList", "()Ljava/util/List;", "setResourceList", "(Ljava/util/List;)V", "urlPrefix", "getUrlPrefix", "setUrlPrefix", "ResourceListBeanTemplate", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public class ResourceListModelTemplate extends ResourceListModel {
    private String iconUri;
    private final transient ResourceListModel kResourceModel;
    private String param;
    private List<com.ss.android.ugc.effectmanager.effect.model.ResourceListModel.ResourceListBean> resourceList;
    private List<String> urlPrefix;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R*\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00078V@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/effectmanager/effect/model/template/ResourceListModelTemplate$ResourceListBeanTemplate;", "Lcom/ss/ugc/effectplatform/model/ResourceListModel$ResourceListBean;", "kResourceBean", "(Lcom/ss/ugc/effectplatform/model/ResourceListModel$ResourceListBean;)V", "getKResourceBean", "()Lcom/ss/ugc/effectplatform/model/ResourceListModel$ResourceListBean;", "value", "", "resourceUrl", "getResourceUrl", "()Ljava/lang/String;", "setResourceUrl", "(Ljava/lang/String;)V", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
    public static class ResourceListBeanTemplate extends ResourceListModel.ResourceListBean {
        private final transient ResourceListModel.ResourceListBean kResourceBean;
        private String resourceUrl;

        /* JADX WARN: Multi-variable type inference failed */
        public ResourceListBeanTemplate() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public String getResourceUrl() {
            ResourceListModel.ResourceListBean r100 = getKResourceBean();
            if (r100 == null) goto L8;
            String r101 = r100.getResource_uri();
            if (r101 == null) goto L8;
            return r101;
        L8:
            return super.getResource_uri();
        }

        public ResourceListModel.ResourceListBean getKResourceBean() {
            return this.kResourceBean;
        }

        public ResourceListBeanTemplate(ResourceListModel.ResourceListBean r100) {
            super(null, null, null, 7, null);
            this.kResourceBean = r100;
        }

        public void setResourceUrl(String r100) {
            this.resourceUrl = r100;
            ResourceListModel.ResourceListBean r101 = getKResourceBean();
            if (r101 == null) goto L5;
            r101.setResource_uri(r100);
        L5:
            super.setResource_uri(r100);
        }

        public /* synthetic */ ResourceListBeanTemplate(ResourceListModel.ResourceListBean r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ResourceListModelTemplate() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public String getIconUri() {
        ResourceListModel r100 = getKResourceModel();
        if (r100 == null) goto L8;
        String r101 = r100.getIcon_uri();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getIcon_uri();
    }

    public String getParam() {
        ResourceListModel r100 = getKResourceModel();
        if (r100 == null) goto L8;
        String r101 = r100.getParams();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getParams();
    }

    public List<com.ss.android.ugc.effectmanager.effect.model.ResourceListModel.ResourceListBean> getResourceList() {
        ResourceListModel r100 = getKResourceModel();
        if (r100 == null) goto L7;
        List r101 = r100.getResource_list();
        List r102 = r101;
        if (r101 == null) goto L7;
    L9:
        if ((!r102.isEmpty()) == false) goto L24;
        if ((ListProtector.get(r102, 0) instanceof com.ss.android.ugc.effectmanager.effect.model.ResourceListModel.ResourceListBean) == false) goto L16;
        if (r102 == null) goto L15;
        return r102;
    L15:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.ss.android.ugc.effectmanager.effect.model.ResourceListModel.ResourceListBean>");
    L16:
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L18:
        if (r105.hasNext() == false) goto L20;
        r104.add(new com.ss.android.ugc.effectmanager.effect.model.ResourceListModel.ResourceListBean((ResourceListModel.ResourceListBean) r105.next()));
        goto L18
    L20:
        if (r100 == null) goto L22;
        r100.setResource_list(r104);
    L22:
        super.setResource_list(r104);
        return r104;
    L24:
        return new ArrayList();
    L7:
        r102 = super.getResource_list();
        goto L9
    }

    public List<String> getUrlPrefix() {
        ResourceListModel r100 = getKResourceModel();
        if (r100 == null) goto L8;
        List<String> r101 = r100.getUrl_prefix();
        if (r101 == null) goto L8;
        return r101;
    L8:
        return super.getUrl_prefix();
    }

    public ResourceListModel getKResourceModel() {
        return this.kResourceModel;
    }

    public ResourceListModelTemplate(ResourceListModel r100) {
        super(null, null, null, null, 15, null);
        this.kResourceModel = r100;
        this.resourceList = new ArrayList();
        this.urlPrefix = new ArrayList();
    }

    public void setIconUri(String r100) {
        this.iconUri = r100;
        ResourceListModel r101 = getKResourceModel();
        if (r101 == null) goto L5;
        r101.setIcon_uri(r100);
    L5:
        super.setIcon_uri(r100);
    }

    public void setParam(String r100) {
        this.param = r100;
        ResourceListModel r101 = getKResourceModel();
        if (r101 == null) goto L5;
        r101.setParams(r100);
    L5:
        super.setParams(r100);
    }

    public void setResourceList(List<com.ss.android.ugc.effectmanager.effect.model.ResourceListModel.ResourceListBean> r100) {
        this.resourceList = r100;
        ResourceListModel r101 = getKResourceModel();
        if (r101 == null) goto L5;
        r101.setResource_list(r100);
    L5:
        super.setResource_list(r100);
    }

    public void setUrlPrefix(List<String> r100) {
        this.urlPrefix = r100;
        ResourceListModel r101 = getKResourceModel();
        if (r101 == null) goto L5;
        r101.setUrl_prefix(r100);
    L5:
        super.setUrl_prefix(r100);
    }

    public /* synthetic */ ResourceListModelTemplate(ResourceListModel r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
