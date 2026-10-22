package v99;

import androidx.fragment.app.Fragment;
import com.larus.feishu.office.im.impl.smart_reply.FlowSmartReplyFloatExpandExtension;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o implements aya.d {
    public o() {
    }

    @Override // aya.d
    public final FlowSmartReplyFloatExpandExtension a(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        return new FlowSmartReplyFloatExpandExtension(r100);
    }
}
