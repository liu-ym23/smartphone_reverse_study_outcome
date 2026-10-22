package com.ss.android.lark.coremd.facade.bizext.theme;

import com.facebook.keyframes.model.KFAnimation;
import com.larus.nova.R;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremdbiz.facade.bizext.theme.LarkAtThemeData;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class IMAtThemeData extends LarkAtThemeData {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419686s = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f419687l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f419688m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f419689n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f419690o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f419691p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f419692q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final c f419693r;

    static {
        f419686s = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "showAtReadDot", "getShowAtReadDot()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "enableAtClickable", "getEnableAtClickable()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "atOtherChatUserTextColorRes", "getAtOtherChatUserTextColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "atAnonymousTextColorRes", "getAtAnonymousTextColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "atAnonymousAsNormalText", "getAtAnonymousAsNormalText()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "atReadDotColorRes", "getAtReadDotColorRes()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(IMAtThemeData.class, "atUnreadDotColorRes", "getAtUnreadDotColorRes()I", 0))};
    }

    public IMAtThemeData(j r110) {
        Intrinsics.checkNotNullParameter(r110, "host");
        super(r110);
        final Boolean r111 = Boolean.FALSE;
        Function1<j, Boolean> r100 = new IMAtThemeData$special$$inlined$extend$1(r111);
        Intrinsics.checkNotNullParameter(r100, "defaultProvider");
        KProperty<Object>[] r101 = f419686s;
        KProperty<Object> r102 = r101[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r102, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r103 = d.f419619a;
        Intrinsics.checkNotNullParameter(r102, "kProperty");
        Intrinsics.checkNotNullParameter(r100, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        r104.put(e.a(r102), r100);
        this.f419687l = new c();
        final Boolean r105 = Boolean.TRUE;
        Function1<j, Boolean> r106 = new IMAtThemeData$special$$inlined$extend$2(r105);
        Intrinsics.checkNotNullParameter(r106, "defaultProvider");
        KProperty<Object> r107 = r101[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r107, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r107, "kProperty");
        Intrinsics.checkNotNullParameter(r106, "value");
        r104.put(e.a(r107), r106);
        this.f419688m = new c();
        final Integer r108 = Integer.valueOf(R.color.text_caption);
        Function1<j, Integer> r109 = new IMAtThemeData$special$$inlined$extend$3(r108);
        Intrinsics.checkNotNullParameter(r109, "defaultProvider");
        KProperty<Object> r112 = r101[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r109, "value");
        r104.put(e.a(r112), r109);
        this.f419689n = new c();
        final Integer r113 = Integer.valueOf(R.color.text_title);
        Function1<j, Integer> r114 = new IMAtThemeData$special$$inlined$extend$4(r113);
        Intrinsics.checkNotNullParameter(r114, "defaultProvider");
        KProperty<Object> r115 = r101[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r115, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r115, "kProperty");
        Intrinsics.checkNotNullParameter(r114, "value");
        r104.put(e.a(r115), r114);
        this.f419690o = new c();
        Function1<j, Boolean> r116 = new IMAtThemeData$special$$inlined$extend$5(r105);
        Intrinsics.checkNotNullParameter(r116, "defaultProvider");
        KProperty<Object> r117 = r101[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r117, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r117, "kProperty");
        Intrinsics.checkNotNullParameter(r116, "value");
        r104.put(e.a(r117), r116);
        this.f419691p = new c();
        final Integer r118 = Integer.valueOf(R.color.imtoken_message_icon_read_dot);
        Function1<j, Integer> r119 = new IMAtThemeData$special$$inlined$extend$6(r118);
        Intrinsics.checkNotNullParameter(r119, "defaultProvider");
        KProperty<Object> r120 = r101[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r120, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r120, "kProperty");
        Intrinsics.checkNotNullParameter(r119, "value");
        r104.put(e.a(r120), r119);
        this.f419692q = new c();
        final Integer r121 = Integer.valueOf(R.color.imtoken_message_icon_unread_dot);
        Function1<j, Integer> r122 = new IMAtThemeData$special$$inlined$extend$7(r121);
        Intrinsics.checkNotNullParameter(r122, "defaultProvider");
        KProperty<Object> r123 = r101[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r123, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r123, "kProperty");
        Intrinsics.checkNotNullParameter(r122, "value");
        r104.put(e.a(r123), r122);
        this.f419693r = new c();
    }
}
