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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00040\fR\"\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/arch/DataViewModel;", "Landroidx/lifecycle/ViewModel;", "", "key", "", "data", "", "putData", "getData", "removeData", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Observer;", "observer", "observe", "", "Lwy3/b;", "dataMap", "Ljava/util/Map;", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class DataViewModel extends ViewModel {
    private final Map<String, b> dataMap;

    public DataViewModel() {
        this.dataMap = new LinkedHashMap();
    }

    public final Object getData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        b r3 = this.dataMap.get(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r3.b;
    }

    public final void removeData(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (this.dataMap.containsKey(r2) == false) goto L6;
        this.dataMap.remove(r2);
        return;
    }

    public final void putData(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        if (this.dataMap.get(r4) != null) goto L5;
        this.dataMap.put(r4, new b(r5, false));
        return;
    L5:
        b r6 = this.dataMap.get(r4);
        Intrinsics.checkNotNull(r6);
        b r7 = r6;
        r7.b = r5;
        MutableLiveData<Object> r8 = r7.a;
        if (r8 == null) goto L11;
        r8.setValue(r5);
        return;
    }

    public final void observe(String r6, LifecycleOwner r7, Observer<? super Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r8, "observer");
        b r2 = this.dataMap.get(r6);
        if (r2 != null) goto L5;
        r2 = new b(null, true);
        this.dataMap.put(r6, r2);
    L5:
        Intrinsics.checkNotNullParameter(r7, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r8, "observer");
        if (r2.a != null) goto L12;
        Object r9 = r2.b;
        if (r9 != null) goto L10;
        MutableLiveData<Object> r10 = new MutableLiveData();
    L11:
        r2.a = r10;
        goto L12
    L10:
        MutableLiveData<Object> r0 = new MutableLiveData();
        r0.setValue(r9);
        r10 = r0;
    L12:
        MutableLiveData<Object> r11 = r2.a;
        if (r11 == null) goto L16;
        r11.observe(r7, r8);
        return;
    }
}
