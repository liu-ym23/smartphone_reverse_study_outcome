package com.ss.android.lark.newemoji.emojioptions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements OptionsSelectPopupMenu.d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f432993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Collection<String> f432994b;

    @Override // com.ss.android.lark.newemoji.emojioptions.OptionsSelectPopupMenu.d
    public final View a(String r100) {
        String r101 = r100;
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        ImageView r102 = new ImageView(this.f432993a);
        int r103 = UIHelper.dp2px(32.0f);
        r102.setLayoutParams(new ViewGroup.LayoutParams(r103, r103));
        Bitmap r104 = qsb.b.a().Hb(r101, false);
        if (r104 != null) goto L5;
        r102.setImageDrawable(new xsb.a(r102.getContext(), r103, r103));
    L6:
        return r102;
    L5:
        r102.setImageDrawable(new BitmapDrawable(r102.getContext().getResources(), r104));
        goto L6
    }

    public a(List<String> r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "options");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f432993a = r101;
        this.f432994b = r100;
    }
}
