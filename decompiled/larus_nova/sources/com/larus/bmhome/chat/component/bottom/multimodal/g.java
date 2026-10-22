package com.larus.bmhome.chat.component.bottom.multimodal;

import android.net.Uri;
import com.larus.bmhome.clarification.ClarificationComponent;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.action.DirectSendData;
import com.larus.platform.model.album.AlbumSettingConfig;
import java.util.Set;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes25.dex */
public interface g extends m1a.a {

    public static final class a {
        public static /* synthetic */ boolean a(g r100) {
            return r100.nA(null);
        }
    }

    MultimodalDowngradeData A6();

    boolean Fb();

    void M6();

    boolean Me(String r100, Integer r101, DirectSendData r102);

    void OR(e1 r100);

    void QS();

    void VR(ClarificationComponent.e r100, Set r101);

    void Xc(Boolean r100);

    void bh(boolean r100);

    void cZ();

    AlbumSettingConfig eP();

    void f60(ClarificationComponent.e r100);

    boolean g90();

    void gx(n r100);

    Object kp(Uri r100, String r101, Continuation<? super Boolean> r102);

    void l90();

    boolean ld();

    String mS(boolean r100, Boolean r101);

    void n90(e1 r100);

    boolean nA(BotModel r100);

    void pd(boolean r100);

    void pm();

    void pn();

    void x2(ns8.b r100);

    boolean xE();

    boolean yb(BotModel r100);

    boolean yz();

    int zv(boolean r100, Boolean r101);
}
