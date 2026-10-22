package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.contract.q0;
import com.bytedance.ee.bear.drive.biz.extra_info.meta.DriveMetaInfoVM;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class DriveMoreMenuViewModel extends ViewModel {
    public static final String TAG = "DriveMoreMenuViewModel";
    private a mDocDataListener;

    public static class a extends q0 {
        public final WeakReference<DriveMetaInfoVM> a;

        public a(DriveMetaInfoVM r2) {
            this.a = new WeakReference(r2);
        }

        public final u55.a i(String r3) {
            DriveMetaInfoVM r0 = this.a.get();
            if (r0 != null) goto L5;
            return null;
        L5:
            if (r0.getLiveMetaInfo().getValue() != null) goto L7;
            return null;
        L7:
            if (TextUtils.equals(r3, ((u55.a) r0.getLiveMetaInfo().getValue()).a) == true) goto L9;
            return null;
        L9:
            return (u55.a) r0.getLiveMetaInfo().getValue();
        }

        @Override // com.bytedance.ee.bear.contract.q0, com.bytedance.ee.bear.contract.c0.d
        public final void e(String r1, boolean r2) {
            u55.a r3 = i(r1);
            if (r3 == null) goto L6;
            r3.b.setStared(r2);
            return;
        }

        @Override // com.bytedance.ee.bear.contract.q0, com.bytedance.ee.bear.contract.c0.d
        public final void f(String r1, boolean r2) {
            u55.a r3 = i(r1);
            if (r3 == null) goto L6;
            r3.b.setPined(r2);
            return;
        }
    }

    public void onDetach() {
        if (this.mDocDataListener == null) goto L6;
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).q(this.mDocDataListener);
        this.mDocDataListener = null;
        return;
    }

    public void onCleared() {
        super.onCleared();
        onDetach();
    }

    public DriveMoreMenuViewModel() {
    }

    public DriveMoreMenuViewModel init(DriveMetaInfoVM r2) {
        if (this.mDocDataListener != null) goto L5;
        this.mDocDataListener = new a(r2);
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).w(this.mDocDataListener);
    L5:
        return this;
    }
}
