package com.bytedance.ee.bear.bitable.core.basemain.ability;

import android.content.res.Configuration;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.browser.plugin.TitleBar;
import com.bytedance.ee.bear.browser.plugin.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public interface b extends i {
    boolean D3();

    com.bytedance.ee.bear.bitable.core.infoarch.f Dl();

    void G7(a r100);

    void Od(com.bytedance.ee.bear.bitable.card.viewmodel.a r100);

    void Qn(BaseMainOverlayType r100, boolean r101);

    void Sa(Function0<Unit> r100);

    void Vg(TitleBar r100);

    void W3();

    boolean We();

    boolean ak();

    void bd(boolean r100);

    boolean d5();

    void destroy();

    boolean h3(Fragment r100);

    void hideLoading();

    boolean l1();

    void l5();

    void m1();

    void ol(boolean r100);

    void onConfigurationChanged(Configuration r100);

    void ph(m r100);

    Integer t5(boolean r100);

    int z1();
}
