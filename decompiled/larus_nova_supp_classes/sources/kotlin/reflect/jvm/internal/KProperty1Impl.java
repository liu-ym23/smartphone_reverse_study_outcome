package kotlin.reflect.jvm.internal;

import android.util.EventsUtils;
import java.lang.reflect.Member;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0001\u001eB+\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rB\u0019\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010J\u0015\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001d\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0019R \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "V", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", XmlPullParser.NO_NAMESPACE, "signature", "boundReceiver", XmlPullParser.NO_NAMESPACE, "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/Lazy;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "delegateSource", "Ljava/lang/reflect/Member;", "getDelegate", "invoke", "Getter", "kotlin-reflection"}, k = 1, mv = {2, 0, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public class KProperty1Impl<T, V> extends KPropertyImpl<V> implements KProperty1<T, V> {
    private final Lazy<Getter<T, V>> _getter;
    private final Lazy<Member> delegateSource;

    public static /* synthetic */ Getter accessor$KProperty1Impl$lambda0(KProperty1Impl r0) {
        return _getter$lambda$0(r0);
    }

    public static /* synthetic */ Member accessor$KProperty1Impl$lambda1(KProperty1Impl r0) {
        return delegateSource$lambda$1(r0);
    }

    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public Getter<T, V> m169getGetter() {
        return this._getter.getValue();
    }

    @Override // kotlin.reflect.KProperty
    public /* bridge */ /* synthetic */ KProperty.Getter getGetter() {
        return m169getGetter();
    }

    @Override // kotlin.reflect.KProperty1
    /* JADX INFO: renamed from: getGetter */
    public /* bridge */ /* synthetic */ KProperty1.Getter mo165getGetter() {
        return m169getGetter();
    }

    @Override // kotlin.reflect.jvm.internal.KPropertyImpl
    /* JADX INFO: renamed from: getGetter, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ KPropertyImpl.Getter mo170getGetter() {
        return m169getGetter();
    }

    private static final Getter _getter$lambda$0(KProperty1Impl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return new Getter(r1);
    }

    private static final Member delegateSource$lambda$1(KProperty1Impl r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        return r1.computeDelegateSource();
    }

    @Override // kotlin.reflect.KProperty1
    public V get(T r4) {
        return (V) m169getGetter().call(new Object[]{r4});
    }

    @Override // kotlin.reflect.KProperty1
    public Object getDelegate(T r3) {
        return getDelegateImpl(this.delegateSource.getValue(), r3, null);
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T r1) {
        return get(r1);
    }

    public KProperty1Impl(KDeclarationContainerImpl r2, PropertyDescriptor r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "descriptor");
        super(r2, r3);
        LazyThreadSafetyMode r4 = LazyThreadSafetyMode.PUBLICATION;
        this._getter = LazyKt.lazy(r4, new KProperty1Impl$$Lambda$0(this));
        this.delegateSource = LazyKt.lazy(r4, new KProperty1Impl$$Lambda$1(this));
    }

    public KProperty1Impl(KDeclarationContainerImpl r2, String r3, String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "signature");
        super(r2, r3, r4, r5);
        LazyThreadSafetyMode r6 = LazyThreadSafetyMode.PUBLICATION;
        this._getter = LazyKt.lazy(r6, new KProperty1Impl$$Lambda$0(this));
        this.delegateSource = LazyKt.lazy(r6, new KProperty1Impl$$Lambda$1(this));
    }
}
