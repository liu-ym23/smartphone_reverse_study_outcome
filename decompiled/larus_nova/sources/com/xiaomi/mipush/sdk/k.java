package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.push.hp;

/* JADX INFO: loaded from: classes41.dex */
public class k {
    public static <T extends hp<T, ?>> void a(Context r100, Config r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Intent r102 = new Intent();
        r102.setAction("action_cr_config");
        r102.putExtra("action_cr_event_switch", r101.isEventUploadSwitchOpen());
        r102.putExtra("action_cr_event_frequency", r101.getEventUploadFrequency());
        r102.putExtra("action_cr_perf_switch", r101.isPerfUploadSwitchOpen());
        r102.putExtra("action_cr_perf_frequency", r101.getPerfUploadFrequency());
        r102.putExtra("action_cr_event_en", r101.isEventEncrypted());
        r102.putExtra("action_cr_max_file_size", r101.getMaxFileLength());
        u.a(r100).m8787a(r102);
    }
}
