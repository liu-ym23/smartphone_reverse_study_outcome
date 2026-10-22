package com.bytedance.ee.bear.widgets.tagview;

import android.content.Context;
import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.component.universe_design.tag.UDTagsDrawable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/view/View;", "it", "Landroid/content/Context;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class SpaceTagType$Companion$partner$1 extends Lambda implements Function1<Context, View> {
    final /* synthetic */ String $tagValue;

    public SpaceTagType$Companion$partner$1(String r100) {
        this.$tagValue = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final View invoke2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        SpaceTagView r101 = new SpaceTagView(r100);
        String r102 = this.$tagValue;
        UDTagsDrawable.d.a r103 = new UDTagsDrawable.d.a(r101.getContext());
        r103.f285353c = r102;
        r103.c(UDTagsDrawable.TagColorSet.BLUE);
        r101.setLabel(r103);
        return r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ View invoke(Context r100) {
        return invoke2(r100);
    }
}
