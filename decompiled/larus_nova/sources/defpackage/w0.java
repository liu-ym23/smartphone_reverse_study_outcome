package defpackage;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import ue7.c;

/* JADX INFO: loaded from: classes42.dex */
public final class w0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f557768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f557769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Uri f557770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Function2<String, Object, Unit> f557771d;

    @Override // ue7.c
    public final String b() {
        return "webcast";
    }

    @Override // ue7.c
    public final Uri a() {
        return this.f557770c;
    }

    @Override // ue7.c
    public final Context context() {
        return this.f557768a;
    }

    @Override // ue7.c
    public final View i() {
        return this.f557769b;
    }

    @Override // ue7.c
    public final void sendEvent(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f557771d.invoke(r100, r101);
    }

    public w0(Context r100, View r101, Uri r102, Function2 r103) {
        this.f557768a = r100;
        this.f557769b = r101;
        this.f557770c = r102;
        this.f557771d = r103;
    }
}
