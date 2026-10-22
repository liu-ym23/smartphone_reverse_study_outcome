package vx1;

import android.app.Activity;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements fw.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IJsBridgeManager f557455a;

    @Override // fw.d
    public Activity getActivity() {
        return this.f557455a.getActivity();
    }

    public b(IJsBridgeManager r100) {
        this.f557455a = r100;
    }
}
