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

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f497580c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<InterfaceC6400b> f497581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f497582b;

    public static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f497583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Data f497584b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(PreviewAction r100) {
            this.f497583a = DrivePreviewActionPlugin.KEY_PREVIEW_ACTION;
            this.f497584b = r100;
        }
    }

    /* JADX INFO: renamed from: j75.b$b, reason: collision with other inner class name */
    public interface InterfaceC6400b<Data> {
        String getKey();

        void onReceived(Data r100);
    }

    static {
        f497580c = new b();
    }

    public static b a() {
        if (f497580c != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f497580c != null) goto L9;
        f497580c = new b();     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f497580c;
    }

    public b() {
        this.f497581a = Collections.synchronizedSet(new HashSet());
        this.f497582b = new Handler(Looper.getMainLooper());
    }

    public final void b(final a r100) {
        tt5.a.h("DriveSdk", "DriveSdkBus#notify() message=" + r100);
        Iterator<InterfaceC6400b> r101 = this.f497581a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        final InterfaceC6400b r102 = r101.next();
        if (TextUtils.equals(r102.getKey(), r100.f497583a) == false) goto L4;
        this.f497582b.post(new j75.a(r102, r100));
        goto L4
    }
}
