package com.ss.android.ugc.aweme.poi.share;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/share/LocalLifeShareReflowScene;", "", "", "open", "Ljava/lang/Integer;", "getOpen", "()Ljava/lang/Integer;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "transSchema", "getTransSchema", "orgSchemaExtQuery", "getOrgSchemaExtQuery", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class LocalLifeShareReflowScene {

    @SerializedName("open")
    private final Integer open;

    @SerializedName("org_schema_ext_query")
    private final String orgSchemaExtQuery;

    @SerializedName("trans_schema")
    private final String transSchema;

    @SerializedName("type")
    private final String type;

    public LocalLifeShareReflowScene() {
        this.open = 0;
        this.type = "";
        this.transSchema = "";
        this.orgSchemaExtQuery = "";
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LocalLifeShareReflowScene) == true) goto L8;
        return false;
    L8:
        LocalLifeShareReflowScene r101 = (LocalLifeShareReflowScene) r100;
        if (Intrinsics.areEqual(this.open, r101.open) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.transSchema, r101.transSchema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.orgSchemaExtQuery, r101.orgSchemaExtQuery) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.open;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.type;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.transSchema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.orgSchemaExtQuery;
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
        return "LocalLifeShareReflowScene(open=" + this.open + ", type=" + this.type + ", transSchema=" + this.transSchema + ", orgSchemaExtQuery=" + this.orgSchemaExtQuery + ')';
    }

    public final String getType() {
        return this.type;
    }
}
