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
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import v7b.g;

/* JADX INFO: loaded from: classes35.dex */
public final class LarkCodeBlockExtend implements f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f420011f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f420012g = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f420013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f420014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f420015e;

    public static final class a implements h<LarkCodeBlockExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f420016c;

        public final <R> R b(Function1<? super LarkCodeBlockExtend, ? extends R> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return (R) this.f420016c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (LarkCodeBlockExtend) this.f420016c.a();
        }

        public a() {
            this.f420016c = new ExtendProviderImpl(LarkCodeBlockExtend.class);
        }
    }

    static {
        f420012g = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkCodeBlockExtend.class, "lineContents", "getLineContents(Lcom/ss/android/lark/commonmark/node/FencedCodeBlock;)Ljava/util/List;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkCodeBlockExtend.class, "wordWrap", "getWordWrap(Lcom/ss/android/lark/commonmark/node/FencedCodeBlock;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkCodeBlockExtend.class, "language", "getLanguage(Lcom/ss/android/lark/commonmark/node/FencedCodeBlock;)I", 0))};
        f420011f = new a();
    }

    public LarkCodeBlockExtend() {
        KProperty<Object>[] r100 = f420012g;
        KProperty<Object> r101 = r100[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f420013c = new m();
        final Boolean r102 = Boolean.FALSE;
        Function1<j, Boolean> r103 = new LarkCodeBlockExtend$special$$inlined$extend$1(r102);
        Intrinsics.checkNotNullParameter(r103, "defaultProvider");
        KProperty<Object> r104 = r100[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        Intrinsics.checkNotNullParameter(r104, "kProperty");
        Intrinsics.checkNotNullParameter(r103, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r106 = d.f419619a;
        r106.put(e.a(r104), r103);
        this.f420014d = new c();
        final int r107 = 0;
        Function1<j, Integer> r108 = new LarkCodeBlockExtend$special$$inlined$extend$2(r107);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r109 = r100[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r109, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r106.put(e.a(r109), r108);
        this.f420015e = new c();
    }

    public final List<LineContent> a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (List) this.f420013c.getValue(r100, f420012g[0]);
    }
}
