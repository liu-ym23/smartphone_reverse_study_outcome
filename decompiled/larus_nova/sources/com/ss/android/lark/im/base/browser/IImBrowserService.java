package com.ss.android.lark.im.base.browser;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&J*\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J>\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010H&J`\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H&¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/im/base/browser/IImBrowserService;", "", "sendLinkClickEvent", "", "scene", "", "location", RuleConditionBean.OPEN_URL_KEY, PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "source", "", "extraParams", "Landroid/os/Bundle;", "docsArgs", "", "extra", "sourceFragment", "Landroidx/fragment/app/Fragment;", "createSecLinkHelper", "Lcom/ss/android/lark/im/base/browser/IImBrowserService$ISecLinkHelper;", "title", "Companion", "ISecLinkHelper", "im-biz-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IImBrowserService {
    public static final a Companion = null;
    public static final String EXTRA_SEC_LINK_PARAMS = "lk_seclink_params";
    public static final String FROM_SCENE_CHAT = "chat";
    public static final String KEY_DOC_TITLE = "key_doc_title";
    public static final String KEY_FROM_SCENE = "fromScene";
    public static final String KEY_WEB_SCENE = "webScene";
    public static final String LINK_LOCATION_CHAT = "messenger_chat";
    public static final String LINK_LOCATION_MESSAGE_CARD = "messenger_chat_shared_link_card";
    public static final String LINK_LOCATION_PIN = "messenger_pin";
    public static final String LINK_SCENE_MESSENGER = "messenger";
    public static final int SCENE_FROM_CARD_LINK_GROUP = 1008;
    public static final int SCENE_FROM_CARD_LINK_SINGLE = 1007;
    public static final int SCENE_FROM_CHAT_GROUP = 1010;
    public static final int SCENE_FROM_CHAT_SINGLE = 1009;
    public static final int SCENE_MESSAGE_CARD_FOOTER_LINK = 1511;
    public static final int SOURCE_TYPE_APP = 1;
    public static final int SOURCE_TYPE_CARD_FOOTER_LINK = 12;
    public static final int SOURCE_TYPE_CARD_GROUP = 9;
    public static final int SOURCE_TYPE_CARD_LINK_GROUP = 11;
    public static final int SOURCE_TYPE_CARD_LINK_SINGLE = 10;
    public static final int SOURCE_TYPE_CARD_SINGLE = 8;
    public static final int SOURCE_TYPE_GROUP_CHAT = 6;
    public static final int SOURCE_TYPE_P2P_CHAT = 5;
    public static final int SOURCE_TYPE_THREAD_TOPIC = 7;
    public static final int SOURCE_TYPE_UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f425882a = null;

        static {
            f425882a = new a();
        }

        public a() {
        }
    }

    public interface b {
    }

    static {
        Companion = a.f425882a;
    }

    b createSecLinkHelper(String r100, String r101);

    void openUrl(Context r100, String r101);

    void openUrl(Context r100, String r101, int r102, Bundle r103);

    void openUrl(Context r100, String r101, int r102, Bundle r103, Map<String, String> r104);

    void openUrl(Context r100, String r101, int r102, Bundle r103, Map<String, String> r104, Map<String, String> r105, Fragment r106);

    void sendLinkClickEvent(String r100, String r101);
}
