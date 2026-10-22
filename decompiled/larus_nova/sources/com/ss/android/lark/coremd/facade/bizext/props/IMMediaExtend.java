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
import com.ss.android.lark.image.entity.ResourceCleanScene;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import okio.ByteString;

/* JADX INFO: loaded from: classes35.dex */
public final class IMMediaExtend implements f {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final a f419669q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f419670r = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f419671c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f419672d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m f419673e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f419674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f419675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final m f419676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f419677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f419678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f419679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f419680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f419681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final c f419682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f419683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f419684p;

    public static final class a implements h<IMMediaExtend> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ExtendProviderImpl f419685c;

        public final <R> R b(Function1<? super IMMediaExtend, ? extends R> r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            return (R) this.f419685c.b(r100);
        }

        @Override // com.ss.android.lark.coremd.ext.h
        public final f a() {
            return (IMMediaExtend) this.f419685c.a();
        }

        public a() {
            this.f419685c = new ExtendProviderImpl(IMMediaExtend.class);
        }
    }

    static {
        f419670r = new KProperty[]{Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "coverImageKey", "getCoverImageKey(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "coverImageFsUnit", "getCoverImageFsUnit(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "coverImageCrypto", "getCoverImageCrypto(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Lokio/ByteString;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "coverImageUrl", "getCoverImageUrl(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "coverImagePath", "getCoverImagePath(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "resourceCleanScene", "getResourceCleanScene(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Lcom/ss/android/lark/image/entity/ResourceCleanScene;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "url", "getUrl(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "originPath", "getOriginPath(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "compressPath", "getCompressPath(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "cryptoToken", "getCryptoToken(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, DBDefinition.MIME_TYPE, "getMimeType(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "mediaUploadId", "getMediaUploadId(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "imageUploadId", "getImageUploadId(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Ljava/lang/String;", 0)), Reflection.mutableProperty2(new MutablePropertyReference2Impl(IMMediaExtend.class, "needCopy", "getNeedCopy(Lcom/ss/android/lark/coremdbiz/facade/node/MediaNode;)Z", 0))};
        f419669q = new a();
    }

    public IMMediaExtend() {
        final String r100 = "";
        Function1<j, String> r101 = new IMMediaExtend$special$$inlined$extend$1(r100);
        Intrinsics.checkNotNullParameter(r101, "defaultProvider");
        KProperty<Object>[] r102 = f419670r;
        KProperty<Object> r103 = r102[0];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r103, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        ConcurrentHashMap<Object, Function1<j, Object>> r104 = d.f419619a;
        Intrinsics.checkNotNullParameter(r103, "kProperty");
        Intrinsics.checkNotNullParameter(r101, "value");
        ConcurrentHashMap<Object, Function1<j, Object>> r105 = d.f419619a;
        r105.put(e.a(r103), r101);
        this.f419671c = new c();
        Function1<j, String> r106 = new IMMediaExtend$special$$inlined$extend$2(r100);
        Intrinsics.checkNotNullParameter(r106, "defaultProvider");
        KProperty<Object> r107 = r102[1];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r107, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r107, "kProperty");
        Intrinsics.checkNotNullParameter(r106, "value");
        r105.put(e.a(r107), r106);
        this.f419672d = new c();
        KProperty<Object> r108 = r102[2];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r108, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f419673e = new m();
        Function1<j, String> r109 = new IMMediaExtend$special$$inlined$extend$3(r100);
        Intrinsics.checkNotNullParameter(r109, "defaultProvider");
        KProperty<Object> r110 = r102[3];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r110, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r110, "kProperty");
        Intrinsics.checkNotNullParameter(r109, "value");
        r105.put(e.a(r110), r109);
        this.f419674f = new c();
        Function1<j, String> r111 = new IMMediaExtend$special$$inlined$extend$4(r100);
        Intrinsics.checkNotNullParameter(r111, "defaultProvider");
        KProperty<Object> r112 = r102[4];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r112, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r112, "kProperty");
        Intrinsics.checkNotNullParameter(r111, "value");
        r105.put(e.a(r112), r111);
        this.f419675g = new c();
        KProperty<Object> r113 = r102[5];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r113, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        this.f419676h = new m();
        Function1<j, String> r114 = new IMMediaExtend$special$$inlined$extend$5(r100);
        Intrinsics.checkNotNullParameter(r114, "defaultProvider");
        KProperty<Object> r115 = r102[6];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r115, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r115, "kProperty");
        Intrinsics.checkNotNullParameter(r114, "value");
        r105.put(e.a(r115), r114);
        this.f419677i = new c();
        Function1<j, String> r116 = new IMMediaExtend$special$$inlined$extend$6(r100);
        Intrinsics.checkNotNullParameter(r116, "defaultProvider");
        KProperty<Object> r117 = r102[7];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r117, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r117, "kProperty");
        Intrinsics.checkNotNullParameter(r116, "value");
        r105.put(e.a(r117), r116);
        this.f419678j = new c();
        Function1<j, String> r118 = new IMMediaExtend$special$$inlined$extend$7(r100);
        Intrinsics.checkNotNullParameter(r118, "defaultProvider");
        KProperty<Object> r119 = r102[8];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r119, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r119, "kProperty");
        Intrinsics.checkNotNullParameter(r118, "value");
        r105.put(e.a(r119), r118);
        this.f419679k = new c();
        Function1<j, String> r120 = new IMMediaExtend$special$$inlined$extend$8(r100);
        Intrinsics.checkNotNullParameter(r120, "defaultProvider");
        KProperty<Object> r121 = r102[9];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r121, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r121, "kProperty");
        Intrinsics.checkNotNullParameter(r120, "value");
        r105.put(e.a(r121), r120);
        this.f419680l = new c();
        Function1<j, String> r122 = new IMMediaExtend$special$$inlined$extend$9(r100);
        Intrinsics.checkNotNullParameter(r122, "defaultProvider");
        KProperty<Object> r123 = r102[10];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r123, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r123, "kProperty");
        Intrinsics.checkNotNullParameter(r122, "value");
        r105.put(e.a(r123), r122);
        this.f419681m = new c();
        Function1<j, String> r124 = new IMMediaExtend$special$$inlined$extend$10(r100);
        Intrinsics.checkNotNullParameter(r124, "defaultProvider");
        KProperty<Object> r125 = r102[11];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r125, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r125, "kProperty");
        Intrinsics.checkNotNullParameter(r124, "value");
        r105.put(e.a(r125), r124);
        this.f419682n = new c();
        Function1<j, String> r126 = new IMMediaExtend$special$$inlined$extend$11(r100);
        Intrinsics.checkNotNullParameter(r126, "defaultProvider");
        KProperty<Object> r127 = r102[12];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r127, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r127, "kProperty");
        Intrinsics.checkNotNullParameter(r126, "value");
        r105.put(e.a(r127), r126);
        this.f419683o = new c();
        final Boolean r128 = Boolean.FALSE;
        Function1<j, Boolean> r129 = new IMMediaExtend$special$$inlined$extend$12(r128);
        Intrinsics.checkNotNullParameter(r129, "defaultProvider");
        KProperty<Object> r130 = r102[13];
        Intrinsics.checkNotNullParameter(this, "thisRef");
        Intrinsics.checkNotNullParameter(r130, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        Intrinsics.checkNotNullParameter(r130, "kProperty");
        Intrinsics.checkNotNullParameter(r129, "value");
        r105.put(e.a(r130), r129);
        this.f419684p = new c();
    }

    public static String g(eab.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.f471747k;
    }

    public final ByteString a(eab.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (ByteString) this.f419673e.getValue(r100, f419670r[2]);
    }

    public final String b(eab.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (String) this.f419672d.getValue(r100, f419670r[1]);
    }

    public final String d(eab.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (String) this.f419671c.getValue(r100, f419670r[0]);
    }

    public final String f(eab.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (String) this.f419674f.getValue(r100, f419670r[3]);
    }

    public final String h(eab.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (String) this.f419678j.getValue(r100, f419670r[7]);
    }

    public final ResourceCleanScene i(eab.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (ResourceCleanScene) this.f419676h.getValue(r100, f419670r[5]);
    }

    public final String j(eab.f r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (String) this.f419677i.getValue(r100, f419670r[6]);
    }
}
