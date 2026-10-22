package com.bytedance.lynx.map.ng.refactor;

import android.graphics.Bitmap;
import com.bytedance.map.api.model.IMarker;
import java.util.HashMap;

/* JADX INFO: loaded from: classes21.dex */
public interface a<M> {

    /* JADX INFO: renamed from: com.bytedance.lynx.map.ng.refactor.a$a, reason: collision with other inner class name */
    public interface InterfaceC3711a<M> {
        void a();

        M getMarkerObject();
    }

    void a(double r100, boolean r101, int r102);

    void b(String r100, HashMap<String, Object> r101, Bitmap r102);

    void c(double r100, double r101, boolean r102, int r103);

    void d(String r100);

    IMarker e(String r100, HashMap r101, c r102, Bitmap r103);
}
