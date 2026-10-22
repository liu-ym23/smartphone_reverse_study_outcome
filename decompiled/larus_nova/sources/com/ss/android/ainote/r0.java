package com.ss.android.ainote;

import android.view.animation.Interpolator;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public interface r0 {
    void a(long r100, Interpolator r101);

    void b(boolean r100, int r101, int r102);

    h c();

    void d(AINoteAction r100);

    void onEvent(String r100, JSONObject r101);
}
