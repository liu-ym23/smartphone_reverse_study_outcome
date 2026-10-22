package luc;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;

/* JADX INFO: loaded from: classes5.dex */
@ExperimentalSerializationApi
public abstract class o {

    @ExperimentalSerializationApi
    public static final class a extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f510875a = null;

        static {
            f510875a = new a();
        }

        public a() {
        }
    }

    @ExperimentalSerializationApi
    public static final class b extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f510876a = null;

        static {
            f510876a = new b();
        }

        public b() {
        }
    }

    public o() {
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        String r100 = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        Intrinsics.checkNotNull(r100);
        return r100;
    }
}
