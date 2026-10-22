package kotlinx.serialization.modules;

import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: kotlinx.serialization.modules.a$a, reason: collision with other inner class name */
    public static final class C6593a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final juc.d<?> f505468a;

        public final int hashCode() {
            return this.f505468a.hashCode();
        }

        public C6593a(juc.d<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "serializer");
            this.f505468a = r100;
        }

        @Override // kotlinx.serialization.modules.a
        public final juc.d<?> a(List<? extends juc.d<?>> r100) {
            Intrinsics.checkNotNullParameter(r100, "typeArgumentsSerializers");
            return this.f505468a;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof C6593a) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(((C6593a) r100).f505468a, this.f505468a) == false) goto L7;
            return true;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function1<List<? extends juc.d<?>>, juc.d<?>> f505469a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super List<? extends juc.d<?>>, ? extends juc.d<?>> r100) {
            Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.f505469a = r100;
        }

        @Override // kotlinx.serialization.modules.a
        public final juc.d<?> a(List<? extends juc.d<?>> r100) {
            Intrinsics.checkNotNullParameter(r100, "typeArgumentsSerializers");
            return this.f505469a.invoke(r100);
        }
    }

    public a() {
    }

    public abstract juc.d<?> a(List<? extends juc.d<?>> r100);
}
