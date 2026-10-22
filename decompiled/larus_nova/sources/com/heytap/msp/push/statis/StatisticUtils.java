package com.heytap.msp.push.statis;

import android.content.Context;
import com.heytap.mcssdk.utils.StatUtil;
import com.heytap.msp.push.mode.DataMessage;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class StatisticUtils {
    public StatisticUtils() {
    }

    public static boolean statisticEvent(Context r100, String r101) {
        ArrayList r102 = new ArrayList();
        r102.add(new MessageStat(r100.getPackageName(), r101));
        return StatUtil.statisticMessage(r100, r102);
    }

    public static boolean statisticEvent(Context r110, String r111, DataMessage r112) {
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

    public static boolean statisticEvent(Context r100, List<String> r101) {
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

    public static boolean statisticEvent(Context r110, Map<String, List<DataMessage>> r111) {
        if (r111 != null) goto L6;
        return false;
    L6:
        String r112 = r110.getPackageName();
        ArrayList r113 = new ArrayList();
        Iterator<String> r114 = r111.keySet().iterator();
    L8:
        if (r114.hasNext() == false) goto L17;
        String r115 = r114.next();
        List<DataMessage> r100 = r111.get(r115);
        if (r100 != null) goto L11;
        r113.add(new MessageStat(r112, r115));
        goto L8
    L11:
        Iterator<DataMessage> r116 = r100.iterator();
    L13:
        if (r116.hasNext() == false) goto L8;
        DataMessage r101 = r116.next();
        r113.add(new MessageStat(r101.getMessageType(), r112, r101.getGlobalId(), r101.getTaskID(), r115, null, r101.getStatisticsExtra(), r101.getDataExtra()));
        goto L13
    L17:
        return StatUtil.statisticMessage(r110, r113);
    }
}
