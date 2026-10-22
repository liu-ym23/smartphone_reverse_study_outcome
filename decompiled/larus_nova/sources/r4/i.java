package r4;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ai.bridge.service.OnPermissionCallback;

/* JADX INFO: loaded from: classes43.dex */
public interface i {
    void a(Activity r100, e3.d r101, String r102, String[] r103, OnPermissionCallback r104);

    boolean isPermissionAllGranted(Context r100, String... r101);
}
