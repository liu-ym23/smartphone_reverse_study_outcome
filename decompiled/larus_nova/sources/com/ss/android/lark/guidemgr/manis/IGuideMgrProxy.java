package com.ss.android.lark.guidemgr.manis;

import com.ss.android.lark.manis.annotation.RemoteCallback;
import com.ss.android.lark.manis.annotation.RemoteService;
import ee.android.framework.manis.interfaces.IHookInterface;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@RemoteService
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\rJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/guidemgr/manis/IGuideMgrProxy;", "Lee/android/framework/manis/interfaces/IHookInterface;", "report", "", "guideKey", "", "fetchFromMainProcess", "", "registerOnGuideChangeListener", "listener", "Lcom/ss/android/lark/guidemgr/manis/IGuideMgrProxy$OnGuideChangeListener;", "onGuideChanged", "guideListString", "OnGuideChangeListener", "guide-mgr_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IGuideMgrProxy extends IHookInterface {

    @RemoteCallback
    public interface a {
        void onGuideChanged(String r100);
    }

    void fetchFromMainProcess();

    void onGuideChanged(String r100);

    void registerOnGuideChangeListener(a r100);

    boolean report(String r100);
}
