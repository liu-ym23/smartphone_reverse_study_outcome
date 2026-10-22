package iy;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: classes45.dex */
public interface e {
    JsonObject C(my.b r100);

    boolean a(DynamicCenterUpdateType r100);

    void b(my.c r100, k r101);

    boolean c(DynamicCenterGetType r100);

    void onStart();

    void onStop();
}
