package com.ss.android.lark.coremd.impl.buildnode;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class ListItemBuildExtend implements f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f419820g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419821h = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f419822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.coremd.ext.c f419823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.ss.android.lark.coremd.ext.c f419824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.ss.android.lark.coremd.ext.c f419825f;

    public static final class a implements h<ListItemBuildExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f419826c;

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (ListItemBuildExtend) this.f419826c.a();
        }

        public a() {
            this.f419826c = new ExtendProviderImpl(ListItemBuildExtend.class);
        }
    }

    static {
        f419821h = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(ListItemBuildExtend.class, "listContainer", "getListContainer(Lcom/ss/android/lark/commonmark/node/ListItem;)Lcom/ss/android/lark/commonmark/node/Node;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(ListItemBuildExtend.class, "floor", "getFloor(Lcom/ss/android/lark/commonmark/node/ListItem;)I", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(ListItemBuildExtend.class, "type", "getType(Lcom/ss/android/lark/commonmark/node/BulletList;)Lcom/ss/android/lark/coremd/span/CommonPrefixSpan$Type;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(ListItemBuildExtend.class, "floor", "getFloor(Lcom/ss/android/lark/commonmark/node/OrderedList;)I", 0))};
        f419820g = new a();
    }

    public ListItemBuildExtend() {
        KProperty<Object>[] r100 = f419821h;
        final int r101 = 0;
        KProperty<Object> r102 = r100[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f419822c = new m();
        Function1<j, Integer> r103 = new ListItemBuildExtend$special$$inlined$extend$1(r101);
        Intrinsics.checkNotNullParameter(r103, "defaultProvider");
        KProperty<Object> r104 = r100[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = com.ss.android.lark.coremd.ext.d.f419619a;
        Intrinsics.checkNotNullParameter(r104, "kProperty");
        Intrinsics.checkNotNullParameter(r103, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r106 = com.ss.android.lark.coremd.ext.d.f419619a;
        r106.put(e.a(r104), r103);
        this.f419823d = new com.ss.android.lark.coremd.ext.c();
        final CommonPrefixSpan.Type r107 = CommonPrefixSpan.Type.FILL_CIRCLE;
        Function1<j, CommonPrefixSpan.Type> r108 = new ListItemBuildExtend$special$$inlined$extend$2(r107);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r109 = r100[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r109, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r106.put(e.a(r109), r108);
        this.f419824e = new com.ss.android.lark.coremd.ext.c();
        Function1<j, Integer> r110 = new ListItemBuildExtend$special$$inlined$extend$3(r101);
        Intrinsics.checkNotNullParameter(r110, "defaultProvider");
        KProperty<Object> r111 = r100[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r111, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r111, "kProperty");
        Intrinsics.checkNotNullParameter(r110, "value");
        r106.put(e.a(r111), r110);
        this.f419825f = new com.ss.android.lark.coremd.ext.c();
    }

    public final CommonPrefixSpan.Type getType(v7b.c r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (CommonPrefixSpan.Type) this.f419824e.getValue(r100, f419821h[2]);
    }
}
