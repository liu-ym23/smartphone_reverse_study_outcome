package mo8;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b extends a {
    @Override // mo8.a
    public final String b() {
        return "message_receive_result";
    }

    @Override // mo8.a
    public final String c() {
        return "client_message_receive_content";
    }

    @Override // mo8.a
    public final String d() {
        return "flow_im_message_receive_first_package";
    }

    @Override // mo8.a
    public final List<String> a() {
        return CollectionsKt.mutableListOf(new String[]{"flow_im_message_receive_first_chunk", "flow_im_message_receive_content_end", "flow_im_receive_all_content_end", "flow_im_message_receive_first_suggest", "flow_im_message_receive_suggest_end", "message_receive_result"});
    }

    public b(com.larus.trace.tracespan.span.b r100) {
        Intrinsics.checkNotNullParameter(r100, "parentSpan");
        super(r100);
    }
}
