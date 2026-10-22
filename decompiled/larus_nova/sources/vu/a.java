package vu;

import android.content.Context;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes44.dex */
public class a implements c {
    public a() {
    }

    @Override // vu.c
    public boolean b() {
        return false;
    }

    @Override // vu.c
    public Intent a(Context r100) {
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r100.getPackageName()));
    }
}
