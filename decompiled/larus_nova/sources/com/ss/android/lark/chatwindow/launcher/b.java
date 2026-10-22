package com.ss.android.lark.chatwindow.launcher;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatBundleInput;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.ChatWindowViewModel;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import f0c.g;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends c0c.b implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f416973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f416974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<c> f416975d;

    @Override // com.ss.android.lark.chatwindow.launcher.c
    public final void U7(Context r100, Fragment r101, ChatBundleInput r102, IGetDataCallback<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "chatBundleInput");
        this.f416973b.U7(r100, r101, r102, r103);
    }

    public b(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<c> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), c.class), c.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f416973b = r103.b();
        this.f416974c = r101;
        this.f416975d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i(ChatWindowViewModel.LAUNCHER_TAG, "preparing IChatLauncherV2");
        v r102 = this.f416974c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        c r104 = (c) k.b(r102.c(r103), c.class);
        this.f416975d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
