package fja;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes33.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f477537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ float f477538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f477539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ View f477540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ RunMode f477541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f477542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ RepeatMode f477543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ List f477544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Function3 f477545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Function2 f477546j;

    public e(d r100, float r101, boolean r102, View r103, RunMode r104, float r105, RepeatMode r106, List r107, Function3 r108, Function2 r110) {
        this.f477537a = r100;
        this.f477538b = r101;
        this.f477539c = r102;
        this.f477540d = r103;
        this.f477541e = r104;
        this.f477542f = r105;
        this.f477543g = r106;
        this.f477544h = r107;
        this.f477545i = r108;
        this.f477546j = r110;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f477537a.b(this.f477538b, this.f477539c, this.f477540d, this.f477541e, this.f477542f, this.f477543g, this.f477544h, this.f477545i, this.f477546j);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
