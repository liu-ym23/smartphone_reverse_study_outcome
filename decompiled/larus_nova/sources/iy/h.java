package iy;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.liveinteract.plantform.utils.l;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import ny.o;
import ny.t;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public interface h {
    void A4(JsonObject r100);

    ApiServerException B4(int r100, String r101);

    boolean C4();

    Integer O0();

    void Q1();

    String d();

    int g();

    Context getContext();

    IRoomBase getRoom();

    void m4();

    void n4(Function0<Unit> r100, Function0<Unit> r101);

    void o4(t r100, ei6.a r101);

    void p4();

    Object q4();

    l r4();

    void s4(JSONObject r100);

    boolean t4();

    Object u4(String r100, o r101);

    boolean v4();

    void w4(JsonObject r100);

    void x4();

    long y4();

    void z4(ny.e r100, ec6.a r101, Function0 r102, Function0 r103);
}
