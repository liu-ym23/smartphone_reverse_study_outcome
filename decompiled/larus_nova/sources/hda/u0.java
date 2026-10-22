package hda;

import com.larus.nova.R;
import com.obric.assistant.cocreationreview.CardTemplateTagTone;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class u0 {
    public static final boolean a(e1 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((!r100.f484666l.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!r100.f484664j.isEmpty()) == false) goto L7;
        return true;
    L7:
        if ((!r100.f484665k.isEmpty()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final List<com.obric.assistant.cocreationreview.c> b(e1 r100) {
        Intrinsics.checkNotNullParameter(r100, "uiModel");
        if (a(r100) == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        return CollectionsKt.listOf(new com.obric.assistant.cocreationreview.c("记忆来源", CardTemplateTagTone.NEUTRAL, Integer.valueOf(R.drawable.ic_cocreation_memory_source), null, null, "memory_source", null, 180));
    }
}
