package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.matrix.proto.Response;
import io.reactivex.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "errorCode", "", "errorMsg", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class CmdManager$sendCMDByBind$1$onResult$3 extends Lambda implements Function2<Integer, String, Unit> {
    final /* synthetic */ int $cmd;
    final /* synthetic */ j<Pair<Integer, Response>> $emitter;

    public CmdManager$sendCMDByBind$1$onResult$3(int r100, j<Pair<Integer, Response>> r101) {
        this.$cmd = r100;
        this.$emitter = r101;
        super(2);
    }

    public final void invoke(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMsg");
        List<Integer> r102 = a.f396997a;
        a.a(this.$cmd, this.$emitter, null, r100, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100, String r101) {
        invoke(r100.intValue(), r101);
        return Unit.INSTANCE;
    }
}
