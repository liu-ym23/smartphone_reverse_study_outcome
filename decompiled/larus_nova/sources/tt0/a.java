package tt0;

import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f547500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f547501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f547502c;

    /* JADX INFO: renamed from: tt0.a$a, reason: collision with other inner class name */
    public static final class C7772a implements a3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f547503a;

        @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
        public final void onFail() {
        }

        public C7772a(a r100) {
            this.f547503a = r100;
        }

        @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
        public final void a(NinePatchDrawable r100) {
            Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
            View r101 = this.f547503a.f547500a.f547504a;
            if (r101 == null) goto L7;
            ViewGroup.LayoutParams r102 = r101.getLayoutParams();
            if (r102 == null) goto L7;
            r102.height = s1.f(16.0f);
        L7:
            a r103 = this.f547503a;
            TextView r104 = r103.f547500a.f547505b;
            if (r104 == null) goto L15;
            String r105 = r103.f547502c;
            if (r105 != null) goto L13;
            r105 = "";
        L13:
            r104.setText(r105);
            return;
        }
    }

    public a(b r100, k r101, String r102) {
        this.f547500a = r100;
        this.f547501b = r101;
        this.f547502c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k r100 = this.f547501b;     // Catch: Throwable -> L7
        if (r100 == null) goto L10;
        int r101 = a3.f114402d;     // Catch: Throwable -> L7
        a3.a.a(this.f547500a.f547504a, r100, new C7772a(this), 0.0f);     // Catch: Throwable -> L7
        return;
    L10:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L14;
        throw th;
    }
}
