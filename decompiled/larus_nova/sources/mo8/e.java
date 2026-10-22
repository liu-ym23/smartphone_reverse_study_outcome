package mo8;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e extends a {
    @Override // mo8.a
    public final String b() {
        return "message_send_result";
    }

    @Override // mo8.a
    public final String c() {
        return "client_message_send";
    }

    @Override // mo8.a
    public final String d() {
        return "message_send_by_user";
    }

    @Override // mo8.a
    public final List<String> a() {
        return CollectionsKt.mutableListOf(new String[]{"message_send_by_user", "flow_im_message_sent_start", "flow_im_message_sent_end", "message_send_result"});
    }

    public e(com.larus.trace.tracespan.span.b r100) {
        Intrinsics.checkNotNullParameter(r100, "parentSpan");
        super(r100);
    }
}
