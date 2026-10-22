package com.larksuite.component.ignition.widget.blur;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes24.dex */
public final class BlurHelper {

    public static final class a {
    }

    static {
    }

    public BlurHelper() {
    }

    public final void a(Context r110, Bitmap r111, com.larksuite.component.ignition.widget.blur.a r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r112, "callback");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new BlurHelper$blur$3(this, r110, r111, r112, null), 2, null);
    }
}
