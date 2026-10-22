package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;

/* JADX INFO: loaded from: classes23.dex */
public class AutoLifecycleFragment extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<a> f277062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f277063b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HuaweiApiClient f277064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final int f277065b;

        public void a() {
            this.f277064a.disconnect();
        }

        public a(int r100, HuaweiApiClient r101) {
            this.f277064a = r101;
            this.f277065b = r100;
        }
    }

    public AutoLifecycleFragment() {
        this.f277062a = new SparseArray();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.f277063b = true;
        int r100 = 0;
    L4:
        if (r100 >= this.f277062a.size()) goto L6;
        this.f277062a.valueAt(r100).f277064a.connect(null);
        r100 = r100 + 1;
        goto L4
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        int r100 = 0;
        this.f277063b = false;
    L4:
        if (r100 >= this.f277062a.size()) goto L6;
        this.f277062a.valueAt(r100).f277064a.disconnect();
        r100 = r100 + 1;
        goto L4
    }

    public static AutoLifecycleFragment getInstance(Activity r100) {
        Preconditions.checkMainThread("Must be called on the main thread");
        AutoLifecycleFragment r101 = (AutoLifecycleFragment) r100.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");     // Catch: ClassCastException -> L7
        FragmentManager r102 = r100.getFragmentManager();     // Catch: ClassCastException -> L7
        if (r101 != null) goto L12;
        AutoLifecycleFragment r103 = new AutoLifecycleFragment();     // Catch: ClassCastException -> L7
        r102.beginTransaction().add(r103, "HmsAutoLifecycleFrag").commitAllowingStateLoss();     // Catch: ClassCastException -> L7
        r102.executePendingTransactions();     // Catch: ClassCastException -> L7
        return r103;
    L12:
        return r101;
    L7:
        e = move-exception;
        throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
    }

    public void stopAutoManage(int r100) {
        a r101 = this.f277062a.get(r100);
        this.f277062a.remove(r100);
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    public void startAutoMange(int r100, HuaweiApiClient r101) {
        Preconditions.checkNotNull(r101, "HuaweiApiClient instance cannot be null");
        if (this.f277062a.indexOfKey(r100) >= 0) goto L5;
        boolean r102 = true;
    L6:
        Preconditions.checkState(r102, "Already managing a HuaweiApiClient with this clientId: " + r100);
        this.f277062a.put(r100, new a(r100, r101));
        if (this.f277063b == false) goto L10;
        r101.connect(null);
        return;
    L10:
        return;
    L5:
        r102 = false;
        goto L6
    }
}
