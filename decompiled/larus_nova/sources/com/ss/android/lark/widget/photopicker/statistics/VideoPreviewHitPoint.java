package com.ss.android.lark.widget.photopicker.statistics;

import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.statistics.Statistics;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;
import s5c.d;

/* JADX INFO: loaded from: classes38.dex */
public final class VideoPreviewHitPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f447641a = 0;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/widget/photopicker/statistics/VideoPreviewHitPoint$MenuClickParams;", "Lcom/ss/android/lark/statistics/extensions/IParam;", "", "value", "", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "getKey", "SAVE_ALBUM", "SAVE_CLOUD", "BACK_CHAT", "FORWARD", "ENTER_PIP_MODE", "CHANGE_SPEED", "photo-picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum MenuClickParams extends Enum<MenuClickParams> implements d {
        public static final MenuClickParams BACK_CHAT = null;
        public static final MenuClickParams CHANGE_SPEED = null;
        public static final MenuClickParams ENTER_PIP_MODE = null;
        public static final MenuClickParams FORWARD = null;
        public static final MenuClickParams SAVE_ALBUM = null;
        public static final MenuClickParams SAVE_CLOUD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MenuClickParams[] f447642a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f447643b = null;
        private final String key;
        private final String value;

        public MenuClickParams() {
            throw null;
        }

        public static EnumEntries<MenuClickParams> getEntries() {
            return f447643b;
        }

        static {
            MenuClickParams r100 = new MenuClickParams("SAVE_ALBUM", 0, "save_album", null, 2, null);
            SAVE_ALBUM = r100;
            MenuClickParams r101 = new MenuClickParams("SAVE_CLOUD", 1, ShareChannel.SAVE_CLOUD, null, 2, null);
            SAVE_CLOUD = r101;
            MenuClickParams r102 = new MenuClickParams("BACK_CHAT", 2, "back_chat", null, 2, null);
            BACK_CHAT = r102;
            MenuClickParams r103 = new MenuClickParams("FORWARD", 3, "forward", null, 2, null);
            FORWARD = r103;
            MenuClickParams r104 = new MenuClickParams("ENTER_PIP_MODE", 4, "small_window", null, 2, null);
            ENTER_PIP_MODE = r104;
            MenuClickParams r105 = new MenuClickParams("CHANGE_SPEED", 5, "change_speed", null, 2, null);
            CHANGE_SPEED = r105;
            MenuClickParams[] r106 = {r100, r101, r102, r103, r104, r105};
            f447642a = r106;
            f447643b = EnumEntriesKt.enumEntries(r106);
        }

        public static MenuClickParams[] values() {
            return (MenuClickParams[]) f447642a.clone();
        }

        @Override // s5c.d
        public JSONObject toJson() {
            return d.b.c(this);
        }

        @Override // s5c.d
        public String getKey() {
            return this.key;
        }

        @Override // s5c.d
        public String getValue() {
            return this.value;
        }

        public static MenuClickParams valueOf(String r100) {
            return (MenuClickParams) a.a(MenuClickParams.class, r100);
        }

        @Override // s5c.d
        public d plus(Map<String, ? extends Object> r100) {
            return d.b.a(this, r100);
        }

        @Override // s5c.d
        public d plus(d r100) {
            return d.b.b(this, r100);
        }

        public MenuClickParams(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 2) == 0) goto L5;
            r103 = "click";
        L5:
            super(r100, r101);
            this.value = r102;
            this.key = r103;
        }
    }

    static {
    }

    public static void a(d r100, MessageIdentity r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r102 = r100.toJson();
        if (r101 == null) goto L5;
        r102.put("chat_id", r101.getChatId());
        r102.put("msg_id", r101.getMessageId());
    L5:
        Statistics.sendEvent("public_video_browser_click", r102);
    }

    public static void b(MenuClickParams r100, MessageIdentity r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r102 = r100.toJson();
        if (r101 == null) goto L5;
        r102.put("chat_id", r101.getChatId());
        r102.put("msg_id", r101.getMessageId());
    L5:
        Statistics.sendEvent("public_video_browser_more_click", r102);
    }
}
