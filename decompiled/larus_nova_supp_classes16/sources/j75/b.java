package j75;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.sdk.preview.PreviewAction;
import com.bytedance.ee.bear.drive.biz.preview.error.action.DrivePreviewActionPlugin;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public static volatile b c;
    public final Set<InterfaceC0242b> a;
    public final Handler b;

    public static class a<Data> {
        public final String a;
        public final Data b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(PreviewAction r2) {
            this.a = DrivePreviewActionPlugin.KEY_PREVIEW_ACTION;
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: j75.b$b, reason: collision with other inner class name */
    public interface InterfaceC0242b<Data> {
        String getKey();

        void onReceived(Data r1);
    }

    static {
        c = new b();
    }

    public static b a() {
        if (c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (c != null) goto L9;
        c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return c;
    }

    public b() {
        this.a = Collections.synchronizedSet(new HashSet());
        this.b = new Handler(Looper.getMainLooper());
    }

    public final void b(final a r5) {
        tt5.a.h("DriveSdk", "DriveSdkBus#notify() message=" + r5);
        Iterator<InterfaceC0242b> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        final InterfaceC0242b r1 = r0.next();
        if (TextUtils.equals(r1.getKey(), r5.a) == false) goto L4;
        this.b.post(new j75.a(r1, r5));
        goto L4
    }
}
