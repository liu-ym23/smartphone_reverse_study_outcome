package com.bytedance.tools.protobuf.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b<T> {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.tools.protobuf.internal.b$b, reason: collision with other inner class name */
    public static final class C3800b extends b<com.bytedance.tools.protobuf.internal.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.tools.protobuf.internal.a f271028a;

        @Override // com.bytedance.tools.protobuf.internal.b
        public final com.bytedance.tools.protobuf.internal.a a() {
            return this.f271028a;
        }

        public C3800b(com.bytedance.tools.protobuf.internal.a r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f271028a = r100;
        }
    }

    public static final class c extends b<com.bytedance.tools.protobuf.internal.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.tools.protobuf.internal.a f271029a;

        @Override // com.bytedance.tools.protobuf.internal.b
        public final com.bytedance.tools.protobuf.internal.a a() {
            return this.f271029a;
        }

        public c(com.bytedance.tools.protobuf.internal.a r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f271029a = r100;
        }
    }

    public static final class d extends b<String> {
        @Override // com.bytedance.tools.protobuf.internal.b
        public final /* bridge */ /* synthetic */ String a() {
            return null;
        }
    }

    static {
    }

    public b() {
    }

    public abstract T a();
}
