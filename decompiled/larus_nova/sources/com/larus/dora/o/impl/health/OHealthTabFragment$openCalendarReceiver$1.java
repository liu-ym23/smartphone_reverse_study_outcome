package com.larus.dora.o.impl.health;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import x69.c;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/o/impl/health/OHealthTabFragment$openCalendarReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OHealthTabFragment$openCalendarReceiver$1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f338684b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OHealthTabFragment f338685a;

    public OHealthTabFragment$openCalendarReceiver$1(OHealthTabFragment r100) {
        this.f338685a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L10;
        final String r102 = r101.getStringExtra("date");
        if (r102 == null) goto L12;
        FLogger.f375446a.i("OHealthH5", "h5 open calendar date=".concat(r102));
        View r103 = this.f338685a.getView();
        if (r103 == null) goto L11;
        final OHealthTabFragment r104 = this.f338685a;
        r103.post(new c(r104, r102));
        return;
    L11:
        return;
    L12:
        return;
    }
}
