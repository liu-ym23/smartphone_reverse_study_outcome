package com.ss.android.lark.chameleon.api;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\b\u0010 \u001a\u00020\u0003H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R.\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chameleon/api/MicroAppInterceptConfig;", "Ljava/io/Serializable;", "urlPath", "", "urlQuery", "Lcom/ss/android/lark/chameleon/api/UrlQuery;", "urlSchema", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;Lcom/ss/android/lark/chameleon/api/UrlQuery;Ljava/util/ArrayList;)V", "getUrlPath", "()Ljava/lang/String;", "setUrlPath", "(Ljava/lang/String;)V", "getUrlQuery", "()Lcom/ss/android/lark/chameleon/api/UrlQuery;", "setUrlQuery", "(Lcom/ss/android/lark/chameleon/api/UrlQuery;)V", "getUrlSchema", "()Ljava/util/ArrayList;", "setUrlSchema", "(Ljava/util/ArrayList;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chameleon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MicroAppInterceptConfig implements Serializable {
    private String urlPath;
    private UrlQuery urlQuery;
    private ArrayList<String> urlSchema;

    public MicroAppInterceptConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MicroAppInterceptConfig copy$default(MicroAppInterceptConfig r100, String r101, UrlQuery r102, ArrayList r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.urlPath;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.urlQuery;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.urlSchema;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.urlPath;
    }

    public final UrlQuery component2() {
        return this.urlQuery;
    }

    public final ArrayList<String> component3() {
        return this.urlSchema;
    }

    public final MicroAppInterceptConfig copy(String r100, UrlQuery r101, ArrayList<String> r102) {
        return new MicroAppInterceptConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MicroAppInterceptConfig) == true) goto L8;
        return false;
    L8:
        MicroAppInterceptConfig r101 = (MicroAppInterceptConfig) r100;
        if (Intrinsics.areEqual(this.urlPath, r101.urlPath) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.urlQuery, r101.urlQuery) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.urlSchema, r101.urlSchema) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.urlPath;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        UrlQuery r104 = this.urlQuery;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ArrayList<String> r107 = this.urlSchema;
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

    public String toString() {
        return "MicroAppInterceptConfig(urlPath=" + this.urlPath + ", urlQuery=" + this.urlQuery + ", urlSchema=" + this.urlSchema + ')';
    }

    public final String getUrlPath() {
        return this.urlPath;
    }

    public final UrlQuery getUrlQuery() {
        return this.urlQuery;
    }

    public final ArrayList<String> getUrlSchema() {
        return this.urlSchema;
    }

    public final void setUrlPath(String r100) {
        this.urlPath = r100;
    }

    public final void setUrlQuery(UrlQuery r100) {
        this.urlQuery = r100;
    }

    public final void setUrlSchema(ArrayList<String> r100) {
        this.urlSchema = r100;
    }

    public MicroAppInterceptConfig(String r100, UrlQuery r101, ArrayList<String> r102) {
        this.urlPath = r100;
        this.urlQuery = r101;
        this.urlSchema = r102;
    }

    public /* synthetic */ MicroAppInterceptConfig(String r100, UrlQuery r101, ArrayList r102, int r103, DefaultConstructorMarker r104) {
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
