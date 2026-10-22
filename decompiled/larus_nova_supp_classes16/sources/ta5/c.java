package ta5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.GenericLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends sa5.e {

    public class a implements GenericLifecycleObserver {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final void onStateChanged(LifecycleOwner r3, Lifecycle.Event r4) {
            tt5.a.h(this.a, "onStateChanged:" + r4);
        }
    }

    public c(AppCompatActivity r3) {
        r3.getLifecycle().addObserver(new a(r3.getClass().getSimpleName() + "#" + Integer.toHexString(r3.hashCode())));
    }
}
