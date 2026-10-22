package com.ss.android.lark.coremd.impl.parse;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.base.parse.a0;
import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import com.ss.android.lark.coremd.base.theme.ListThemeData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class MarkdownThemeImpl implements com.ss.android.lark.coremd.base.parse.j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Object, Object> f419847c;

    public static final class ThemeExtendImpl implements com.ss.android.lark.coremd.base.parse.k, com.ss.android.lark.coremd.ext.h<com.ss.android.lark.coremd.base.parse.k> {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ KProperty<Object>[] f419848l = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.ss.android.lark.coremd.ext.c f419849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.ss.android.lark.coremd.ext.c f419850d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.ss.android.lark.coremd.ext.c f419851e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final com.ss.android.lark.coremd.ext.c f419852f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final com.ss.android.lark.coremd.ext.c f419853g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final com.ss.android.lark.coremd.ext.c f419854h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final com.ss.android.lark.coremd.ext.c f419855i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final com.ss.android.lark.coremd.ext.c f419856j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final com.ss.android.lark.coremd.ext.c f419857k;

        @Override // com.ss.android.lark.coremd.ext.h
        public final com.ss.android.lark.coremd.ext.f a() {
            return this;
        }

        static {
            f419848l = new KProperty[]{Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "imageThemeData", "getImageThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/ImageThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "linkThemeData", "getLinkThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/LinkThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "listThemeData", "getListThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/ListThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "inlineCodeThemeData", "getInlineCodeThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/InlineCodeThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "codeBlockThemeData", "getCodeBlockThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/CodeBlockThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "blockQuoteThemeData", "getBlockQuoteThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/BlockQuoteThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "headingThemeData", "getHeadingThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/HeadingThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(ThemeExtendImpl.class, "thematicBreakThemeData", "getThematicBreakThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/base/theme/ThematicBreakThemeData;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(ThemeExtendImpl.class, "showBISU", "getShowBISU(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Z", 0))};
        }

        public ThemeExtendImpl() {
            MarkdownThemeImpl$ThemeExtendImpl$imageThemeData$2 r100 = MarkdownThemeImpl$ThemeExtendImpl$imageThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r100, "defaultProvider");
            KProperty<Object>[] r101 = f419848l;
            KProperty<Object> r102 = r101[0];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            ConcurrentHashMap<Object, Function1<com.ss.android.lark.coremd.ext.j, Object>> r103 = com.ss.android.lark.coremd.ext.d.f419619a;
            Intrinsics.checkNotNullParameter(r102, "kProperty");
            Intrinsics.checkNotNullParameter(r100, "value");
            ConcurrentHashMap<Object, Function1<com.ss.android.lark.coremd.ext.j, Object>> r104 = com.ss.android.lark.coremd.ext.d.f419619a;
            r104.put(com.ss.android.lark.coremd.ext.e.a(r102), r100);
            this.f419849c = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$linkThemeData$2 r105 = MarkdownThemeImpl$ThemeExtendImpl$linkThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r105, "defaultProvider");
            KProperty<Object> r106 = r101[1];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r106, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r106, "kProperty");
            Intrinsics.checkNotNullParameter(r105, "value");
            r104.put(com.ss.android.lark.coremd.ext.e.a(r106), r105);
            this.f419850d = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$listThemeData$2 r107 = MarkdownThemeImpl$ThemeExtendImpl$listThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r107, "defaultProvider");
            KProperty<Object> r108 = r101[2];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r108, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r108, "kProperty");
            Intrinsics.checkNotNullParameter(r107, "value");
            r104.put(com.ss.android.lark.coremd.ext.e.a(r108), r107);
            this.f419851e = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$inlineCodeThemeData$2 r109 = MarkdownThemeImpl$ThemeExtendImpl$inlineCodeThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r109, "defaultProvider");
            KProperty<Object> r110 = r101[3];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r110, "kProperty");
            Intrinsics.checkNotNullParameter(r109, "value");
            r104.put(com.ss.android.lark.coremd.ext.e.a(r110), r109);
            this.f419852f = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$codeBlockThemeData$2 r111 = MarkdownThemeImpl$ThemeExtendImpl$codeBlockThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r111, "defaultProvider");
            KProperty<Object> r112 = r101[4];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r112, "kProperty");
            Intrinsics.checkNotNullParameter(r111, "value");
            r104.put(com.ss.android.lark.coremd.ext.e.a(r112), r111);
            this.f419853g = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$blockQuoteThemeData$2 r113 = MarkdownThemeImpl$ThemeExtendImpl$blockQuoteThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r113, "defaultProvider");
            KProperty<Object> r114 = r101[5];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r114, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r114, "kProperty");
            Intrinsics.checkNotNullParameter(r113, "value");
            r104.put(com.ss.android.lark.coremd.ext.e.a(r114), r113);
            this.f419854h = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$headingThemeData$2 r115 = MarkdownThemeImpl$ThemeExtendImpl$headingThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r115, "defaultProvider");
            KProperty<Object> r116 = r101[6];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r116, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r116, "kProperty");
            Intrinsics.checkNotNullParameter(r115, "value");
            r104.put(com.ss.android.lark.coremd.ext.e.a(r116), r115);
            this.f419855i = new com.ss.android.lark.coremd.ext.c();
            MarkdownThemeImpl$ThemeExtendImpl$thematicBreakThemeData$2 r117 = MarkdownThemeImpl$ThemeExtendImpl$thematicBreakThemeData$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r117, "defaultProvider");
            KProperty<Object> r118 = r101[7];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r118, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r118, "kProperty");
            Intrinsics.checkNotNullParameter(r117, "value");
            r104.put(com.ss.android.lark.coremd.ext.e.a(r118), r117);
            this.f419856j = new com.ss.android.lark.coremd.ext.c();
            final Boolean r119 = Boolean.TRUE;
            Function1<com.ss.android.lark.coremd.ext.j, Boolean> r120 = new MarkdownThemeImpl$ThemeExtendImpl$special$$inlined$extend$1(r119);
            Intrinsics.checkNotNullParameter(r120, "defaultProvider");
            KProperty<Object> r121 = r101[8];
            Intrinsics.checkNotNullParameter(this, "thisRef");
            Intrinsics.checkNotNullParameter(r121, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r121, "kProperty");
            Intrinsics.checkNotNullParameter(r120, "value");
            r104.put(com.ss.android.lark.coremd.ext.e.a(r121), r120);
            this.f419857k = new com.ss.android.lark.coremd.ext.c();
        }

        @Override // com.ss.android.lark.coremd.base.parse.k
        public final ListThemeData c(com.ss.android.lark.coremd.base.parse.j r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return (ListThemeData) this.f419851e.getValue(r100, f419848l[2]);
        }

        @Override // com.ss.android.lark.coremd.base.parse.k
        public final HeadingThemeData e(com.ss.android.lark.coremd.base.parse.j r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            return (HeadingThemeData) this.f419855i.getValue(r100, f419848l[6]);
        }
    }

    @Override // com.ss.android.lark.coremd.base.parse.j
    public final MarkdownThemeImpl clone() {
        MarkdownThemeImpl r100 = new MarkdownThemeImpl();
        Map<Object, Object> r101 = r100.f419847c;
        Map<Object, Object> r102 = this.f419847c;
        LinkedHashMap r103 = new LinkedHashMap();
        Iterator r104 = ((LinkedHashMap) r102).entrySet().iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Map.Entry r105 = (Map.Entry) r104.next();
        if ((!(r105.getValue() instanceof a0)) == false) goto L4;
        r103.put(r105.getKey(), r105.getValue());
        goto L4
    L8:
        r101.putAll(r103);
        return r100;
    }

    public MarkdownThemeImpl() {
        this.f419847c = new LinkedHashMap();
    }

    @Override // com.ss.android.lark.coremd.ext.j
    public final Map<Object, Object> getValues() {
        return this.f419847c;
    }
}
