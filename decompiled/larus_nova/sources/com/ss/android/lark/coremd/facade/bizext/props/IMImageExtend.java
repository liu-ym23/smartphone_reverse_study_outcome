package com.ss.android.lark.coremd.facade.bizext.props;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import com.ss.android.lark.coremd.ext.m;
import com.ss.android.lark.coremdbiz.facade.bizext.props.LarkImageExtend;
import com.ss.android.lark.image.entity.ResourceCleanScene;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import v7b.l;

/* JADX INFO: loaded from: classes35.dex */
public final class IMImageExtend extends LarkImageExtend {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f419659p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419660q = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f419661i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f419662j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f419663k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f419664l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final m f419665m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m f419666n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f419667o;

    public static final class a implements h<IMImageExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f419668c;

        public final <R> R b(Function1<? super IMImageExtend, ? extends R> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return (R) this.f419668c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMImageExtend) this.f419668c.a();
        }

        public a() {
            this.f419668c = new ExtendProviderImpl(IMImageExtend.class);
        }
    }

    static {
        f419660q = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "originKey", "getOriginKey(Lcom/ss/android/lark/commonmark/node/Image;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "middleKey", "getMiddleKey(Lcom/ss/android/lark/commonmark/node/Image;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "thumbKey", "getThumbKey(Lcom/ss/android/lark/commonmark/node/Image;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "url", "getUrl(Lcom/ss/android/lark/commonmark/node/Image;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "inlinePreview", "getInlinePreview(Lcom/ss/android/lark/commonmark/node/Image;)Lokio/ByteString;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "resourceCleanScene", "getResourceCleanScene(Lcom/ss/android/lark/commonmark/node/Image;)Lcom/ss/android/lark/image/entity/ResourceCleanScene;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMImageExtend.class, "needCopy", "getNeedCopy(Lcom/ss/android/lark/commonmark/node/Image;)Z", 0))};
        f419659p = new a();
    }

    public IMImageExtend() {
        final String r100 = "";
        Function1<j, String> r101 = new IMImageExtend$special$$inlined$extend$1(r100);
        Intrinsics.checkNotNullParameter(r101, "defaultProvider");
        KProperty<Object>[] r102 = f419660q;
        KProperty<Object> r103 = r102[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        Intrinsics.checkNotNullParameter(r103, "kProperty");
        Intrinsics.checkNotNullParameter(r101, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        r105.put(e.a(r103), r101);
        this.f419661i = new c();
        Function1<j, String> r106 = new IMImageExtend$special$$inlined$extend$2(r100);
        Intrinsics.checkNotNullParameter(r106, "defaultProvider");
        KProperty<Object> r107 = r102[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r107, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r107, "kProperty");
        Intrinsics.checkNotNullParameter(r106, "value");
        r105.put(e.a(r107), r106);
        this.f419662j = new c();
        Function1<j, String> r108 = new IMImageExtend$special$$inlined$extend$3(r100);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r109 = r102[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r109, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r109, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r105.put(e.a(r109), r108);
        this.f419663k = new c();
        Function1<j, String> r110 = new IMImageExtend$special$$inlined$extend$4(r100);
        Intrinsics.checkNotNullParameter(r110, "defaultProvider");
        KProperty<Object> r111 = r102[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r111, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r111, "kProperty");
        Intrinsics.checkNotNullParameter(r110, "value");
        r105.put(e.a(r111), r110);
        this.f419664l = new c();
        KProperty<Object> r112 = r102[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f419665m = new m();
        KProperty<Object> r113 = r102[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r113, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f419666n = new m();
        final Boolean r114 = Boolean.FALSE;
        Function1<j, Boolean> r115 = new IMImageExtend$special$$inlined$extend$5(r114);
        Intrinsics.checkNotNullParameter(r115, "defaultProvider");
        KProperty<Object> r116 = r102[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r116, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r116, "kProperty");
        Intrinsics.checkNotNullParameter(r115, "value");
        r105.put(e.a(r116), r115);
        this.f419667o = new c();
    }

    public static String j(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.f553559j;
    }

    public final String g(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (String) this.f419662j.getValue(r100, f419660q[1]);
    }

    public final String h(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (String) this.f419661i.getValue(r100, f419660q[0]);
    }

    public final ResourceCleanScene i(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (ResourceCleanScene) this.f419666n.getValue(r100, f419660q[5]);
    }

    public final String k(l r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (String) this.f419664l.getValue(r100, f419660q[3]);
    }
}
