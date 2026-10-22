package dq2;

import com.bytedance.android.live.liveinteract.revenue.battle.c0;
import com.bytedance.android.livesdk.chatroom.model.interact.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c0 f469641a;

    public final a0 a() {
        return this.f469641a.c();
    }

    public final boolean b() {
        return this.f469641a.e();
    }

    public final boolean c() {
        return this.f469641a.isGameShowing();
    }

    public m(c0 r100) {
        Intrinsics.checkNotNullParameter(r100, "original");
        this.f469641a = r100;
    }
}
