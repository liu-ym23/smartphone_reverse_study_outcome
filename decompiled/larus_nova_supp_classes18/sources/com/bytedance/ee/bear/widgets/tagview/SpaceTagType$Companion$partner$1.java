package com.bytedance.ee.bear.widgets.tagview;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/view/View;", "it", "Landroid/content/Context;", "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SpaceTagType$Companion$partner$1 extends Lambda implements Function1<Context, View> {
    final /* synthetic */ String $tagValue;

    public SpaceTagType$Companion$partner$1(String r1) {
        this.$tagValue = r1;
        super(1);
    }

    public final View invoke(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        SpaceTagView r0 = new SpaceTagView(r4);
        String r5 = this.$tagValue;
        UDTagsDrawable.d.a r1 = new UDTagsDrawable.d.a(r0.getContext());
        r1.c = r5;
        r1.c(UDTagsDrawable.TagColorSet.BLUE);
        r0.setLabel(r1);
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Context) r1);
    }
}
