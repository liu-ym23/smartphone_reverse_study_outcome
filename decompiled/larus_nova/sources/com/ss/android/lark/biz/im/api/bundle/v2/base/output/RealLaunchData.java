package com.ss.android.lark.biz.im.api.bundle.v2.base.output;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001:\u0002$%B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0018HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006&"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/base/output/RealLaunchData;", "Landroid/os/Parcelable;", "chatId", "", "chatterId", "direction", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/output/RealLaunchData$ChatDirection;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/biz/im/api/bundle/v2/base/output/RealLaunchData$ChatDirection;)V", "getChatId", "()Ljava/lang/String;", "setChatId", "(Ljava/lang/String;)V", "getChatterId", "setChatterId", "getDirection", "()Lcom/ss/android/lark/biz/im/api/bundle/v2/base/output/RealLaunchData$ChatDirection;", "setDirection", "(Lcom/ss/android/lark/biz/im/api/bundle/v2/base/output/RealLaunchData$ChatDirection;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "ChatDirection", "Builder", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealLaunchData implements Parcelable {
    public static final Parcelable.Creator<RealLaunchData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f410012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f410013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ChatDirection f410014c;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/base/output/RealLaunchData$ChatDirection;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT", "THREAD", "MY_AI", "GROUP_PROFILE", "NEXUS_BOT", "FLOW_CHAT", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatDirection extends Enum<ChatDirection> {
        public static final ChatDirection CHAT = null;
        public static final ChatDirection FLOW_CHAT = null;
        public static final ChatDirection GROUP_PROFILE = null;
        public static final ChatDirection MY_AI = null;
        public static final ChatDirection NEXUS_BOT = null;
        public static final ChatDirection THREAD = null;
        public static final ChatDirection UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatDirection[] f410015a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f410016b = null;
        private final int value;

        public static EnumEntries<ChatDirection> getEntries() {
            return f410016b;
        }

        static {
            ChatDirection r100 = new ChatDirection("UNKNOWN", 0, -1);
            UNKNOWN = r100;
            ChatDirection r101 = new ChatDirection("CHAT", 1, 1);
            CHAT = r101;
            ChatDirection r102 = new ChatDirection("THREAD", 2, 2);
            THREAD = r102;
            ChatDirection r103 = new ChatDirection("MY_AI", 3, 3);
            MY_AI = r103;
            ChatDirection r104 = new ChatDirection("GROUP_PROFILE", 4, 4);
            GROUP_PROFILE = r104;
            ChatDirection r105 = new ChatDirection("NEXUS_BOT", 5, 5);
            NEXUS_BOT = r105;
            ChatDirection r110 = new ChatDirection("FLOW_CHAT", 6, 6);
            FLOW_CHAT = r110;
            ChatDirection[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f410015a = r111;
            f410016b = EnumEntriesKt.enumEntries(r111);
        }

        public static ChatDirection[] values() {
            return (ChatDirection[]) f410015a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static ChatDirection valueOf(String r100) {
            return (ChatDirection) r27.a.a(ChatDirection.class, r100);
        }

        public ChatDirection(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<RealLaunchData> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final RealLaunchData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new RealLaunchData(r100.readString(), r100.readString(), ChatDirection.valueOf(r100.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final RealLaunchData[] newArray(int r100) {
            return new RealLaunchData[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RealLaunchData) == true) goto L8;
        return false;
    L8:
        RealLaunchData r101 = (RealLaunchData) r100;
        if (Intrinsics.areEqual(this.f410012a, r101.f410012a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410013b, r101.f410013b) == true) goto L15;
        return false;
    L15:
        if (this.f410014c == r101.f410014c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f410012a.hashCode() * 31;
        String r101 = this.f410013b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f410014c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "RealLaunchData(chatId=" + this.f410012a + ", chatterId=" + this.f410013b + ", direction=" + this.f410014c + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f410012a);
        r100.writeString(this.f410013b);
        r100.writeString(this.f410014c.name());
    }

    public RealLaunchData(String r100, String r101, ChatDirection r102) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        Intrinsics.checkNotNullParameter(r102, "direction");
        this.f410012a = r100;
        this.f410013b = r101;
        this.f410014c = r102;
    }
}
