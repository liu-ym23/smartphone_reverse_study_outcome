package lf6;

import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.artist.render.RenderRequest;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public final class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C6690a f509061b;

    /* JADX INFO: renamed from: lf6.a$a, reason: collision with other inner class name */
    public final class C6690a implements Function1<RenderEntity, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f509062a;

        public C6690a() {
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(RenderEntity r100) {
            mf6.a r101 = r100.f254834i;
            if (r101 == null) goto L6;
            r101.a(this.f509062a);
        L6:
            return Unit.INSTANCE;
        }
    }

    public a() {
        this.f509061b = new C6690a();
    }

    @Override // lf6.c
    public final void b(RenderRequest r100, float r101) {
        C6690a r102 = this.f509061b;
        r102.f509062a = r101;
        r100.a(r102);
    }
}
