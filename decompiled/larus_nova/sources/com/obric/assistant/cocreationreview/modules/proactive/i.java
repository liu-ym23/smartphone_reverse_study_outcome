package com.obric.assistant.cocreationreview.modules.proactive;

import com.obric.assistant.cocreationreview.ModuleKey;
import com.obric.assistant.cocreationreview.l5;
import com.obric.memorydata.sdk.proactive.ProactiveLabelingFeedbackConfigDto;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f387482a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ProactiveLabelingFeedbackConfigDto f387483b;

    static {
        f387482a = new i();
    }

    public i() {
    }

    public static l5 a() {
        ProactiveLabelingFeedbackConfigDto r100 = f387483b;
        if (r100 == null) goto L5;
        l5 r101 = e.f387469a;
        List<String> r102 = r100.f397167a;
        if (r102.isEmpty() == false) goto L9;
        r102 = r101.f387364g;
    L9:
        List<String> r110 = r102;
        List<String> r103 = r100.f397168b;
        if (r103.isEmpty() == false) goto L12;
        r103 = r101.f387365h;
    L12:
        List<String> r111 = r103;
        String r104 = r100.f397169c;
        if (StringsKt.isBlank(r104) == false) goto L15;
        r104 = r101.f387366i;
    L15:
        String r112 = r104;
        ModuleKey r105 = r101.f387358a;
        String r106 = r101.f387359b;
        String r107 = r101.f387360c;
        int r108 = r101.f387361d;
        int r109 = r101.f387362e;
        String r113 = r101.f387363f;
        String r114 = r101.f387367j;
        String r115 = r101.f387368k;
        boolean r116 = r101.f387369l;
        Intrinsics.checkNotNullParameter(r105, "key");
        Intrinsics.checkNotNullParameter(r106, "label");
        Intrinsics.checkNotNullParameter(r107, "shortLabel");
        Intrinsics.checkNotNullParameter(r113, "description");
        Intrinsics.checkNotNullParameter(r110, "positiveReasons");
        Intrinsics.checkNotNullParameter(r111, "negativeReasons");
        Intrinsics.checkNotNullParameter(r112, "feedbackPlaceholder");
        Intrinsics.checkNotNullParameter(r114, "positiveFeedbackPlaceholder");
        Intrinsics.checkNotNullParameter(r115, "negativeFeedbackPlaceholder");
        return new l5(r105, r106, r107, r108, r109, r113, r110, r111, r112, r114, r115, r116);
    L5:
        return e.f387469a;
    }

    public final void update(ProactiveLabelingFeedbackConfigDto r100) {
        f387483b = r100;
    }
}
