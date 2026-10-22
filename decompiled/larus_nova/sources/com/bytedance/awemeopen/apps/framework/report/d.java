package com.bytedance.awemeopen.apps.framework.report;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.domain.report.l;
import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class d implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AosWebReportFragment f197614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f197615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f197616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f197617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f197618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f197619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f197620g;

    @Override // com.bytedance.awemeopen.domain.report.l
    public final void b() {
        FragmentActivity r100 = this.f197614a.getActivity();
        if (r100 == null) goto L6;
        r100.finish();
        return;
    }

    @Override // com.bytedance.awemeopen.domain.report.l
    public final void c(JSONObject r110) {
        r110.optInt("report_type");
        String r100 = r110.optString("report_desc");
        String r101 = r110.optString("reason");
        int r111 = this.f197615b;
        if (r111 != 82) goto L5;
        String r112 = BDLocationException.ERROR_UID_IS_EMPTY;
    L6:
        String r113 = r112;
        AosEventReporter r114 = AosEventReporter.f194596a;
        String r102 = this.f197616c;
        String r103 = this.f197617d;
        String r104 = this.f197618e;
        String r105 = this.f197619f;
        int r106 = this.f197620g;
        String r107 = r101.toString();
        String r115 = this.f197619f;
        r114.getClass();
        Intrinsics.checkNotNullParameter(r102, "enterFrom");
        Intrinsics.checkNotNullParameter(r104, "authorOpenId");
        Intrinsics.checkNotNullParameter(r105, "groupId");
        Intrinsics.checkNotNullParameter(r100, "reasonText");
        Intrinsics.checkNotNullParameter(r107, "reasonType");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r115, "objectId");
        Intrinsics.checkNotNullParameter(r113, "objectType");
        d14.a r116 = b14.a.f16924a;
        ((t24.a) b14.a.a(t24.a.class)).p(r102, r103, r104, r105, r106, r100, r107, r101, r115, r113);
        return;
    L5:
        r112 = String.valueOf(r111);
        goto L6
    }

    @Override // com.bytedance.awemeopen.domain.report.l
    public final void a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        if (r100 != 0) goto L5;
        AosWebReportFragment r102 = this.f197614a;
        int r103 = AosWebReportFragment.f197600o;
        r102.W90().setUrlLoadStatus(1);
        return;
    L5:
        AosWebReportFragment r104 = this.f197614a;
        int r105 = AosWebReportFragment.f197600o;
        r104.W90().setUrlLoadStatus(0);
    }

    public d(AosWebReportFragment r100, int r101, String r102, String r103, String r104, String r105, int r106) {
        this.f197614a = r100;
        this.f197615b = r101;
        this.f197616c = r102;
        this.f197617d = r103;
        this.f197618e = r104;
        this.f197619f = r105;
        this.f197620g = r106;
    }
}
