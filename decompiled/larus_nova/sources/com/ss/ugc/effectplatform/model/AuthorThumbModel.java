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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJD\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001eJ\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0007HÖ\u0001R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u0017\u0010\u000b\"\u0004\b\u0018\u0010\r¨\u0006+"}, d2 = {"Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "uri", "", ScoreTags.STAR_URL_LIST, "", "width", "", "height", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "getUrl_list", "()Ljava/util/List;", "setUrl_list", "(Ljava/util/List;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ss/ugc/effectplatform/model/AuthorThumbModel;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class AuthorThumbModel implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;
    private Integer height;
    private String uri;
    private List<String> url_list;
    private Integer width;

    /* JADX INFO: loaded from: classes36.dex */
    public static class a implements Parcelable.Creator {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            String r101 = r100.readString();
            ArrayList<String> r102 = r100.createStringArrayList();
            Integer r103 = null;
            if (r100.readInt() == 0) goto L5;
            Integer r104 = Integer.valueOf(r100.readInt());
        L7:
            if (r100.readInt() == 0) goto L10;
            r103 = Integer.valueOf(r100.readInt());
        L10:
            return new AuthorThumbModel(r101, r102, r104, r103);
        L5:
            r104 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new AuthorThumbModel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public AuthorThumbModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AuthorThumbModel copy$default(AuthorThumbModel r100, String r101, List r102, Integer r103, Integer r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.uri;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.url_list;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.width;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.height;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.uri;
    }

    public final List<String> component2() {
        return this.url_list;
    }

    public final Integer component3() {
        return this.width;
    }

    public final Integer component4() {
        return this.height;
    }

    public final AuthorThumbModel copy(String r100, List<String> r101, Integer r102, Integer r103) {
        return new AuthorThumbModel(r100, r101, r102, r103);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AuthorThumbModel) == false) goto L14;
        AuthorThumbModel r101 = (AuthorThumbModel) r100;
        if (Intrinsics.areEqual(this.uri, r101.uri) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.url_list, r101.url_list) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.height, r101.height) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.uri;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.url_list;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.width;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.height;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AuthorThumbModel(uri=" + this.uri + ", url_list=" + this.url_list + ", width=" + this.width + ", height=" + this.height + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.uri);
        r100.writeStringList(this.url_list);
        Integer r102 = this.width;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        r100.writeInt(r102.intValue());
    L6:
        Integer r103 = this.height;
        if (r103 == null) goto L9;
        r100.writeInt(1);
        r100.writeInt(r103.intValue());
        return;
    L9:
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(0);
        goto L6
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getUri() {
        return this.uri;
    }

    public final List<String> getUrl_list() {
        return this.url_list;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setUri(String r100) {
        this.uri = r100;
    }

    public final void setUrl_list(List<String> r100) {
        this.url_list = r100;
    }

    public final void setWidth(Integer r100) {
        this.width = r100;
    }

    public AuthorThumbModel(String r100, List<String> r101, Integer r102, Integer r103) {
        this.uri = r100;
        this.url_list = r101;
        this.width = r102;
        this.height = r103;
    }

    public /* synthetic */ AuthorThumbModel(String r100, List r101, Integer r102, Integer r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
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
