package com.bytedance.locallife.poi.dito.poi.component;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.poi.dito.poi.entity.PoiTag;
import com.bytedance.locallife.poi.experiment.PoiBigFontExperiment;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f262523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxTextView f262524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DuxTextView f262525c;

    public static final class a {
    }

    static {
    }

    public m(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        this.f262523a = r100;
        this.f262524b = (DuxTextView) r100.findViewById(R.id.poi_detail_tag_text);
        this.f262525c = (DuxTextView) r100.findViewById(R.id.poi_detail_tag_text_place_holder);
    }

    public final void a(PoiTag r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "poiTag");
        String r103 = r100.getDisplayText();
        this.f262525c.setText(r103);
        this.f262524b.setText(r103);
        DuxTextView r104 = this.f262524b;
        String r105 = "";
        if (r101 != r102) goto L9;
        Context r106 = this.f262523a.getContext();
        Object[] r107 = new Object[1];
        String r108 = r100.getDisplayText();
        if (r108 == null) goto L8;
        r105 = r108;
    L8:
        r107[0] = r105;
        String r109 = r106.getString(R.string.poi_ugc_tag_selected_talkback, r107);
    L14:
        r104.setContentDescription(r109);
        if (r101 != r102) goto L23;
        int r110 = com.bytedance.locallife.poi.poidetail.container.mob.h.f263875a;
        DuxTextView r111 = this.f262524b;
        if (PoiBigFontExperiment.a() == false) goto L20;
        if (r111 == null) goto L22;
        r111.setTextSize(1, 17.0f);
    L22:
        this.f262524b.setTypeface(Typeface.create("PingFangSC", 1));
        return;
    L20:
        if (r111 == null) goto L22;
        r111.setTextSize(2, 17.0f);
        goto L22
    L23:
        int r112 = com.bytedance.locallife.poi.poidetail.container.mob.h.f263875a;
        DuxTextView r113 = this.f262524b;
        if (PoiBigFontExperiment.a() == false) goto L27;
        if (r113 == null) goto L29;
        r113.setTextSize(1, 15.0f);
    L29:
        this.f262524b.setTypeface(Typeface.create("PingFangSC", 0));
        return;
    L27:
        if (r113 == null) goto L29;
        r113.setTextSize(2, 15.0f);
        goto L29
    L9:
        String r114 = r100.getDisplayText();
        if (r114 == null) goto L13;
        r105 = r114;
    L13:
        r109 = r105;
        goto L14
    }
}
