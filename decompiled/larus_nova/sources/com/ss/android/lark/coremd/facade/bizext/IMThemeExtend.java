package com.ss.android.lark.coremd.facade.bizext;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.facade.bizext.theme.IMAtThemeData;
import com.ss.android.lark.coremd.facade.bizext.theme.IMImageThemeData;
import com.ss.android.lark.coremd.facade.bizext.theme.IMMediaThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkImageThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkMediaThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class IMThemeExtend extends LarkThemeExtend {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f419630s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419631t = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f419632o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f419633p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f419634q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f419635r;

    public static final class a implements h<IMThemeExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f419636c;

        public final <R> R b(Function1<? super IMThemeExtend, ? extends R> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return (R) this.f419636c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMThemeExtend) this.f419636c.a();
        }

        public a() {
            this.f419636c = new ExtendProviderImpl(IMThemeExtend.class);
        }
    }

    static {
        f419631t = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMThemeExtend.class, "atThemeData", "getAtThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/facade/bizext/theme/IMAtThemeData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMThemeExtend.class, "imageThemeData", "getImageThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/facade/bizext/theme/IMImageThemeData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMThemeExtend.class, "mediaThemeData", "getMediaThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/facade/bizext/theme/IMMediaThemeData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMThemeExtend.class, "showEditMessageTag", "getShowEditMessageTag(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Z", 0))};
        f419630s = new a();
    }

    public IMThemeExtend() {
        IMThemeExtend$atThemeData$2 r100 = IMThemeExtend$atThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "defaultProvider");
        KProperty<Object>[] r101 = f419631t;
        KProperty<Object> r102 = r101[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r103 = d.f419619a;
        Intrinsics.checkNotNullParameter(r102, "kProperty");
        Intrinsics.checkNotNullParameter(r100, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        r104.put(e.a(r102), r100);
        this.f419632o = new c();
        IMThemeExtend$imageThemeData$2 r105 = IMThemeExtend$imageThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r105, "defaultProvider");
        KProperty<Object> r106 = r101[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r106, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r106, "kProperty");
        Intrinsics.checkNotNullParameter(r105, "value");
        r104.put(e.a(r106), r105);
        this.f419633p = new c();
        IMThemeExtend$mediaThemeData$2 r107 = IMThemeExtend$mediaThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r107, "defaultProvider");
        KProperty<Object> r108 = r101[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r108, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r108, "kProperty");
        Intrinsics.checkNotNullParameter(r107, "value");
        r104.put(e.a(r108), r107);
        this.f419634q = new c();
        final Boolean r109 = Boolean.TRUE;
        Function1<j, Boolean> r110 = new IMThemeExtend$special$$inlined$extend$1(r109);
        Intrinsics.checkNotNullParameter(r110, "defaultProvider");
        KProperty<Object> r111 = r101[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r111, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r111, "kProperty");
        Intrinsics.checkNotNullParameter(r110, "value");
        r104.put(e.a(r111), r110);
        this.f419635r = new c();
    }

    @Override // com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend
    public final /* bridge */ /* synthetic */ LarkAtThemeData b(com.ss.android.lark.coremd.base.parse.j r100) {
        return m(r100);
    }

    @Override // com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend
    public final /* bridge */ /* synthetic */ LarkImageThemeData h(com.ss.android.lark.coremd.base.parse.j r100) {
        return n(r100);
    }

    @Override // com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend
    public final /* bridge */ /* synthetic */ LarkMediaThemeData j(com.ss.android.lark.coremd.base.parse.j r100) {
        return o(r100);
    }

    public final IMAtThemeData m(com.ss.android.lark.coremd.base.parse.j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (IMAtThemeData) this.f419632o.getValue(r100, f419631t[0]);
    }

    public final IMImageThemeData n(com.ss.android.lark.coremd.base.parse.j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (IMImageThemeData) this.f419633p.getValue(r100, f419631t[1]);
    }

    public final IMMediaThemeData o(com.ss.android.lark.coremd.base.parse.j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (IMMediaThemeData) this.f419634q.getValue(r100, f419631t[2]);
    }

    public final boolean p(com.ss.android.lark.coremd.base.parse.j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ((Boolean) this.f419635r.getValue(r100, f419631t[3])).booleanValue();
    }
}
