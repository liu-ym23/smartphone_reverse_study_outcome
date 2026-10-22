package com.ss.android.lark.coremdbiz.facade.bizext;

import android.view.View;
import com.bytedance.lark.lark_markdown_render_android.MovableRenderConfig;
import com.bytedance.lark.pb.basic.v1.ImageSetV2;
import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.base.parse.b;
import com.ss.android.lark.coremd.base.parse.o;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.coremdbiz.facade.node.MarkdownUrlPreviewInline;
import com.ss.android.lark.movable.selection.g;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public class LarkContextExtend implements f {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f419979s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419980t = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f419981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f419982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f419983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f419984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f419985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f419986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f419987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f419988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f419989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f419990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f419991m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f419992n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f419993o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f419994p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final m f419995q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f419996r;

    public static final class a implements h<LarkContextExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f419997c;

        public final <R> R b(Function1<? super LarkContextExtend, ? extends R> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return (R) this.f419997c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (LarkContextExtend) this.f419997c.a();
        }

        public a() {
            this.f419997c = new ExtendProviderImpl(LarkContextExtend.class);
        }
    }

    static {
        f419980t = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "markdownMaxWidth", "getMarkdownMaxWidth(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)I", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "tableCellLayoutParserFactory", "getTableCellLayoutParserFactory(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/coremdbiz/facade/table/TableCellLayoutParserFactory;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "curUserIdProvider", "getCurUserIdProvider(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/coremdbiz/facade/bizext/DefaultUserIdProvider;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableImageClickHandler", "getMovableImageClickHandler(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function3;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableEnableSelection", "getMovableEnableSelection(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableLongPressHandler", "getMovableLongPressHandler(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function1;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableAutoScrollStrategyProvider", "getMovableAutoScrollStrategyProvider(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function0;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableSelectionHandleDragStartHandler", "getMovableSelectionHandleDragStartHandler(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function0;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableSelectionClearHandler", "getMovableSelectionClearHandler(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function0;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableCopyHandler", "getMovableCopyHandler(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/ss/android/lark/movable/selection/MovableCopyStrategy;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "isFromTopicGroup", "isFromTopicGroup(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "isFromReplyInThread", "isFromReplyInThread(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableDocumentPreloadOnly", "getMovableDocumentPreloadOnly(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableUrlPreviewInlines", "getMovableUrlPreviewInlines(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Ljava/util/List;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "movableRenderConfig", "getMovableRenderConfig(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lcom/bytedance/lark/lark_markdown_render_android/MovableRenderConfig;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(LarkContextExtend.class, "draftResourceSourceProvider", "getDraftResourceSourceProvider(Lcom/ss/android/lark/coremd/base/parse/MarkdownContext;)Lkotlin/jvm/functions/Function0;", 0))};
        f419979s = new a();
    }

    public LarkContextExtend() {
        final int r100 = Integer.MAX_VALUE;
        Function1<j, Integer> r101 = new LarkContextExtend$special$$inlined$extend$1(r100);
        Intrinsics.checkNotNullParameter(r101, "defaultProvider");
        KProperty<Object>[] r102 = f419980t;
        KProperty<Object> r103 = r102[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        Intrinsics.checkNotNullParameter(r103, "kProperty");
        Intrinsics.checkNotNullParameter(r101, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        r105.put(e.a(r103), r101);
        this.f419981c = new c();
        KProperty<Object> r106 = r102[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r106, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f419982d = new m();
        LarkContextExtend$curUserIdProvider$2 r107 = LarkContextExtend$curUserIdProvider$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r107, "defaultProvider");
        KProperty<Object> r108 = r102[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r108, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r108, "kProperty");
        Intrinsics.checkNotNullParameter(r107, "value");
        r105.put(e.a(r108), r107);
        this.f419983e = new c();
        final Object r109 = null;
        Function1<j, Function3<? super View, ? super String, ? super Map<String, ? extends ImageSetV2>, ? extends Boolean>> r110 = new LarkContextExtend$special$$inlined$extend$2(r109);
        Intrinsics.checkNotNullParameter(r110, "defaultProvider");
        KProperty<Object> r111 = r102[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r111, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r111, "kProperty");
        Intrinsics.checkNotNullParameter(r110, "value");
        r105.put(e.a(r111), r110);
        this.f419984f = new c();
        final Boolean r112 = Boolean.FALSE;
        Function1<j, Boolean> r113 = new LarkContextExtend$special$$inlined$extend$3(r112);
        Intrinsics.checkNotNullParameter(r113, "defaultProvider");
        KProperty<Object> r114 = r102[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r114, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r114, "kProperty");
        Intrinsics.checkNotNullParameter(r113, "value");
        r105.put(e.a(r114), r113);
        this.f419985g = new c();
        Function1<j, Function1<? super View, ? extends Boolean>> r115 = new LarkContextExtend$special$$inlined$extend$4(r109);
        Intrinsics.checkNotNullParameter(r115, "defaultProvider");
        KProperty<Object> r116 = r102[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r116, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r116, "kProperty");
        Intrinsics.checkNotNullParameter(r115, "value");
        r105.put(e.a(r116), r115);
        this.f419986h = new c();
        Function1<j, Function0<? extends g>> r117 = new LarkContextExtend$special$$inlined$extend$5(r109);
        Intrinsics.checkNotNullParameter(r117, "defaultProvider");
        KProperty<Object> r118 = r102[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r118, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r118, "kProperty");
        Intrinsics.checkNotNullParameter(r117, "value");
        r105.put(e.a(r118), r117);
        this.f419987i = new c();
        Function1<j, Function0<? extends Unit>> r119 = new LarkContextExtend$special$$inlined$extend$6(r109);
        Intrinsics.checkNotNullParameter(r119, "defaultProvider");
        KProperty<Object> r120 = r102[7];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r120, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r120, "kProperty");
        Intrinsics.checkNotNullParameter(r119, "value");
        r105.put(e.a(r120), r119);
        this.f419988j = new c();
        Function1<j, Function0<? extends Unit>> r121 = new LarkContextExtend$special$$inlined$extend$7(r109);
        Intrinsics.checkNotNullParameter(r121, "defaultProvider");
        KProperty<Object> r122 = r102[8];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r122, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r122, "kProperty");
        Intrinsics.checkNotNullParameter(r121, "value");
        r105.put(e.a(r122), r121);
        this.f419989k = new c();
        Function1<j, com.ss.android.lark.movable.selection.h> r123 = new LarkContextExtend$special$$inlined$extend$8(r109);
        Intrinsics.checkNotNullParameter(r123, "defaultProvider");
        KProperty<Object> r124 = r102[9];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r124, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r124, "kProperty");
        Intrinsics.checkNotNullParameter(r123, "value");
        r105.put(e.a(r124), r123);
        this.f419990l = new c();
        Function1<j, Boolean> r125 = new LarkContextExtend$special$$inlined$extend$9(r112);
        Intrinsics.checkNotNullParameter(r125, "defaultProvider");
        KProperty<Object> r126 = r102[10];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r126, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r126, "kProperty");
        Intrinsics.checkNotNullParameter(r125, "value");
        r105.put(e.a(r126), r125);
        this.f419991m = new c();
        Function1<j, Boolean> r127 = new LarkContextExtend$special$$inlined$extend$10(r112);
        Intrinsics.checkNotNullParameter(r127, "defaultProvider");
        KProperty<Object> r128 = r102[11];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r128, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r128, "kProperty");
        Intrinsics.checkNotNullParameter(r127, "value");
        r105.put(e.a(r128), r127);
        this.f419992n = new c();
        Function1<j, Boolean> r129 = new LarkContextExtend$special$$inlined$extend$11(r112);
        Intrinsics.checkNotNullParameter(r129, "defaultProvider");
        KProperty<Object> r130 = r102[12];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r130, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r130, "kProperty");
        Intrinsics.checkNotNullParameter(r129, "value");
        r105.put(e.a(r130), r129);
        this.f419993o = new c();
        final List r131 = CollectionsKt.emptyList();
        Function1<j, List<? extends MarkdownUrlPreviewInline>> r132 = new LarkContextExtend$special$$inlined$extend$12(r131);
        Intrinsics.checkNotNullParameter(r132, "defaultProvider");
        KProperty<Object> r133 = r102[13];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r133, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r133, "kProperty");
        Intrinsics.checkNotNullParameter(r132, "value");
        r105.put(e.a(r133), r132);
        this.f419994p = new c();
        KProperty<Object> r134 = r102[14];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r134, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f419995q = new m();
        LarkContextExtend$draftResourceSourceProvider$2 r135 = LarkContextExtend$draftResourceSourceProvider$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r135, "defaultProvider");
        KProperty<Object> r136 = r102[15];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r136, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r136, "kProperty");
        Intrinsics.checkNotNullParameter(r135, "value");
        r105.put(e.a(r136), r135);
        this.f419996r = new c();
    }

    public final DefaultUserIdProvider a(o r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (DefaultUserIdProvider) this.f419983e.getValue(r100, f419980t[2]);
    }

    public final int b(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ((Number) this.f419981c.getValue(r100, f419980t[0])).intValue();
    }

    public final Function1<View, Boolean> d(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (Function1) this.f419986h.getValue(r100, f419980t[5]);
    }

    public final com.ss.android.lark.coremdbiz.facade.table.a f(b r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (com.ss.android.lark.coremdbiz.facade.table.a) this.f419982d.getValue(r100, f419980t[1]);
    }

    public final void g(b r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419981c.setValue(r100, f419980t[0], Integer.valueOf(r101));
    }

    public final void h(b r100, Function0<? extends g> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419987i.setValue(r100, f419980t[6], r101);
    }

    public final void i(b r100, com.ss.android.lark.movable.selection.h r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419990l.setValue(r100, f419980t[9], r101);
    }

    public final void j(b r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419985g.setValue(r100, f419980t[4], Boolean.valueOf(r101));
    }

    public final void k(b r100, Function3<? super View, ? super String, ? super Map<String, ImageSetV2>, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419984f.setValue(r100, f419980t[3], r101);
    }

    public final void l(b r100, Function1<? super View, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419986h.setValue(r100, f419980t[5], r101);
    }

    public final void m(b r100, MovableRenderConfig r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419995q.setValue(r100, f419980t[14], r101);
    }

    public final void n(b r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419989k.setValue(r100, f419980t[8], r101);
    }

    public final void o(b r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419988j.setValue(r100, f419980t[7], r101);
    }

    public final void p(b r100, List<MarkdownUrlPreviewInline> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f419994p.setValue(r100, f419980t[13], r101);
    }
}
