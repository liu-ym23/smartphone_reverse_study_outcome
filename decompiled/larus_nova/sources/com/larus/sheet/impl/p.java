package com.larus.sheet.impl;

import androidx.fragment.app.Fragment;
import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import va8.n0;

/* JADX INFO: loaded from: classes31.dex */
public final class p implements pw9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetFragment f369039a;

    public p(SheetFragment r100) {
        this.f369039a = r100;
    }

    @Override // pw9.d
    public final void P(boolean r100) {
        FLogger.f375446a.i("SheetFragment", "refSelectStateChange, isRefSelect:" + r100);
        SheetFragment r101 = this.f369039a;
        int r102 = SheetFragment.R;
        Fragment r103 = r101.f360440f;
        if (r103 == null) goto L10;
        t1a.b r104 = s1a.a.g(r103);
        if (r104 == null) goto L11;
        n0 r105 = (n0) r104.getAbility(n0.class);
        if (r105 == null) goto L12;
        r105.P(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // pw9.d
    public final void b(String r100) {
        if (r100 == null) goto L15;
        String r101 = r100.toLowerCase(Locale.ROOT);
        if (r101 == null) goto L16;
        int r102 = nw9.a.f521014b;
        JSONObject r103 = this.f369039a.t9();
        Intrinsics.checkNotNullParameter(r103, "params");
        r103.put("button_name_level_one", r101);     // Catch: JSONException -> L9
    L11:
        TrackParams r104 = new TrackParams().merge(r103);
        by7.a r105 = new by7.a("text_selection_bar_show");
        r105.f21463a.merge(r104);
        r105.b();
        return;
    L9:
        e = move-exception;
        FLogger.f375446a.e("SheetDetailTracer", "error in SheetDetailTracer reportOutputPreviewToolShow: " + e.getLocalizedMessage());
        goto L11
    L16:
        return;
    }

    @Override // pw9.d
    public final void a(String r100, String r101, Integer r102) {
        SheetFragment r103 = this.f369039a;
        if (r102 == null) goto L5;
        String r104 = r102.toString();
    L6:
        r103.G = r104;
        Fragment r105 = this.f369039a.f360440f;
        if (r105 == null) goto L11;
        boolean r106 = true;
        if (r105.isAdded() != true) goto L11;
    L12:
        if (r106 == false) goto L14;
        this.f369039a.fa0(r100, r101);
        return;
    L14:
        SheetFragment r107 = this.f369039a;
        r107.E = r100;
        r107.F = r101;
        return;
    L11:
        r106 = false;
        goto L12
    L5:
        r104 = null;
        goto L6
    }
}
