package gl6;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.ies.xelement.XElementConfigLite;
import com.bytedance.ies.xelement.XElementInitializerLite;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class c extends com.lynx.tasm.behavior.a {
    public c() {
        super("x-video");
    }

    @Override // com.lynx.tasm.behavior.a
    public final LynxUI<?> createUI(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        XElementInitializerLite.Companion.getClass();
        XElementInitializerLite r101 = (XElementInitializerLite) XElementInitializerLite.access$getInstance$delegate$cp().getValue();
        Function1 r102 = new b();
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);
        r101.setConfig(new XElementConfigLite(r102, null));
        return new LynxVideoManagerLite(r100);
    }
}
