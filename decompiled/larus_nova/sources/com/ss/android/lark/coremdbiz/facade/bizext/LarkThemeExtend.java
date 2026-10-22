package com.ss.android.lark.coremdbiz.facade.bizext;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.base.parse.j;
import com.ss.android.lark.coremd.base.parse.k;
import com.ss.android.lark.coremd.base.theme.HeadingThemeData;
import com.ss.android.lark.coremd.base.theme.ListThemeData;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.impl.parse.MarkdownThemeImpl;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtUserGroupThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkCodeBlockThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkEmojiThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkImageThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkLinkThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkMediaThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkPhoneThemeData;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkTableThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public class LarkThemeExtend implements k {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f419998m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419999n = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k.a f420000c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f420001d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f420002e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f420003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f420004g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f420005h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f420006i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f420007j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f420008k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f420009l;

    public static final class a implements h<LarkThemeExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f420010c;

        public final <R> R b(Function1<? super LarkThemeExtend, ? extends R> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return (R) this.f420010c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (LarkThemeExtend) this.f420010c.a();
        }

        public a() {
            this.f420010c = new ExtendProviderImpl(LarkThemeExtend.class);
        }
    }

    @Override // com.ss.android.lark.coremd.base.parse.k
    public final ListThemeData c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return this.f420000c.c(r100);
    }

    @Override // com.ss.android.lark.coremd.base.parse.k
    public final HeadingThemeData e(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return this.f420000c.e(r100);
    }

    static {
        f419999n = new KProperty[]{Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "imageThemeData", "getImageThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkImageThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "linkThemeData", "getLinkThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkLinkThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "codeBlockThemeData", "getCodeBlockThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkCodeBlockThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "atThemeData", "getAtThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkAtThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "emojiThemeData", "getEmojiThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkEmojiThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "mediaThemeData", "getMediaThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkMediaThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "phoneThemeData", "getPhoneThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkPhoneThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "atUserGroupData", "getAtUserGroupData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkAtUserGroupThemeData;", 0)), Reflection.property2(new PropertyReference2Impl(LarkThemeExtend.class, "tableThemeData", "getTableThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremdbiz/facade/bizext/theme/LarkTableThemeData;", 0))};
        f419998m = new a();
    }

    @Override // com.ss.android.lark.coremd.ext.h
    public final f a() {
        MarkdownThemeImpl.ThemeExtendImpl r100 = this.f420000c.f419545c;
        r100.getClass();
        return r100;
    }

    public LarkThemeExtend() {
        this.f420000c = k.f419543b;
        LarkThemeExtend$imageThemeData$2 r100 = LarkThemeExtend$imageThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "defaultProvider");
        KProperty<Object>[] r101 = f419999n;
        KProperty<Object> r102 = r101[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<com.ss.android.lark.coremd.ext.j, Object>> r103 = d.f419619a;
        Intrinsics.checkNotNullParameter(r102, "kProperty");
        Intrinsics.checkNotNullParameter(r100, "value");
        ConcurrentHashMap<Object, Function1<com.ss.android.lark.coremd.ext.j, Object>> r104 = d.f419619a;
        r104.put(e.a(r102), r100);
        this.f420001d = new c();
        LarkThemeExtend$linkThemeData$2 r105 = LarkThemeExtend$linkThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r105, "defaultProvider");
        KProperty<Object> r106 = r101[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r106, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r106, "kProperty");
        Intrinsics.checkNotNullParameter(r105, "value");
        r104.put(e.a(r106), r105);
        this.f420002e = new c();
        LarkThemeExtend$codeBlockThemeData$2 r107 = LarkThemeExtend$codeBlockThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r107, "defaultProvider");
        KProperty<Object> r108 = r101[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r108, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r108, "kProperty");
        Intrinsics.checkNotNullParameter(r107, "value");
        r104.put(e.a(r108), r107);
        this.f420003f = new c();
        LarkThemeExtend$atThemeData$2 r109 = LarkThemeExtend$atThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r109, "defaultProvider");
        KProperty<Object> r110 = r101[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r110, "kProperty");
        Intrinsics.checkNotNullParameter(r109, "value");
        r104.put(e.a(r110), r109);
        this.f420004g = new c();
        LarkThemeExtend$emojiThemeData$2 r111 = LarkThemeExtend$emojiThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r111, "defaultProvider");
        KProperty<Object> r112 = r101[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r111, "value");
        r104.put(e.a(r112), r111);
        this.f420005h = new c();
        LarkThemeExtend$mediaThemeData$2 r113 = LarkThemeExtend$mediaThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r113, "defaultProvider");
        KProperty<Object> r114 = r101[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r114, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r114, "kProperty");
        Intrinsics.checkNotNullParameter(r113, "value");
        r104.put(e.a(r114), r113);
        this.f420006i = new c();
        LarkThemeExtend$phoneThemeData$2 r115 = LarkThemeExtend$phoneThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r115, "defaultProvider");
        KProperty<Object> r116 = r101[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r116, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r116, "kProperty");
        Intrinsics.checkNotNullParameter(r115, "value");
        r104.put(e.a(r116), r115);
        this.f420007j = new c();
        LarkThemeExtend$atUserGroupData$2 r117 = LarkThemeExtend$atUserGroupData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r117, "defaultProvider");
        KProperty<Object> r118 = r101[7];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r118, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r118, "kProperty");
        Intrinsics.checkNotNullParameter(r117, "value");
        r104.put(e.a(r118), r117);
        this.f420008k = new c();
        LarkThemeExtend$tableThemeData$2 r119 = LarkThemeExtend$tableThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r119, "defaultProvider");
        KProperty<Object> r120 = r101[8];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r120, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r120, "kProperty");
        Intrinsics.checkNotNullParameter(r119, "value");
        r104.put(e.a(r120), r119);
        this.f420009l = new c();
    }

    public LarkAtThemeData b(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (LarkAtThemeData) this.f420004g.getValue(r100, f419999n[3]);
    }

    public final LarkAtUserGroupThemeData d(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (LarkAtUserGroupThemeData) this.f420008k.getValue(r100, f419999n[7]);
    }

    public final LarkCodeBlockThemeData f(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (LarkCodeBlockThemeData) this.f420003f.getValue(r100, f419999n[2]);
    }

    public final LarkEmojiThemeData g(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (LarkEmojiThemeData) this.f420005h.getValue(r100, f419999n[4]);
    }

    public LarkImageThemeData h(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (LarkImageThemeData) this.f420001d.getValue(r100, f419999n[0]);
    }

    public final LarkLinkThemeData i(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (LarkLinkThemeData) this.f420002e.getValue(r100, f419999n[1]);
    }

    public LarkMediaThemeData j(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (LarkMediaThemeData) this.f420006i.getValue(r100, f419999n[5]);
    }

    public final LarkPhoneThemeData k(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (LarkPhoneThemeData) this.f420007j.getValue(r100, f419999n[6]);
    }

    public final LarkTableThemeData l(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (LarkTableThemeData) this.f420009l.getValue(r100, f419999n[8]);
    }
}
