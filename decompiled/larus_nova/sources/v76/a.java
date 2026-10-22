package v76;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ies.xelement.common.LynxAudioView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends LynxAudioView {

    /* JADX INFO: renamed from: v76.a$a, reason: collision with other inner class name */
    public static final class C7969a {
        public C7969a() {
        }

        public final a a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return new a(r100);
        }
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        AttributeSet r101 = null;
        super(r100, r101, 6, 0);
    }
}
