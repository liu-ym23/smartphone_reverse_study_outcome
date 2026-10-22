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
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okio.ByteString;
import v7b.l;

/* JADX INFO: loaded from: classes35.dex */
public class LarkImageExtend implements f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f420017g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f420018h = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f420019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f420020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f420021e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f420022f;

    public static final class a implements h<LarkImageExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f420023c;

        public final <R> R b(Function1<? super LarkImageExtend, ? extends R> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return (R) this.f420023c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (LarkImageExtend) this.f420023c.a();
        }

        public a() {
            this.f420023c = new ExtendProviderImpl(LarkImageExtend.class);
        }
    }

    static {
        f420018h = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkImageExtend.class, "width", "getWidth(Lcom/ss/android/lark/commonmark/node/Image;)I", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkImageExtend.class, "height", "getHeight(Lcom/ss/android/lark/commonmark/node/Image;)I", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkImageExtend.class, "fsUnit", "getFsUnit(Lcom/ss/android/lark/commonmark/node/Image;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkImageExtend.class, "crypto", "getCrypto(Lcom/ss/android/lark/commonmark/node/Image;)Lokio/ByteString;", 0))};
        f420017g = new a();
    }

    public LarkImageExtend() {
        final int r100 = 0;
        Function1<j, Integer> r101 = new LarkImageExtend$special$$inlined$extend$1(r100);
        Intrinsics.checkNotNullParameter(r101, "defaultProvider");
        KProperty<Object>[] r102 = f420018h;
        KProperty<Object> r103 = r102[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        Intrinsics.checkNotNullParameter(r103, "kProperty");
        Intrinsics.checkNotNullParameter(r101, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        r105.put(e.a(r103), r101);
        this.f420019c = new c();
        Function1<j, Integer> r106 = new LarkImageExtend$special$$inlined$extend$2(r100);
        Intrinsics.checkNotNullParameter(r106, "defaultProvider");
        KProperty<Object> r107 = r102[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r107, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r107, "kProperty");
        Intrinsics.checkNotNullParameter(r106, "value");
        r105.put(e.a(r107), r106);
        this.f420020d = new c();
        KProperty<Object> r108 = r102[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r108, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f420021e = new m();
        KProperty<Object> r109 = r102[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f420022f = new m();
    }

    public final ByteString a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (ByteString) this.f420022f.getValue(r100, f420018h[3]);
    }

    public final String b(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (String) this.f420021e.getValue(r100, f420018h[2]);
    }

    public final int d(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ((Number) this.f420020d.getValue(r100, f420018h[1])).intValue();
    }

    public final int f(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ((Number) this.f420019c.getValue(r100, f420018h[0])).intValue();
    }
}
