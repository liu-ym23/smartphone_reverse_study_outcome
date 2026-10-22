package v55;

import com.bytedance.ee.bear.drive.biz.permission.DriveMGPermissionVM;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f553249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DriveMGPermissionVM f553250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f553251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f553252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f553253e;

    public final void a() {
        a r100 = this.f553251c;
        if (r100 == null) goto L5;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).Lc(r100);
    L5:
        b r101 = this.f553252d;
        if (r101 == null) goto L8;
        ((com.bytedance.ee.space.sync.b) org.koin.java.a.c(com.bytedance.ee.space.sync.b.class, null, null, 6)).n8(r101);
        this.f553252d = null;
    L8:
        this.f553253e = true;
    }

    public c(String r100, DriveMGPermissionVM r101) {
        Intrinsics.checkNotNullParameter(r100, "fileId");
        Intrinsics.checkNotNullParameter(r101, "permissionVM");
        this.f553249a = r100;
        this.f553250b = r101;
    }
}
