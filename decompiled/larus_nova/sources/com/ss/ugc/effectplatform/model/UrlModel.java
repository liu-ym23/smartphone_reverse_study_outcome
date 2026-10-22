package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B9\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\u0019\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/ss/ugc/effectplatform/model/UrlModel;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", ScoreTags.STAR_URL_LIST, "", "", "uri", "md5", "url_type", "", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getMd5", "()Ljava/lang/String;", "setMd5", "(Ljava/lang/String;)V", "getUri", "setUri", "getUrl_list", "()Ljava/util/List;", "setUrl_list", "(Ljava/util/List;)V", "getUrl_type", "()Ljava/lang/Integer;", "setUrl_type", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class UrlModel implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private String f457411md5;
    private String uri;
    private List<String> url_list;
    private Integer url_type;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            ArrayList<String> r101 = r100.createStringArrayList();
            String r102 = r100.readString();
            String r103 = r100.readString();
            if (r100.readInt() == 0) goto L5;
            Integer r104 = Integer.valueOf(r100.readInt());
        L7:
            return new UrlModel(r101, r102, r103, r104);
        L5:
            r104 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new UrlModel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public UrlModel() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeStringList(this.url_list);
        r100.writeString(this.uri);
        r100.writeString(this.f457411md5);
        Integer r102 = this.url_type;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        int r103 = r102.intValue();
    L6:
        r100.writeInt(r103);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public String toString() {
        return "UrlModel(url_list=" + getUrl_list() + ", uri=" + getUri() + ')';
    }

    public int hashCode() {
        List<String> r100 = getUrl_list();
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.hashCode());
    L6:
        int r102 = r101.intValue() * 31;
        String r103 = getUri();
        int r104 = 0;
        if (r103 == null) goto L9;
        int r105 = r103.hashCode();
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = getMd5();
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = getUrl_type();
        if (r110 == null) goto L18;
        r104 = r110.hashCode();
    L18:
        return r109 + r104;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public String getMd5() {
        return this.f457411md5;
    }

    public String getUri() {
        return this.uri;
    }

    public List<String> getUrl_list() {
        return this.url_list;
    }

    public Integer getUrl_type() {
        return this.url_type;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UrlModel) == true) goto L8;
        return false;
    L8:
        UrlModel r101 = (UrlModel) r100;
        if ((!Intrinsics.areEqual(getUrl_list(), r101.getUrl_list())) == false) goto L12;
        return false;
    L12:
        if ((!Intrinsics.areEqual(getUri(), r101.getUri())) == false) goto L15;
        return false;
    L15:
        if ((!Intrinsics.areEqual(getMd5(), r101.getMd5())) == false) goto L18;
        return false;
    L18:
        if ((!Intrinsics.areEqual(getUrl_type(), r101.getUrl_type())) == false) goto L20;
        return false;
    L20:
        return true;
    }

    public void setMd5(String r100) {
        this.f457411md5 = r100;
    }

    public void setUri(String r100) {
        this.uri = r100;
    }

    public void setUrl_list(List<String> r100) {
        this.url_list = r100;
    }

    public void setUrl_type(Integer r100) {
        this.url_type = r100;
    }

    public UrlModel(List<String> r100, String r101, String r102, Integer r103) {
        this.url_list = r100;
        this.uri = r101;
        this.f457411md5 = r102;
        this.url_type = r103;
    }

    public /* synthetic */ UrlModel(List r100, String r101, String r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
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
