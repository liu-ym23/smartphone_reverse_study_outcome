package hk2;

import ak2.b;
import android.content.Context;
import android.view.View;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f485543a;

    @Override // wd.e, com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalView
    public final View getView() {
        return new View(this.f485543a);
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f485543a = r100;
    }
}
