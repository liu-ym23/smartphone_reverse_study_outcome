package l65;

import android.text.TextUtils;
import com.bytedance.ee.bear.doc.follow.FollowModuleState;
import com.bytedance.ee.bear.doc.follow.event.LoadStateChangedEvent;
import com.bytedance.ee.bear.drive.loader.download.DownLoadState;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements com.bytedance.ee.bear.drive.biz.preview.vc.connector.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f507703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.drive.biz.preview.vc.connector.f f507704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f507705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public py4.h f507706d;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f507707a = null;

        static {
            int[] r100 = new int[DownLoadState.values().length];
            r100[DownLoadState.Loading.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DownLoadState.LoadSuccess.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f507707a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void g() {
        if (this.f507705c == false) goto L5;
        return;
    L5:
        Iterator<T> r100 = this.f507704b.b().iterator();
    L7:
        if (r100.hasNext() == false) goto L11;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r101 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r100.next();
        if (TextUtils.equals(this.f507703a, r101.getModule()) == false) goto L7;
        r101.g();
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void onDetach() {
        if (this.f507705c == false) goto L5;
        return;
    L5:
        Iterator<T> r100 = this.f507704b.b().iterator();
    L7:
        if (r100.hasNext() == false) goto L11;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r101 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r100.next();
        if (TextUtils.equals(this.f507703a, r101.getModule()) == false) goto L7;
        r101.onDetach();
        goto L7
    }

    @Override // py4.g
    public final String getModule() {
        return this.f507703a;
    }

    @Override // py4.g
    public final void a(py4.h r100) {
        this.f507706d = r100;
        if (this.f507705c == false) goto L5;
        return;
    L5:
        this.f507704b.a(r100);
    }

    @Override // py4.g
    public final void b(FollowModuleState r100) {
        if (this.f507705c == false) goto L5;
        return;
    L5:
        Iterator<T> r101 = this.f507704b.b().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r102 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r101.next();
        if (TextUtils.equals(this.f507703a, r102.getModule()) == false) goto L7;
        r102.b(r100);
        goto L7
    }

    @Override // py4.g
    public final void c(FollowModuleState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        if (this.f507705c == false) goto L5;
        return;
    L5:
        Iterator<T> r101 = this.f507704b.b().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r102 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r101.next();
        if (TextUtils.equals(this.f507703a, r102.getModule()) == false) goto L7;
        r102.c(r100);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void d(sy4.b r100) {
        Iterator<T> r101 = this.f507704b.b().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r102 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r101.next();
        if (TextUtils.equals(this.f507703a, r102.getModule()) == false) goto L4;
        r102.d(r100);
        goto L4
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void e(boolean r100) {
        if (this.f507705c == false) goto L5;
        return;
    L5:
        Iterator<T> r101 = this.f507704b.b().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        com.bytedance.ee.bear.drive.biz.preview.vc.connector.e r102 = (com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r101.next();
        if (TextUtils.equals(this.f507703a, r102.getModule()) == false) goto L7;
        r102.e(r100);
        goto L7
    }

    @Override // com.bytedance.ee.bear.drive.biz.preview.vc.connector.e
    public final void f(boolean r100) {
        Iterator<T> r101 = this.f507704b.b().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.drive.biz.preview.vc.connector.e) r101.next()).f(r100);
        goto L4
    }

    public final void h(DownLoadState r100) {
        tt5.a.h("DriveFollowableContentDelegate", "downLoadStateChange: state= " + r100);
        if (this.f507706d != null) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        LoadStateChangedEvent.LoadState r101 = LoadStateChangedEvent.LoadState.LoadFail;
    L14:
        LoadStateChangedEvent r102 = new LoadStateChangedEvent(r101);
        py4.h r103 = this.f507706d;
        Intrinsics.checkNotNull(r103);
        r103.a(r102);
        if (r100 != DownLoadState.LoadSuccess) goto L19;
        g();
        return;
    L19:
        return;
    L7:
        int r104 = b.f507707a[r100.ordinal()];
        if (r104 != 1) goto L10;
        r101 = LoadStateChangedEvent.LoadState.Loading;
        goto L14
    L10:
        if (r104 == 2) goto L12;
        r101 = LoadStateChangedEvent.LoadState.LoadFail;
        goto L14
    L12:
        r101 = LoadStateChangedEvent.LoadState.LoadSuccess;
        goto L14
    }

    public e(String r100, com.bytedance.ee.bear.drive.biz.preview.vc.connector.f r101) {
        Intrinsics.checkNotNullParameter(r100, TextureRenderKeys.KEY_MODULE_NAME);
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f507703a = r100;
        this.f507704b = r101;
    }
}
