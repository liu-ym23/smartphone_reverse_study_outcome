package com.ss.android.lark.coremdbiz.facade.bizext.props;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.coremdbiz.facade.link.LinkType;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import v7b.n;

/* JADX INFO: loaded from: classes35.dex */
public final class LarkLinkExtend implements f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f420024f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f420025g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f420026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f420027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f420028e;

    public static final class a implements h<LarkLinkExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f420029c;

        public final <R> R b(Function1<? super LarkLinkExtend, ? extends R> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return (R) this.f420029c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (LarkLinkExtend) this.f420029c.a();
        }

        public a() {
            this.f420029c = new ExtendProviderImpl(LarkLinkExtend.class);
        }
    }

    static {
        f420025g = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkLinkExtend.class, "linkType", "getLinkType(Lcom/ss/android/lark/commonmark/node/Link;)Lcom/ss/android/lark/coremdbiz/facade/link/LinkType;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkLinkExtend.class, "previewId", "getPreviewId(Lcom/ss/android/lark/commonmark/node/Link;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkLinkExtend.class, "iconInfo", "getIconInfo(Lcom/ss/android/lark/commonmark/node/Link;)Lcom/ss/android/lark/coremdbiz/facade/link/icon/ILinkIconInfo;", 0))};
        f420024f = new a();
    }

    public LarkLinkExtend() {
        final LinkType r100 = LinkType.UrlInline;
        Function1<j, LinkType> r101 = new LarkLinkExtend$special$$inlined$extend$1(r100);
        Intrinsics.checkNotNullParameter(r101, "defaultProvider");
        KProperty<Object>[] r102 = f420025g;
        KProperty<Object> r103 = r102[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        Intrinsics.checkNotNullParameter(r103, "kProperty");
        Intrinsics.checkNotNullParameter(r101, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        r105.put(e.a(r103), r101);
        this.f420026c = new c();
        final String r106 = "";
        Function1<j, String> r107 = new LarkLinkExtend$special$$inlined$extend$2(r106);
        Intrinsics.checkNotNullParameter(r107, "defaultProvider");
        KProperty<Object> r108 = r102[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r108, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r108, "kProperty");
        Intrinsics.checkNotNullParameter(r107, "value");
        r105.put(e.a(r108), r107);
        this.f420027d = new c();
        KProperty<Object> r109 = r102[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f420028e = new m();
    }

    public final dab.a a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (dab.a) this.f420028e.getValue(r100, f420025g[2]);
    }

    public final LinkType b(n r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (LinkType) this.f420026c.getValue(r100, f420025g[0]);
    }

    public final String d(n r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (String) this.f420027d.getValue(r100, f420025g[1]);
    }

    public final void f(n r100, LinkType r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f420026c.setValue(r100, f420025g[0], r101);
    }
}
