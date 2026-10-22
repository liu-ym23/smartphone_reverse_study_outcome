package androidx.appcompat.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatActivity$1 implements SavedStateRegistry.SavedStateProvider {
    final /* synthetic */ AppCompatActivity this$0;

    public Bundle saveState() {
        Bundle r0 = new Bundle();
        this.this$0.getDelegate().onSaveInstanceState(r0);
        return r0;
    }

    public AppCompatActivity$1(AppCompatActivity r1) {
        this.this$0 = r1;
    }
}
