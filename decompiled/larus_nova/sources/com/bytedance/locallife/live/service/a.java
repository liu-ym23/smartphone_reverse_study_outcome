package com.bytedance.locallife.live.service;

import com.bytedance.android.livehostapi.business.depend.livead.IGroupPurchaseItemCallback;
import com.bytedance.android.livehostapi.business.depend.locallife.ILiveLocalLifeFragmentDelegate;
import com.google.gson.JsonObject;
import is2.b;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jv6.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public interface a {
    void a(String r100, long r101, String r102, IGroupPurchaseItemCallback r103, String r104, String r105);

    h b();

    List<b> c();

    void d(Object r100);

    Map<String, Object> e(String r100, HashMap<String, Object> r101);

    void f(String r100, HashMap<String, Object> r101, Function1<? super Map<String, ? extends Object>, Unit> r102);

    void g(Object r100);

    ILiveLocalLifeFragmentDelegate getLiveGoodsDetailDialogFragment(String r100, boolean r101, String r102);

    JSONObject getRoomInfo();

    void h(int r100);

    void hideLiveFloatWindow();

    void i(String r100, Map r101);

    void initRoomController();

    void j(String r100, JSONObject r101);

    String k(long r100);

    void openLiveLifeGrouponPage(Map<String, ? extends Object> r100);

    JsonObject postMsg(String r100, JsonObject r101, JsonObject r102, Function3<? super String, ? super Map<String, ? extends Object>, ? super Map<String, ? extends Object>, Unit> r103);

    int registerLiveLifeMsgCenter(String r100, JsonObject r101, Function3<? super String, ? super Map<String, ? extends Object>, ? super Map<String, ? extends Object>, Unit> r102);

    int unRegisterLiveLifeMsgCenter(String r100, JsonObject r101, Function3<? super String, ? super Map<String, ? extends Object>, ? super Map<String, ? extends Object>, Unit> r102);

    boolean updateSessionInfo(String r100, HashMap<String, String> r101);

    boolean useAppendExpoundCardIdInjector();
}
