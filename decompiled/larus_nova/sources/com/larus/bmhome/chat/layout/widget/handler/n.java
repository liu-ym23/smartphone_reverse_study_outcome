package com.larus.bmhome.chat.layout.widget.handler;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.common.utility.Logger;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.api.c0;
import com.larus.bmhome.utils.t2;
import com.larus.im.bean.message.Message;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.HtmlBlock;
import org.json.JSONArray;
import org.json.JSONObject;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class n implements pw8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f305046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ uvc.b f305047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o f305048c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.larus.bmhome.chat.layout.widget.handler.m] */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.larus.bmhome.chat.layout.widget.handler.l] */
    @Override // pw8.a
    public final void a(ViewGroup r510) {
        Intrinsics.checkNotNullParameter(r510, "parent");
        final c0 r100 = ILegacyChatUiServiceDelegate.f297164b.s8(this.f305046a);
        uvc.b r101 = this.f305047b;
        xc8.h r102 = null;
        if ((r101 instanceof HtmlBlock) == false) goto L5;
        HtmlBlock r103 = (HtmlBlock) r101;
    L6:
        if (r103 == null) goto L29;
        final o r104 = this.f305048c;
        final Context r105 = this.f305046a;
        String r106 = r103.f525768h;
        r104.getClass();
        if (r106 != null) goto L50;
    L20:
        final Message r107 = null;
    L21:
        if (r107 == null) goto L29;
        if (r100 == 0) goto L24;
        r100.g(r107);
    L24:
        if (r100 == 0) goto L26;
        r100.c(new l(r104));
    L26:
        if (r100 == 0) goto L29;
        r100.f(new m(r104, r105, r100, r107));
        goto L29
    L50:
        int r108 = t2.f315114a;     // Catch: Exception -> L18
        String r109 = t2.a(r104.f305049a.getMessageId(), r106);     // Catch: Exception -> L18
        if (r109 == null) goto L20;
        if (o0.d(r109) == false) goto L16;
        JSONArray r110 = new JSONObject(r109).optJSONArray("videos");     // Catch: Exception -> L18
        if (r110 == null) goto L16;
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L18
        r111.put("has_more", "false");     // Catch: Exception -> L18
        r111.put("search_result", new JSONObject().put("video_card", new JSONObject().put("card_list", r110)));     // Catch: Exception -> L18
        String r210 = r111.toString();     // Catch: Exception -> L18
        LinkedHashMap r112 = new LinkedHashMap();     // Catch: Exception -> L18
        r112.put("video_as_ref", "1");     // Catch: Exception -> L18
        r112.put("is_from_deep_search", "1");     // Catch: Exception -> L18
        Unit r113 = Unit.INSTANCE;     // Catch: Exception -> L18
        r107 = new Message(null, null, null, 0, 0, null, 0, false, null, r210, null, null, null, r112, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -8705, 31, null);     // Catch: Exception -> L18
    L16:
        Unit r114 = Unit.INSTANCE;     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Logger.e("SingleRowVideoWidgetHandler", "e : " + e);
        Unit r115 = Unit.INSTANCE;
    L29:
        if ((r100 instanceof ViewGroup) == false) goto L31;
        ViewGroup r116 = (ViewGroup) r100;
    L32:
        if (r116 == null) goto L49;
        Context r117 = this.f305046a;
        ViewGroup.LayoutParams r118 = r116.getLayoutParams();
        if (r118 == null) goto L48;
        r118.width = -1;
        r118.height = -2;
        if ((r118 instanceof ViewGroup.MarginLayoutParams) == false) goto L38;
        ViewGroup.MarginLayoutParams r119 = (ViewGroup.MarginLayoutParams) r118;
    L39:
        if (r119 == null) goto L42;
        r119.topMargin = i5.Q();
    L42:
        if ((r100 instanceof xc8.h) == false) goto L44;
        r102 = (xc8.h) r100;
    L44:
        if (r102 == null) goto L46;
        Resources r120 = r117.getResources();
        r102.setMaxWidth(WindowDisplayMetricsOverride.apply(r120, r120.getDisplayMetrics()).widthPixels);
    L46:
        r116.setLayoutParams(r118);
        r510.addView((View) r100);
        return;
    L38:
        r119 = null;
        goto L39
    L48:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L49:
        return;
    L31:
        r116 = null;
        goto L32
    L5:
        r103 = null;
        goto L6
    }

    @Override // pw8.a
    public final void b(int r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r101, "currentViewGroup");
    }

    public n(Context r100, uvc.b r101, o r102) {
        this.f305046a = r100;
        this.f305047b = r101;
        this.f305048c = r102;
    }
}
