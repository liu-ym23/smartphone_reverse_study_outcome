package com.larus.larkfeed.impl.service;

import android.os.Bundle;
import com.larus.bmhome.chat.larkforward.q;
import com.larus.utils.logger.FLogger;
import com.suite.lark.platform.feature.forward.doubao.assembly.dependency.ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class j implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowLarkToDoubaoDelegate f355532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f355533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ mpc.b f355534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f355535d;

    @Override // com.larus.bmhome.chat.larkforward.o
    public final void onSuccess() {
        if (this.f355532a.f355505a.get() != this.f355533b) goto L5;
        this.f355532a.f355506b.set(null);
    L5:
        this.f355534c.onSuccess();
    }

    @Override // com.larus.bmhome.chat.larkforward.q
    public final void onSuccess(Bundle r100) {
        long r101 = this.f355532a.f355505a.get();
        long r102 = this.f355533b;
        if (r101 != r102) goto L9;
        AtomicReference<FlowLarkToDoubaoDelegate.b> r103 = this.f355532a.f355506b;
        String r104 = this.f355535d;
        if (r100 == null) goto L7;
        Bundle r105 = new Bundle(r100);
    L8:
        r103.set(new FlowLarkToDoubaoDelegate.b(r102, r104, r105));
        goto L9
    L7:
        r105 = null;
    L9:
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("cache forward result, hasChatBundle=");
        if (r100 == null) goto L12;
        boolean r108 = true;
    L13:
        r107.append(r108);
        r106.i("FlowLarkToDoubaoDelegate", r107.toString());
        this.f355534c.onSuccess();
        return;
    L12:
        r108 = false;
        goto L13
    }

    @Override // com.larus.bmhome.chat.larkforward.o
    public final void onFailure(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        if (this.f355532a.f355505a.get() != this.f355533b) goto L5;
        this.f355532a.f355506b.set(null);
    L5:
        this.f355534c.onFailure(r100, r101);
    }

    public j(FlowLarkToDoubaoDelegate r100, long r101, ForwardNewDependency$LarkToDoubaoExternalForwardExecutor$execute$1.a r102, String r103) {
        this.f355532a = r100;
        this.f355533b = r101;
        this.f355534c = r102;
        this.f355535d = r103;
    }
}
