package sb6;

import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.revenue.platform.api.core.rx.o;
import io.reactivex.subjects.PublishSubject;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f541252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f541253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f541254c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.multilink.base.model.guestlink.b f541255d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PublishSubject f541256e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.live.base.model.message.guestlink.a f541257f;

    /* JADX INFO: renamed from: sb6.a$a, reason: collision with other inner class name */
    public static final class C7592a {
    }

    static {
    }

    public final void a() {
        this.f541252a = false;
        this.f541254c = false;
        b((com.bytedance.android.live.base.model.message.guestlink.a) f.c(pb6.a.class), BasicTestActionHandler.TEST_ACTION_RESET);
    }

    public a() {
        int r100 = o.f267521a;
        PublishSubject r101 = PublishSubject.create();
        this.f541256e = r101;
        com.bytedance.android.live.base.model.message.guestlink.a r102 = (com.bytedance.android.live.base.model.message.guestlink.a) f.c(pb6.a.class);
        this.f541257f = r102;
        r101.onNext(r102);
    }

    public final void b(com.bytedance.android.live.base.model.message.guestlink.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "channelInfo");
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r100.getChannelId() == this.f541257f.getChannelId()) goto L5;
    L8:
        jy0.b.d("GuestLinkState", "updateChannelInfo: " + r100 + ", source: " + r101);
        this.f541257f = r100;
        this.f541256e.onNext(r100);
        if ((r100 instanceof pb6.a) == false) goto L12;
        this.f541255d = null;
        return;
    L12:
        return;
    L5:
        if (r100.getVersion() >= this.f541257f.getVersion()) goto L8;
        jy0.b.c("GuestLinkState", "update ChannelInfo failed, cause: invalid version", null, 4);
    }
}
