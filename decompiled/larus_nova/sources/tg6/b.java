package tg6;

import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.livesdk.chatroom.model.IJoinChannelResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements qg6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f545904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IJoinChannelResult f545905b;

    @Override // qg6.a
    public final void a() {
        jy0.b.a("BaseAnchorBizLinkService", "check anchor bluetooth permission!");
        this.f545904a.p();
    }

    @Override // qg6.a
    public final void b(BaseCheckException r100) {
        Intrinsics.checkNotNullParameter(r100, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
        jy0.b.a("BaseAnchorBizLinkService", "check anchor bluetooth permission failed skip");
        this.f545904a.p();
    }

    public b(a r100, IJoinChannelResult r101) {
        this.f545904a = r100;
        this.f545905b = r101;
    }
}
