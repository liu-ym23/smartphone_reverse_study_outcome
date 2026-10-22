package com.bytedance.applet.model.floating;

import android.content.Context;
import android.view.View;
import com.bytedance.ai.model.objects.PageInfo;
import com.larus.common_ui.floatwindow.manager.FloatPriority;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b implements e19.h {
    public final FloatPriority a;
    public boolean b;
    public final boolean c;
    public final String d;
    public final View e;
    public int f;
    public int g;
    public final /* synthetic */ PageInfo h;
    public final /* synthetic */ k2.s i;
    public final /* synthetic */ String j;

    public final int c() {
        return 0;
    }

    public final boolean g() {
        return false;
    }

    public final boolean n0() {
        return false;
    }

    public final void a() {
        c.f = "";
        com.bytedance.ai.utils.g.a.i("FloatingAbilityImpl", this.j + " is Removed, info=" + this.h.getPageData() + ", packageName[" + this.h.getPackageName() + "], pageName[" + this.h.getPageName() + ']');
        if (Intrinsics.areEqual(c.e, this.j) == false) goto L5;
        c.e = "";
    L5:
        this.i.e();
        c.c.remove(this.j);
        c.d.remove(this.j);
    }

    public final void b() {
        com.bytedance.ai.utils.g r0 = com.bytedance.ai.utils.g.a;
        r0.i("FloatingAbilityImpl", this.j + " is Added, info=" + this.h.getPageData() + " packageName[" + this.h.getPackageName() + "], pageName[" + this.h.getPageName() + ']');
        c r1 = c.a;
        c.e = this.j;
        JSONObject r2 = new JSONObject();
        Intrinsics.checkNotNullParameter(r2, "$this$publishEvent");
        r2.put("resource_id", c.f);
        Unit r3 = Unit.INSTANCE;
        StringBuilder r4 = new StringBuilder("send event：EVENT_ATTACH_FLOAT_PAGE payload=");
        r4.append(r2);
        r0.i("FloatingAbilityImpl", r4.toString());
        c.b.setValue(TuplesKt.to("EVENT_ATTACH_FLOAT_PAGE", r2));
    }

    public final e19.f h() {
        return new e19.f(0);
    }

    public final void onWindowDismiss() {
        com.bytedance.ai.utils.g.a.i("FloatingAbilityImpl", this.j + " is Dismissed, packageName[" + this.h.getPackageName() + "], pageName[" + this.h.getPageName() + ']');
        this.i.i();
    }

    public final void onWindowShow() {
        com.bytedance.ai.utils.g.a.i("FloatingAbilityImpl", this.j + " is Showed, packageName[" + this.h.getPackageName() + "], pageName[" + this.h.getPageName() + ']');
        this.i.a();
    }

    public final List<String> d() {
        return CollectionsKt.emptyList();
    }

    public final boolean f() {
        return this.c;
    }

    public final View getContentView() {
        return this.e;
    }

    public final int getHeight() {
        return this.g;
    }

    public final FloatPriority getPriority() {
        return this.a;
    }

    public final int getWidth() {
        return this.f;
    }

    public final boolean i() {
        return this.b;
    }

    public final String k() {
        return this.d;
    }

    public final void e(boolean r1) {
        this.b = r1;
    }

    public final void j(e19.b r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
    }

    public final View l(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.e;
    }

    public final void setHeight(int r1) {
        this.g = r1;
    }

    public final void setWidth(int r1) {
        this.f = r1;
    }

    public b(Ref.IntRef r1, boolean r2, PageInfo r3, View r4, k2.s r5, String r6) {
        this.h = r3;
        this.i = r5;
        this.j = r6;
        this.a = new FloatPriority(r1.element);
        this.c = r2;
        this.d = r3.getPackageName();
        this.e = r4;
        this.f = r5.width();
        this.g = r5.height();
    }
}
