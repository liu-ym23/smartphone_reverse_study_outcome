package com.ss.android.lark.chat.video;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.larus.nova.R;
import v0c.r;

/* JADX INFO: loaded from: classes35.dex */
public final class o extends v0c.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f416832e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f416833f;

    @Override // v0c.o
    public final void g() {
        this.f416833f = this.f416832e.findViewById(R.id.loading_progress);
    }

    @Override // v0c.a
    public final void k() {
        r r100 = i();
        if (r100 == null) goto L19;
        int r101 = r100.getState();
        if (r101 != (-2)) goto L7;
    L16:
        boolean r102 = false;
    L17:
        if (r102 == false) goto L19;
        r(r100.a());
        return;
    L7:
        if (r101 == (-1)) goto L16;
        if (r101 == 0) goto L16;
        r102 = true;
        if (r101 == 1) goto L16;
        if (r101 == 4) goto L16;
        if (r101 == 5) goto L16;
    L19:
        r(false);
    }

    public o(FragmentActivity r100) {
        super(r100);
    }

    @Override // v0c.a
    public final View m(Context r100) {
        View r101 = LayoutInflater.from(r100).inflate(R.layout.online_loading_cover, null);
        this.f416832e = r101;
        return r101;
    }

    public final void r(boolean r100) {
        if (r100 == false) goto L4;
        i();
        this.f416833f.setVisibility(0);
        q(0);
        return;
    L4:
        q(8);
    }

    @Override // v0c.b, v0c.o
    public final void a(int r100, Bundle r101) {
        switch(r100) {
            case -99052: goto L5;
            case -99050: goto L4;
            case -99015: goto L5;
            case -99014: goto L5;
            case -99013: goto L4;
            case -99011: goto L5;
            case -99010: goto L4;
            case -99007: goto L5;
            case -99001: goto L4;
            default: goto L8;
        };
    L4:
        r(true);
        return;
    L5:
        r(false);
        return;
    }

    @Override // v0c.b, v0c.o
    public final void h(int r100, Bundle r101) {
        q(8);
    }
}
