package com.larus.chat.gallery.impl.preview.input;

import com.larus.camera.api.params.CameraOutputContext;
import com.larus.camera.api.params.CameraResultRoute;
import com.larus.chat.gallery.impl.preview.provider.w0;
import java.util.List;

/* JADX INFO: loaded from: classes26.dex */
public interface d0 {
    String a();

    com.larus.chat.gallery.api.o b();

    boolean c(ChildResultMode r100);

    com.larus.chat.gallery.api.o d(String r100);

    void detach();

    boolean e();

    boolean f(CameraResultRoute r100);

    void g();

    com.larus.chat.gallery.api.q getSession();

    boolean h(CameraOutputContext r100, xy8.d r101);

    int i(String r100);

    void j(w0 r100);

    boolean k(String r100);

    List<com.larus.chat.gallery.api.o> l();
}
