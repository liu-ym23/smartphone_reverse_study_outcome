package okio;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lokio/Path;", "it", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 9, 0}, xi = 48)
final class ForwardingFileSystem$listRecursively$1 extends Lambda implements Function1<b0, b0> {
    final /* synthetic */ m this$0;

    public ForwardingFileSystem$listRecursively$1(m r100) {
        this.this$0 = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final b0 invoke2(b0 r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.this$0.getClass();
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter("listRecursively", "functionName");
        return r100;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ b0 invoke(b0 r100) {
        return invoke2(r100);
    }
}
