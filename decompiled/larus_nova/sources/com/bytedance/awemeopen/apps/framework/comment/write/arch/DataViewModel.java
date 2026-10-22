package com.bytedance.awemeopen.apps.framework.comment.write.arch;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import wy3.b;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\fR\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/arch/DataViewModel;", "Landroidx/lifecycle/ViewModel;", "", "key", "", "data", "", "putData", "getData", "removeData", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Observer;", "observer", "observe", "", "Lwy3/b;", "dataMap", "Ljava/util/Map;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DataViewModel extends ViewModel {
    private final Map<String, b> dataMap;

    public DataViewModel() {
        this.dataMap = new LinkedHashMap();
    }

    public final Object getData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        b r101 = this.dataMap.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.f561870b;
    }

    public final void removeData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.dataMap.containsKey(r100) == false) goto L6;
        this.dataMap.remove(r100);
        return;
    }

    public final void putData(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.dataMap.get(r100) != null) goto L5;
        this.dataMap.put(r100, new b(r101, false));
        return;
    L5:
        b r102 = this.dataMap.get(r100);
        Intrinsics.checkNotNull(r102);
        b r103 = r102;
        r103.f561870b = r101;
        MutableLiveData<Object> r104 = r103.f561869a;
        if (r104 == null) goto L11;
        r104.setValue(r101);
        return;
    }

    public final void observe(String r100, LifecycleOwner r101, Observer<? super Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "observer");
        b r103 = this.dataMap.get(r100);
        if (r103 != null) goto L5;
        r103 = new b(null, true);
        this.dataMap.put(r100, r103);
    L5:
        Intrinsics.checkNotNullParameter(r101, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r102, "observer");
        if (r103.f561869a != null) goto L12;
        Object r104 = r103.f561870b;
        if (r104 != null) goto L10;
        MutableLiveData<Object> r105 = new MutableLiveData();
    L11:
        r103.f561869a = r105;
        goto L12
    L10:
        MutableLiveData<Object> r106 = new MutableLiveData();
        r106.setValue(r104);
        r105 = r106;
    L12:
        MutableLiveData<Object> r107 = r103.f561869a;
        if (r107 == null) goto L16;
        r107.observe(r101, r102);
        return;
    }
}
