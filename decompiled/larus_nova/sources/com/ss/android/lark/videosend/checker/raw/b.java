package com.ss.android.lark.videosend.checker.raw;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements InterLeaveChecker.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f444873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f444874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f444875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ a f444876d;

    @Override // com.ss.android.lark.videosend.checker.raw.InterLeaveChecker.a
    public final void a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "mediaPath");
        long r102 = System.currentTimeMillis() - this.f444873a;
        int r103 = 1;
        boolean r104 = !r101;
        Log.i("CheckRawTask", "checkInterLeave, result:" + r104 + ", costTime:" + r102);
        Ref.BooleanRef r105 = this.f444874b;
        boolean r106 = false;
        if (r105.element == false) goto L6;
        if (r104 == false) goto L6;
        boolean r107 = true;
    L7:
        r105.element = r107;
        Ref.BooleanRef r108 = this.f444875c;
        if (r108.element == false) goto L11;
        if (r104 == false) goto L11;
        r106 = true;
    L11:
        r108.element = r106;
        if (r105.element == false) goto L16;
        if (r106 == false) goto L15;
        r103 = 4;
    L18:
        this.f444876d.d(r103);
        return;
    L15:
        r103 = 2;
        goto L18
    L16:
        if (r106 == false) goto L18;
        r103 = 3;
    L6:
        r107 = false;
        goto L7
    }

    public b(long r100, Ref.BooleanRef r101, Ref.BooleanRef r102, a r103) {
        this.f444873a = r100;
        this.f444874b = r101;
        this.f444875c = r102;
        this.f444876d = r103;
    }
}
