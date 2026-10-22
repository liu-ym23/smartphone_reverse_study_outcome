package zz1;

import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.ChangeReceiverSource;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.repo.receiver.y;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i implements j12.a, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f574032a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public i(y r100) {
        Intrinsics.checkNotNullParameter(r100, "selectReceiverService");
        this.f574032a = r100;
    }

    @Override // j12.a
    public final void selectReceiver(String r100) {
        Intrinsics.checkNotNullParameter(r100, "receiverId");
        this.f574032a.a(r100, ChangeReceiverSource.Other);
    }
}
