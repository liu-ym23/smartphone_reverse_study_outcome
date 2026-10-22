package p6c;

import com.bytedance.lark.pb.im.v1.ChatTab;
import com.larus.nova.R;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.utils.UIHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class d {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f527973a = null;

        static {
            int[] r100 = new int[ChatTab.Type.values().length];
            r100[ChatTab.Type.Message.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ChatTab.Type.DocSpace.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f527973a = r100;
        }
    }

    static {
    }

    @JvmStatic
    public static final List<com.ss.android.lark.chat.entity.chat.ChatTab> a(String r110, List<ChatTab> r210) {
        Intrinsics.checkNotNullParameter(r110, "chatId");
        Intrinsics.checkNotNullParameter(r210, "pbChatTabs");
        Chat r100 = ChatService.c.f411535a.getLocalChat(r110);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r210.iterator();
    L3:
        boolean r103 = true;
        if (r102.hasNext() == false) goto L43;
        ChatTab r104 = (ChatTab) r102.next();
        Intrinsics.checkNotNullParameter(r104, "pbChatTab");
        ChatTab.Type r105 = r104.type;
        if (r105 != null) goto L8;
        int r106 = -1;
    L9:
        if (r106 != 1) goto L11;
        long r111 = r104.f253635id.longValue();
        int r107 = b.f527969a;
        com.ss.android.lark.chat.entity.chat.ChatTab r108 = new com.ss.android.lark.chat.entity.chat.ChatTab(com.ss.android.lark.chat.entity.chat.ChatTab.MESSAGE_LIST_ID, UIHelper.getString(R.string.Lark_Groups_TabChat), com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.MESSAGE, null, null, r111);
    L42:
        r101.add(r108);
        goto L3
    L11:
        if (r106 == 2) goto L31;
        com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.a r109 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.Companion;
        int r112 = r104.type.getValue();
        r109.getClass();
        switch(r112) {
            case 0: goto L26;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            case 10: goto L16;
            case 11: goto L15;
            default: goto L14;
        };
    L14:
        com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.UNKNOWN;
    L27:
        com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType r114 = r113;
        com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType r115 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.UNKNOWN;
        if (r114 != r115) goto L30;
        long r116 = r104.f253635id.longValue();
        int r117 = b.f527969a;
        r108 = new com.ss.android.lark.chat.entity.chat.ChatTab(r116, UIHelper.getString(R.string.Lark_IM_UnknownType_Tabs), r115, null, null, r116);
        goto L42
    L30:
        r108 = new com.ss.android.lark.chat.entity.chat.ChatTab(r104.f253635id.longValue(), r104.name, r114, r104.payload, r104.payload_json, r104.f253635id.longValue());
        goto L42
    L15:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.IMAGE_VIDEO_MERGE;
        goto L27
    L16:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.DOC_FILE_URL_MERGE;
        goto L27
    L17:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.TASK;
        goto L27
    L18:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.FILE;
        goto L27
    L19:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.URL;
        goto L27
    L20:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.CHAT_ANNOUNCEMENT;
        goto L27
    L21:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.MEETING_MINUTE;
        goto L27
    L22:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.PIN;
        goto L27
    L23:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.DOC;
        goto L27
    L24:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.DOC_SPACE;
        goto L27
    L25:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.MESSAGE;
        goto L27
    L26:
        r113 = com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.UNKNOWN;
        goto L27
    L31:
        long r118 = r104.f253635id.longValue();
        int r119 = b.f527969a;
        if (r100 != null) goto L34;
    L36:
        r103 = false;
    L37:
        if (r103 == false) goto L39;
        String r120 = UIHelper.getString(R.string.Lark_Groups_ChatDocs);
    L40:
        String r121 = r120;
        Intrinsics.checkNotNull(r121);
        r108 = new com.ss.android.lark.chat.entity.chat.ChatTab(com.ss.android.lark.chat.entity.chat.ChatTab.SPACE_LIST_ID, r121, com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.DOC_SPACE, null, null, r118);
        goto L42
    L39:
        r120 = UIHelper.getString(R.string.Lark_Groups_TabDocs);
        goto L40
    L34:
        if (r100.isP2PChat() != true) goto L36;
    L8:
        r106 = a.f527973a[r105.ordinal()];
        goto L9
    L43:
        Intrinsics.checkNotNullParameter(r101, "<this>");
        ArrayList r122 = new ArrayList();
        Iterator r123 = r101.iterator();
    L45:
        if (r123.hasNext() == false) goto L52;
        Object r124 = r123.next();
        if (((com.ss.android.lark.chat.entity.chat.ChatTab) r124).getType() == com.ss.android.lark.chat.entity.chat.ChatTab.ChatTabType.UNKNOWN) goto L49;
        boolean r125 = true;
    L50:
        if (r125 == false) goto L45;
        r122.add(r124);
        goto L45
    L49:
        r125 = false;
        goto L50
    L52:
        return r122;
    }
}
