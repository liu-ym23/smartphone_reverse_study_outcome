package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.extension.b;
import com.ss.ugc.effectplatform.model.CategoryEffectModel;
import com.ss.ugc.effectplatform.model.Effect;
import com.ss.ugc.effectplatform.model.PanelInfoModel;
import com.ss.ugc.effectplatform.model.e;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0014\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B5\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b*\u0010+J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0007HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010 R$\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010$R\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "", "component2", "getResponseData", "getResponseMessage", "", "getStatusCode", "", "checkValue", "verifySign", "component1", "component3", "()Ljava/lang/Boolean;", "component4", "data", "message", "updated", "status_code", "copy", "(Lcom/ss/ugc/effectplatform/model/PanelInfoModel;Ljava/lang/String;Ljava/lang/Boolean;I)Lcom/ss/ugc/effectplatform/model/net/PanelInfoCheckedResponse;", "toString", "hashCode", "", "other", "equals", "Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "getData", "()Lcom/ss/ugc/effectplatform/model/PanelInfoModel;", "setData", "(Lcom/ss/ugc/effectplatform/model/PanelInfoModel;)V", "Ljava/lang/String;", "Ljava/lang/Boolean;", "getUpdated", "setUpdated", "(Ljava/lang/Boolean;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Lcom/ss/ugc/effectplatform/model/PanelInfoModel;Ljava/lang/String;Ljava/lang/Boolean;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class PanelInfoCheckedResponse extends e<PanelInfoModel> {
    private PanelInfoModel data;
    private String message;
    private int status_code;
    private Boolean updated;

    public PanelInfoCheckedResponse() {
        this(null, null, null, 0, 15, null);
    }

    private final String component2() {
        return this.message;
    }

    public static /* synthetic */ PanelInfoCheckedResponse copy$default(PanelInfoCheckedResponse r100, PanelInfoModel r101, String r102, Boolean r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.message;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.updated;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.status_code;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final PanelInfoModel component1() {
        return this.data;
    }

    public final Boolean component3() {
        return this.updated;
    }

    public final int component4() {
        return this.status_code;
    }

    public final PanelInfoCheckedResponse copy(PanelInfoModel r100, String r101, Boolean r102, int r103) {
        return new PanelInfoCheckedResponse(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PanelInfoCheckedResponse) == false) goto L14;
        PanelInfoCheckedResponse r101 = (PanelInfoCheckedResponse) r100;
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.updated, r101.updated) == true) goto L12;
        return false;
    L12:
        if (this.status_code == r101.status_code) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        PanelInfoModel r100 = this.data;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.message;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.updated;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.status_code;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "PanelInfoCheckedResponse(data=" + this.data + ", message=" + this.message + ", updated=" + this.updated + ", status_code=" + this.status_code + ")";
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean checkValue() {
        if (Intrinsics.areEqual(this.updated, Boolean.TRUE) == true) goto L5;
        return true;
    L5:
        if (this.data != null) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public boolean verifySign() {
        PanelInfoModel r100 = this.data;
        if (r100 == null) goto L14;
        CategoryEffectModel r101 = r100.getCategory_effects();
        if (r101 == null) goto L14;
        List<Effect> r102 = r101.getCollection();
        if (r102 == null) goto L14;
        Iterator<T> r103 = r102.iterator();
    L10:
        if (r103.hasNext() == false) goto L14;
        if (b.a((Effect) r103.next()) == true) goto L10;
        return false;
    L14:
        PanelInfoModel r104 = this.data;
        if (r104 == null) goto L26;
        CategoryEffectModel r105 = r104.getCategory_effects();
        if (r105 == null) goto L26;
        List<Effect> r106 = r105.getBind_effects();
        if (r106 == null) goto L26;
        Iterator<T> r107 = r106.iterator();
    L22:
        if (r107.hasNext() == false) goto L26;
        if (b.a((Effect) r107.next()) == true) goto L22;
        return false;
    L26:
        PanelInfoModel r108 = this.data;
        if (r108 == null) goto L38;
        CategoryEffectModel r109 = r108.getCategory_effects();
        if (r109 == null) goto L49;
        List<Effect> r110 = r109.getCategory_effects();
        if (r110 == null) goto L50;
        Iterator<T> r111 = r110.iterator();
    L34:
        if (r111.hasNext() == false) goto L51;
        if (b.a((Effect) r111.next()) == true) goto L34;
        return false;
    L51:
        return true;
    L50:
        return true;
    L49:
        return true;
    L38:
        return true;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ PanelInfoModel getResponseData() {
        return getResponseData();
    }

    public final PanelInfoModel getData() {
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

    public final Boolean getUpdated() {
        return this.updated;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public PanelInfoModel getResponseData() {
        return this.data;
    }

    public final void setData(PanelInfoModel r100) {
        this.data = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public final void setUpdated(Boolean r100) {
        this.updated = r100;
    }

    public PanelInfoCheckedResponse(PanelInfoModel r100, String r101, Boolean r102, int r103) {
        this.data = r100;
        this.message = r101;
        this.updated = r102;
        this.status_code = r103;
    }

    public /* synthetic */ PanelInfoCheckedResponse(PanelInfoModel r100, String r101, Boolean r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = Boolean.TRUE;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
