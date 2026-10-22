package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0010\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\r\u001a\u00020\u0007HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001cR\"\u0010\u0010\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;", "", "component2", "getResponseData", "getResponseMessage", "", "getStatusCode", "", "checkValue", "verifySign", "component1", "component3", "data", "message", "status_code", "copy", "toString", "hashCode", "", "other", "equals", "Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;", "getData", "()Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;", "setData", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;)V", "Ljava/lang/String;", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/net/PanelInfoWithOneEffectData;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class PanelInfoWithOneEffectResponse extends e<PanelInfoWithOneEffectData> {
    private PanelInfoWithOneEffectData data;
    private String message;
    private int status_code;

    public PanelInfoWithOneEffectResponse() {
        this(null, null, 0, 7, null);
    }

    private final String component2() {
        return this.message;
    }

    public static /* synthetic */ PanelInfoWithOneEffectResponse copy$default(PanelInfoWithOneEffectResponse r100, PanelInfoWithOneEffectData r101, String r102, int r103, int r104, Object r105) {
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

    public final PanelInfoWithOneEffectData component1() {
        return this.data;
    }

    public final int component3() {
        return this.status_code;
    }

    public final PanelInfoWithOneEffectResponse copy(PanelInfoWithOneEffectData r100, String r101, int r102) {
        return new PanelInfoWithOneEffectResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PanelInfoWithOneEffectResponse) == false) goto L12;
        PanelInfoWithOneEffectResponse r101 = (PanelInfoWithOneEffectResponse) r100;
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
        PanelInfoWithOneEffectData r100 = this.data;
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
        return "PanelInfoWithOneEffectResponse(data=" + this.data + ", message=" + this.message + ", status_code=" + this.status_code + ")";
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
        PanelInfoWithOneEffectData r100 = this.data;
        if (r100 == null) goto L9;
        Effect r101 = r100.front_effect;
        if (r101 == null) goto L9;
        if (b.a(r101) == true) goto L9;
        return false;
    L9:
        PanelInfoWithOneEffectData r102 = this.data;
        if (r102 == null) goto L16;
        Effect r103 = r102.rear_effect;
        if (r103 == null) goto L16;
        if (b.a(r103) == true) goto L16;
        return false;
    L16:
        PanelInfoWithOneEffectData r104 = this.data;
        if (r104 == null) goto L44;
        List<CategoryEffect> r105 = r104.category_effect_list;
        if (r105 == null) goto L57;
        Iterator<T> r106 = r105.iterator();
    L22:
        if (r106.hasNext() == false) goto L58;
        CategoryEffect r107 = (CategoryEffect) r106.next();
        Effect r108 = r107.effects;
        if (r108 != null) goto L26;
    L28:
        List<? extends Effect> r109 = r107.bind_effects;
        if (r109 == null) goto L36;
        Iterator<T> r110 = r109.iterator();
    L32:
        if (r110.hasNext() == false) goto L36;
        if (b.a((Effect) r110.next()) == true) goto L32;
        return false;
    L36:
        List<? extends Effect> r111 = r107.collection;
        if (r111 == null) goto L22;
        Iterator<T> r112 = r111.iterator();
    L40:
        if (r112.hasNext() == false) goto L22;
        if (b.a((Effect) r112.next()) == true) goto L40;
        return false;
    L26:
        if (b.a(r108) == true) goto L28;
        return false;
    L58:
        return true;
    L57:
        return true;
    L44:
        return true;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ PanelInfoWithOneEffectData getResponseData() {
        return getResponseData();
    }

    public final PanelInfoWithOneEffectData getData() {
        return this.data;
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
    public PanelInfoWithOneEffectData getResponseData() {
        return this.data;
    }

    public final void setData(PanelInfoWithOneEffectData r100) {
        this.data = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public PanelInfoWithOneEffectResponse(PanelInfoWithOneEffectData r100, String r101, int r102) {
        this.data = r100;
        this.message = r101;
        this.status_code = r102;
    }

    public /* synthetic */ PanelInfoWithOneEffectResponse(PanelInfoWithOneEffectData r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
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
