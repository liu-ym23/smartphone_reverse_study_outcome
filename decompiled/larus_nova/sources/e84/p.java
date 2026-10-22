package e84;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f471339a;

    public p(Context r100) {
        this.f471339a = r100.getSharedPreferences("device_register_oaid_refine", 0);
    }
}
