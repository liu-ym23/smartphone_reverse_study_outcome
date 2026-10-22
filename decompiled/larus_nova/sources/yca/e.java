package yca;

import com.skydoves.balloon.Balloon;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes32.dex */
public final class e implements d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Balloon> f567292a;

    @Override // yca.d.a
    public final void dismiss() {
        Balloon r100 = this.f567292a.element;
        if (r100 == null) goto L6;
        r100.h();
        return;
    }

    public e(Ref.ObjectRef<Balloon> r100) {
        this.f567292a = r100;
    }
}
