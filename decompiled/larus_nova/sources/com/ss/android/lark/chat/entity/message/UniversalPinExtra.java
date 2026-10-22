package com.ss.android.lark.chat.entity.message;

import com.bytedance.lark.pb.im.v1.ChatPinInfo;
import com.bytedance.lark.pb.im.v1.UniversalChatPin;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0000H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/UniversalPinExtra;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "pinId", "", "pinChatter", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "type", "Lcom/ss/android/lark/chat/entity/message/UniversalPinExtraType;", "<init>", "(Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;Lcom/ss/android/lark/chat/entity/message/UniversalPinExtraType;)V", "getPinId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPinChatter", "()Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "getType", "()Lcom/ss/android/lark/chat/entity/message/UniversalPinExtraType;", "isItemSame", "", "diffable", "isContentSame", "toString", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UniversalPinExtra implements Serializable, b<UniversalPinExtra> {
    public static final a Companion = null;
    private final ChatChatter pinChatter;
    private final Long pinId;
    private final UniversalPinExtraType type;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.chat.entity.message.UniversalPinExtra$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C4858a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f415314a = null;

            static {
                int[] r100 = new int[UniversalChatPin.Type.values().length];
                r100[UniversalChatPin.Type.UNKNOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r100[UniversalChatPin.Type.URL_PIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r100[UniversalChatPin.Type.MESSAGE_PIN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r100[UniversalChatPin.Type.ANNOUNCEMENT_PIN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                f415314a = r100;
            }
        }

        public a() {
        }

        public static UniversalPinExtra a(ChatPinInfo r100, String r101, com.ss.android.lark.chat.entity.chatter.a r102) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            Intrinsics.checkNotNullParameter(r101, "chatId");
            Intrinsics.checkNotNullParameter(r102, "chatChatters");
            ChatChatter r103 = r102.b(r101, r100.chatter_id.toString());
            UniversalChatPin.Type r104 = r100.type;
            if (r104 != null) goto L5;
            int r105 = -1;
        L7:
            if (r105 != 1) goto L9;
        L17:
            return null;
        L9:
            if (r105 == 2) goto L17;
            if (r105 == 3) goto L20;
            if (r105 != 4) goto L17;
            return new AnnouncementUniversalPinExtra(r100.pin_id, r103);
        L20:
            return new MessageUniversalPinExtra(r100.message_id.longValue(), r100.pin_id, r103);
        L5:
            r105 = C4858a.f415314a[r104.ordinal()];
            goto L7
        }
    }

    static {
        Companion = new a();
    }

    public String toString() {
        return "pinChatter=" + this.pinChatter + ", pinId= " + this.pinId;
    }

    public final ChatChatter getPinChatter() {
        return this.pinChatter;
    }

    public final Long getPinId() {
        return this.pinId;
    }

    public final UniversalPinExtraType getType() {
        return this.type;
    }

    public boolean isContentSame(UniversalPinExtra r100) {
        if (this != r100) goto L5;
        return true;
    L5:
        Class<?> r101 = getClass();
        if (r100 == null) goto L8;
        Class<?> r102 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(r101, r102) == true) goto L12;
        return false;
    L12:
        ChatChatter r103 = this.pinChatter;
        if (r103 != null) goto L15;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.pinId, r100.pinId) == true) goto L23;
        return false;
    L23:
        return true;
    L15:
        if (r103.isContentSame(r100.pinChatter) == true) goto L17;
        r104 = true;
        goto L18
    L8:
        r102 = null;
        goto L10
    }

    public boolean isItemSame(UniversalPinExtra r100) {
        Long r101 = this.pinId;
        if (r100 == null) goto L5;
        Long r102 = r100.pinId;
    L7:
        return Intrinsics.areEqual(r101, r102);
    L5:
        r102 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r100) {
        return isContentSame((UniversalPinExtra) r100);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r100) {
        return isItemSame((UniversalPinExtra) r100);
    }

    public UniversalPinExtra(Long r100, ChatChatter r101, UniversalPinExtraType r102) {
        Intrinsics.checkNotNullParameter(r102, "type");
        this.pinId = r100;
        this.pinChatter = r101;
        this.type = r102;
    }

    public /* synthetic */ UniversalPinExtra(Long r100, ChatChatter r101, UniversalPinExtraType r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = UniversalPinExtraType.UNKNOWN;
    L5:
        this(r100, r101, r102);
    }
}
