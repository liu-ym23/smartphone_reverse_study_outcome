package l65;

import android.text.TextUtils;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.doc.follow.event.LoadStateChangedEvent;
import com.bytedance.ee.bear.drive.loader.download.DownLoadState;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements com.bytedance.ee.bear.drive.biz.preview.vc.connector.e {
    public final String a;
    public final com.bytedance.ee.bear.drive.biz.preview.vc.connector.f b;
    public boolean c;
    public py4.h d;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DownLoadState.values().length];
            r0[DownLoadState.Loading.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[DownLoadState.LoadSuccess.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void g() {
        if (this.c == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.b.b().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r1 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r0.next();
        if (TextUtils.equals(this.a, r1.getModule()) == false) goto L7;
        r1.g();
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        if (this.c == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.b.b().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r1 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r0.next();
        if (TextUtils.equals(this.a, r1.getModule()) == false) goto L7;
        r1.onDetach();
        goto L7
    }

    @Override // py4.g
    public final String getModule() {
        return this.a;
    }

    @Override // py4.g
    public final void a(py4.h r2) {
        this.d = r2;
        if (this.c == false) goto L5;
        return;
    L5:
        this.b.a(r2);
    }

    @Override // py4.g
    public final void b(FollowModuleState r5) {
        if (this.c == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.b.b().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r1 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r0.next();
        if (TextUtils.equals(this.a, r1.getModule()) == false) goto L7;
        r1.b(r5);
        goto L7
    }

    @Override // py4.g
    public final void c(FollowModuleState r5) {
        Intrinsics.checkNotNullParameter(r5, "state");
        if (this.c == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.b.b().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r1 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r0.next();
        if (TextUtils.equals(this.a, r1.getModule()) == false) goto L7;
        r1.c(r5);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void d(sy4.b r5) {
        Iterator<T> r0 = this.b.b().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r1 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r0.next();
        if (TextUtils.equals(this.a, r1.getModule()) == false) goto L4;
        r1.d(r5);
        goto L4
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void e(boolean r5) {
        if (this.c == false) goto L5;
        return;
    L5:
        Iterator<T> r0 = this.b.b().iterator();
    L7:
        if (r0.hasNext() == false) goto L11;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r1 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r0.next();
        if (TextUtils.equals(this.a, r1.getModule()) == false) goto L7;
        r1.e(r5);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void f(boolean r3) {
        Iterator<T> r0 = this.b.b().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r0.next()).f(r3);
        goto L4
    }

    public final void h(DownLoadState r4) {
        tt5.a.h("DriveFollowableContentDelegate", "downLoadStateChange: state= " + r4);
        if (this.d != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        LoadStateChangedEvent.LoadState r1 = LoadStateChangedEvent.LoadState.LoadFail;
    L14:
        LoadStateChangedEvent r0 = new LoadStateChangedEvent(r1);
        py4.h r2 = this.d;
        Intrinsics.checkNotNull(r2);
        r2.a(r0);
        if (r4 != DownLoadState.LoadSuccess) goto L19;
        g();
        return;
    L19:
        return;
    L7:
        int r3 = b.a[r4.ordinal()];
        if (r3 != 1) goto L10;
        r1 = LoadStateChangedEvent.LoadState.Loading;
        goto L14
    L10:
        if (r3 == 2) goto L12;
        r1 = LoadStateChangedEvent.LoadState.LoadFail;
        goto L14
    L12:
        r1 = LoadStateChangedEvent.LoadState.LoadSuccess;
        goto L14
    }

    public e(String r2, com.bytedance.ee.bear.drive.biz.preview.vc.connector.f r3) {
        Intrinsics.checkNotNullParameter(r2, "moduleName");
        Intrinsics.checkNotNullParameter(r3, "provider");
        this.a = r2;
        this.b = r3;
    }
}
