package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Consumer {
    public final /* synthetic */ io.reactivex.disposables.a a;
    public final /* synthetic */ nc5.a<Boolean> b;
    public final /* synthetic */ f c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ int f;
    public final /* synthetic */ long g;

    public h(io.reactivex.disposables.a r1, nc5.a<Boolean> r2, f r3, String r4, String r5, int r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public final void accept(Object r10) {
        Result r11 = (Result) r10;
        if (r11.code == 0) goto L5;
        this.a.dispose();
        this.b.onFailure(new NetService.ServerErrorException(r11.code, r11.msg, "", ""));
        return;
    L5:
        MoveTaskInfo r12 = (MoveTaskInfo) r11.data;
        if (r12 != null) goto L8;
        this.a.dispose();
        this.b.onFailure(new IllegalStateException("empty task info"));
        return;
    L8:
        int r0 = r12.getTaskStatus();
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L15;
        if (r0 == 2) goto L14;
        this.a.dispose();
        this.b.onFailure(new Exception("move task failed, status=" + r12.getTaskStatus()));
        return;
    L14:
        this.a.dispose();
        tt5.a.h(this.c.b, "move unified task success, taskId=" + this.d + ", taskType=" + this.e + ", info=" + r12.getTaskStatus());
        this.b.onSuccess(Boolean.TRUE);
        return;
    L15:
        f.o(this.c, this.d, this.e, this.f + 1, this.g, this.b, this.a);
    }
}
