package com.ss.android.lark.search.ui.result.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.EllipsizedEmojiconTextView;
import f4c.e;
import j4c.a0;
import j4c.o;
import kotlin.jvm.internal.Intrinsics;
import w3c.f;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements o, b08.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b08.a f440344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g4c.a f440345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EllipsizedEmojiconTextView f440346c;

    @Override // b08.c
    public final <M, V extends View> void registerModelBinder(Class<M> r100, Class<V> r101, b08.b<? super V, ? super M> r102) {
        this.f440344a.registerModelBinder(r100, r101, r102);
    }

    public a() {
        b08.a r100 = new b08.a();
        Intrinsics.checkNotNullParameter(r100, "compositeComponentDelegate");
        this.f440344a = r100;
        this.f440345b = new g4c.a();
    }

    @Override // j4c.o
    public final void a(int r100) {
        EllipsizedEmojiconTextView r101 = this.f440346c;
        if (r101 != null) goto L5;
        return;
    L5:
        if (AvatarItemFrameView.f440314h != (-1)) goto L9;
        int r102 = a0.b(r101, r100);
        AvatarItemFrameView.f440314h = r102;
        Log.d("LarkSearch.Common.AvatarItemFrameView", String.valueOf(r102));
        return;
    }

    @Override // j4c.o
    public final void b(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        r101.removeAllViews();
        EllipsizedEmojiconTextView r102 = new EllipsizedEmojiconTextView(r100);
        r102.setId(R.id.avatar_item_subtitle);
        int r103 = a0.a(20.0f, r100);
        this.f440345b.f480012a.isEnable("lark.search.enable.search_font_size_opt");
        r102.setLayoutParams(new LinearLayout.LayoutParams(-2, r103));
        ViewGroup.LayoutParams r104 = r102.getLayoutParams();
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        int r105 = a0.a(4.0f, r100);
        ((LinearLayout.LayoutParams) r104).topMargin = r105;
        r102.setIncludeFontPadding(false);
        r102.setGravity(16);
        this.f440345b.f480012a.isEnable("core.forward.search_department");
        r102.setEllipsize(TextUtils.TruncateAt.END);
        r102.f445616j = TextUtils.TruncateAt.END;
        r102.setMaxLines(1);
        r102.setSingleLine(true);
        r102.setTextSize(2, 14.0f);
        r102.setTextColor(r100.getResources().getColor(R.color.text_placeholder));
        r102.setVisibility(8);
        r101.addView(r102);
        this.f440346c = r102;
        registerModelBinder(f.class, EllipsizedEmojiconTextView.class, e.f475601a);
    }
}
