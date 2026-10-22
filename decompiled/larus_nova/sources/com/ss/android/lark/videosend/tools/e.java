package com.ss.android.lark.videosend.tools;

import com.ss.android.lark.log.Log;
import com.ss.android.vesdk.VELogProtocol;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements VELogProtocol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f445006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f445007b;

    public e(boolean r100, boolean r101) {
        this.f445006a = r100;
        this.f445007b = r101;
    }

    @Override // com.ss.android.vesdk.VELogProtocol
    public final void logToLocal(int r100, String r101) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L21;
        if (r100 == 2) goto L16;
        if (r100 != 3) goto L11;
        Log.w("VE_SDK_LOG", r101);
        return;
    L11:
        if (r100 != 4) goto L38;
        Log.e("VE_SDK_LOG", r101);
        return;
    L38:
        return;
    L16:
        if (this.f445006a == false) goto L18;
    L19:
        Log.i("VE_SDK_LOG", r101);
        return;
    L18:
        if (this.f445007b == true) goto L19;
        return;
    L21:
        if (this.f445006a == false) goto L23;
    L24:
        Log.d("VE_SDK_LOG", r101);
        return;
    L23:
        if (this.f445007b == true) goto L24;
        return;
    L26:
        if (this.f445006a == false) goto L28;
    L29:
        Log.v("VE_SDK_LOG", r101);
        return;
    L28:
        if (this.f445007b == true) goto L29;
    }
}
