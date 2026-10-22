package com.franmontiel.persistentcookiejar.cache;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import okhttp3.g;

/* JADX INFO: loaded from: classes23.dex */
class IdentifiableCookie {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f274227a;

    public final int hashCode() {
        int r100 = (((((TTVideoEngineInterface.PLAYER_OPTION_ABR_STALL_PENALTY_PARAMETER + this.f274227a.f523855a.hashCode()) * 31) + this.f274227a.f523858d.hashCode()) * 31) + this.f274227a.f523859e.hashCode()) * 31;
        g r101 = this.f274227a;
        return ((r100 + (!r101.f523860f ? 1 : 0)) * 31) + (!r101.f523863i ? 1 : 0);
    }

    public IdentifiableCookie(g r100) {
        this.f274227a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof IdentifiableCookie) == true) goto L5;
        return false;
    L5:
        IdentifiableCookie r101 = (IdentifiableCookie) r100;
        if (r101.f274227a.f523855a.equals(this.f274227a.f523855a) == true) goto L8;
        return false;
    L8:
        if (r101.f274227a.f523858d.equals(this.f274227a.f523858d) == true) goto L10;
        return false;
    L10:
        if (r101.f274227a.f523859e.equals(this.f274227a.f523859e) == false) goto L19;
        g r102 = r101.f274227a;
        boolean r103 = r102.f523860f;
        g r104 = this.f274227a;
        if (r103 == r104.f523860f) goto L14;
        return false;
    L14:
        if (r102.f523863i != r104.f523863i) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    }
}
