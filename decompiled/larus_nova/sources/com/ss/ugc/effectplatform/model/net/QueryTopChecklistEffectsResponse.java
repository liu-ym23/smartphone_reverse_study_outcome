package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.QueryTopChecklistEffectsModel;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b&\u0010'J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\u0010\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/QueryTopChecklistEffectsResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/QueryTopChecklistEffectsModel;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "", "checkValue", "verifySign", "component1", "component2", "component3", "data", "message", "status_code", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/ss/ugc/effectplatform/model/QueryTopChecklistEffectsModel;", "getData", "()Lcom/ss/ugc/effectplatform/model/QueryTopChecklistEffectsModel;", "setData", "(Lcom/ss/ugc/effectplatform/model/QueryTopChecklistEffectsModel;)V", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/QueryTopChecklistEffectsModel;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class QueryTopChecklistEffectsResponse extends e<QueryTopChecklistEffectsModel> {
    private QueryTopChecklistEffectsModel data;
    private String message;
    private int status_code;

    public QueryTopChecklistEffectsResponse() {
        this(null, null, 0, 7, null);
    }

    public static /* synthetic */ QueryTopChecklistEffectsResponse copy$default(QueryTopChecklistEffectsResponse r100, QueryTopChecklistEffectsModel r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.status_code;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final QueryTopChecklistEffectsModel component1() {
        return this.data;
    }

    public final String component2() {
        return this.message;
    }

    public final int component3() {
        return this.status_code;
    }

    public final QueryTopChecklistEffectsResponse copy(QueryTopChecklistEffectsModel r100, String r101, int r102) {
        return new QueryTopChecklistEffectsResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof QueryTopChecklistEffectsResponse) == false) goto L12;
        QueryTopChecklistEffectsResponse r101 = (QueryTopChecklistEffectsResponse) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r101.status_code) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        QueryTopChecklistEffectsModel r100 = this.data;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.message;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.status_code;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "QueryTopChecklistEffectsResponse(data=" + this.data + ", message=" + this.message + ", status_code=" + this.status_code + ")";
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        if (this.data == null) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean verifySign() {
        QueryTopChecklistEffectsModel r100 = this.data;
        if (r100 == null) goto L12;
        List<Effect> r101 = r100.getCollection();
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        if (b.a((Effect) r102.next()) == true) goto L8;
        return false;
    L12:
        QueryTopChecklistEffectsModel r103 = this.data;
        if (r103 == null) goto L22;
        List<Effect> r104 = r103.getBind_effects();
        if (r104 == null) goto L22;
        Iterator<T> r105 = r104.iterator();
    L18:
        if (r105.hasNext() == false) goto L22;
        if (b.a((Effect) r105.next()) == true) goto L18;
        return false;
    L22:
        QueryTopChecklistEffectsModel r106 = this.data;
        if (r106 == null) goto L32;
        List<Effect> r107 = r106.getEffects();
        if (r107 == null) goto L43;
        Iterator<T> r108 = r107.iterator();
    L28:
        if (r108.hasNext() == false) goto L44;
        if (b.a((Effect) r108.next()) == true) goto L28;
        return false;
    L44:
        return true;
    L43:
        return true;
    L32:
        return true;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ QueryTopChecklistEffectsModel getResponseData() {
        return getResponseData();
    }

    public final QueryTopChecklistEffectsModel getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public String getResponseMessage() {
        return this.message;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public QueryTopChecklistEffectsModel getResponseData() {
        return this.data;
    }

    public final void setData(QueryTopChecklistEffectsModel r100) {
        this.data = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public QueryTopChecklistEffectsResponse(QueryTopChecklistEffectsModel r100, String r101, int r102) {
        this.data = r100;
        this.message = r101;
        this.status_code = r102;
    }

    public /* synthetic */ QueryTopChecklistEffectsResponse(QueryTopChecklistEffectsModel r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        this(r100, r101, r102);
    }
}
