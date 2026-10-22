package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B)\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/SearchEffectResponseV2;", "Lcom/ss/ugc/effectplatform/model/e;", "", "getResponseMessage", "getResponseData", "", "getStatusCode", "", "checkValue", "verifySign", "Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;", "data", "Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;", "getData", "()Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;", "setData", "(Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;)V", "status_code", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/net/SearchEffectModel;ILjava/lang/String;)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public class SearchEffectResponseV2 extends e<SearchEffectResponseV2> {
    private SearchEffectModel data;
    private String message;
    private int status_code;

    public SearchEffectResponseV2() {
        this(null, 0, null, 7, null);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public SearchEffectResponseV2 getResponseData() {
        return this;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        if (this.data == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean verifySign() {
        SearchEffectModel r100 = this.data;
        if (r100 == null) goto L12;
        List<Effect> r101 = r100.getCollection();
        if (r101 == null) goto L12;
        Iterator<T> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        if (b.a((Effect) r102.next()) == true) goto L8;
        return false;
    L12:
        SearchEffectModel r103 = this.data;
        if (r103 == null) goto L22;
        List<Effect> r104 = r103.getBind_effects();
        if (r104 == null) goto L22;
        Iterator<T> r105 = r104.iterator();
    L18:
        if (r105.hasNext() == false) goto L22;
        if (b.a((Effect) r105.next()) == true) goto L18;
        return false;
    L22:
        SearchEffectModel r106 = this.data;
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
    public /* bridge */ /* synthetic */ SearchEffectResponseV2 getResponseData() {
        return getResponseData();
    }

    public final SearchEffectModel getData() {
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

    public final void setData(SearchEffectModel r100) {
        this.data = r100;
    }

    public final void setMessage(String r100) {
        this.message = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public SearchEffectResponseV2(SearchEffectModel r100, int r101, String r102) {
        this.data = r100;
        this.status_code = r101;
        this.message = r102;
    }

    public /* synthetic */ SearchEffectResponseV2(SearchEffectModel r100, int r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
