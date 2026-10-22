package com.bytedance.ee.bear.doc.resupdate;

import android.util.Pair;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.UpdatePackage;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class d extends GeckoUpdateListener {
    public d() {
    }

    public void onActivateSuccess(UpdatePackage r3) {
        tt5.a.h("GeckoUpdateAdapter", "onActivateSuccess: channel = " + r3.getChannel());
    }

    public final void onClean(String r3) {
        tt5.a.h("GeckoUpdateAdapter", "onClean: channel = " + r3);
    }

    public final void onDownloadSuccess(UpdatePackage r3) {
        tt5.a.h("GeckoUpdateAdapter", "onDownloadSuccess: channel = " + r3.getChannel());
    }

    public final void onUpdateStart(UpdatePackage r3) {
        tt5.a.h("GeckoUpdateAdapter", "onUpdateStart: channel = " + r3.getChannel());
    }

    public final void onUpdating(String r3) {
        tt5.a.h("GeckoUpdateAdapter", "onUpdating: channel = " + r3);
    }

    public final void onActivateFail(UpdatePackage r3, Throwable r4) {
        tt5.a.e("GeckoUpdateAdapter", "onActivateFail: channel = " + r3.getChannel(), r4, false);
    }

    public void onCheckServerVersionFail(Map<String, List<Pair<String, Long>>> r3, Throwable r4) {
        tt5.a.e("GeckoUpdateAdapter", "onCheckServerVersionFail: ", r4, false);
    }

    public void onCheckServerVersionSuccess(Map<String, List<Pair<String, Long>>> r1, Map<String, List<UpdatePackage>> r2) {
        tt5.a.h("GeckoUpdateAdapter", "onCheckServerVersionSuccess: ");
    }

    public final void onDownloadFail(UpdatePackage r3, Throwable r4) {
        tt5.a.e("GeckoUpdateAdapter", "onDownloadFail: channel = " + r3.getChannel(), r4, false);
    }

    public void onUpdateFailed(UpdatePackage r3, Throwable r4) {
        tt5.a.e("GeckoUpdateAdapter", "onUpdateFailed: channel = " + r3.getChannel(), r4, false);
    }

    public void onUpdateSuccess(UpdatePackage r1, long r2) {
        tt5.a.h("GeckoUpdateAdapter", "onUpdateSuccess: channel = " + r1.getChannel());
    }

    public final void onCheckRequestIntercept(int r2, Map<String, List<Pair<String, Long>>> r3, Throwable r4) {
        tt5.a.l("GeckoUpdateAdapter", "onCheckRequestIntercept, code = " + r2, r4);
    }
}
