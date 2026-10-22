package fxa;

import android.os.Bundle;
import com.ss.android.lark.biz.im.api.ChatIntentExtraBundle;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
import com.ss.android.lark.biz.im.api.bundle.ChatTeamBundle;
import com.ss.android.lark.biz.im.api.bundle.SourceType;

/* JADX INFO: loaded from: classes34.dex */
public interface b {
    boolean D();

    boolean a();

    String b();

    String c();

    boolean d();

    ChatTeamBundle e();

    ChatWindowPrepareData g();

    String getAppId();

    String getChatId();

    Bundle getExtraParams();

    String getMessageId();

    SourceType getSourceType();

    long getTabId();

    String h();

    boolean i();

    boolean isSecretChat();

    ChatIntentExtraBundle j();

    Bundle k();

    int o();

    String q();

    void r(int r100);

    boolean s();

    boolean t();

    void z(String r100);
}
