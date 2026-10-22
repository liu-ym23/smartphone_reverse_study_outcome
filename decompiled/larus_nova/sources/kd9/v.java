package kd9;

import com.larus.audio.call.play.AVInnerPlayerAdapter$linkPlayerCallback$1;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class v implements com.larus.im.service.audio.r, r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f502943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f502944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vt7.b<com.larus.im.service.audio.p> f502945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vt7.b<s> f502946d;

    public v() {
        this.f502945c = new vt7.b();
        this.f502946d = new vt7.b();
    }

    @Override // com.larus.im.service.audio.r
    public final boolean a() {
        return this.f502944b;
    }

    @Override // com.larus.im.service.audio.r
    public final boolean isPlaying() {
        return this.f502943a;
    }

    @Override // kd9.r
    public final void j(s r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        this.f502946d.add(r100);
    }

    @Override // com.larus.im.service.audio.r
    public final void l(com.larus.im.service.audio.p r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f502945c.add(r100);
    }

    @Override // com.larus.im.service.audio.r
    public final void q(AVInnerPlayerAdapter$linkPlayerCallback$1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f502945c.remove(r100);
    }

    @Override // kd9.r
    public final void s(s r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        this.f502946d.remove(r100);
    }

    public final void t(Function1<? super com.larus.im.service.audio.p, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Iterator<com.larus.im.service.audio.p> r101 = this.f502945c.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(r101.next());
        goto L4
    }

    public final void u(Function1<? super s, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "point");
        Iterator<s> r101 = this.f502946d.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.invoke(r101.next());
        goto L4
    }

    public final void v(boolean r100) {
        if (r100 == false) goto L4;
        boolean r101 = this.f502943a;
    L4:
        this.f502944b = r100;
    }
}
