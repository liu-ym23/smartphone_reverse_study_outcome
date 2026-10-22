package com.larus.receive.impl.handler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.minor.api.IMinorService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes31.dex */
public final class d implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f367377b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Uri> f367378a;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.receive.impl.handler.b
    public final String getName() {
        return "ReceiveUriHandler";
    }

    public d() {
        this.f367378a = new ArrayList();
    }

    @Override // com.larus.receive.impl.handler.b
    public final void a(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("landing", "currentPage");
        FLogger.f375446a.i("ReceiveUriHandler", "handle, currentPage:landing,uris:" + this.f367378a);
        if (((ArrayList) this.f367378a).isEmpty() == false) goto L8;
        if (IMinorService.f359156a.a() == true) goto L8;
        return;
    L8:
        if ((r110 instanceof AppCompatActivity) == false) goto L10;
        AppCompatActivity r100 = (AppCompatActivity) r110;
    L11:
        if (r100 == null) goto L16;
        LifecycleCoroutineScope r101 = LifecycleOwnerKt.getLifecycleScope(r100);
        if (r101 == null) goto L17;
        BuildersKt.launch$default(r101, null, null, new ReceiveUriHandler$handle$1(this, r110, "landing", null), 3, null);
        return;
    L17:
        return;
    L16:
        return;
    L10:
        r100 = null;
        goto L11
    }

    @Override // com.larus.receive.impl.handler.b
    public final boolean b(Intent r100) {
        Intrinsics.checkNotNullParameter(r100, "intent");
        ((ArrayList) this.f367378a).clear();
        List r101 = qs9.a.b(r100);
        if (r101 == null) goto L6;
        ((ArrayList) this.f367378a).addAll(r101);
    L6:
        return !((ArrayList) this.f367378a).isEmpty();
    }
}
