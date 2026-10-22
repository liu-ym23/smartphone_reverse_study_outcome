package com.larus.dora.o.impl.diary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/o/impl/diary/ODiaryBetaH5Controller$reportReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryBetaH5Controller$reportReceiver$1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f338440b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f338441a;

    public ODiaryBetaH5Controller$reportReceiver$1(f r100) {
        this.f338441a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r110) {
        if (r110 == null) goto L10;
        String r101 = r110.getStringExtra("date");
        if (r101 == null) goto L12;
        final f.b r102 = new f.b(r101, r110.getStringExtra("diary_id"), r110.getStringExtra("last_update_time"), r110.getStringExtra("earliest_date"), r110.getIntExtra("recorded_diary_days", 0), r110.getStringExtra("report_source"), Intrinsics.areEqual(r110.getStringExtra("report_entry"), "diary_page"));
        FLogger.f375446a.i("ODiaryBetaH5", "h5 report date=" + r102.f338522a + " source=" + r102.f338527f + " fromDiaryPage=" + r102.f338528g + " earliest=" + r102.f338525d + " days=" + r102.f338526e);
        View r111 = this.f338441a.f338513a.getView();
        if (r111 == null) goto L11;
        final f r103 = this.f338441a;
        r111.post(new h(r102, r103));
        return;
    L11:
        return;
    L12:
        return;
    }
}
