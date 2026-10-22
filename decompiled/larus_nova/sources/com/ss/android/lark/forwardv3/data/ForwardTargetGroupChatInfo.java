package com.ss.android.lark.forwardv3.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatDisplayModeSetting;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0002+,B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0006\u0010%\u001a\u00020\u001bJ\u0006\u0010&\u001a\u00020\u001bJ\u0018\u0010'\u001a\u00020(2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\bH\u0016J\b\u0010*\u001a\u00020\bH\u0016R$\u0010\u0007\u001a\u00020\b8\u0016@\u0016X\u0097\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006-"}, d2 = {"Lcom/ss/android/lark/forwardv3/data/ForwardTargetGroupChatInfo;", "Lcom/ss/android/lark/forwardv3/data/ForwardTargetBaseInfoNew;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "chatMode", "Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "getChatMode", "()Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "setChatMode", "(Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;)V", "chatDisplayModeSetting", "Lcom/ss/android/lark/chat/entity/chat/ChatDisplayModeSetting;", "getChatDisplayModeSetting", "()Lcom/ss/android/lark/chat/entity/chat/ChatDisplayModeSetting;", "setChatDisplayModeSetting", "(Lcom/ss/android/lark/chat/entity/chat/ChatDisplayModeSetting;)V", "isShield", "", "()Z", "setShield", "(Z)V", "chatId", "", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "isThreadGroup", "isChatDisplayModeSetting", "writeToParcel", "", "flags", "describeContents", "Builder", "CREATOR", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForwardTargetGroupChatInfo extends ForwardTargetBaseInfoNew {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f425280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Chat.ChatMode f425281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ChatDisplayModeSetting f425282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f425283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f425284j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Chat.ChatMode f425285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ChatDisplayModeSetting f425286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f425287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f425288d;

        public a() {
            this.f425285a = Chat.ChatMode.UNKNOWN;
            this.f425286b = ChatDisplayModeSetting.UNKNOWN;
            this.f425288d = "";
        }
    }

    public static final class b implements Parcelable.Creator<ForwardTargetGroupChatInfo> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetGroupChatInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForwardTargetGroupChatInfo r101 = new ForwardTargetGroupChatInfo();
            r101.a(r100);
            r101.f425281g = Chat.ChatMode.forNumber(r100.readInt());
            ChatDisplayModeSetting.a r102 = ChatDisplayModeSetting.Companion;
            int r103 = r100.readInt();
            r102.getClass();
            r101.f425282h = ChatDisplayModeSetting.a.a(r103);
            if (r100.readByte() == 0) goto L5;
            boolean r104 = true;
        L6:
            r101.f425283i = r104;
            String r105 = r100.readString();
            if (r105 != null) goto L9;
            r105 = "";
        L9:
            r101.f425284j = r105;
            return r101;
        L5:
            r104 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ForwardTargetGroupChatInfo[] newArray(int r100) {
            return new ForwardTargetGroupChatInfo[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForwardTargetGroupChatInfo() {
        this.f425280f = 1;
        this.f425281g = Chat.ChatMode.UNKNOWN;
        this.f425282h = ChatDisplayModeSetting.UNKNOWN;
        this.f425284j = "";
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew
    public int getType() {
        return this.f425280f;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew
    public final void b(int r100) {
        this.f425280f = r100;
    }

    @Override // com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeInt(this.f425281g.getNumber());
        r100.writeInt(this.f425282h.getNumber());
        r100.writeByte(this.f425283i ? 1 : 0);
        r100.writeString(this.f425284j);
    }
}
