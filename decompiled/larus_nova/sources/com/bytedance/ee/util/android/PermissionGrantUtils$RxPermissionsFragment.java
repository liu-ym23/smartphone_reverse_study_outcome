package com.bytedance.ee.util.android;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import eu5.e;
import eu5.f;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;
import tt5.a;

/* JADX INFO: loaded from: classes19.dex */
public class PermissionGrantUtils$RxPermissionsFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, PublishSubject<e>> f243097d;

    public PermissionGrantUtils$RxPermissionsFragment() {
        this.f243097d = new HashMap();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setRetainInstance(true);
    }

    public void requestPermissions(String[] r100) {
        requestPermissions(r100, 42);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onRequestPermissionsResult(int r100, String[] r110, int[] r111) {
        super.onRequestPermissionsResult(r100, r110, r111);
        if (r100 == 42) goto L5;
        return;
    L5:
        boolean[] r101 = new boolean[r110.length];
        int r102 = 0;
    L7:
        if (r102 >= r110.length) goto L9;
        r101[r102] = shouldShowRequestPermissionRationale(r110[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        int r103 = r110.length;
        int r104 = 0;
    L10:
        if (r104 >= r103) goto L25;
        String r105 = r110[r104];
        PublishSubject r106 = (PublishSubject) ((HashMap) this.f243097d).get(r105);
        if (r106 == null) goto L13;
        Map<String, PublishSubject<e>> r107 = this.f243097d;
        HashMap r108 = (HashMap) r107;
        r108.remove(r110[r104]);
        if (r111[r104] != 0) goto L17;
        boolean r109 = true;
    L18:
        r106.onNext(new e(r110[r104], r109, r101[r104]));
        r106.onComplete();
        r104 = r104 + 1;
        goto L10
    L17:
        r109 = false;
        goto L18
    L13:
        a.d(f.f474080a, "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
        return;
    }
}
