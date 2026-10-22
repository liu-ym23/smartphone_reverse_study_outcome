package com.larus.bmhome.chat;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010#\u001a\u00020\u0004H\u0016J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\b\u0010'\u001a\u00020(H\u0016J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0004HÆ\u0003Jg\u00101\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u00102\u001a\u00020(J\u0016\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020(R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012¨\u00068"}, d2 = {"Lcom/larus/bmhome/chat/ChatParam;", "Landroid/os/Parcelable;", "Lcom/larus/ui/arch/context/external/VData;", "cvsId", "", "botId", "previousPage", "currentPage", "chatType", "useSubscribedColor", "", "fromActivityName", "fromActivityModule", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getCvsId", "()Ljava/lang/String;", "setCvsId", "(Ljava/lang/String;)V", "getBotId", "setBotId", "getPreviousPage", "setPreviousPage", "getCurrentPage", "setCurrentPage", "getChatType", "setChatType", "getUseSubscribedColor", "()Z", "setUseSubscribedColor", "(Z)V", "getFromActivityName", "setFromActivityName", "getFromActivityModule", "setFromActivityModule", "toString", "equals", "other", "", "hashCode", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatParam implements Parcelable, t1a.c {
    public static final Parcelable.Creator<ChatParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f296889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f296890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f296891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f296892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f296893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f296894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f296895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f296896h;

    public static final class a implements Parcelable.Creator<ChatParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatParam createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            String r101 = r110.readString();
            String r102 = r110.readString();
            String r103 = r110.readString();
            String r104 = r110.readString();
            if (r110.readInt() == 0) goto L5;
            boolean r105 = true;
        L7:
            return new ChatParam(r100, r101, r102, r103, r104, r105, r110.readString(), r110.readString());
        L5:
            r105 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ChatParam[] newArray(int r100) {
            return new ChatParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ChatParam() {
        this(null, null, null, null, null, 255);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f296889a);
        r100.writeString(this.f296890b);
        r100.writeString(this.f296891c);
        r100.writeString(this.f296892d);
        r100.writeString(this.f296893e);
        r100.writeInt(this.f296894f ? 1 : 0);
        r100.writeString(this.f296895g);
        r100.writeString(this.f296896h);
    }

    public final String toString() {
        return "cvsId=" + this.f296889a + ",botId=" + this.f296890b + ",previousPage=" + this.f296891c + ",currentPage=" + this.f296892d;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof ChatParam) == true) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(toString(), ((ChatParam) r100).toString());
    }

    public static ChatParam a(ChatParam r100, String r110, String r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        r110 = r100.f296889a;
    L5:
        String r101 = r110;
        if ((r113 & 2) == 0) goto L8;
        r111 = r100.f296890b;
    L8:
        String r102 = r111;
        if ((r113 & 4) == 0) goto L11;
        String r103 = r100.f296891c;
    L13:
        if ((r113 & 8) == 0) goto L15;
        String r104 = r100.f296892d;
    L17:
        if ((r113 & 16) == 0) goto L19;
        r112 = r100.f296893e;
    L19:
        String r105 = r112;
        if ((r113 & 32) == 0) goto L22;
        boolean r106 = r100.f296894f;
    L24:
        if ((r113 & 64) == 0) goto L26;
        String r107 = r100.f296895g;
    L28:
        if ((r113 & 128) == 0) goto L30;
        String r108 = r100.f296896h;
    L32:
        return new ChatParam(r101, r102, r103, r104, r105, r106, r107, r108);
    L30:
        r108 = null;
        goto L32
    L26:
        r107 = null;
        goto L28
    L22:
        r106 = false;
        goto L24
    L15:
        r104 = null;
        goto L17
    L11:
        r103 = null;
        goto L13
    }

    public /* synthetic */ ChatParam(String r110, String r111, String r112, String r113, String r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r115 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r115 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r115 & 16) == 0) goto L21;
        String r104 = null;
    L22:
        this(r100, r101, r102, r103, r104, false, null, null);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public ChatParam(String r100, String r101, String r102, String r103, String r104, boolean r105, String r106, String r107) {
        this.f296889a = r100;
        this.f296890b = r101;
        this.f296891c = r102;
        this.f296892d = r103;
        this.f296893e = r104;
        this.f296894f = r105;
        this.f296895g = r106;
        this.f296896h = r107;
    }
}
