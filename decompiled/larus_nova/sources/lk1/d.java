package lk1;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d implements c {
    public d() {
    }

    @Override // lk1.c
    public final mk1.a getComponentStatus(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return null;
    }

    @Override // lk1.c
    public final mk1.a getComponentStatusByConfig(String r100, mk1.c r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "config");
        return null;
    }

    @Override // lk1.c
    public final com.bytedance.android.live.core.arch.mvvm.d<mk1.a> observeStatusChanged(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return null;
    }

    @Override // lk1.c
    public final void updateComponentRule(String r100, mk1.b r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276366p);
    }

    @Override // lk1.c
    public final a addComponentRule(String r100, mk1.b r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, com.heytap.mcssdk.constant.b.f276366p);
        return new a();
    }
}
