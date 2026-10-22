package kotlinx.datetime.format;

import com.ss.ttvideoengine.model.SubInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.b;
import kotlinx.datetime.internal.format.OptionalFormatStructure;

/* JADX INFO: loaded from: classes42.dex */
public interface b<Target, ActualSelf extends b<Target, ActualSelf>> extends w {

    public static final class a {
        public static <Target, ActualSelf extends b<Target, ActualSelf>> kotlinx.datetime.internal.format.f<Target> c(b<Target, ActualSelf> r100) {
            kotlinx.datetime.internal.format.d<Target> r101 = r100.c();
            r101.getClass();
            List<kotlinx.datetime.internal.format.q<Target>> r102 = r101.f505284a;
            Intrinsics.checkNotNullParameter(r102, "formats");
            return new kotlinx.datetime.internal.format.f(r102);
        }

        public static <Target, ActualSelf extends b<Target, ActualSelf>> void d(b<Target, ActualSelf> r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "value");
            r100.c().a(new kotlinx.datetime.internal.format.j(r101));
        }

        public static <Target, ActualSelf extends b<Target, ActualSelf>> void a(b<Target, ActualSelf> r100, Function1<? super ActualSelf, Unit>[] r101, Function1<? super ActualSelf, Unit> r102) {
            Intrinsics.checkNotNullParameter(r101, "otherFormats");
            Intrinsics.checkNotNullParameter(r102, "mainFormat");
            ArrayList r103 = new ArrayList(r101.length);
            int r104 = r101.length;
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L5;
            Function1<? super ActualSelf, Unit> r106 = r101[r105];
            b r107 = r100.k();
            r106.invoke(r107);
            kotlinx.datetime.internal.format.d<Target> r108 = r107.c();
            r108.getClass();
            r103.add(new kotlinx.datetime.internal.format.h(r108.f505284a));
            r105 = r105 + 1;
            goto L3
        L5:
            b r109 = r100.k();
            r102.invoke(r109);
            kotlinx.datetime.internal.format.d<Target> r110 = r109.c();
            r110.getClass();
            kotlinx.datetime.internal.format.h r111 = new kotlinx.datetime.internal.format.h(r110.f505284a);
            r100.c().a(new kotlinx.datetime.internal.format.c(r111, r103));
        }

        public static <Target, ActualSelf extends b<Target, ActualSelf>> void b(b<Target, ActualSelf> r100, String r101, Function1<? super ActualSelf, Unit> r102) {
            Intrinsics.checkNotNullParameter(r101, "onZero");
            Intrinsics.checkNotNullParameter(r102, SubInfo.KEY_FORMAT);
            kotlinx.datetime.internal.format.d<Target> r103 = r100.c();
            b r104 = r100.k();
            r102.invoke(r104);
            Unit r105 = Unit.INSTANCE;
            kotlinx.datetime.internal.format.d<Target> r106 = r104.c();
            r106.getClass();
            r103.a(new OptionalFormatStructure(r101, new kotlinx.datetime.internal.format.h(r106.f505284a)));
        }
    }

    kotlinx.datetime.internal.format.d<Target> c();

    void f(Function1<? super ActualSelf, Unit>[] r100, Function1<? super ActualSelf, Unit> r101);

    ActualSelf k();

    void p(String r100, Function1<? super ActualSelf, Unit> r101);
}
