package mq1;

import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes8.dex */
public interface z {

    /* JADX INFO: renamed from: j2, reason: collision with root package name */
    public static final a f514788j2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final List<String> f514789a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final ArrayList<String> f514790b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ a f514791c = null;

        public a() {
        }

        static {
            f514791c = new a();
            f514789a = CollectionsKt.mutableListOf(new String[]{"song_list_board_card", "song_list_board_multi_popup_card"});
            f514790b = CollectionsKt.arrayListOf(new String[]{PbRequest.SwitchType.PK, UserProfileEvent.SOURCE_ANCHOR_AVATAR, "audience_linkmic", "anchor_linkmic", "audience_audio"});
        }
    }

    static {
        f514788j2 = a.f514791c;
    }

    void a(vk1.a r100);
}
