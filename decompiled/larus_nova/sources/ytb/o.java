package ytb;

import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class o implements com.ss.android.lark.chat.core.api.d {
    @Override // com.ss.android.lark.chat.core.api.d
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "cId");
        Intrinsics.checkNotNullParameter(r101, "chatId");
    }

    @Inject
    public o() {
        kotlinx.coroutines.flow.e.a(SharedFlowKt.MutableSharedFlow$default(0, 0, null, 6, null));
    }
}
