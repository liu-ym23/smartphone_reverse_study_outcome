package t6b;

import com.ss.android.lark.biz.im.api.m1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public class e implements s6b.b<e, f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m1 f544787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b<?>> f544788b;

    public interface a {
    }

    public interface b<Event extends a> {
        Class<Event> getEventType();

        void onEvent(Event r100);
    }

    public e() {
        this(null, null, null);
    }

    public jya.b d() {
        return null;
    }

    @Override // s6b.b
    public final s6b.b a() {
        return new f(this);
    }

    public List<b<?>> c() {
        return this.f544788b;
    }

    public m1 e() {
        return this.f544787a;
    }

    @Override // s6b.b
    public final s6b.b b(s6b.b r100) {
        e r101 = (e) r100;
        Intrinsics.checkNotNullParameter(r101, "patch");
        return new e(r101.e(), r101.d(), r101.c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(m1 r100, jya.b r101, List<? extends b<?>> r102) {
        this.f544787a = r100;
        this.f544788b = r102;
    }
}
