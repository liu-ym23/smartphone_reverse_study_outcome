package com.bytedance.creativex.model.mapping;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
public final class InitialModelExtraMapping extends DefaultModelExtraMapping {

    /* JADX INFO: renamed from: com.bytedance.creativex.model.mapping.InitialModelExtraMapping$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Class;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 1})
    public static final class AnonymousClass1 extends Lambda implements Function1<Class<?>, Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Class<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            return true;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Class<?> r100) {
            return Boolean.valueOf(invoke2(r100));
        }
    }

    public InitialModelExtraMapping(Function1<? super Class<?>, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "isTypeSupported");
        super(r100);
    }

    @Override // com.bytedance.creativex.model.mapping.a
    public final Class<?> get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r100, "name");
        Object r101 = ((LinkedHashMap) this.f204225a).get(r100);
        if (r101 == null) goto L7;
        return (Class) r101;
    L7:
        throw new IllegalArgumentException(("unregistered key:" + r100).toString());
    }
}
