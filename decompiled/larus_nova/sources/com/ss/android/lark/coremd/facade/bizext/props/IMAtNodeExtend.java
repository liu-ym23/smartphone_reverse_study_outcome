package com.ss.android.lark.coremd.facade.bizext.props;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.coremd.ext.ExtendProviderImpl;
import com.ss.android.lark.coremd.ext.c;
import com.ss.android.lark.coremd.ext.d;
import com.ss.android.lark.coremd.ext.e;
import com.ss.android.lark.coremd.ext.f;
import com.ss.android.lark.coremd.ext.h;
import com.ss.android.lark.coremd.ext.j;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class IMAtNodeExtend implements f {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f419650i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419651j = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f419652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f419653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f419654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f419655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f419656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f419657h;

    public static final class a implements h<IMAtNodeExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f419658c;

        public final <R> R b(Function1<? super IMAtNodeExtend, ? extends R> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return (R) this.f419658c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMAtNodeExtend) this.f419658c.a();
        }

        public a() {
            this.f419658c = new ExtendProviderImpl(IMAtNodeExtend.class);
        }
    }

    static {
        f419651j = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "chatId", "getChatId(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "isOutChatUser", "isOutChatUser(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "isHighLight", "isHighLight(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "isAnonymous", "isAnonymous(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "isAtAll", "isAtAll(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Z", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMAtNodeExtend.class, "originName", "getOriginName(Lcom/ss/android/lark/coremdbiz/facade/node/AtNode;)Ljava/lang/String;", 0))};
        f419650i = new a();
    }

    public IMAtNodeExtend() {
        final String r100 = "";
        Function1<j, String> r101 = new IMAtNodeExtend$special$$inlined$extend$1(r100);
        Intrinsics.checkNotNullParameter(r101, "defaultProvider");
        KProperty<Object>[] r102 = f419651j;
        KProperty<Object> r103 = r102[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        Intrinsics.checkNotNullParameter(r103, "kProperty");
        Intrinsics.checkNotNullParameter(r101, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        r105.put(e.a(r103), r101);
        this.f419652c = new c();
        final Boolean r106 = Boolean.FALSE;
        Function1<j, Boolean> r107 = new IMAtNodeExtend$special$$inlined$extend$2(r106);
        Intrinsics.checkNotNullParameter(r107, "defaultProvider");
        KProperty<Object> r110 = r102[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r110, "kProperty");
        Intrinsics.checkNotNullParameter(r107, "value");
        r105.put(e.a(r110), r107);
        this.f419653d = new c();
        Function1<j, Boolean> r108 = new IMAtNodeExtend$special$$inlined$extend$3(r106);
        Intrinsics.checkNotNullParameter(r108, "defaultProvider");
        KProperty<Object> r111 = r102[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r111, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r111, "kProperty");
        Intrinsics.checkNotNullParameter(r108, "value");
        r105.put(e.a(r111), r108);
        this.f419654e = new c();
        Function1<j, Boolean> r109 = new IMAtNodeExtend$special$$inlined$extend$4(r106);
        Intrinsics.checkNotNullParameter(r109, "defaultProvider");
        KProperty<Object> r112 = r102[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r109, "value");
        r105.put(e.a(r112), r109);
        this.f419655f = new c();
        Function1<j, Boolean> r113 = new IMAtNodeExtend$special$$inlined$extend$5(r106);
        Intrinsics.checkNotNullParameter(r113, "defaultProvider");
        KProperty<Object> r114 = r102[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r114, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r114, "kProperty");
        Intrinsics.checkNotNullParameter(r113, "value");
        r105.put(e.a(r114), r113);
        this.f419656g = new c();
        Function1<j, String> r115 = new IMAtNodeExtend$special$$inlined$extend$6(r100);
        Intrinsics.checkNotNullParameter(r115, "defaultProvider");
        KProperty<Object> r116 = r102[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r116, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r116, "kProperty");
        Intrinsics.checkNotNullParameter(r115, "value");
        r105.put(e.a(r116), r115);
        this.f419657h = new c();
    }

    public final boolean a(eab.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ((Boolean) this.f419655f.getValue(r100, f419651j[3])).booleanValue();
    }

    public final boolean b(eab.a r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return ((Boolean) this.f419653d.getValue(r100, f419651j[1])).booleanValue();
    }

    public final void d(eab.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419655f.setValue(r100, f419651j[3], Boolean.valueOf(r101));
    }

    public final void f(eab.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        this.f419653d.setValue(r100, f419651j[1], Boolean.valueOf(r101));
    }
}
