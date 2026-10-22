package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ io.reactivex.disposables.a f228863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ nc5.a<Boolean> f228864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f228865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f228866d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f228867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f228868f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f228869g;

    public h(io.reactivex.disposables.a r100, nc5.a<Boolean> r101, f r102, String r103, String r104, int r105, long r106) {
        this.f228863a = r100;
        this.f228864b = r101;
        this.f228865c = r102;
        this.f228866d = r103;
        this.f228867e = r104;
        this.f228868f = r105;
        this.f228869g = r106;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Result r111 = (Result) r110;
        if (r111.code == 0) goto L5;
        this.f228863a.dispose();
        this.f228864b.onFailure(new NetService.ServerErrorException(r111.code, r111.msg, "", ""));
        return;
    L5:
        MoveTaskInfo r112 = (MoveTaskInfo) r111.data;
        if (r112 != null) goto L8;
        this.f228863a.dispose();
        this.f228864b.onFailure(new IllegalStateException("empty task info"));
        return;
    L8:
        int r100 = r112.getTaskStatus();
        if (r100 == 0) goto L15;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L14;
        this.f228863a.dispose();
        this.f228864b.onFailure(new Exception("move task failed, status=" + r112.getTaskStatus()));
        return;
    L14:
        this.f228863a.dispose();
        tt5.a.h(this.f228865c.f228853b, "move unified task success, taskId=" + this.f228866d + ", taskType=" + this.f228867e + ", info=" + r112.getTaskStatus());
        this.f228864b.onSuccess(Boolean.TRUE);
        return;
    L15:
        f.o(this.f228865c, this.f228866d, this.f228867e, this.f228868f + 1, this.f228869g, this.f228864b, this.f228863a);
    }
}
