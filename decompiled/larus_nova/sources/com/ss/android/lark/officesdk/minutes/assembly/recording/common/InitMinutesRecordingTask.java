package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.container.OfficeSDKUserEntryPoint;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import dagger.hilt.EntryPoints;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class InitMinutesRecordingTask implements com.ss.android.lark.passportc.task.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j0c.b f433585b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Inject
    public com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f433586a;

    public static final class a {
    }

    @Inject
    public InitMinutesRecordingTask() {
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ boolean G() {
        return false;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final /* synthetic */ Observable H(j0c.e r100) {
        return com.ss.android.lark.passportc.task.e.a(this, r100);
    }

    static {
        f433585b = new j0c.b("resume_minutes_recording");
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final List dependencies() {
        return CollectionsKt.emptyList();
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final j0c.b F() {
        return f433585b;
    }

    @Override // com.ss.android.lark.passportc.task.f
    public final Observable<j0c.c> I(j0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        OfficeSDKUserComponent r102 = OfficeSDKManager.getOfficeSDKUserComponent();     // Catch: Throwable -> L8
        if (r102 == null) goto L10;
        Result.m9449constructorimpl((hub.a) ((OfficeSDKUserEntryPoint) EntryPoints.get(r102, OfficeSDKUserEntryPoint.class)).getOfficeSDKUserApi().getService(hub.a.class));     // Catch: Throwable -> L8
    L10:
        Object r103 = vub.a.f557372a;
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r104 = this.f433586a;
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r105 = null;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("componentContext");
        r104 = null;
    L14:
        String r106 = r104.getCurrentUserId();
        com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r107 = this.f433586a;
        if (r107 == null) goto L17;
        r105 = r107;
    L18:
        InitMinutesRecordingTask$execute$1 r108 = new InitMinutesRecordingTask$execute$1(r105.I());
        Intrinsics.checkNotNullParameter(r106, "userId");
        Intrinsics.checkNotNullParameter(r108, "startRuntime");
        Object r109 = vub.a.f557372a;
        monitor-enter(r109);
        long r110 = vub.a.f557373b + 1;     // Catch: Throwable -> L24
        vub.a.f557373b = r110;     // Catch: Throwable -> L24
        monitor-exit(r109);
        lvb.a.e("MmD1204RuntimeStartup", "[onUserScopeReady] user=" + vub.a.b(r106) + ", generation=" + r110);
        vub.a.a(r106, r110);
        return Observable.just(new j0c.c(f433585b, true, "", 4));
    L24:
        th = move-exception;
        throw th;
    L17:
        Intrinsics.throwUninitializedPropertyAccessException("componentContext");
    L8:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
