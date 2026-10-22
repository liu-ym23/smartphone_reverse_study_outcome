package com.ss.android.lark.chat.message.menu.context;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.ss.android.lark.blueprint.q;
import com.ss.android.lark.blueprint.recyclerview.BlueprintCellViewHolder;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.e;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.widget.light.LKUILightTextView;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yya.n;
import yya.o;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements n, o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h3b.b f415488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y6b.a<?> f415489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Point f415490c;

    @Override // yya.o
    public final LKUILightTextView e() {
        if (CollectionsKt.listOf(new Message.Type[]{Message.Type.TEXT, Message.Type.POST, Message.Type.DOUBAO, Message.Type.AUDIO}).contains(this.f415489b.getType()) == true) goto L5;
        return null;
    L5:
        View r100 = this.f415488a.f410625g;
        if (r100 != null) goto L8;
        return null;
    L8:
        return g(r100);
    }

    @Override // yya.n
    public final View a() {
        View r100 = this.f415488a.f410625g;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("rootView is null".toString());
    }

    @Override // yya.n
    public final int b() {
        h3b.b r100 = this.f415488a;
        BlueprintCellViewHolder<y6b.a<?>> r101 = null;
        if ((r100 instanceof xza.a) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L8;
        r101 = r100.i();
    L8:
        if (r101 == null) goto L12;
        return r101.getLayoutPosition();
    L12:
        throw new IllegalStateException("ViewHolder is null".toString());
    }

    @Override // yya.n
    public final void d() {
        q<y6b.a<?>> r100 = this.f415488a.l();
        if ((r100 instanceof e) == false) goto L5;
        e r101 = (e) r100;
    L6:
        if (r101 == null) goto L9;
        r101.h();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // yya.n
    public final void f() {
        q<y6b.a<?>> r100 = this.f415488a.l();
        if ((r100 instanceof e) == false) goto L5;
        e r101 = (e) r100;
    L6:
        if (r101 == null) goto L9;
        r101.e();
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // yya.n
    public final View o0() {
        q<y6b.a<?>> r100 = this.f415488a.l();
        if ((r100 instanceof com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c) == false) goto L5;
        com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c r101 = (com.ss.android.lark.chat.chatwindow.chat.message.cellv2.layout.c) r100;
    L6:
        if (r101 == null) goto L11;
        ViewGroup r102 = r101.k();
        if (r102 == null) goto L11;
        return r102;
    L11:
        return a();
    L5:
        r101 = null;
        goto L6
    }

    @Override // yya.n
    public final Point c() {
        return this.f415490c;
    }

    public static LKUILightTextView g(View r100) {
        if ((r100 instanceof LKUILightTextView) == false) goto L7;
        return (LKUILightTextView) r100;
    L7:
        if ((r100 instanceof ViewGroup) == false) goto L14;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L9:
        if (r103 >= r102) goto L18;
        LKUILightTextView r104 = g(r101.getChildAt(r103));
        if (r104 != null) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return r104;
    L18:
        return null;
    L14:
        return null;
    }

    public a(h3b.b r100, y6b.a<?> r101, Point r102) {
        Intrinsics.checkNotNullParameter(r100, LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL);
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r102, "touchEventOnWindow");
        this.f415488a = r100;
        this.f415489b = r101;
        this.f415490c = r102;
    }
}
