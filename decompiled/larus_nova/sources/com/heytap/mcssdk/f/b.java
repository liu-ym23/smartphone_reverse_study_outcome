package com.heytap.mcssdk.f;

import android.app.NotificationManager;
import android.content.Context;
import com.heytap.mcssdk.utils.d;
import com.heytap.mcssdk.utils.f;
import com.heytap.msp.push.callback.IDataMessageCallBackService;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.statis.StatisticUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f276405a = 1;

    public b() {
    }

    private void a(Context r100, DataMessage r101) {
        if (r100 != null) goto L5;
        d.b("context is null");
        return;
    L5:
        d.b("Receive revokeMessage  extra : " + r101.getStatisticsExtra() + "notifyId :" + r101.getNotifyID() + "messageId : " + r101.getTaskID());
        ((NotificationManager) r100.getSystemService("notification")).cancel(r101.getNotifyID());
        b(r100, r101);
    }

    public static /* synthetic */ void a(b r100, Context r101, DataMessage r102) {
        r100.a(r101, r102);
    }

    private void b(Context r100, DataMessage r101) {
        HashMap r102 = new HashMap();
        ArrayList r103 = new ArrayList();
        r103.add(r101);
        r102.put(r101.getEventId(), r103);
        StatisticUtils.statisticEvent(r100, r102);
    }

    @Override // com.heytap.mcssdk.f.c
    public void a(final Context r100, BaseMode r101, final IDataMessageCallBackService r102) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getType() != 4103) goto L10;
        final DataMessage r103 = (DataMessage) r101;
        if (r102 == null) goto L11;
        f.b(new AnonymousClass1(this, r103, r100, r102));
        return;
    L11:
        return;
    }
}
