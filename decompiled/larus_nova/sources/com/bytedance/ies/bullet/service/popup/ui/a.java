package com.bytedance.ies.bullet.service.popup.ui;

import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements p36.a.InterfaceC7146a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsPopupFragment f248017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Window f248018b;

    @Override // p36.a.InterfaceC7146a
    public final void a(int r100) {
        boolean r101 = false;
        if (this.f248017a.da0().f511760u == true) goto L10;
        e r102 = this.f248017a.f247993i;
        if (r102 == null) goto L10;
        if (r100 <= 0) goto L8;
        boolean r103 = true;
    L9:
        Window r104 = this.f248018b;
        i16.c r105 = i16.c.f487996a;
        Intrinsics.checkNotNullParameter(r104, LiveEndPageData.TAG_WINDOW);
        View r106 = i16.c.b(r104);
        Rect r107 = new Rect();
        r106.getWindowVisibleDisplayFrame(r107);
        r102.i(r103, r100, Integer.valueOf(r107.bottom));
        goto L10
    L8:
        r103 = false;
    L10:
        AbsPopupFragment r108 = this.f248017a;
        JSONObject r109 = new JSONObject();
        r109.put("containerID", this.f248017a.getContainerId());
        if (r100 <= 0) goto L13;
        r101 = true;
    L13:
        r109.put("keyboardShow", r101);
        Unit r110 = Unit.INSTANCE;
        r108.ka0("bulletOnSoftInputChangedAction", r109);
    }

    public a(AbsPopupFragment r100, Window r101) {
        this.f248017a = r100;
        this.f248018b = r101;
    }
}
