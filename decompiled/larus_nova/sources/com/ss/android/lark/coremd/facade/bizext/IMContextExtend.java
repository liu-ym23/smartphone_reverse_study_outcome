package com.ss.android.lark.coremd.facade.bizext;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.base.parse.b;
import com.ss.android.lark.coremd.base.parse.n;
import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkContextExtend;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class IMContextExtend extends LarkContextExtend {
    public static final a A = null;
    public static final /* synthetic */ KProperty<Object>[] B = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final m f419623u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final c f419624v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f419625w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f419626x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final c f419627y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f419628z;

    public static final class a implements h<IMContextExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f419629c;

        public final <R> R b(Function1<? super IMContextExtend, ? extends R> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return (R) this.f419629c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMContextExtend) this.f419629c.a();
        }

        public a() {
            this.f419629c = new ExtendProviderImpl(IMContextExtend.class);
        }
    }

    static {
        B = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "clickDelegate", "getClickDelegate(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/coremd/facade/click/IMNodeClickDelegate;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "messageContextData", "getMessageContextData(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/coremd/facade/bizext/context/MessageContextData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "forceRegexParsePhone", "getForceRegexParsePhone(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "anonymousUserId", "getAnonymousUserId(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "permissionContextData", "getPermissionContextData(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/coremd/facade/bizext/context/PermissionContextData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMContextExtend.class, "applyStyleFromMe", "getApplyStyleFromMe(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0))};
        A = new a();
    }

    public IMContextExtend() {
        KProperty<Object>[] r100 = B;
        KProperty<Object> r101 = r100[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f419623u = new m();
        IMContextExtend$messageContextData$2 r102 = IMContextExtend$messageContextData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r102, "defaultProvider");
        KProperty<Object> r103 = r100[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        Intrinsics.checkNotNullParameter(r103, "kProperty");
        Intrinsics.checkNotNullParameter(r102, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        r105.put(e.a(r103), r102);
        this.f419624v = new c();
        final Boolean r106 = Boolean.FALSE;
        Function1<j, Boolean> r107 = new IMContextExtend$special$$inlined$extend$1(r106);
        Intrinsics.checkNotNullParameter(r107, "defaultProvider");
        KProperty<Object> r108 = r100[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r108, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r108, "kProperty");
        Intrinsics.checkNotNullParameter(r107, "value");
        r105.put(e.a(r108), r107);
        this.f419625w = new c();
        final String r109 = "";
        Function1<j, String> r110 = new IMContextExtend$special$$inlined$extend$2(r109);
        Intrinsics.checkNotNullParameter(r110, "defaultProvider");
        KProperty<Object> r111 = r100[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r111, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r111, "kProperty");
        Intrinsics.checkNotNullParameter(r110, "value");
        r105.put(e.a(r111), r110);
        this.f419626x = new c();
        IMContextExtend$permissionContextData$2 r112 = IMContextExtend$permissionContextData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r112, "defaultProvider");
        KProperty<Object> r113 = r100[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r113, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r113, "kProperty");
        Intrinsics.checkNotNullParameter(r112, "value");
        r105.put(e.a(r113), r112);
        this.f419627y = new c();
        Function1<j, Boolean> r114 = new IMContextExtend$special$$inlined$extend$3(r106);
        Intrinsics.checkNotNullParameter(r114, "defaultProvider");
        KProperty<Object> r115 = r100[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r115, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r115, "kProperty");
        Intrinsics.checkNotNullParameter(r114, "value");
        r105.put(e.a(r115), r114);
        this.f419628z = new c();
    }

    public final boolean q(o r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ((Boolean) this.f419628z.getValue(r100, B[5])).booleanValue();
    }

    public final w9b.c r(n.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (w9b.c) this.f419623u.getValue(r100, B[0]);
    }

    public final v9b.a s(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (v9b.a) this.f419624v.getValue(r100, B[1]);
    }

    public final v9b.b t(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (v9b.b) this.f419627y.getValue(r100, B[4]);
    }

    public final void u(b r100, v9b.b r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f419627y.setValue(r100, B[4], r101);
    }
}
