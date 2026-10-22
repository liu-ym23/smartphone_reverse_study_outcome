package com.vivo.push.restructure.a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.m.p.e;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.util.t;
import com.vivo.push.util.u;
import org.json.JSONException;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f462466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f462467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.vivo.push.restructure.request.a.a f462468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f462469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InsideNotificationItem f462470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private UnvarnishedMessage f462471f;

    private InsideNotificationItem p() {
        InsideNotificationItem r100 = this.f462470e;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intent r101 = this.f462466a;
        InsideNotificationItem r102 = null;
        if (r101 != null) goto L21;
    L19:
        this.f462470e = r102;
        return r102;
    L21:
        String r103 = r101.getStringExtra("notification_v1");     // Catch: Exception -> L15
        if (r103 == null) goto L19;
        InsideNotificationItem r104 = u.a(r103);     // Catch: Exception -> L15
        if (r104 != null) goto L23;
    L18:
        r102 = r104;
        goto L19
    L23:
        r104.setMsgId(CastLongProtector.parseLong(a()));     // Catch: Exception -> L13
    L13:
        Exception e100 = e;
    L17:
        t.a("ReceivedMessageImpl", "getNotificationMessage " + e100.getMessage());
    L15:
        e = move-exception;
        e100 = e;
        r104 = null;
        goto L17
    }

    private UnvarnishedMessage q() {
        UnvarnishedMessage r100 = this.f462471f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intent r101 = this.f462466a;
        UnvarnishedMessage r102 = null;
        if (r101 != null) goto L18;
    L16:
        this.f462471f = r102;
        return r102;
    L18:
        String r103 = r101.getStringExtra("msg_v1");     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r103) == true) goto L16;
        UnvarnishedMessage r104 = new UnvarnishedMessage(r103);     // Catch: Exception -> L14
        r104.setMsgId(CastLongProtector.parseLong(a()));     // Catch: Exception -> L12
        r102 = r104;
    L12:
        e = e;
        r102 = r104;
    L15:
        t.a("ReceivedMessageImpl", "getTransmissionMessage " + e.getMessage());
    L14:
        e = e;
        goto L15
    }

    @Override // com.vivo.push.restructure.a.a
    public final String a() {
        Intent r100 = this.f462466a;
        if (r100 == null) goto L7;
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L7;
        long r102 = r101.getLong("notify_id", 0);
    L9:
        if (r102 != 0) goto L11;
        return "";
    L11:
        return String.valueOf(r102);
    L7:
        r102 = 0;
        goto L9
    }

    @Override // com.vivo.push.restructure.a.a
    public final String c() {
        if (TextUtils.isEmpty(this.f462467b) == false) goto L6;
        this.f462467b = this.f462466a.getStringExtra("req_id");
    L6:
        return this.f462467b;
    }

    @Override // com.vivo.push.restructure.a.a
    public final long d() {
        Intent r100 = this.f462466a;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getLongExtra("ipc_start_time", 0);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean e() {
        Intent r100 = this.f462466a;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.getBooleanExtra("core_support_monitor", false);
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean f() {
        Intent r100 = this.f462466a;
        if (r100 == null) goto L8;
        Bundle r101 = r100.getExtras();
        if (r101 == null) goto L8;
        return r101.getBoolean("client_collect_node", false);
    L8:
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final com.vivo.push.restructure.request.a.a h() {
        if (this.f462468c != null) goto L12;
        String r100 = this.f462466a.getStringExtra("cf_content");
        if (r100 == null) goto L12;
        com.vivo.push.restructure.request.a.a.a r101 = new com.vivo.push.restructure.request.a.a.a(r100);     // Catch: JSONException -> L8
    L9:
        if (r101 == null) goto L12;
        this.f462468c = (com.vivo.push.restructure.request.a.a) com.vivo.push.restructure.request.a.a.f462484a.a(r101);
    L8:
        r101 = null;
    L12:
        return this.f462468c;
    }

    @Override // com.vivo.push.restructure.a.a
    public final String i() {
        if (TextUtils.isEmpty(this.f462469d) == false) goto L6;
        this.f462469d = this.f462466a.getStringExtra("content");
    L6:
        return this.f462469d;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int j() {
        Intent r100 = this.f462466a;
        if (r100 == null) goto L9;
        int r101 = r100.getIntExtra("command", -1);
        if (r101 >= 0) goto L8;
        return this.f462466a.getIntExtra(e.f25671s, -1);
    L8:
        return r101;
    L9:
        return -1;
    }

    @Override // com.vivo.push.restructure.a.a
    public final int l() {
        if (this.f462466a != null) goto L6;
        return 0;
    L6:
        if (n() == false) goto L11;
        if (p() == null) goto L11;
        return p().getTargetType();
    L11:
        if (o() == true) goto L13;
        return 0;
    L13:
        if (q() != null) goto L15;
        return 0;
    L15:
        return q().getTargetType();
    }

    @Override // com.vivo.push.restructure.a.a
    public final String m() {
        if (this.f462466a != null) goto L6;
        return "";
    L6:
        if (n() == false) goto L11;
        if (p() == null) goto L11;
        return p().getTargetContent();
    L11:
        if (o() == true) goto L13;
        return "";
    L13:
        if (q() != null) goto L15;
        return "";
    L15:
        return q().getTragetContent();
    }

    private boolean n() {
        if (j() != 4) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean o() {
        if (j() != 3) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean g() {
        com.vivo.push.restructure.request.a.a r100 = h();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.a() != 2018) goto L10;
        return true;
    L10:
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final boolean k() {
        if (j() != 5) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.vivo.push.restructure.a.a
    public final Intent b() {
        return this.f462466a;
    }

    public b(Intent r100) {
        this.f462467b = "";
        this.f462469d = "";
        this.f462466a = r100;
    }
}
