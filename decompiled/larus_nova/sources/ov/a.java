package ov;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.android.gamecp.common.utils.j;
import com.bytedance.android.gamecp.host_api.service.IBaseHostService;

/* JADX INFO: loaded from: classes44.dex */
public interface a extends IBaseHostService {
    void N1();

    void U0();

    void a();

    boolean hasToolbarShow();

    Dialog i0(Context r100, String r101, CharSequence r102, String r103, DialogInterface.OnClickListener r104, String r105, j r106);

    void i2(String r100);

    void isEnablePersonalRecommend();

    void s1();

    void u2();

    void x0();
}
