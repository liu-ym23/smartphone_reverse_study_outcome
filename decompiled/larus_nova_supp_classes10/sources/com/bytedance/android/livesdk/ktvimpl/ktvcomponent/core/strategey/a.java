package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.BaseOrderSongViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public interface a extends com.bytedance.android.livesdk.ktvimpl.base.util.e {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.strategey.a$a, reason: collision with other inner class name */
    public static final class C0016a {
        public static void a(BaseOrderSongViewModel.e r1) {
            Intrinsics.checkNotNullParameter(r1, "listener");
            Intrinsics.checkNotNullParameter(r1, "listener");
            r1.onSuccess();
        }
    }

    void Fh(IBaseUser r1, h80.a<Boolean> r2);

    void release();
}
