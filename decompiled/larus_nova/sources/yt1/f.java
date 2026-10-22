package yt1;

import android.content.Context;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public interface f<V extends View> {
    <T> void a(b<T, V> r100, Map<String, ? extends Object> r101);

    void b(com.bytedance.android.ecom.arch.slice.render.elements.flexbox.b r100, com.bytedance.android.ecom.arch.slice.render.elements.g r101, int r102, int r103, int r104, int r105);

    V createView(Context r100);

    int getType();
}
