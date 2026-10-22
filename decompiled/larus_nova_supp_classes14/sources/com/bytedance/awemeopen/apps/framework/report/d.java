package com.bytedance.awemeopen.apps.framework.report;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.domain.report.l;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements l {
    public final /* synthetic */ AosWebReportFragment a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ int g;

    public final void b() {
        FragmentActivity r0 = this.a.getActivity();
        if (r0 == null) goto L6;
        r0.finish();
        return;
    }

    public final void c(JSONObject r13) {
        r13.optInt("report_type");
        String r7 = r13.optString("report_desc");
        String r9 = r13.optString("reason");
        int r14 = this.b;
        if (r14 != 82) goto L5;
        String r15 = "102";
    L6:
        String r11 = r15;
        AosEventReporter r16 = AosEventReporter.a;
        String r2 = this.c;
        String r3 = this.d;
        String r4 = this.e;
        String r5 = this.f;
        int r6 = this.g;
        String r8 = r9.toString();
        String r10 = this.f;
        r16.getClass();
        Intrinsics.checkNotNullParameter(r2, "enterFrom");
        Intrinsics.checkNotNullParameter(r4, "authorOpenId");
        Intrinsics.checkNotNullParameter(r5, "groupId");
        Intrinsics.checkNotNullParameter(r7, "reasonText");
        Intrinsics.checkNotNullParameter(r8, "reasonType");
        Intrinsics.checkNotNullParameter(r9, "reason");
        Intrinsics.checkNotNullParameter(r10, "objectId");
        Intrinsics.checkNotNullParameter(r11, "objectType");
        d14.a r17 = b14.a.a;
        b14.a.a(t24.a.class).p(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        return;
    L5:
        r15 = String.valueOf(r14);
        goto L6
    }

    public final void a(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        if (r2 != 0) goto L5;
        AosWebReportFragment r4 = this.a;
        int r5 = AosWebReportFragment.o;
        r4.W90().setUrlLoadStatus(1);
        return;
    L5:
        AosWebReportFragment r6 = this.a;
        int r7 = AosWebReportFragment.o;
        r6.W90().setUrlLoadStatus(0);
    }

    public d(AosWebReportFragment r1, int r2, String r3, String r4, String r5, String r6, int r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
