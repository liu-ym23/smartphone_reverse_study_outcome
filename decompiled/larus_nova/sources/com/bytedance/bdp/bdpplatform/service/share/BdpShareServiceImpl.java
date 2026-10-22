package com.bytedance.bdp.bdpplatform.service.share;

import android.app.Activity;
import com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareCallback;
import com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService;
import java.util.List;
import kotlin.Pair;
import pb4.a;
import pb4.b;

/* JADX INFO: loaded from: classes3.dex */
public class BdpShareServiceImpl implements BdpShareService {
    public BdpShareServiceImpl() {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final void addShareInfo(Pair<String, List<Object>> r100) {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final boolean auditShareInfo() {
        return true;
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final void clearShareInfo() {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final Pair<String, List<Object>> getNextShareInfo() {
        return null;
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final boolean isBlockChannelDefault(String r100, boolean r101) {
        return false;
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final boolean isSupportPictureToken() {
        return false;
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final void openShareDialog(Activity r100, a r101, b r102, boolean r103) {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final void openShareDialog(Activity r100, a r101, String[] r102, b r103, boolean r104) {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final void registerShareCallback(BdpShareCallback r100) {
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final boolean share(Activity r100, a r101, BdpShareCallback r102, BdpShareCallback r103) {
        return false;
    }

    @Override // com.bytedance.bdp.serviceapi.hostimpl.share.BdpShareService
    public final boolean solidifyImageWhenImageShare() {
        return true;
    }
}
