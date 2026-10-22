package com.heytap.mcssdk.g;

import android.content.Context;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class a {
    public a() {
    }

    public static boolean a(Context r100, String r101) {
        ArrayList r102 = new ArrayList();
        r102.add(new MessageStat(r100.getPackageName(), r101));
        return StatUtil.statisticMessage(r100, r102);
    }

    public static boolean a(Context r110, String r111, DataMessage r112) {
        ArrayList r100 = new ArrayList();
        String r101 = r110.getPackageName();
        if (r112 != null) goto L5;
        MessageStat r113 = new MessageStat(r101, r111);
    L6:
        r100.add(r113);
        return StatUtil.statisticMessage(r110, r100);
    L5:
        r113 = new MessageStat(r112.getMessageType(), r101, r112.getGlobalId(), r112.getTaskID(), r111, null, r112.getStatisticsExtra(), r112.getDataExtra());
        goto L6
    }

    public static boolean a(Context r100, List<String> r101) {
        ArrayList r102 = new ArrayList();
        String r103 = r100.getPackageName();
        if (r101 == null) goto L11;
        if (r101.size() == 0) goto L11;
        Iterator<String> r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L11;
        r102.add(new MessageStat(r103, r104.next()));
    L11:
        return StatUtil.statisticMessage(r100, r102);
    }
}
