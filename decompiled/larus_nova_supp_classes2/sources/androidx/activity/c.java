package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final /* synthetic */ class c implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ComponentActivity f191a;

    public /* synthetic */ c(ComponentActivity r1) {
        this.f191a = r1;
    }

    public final Bundle saveState() {
        return ComponentActivity.t1(this.f191a);
    }
}
