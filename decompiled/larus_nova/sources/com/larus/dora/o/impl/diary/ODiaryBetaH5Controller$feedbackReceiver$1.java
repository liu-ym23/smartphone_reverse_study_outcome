package com.larus.dora.o.impl.diary;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/o/impl/diary/ODiaryBetaH5Controller$feedbackReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ODiaryBetaH5Controller$feedbackReceiver$1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f338438b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f338439a;

    public ODiaryBetaH5Controller$feedbackReceiver$1(f r100) {
        this.f338439a = r100;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        final String r102 = r101.getStringExtra("diary_id");
        String r103 = "";
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        final int r104 = r101.getIntExtra("feedback_action", -1);
        if (r102.length() != 0) goto L10;
        boolean r105 = true;
    L11:
        if (r105 == true) goto L36;
        if (r104 >= 0) goto L14;
    L16:
        boolean r106 = false;
    L17:
        if (r106 == false) goto L38;
        int r107 = r101.getIntExtra("feedback_target_type", 1);
        String r108 = r101.getStringExtra("feedback_target_id");
        if (r108 != null) goto L22;
    L27:
        r108 = r102;
    L28:
        String r109 = r101.getStringExtra("feedback_snapshot_json");
        if (r109 == null) goto L32;
        r103 = r109;
    L32:
        final l0 r110 = new l0(r107, r108, r103, r101.getIntExtra("feedback_diary_version", 0));
        FLogger.f375446a.i("ODiaryBetaH5", "h5 feedback diary=" + r102 + " action=" + r104 + " targetType=" + r110.f338558a + " targetId=" + r110.f338559b + " snapshotLen=" + r110.f338560c.length() + " v=" + r110.f338561d);
        View r111 = this.f338439a.f338513a.getView();
        if (r111 == null) goto L37;
        final f r112 = this.f338439a;
        r111.post(new g(r112, r102, r104, r110));
        return;
    L37:
        return;
    L22:
        if ((true ^ StringsKt.isBlank(r108)) == true) goto L25;
        r108 = null;
    L25:
        if (r108 == null) goto L27;
    L38:
        return;
    L14:
        if (r104 >= 3) goto L16;
        r106 = true;
        goto L17
    L36:
        return;
    L10:
        r105 = false;
        goto L11
    }
}
