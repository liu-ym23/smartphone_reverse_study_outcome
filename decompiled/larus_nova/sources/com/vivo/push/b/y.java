package com.vivo.push.b;

import android.text.TextUtils;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class y extends com.vivo.push.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f462270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f462271b;

    public y() {
        super(2012);
    }

    public final void e() {
        if (this.f462270a != null) goto L6;
        com.vivo.push.util.t.d("ReporterCommand", "reportParams is empty");
        return;
    L6:
        StringBuilder r100 = new StringBuilder("report message reportType:");
        r100.append(this.f462271b);
        r100.append(",msgId:");
        String r101 = this.f462270a.get(com.heytap.mcssdk.constant.b.f276353c);
        if (TextUtils.isEmpty(r101) == false) goto L10;
        r101 = this.f462270a.get(MusicAppletPage.KEY_MESSAGE_ID);
    L10:
        r100.append(r101);
        com.vivo.push.util.t.d("ReporterCommand", r100.toString());
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "ReporterCommand（" + this.f462271b + ")";
    }

    public y(long r100) {
        this();
        this.f462271b = r100;
    }

    public final void a(HashMap<String, String> r100) {
        this.f462270a = r100;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d r100) {
        r100.a("ReporterCommand.EXTRA_PARAMS", this.f462270a);
        r100.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f462271b);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d r100) {
        this.f462270a = (HashMap) r100.d("ReporterCommand.EXTRA_PARAMS");
        this.f462271b = r100.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f462271b);
    }
}
