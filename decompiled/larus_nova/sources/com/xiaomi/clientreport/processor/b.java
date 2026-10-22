package com.xiaomi.clientreport.processor;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.push.bk;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class b implements IPerfProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f463025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> f143a;

    @Override // com.xiaomi.clientreport.processor.c
    public void a() {
        bk.a(this.f463025a, PerfLog.TAG_PERF, "perfUploading");
        File[] r100 = bk.m8854a(this.f463025a, "perfUploading");
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.length <= 0) goto L18;
        int r101 = r100.length;
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L19;
        File r103 = r100[r102];
        if (r103 == null) goto L13;
        List<String> r104 = e.a(this.f463025a, r103.getAbsolutePath());
        r103.delete();
        a(r104);
    L13:
        r102 = r102 + 1;
        goto L8
    L19:
        return;
    }

    @Override // com.xiaomi.clientreport.processor.d
    public void b() {
        HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> r100 = this.f143a;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.size() <= 0) goto L15;
        Iterator<String> r101 = this.f143a.keySet().iterator();
    L9:
        if (r101.hasNext() == false) goto L15;
        String r102 = r101.next();
        HashMap<String, com.xiaomi.clientreport.data.a> r103 = this.f143a.get(r102);
        if (r103 == null) goto L9;
        if (r103.size() <= 0) goto L9;
        com.xiaomi.clientreport.data.a[] r104 = new com.xiaomi.clientreport.data.a[r103.size()];
        r103.values().toArray(r104);
        a(r104);
    L15:
        this.f143a.clear();
    }

    public b(Context r100) {
        this.f463025a = r100;
    }

    private String b(com.xiaomi.clientreport.data.a r100) {
        int r101 = r100.production;
        String r102 = r100.clientInterfaceId;
        if (r101 > 0) goto L5;
    L7:
        String r103 = "";
    L8:
        PolarisFileWrapper r104 = new PolarisFileWrapper(this.f463025a.getFilesDir(), PerfLog.TAG_PERF);
        if (r104.exists() == true) goto L12;
        r104.mkdirs();
    L12:
        return new PolarisFileWrapper(r104, r103).getAbsolutePath();
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L7;
        r103 = String.valueOf(r101) + "#" + r102;
        goto L8
    }

    private String c(com.xiaomi.clientreport.data.a r100) {
        String r101 = b(r100);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        int r102 = 0;
    L7:
        if (r102 >= 20) goto L15;
        String r103 = r101 + r102;
        if (bk.m8853a(this.f463025a, r103) == true) goto L12;
        r102 = r102 + 1;
        goto L7
    L12:
        return r103;
    L15:
        return null;
    }

    @Override // com.xiaomi.clientreport.processor.d
    /* JADX INFO: renamed from: a */
    public void mo8730a(com.xiaomi.clientreport.data.a r100) {
        if ((r100 instanceof PerfClientReport) == true) goto L6;
        return;
    L6:
        if (this.f143a != null) goto L8;
        return;
    L8:
        PerfClientReport r101 = (PerfClientReport) r100;
        String r102 = a(r101);
        String r103 = e.a(r101);
        HashMap<String, com.xiaomi.clientreport.data.a> r104 = this.f143a.get(r102);
        if (r104 != null) goto L11;
        r104 = new HashMap();
    L11:
        PerfClientReport r105 = (PerfClientReport) r104.get(r103);
        if (r105 == null) goto L14;
        r101.perfCounts += r105.perfCounts;
        r101.perfLatencies += r105.perfLatencies;
    L14:
        r104.put(r103, r101);
        this.f143a.put(r102, r104);
    }

    @Override // com.xiaomi.clientreport.processor.IPerfProcessor
    public void setPerfMap(HashMap<String, HashMap<String, com.xiaomi.clientreport.data.a>> r100) {
        this.f143a = r100;
    }

    public static String a(com.xiaomi.clientreport.data.a r100) {
        return String.valueOf(r100.production) + "#" + r100.clientInterfaceId;
    }

    public void a(com.xiaomi.clientreport.data.a[] r100) {
        String r101 = c(r100[0]);
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        e.a(r101, r100);
    }

    public void a(List<String> r100) {
        bk.a(this.f463025a, r100);
    }
}
