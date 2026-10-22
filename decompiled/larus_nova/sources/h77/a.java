package h77;

import android.app.Activity;
import android.content.Context;
import com.bytedance.common.push.ActivityLifecycleAdapter;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.ThreadPlus;
import v67.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f483992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C6110a f483993b;

    /* JADX INFO: renamed from: h77.a$a, reason: collision with other inner class name */
    public class C6110a extends ActivityLifecycleAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f483994a;

        public C6110a(a r100) {
            this.f483994a = r100;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r100) {
            if (ActivityLifecycleObserver.getIns().isBackGround() == false) goto L6;
            a r101 = this.f483994a;
            r101.getClass();
            ThreadPlus.submitRunnable(new b(r101));
            return;
        }
    }

    public a(Context r100) {
        this.f483993b = new C6110a(this);
        this.f483992a = r100;
    }
}
