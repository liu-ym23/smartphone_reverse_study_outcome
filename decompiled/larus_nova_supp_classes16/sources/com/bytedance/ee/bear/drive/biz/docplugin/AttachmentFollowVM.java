package com.bytedance.ee.bear.drive.biz.docplugin;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceThirdPartyOpenEntity;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\r0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/docplugin/AttachmentFollowVM;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "closeCMD", "Landroidx/lifecycle/MutableLiveData;", "", "getCloseCMD", "()Landroidx/lifecycle/MutableLiveData;", "fileBlockState", "", "getFileBlockState", "fileBlockPresenterState", "Lkotlin/Pair;", "Lcom/bytedance/ee/bear/contract/drive/sdk/entity/open/SpaceThirdPartyOpenEntity;", "getFileBlockPresenterState", "docs-follow-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AttachmentFollowVM extends ViewModel {
    private final MutableLiveData<Integer> closeCMD;
    private final MutableLiveData<Pair<Boolean, SpaceThirdPartyOpenEntity>> fileBlockPresenterState;
    private final MutableLiveData<Boolean> fileBlockState;

    public AttachmentFollowVM() {
        this.closeCMD = new MutableLiveData();
        this.fileBlockState = new MutableLiveData();
        this.fileBlockPresenterState = new MutableLiveData();
    }

    public final MutableLiveData<Integer> getCloseCMD() {
        return this.closeCMD;
    }

    public final MutableLiveData<Pair<Boolean, SpaceThirdPartyOpenEntity>> getFileBlockPresenterState() {
        return this.fileBlockPresenterState;
    }

    public final MutableLiveData<Boolean> getFileBlockState() {
        return this.fileBlockState;
    }
}
