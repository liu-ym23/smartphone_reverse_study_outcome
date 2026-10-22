package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001:\u0001\u001dB=\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/ss/ugc/effectplatform/model/ResourceListModel;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "resource_list", "", "Lcom/ss/ugc/effectplatform/model/ResourceListModel$ResourceListBean;", "url_prefix", "", "icon_uri", "params", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getIcon_uri", "()Ljava/lang/String;", "setIcon_uri", "(Ljava/lang/String;)V", "getParams", "setParams", "getResource_list", "()Ljava/util/List;", "setResource_list", "(Ljava/util/List;)V", "getUrl_prefix", "setUrl_prefix", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "ResourceListBean", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class ResourceListModel implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;
    private String icon_uri;
    private String params;
    private List<? extends ResourceListBean> resource_list;
    private List<String> url_prefix;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/ss/ugc/effectplatform/model/ResourceListModel$ResourceListBean;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "name", "", "value", "resource_uri", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getResource_uri", "setResource_uri", "getValue", "setValue", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "effect_model_release"}, k = 1, mv = {1, 1, 16})
    public static class ResourceListBean implements AndroidParcelable {
        public static final Parcelable.Creator CREATOR = null;
        private String name;
        private String resource_uri;
        private String value;

        public static class a implements Parcelable.Creator {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel r100) {
                return new ResourceListBean(r100.readString(), r100.readString(), r100.readString());
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int r100) {
                return new ResourceListBean[r100];
            }
        }

        static {
            CREATOR = new a();
        }

        public ResourceListBean() {
            this(null, null, null, 7, null);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.name);
            r100.writeString(this.value);
            r100.writeString(this.resource_uri);
        }

        public String getName() {
            return this.name;
        }

        public String getResource_uri() {
            return this.resource_uri;
        }

        public String getValue() {
            return this.value;
        }

        public void setName(String r100) {
            this.name = r100;
        }

        public void setResource_uri(String r100) {
            this.resource_uri = r100;
        }

        public void setValue(String r100) {
            this.value = r100;
        }

        public ResourceListBean(String r100, String r101, String r102) {
            this.name = r100;
            this.value = r101;
            this.resource_uri = r102;
        }

        public /* synthetic */ ResourceListBean(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = null;
        L11:
            this(r100, r101, r102);
        }
    }

    public static class a implements Parcelable.Creator {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            ArrayList r102 = new ArrayList(r101);
        L3:
            if (r101 == 0) goto L6;
            r102.add((ResourceListBean) r100.readParcelable(ResourceListModel.class.getClassLoader()));
            r101 = r101 - 1;
            goto L3
        L6:
            return new ResourceListModel(r102, r100.createStringArrayList(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new ResourceListModel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ResourceListModel() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        List<? extends ResourceListBean> r102 = this.resource_list;
        r100.writeInt(r102.size());
        Iterator<? extends ResourceListBean> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r100.writeParcelable(r103.next(), r101);
        goto L4
    L6:
        r100.writeStringList(this.url_prefix);
        r100.writeString(this.icon_uri);
        r100.writeString(this.params);
    }

    public String getIcon_uri() {
        return this.icon_uri;
    }

    public String getParams() {
        return this.params;
    }

    public List<ResourceListBean> getResource_list() {
        return this.resource_list;
    }

    public List<String> getUrl_prefix() {
        return this.url_prefix;
    }

    public void setIcon_uri(String r100) {
        this.icon_uri = r100;
    }

    public void setParams(String r100) {
        this.params = r100;
    }

    public void setResource_list(List<? extends ResourceListBean> r100) {
        this.resource_list = r100;
    }

    public void setUrl_prefix(List<String> r100) {
        this.url_prefix = r100;
    }

    public ResourceListModel(List<? extends ResourceListBean> r100, List<String> r101, String r102, String r103) {
        this.resource_list = r100;
        this.url_prefix = r101;
        this.icon_uri = r102;
        this.params = r103;
    }

    public /* synthetic */ ResourceListModel(List r100, List r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = new ArrayList();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
