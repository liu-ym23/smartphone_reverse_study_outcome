package yfa;

import android.content.Context;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.obric.assistant.special_input.ObricSpecialInputServiceDelegate;
import com.obric.assistant.spi.actionbar.ObricSpecialInputType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import up8.b;
import wa8.a0;

/* JADX INFO: loaded from: classes33.dex */
public final class a extends b {
    @Override // up8.d
    public final boolean a() {
        return true;
    }

    @Override // up8.d
    public final /* bridge */ /* synthetic */ String g() {
        return null;
    }

    @Override // up8.b
    public final void k(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "defaultStateTemplate");
    }

    @Override // up8.b
    public int getType() {
        return ObricSpecialInputType.SPECIAL_INPUT.getType();
    }

    public a() {
    }

    @Override // up8.b
    public final AbsInstructionWidget e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = ObricSpecialInputServiceDelegate.f392626b.b(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.larus.bmhome.instruction.base.AbsInstructionWidget");
        return (AbsInstructionWidget) r101;
    }

    @Override // up8.b
    public final a0 n(String r100) {
        return new a0(Boolean.TRUE, "text list selector is empty template");
    }
}
