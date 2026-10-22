package com.bytedance.byted_bach_sdk.finder;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class DownloadableResourceFinder extends BachResourceFinder {
    private AssetManager m_assetMgr;
    private Context m_context;
    private HashMap<String, String> m_params;

    private native long nativeCreate(String r100, String[] r101, AssetManager r102);

    private native void nativeDestroy(long r100);

    private native void nativeDownloadModels(long r100, String[] r101, ModelDownloadListener r102);

    private void init() {
        PolarisFileWrapper r100 = new PolarisFileWrapper(this.m_context.getCacheDir(), DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        String[] r101 = new String[this.m_params.size() * 2];
        Iterator<String> r102 = this.m_params.keySet().iterator();
        int r103 = 0;
    L4:
        if (r102.hasNext() == false) goto L6;
        String r104 = r102.next();
        int r105 = r103 * 2;
        r101[r105] = r104;
        r101[r105 + 1] = this.m_params.get(r104);
        r103 = r103 + 1;
        goto L4
    L6:
        this.m_nativePtr = nativeCreate(r100.getAbsolutePath(), r101, this.m_assetMgr);
    }

    @Override // com.bytedance.byted_bach_sdk.finder.BachResourceFinder
    public void destroy() {
        if (this.isDestroyed == false) goto L5;
        return;
    L5:
        this.isDestroyed = true;
        nativeDestroy(this.m_nativePtr);
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public DownloadableResourceFinder(Context r100, HashMap<String, String> r101) {
        this.m_assetMgr = r100.getAssets();
        this.m_context = r100;
        this.m_params = r101;
        init();
    }

    public void downloadModels(List<String> r100, ModelDownloadListener r101) {
        String[] r102 = new String[r100.size()];
        r100.toArray(r102);
        nativeDownloadModels(this.m_nativePtr, r102, r101);
    }
}
