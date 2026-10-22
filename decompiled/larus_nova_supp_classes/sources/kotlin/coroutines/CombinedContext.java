package kotlin.coroutines;

import android.util.EventsUtils;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", XmlPullParser.NO_NAMESPACE, "containsAll", "context", "equals", "other", XmlPullParser.NO_NAMESPACE, "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", XmlPullParser.NO_NAMESPACE, "minusKey", "size", "toString", XmlPullParser.NO_NAMESPACE, "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class CombinedContext implements CoroutineContext, Serializable {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    private final int size() {
        int r0 = 2;
        CombinedContext r1 = this;
    L3:
        CoroutineContext r2 = r1.left;
        if ((r2 instanceof CombinedContext) == false) goto L6;
        r1 = (CombinedContext) r2;
    L7:
        if (r1 == null) goto L8;
        r0 = r0 + 1;
        goto L3
    L8:
        return r0;
    L6:
        r1 = null;
        goto L7
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold(XmlPullParser.NO_NAMESPACE, toString.1.INSTANCE)) + ']';
    }

    private final Object writeReplace() {
        int r0 = size();
        CoroutineContext[] r1 = new CoroutineContext[r0];
        Ref.IntRef r2 = new Ref.IntRef();
        fold(Unit.INSTANCE, new writeReplace.1(r1, r2));
        if (r2.element != r0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == false) goto L10;
        return new Serialized(r1);
    L10:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r3 = false;
        goto L6
    }

    private final boolean contains(CoroutineContext.Element r2) {
        return Intrinsics.areEqual(get(r2.getKey()), r2);
    }

    private final boolean containsAll(CombinedContext r2) {
    L3:
        if (contains(r2.element) == false) goto L4;
        CoroutineContext r3 = r2.left;
        if ((r3 instanceof CombinedContext) == false) goto L9;
        r2 = (CombinedContext) r3;
        goto L3
    L9:
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return contains((CoroutineContext.Element) r3);
    L4:
        return false;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
    L11:
        return true;
    L4:
        if ((r3 instanceof CombinedContext) == false) goto L10;
        CombinedContext r4 = (CombinedContext) r3;
        if (r4.size() != size()) goto L10;
        if (r4.containsAll(this) == true) goto L11;
    L10:
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        CombinedContext r0 = this;
    L3:
        E r1 = (E) r0.element.get(r3);
        if (r1 != null) goto L5;
        CoroutineContext r2 = r0.left;
        if ((r2 instanceof CombinedContext) == false) goto L10;
        r0 = (CombinedContext) r2;
        goto L3
    L10:
        return (E) r2.get(r3);
    L5:
        return r1;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        if (this.element.get(r3) != null) goto L5;
        CoroutineContext r4 = this.left.minusKey(r3);
        if (r4 != this.left) goto L10;
        return this;
    L10:
        if (r4 != EmptyCoroutineContext.INSTANCE) goto L13;
        return this.element;
    L13:
        return new CombinedContext(r4, this.element);
    L5:
        return this.left;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r1) {
        return CoroutineContext.DefaultImpls.plus(this, r1);
    }

    public CombinedContext(CoroutineContext r2, CoroutineContext.Element r3) {
        Intrinsics.checkNotNullParameter(r2, "left");
        Intrinsics.checkNotNullParameter(r3, "element");
        this.left = r2;
        this.element = r3;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r2, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r3) {
        Intrinsics.checkNotNullParameter(r3, "operation");
        return r3.invoke((Object) this.left.fold(r2, r3), this.element);
    }
}
