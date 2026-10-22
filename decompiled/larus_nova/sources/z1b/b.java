package z1b;

import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f569728a = null;

        static {
            int[] r100 = new int[Message.Type.values().length];
            f569728a = r100;
            r100[Message.Type.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            f569728a[Message.Type.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            f569728a[Message.Type.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            f569728a[Message.Type.MEDIA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            f569728a[Message.Type.FILE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            f569728a[Message.Type.STICKER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            f569728a[Message.Type.AUDIO.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            f569728a[Message.Type.LOCATION.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            f569728a[Message.Type.RED_PACKET.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            f569728a[Message.Type.SHARE_GROUP_CHAT.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            f569728a[Message.Type.MERGE_FORWARD.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            f569728a[Message.Type.SHARE_USER_CARD.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static String a(Message.Type r100) {
        switch(a.f569728a[r100.ordinal()]) {
            case 1: goto L28;
            case 2: goto L26;
            case 3: goto L24;
            case 4: goto L22;
            case 5: goto L20;
            case 6: goto L18;
            case 7: goto L16;
            case 8: goto L14;
            case 9: goto L12;
            case 10: goto L10;
            case 11: goto L8;
            case 12: goto L6;
            default: goto L4;
        };
    L4:
        return null;
    L6:
        return "share_user_card";
    L8:
        return ShareChannel.MERGE_FORWARD;
    L10:
        return "share_group";
    L12:
        return "red_packet";
    L14:
        return "location";
    L16:
        return "audio";
    L18:
        return "sticker";
    L20:
        return "file";
    L22:
        return "media";
    L24:
        return "image";
    L26:
        return UGCMonitor.TYPE_POST;
    L28:
        return "text";
    }
}
