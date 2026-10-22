package androidx.appcompat.app;

import android.content.Context;
import androidx.activity.contextaware.OnContextAvailableListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatActivity$2 implements OnContextAvailableListener {
    final /* synthetic */ AppCompatActivity this$0;

    public AppCompatActivity$2(AppCompatActivity r1) {
        this.this$0 = r1;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context r3) {
        AppCompatDelegate r4 = this.this$0.getDelegate();
        r4.installViewFactory();
        r4.onCreate(this.this$0.getSavedStateRegistry().consumeRestoredStateForKey("androidx:appcompat"));
    }
}
