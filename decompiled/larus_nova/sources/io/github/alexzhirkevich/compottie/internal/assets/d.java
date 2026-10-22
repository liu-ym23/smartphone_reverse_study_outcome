package io.github.alexzhirkevich.compottie.internal.assets;

import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: classes41.dex */
@Serializable(with = io.github.alexzhirkevich.compottie.internal.assets.a.class)
public interface d {
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f491248a = null;

        static {
            f491248a = new a();
        }

        public a() {
        }

        public final juc.d<d> serializer() {
            return new io.github.alexzhirkevich.compottie.internal.assets.a();
        }
    }

    @Serializable
    public static final class b implements d {
        public static final C6305b Companion = null;

        /* JADX INFO: renamed from: io.github.alexzhirkevich.compottie.internal.assets.d$b$b, reason: collision with other inner class name */
        public static final class C6305b {
            public C6305b() {
            }

            public final juc.d<b> serializer() {
                return a.f491249a;
            }
        }

        public b() {
        }

        @Override // io.github.alexzhirkevich.compottie.internal.assets.d
        public final String getId() {
            return "";
        }

        static {
            Companion = new C6305b();
        }

        @Override // io.github.alexzhirkevich.compottie.internal.assets.d
        public final d copy() {
            return new b();
        }

        public b(int r100) {
        }
    }

    static {
        Companion = a.f491248a;
    }

    d copy();

    String getId();
}
