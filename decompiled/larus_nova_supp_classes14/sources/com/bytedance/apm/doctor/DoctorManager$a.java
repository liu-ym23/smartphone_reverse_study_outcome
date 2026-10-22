package com.bytedance.apm.doctor;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import f27.g;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class DoctorManager$a implements g {
    public final /* synthetic */ List a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public final void run() {
        Iterator r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((DoctorManager.ApmListener) r0.next()).onEvent(this.b, this.c);
        goto L4
    }

    public final AsyncTaskType getTaskType() {
        return AsyncTaskType.LIGHT_WEIGHT;
    }

    public DoctorManager$a(List r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
