package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", AbsMethodDelegate.TAG_INVOKE, "()[Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 176)
public final class FlowKt__ZipKt$combine$5$1 extends Lambda implements Function0<Object[]> {
    final /* synthetic */ Flow<Object>[] $flows;

    public FlowKt__ZipKt$combine$5$1(Flow<Object>[] r100) {
        this.$flows = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object[] invoke2() {
        int r100 = this.$flows.length;
        Intrinsics.reifiedOperationMarker(0, "T?");
        return new Object[r100];
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object[] invoke() {
        return invoke2();
    }
}
