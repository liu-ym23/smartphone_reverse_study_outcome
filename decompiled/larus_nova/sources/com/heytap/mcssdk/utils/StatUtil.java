package com.heytap.mcssdk.utils;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.PushService;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.msp.push.mode.MessageStat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public class StatUtil {
    private static final String COUNT = "count";
    private static final int MCS_SUPPORT_VERSION = 1017;
    private static final String STAT_LIST = "list";
    private static final String TYPE = "type";

    public StatUtil() {
    }

    private static boolean isSupportStatisticByMcs(Context r100) {
        String r101 = PushService.getInstance().getMcsPackageName(r100);
        if (Utils.isExistPackage(r100, r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (Utils.getVersionCode(r100, r101) < 1017) goto L7;
        return true;
    }

    public static void statisticMessage(Context r100, MessageStat r101) {
        LinkedList r102 = new LinkedList();
        r102.add(r101);
        statisticMessage(r100, r102);
    }

    public static boolean statisticMessage(Context r100, List<MessageStat> r101) {
        LinkedList r102 = new LinkedList();
        r102.addAll(r101);
        d.b("isSupportStatisticByMcs:" + isSupportStatisticByMcs(r100) + ",list size:" + r102.size());
        if (r102.size() > 0) goto L5;
        return false;
    L5:
        if (isSupportStatisticByMcs(r100) == true) goto L7;
        return false;
    L7:
        return statisticMessageByMcs(r100, r102);
    }

    private static boolean statisticMessageByMcs(Context r100, List<MessageStat> r101) {
        Intent r102 = new Intent();     // Catch: Exception -> L9
        r102.setAction(PushService.getInstance().getReceiveSdkAction(r100));     // Catch: Exception -> L9
        r102.setPackage(PushService.getInstance().getMcsPackageName(r100));     // Catch: Exception -> L9
        r102.putExtra(com.heytap.mcssdk.constant.b.f276355e, r100.getPackageName());     // Catch: Exception -> L9
        r102.putExtra("type", MessageConstant.CommandId.COMMAND_STATISTIC);     // Catch: Exception -> L9
        r102.putExtra("count", r101.size());     // Catch: Exception -> L9
        ArrayList<String> r103 = new ArrayList();     // Catch: Exception -> L9
        Iterator<MessageStat> r104 = r101.iterator();     // Catch: Exception -> L9
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r104.next().toJsonObject());     // Catch: Exception -> L9
        goto L4
    L6:
        r102.putStringArrayListExtra("list", r103);     // Catch: Exception -> L9
        r100.startService(r102);     // Catch: Exception -> L9
        return true;
    L9:
        e = move-exception;
        d.e("statisticMessage--Exception" + e.getMessage());
        return false;
    }
}
