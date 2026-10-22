package mo8;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d extends a {
    @Override // mo8.a
    public final String b() {
        return "message_all_complete_shown";
    }

    @Override // mo8.a
    public final String c() {
        return "client_message_render";
    }

    @Override // mo8.a
    public final String d() {
        return "message_send_by_user";
    }

    @Override // mo8.a
    public final List<String> a() {
        return CollectionsKt.mutableListOf(new String[]{"message_send_loading_hide", "message_all_first_shown", "message_content_first_shown", "message_content_complete_shown", "message_all_complete_shown"});
    }

    public d(com.larus.trace.tracespan.span.b r100) {
        Intrinsics.checkNotNullParameter(r100, "parentSpan");
        super(r100);
    }
}
