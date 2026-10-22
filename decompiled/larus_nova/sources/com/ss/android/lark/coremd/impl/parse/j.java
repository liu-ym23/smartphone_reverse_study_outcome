package com.ss.android.lark.coremd.impl.parse;

import com.ss.android.lark.coremd.base.parse.p;
import com.ss.android.lark.coremd.base.parse.q;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, q<s>> f419899a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, q<s>> f419900a;

        public a() {
            this.f419900a = new LinkedHashMap();
        }

        public final a a(Class r100, q r101) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            Intrinsics.checkNotNullParameter(r101, ShortVideoSegments.KEY_PROP_PROVIDER);
            this.f419900a.put(r100, r101);
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Map<Class<?>, ? extends q<s>> r100) {
        Intrinsics.checkNotNullParameter(r100, "spanFactoryMap");
        this.f419899a = r100;
    }

    @Override // com.ss.android.lark.coremd.base.parse.p
    public final Object a(com.ss.android.lark.coremd.base.parse.i r100, s r101) {
        Intrinsics.checkNotNullParameter(r100, "parseContext");
        Intrinsics.checkNotNullParameter(r101, "node");
        q<s> r102 = this.f419899a.get(r101.getClass());
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.a(new i(r100, r101));
    }
}
