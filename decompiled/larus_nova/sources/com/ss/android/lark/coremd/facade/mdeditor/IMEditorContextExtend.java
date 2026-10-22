package com.ss.android.lark.coremd.facade.mdeditor;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class IMEditorContextExtend extends LarkContextExtend {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419762v = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final c f419763u;

    public static final class a implements h<IMEditorContextExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f419764c;

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMEditorContextExtend) this.f419764c.a();
        }

        public a() {
            this.f419764c = new ExtendProviderImpl(IMEditorContextExtend.class);
        }
    }

    static {
        f419762v = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMEditorContextExtend.class, "chatIdProvider", "getChatIdProvider(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function0;", 0))};
        new a();
    }

    public IMEditorContextExtend() {
        IMEditorContextExtend$chatIdProvider$2 r100 = IMEditorContextExtend$chatIdProvider$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "defaultProvider");
        KProperty<Object> r101 = f419762v[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r102 = d.f419619a;
        Intrinsics.checkNotNullParameter(r101, "kProperty");
        Intrinsics.checkNotNullParameter(r100, "value");
        d.f419619a.put(e.a(r101), r100);
        this.f419763u = new c();
    }
}
