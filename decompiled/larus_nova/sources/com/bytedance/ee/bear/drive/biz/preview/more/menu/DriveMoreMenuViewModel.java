package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.q0;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes16.dex */
public class DriveMoreMenuViewModel extends ViewModel {
    public static final String TAG = "DriveMoreMenuViewModel";
    private a mDocDataListener;

    public static class a extends q0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<DriveMetaInfoVM> f223556a;

        public a(DriveMetaInfoVM r100) {
            this.f223556a = new WeakReference(r100);
        }

        public final u55.a i(String r100) {
            DriveMetaInfoVM r101 = this.f223556a.get();
            if (r101 != null) goto L5;
            return null;
        L5:
            if (r101.getLiveMetaInfo().getValue() != null) goto L7;
            return null;
        L7:
            if (TextUtils.equals(r100, r101.getLiveMetaInfo().getValue().f548838a) == true) goto L9;
            return null;
        L9:
            return r101.getLiveMetaInfo().getValue();
        }

        @Override // com.bytedance.ee.bear.contract.q0, com.bytedance.ee.bear.contract.c0.d
        public final void e(String r100, boolean r101) {
            u55.a r102 = i(r100);
            if (r102 == null) goto L6;
            r102.f548839b.setStared(r101);
            return;
        }

        @Override // com.bytedance.ee.bear.contract.q0, com.bytedance.ee.bear.contract.c0.d
        public final void f(String r100, boolean r101) {
            u55.a r102 = i(r100);
            if (r102 == null) goto L6;
            r102.f548839b.setPined(r101);
            return;
        }
    }

    public void onDetach() {
        if (this.mDocDataListener == null) goto L6;
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).q(this.mDocDataListener);
        this.mDocDataListener = null;
        return;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        onDetach();
    }

    public DriveMoreMenuViewModel() {
    }

    public DriveMoreMenuViewModel init(DriveMetaInfoVM r100) {
        if (this.mDocDataListener != null) goto L5;
        this.mDocDataListener = new a(r100);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).w(this.mDocDataListener);
    L5:
        return this;
    }
}
