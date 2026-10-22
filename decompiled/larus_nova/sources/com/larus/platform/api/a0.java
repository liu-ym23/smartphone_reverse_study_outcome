package com.larus.platform.api;

import android.net.Uri;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.platform.model.preview.AttachmentSnapshot;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
public interface a0 {
    void BA(boolean r100);

    void Bs(FragmentManager r100, String r101);

    void Ci(Fragment r100);

    boolean H10();

    void Lb(Function1<? super View, ? extends View> r100);

    void Nu(int r100);

    boolean RU(List<AttachmentSnapshot> r100);

    boolean S0();

    void Ua();

    void Uw();

    View Yz();

    boolean au();

    void cP(String r100);

    boolean gC();

    void k6(int r100, boolean r101);

    void n60();

    Fragment od();

    void tZ(Uri r100);

    void uH();
}
