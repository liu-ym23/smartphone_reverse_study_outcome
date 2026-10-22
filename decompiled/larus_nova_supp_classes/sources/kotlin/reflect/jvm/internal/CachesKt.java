package kotlin.reflect.jvm.internal;

import android.util.EventsUtils;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KAnnotatedElement;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClassifiers;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0002\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0000\u001a \u0010\u000b\u001a\u00020\f\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0000\u001a\b\u0010\r\u001a\u00020\u000eH\u0000\u001a6\u0010\u001a\u001a\u00020\u0010\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001c\u001a\u00020\u0016H\u0000\u001a6\u0010\u001d\u001a\u00020\u0010\"\b\b\u0000\u0010\b*\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001c\u001a\u00020\u0016H\u0002\"$\u0010\u0000\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u000e\b\u0001\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"6\u0010\u0017\u001a*\u0012&\u0012$\u0012\u001a\u0012\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013j\u0002`\u0019\u0012\u0004\u0012\u00020\u00100\u00180\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*0\b\u0002\u0010\u0012\"\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u00132\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0004\u0012\u00020\u00160\u0013¨\u0006\u001e"}, d2 = {"K_CLASS_CACHE", "Lkotlin/reflect/jvm/internal/CacheByClass;", "Lkotlin/reflect/jvm/internal/KClassImpl;", XmlPullParser.NO_NAMESPACE, "kotlin.jvm.PlatformType", "K_PACKAGE_CACHE", "Lkotlin/reflect/jvm/internal/KPackageImpl;", "getOrCreateKotlinClass", "T", "jClass", "Ljava/lang/Class;", "getOrCreateKotlinPackage", "Lkotlin/reflect/KDeclarationContainer;", "clearCaches", XmlPullParser.NO_NAMESPACE, "CACHE_FOR_BASE_CLASSIFIERS", "Lkotlin/reflect/KType;", "CACHE_FOR_NULLABLE_BASE_CLASSIFIERS", "Key", "Lkotlin/Pair;", XmlPullParser.NO_NAMESPACE, "Lkotlin/reflect/KTypeProjection;", XmlPullParser.NO_NAMESPACE, "CACHE_FOR_GENERIC_CLASSIFIERS", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/reflect/jvm/internal/Key;", "getOrCreateKType", "arguments", "isMarkedNullable", "getOrCreateKTypeWithTypeArguments", "kotlin-reflection"}, k = 2, mv = {2, 0, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class CachesKt {
    private static final CacheByClass<KType> CACHE_FOR_BASE_CLASSIFIERS = null;
    private static final CacheByClass<ConcurrentHashMap<Pair<List<KTypeProjection>, Boolean>, KType>> CACHE_FOR_GENERIC_CLASSIFIERS = null;
    private static final CacheByClass<KType> CACHE_FOR_NULLABLE_BASE_CLASSIFIERS = null;
    private static final CacheByClass<KClassImpl<? extends Object>> K_CLASS_CACHE = null;
    private static final CacheByClass<KPackageImpl> K_PACKAGE_CACHE = null;

    public static /* synthetic */ KClassImpl accessor$CachesKt$lambda0(Class r0) {
        return K_CLASS_CACHE$lambda$0(r0);
    }

    public static /* synthetic */ KPackageImpl accessor$CachesKt$lambda1(Class r0) {
        return K_PACKAGE_CACHE$lambda$1(r0);
    }

    public static /* synthetic */ KType accessor$CachesKt$lambda2(Class r0) {
        return CACHE_FOR_BASE_CLASSIFIERS$lambda$2(r0);
    }

    public static /* synthetic */ KType accessor$CachesKt$lambda3(Class r0) {
        return CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$3(r0);
    }

    public static /* synthetic */ ConcurrentHashMap accessor$CachesKt$lambda4(Class r0) {
        return CACHE_FOR_GENERIC_CLASSIFIERS$lambda$4(r0);
    }

    static {
        K_CLASS_CACHE = CacheByClassKt.createCache(CachesKt$$Lambda$0.INSTANCE);
        K_PACKAGE_CACHE = CacheByClassKt.createCache(CachesKt$$Lambda$1.INSTANCE);
        CACHE_FOR_BASE_CLASSIFIERS = CacheByClassKt.createCache(CachesKt$$Lambda$2.INSTANCE);
        CACHE_FOR_NULLABLE_BASE_CLASSIFIERS = CacheByClassKt.createCache(CachesKt$$Lambda$3.INSTANCE);
        CACHE_FOR_GENERIC_CLASSIFIERS = CacheByClassKt.createCache(CachesKt$$Lambda$4.INSTANCE);
    }

    public static final void clearCaches() {
        K_CLASS_CACHE.clear();
        K_PACKAGE_CACHE.clear();
        CACHE_FOR_BASE_CLASSIFIERS.clear();
        CACHE_FOR_NULLABLE_BASE_CLASSIFIERS.clear();
        CACHE_FOR_GENERIC_CLASSIFIERS.clear();
    }

    private static final KType CACHE_FOR_BASE_CLASSIFIERS$lambda$2(Class r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return KClassifiers.createType(getOrCreateKotlinClass(r3), CollectionsKt.emptyList(), false, CollectionsKt.emptyList());
    }

    private static final ConcurrentHashMap CACHE_FOR_GENERIC_CLASSIFIERS$lambda$4(Class r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return new ConcurrentHashMap();
    }

    private static final KType CACHE_FOR_NULLABLE_BASE_CLASSIFIERS$lambda$3(Class r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        return KClassifiers.createType(getOrCreateKotlinClass(r3), CollectionsKt.emptyList(), true, CollectionsKt.emptyList());
    }

    private static final KClassImpl K_CLASS_CACHE$lambda$0(Class r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return new KClassImpl(r1);
    }

    private static final KPackageImpl K_PACKAGE_CACHE$lambda$1(Class r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return new KPackageImpl(r1);
    }

    public static final <T> KClassImpl<T> getOrCreateKotlinClass(Class<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "jClass");
        KAnnotatedElement r2 = K_CLASS_CACHE.get(r1);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.reflect.jvm.internal.KClassImpl<T of kotlin.reflect.jvm.internal.CachesKt.getOrCreateKotlinClass>");
        return (KClassImpl) r2;
    }

    public static final <T> KDeclarationContainer getOrCreateKotlinPackage(Class<T> r1) {
        Intrinsics.checkNotNullParameter(r1, "jClass");
        return K_PACKAGE_CACHE.get(r1);
    }

    public static final <T> KType getOrCreateKType(Class<T> r1, List<KTypeProjection> r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "jClass");
        Intrinsics.checkNotNullParameter(r2, "arguments");
        if (r2.isEmpty() == false) goto L8;
        if (r3 == false) goto L10;
        return CACHE_FOR_NULLABLE_BASE_CLASSIFIERS.get(r1);
    L10:
        return CACHE_FOR_BASE_CLASSIFIERS.get(r1);
    L8:
        return getOrCreateKTypeWithTypeArguments(r1, r2, r3);
    }

    private static final <T> KType getOrCreateKTypeWithTypeArguments(Class<T> r3, List<KTypeProjection> r4, boolean r5) {
        ConcurrentHashMap<Pair<List<KTypeProjection>, Boolean>, KType> r0 = CACHE_FOR_GENERIC_CLASSIFIERS.get(r3);
        Pair<List<KTypeProjection>, Boolean> r1 = TuplesKt.to(r4, Boolean.valueOf(r5));
        KType r2 = r0.get(r1);
        if (r2 != null) goto L9;
        KType r6 = KClassifiers.createType(getOrCreateKotlinClass(r3), r4, r5, CollectionsKt.emptyList());
        KType r7 = r0.putIfAbsent(r1, r6);
        if (r7 != null) goto L7;
        r2 = r6;
        goto L9
    L7:
        r2 = r7;
    L9:
        return r2;
    }
}
