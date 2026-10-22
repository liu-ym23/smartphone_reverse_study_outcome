package p18;

import android.app.Activity;
import android.content.Context;
import com.ss.android.lark.log.Log;
import l18.e;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j18.b f527324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f527325b;

    public final void b() {
        Log.i("LKBridgeContextImpl", "release");
        this.f527324a = null;
        this.f527325b = null;
    }

    @Override // l18.e, i18.c
    public Context getContext() {
        return this.f527325b;
    }

    public a(j18.b r100) {
        this.f527324a = r100;
        this.f527325b = r100.getContext();
    }

    @Override // l18.e
    public final void a(Activity r100) {
        this.f527325b = r100;
    }
}
