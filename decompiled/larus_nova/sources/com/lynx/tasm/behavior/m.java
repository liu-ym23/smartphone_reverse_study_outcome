package com.lynx.tasm.behavior;

import android.content.Context;
import javax.xml.transform.Transformer;

/* JADX INFO: loaded from: classes32.dex */
public interface m {

    public interface a {
        void a(Object r100, Throwable r101);
    }

    void loadImage(Context r100, String r101, String r102, float r103, float r104, Transformer r105, a r106);

    String shouldRedirectImageUrl(String r100);
}
