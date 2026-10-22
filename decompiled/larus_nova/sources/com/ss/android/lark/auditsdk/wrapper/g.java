package com.ss.android.lark.auditsdk.wrapper;

import com.ss.android.lark.auditsdk.IAuditModuleDependency;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.security_event.ClientType;
import com.ss.android.lark.pb.security_event.Env;
import com.ss.android.lark.pb.security_event.FlagType;
import com.ss.android.lark.pb.security_event.OperatorEntity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class g implements IAuditModuleDependency.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f409732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f.c f409733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f409734c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OperatorEntity f409735d;

    @Override // com.ss.android.lark.auditsdk.IAuditModuleDependency.a
    public final void onError() {
        Log.e("AuditSdk", "create env: get deviceId failed");
        Env r100 = new Env.Builder().Client(ClientType.ClientAndroid).DID(null).Location("").UA(this.f409732a).IP("").Flag(FlagType.FlagNormal).build();
        f.c r101 = this.f409733b;
        String r102 = this.f409734c;
        Intrinsics.checkNotNull(r100);
        b.RunnableC4766b.a r103 = (b.RunnableC4766b.a) r101;
        r103.a(new f.a(r102, r100, this.f409735d));
    }

    @Override // com.ss.android.lark.auditsdk.IAuditModuleDependency.a
    public final void onSuccess(String r100) {
        Env r101 = new Env.Builder().Client(ClientType.ClientAndroid).DID(r100).Location("").UA(this.f409732a).IP("").Flag(FlagType.FlagNormal).build();
        f.c r102 = this.f409733b;
        String r103 = this.f409734c;
        Intrinsics.checkNotNull(r101);
        b.RunnableC4766b.a r104 = (b.RunnableC4766b.a) r102;
        r104.a(new f.a(r103, r101, this.f409735d));
    }

    public g(String r100, b.RunnableC4766b.a r101, String r102, OperatorEntity r103) {
        this.f409732a = r100;
        this.f409733b = r101;
        this.f409734c = r102;
        this.f409735d = r103;
    }
}
