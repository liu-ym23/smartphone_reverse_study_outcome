package ouc;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.ExperimentalSerializationApi;
import nuc.v2;
import nuc.z0;

/* JADX INFO: loaded from: classes5.dex */
public final class f0 implements juc.d<d0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f526848a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f526849b = null;

    public static final class a implements luc.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f526850b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f526851c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ z0 f526852a;

        @Override // luc.f
        public final boolean a() {
            this.f526852a.getClass();
            return false;
        }

        @Override // luc.f
        @ExperimentalSerializationApi
        public final List<Annotation> e(int r100) {
            return this.f526852a.e(r100);
        }

        @Override // luc.f
        @ExperimentalSerializationApi
        public final int g(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            return this.f526852a.g(r100);
        }

        @Override // luc.f
        @ExperimentalSerializationApi
        public final luc.f h(int r100) {
            return this.f526852a.h(r100);
        }

        @Override // luc.f
        @ExperimentalSerializationApi
        public final boolean i(int r100) {
            this.f526852a.i(r100);
            return false;
        }

        @Override // luc.f
        public final boolean isInline() {
            this.f526852a.getClass();
            return false;
        }

        static {
            f526850b = new a();
            f526851c = "kotlinx.serialization.json.JsonObject";
        }

        @Override // luc.f
        public final int d() {
            return this.f526852a.f520719d;
        }

        @Override // luc.f
        public final List<Annotation> getAnnotations() {
            this.f526852a.getClass();
            return CollectionsKt.emptyList();
        }

        @Override // luc.f
        public final luc.o getKind() {
            this.f526852a.getClass();
            return luc.p.c.f510879a;
        }

        public a() {
            kuc.a.f(StringCompanionObject.INSTANCE);
            this.f526852a = kuc.a.c(v2.f520790a, r.f526859a).f520641c;
        }

        @Override // luc.f
        public final String f() {
            return f526851c;
        }

        @Override // luc.f
        @ExperimentalSerializationApi
        public final String b(int r100) {
            this.f526852a.getClass();
            return String.valueOf(r100);
        }
    }

    public f0() {
    }

    static {
        f526848a = new f0();
        f526849b = a.f526850b;
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f526849b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        t.a(r100);
        kuc.a.f(StringCompanionObject.INSTANCE);
        return new d0(kuc.a.c(v2.f520790a, r.f526859a).deserialize(r100));
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        d0 r102 = (d0) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        t.b(r100);
        kuc.a.f(StringCompanionObject.INSTANCE);
        kuc.a.c(v2.f520790a, r.f526859a).serialize(r100, r102);
    }
}
