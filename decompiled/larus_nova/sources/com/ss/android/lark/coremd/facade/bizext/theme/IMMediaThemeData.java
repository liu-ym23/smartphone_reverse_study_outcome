package com.ss.android.lark.coremd.facade.bizext.theme;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkMediaThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class IMMediaThemeData extends LarkMediaThemeData {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419700m = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f419701k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f419702l;

    static {
        f419700m = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMMediaThemeData.class, "mediaBorderProvider", "getMediaBorderProvider()Lkotlin/jvm/functions/Function1;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMMediaThemeData.class, "mediaCoverSizeCoordinator", "getMediaCoverSizeCoordinator()Lcom/ss/android/lark/coremd/facade/bizext/image/IMImageSizeInterceptor;", 0))};
    }

    public IMMediaThemeData(j r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super(r100);
        IMMediaThemeData$mediaBorderProvider$2 r101 = IMMediaThemeData$mediaBorderProvider$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r101, "defaultProvider");
        KProperty<Object>[] r102 = f419700m;
        KProperty<Object> r103 = r102[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        Intrinsics.checkNotNullParameter(r103, "kProperty");
        Intrinsics.checkNotNullParameter(r101, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        r105.put(e.a(r103), r101);
        this.f419701k = new c();
        IMMediaThemeData$mediaCoverSizeCoordinator$2 r106 = IMMediaThemeData$mediaCoverSizeCoordinator$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r106, "defaultProvider");
        KProperty<Object> r107 = r102[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r107, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r107, "kProperty");
        Intrinsics.checkNotNullParameter(r106, "value");
        r105.put(e.a(r107), r106);
        this.f419702l = new c();
    }
}
