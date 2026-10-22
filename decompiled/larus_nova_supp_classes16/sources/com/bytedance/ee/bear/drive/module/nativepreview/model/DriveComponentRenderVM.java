package com.bytedance.ee.bear.drive.module.nativepreview.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\u0011R\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/drive/module/nativepreview/model/DriveComponentRenderVM;", "Landroidx/lifecycle/ViewModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "liveNativeComponentDelegate", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/ee/bear/drive/module/nativepreview/component/IDriveNativeComponentDelegate;", "getLiveNativeComponentDelegate", "()Landroidx/lifecycle/MutableLiveData;", "onViewNeedReleaseMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/ee/bear/drive/module/nativepreview/model/OnViewNeedReleaseListener;", "needBindReleaseListener", "", "bindReleaseListener", "", "listener", "notifyReleaseListener", "Companion", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveComponentRenderVM extends ViewModel implements NonProguard {
    public static final a Companion = null;
    public static final String TAG = "DriveComponentRenderVM";
    private final MutableLiveData<k85.a> liveNativeComponentDelegate;
    private final ConcurrentHashMap<String, m85.a> onViewNeedReleaseMap;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean needBindReleaseListener() {
        k85.a r0 = (k85.a) this.liveNativeComponentDelegate.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.getNeedRelease();
    }

    public final void notifyReleaseListener() {
        tt5.a.h(TAG, "notifyReleaseListener called! release size= " + this.onViewNeedReleaseMap.size());
        Iterator<Map.Entry<String, m85.a>> r0 = this.onViewNeedReleaseMap.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry<String, m85.a> r2 = r0.next();
        tt5.a.h(TAG, "notifyReleaseListener: " + r2.getKey());
        r2.getValue().onRelease();
        goto L4
    L6:
        this.onViewNeedReleaseMap.clear();
    }

    public DriveComponentRenderVM() {
        this.liveNativeComponentDelegate = new MutableLiveData();
        this.onViewNeedReleaseMap = new ConcurrentHashMap();
    }

    public final MutableLiveData<k85.a> getLiveNativeComponentDelegate() {
        return this.liveNativeComponentDelegate;
    }

    public final void bindReleaseListener(m85.a r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        if (needBindReleaseListener() == true) goto L5;
        return;
    L5:
        tt5.a.h(TAG, "bindReleaseListener: " + r3.getReleaseKey());
        this.onViewNeedReleaseMap.put(r3.getReleaseKey(), r3);
    }
}
