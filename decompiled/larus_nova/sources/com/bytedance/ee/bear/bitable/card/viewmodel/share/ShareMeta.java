package com.bytedance.ee.bear.bitable.card.viewmodel.share;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.IShareMeta;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BW\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\t\u0010 \u001a\u00020\u0005HÂ\u0003J\t\u0010!\u001a\u00020\u0007HÂ\u0003J\t\u0010\"\u001a\u00020\u0005HÂ\u0003J\t\u0010#\u001a\u00020\u0005HÂ\u0003J\t\u0010$\u001a\u00020\u0005HÂ\u0003J\t\u0010%\u001a\u00020\fHÂ\u0003J\t\u0010&\u001a\u00020\fHÂ\u0003J\t\u0010'\u001a\u00020\u0007HÂ\u0003JY\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0007HÆ\u0001J\u0013\u0010)\u001a\u00020\f2\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\u0005HÖ\u0001J\t\u0010-\u001a\u00020\u0007HÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareMeta;", "Lcom/bytedance/ee/bear/share/IShareMeta;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", ForwardDependency$ForwardLocation.FLAG, "", "shareToken", "", "objType", "shareType", "submitFrequencyLimit", "enableAnonymousSubmit", "", "constraintExternal", "recordShareToken", "<init>", "(ILjava/lang/String;IIIZZLjava/lang/String;)V", "getShareType", "Lcom/bytedance/ee/bear/share/EShareType;", "setShareType", "", "isOpen", "setFlag", "getShareToken", "setShareToken", "getObjType", "getSubmitFrequencyLimit", "setSubmitFrequencyLimit", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "isConstraintExternal", "getRecordShareToken", "setRecordShareToken", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareMeta extends Result<Serializable> implements IShareMeta {
    private final boolean constraintExternal;
    private final boolean enableAnonymousSubmit;
    private int flag;
    private final int objType;
    private String recordShareToken;
    private String shareToken;
    private int shareType;
    private int submitFrequencyLimit;

    public ShareMeta() {
        this(0, null, 0, 0, 0, false, false, null, 255, null);
    }

    public static /* synthetic */ ShareMeta copy$default(ShareMeta r100, int r110, String r111, int r112, int r113, int r114, boolean r115, boolean r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        int r101 = r100.flag;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.shareToken;
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r103 = r100.objType;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r104 = r100.shareType;
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r105 = r100.submitFrequencyLimit;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = r100.enableAnonymousSubmit;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.constraintExternal;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.recordShareToken;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final ShareMeta copy(int r110, String r111, int r112, int r113, int r114, boolean r115, boolean r116, String r117) {
        Intrinsics.checkNotNullParameter(r111, "shareToken");
        Intrinsics.checkNotNullParameter(r117, "recordShareToken");
        return new ShareMeta(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareMeta) == true) goto L8;
        return false;
    L8:
        ShareMeta r101 = (ShareMeta) r100;
        if (this.flag == r101.flag) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.shareToken, r101.shareToken) == true) goto L15;
        return false;
    L15:
        if (this.objType == r101.objType) goto L18;
        return false;
    L18:
        if (this.shareType == r101.shareType) goto L21;
        return false;
    L21:
        if (this.submitFrequencyLimit == r101.submitFrequencyLimit) goto L24;
        return false;
    L24:
        if (this.enableAnonymousSubmit == r101.enableAnonymousSubmit) goto L27;
        return false;
    L27:
        if (this.constraintExternal == r101.constraintExternal) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.recordShareToken, r101.recordShareToken) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((this.flag * 31) + this.shareToken.hashCode()) * 31) + this.objType) * 31) + this.shareType) * 31) + this.submitFrequencyLimit) * 31;
        int r101 = 1231;
        if (this.enableAnonymousSubmit == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.constraintExternal == true) goto L11;
        r101 = 1237;
    L11:
        return ((r103 + r101) * 31) + this.recordShareToken.hashCode();
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "ShareMeta(flag=" + this.flag + ", shareToken=" + this.shareToken + ", objType=" + this.objType + ", shareType=" + this.shareType + ", submitFrequencyLimit=" + this.submitFrequencyLimit + ", enableAnonymousSubmit=" + this.enableAnonymousSubmit + ", constraintExternal=" + this.constraintExternal + ", recordShareToken=" + this.recordShareToken + ')';
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public EShareType getShareType() {
        EShareType.a r100 = EShareType.Companion;
        int r101 = this.shareType;
        r100.getClass();
        return EShareType.a.a(r101);
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public boolean isOpen() {
        if (this.flag == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public boolean enableAnonymousSubmit() {
        return this.enableAnonymousSubmit;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public int getObjType() {
        return this.objType;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public String getRecordShareToken() {
        return this.recordShareToken;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public String getShareToken() {
        return this.shareToken;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public int getSubmitFrequencyLimit() {
        return this.submitFrequencyLimit;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public boolean isConstraintExternal() {
        return this.constraintExternal;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public void setFlag(int r100) {
        this.flag = r100;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public void setRecordShareToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "shareToken");
        this.recordShareToken = r100;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public void setShareToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "shareToken");
        this.shareToken = r100;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public void setShareType(int r100) {
        this.shareType = r100;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public void setSubmitFrequencyLimit(int r100) {
        this.submitFrequencyLimit = r100;
    }

    public ShareMeta(int r100, String r101, int r102, int r103, int r104, boolean r105, boolean r106, String r107) {
        Intrinsics.checkNotNullParameter(r101, "shareToken");
        Intrinsics.checkNotNullParameter(r107, "recordShareToken");
        this.flag = r100;
        this.shareToken = r101;
        this.objType = r102;
        this.shareType = r103;
        this.submitFrequencyLimit = r104;
        this.enableAnonymousSubmit = r105;
        this.constraintExternal = r106;
        this.recordShareToken = r107;
    }

    public ShareMeta(int r110, String r111, int r112, int r113, int r114, boolean r115, boolean r116, String r117, int r118, DefaultConstructorMarker r210) {
        boolean r100 = false;
        if ((r118 & 1) == 0) goto L5;
        int r101 = 0;
    L6:
        String r102 = "";
        if ((r118 & 2) == 0) goto L9;
        String r103 = "";
    L11:
        if ((r118 & 4) == 0) goto L13;
        int r104 = e.f541307r.f541317b;
    L15:
        if ((r118 & 8) == 0) goto L17;
        int r105 = EShareType.UNSUPPORT.getType();
    L19:
        if ((r118 & 16) == 0) goto L21;
        int r106 = 0;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r107 = false;
    L27:
        if ((r118 & 64) != 0) goto L31;
        r100 = r116;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r102 = r117;
    L34:
        this(r101, r103, r104, r105, r106, r107, r100, r102);
        return;
    L25:
        r107 = r115;
        goto L27
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
