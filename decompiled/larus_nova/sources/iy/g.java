package iy;

import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes45.dex */
public interface g {
    boolean Bk();

    JsonObject C(my.b r100);

    void Dd(String r100, JsonObject r101);

    void Dh(String r100, JsonObject r101, Function1<? super JsonObject, Unit> r102);

    boolean Do(String r100);

    void Io(String r100);

    void Kp(i r100);

    List<ILinkPlayerInfoBridge> L4();

    void P0(my.c r100, k r101, boolean r102);

    boolean Rp();

    int Ti();

    int getCurrentScene();

    tf0.h getInteractAnimationService();

    void gk(dq2.k r100);

    boolean isEngineOn();

    boolean rb();

    Map<String, String> to(String r100);

    void updateFullScreenDialogShowStatus(boolean r100);
}
