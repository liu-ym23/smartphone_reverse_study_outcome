package com.ss.android.lark.chat.component.task;

import com.ss.android.lark.im.sdk.service.ImSdkService;
import com.ss.android.lark.passportc.api.Scene;
import com.ss.android.lark.passportc.api.i;
import com.ss.android.lark.passportc.task.d;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import j0c.b;
import j0c.c;
import j0c.e;
import java.util.List;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class SetLoginChatterTask implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f414712b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f414713a;

    public static final class a {
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final boolean G() {
        return false;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ Observable H(e r100) {
        return com.ss.android.lark.passportc.task.e.a(this, r100);
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List<b> dependencies() {
        return CollectionsKt.mutableListOf(new b[]{new b("switch_user")});
    }

    static {
        f414712b = new b("set_login_chatter");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final b F() {
        return f414712b;
    }

    @Inject
    public SetLoginChatterTask(i r100) {
        Intrinsics.checkNotNullParameter(r100, "multiOnlineFG");
        this.f414713a = r100;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<c> I(e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = 12;
        String r102 = null;
        boolean r103 = true;
        if (r100.f496853b == Scene.FAST_ONLINE) goto L5;
        ImSdkService.d().pd(r100.f496852a.f475033a.userId, new SetLoginChatterTask$execute$1());
        return Observable.just(new c(f414712b, r103, r102, r101));
    L5:
        return Observable.just(new c(f414712b, r103, r102, r101));
    }
}
