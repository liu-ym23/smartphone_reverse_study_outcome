package com.ss.android.lark.coremd.facade.bizext.theme;

import com.facebook.keyframes.model.KFAnimation;
import com.larus.nova.R;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkImageThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class IMImageThemeData extends LarkImageThemeData {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419694r = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f419695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f419696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f419697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f419698p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f419699q;

    static {
        f419694r = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMImageThemeData.class, "imageBackgroundColorRes", "getImageBackgroundColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMImageThemeData.class, "showImageBorder", "getShowImageBorder()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMImageThemeData.class, "showImageMode", "getShowImageMode()Lcom/ss/android/lark/coremd/facade/bizext/image/IMShowImageScene;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMImageThemeData.class, "imageSizeCoordinator", "getImageSizeCoordinator()Lcom/ss/android/lark/coremd/facade/bizext/image/IMImageSizeInterceptor;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMImageThemeData.class, "imageBorderProvider", "getImageBorderProvider()Lkotlin/jvm/functions/Function1;", 0))};
    }

    public IMImageThemeData(j r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super(r100);
        final Integer r101 = Integer.valueOf(R.color.bg_body);
        Function1<j, Integer> r102 = new IMImageThemeData$special$$inlined$extend$1(r101);
        Intrinsics.checkNotNullParameter(r102, "defaultProvider");
        KProperty<Object>[] r103 = f419694r;
        KProperty<Object> r104 = r103[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r104, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        Intrinsics.checkNotNullParameter(r104, "kProperty");
        Intrinsics.checkNotNullParameter(r102, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r106 = d.f419619a;
        r106.put(e.a(r104), r102);
        this.f419695m = new c();
        final Boolean r107 = Boolean.TRUE;
        Function1<j, Boolean> r108 = new IMImageThemeData$special$$inlined$extend$2(r107);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r109 = r103[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r109, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r106.put(e.a(r109), r108);
        this.f419696n = new c();
        IMImageThemeData$showImageMode$2 r110 = IMImageThemeData$showImageMode$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r110, "defaultProvider");
        KProperty<Object> r111 = r103[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r111, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r111, "kProperty");
        Intrinsics.checkNotNullParameter(r110, "value");
        r106.put(e.a(r111), r110);
        this.f419697o = new c();
        IMImageThemeData$imageSizeCoordinator$2 r112 = IMImageThemeData$imageSizeCoordinator$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r112, "defaultProvider");
        KProperty<Object> r113 = r103[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r113, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r113, "kProperty");
        Intrinsics.checkNotNullParameter(r112, "value");
        r106.put(e.a(r113), r112);
        this.f419698p = new c();
        IMImageThemeData$imageBorderProvider$2 r114 = IMImageThemeData$imageBorderProvider$2.INSTANCE;
        Intrinsics.checkNotNullParameter(r114, "defaultProvider");
        KProperty<Object> r115 = r103[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r115, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r115, "kProperty");
        Intrinsics.checkNotNullParameter(r114, "value");
        r106.put(e.a(r115), r114);
        this.f419699q = new c();
    }
}
