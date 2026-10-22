package kotlinx.serialization.modules;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import juc.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes42.dex */
public final class h implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f505487a;

    public h(e r100) {
        this.f505487a = r100;
    }

    @Override // kotlinx.serialization.modules.g
    public final <T> void a(KClass<T> r100, Function1<? super List<? extends juc.d<?>>, ? extends juc.d<?>> r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f505487a.j(r100, new a.b(r101), true);
    }

    @Override // kotlinx.serialization.modules.g
    public final <T> void b(KClass<T> r100, juc.d<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "kClass");
        Intrinsics.checkNotNullParameter(r101, "serializer");
        this.f505487a.j(r100, new a.C6593a(r101), true);
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base> void c(KClass<Base> r100, Function1<? super String, ? extends juc.c<? extends Base>> r101) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "defaultDeserializerProvider");
        this.f505487a.g(r100, r101, true);
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base> void d(KClass<Base> r100, Function1<? super Base, ? extends n<? super Base>> r101) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "defaultSerializerProvider");
        this.f505487a.h(r100, r101, true);
    }

    @Override // kotlinx.serialization.modules.g
    public final <Base, Sub extends Base> void e(KClass<Base> r100, KClass<Sub> r101, juc.d<Sub> r102) {
        Intrinsics.checkNotNullParameter(r100, "baseClass");
        Intrinsics.checkNotNullParameter(r101, "actualClass");
        Intrinsics.checkNotNullParameter(r102, "actualSerializer");
        this.f505487a.i(r100, r101, r102, true);
    }
}
