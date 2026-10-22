package com.bytedance.ee.bear.contract;

import android.os.Bundle;
import android.os.IBinder;
import com.bytedance.ee.bear.more.itemv2.ShortcutItemV2;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface x {

    public interface a {
    }

    void A(int r1);

    void B(String r1, String r2, String r3, IBinder r4);

    DefaultEmojiPanelData a();

    Bundle doCommand(Bundle r1);

    List<String> f();

    List<String> h();

    boolean i(String r1);

    List<String> o();

    void q(String r1, IGetDataCallback<Integer> r2);

    void r();

    void s(boolean r1, String r2, ShortcutItemV2.a r3);

    void t(String r1, String r2);

    String u(String r1);

    void v(String r1);

    void w(String r1, String r2, boolean r3);

    void x();

    void y(String r1, Map<String, String> r2);

    void z(String r1, ArrayList r2);
}
