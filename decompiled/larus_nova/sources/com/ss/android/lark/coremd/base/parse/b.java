package com.ss.android.lark.coremd.base.parse;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public interface b extends com.ss.android.lark.coremd.ext.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f419537a = null;

    public static final class a implements b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ a f419538d = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.coremd.impl.parse.a f419539c;

        static {
            f419538d = new a();
        }

        @Override // com.ss.android.lark.coremd.base.parse.b
        public final b b(b r100) {
            Intrinsics.checkNotNullParameter(r100, "that");
            return this.f419539c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.base.parse.b
        public final b clone() {
            return this.f419539c.clone();
        }

        @Override // com.ss.android.lark.coremd.ext.j
        public final Map<Object, Object> getValues() {
            return this.f419539c.f419862c;
        }

        public a() {
            this.f419539c = new com.ss.android.lark.coremd.impl.parse.a();
        }
    }

    static {
        f419537a = a.f419538d;
    }

    b b(b r100);

    b clone();
}
