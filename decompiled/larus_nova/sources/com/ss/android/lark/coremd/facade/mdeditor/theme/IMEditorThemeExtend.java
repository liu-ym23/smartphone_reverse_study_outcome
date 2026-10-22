package com.ss.android.lark.coremd.facade.mdeditor.theme;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class IMEditorThemeExtend extends LarkThemeExtend {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f419771p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419772q = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f419773o;

    public static final class a implements h<IMEditorThemeExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f419774c;

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMEditorThemeExtend) this.f419774c.a();
        }

        public a() {
            this.f419774c = new ExtendProviderImpl(IMEditorThemeExtend.class);
        }
    }

    static {
        f419772q = new KProperty[]{Reflection.property2(new PropertyReference2Impl(IMEditorThemeExtend.class, "atThemeData", "getAtThemeData(Lcom/ss/android/lark/coremd/base/parse/MarkdownTheme;)Lcom/ss/android/lark/coremd/facade/mdeditor/theme/IMEditorAtThemeData;", 0))};
        f419771p = new a();
    }

    public IMEditorThemeExtend() {
        IMEditorThemeExtend$atThemeData$2 r100 = IMEditorThemeExtend$atThemeData$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r100, "defaultProvider");
        KProperty<Object> r101 = f419772q[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r101, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r102 = d.f419619a;
        Intrinsics.checkNotNullParameter(r101, "kProperty");
        Intrinsics.checkNotNullParameter(r100, "value");
        d.f419619a.put(e.a(r101), r100);
        this.f419773o = new c();
    }

    @Override // com.ss.android.lark.coremdbiz.facade.bizext.LarkThemeExtend
    public final /* bridge */ /* synthetic */ LarkAtThemeData b(com.ss.android.lark.coremd.base.parse.j r100) {
        return m(r100);
    }

    public final IMEditorAtThemeData m(com.ss.android.lark.coremd.base.parse.j r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (IMEditorAtThemeData) this.f419773o.getValue(r100, f419772q[0]);
    }
}
