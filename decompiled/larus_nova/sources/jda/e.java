package jda;

import com.larus.nova.R;
import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import com.obric.assistant.cocreationreview.a5;
import com.obric.assistant.cocreationreview.l5;
import com.obric.assistant.cocreationreview.z4;
import com.ss.ttm.player.MediaPlayer;
import hda.e1;
import hda.s0;
import hda.t0;
import hda.t1;
import hda.u;
import hda.u0;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class e extends s0<g> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f498768b = null;

    static {
        f498768b = new e();
    }

    public e() {
        super(c.f498766a);
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String b(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f498777h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.obric.assistant.cocreationreview.n5
    public final List c(com.obric.assistant.cocreationreview.a r110) {
        g r111 = (g) r110;
        Intrinsics.checkNotNullParameter(r111, "record");
        e1 r100 = r111.f498776g;
        Intrinsics.checkNotNullParameter(r100, "uiModel");
        String r101 = r100.f484662h;
        if (r101 == null) goto L20;
        Function1 r102 = null;
        if ((!StringsKt.isBlank(r101)) == false) goto L7;
        String r103 = r101;
    L8:
        if (r103 == null) goto L20;
        CardTemplateTagTone r104 = CardTemplateTagTone.NEUTRAL;
        Integer r105 = Integer.valueOf(R.drawable.ic_cocreation_memory_source);
        final String r106 = r100.f484663i;
        if (r106 != null) goto L13;
    L19:
        List r107 = CollectionsKt.listOf(new com.obric.assistant.cocreationreview.c(r103, r104, r105, r102, 94, null, null, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE));
    L22:
        return CollectionsKt.plus(r107, u0.b(r111.f498776g));
    L13:
        if ((!StringsKt.isBlank(r106)) == true) goto L16;
        r106 = null;
    L16:
        if (r106 == null) goto L19;
        r102 = new t0(r106);
        goto L19
    L7:
        r103 = null;
    L20:
        r107 = CollectionsKt.emptyList();
        goto L22
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String d(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f498772c;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final String h(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f498774e;
    }

    @Override // com.obric.assistant.cocreationreview.w4
    public final String k(com.obric.assistant.cocreationreview.a r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "record");
        return r101.f498773d;
    }

    @Override // com.obric.assistant.cocreationreview.n5
    public final z4.a f(com.obric.assistant.cocreationreview.a r110, a5 r111) {
        g r112 = (g) r110;
        Intrinsics.checkNotNullParameter(r112, "record");
        Intrinsics.checkNotNullParameter(r111, "feedback");
        int r100 = u.f484757a;
        l5 r101 = c.f498766a;
        String r102 = r112.f498770a;
        String r103 = r112.f498774e;
        String r104 = r112.f498772c;
        e1 r105 = r112.f498776g;
        return u.f(r101, r102, r103, r104, r111, r105, false, t1.a(r104, r105.f484662h), null, null, null, 7808);
    }
}
