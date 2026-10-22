package v3b;

import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements d<w3b.b, ChatMessageResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f552978a;

    @Inject
    public c() {
        this.f552978a = new AtomicInteger(0);
    }

    @Override // v3b.d
    public final String a(w3b.d r100) {
        w3b.b r101 = (w3b.b) r100;
        Intrinsics.checkNotNullParameter(r101, "task");
        return r101.a() + '_' + this.f552978a.incrementAndGet();
    }
}
