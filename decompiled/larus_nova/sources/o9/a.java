package o9;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.android.annie.bridge.method.z0;
import com.ss.android.lark.utils.statistics.PerfLog;
import e7.m0;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {
    public a() {
    }

    @Override // o9.b
    public final void q1(m0 r100, Context r101, z0 r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "callback");
        Unit r103 = null;
        if (r100.a() == null) goto L5;
        r101.startActivity(new Intent("android.intent.action.DIAL", Uri.fromParts("tel", r100.a(), null)));
        r102.b();
        r103 = Unit.INSTANCE;
    L5:
        if (r103 != null) goto L8;
        r102.a();
        return;
    }
}
