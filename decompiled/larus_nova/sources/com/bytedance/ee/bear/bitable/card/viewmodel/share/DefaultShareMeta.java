package com.bytedance.ee.bear.bitable.card.viewmodel.share;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.ee.bear.share.EShareType;
import com.bytedance.ee.bear.share.IShareMeta;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000bH\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/DefaultShareMeta;", "Lcom/bytedance/ee/bear/share/IShareMeta;", "<init>", "()V", "getShareType", "Lcom/bytedance/ee/bear/share/EShareType;", "isOpen", "", "setFlag", "", ForwardDependency$ForwardLocation.FLAG, "", "setShareType", "shareType", "getShareToken", "", "setShareToken", "shareToken", "getRecordShareToken", "setRecordShareToken", "getObjType", "getSubmitFrequencyLimit", "setSubmitFrequencyLimit", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "enableAnonymousSubmit", "isConstraintExternal", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultShareMeta implements IShareMeta {
    public DefaultShareMeta() {
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public boolean enableAnonymousSubmit() {
        return false;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public int getObjType() {
        return 80;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public String getRecordShareToken() {
        return "";
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public String getShareToken() {
        return "";
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public int getSubmitFrequencyLimit() {
        return 0;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public boolean isConstraintExternal() {
        return false;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public boolean isOpen() {
        return false;
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public void setFlag(int r100) {
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public void setRecordShareToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "shareToken");
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public void setShareToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "shareToken");
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public void setShareType(int r100) {
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public void setSubmitFrequencyLimit(int r100) {
    }

    @Override // com.bytedance.ee.bear.share.IShareMeta
    public EShareType getShareType() {
        return EShareType.UNSUPPORT;
    }
}
