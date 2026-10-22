package com.ss.ugc.effectplatform.model.net;

import com.ss.ugc.effectplatform.model.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B-\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b%\u0010&J\b\u0010\u0002\u001a\u00020\u0000H\u0016J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J/\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003R(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/ss/ugc/effectplatform/model/net/StickerCategoryListResponse;", "Lcom/ss/ugc/effectplatform/model/e;", "getResponseData", "", "getResponseMessage", "", "getStatusCode", "", "Lcom/ss/ugc/effectplatform/model/net/StickerCategoryListModel;", "component1", "component2", "component3", "categorys", "status_msg", "status_code", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getCategorys", "()Ljava/util/List;", "setCategorys", "(Ljava/util/List;)V", "Ljava/lang/String;", "getStatus_msg", "()Ljava/lang/String;", "setStatus_msg", "(Ljava/lang/String;)V", "I", "getStatus_code", "()I", "setStatus_code", "(I)V", "<init>", "(Ljava/util/List;Ljava/lang/String;I)V", "effectplatform_release"}, k = 1, mv = {1, 4, 0})
public final class StickerCategoryListResponse extends e<StickerCategoryListResponse> {
    private List<StickerCategoryListModel> categorys;
    private int status_code;
    private String status_msg;

    public StickerCategoryListResponse() {
        this(null, null, 0, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StickerCategoryListResponse copy$default(StickerCategoryListResponse r100, List r101, String r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.categorys;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.status_msg;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.status_code;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<StickerCategoryListModel> component1() {
        return this.categorys;
    }

    public final String component2() {
        return this.status_msg;
    }

    public final int component3() {
        return this.status_code;
    }

    public final StickerCategoryListResponse copy(List<StickerCategoryListModel> r100, String r101, int r102) {
        return new StickerCategoryListResponse(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof StickerCategoryListResponse) == false) goto L12;
        StickerCategoryListResponse r101 = (StickerCategoryListResponse) r100;
        if (Intrinsics.areEqual(this.categorys, r101.categorys) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.status_msg, r101.status_msg) == true) goto L10;
        return false;
    L10:
        if (this.status_code == r101.status_code) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ss.ugc.effectplatform.model.e
    public StickerCategoryListResponse getResponseData() {
        return this;
    }

    public int hashCode() {
        List<StickerCategoryListModel> r100 = this.categorys;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.status_msg;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return ((r103 + r101) * 31) + this.status_code;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "StickerCategoryListResponse(categorys=" + this.categorys + ", status_msg=" + this.status_msg + ", status_code=" + this.status_code + ")";
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public /* bridge */ /* synthetic */ StickerCategoryListResponse getResponseData() {
        return getResponseData();
    }

    public final List<StickerCategoryListModel> getCategorys() {
        return this.categorys;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public String getResponseMessage() {
        return this.status_msg;
    }

    @Override // com.ss.ugc.effectplatform.model.e
    public int getStatusCode() {
        return this.status_code;
    }

    public final int getStatus_code() {
        return this.status_code;
    }

    public final String getStatus_msg() {
        return this.status_msg;
    }

    public final void setCategorys(List<StickerCategoryListModel> r100) {
        this.categorys = r100;
    }

    public final void setStatus_code(int r100) {
        this.status_code = r100;
    }

    public final void setStatus_msg(String r100) {
        this.status_msg = r100;
    }

    public StickerCategoryListResponse(List<StickerCategoryListModel> r100, String r101, int r102) {
        this.categorys = r100;
        this.status_msg = r101;
        this.status_code = r102;
    }

    public /* synthetic */ StickerCategoryListResponse(List r100, String r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new ArrayList();
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
