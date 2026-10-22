package kotlinx.datetime.internal.format.parser;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.parser.c;

/* JADX INFO: loaded from: classes42.dex */
@JvmInline
public final class m<Output extends c<Output>> {

    public static final class a<Output> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Output f505335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u<Output> f505336b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f505337c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Output r100, u<? super Output> r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "parserStructure");
            this.f505335a = r100;
            this.f505336b = r101;
            this.f505337c = r102;
        }
    }

    public static c a(u r100, CharSequence r110, c r111) {
        Intrinsics.checkNotNullParameter(r110, "input");
        Intrinsics.checkNotNullParameter(r111, "initialContainer");
        ArrayList r101 = new ArrayList();
        List r102 = CollectionsKt.mutableListOf(new a[]{new a(r111, r100, 0)});
    L3:
        a r112 = (a) CollectionsKt.removeLastOrNull(r102);
        if (r112 == null) goto L6;
        c r103 = (c) ((c) r112.f505335a).copy();
        int r104 = r112.f505337c;
        u<Output> r113 = r112.f505336b;
        int r105 = r113.f505342a.size();
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L21;
        Object r107 = ((r) ListProtector.get(r113.f505342a, r106)).a(r103, r110, r104);
        if ((r107 instanceof Integer) == false) goto L16;
        r104 = ((Number) r107).intValue();
        r106 = r106 + 1;
        goto L11
    L16:
        if ((r107 instanceof k) == false) goto L19;
        r101.add((k) r107);
        goto L3
    L19:
        throw new IllegalStateException(("Unexpected parse result: " + r107).toString());
    L21:
        if (r113.f505343b.isEmpty() == true) goto L23;
        int r108 = r113.f505343b.size() - 1;
        if (r108 < 0) goto L3;
    L28:
        int r109 = r108 - 1;
        r102.add(new a(r103, (u) ListProtector.get(r113.f505343b, r108), r104));
        if (r109 < 0) goto L3;
        r108 = r109;
        goto L28
    L23:
        if (r104 == r110.length()) goto L24;
        r101.add(new k(r104, o.f505338a));
        goto L3
    L24:
        return r103;
    L6:
        if (r101.size() <= 1) goto L9;
        CollectionsKt.sortWith(r101, new n());
    L9:
        throw new ParseException(r101);
    }
}
