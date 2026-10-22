package com.bytedance.ies.sdk.widgets;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public class DataCenter extends ViewModel {
    private Map<String, Object> dataStore;
    private Handler handler;
    private boolean isCleared;
    public LifecycleOwner lifecycleOwner;
    private Map<String, NextLiveData<KVData>> liveDataMap;
    private Thread mainThread;

    public static /* synthetic */ void Mo(DataCenter r100, Bundle r101) {
        r100.lambda$put$0(r101);
    }

    public static /* synthetic */ void yo(DataCenter r100, String r101, Object r102) {
        r100.lambda$put$1(r101, r102);
    }

    private boolean notMainThread() {
        if (this.mainThread != null) goto L6;
        this.mainThread = ThreadMethodProxy.getLooperThread(Looper.getMainLooper());
    L6:
        if (ThreadMethodProxy.currentThread() == this.mainThread) goto L8;
        return true;
    L8:
        return false;
    }

    public DataCenter() {
        this.dataStore = new HashMap();
        this.liveDataMap = new HashMap();
        this.handler = new Handler(Looper.getMainLooper());
        this.isCleared = false;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        WidgetService r100 = WidgetService.getInstance();
        StringBuilder r101 = new StringBuilder("onCleared lifecycleOwner:");
        LifecycleOwner r102 = this.lifecycleOwner;
        if (r102 != null) goto L5;
        String r103 = "";
    L6:
        r101.append(r103);
        r101.append(" DataCenter:");
        r101.append(hashCode());
        r100.aLogI("【widget】", r101.toString());
        this.isCleared = true;
        this.dataStore.clear();
        this.liveDataMap.clear();
        this.lifecycleOwner = null;
        this.handler.removeCallbacksAndMessages(null);
        return;
    L5:
        r103 = r102.toString();
        goto L6
    }

    public boolean isCleared() {
        return this.isCleared;
    }

    private NextLiveData<KVData> getLiveData(String r100) {
        NextLiveData<KVData> r101 = this.liveDataMap.get(r100);
        if (r101 != null) goto L8;
        r101 = new NextLiveData();
        if (this.dataStore.containsKey(r100) == false) goto L7;
        r101.setValue(new KVData(r100, this.dataStore.get(r100)));
    L7:
        this.liveDataMap.put(r100, r101);
    L8:
        return r101;
    }

    private /* synthetic */ void lambda$put$0(Bundle r100) {
        put(r100);
    }

    public <T> T get(String r100) {
        T r101 = (T) this.dataStore.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return null;
    }

    public boolean has(String r100) {
        return this.dataStore.containsKey(r100);
    }

    public DataCenter put(final Bundle r100) {
        if (notMainThread() == false) goto L6;
        this.handler.post(new a(this, r100));
        return this;
    L6:
        if (r100 != null) goto L8;
        return this;
    L8:
        Iterator<String> r101 = r100.keySet().iterator();
    L10:
        if (r101.hasNext() == false) goto L15;
        String r102 = r101.next();
        if (r102 == null) goto L10;
        put(r102, r100.get(r102));
        goto L10
    L15:
        return this;
    }

    public DataCenter removeObserver(Observer<KVData> r100) {
        if (r100 != null) goto L4;
        return this;
    L4:
        Iterator<NextLiveData<KVData>> r101 = this.liveDataMap.values().iterator();
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().removeObserver(r100);
        goto L6
    L8:
        return this;
    }

    public static DataCenter create(ViewModelProvider r100, LifecycleOwner r101) {
        DataCenter r102 = (DataCenter) r100.get(DataCenter.class);
        r102.lifecycleOwner = r101;
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T get(Object r100, T r101) {
        if (r100 != 0) goto L5;
        return null;
    L5:
        if (r101 != null) goto L7;
    L14:
        return r100;
    L7:
        if ((r100 instanceof Number) == false) goto L11;
        if ((r101 instanceof Number) == true) goto L14;
    L11:
        if (r101.getClass().isAssignableFrom(r100.getClass()) == true) goto L14;
        return r101;
    }

    private /* synthetic */ void lambda$put$1(String r100, Object r101) {
        put(r100, r101);
    }

    public DataCenter observe(String r100, Observer<KVData> r101) {
        return observe(r100, r101, false);
    }

    public DataCenter observeForever(String r100, Observer<KVData> r101) {
        return observeForever(r100, r101, false);
    }

    public DataCenter put(final String r100, final Object r101) {
        if (notMainThread() == false) goto L6;
        this.handler.post(new b(this, r100, r101));
        return this;
    L6:
        this.dataStore.put(r100, r101);
        NextLiveData<KVData> r102 = this.liveDataMap.get(r100);
        if (r102 == null) goto L9;
        r102.setValue(new KVData(r100, r101));
    L9:
        return this;
    }

    public DataCenter removeObserver(String r100, Observer<KVData> r101) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r101 == null) goto L9;
        NextLiveData<KVData> r102 = this.liveDataMap.get(r100);
        if (r102 == null) goto L9;
        r102.removeObserver(r101);
    L9:
        return this;
    }

    public <T> T get(String r100, T r101) {
        if (this.dataStore.containsKey(r100) == true) goto L6;
        return r101;
    L6:
        return (T) get(this.dataStore.get(r100), r101);
    }

    public DataCenter observe(String r100, Observer<KVData> r101, boolean r102) {
        if (TextUtils.isEmpty(r100) == true) goto L9;
        if (r101 == null) goto L9;
        NextLiveData<KVData> r103 = getLiveData(r100);
        LifecycleOwner r104 = this.lifecycleOwner;
        if (r104 == null) goto L9;
        r103.observe(r104, r101, r102);
    L9:
        return this;
    }

    public DataCenter observeForever(String r100, Observer<KVData> r101, boolean r102) {
        if (TextUtils.isEmpty(r100) == true) goto L7;
        if (r101 == null) goto L7;
        getLiveData(r100).observeForever(r101, r102);
    L7:
        return this;
    }
}
