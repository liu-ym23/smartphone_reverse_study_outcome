package com.larus.voicecall.impl.ui;

import android.view.OrientationEventListener;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RealtimeCallActivity f379370a;

    public d(RealtimeCallActivity r100) {
        this.f379370a = r100;
        super(r100, 3);
    }

    @Override // android.view.OrientationEventListener
    public final void onOrientationChanged(int r100) {
        int r101 = 0;
        if (r100 < 0) goto L6;
        if (r100 >= 46) goto L6;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
    L36:
        r101 = 1;
    L37:
        FLogger.f375446a.i("RealtimeCallActivity", "setPad newOrientation=" + r101 + ", orientationValue=" + r100);
        this.f379370a.setRequestedOrientation(r101);
        RealtimeCallActivity r103 = this.f379370a;
        OrientationEventListener r104 = r103.f379262h;
        if (r104 == null) goto L40;
        r104.disable();
    L40:
        r103.f379262h = null;
        return;
    L9:
        if (315 <= r100) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == true) goto L36;
        if (46 > r100) goto L20;
        if (r100 >= 136) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == false) goto L24;
        r101 = 8;
        goto L37
    L24:
        if (136 > r100) goto L27;
        if (r100 >= 226) goto L27;
        boolean r107 = true;
    L28:
        if (r107 == false) goto L30;
        r101 = 9;
        goto L37
    L30:
        if (226 > r100) goto L33;
        if (r100 >= 315) goto L33;
        boolean r108 = true;
    L34:
        if (r108 == false) goto L36;
    L33:
        r108 = false;
    L27:
        r107 = false;
    L20:
        r106 = false;
        goto L21
    L11:
        if (r100 >= 361) goto L13;
        r105 = true;
    L6:
        r102 = false;
        goto L7
    }
}
