package kotlinx.datetime.format;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class MonthNames {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MonthNames f505181b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f505182a;

    public static final class a {
    }

    /* JADX INFO: renamed from: kotlinx.datetime.format.MonthNames$toString$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, String> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1, String.class, "toString", "toString()Ljava/lang/String;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(String r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            return r100.toString();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(String r100) {
            return invoke2(r100);
        }
    }

    static {
        new MonthNames(CollectionsKt.listOf(new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
        f505181b = new MonthNames(CollectionsKt.listOf(new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));
    }

    public final int hashCode() {
        return this.f505182a.hashCode();
    }

    public final String toString() {
        return CollectionsKt.joinToString$default(this.f505182a, ", ", "MonthNames(", ")", 0, null, AnonymousClass1.INSTANCE, 24, null);
    }

    public MonthNames(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "names");
        this.f505182a = r100;
        if (r100.size() != 12) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L26;
        Iterator<Integer> r102 = CollectionsKt.getIndices(r100).iterator();
    L9:
        if (r102.hasNext() == false) goto L24;
        int r103 = ((IntIterator) r102).nextInt();
        if (((CharSequence) ListProtector.get(this.f505182a, r103)).length() <= 0) goto L13;
        boolean r104 = true;
    L14:
        if (r104 == false) goto L23;
        int r105 = 0;
    L16:
        if (r105 >= r103) goto L9;
        if ((!Intrinsics.areEqual(ListProtector.get(this.f505182a, r103), ListProtector.get(this.f505182a, r105))) == false) goto L21;
        r105 = r105 + 1;
        goto L16
    L21:
        throw new IllegalArgumentException(("Month names must be unique, but '" + ((String) ListProtector.get(this.f505182a, r103)) + "' was repeated").toString());
    L23:
        throw new IllegalArgumentException("A month name can not be empty".toString());
    L13:
        r104 = false;
        goto L14
    L24:
        return;
    L26:
        throw new IllegalArgumentException("Month names must contain exactly 12 elements".toString());
    L5:
        r101 = false;
        goto L6
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof MonthNames) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f505182a, ((MonthNames) r100).f505182a) == false) goto L7;
        return true;
    }
}
