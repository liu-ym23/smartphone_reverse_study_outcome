package ld8;

import android.view.View;
import android.widget.ImageView;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonAction;
import com.larus.bmhome.chat.component.bottom.floating.BottomFloatingButtonType;
import com.larus.bmhome.chat.component.bottom.floating.collect.CollectFrom;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public interface n extends t1a.a {
    void AE(BottomFloatingButtonType r100, Function1<? super View, Unit> r101);

    void Dm(boolean r100);

    ImageView G50();

    boolean Ho(CollectFrom r100, String r101);

    void Ib(BottomFloatingButtonAction r100, boolean r101);

    void RZ();

    void Sc(String r100);

    void e2(int r100);

    void m60(BottomFloatingButtonAction r100);

    boolean uo(BottomFloatingButtonType r100);
}
