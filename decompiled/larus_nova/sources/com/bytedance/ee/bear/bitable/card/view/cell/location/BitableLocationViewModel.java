package com.bytedance.ee.bear.bitable.card.view.cell.location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.PoiInfo;
import com.bytedance.ee.bear.lark.dependency.r;

/* JADX INFO: loaded from: classes15.dex */
public class BitableLocationViewModel extends ViewModel {
    private final MutableLiveData<Boolean> mActive;
    private final MutableLiveData<r.a> mILocationResultListener;
    private final MutableLiveData<PoiInfo> mPoiInfo;

    public BitableLocationViewModel() {
        this.mActive = new MutableLiveData(Boolean.FALSE);
        this.mPoiInfo = new MutableLiveData();
        this.mILocationResultListener = new MutableLiveData();
    }

    public MutableLiveData<Boolean> getActive() {
        return this.mActive;
    }

    public MutableLiveData<r.a> getILocationResultListener() {
        return this.mILocationResultListener;
    }

    public MutableLiveData<PoiInfo> getPoiInfo() {
        return this.mPoiInfo;
    }

    public void updateActive(boolean r100) {
        this.mActive.setValue(Boolean.valueOf(r100));
    }

    public void updateILocationResultListener(r.a r100) {
        this.mILocationResultListener.setValue(r100);
    }

    public void updatePoiInfo(PoiInfo r100) {
        this.mPoiInfo.setValue(r100);
    }
}
