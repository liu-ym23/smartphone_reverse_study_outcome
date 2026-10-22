package com.larus.larkfeed.impl.lark.holder.content;

import android.view.View;
import android.view.ViewGroup;
import com.larus.bmhome.chat.layout.holder.video.bean.AiGenVideoContentData;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public final class x implements kc8.c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f355421a;

    public x(View r100) {
        this.f355421a = r100;
    }

    @Override // kc8.c0
    public final void a(View r100, Message r101, nr9.g r102, JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "videoPlayData");
    }

    @Override // kc8.c0
    public final void d(View r100, Message r101, final AiGenVideoContentData r102, final JSONObject r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "data");
        final View r104 = this.f355421a;
        r100.setOnLongClickListener(new w(r104, r102, r103));
    }

    @Override // kc8.c0
    public final void c(View r100, Message r101, final df8.a r102, ViewGroup r103, final JSONObject r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "data");
        final View r105 = this.f355421a;
        r100.setOnLongClickListener(new v(r105, r102, r104));
    }

    @Override // kc8.c0
    public final void b(View r100, Message r101, kc8.f0 r102, int r103, ViewGroup r104, JSONObject r105) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "imageInfo");
    }
}
