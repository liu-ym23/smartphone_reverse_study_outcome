package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* JADX INFO: loaded from: classes41.dex */
public class db implements LoggerInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LoggerInterface f463328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LoggerInterface f463329b;

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String r100) {
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String r100) {
        LoggerInterface r101 = this.f463328a;
        if (r101 == null) goto L5;
        r101.log(r100);
    L5:
        LoggerInterface r102 = this.f463329b;
        if (r102 == null) goto L9;
        r102.log(r100);
        return;
    }

    public db(LoggerInterface r100, LoggerInterface r101) {
        this.f463328a = r100;
        this.f463329b = r101;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String r100, Throwable r101) {
        LoggerInterface r102 = this.f463328a;
        if (r102 == null) goto L5;
        r102.log(r100, r101);
    L5:
        LoggerInterface r103 = this.f463329b;
        if (r103 == null) goto L9;
        r103.log(r100, r101);
        return;
    }
}
