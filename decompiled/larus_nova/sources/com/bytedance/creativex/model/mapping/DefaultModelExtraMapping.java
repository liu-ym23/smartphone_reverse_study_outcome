package com.bytedance.creativex.model.mapping;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.ugc.aweme.shortvideo.ui.TimeSpeedModelExtension;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes15.dex */
public class DefaultModelExtraMapping implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Class<?>> f204225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Class<?>, Boolean> f204226b;

    /* JADX INFO: renamed from: com.bytedance.creativex.model.mapping.DefaultModelExtraMapping$1, reason: invalid class name */
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

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultModelExtraMapping(Function1<? super Class<?>, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "isTypeSupported");
        this.f204226b = r100;
        this.f204225a = new LinkedHashMap();
    }

    @Override // com.bytedance.creativex.model.mapping.a
    public final void a(Class r100) {
        Intrinsics.checkNotNullParameter(TimeSpeedModelExtension.KEY_BEAUTY_SEGMENT_INFO, "name");
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.f204226b.invoke(r100).booleanValue() == false) goto L7;
        this.f204225a.put(TimeSpeedModelExtension.KEY_BEAUTY_SEGMENT_INFO, r100);
        return;
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
