package com.ss.ugc.effectplatform.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0016J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/ss/ugc/effectplatform/model/RankingEffectModel;", "Lcom/ss/ugc/effectplatform/model/AndroidParcelable;", "category_key", "", "category_name", "ranking", "", "ranking_url", "Lcom/ss/ugc/effectplatform/model/UrlModel;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "getCategory_key", "()Ljava/lang/String;", "setCategory_key", "(Ljava/lang/String;)V", "getCategory_name", "setCategory_name", "getRanking", "()Ljava/lang/Integer;", "setRanking", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getRanking_url", "()Lcom/ss/ugc/effectplatform/model/UrlModel;", "setRanking_url", "(Lcom/ss/ugc/effectplatform/model/UrlModel;)V", "describeContents", "equals", "", "other", "", "hashCode", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class RankingEffectModel implements AndroidParcelable {
    public static final Parcelable.Creator CREATOR = null;
    private String category_key;
    private String category_name;
    private Integer ranking;
    private UrlModel ranking_url;

    /* JADX INFO: loaded from: classes36.dex */
    public static class a implements Parcelable.Creator {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel r100) {
            String r101 = r100.readString();
            String r102 = r100.readString();
            if (r100.readInt() == 0) goto L5;
            Integer r103 = Integer.valueOf(r100.readInt());
        L7:
            return new RankingEffectModel(r101, r102, r103, (UrlModel) r100.readParcelable(RankingEffectModel.class.getClassLoader()));
        L5:
            r103 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int r100) {
            return new RankingEffectModel[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public RankingEffectModel() {
        this(null, null, null, null, 15, null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.category_key);
        r100.writeString(this.category_name);
        Integer r102 = this.ranking;
        if (r102 == null) goto L5;
        r100.writeInt(1);
        int r103 = r102.intValue();
    L6:
        r100.writeInt(r103);
        r100.writeParcelable(this.ranking_url, r101);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public int hashCode() {
        String r100 = getCategory_key();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = getCategory_name();
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = getRanking();
        if (r107 == null) goto L13;
        int r108 = r107.intValue();
    L14:
        int r109 = (r106 + r108) * 31;
        UrlModel r110 = getRanking_url();
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

    public String getCategory_key() {
        return this.category_key;
    }

    public String getCategory_name() {
        return this.category_name;
    }

    public Integer getRanking() {
        return this.ranking;
    }

    public UrlModel getRanking_url() {
        return this.ranking_url;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L23:
        return false;
    L8:
        if ((!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(getClass()), Reflection.getOrCreateKotlinClass(r100.getClass()))) == true) goto L23;
        RankingEffectModel r101 = (RankingEffectModel) r100;
        if ((!Intrinsics.areEqual(getCategory_key(), r101.getCategory_key())) == false) goto L14;
        return false;
    L14:
        if ((!Intrinsics.areEqual(getCategory_name(), r101.getCategory_name())) == false) goto L17;
        return false;
    L17:
        if ((!Intrinsics.areEqual(getRanking(), r101.getRanking())) == false) goto L20;
        return false;
    L20:
        if ((!Intrinsics.areEqual(getRanking_url(), r101.getRanking_url())) == false) goto L22;
        return false;
    L22:
        return true;
    }

    public void setCategory_key(String r100) {
        this.category_key = r100;
    }

    public void setCategory_name(String r100) {
        this.category_name = r100;
    }

    public void setRanking(Integer r100) {
        this.ranking = r100;
    }

    public void setRanking_url(UrlModel r100) {
        this.ranking_url = r100;
    }

    public RankingEffectModel(String r100, String r101, Integer r102, UrlModel r103) {
        this.category_key = r100;
        this.category_name = r101;
        this.ranking = r102;
        this.ranking_url = r103;
    }

    public /* synthetic */ RankingEffectModel(String r100, String r101, Integer r110, UrlModel r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r112 & 4) == 0) goto L12;
        r110 = 0;
    L12:
        if ((r112 & 8) == 0) goto L14;
        r111 = new UrlModel(null, null, null, null, 15, null);
    L14:
        this(r100, r101, r110, r111);
    }
}
