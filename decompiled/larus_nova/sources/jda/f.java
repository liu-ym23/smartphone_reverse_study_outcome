package jda;

import com.obric.assistant.cocreationreview.ModuleKey;
import hda.b1;
import hda.e1;
import hda.o0;
import hda.p0;
import hda.q0;
import hda.r0;
import hda.r1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class f implements r0<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f498769a = null;

    static {
        f498769a = new f();
    }

    public f() {
    }

    @Override // hda.r0
    public final String a(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f498777h;
    }

    @Override // hda.r0
    public final String b(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f498778i;
    }

    @Override // hda.r0
    public final com.obric.assistant.cocreationreview.a c(q0 r110) {
        Intrinsics.checkNotNullParameter(r110, "record");
        o0 r100 = new o0(r110);
        r1.f484750a.getClass();
        e1 r101 = r1.f(r110);
        String r102 = r110.f484743d;
        if (r102 != null) goto L7;
        r102 = r100.c(new String[]{"displaySummary", "memoryContent", "content"});
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        Intrinsics.checkNotNullParameter(r102, "<this>");
        String r103 = b1.a(r102);
        String r104 = r110.f484740a;
        ModuleKey r105 = ModuleKey.COLLECTION_MEMORY;
        String r106 = p0.a(r110);
        String r107 = r101.f484657c;
        String r108 = r101.f484658d;
        if (StringsKt.isBlank(r108) == false) goto L10;
        String r109 = r103;
    L12:
        return new g(r104, r105, r106, r107, r109, r101, r110.f484744e, r110.f484746g);
    L10:
        r109 = r108;
        goto L12
    }
}
