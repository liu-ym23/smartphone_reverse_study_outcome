package it6;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdkapi.room.handler.toolbar.ToolbarMatchInterface;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes21.dex */
public interface f {
    void a(FragmentActivity r100, String r101, Window r102);

    void b(FragmentActivity r100, String r101, Window r102);

    void c();

    void d(FragmentActivity r100, com.bytedance.locallife.live.controller.j.c r101);

    void e(Context r100, Uri r101, Function2 r102, Function0 r103);

    boolean f(Activity r100);

    void g(FragmentActivity r100, com.bytedance.locallife.live.controller.j.c r101);

    String getAnchorShelfSchema();

    Bundle getLiveLocalRoomInfo(FragmentActivity r100, String r101, boolean r102);

    void getLiveSdkVersion();

    Object getRoomInfoByUniqueKey(FragmentActivity r100, String r101);

    Object getShortTermState(FragmentActivity r100);

    long getTimeStamp();

    void h(ToolbarMatchInterface r100, boolean r101);

    void i(View r100, Map<String, ? extends Object> r101);

    void removeEnterActionParams(FragmentActivity r100, String r101);

    void setLifeShareId(FragmentActivity r100, String r101);
}
