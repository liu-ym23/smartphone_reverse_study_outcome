package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", PerfLog.PARAM_KEY_CONTEXT_ID, "equals", "other", "", "fold", "R", "initial", WikiFolderPushPlugin.OPT, "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", MonitorConstants.CONNECT_TYPE_GET, ExifInterface.LONGITUDE_EAST, "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class CombinedContext implements CoroutineContext, Serializable {
    private final CoroutineContext.Element element;
    private final CoroutineContext left;

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", SlcElement.KEY_ELEMENTS, "", "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Serialized implements Serializable {
        public static final Companion Companion = null;
        private static final long serialVersionUID = 0;
        private final CoroutineContext[] elements;

        /* JADX INFO: loaded from: classes41.dex */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        private final Object readResolve() {
            CoroutineContext[] r100 = this.elements;
            CoroutineContext r101 = EmptyCoroutineContext.INSTANCE;
            int r102 = r100.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            r101 = r101.plus(r100[r103]);
            r103 = r103 + 1;
            goto L3
        L5:
            return r101;
        }

        public final CoroutineContext[] getElements() {
            return this.elements;
        }

        public Serialized(CoroutineContext[] r100) {
            Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
            this.elements = r100;
        }
    }

    private final int size() {
        int r100 = 2;
        CombinedContext r101 = this;
    L3:
        CoroutineContext r102 = r101.left;
        if ((r102 instanceof CombinedContext) == false) goto L6;
        r101 = (CombinedContext) r102;
    L7:
        if (r101 == null) goto L8;
        r100 = r100 + 1;
        goto L3
    L8:
        return r100;
    L6:
        r101 = null;
        goto L7
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    public String toString() {
        return "[" + ((String) fold("", AnonymousClass1.INSTANCE)) + ']';
    }

    private final Object writeReplace() {
        int r100 = size();
        final CoroutineContext[] r101 = new CoroutineContext[r100];
        final Ref.IntRef r102 = new Ref.IntRef();
        fold(Unit.INSTANCE, new C123351(r101, r102));
        if (r102.element != r100) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        return new Serialized(r101);
    L10:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r103 = false;
        goto L6
    }

    private final boolean contains(CoroutineContext.Element r100) {
        return Intrinsics.areEqual(get(r100.getKey()), r100);
    }

    private final boolean containsAll(CombinedContext r100) {
    L3:
        if (contains(r100.element) == false) goto L4;
        CoroutineContext r101 = r100.left;
        if ((r101 instanceof CombinedContext) == false) goto L9;
        r100 = (CombinedContext) r101;
        goto L3
    L9:
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return contains((CoroutineContext.Element) r101);
    L4:
        return false;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
    L11:
        return true;
    L4:
        if ((r100 instanceof CombinedContext) == false) goto L10;
        CombinedContext r101 = (CombinedContext) r100;
        if (r101.size() != size()) goto L10;
        if (r101.containsAll(this) == true) goto L11;
    L10:
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        CombinedContext r101 = this;
    L3:
        E r102 = (E) r101.element.get(r100);
        if (r102 != null) goto L5;
        CoroutineContext r103 = r101.left;
        if ((r103 instanceof CombinedContext) == false) goto L10;
        r101 = (CombinedContext) r103;
        goto L3
    L10:
        return (E) r103.get(r100);
    L5:
        return r102;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.element.get(r100) != null) goto L5;
        CoroutineContext r101 = this.left.minusKey(r100);
        if (r101 != this.left) goto L10;
        return this;
    L10:
        if (r101 != EmptyCoroutineContext.INSTANCE) goto L13;
        return this.element;
    L13:
        return new CombinedContext(r101, this.element);
    L5:
        return this.left;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext r100) {
        return CoroutineContext.DefaultImpls.plus(this, r100);
    }

    public CombinedContext(CoroutineContext r100, CoroutineContext.Element r101) {
        Intrinsics.checkNotNullParameter(r100, "left");
        Intrinsics.checkNotNullParameter(r101, "element");
        this.left = r100;
        this.element = r101;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r100, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r101) {
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.OPT);
        return r101.invoke((Object) this.left.fold(r100, r101), this.element);
    }
}
