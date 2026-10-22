package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003JD\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\"J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\"HÖ\u0001J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/larus/bmhome/auth/DouyinFeedAbConf;", "Landroid/os/Parcelable;", "enableDySdk", "", "searchSceneId", "", "feedEntrances", "", "Lcom/larus/bmhome/auth/DouyinFeedEntrance;", "pushEntrance", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Lcom/larus/bmhome/auth/DouyinFeedEntrance;)V", "getEnableDySdk", "()Ljava/lang/Boolean;", "setEnableDySdk", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSearchSceneId", "()Ljava/lang/String;", "getFeedEntrances", "()Ljava/util/List;", "setFeedEntrances", "(Ljava/util/List;)V", "getPushEntrance", "()Lcom/larus/bmhome/auth/DouyinFeedEntrance;", "setPushEntrance", "(Lcom/larus/bmhome/auth/DouyinFeedEntrance;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Lcom/larus/bmhome/auth/DouyinFeedEntrance;)Lcom/larus/bmhome/auth/DouyinFeedAbConf;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouyinFeedAbConf implements Parcelable {
    public static final Parcelable.Creator<DouyinFeedAbConf> CREATOR = null;

    @SerializedName("enable_dy_sdk")
    private Boolean enableDySdk;

    @SerializedName("feed_entrances")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private List<DouyinFeedEntrance> feedEntrances;

    @SerializedName("push_entrance")
    private DouyinFeedEntrance pushEntrance;

    @SerializedName("search_scene_id")
    private final String searchSceneId;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<DouyinFeedAbConf> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DouyinFeedAbConf createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = 0;
            DouyinFeedEntrance r102 = null;
            if (r100.readInt() != 0) goto L6;
            Boolean r103 = null;
        L10:
            String r104 = r100.readString();
            if (r100.readInt() != 0) goto L13;
            ArrayList r105 = null;
        L17:
            if (r100.readInt() == 0) goto L21;
            r102 = DouyinFeedEntrance.CREATOR.createFromParcel(r100);
        L21:
            return new DouyinFeedAbConf(r103, r104, r105, r102);
        L13:
            int r106 = r100.readInt();
            r105 = new ArrayList(r106);
        L14:
            if (r101 == r106) goto L17;
            r105.add(DouyinFeedEntrance.CREATOR.createFromParcel(r100));
            r101 = r101 + 1;
            goto L14
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r107 = true;
        L9:
            r103 = Boolean.valueOf(r107);
            goto L10
        L8:
            r107 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final DouyinFeedAbConf[] newArray(int r100) {
            return new DouyinFeedAbConf[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DouyinFeedAbConf) == true) goto L8;
        return false;
    L8:
        DouyinFeedAbConf r101 = (DouyinFeedAbConf) r100;
        if (Intrinsics.areEqual(this.enableDySdk, r101.enableDySdk) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.searchSceneId, r101.searchSceneId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.feedEntrances, r101.feedEntrances) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.pushEntrance, r101.pushEntrance) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enableDySdk;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.searchSceneId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<DouyinFeedEntrance> r107 = this.feedEntrances;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        DouyinFeedEntrance r110 = this.pushEntrance;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DouyinFeedAbConf(enableDySdk=" + this.enableDySdk + ", searchSceneId=" + this.searchSceneId + ", feedEntrances=" + this.feedEntrances + ", pushEntrance=" + this.pushEntrance + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Boolean r102 = this.enableDySdk;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeString(this.searchSceneId);
        List<DouyinFeedEntrance> r103 = this.feedEntrances;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L13:
        DouyinFeedEntrance r104 = this.pushEntrance;
        if (r104 != null) goto L16;
        r100.writeInt(0);
        return;
    L16:
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<DouyinFeedEntrance> r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        r105.next().writeToParcel(r100, r101);
        goto L11
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public DouyinFeedAbConf() {
        this(Boolean.FALSE, "", CollectionsKt.emptyList(), null);
    }

    public final List<DouyinFeedEntrance> b() {
        return this.feedEntrances;
    }

    public final DouyinFeedEntrance c() {
        return this.pushEntrance;
    }

    public final String d() {
        return this.searchSceneId;
    }

    public static DouyinFeedAbConf a(DouyinFeedAbConf r100) {
        return new DouyinFeedAbConf(r100.enableDySdk, r100.searchSceneId, r100.feedEntrances, r100.pushEntrance);
    }

    public DouyinFeedAbConf(Boolean r100, String r101, List<DouyinFeedEntrance> r102, DouyinFeedEntrance r103) {
        this.enableDySdk = r100;
        this.searchSceneId = r101;
        this.feedEntrances = r102;
        this.pushEntrance = r103;
    }
}
