package com.bytedance.awemeopen.apps.framework.report;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.framework.AosViewModel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/report/WebReportFragmentViewModel;", "Lcom/bytedance/awemeopen/apps/framework/framework/AosViewModel;", "", "loadStatus", "", "setUrlLoadStatus", "Landroidx/lifecycle/MutableLiveData;", "_urlLoadStatus", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "urlLoadStatus", "Landroidx/lifecycle/LiveData;", "getUrlLoadStatus", "()Landroidx/lifecycle/LiveData;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class WebReportFragmentViewModel extends AosViewModel {
    public static final a Companion = null;
    public static final int LOAD_FAILED = 0;
    public static final int LOAD_SUCCESS = 1;
    private final MutableLiveData<Integer> _urlLoadStatus;
    private final LiveData<Integer> urlLoadStatus;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public WebReportFragmentViewModel() {
        MutableLiveData<Integer> r100 = new MutableLiveData();
        r100.setValue(-1);
        this._urlLoadStatus = r100;
        this.urlLoadStatus = r100;
    }

    public final LiveData<Integer> getUrlLoadStatus() {
        return this.urlLoadStatus;
    }

    public final void setUrlLoadStatus(int r100) {
        this._urlLoadStatus.postValue(Integer.valueOf(r100));
    }
}
