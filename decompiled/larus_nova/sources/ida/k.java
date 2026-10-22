package ida;

import com.larus.nova.R;
import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.z4;
import hda.e1;
import hda.s0;
import hda.t1;
import hda.u0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class k extends s0<u> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f489415b = null;

    static {
        f489415b = new k();
    }

    public k() {
        super(c.f489407a);
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r100) {
        u r101 = (u) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f489446n;
    }

    /* JADX WARN: Type inference failed for: r8v0, types: [ida.h] */
    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r110) {
        final u r111 = (u) r110;
        Intrinsics.checkNotNullParameter(r111, "record");
        if (r111.f489444l == false) goto L5;
        List r100 = CollectionsKt.listOf(new com.obric.assistant.cocreationreview.c("原始录音", CardTemplateTagTone.NEUTRAL, Integer.valueOf(R.drawable.ic_cocreation_module_audio_memory), null, null, null, new h(r111), 116));
    L7:
        return CollectionsKt.plus(r100, u0.b(r111.f489445m));
    L5:
        r100 = CollectionsKt.emptyList();
        goto L7
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r100) {
        u r101 = (u) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f489435c;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r100) {
        u r101 = (u) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f489438f;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r100) {
        u r101 = (u) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f489436d;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String l(com.obric.assistant.cocreationreview.a r100) {
        Intrinsics.checkNotNullParameter((u) r100, "record");
        return null;
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [ida.g] */
    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r110, a5 r111) {
        final u r112 = (u) r110;
        Intrinsics.checkNotNullParameter(r112, "record");
        Intrinsics.checkNotNullParameter(r111, "feedback");
        int r100 = hda.u.f484757a;
        l5 r101 = c.f489407a;
        String r102 = r112.f489433a;
        String r103 = r112.f489438f;
        String r104 = r112.f489435c;
        e1 r105 = r112.f489445m;
        String r106 = r112.f489439g;
        if ((!StringsKt.isBlank(r106)) == false) goto L5;
        String r107 = r106;
    L7:
        return hda.u.f(r101, r102, r103, r104, r111, e1.a(r105, r106, r112.f489439g, r107, null, 1044455), true, t1.a(r112.f489435c, null), null, new f(r112), new g(r112), 1664);
    L5:
        r107 = null;
        goto L7
    }
}
