package r0c;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f535518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f535519b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f535520c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f535521d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f535522a;

        @Override // java.lang.Runnable
        public final void run() {
            c r100 = this.f535522a;     // Catch: Throwable -> L7
            if (r100.f535521d == false) goto L5;
            e.a(r100.f535518a, "key_result_forwarded_image", r100.f535520c);     // Catch: Throwable -> L7
        L12:
            return;
        L5:
            q0c.b r101 = p0c.a.a();     // Catch: Throwable -> L7
            c r102 = this.f535522a;     // Catch: Throwable -> L7
            r101.goImageForwardSelectPage(r102.f535518a, r102.f535520c, 16);     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        }

        public a(c r100) {
            this.f535522a = r100;
        }
    }

    @Override // r0c.d
    public final String a() {
        return UIUtils.getString(this.f535518a, R.string.Lark_Legacy_MenuForward);
    }

    @Override // r0c.d
    public final Runnable getAction() {
        return new a(this);
    }

    @Override // r0c.d
    public final boolean isValid() {
        return this.f535519b;
    }

    public c(Context r100, boolean r101, String r102, boolean r103) {
        this.f535518a = r100;
        this.f535519b = r101;
        this.f535520c = r102;
        this.f535521d = r103;
    }
}
