package com.bytedance.ee.bear.contract;

import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.ee.bear.more.itemv2.ShortcutItemV2;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public interface x {

    public interface a {
    }

    void A(int r100);

    void B(String r100, String r101, String r102, IBinder r103);

    DefaultEmojiPanelData a();

    Bundle doCommand(Bundle r100);

    List<String> f();

    List<String> h();

    boolean i(String r100);

    List<String> o();

    void q(String r100, IGetDataCallback<Integer> r101);

    void r();

    void s(boolean r100, String r101, ShortcutItemV2.a r102);

    void t(String r100, String r101);

    String u(String r100);

    void v(String r100);

    void w(String r100, String r101, boolean r102);

    void x();

    void y(String r100, Map<String, String> r101);

    void z(String r100, ArrayList r101);
}
