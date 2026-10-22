package com.ss.android.ugc.aweme.poi.bean;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/BackToPoiParam;", "", "", "lifeTag", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "lifePage", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "schema", "c", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class BackToPoiParam {

    @SerializedName("life_page")
    private final List<String> lifePage;

    @SerializedName("life_tag")
    private final String lifeTag;

    @SerializedName("schema")
    private final String schema;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BackToPoiParam) == true) goto L8;
        return false;
    L8:
        BackToPoiParam r101 = (BackToPoiParam) r100;
        if (Intrinsics.areEqual(this.lifeTag, r101.lifeTag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lifePage, r101.lifePage) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.lifeTag;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.lifePage;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.schema;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BackToPoiParam(lifeTag=" + this.lifeTag + ", lifePage=" + this.lifePage + ", schema=" + this.schema + ')';
    }

    public BackToPoiParam() {
        this.lifeTag = null;
        this.lifePage = null;
        this.schema = null;
    }

    public final List<String> a() {
        return this.lifePage;
    }

    public final String b() {
        return this.lifeTag;
    }

    public final String c() {
        return this.schema;
    }
}
