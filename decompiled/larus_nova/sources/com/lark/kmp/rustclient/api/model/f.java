package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.LarkError;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Exception f282476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarkError f282477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Command f282478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.lark.kmp.server.pb.improto.Command f282479d;

    public final RustClientException a() {
        StringBuilder r100 = new StringBuilder("Error encountered while processing ");
        com.lark.kmp.server.pb.improto.Command r101 = this.f282479d;
        if (r101 == null) goto L6;
        String r102 = "Server Command " + r101.getValue();
        if (r102 == null) goto L6;
    L7:
        r100.append(r102);
        r100.append('.');
        String r103 = r100.toString();
        if (this.f282477b == null) goto L22;
        StringBuilder r104 = new StringBuilder();
        r104.append(r103);
        r104.append("\nRust error: code=");
        r104.append(this.f282477b.getCode());
        r104.append(", status=");
        r104.append(this.f282477b.getStatus());
        r104.append(", dbg=");
        LarkError.ErrorDetails r105 = this.f282477b.getDetails();
        String r106 = "";
        if (r105 == null) goto L13;
        String r107 = r105.getDebug_message();
        if (r107 == null) goto L13;
    L14:
        r104.append(r107);
        r104.append(", display=");
        r104.append(this.f282477b.getDisplay_message());
        r104.append(", reqId=");
        LarkError.ErrorDetails r108 = this.f282477b.getDetails();
        if (r108 == null) goto L20;
        String r109 = r108.getServer_request_id();
        if (r109 == null) goto L20;
        r106 = r109;
    L20:
        r104.append(r106);
        r104.append('.');
        r103 = r104.toString();
    L13:
        r107 = "";
    L22:
        if (this.f282476a == null) goto L24;
        r103 = r103 + "\nAndroid error: " + this.f282476a.getMessage();
    L24:
        Exception r110 = this.f282476a;
        if (r110 == null) goto L28;
        return new RustClientException(r103, r110);
    L28:
        return new RustClientException(r103, this.f282477b);
    L6:
        r102 = "Command " + this.f282478c.getValue();
        goto L7
    }

    public f(Exception r100, LarkError r101, Command r102, com.lark.kmp.server.pb.improto.Command r103) {
        Intrinsics.checkNotNullParameter(r102, "command");
        this.f282476a = r100;
        this.f282477b = r101;
        this.f282478c = r102;
        this.f282479d = r103;
    }
}
