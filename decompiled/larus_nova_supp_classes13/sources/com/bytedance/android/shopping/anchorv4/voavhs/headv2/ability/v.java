package com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.android.ecom.arch.slice.SlcContext;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface v extends d83.c {
    List<String> getImages();

    void k0(String r1);

    void l0(int r1, String r2);

    void l9(GalleryVO r1);

    boolean m0(Boolean r1, boolean r2);

    Rect m9();

    ActionContext n0();

    float n9();

    void o9(boolean r1, int r2);

    void p9(com.bytedance.android.ecom.arch.slice.g r1, IAction r2, View r3, Map<String, ? extends Object> r4);

    SlcContext q9();

    void r9();

    boolean s();

    void s9(int r1);

    void t(b0 r1);

    void w5(Map<Integer, String> r1);

    void x(p r1);

    void y5(String r1);

    void z(View r1, String r2, Map<String, ? extends Object> r3, Map<String, ? extends Object> r4);

    void z5(boolean r1);
}
