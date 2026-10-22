package com.bytedance.ee.bear.doc.resupdate;

import android.util.Pair;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public abstract class d extends GeckoUpdateListener {
    public d() {
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public void onActivateSuccess(UpdatePackage r100) {
        tt5.a.h("GeckoUpdateAdapter", "onActivateSuccess: channel = " + r100.getChannel());
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onClean(String r100) {
        tt5.a.h("GeckoUpdateAdapter", "onClean: channel = " + r100);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadSuccess(UpdatePackage r100) {
        tt5.a.h("GeckoUpdateAdapter", "onDownloadSuccess: channel = " + r100.getChannel());
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdateStart(UpdatePackage r100) {
        tt5.a.h("GeckoUpdateAdapter", "onUpdateStart: channel = " + r100.getChannel());
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onUpdating(String r100) {
        tt5.a.h("GeckoUpdateAdapter", "onUpdating: channel = " + r100);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onActivateFail(UpdatePackage r100, Throwable r101) {
        tt5.a.e("GeckoUpdateAdapter", "onActivateFail: channel = " + r100.getChannel(), r101, false);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r100, Throwable r101) {
        tt5.a.e("GeckoUpdateAdapter", "onCheckServerVersionFail: ", r101, false);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r100, Map<String, List<UpdatePackage>> r101) {
        tt5.a.h("GeckoUpdateAdapter", "onCheckServerVersionSuccess: ");
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onDownloadFail(UpdatePackage r100, Throwable r101) {
        tt5.a.e("GeckoUpdateAdapter", "onDownloadFail: channel = " + r100.getChannel(), r101, false);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public void onUpdateFailed(UpdatePackage r100, Throwable r101) {
        tt5.a.e("GeckoUpdateAdapter", "onUpdateFailed: channel = " + r100.getChannel(), r101, false);
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public void onUpdateSuccess(UpdatePackage r100, long r101) {
        tt5.a.h("GeckoUpdateAdapter", "onUpdateSuccess: channel = " + r100.getChannel());
    }

    @Override // com.bytedance.geckox.listener.GeckoUpdateListener
    public final void onCheckRequestIntercept(int r100, Map<String, List<Pair<String, Long>>> r101, Throwable r102) {
        tt5.a.l("GeckoUpdateAdapter", "onCheckRequestIntercept, code = " + r100, r102);
    }
}
