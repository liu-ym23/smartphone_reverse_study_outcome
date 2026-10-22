package com.ss.android.lark.keyboard.plugin.tool.voice;

import android.content.Context;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f429828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f429829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AudioRecordMutexController f429830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b f429831d;

    public a(Function0<Unit> r100, Context r101, AudioRecordMutexController r102, b r103) {
        this.f429828a = r100;
        this.f429829b = r101;
        this.f429830c = r102;
        this.f429831d = r103;
    }

    public final void a() {
        Function0<Unit> r100 = this.f429828a;
        if (r100 == null) goto L5;
        r100.invoke();
    L10:
        String r101 = UIUtils.getString(this.f429829b, R.string.Lark_IM_RecordingInterrupted_Toast);
        Context r102 = this.f429829b;
        Intrinsics.checkNotNull(r101);
        UDToast.show(r102, r101);
        AudioRecordMutexController r103 = this.f429830c;
        b r104 = this.f429831d;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "listener");
        r103.f429807b.remove(r104);
        return;
    L5:
        StringBuilder r105 = new StringBuilder("onInterrupted cancelBlockRef is null, isParamNull:");
        if (this.f429828a != null) goto L8;
        boolean r106 = true;
    L9:
        r105.append(r106);
        Log.i("AudioRecordMutexController", r105.toString());
        goto L10
    L8:
        r106 = false;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
