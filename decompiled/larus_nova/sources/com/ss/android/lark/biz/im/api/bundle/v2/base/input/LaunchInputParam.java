package com.ss.android.lark.biz.im.api.bundle.v2.base.input;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001:\u0001%B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0013\u0010\u001b\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011¨\u0006&"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/LaunchInputParam;", "Landroid/os/Parcelable;", "chatId", "", "chatterId", "chatMode", "Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "isSecret", "", "isChatMember", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;ZZ)V", "getChatId", "()Ljava/lang/String;", "getChatterId", "getChatMode", "()Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "()Z", "isValid", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Builder", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LaunchInputParam implements Parcelable {
    public static final Parcelable.Creator<LaunchInputParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Chat.ChatMode f409984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f409985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f409986e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f409987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Chat.ChatMode f409988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f409989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f409990d;

        public a(String r100) {
            this.f409988b = Chat.ChatMode.UNKNOWN;
            this.f409990d = true;
        }
    }

    public static final class b implements Parcelable.Creator<LaunchInputParam> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final LaunchInputParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            Chat.ChatMode r103 = Chat.ChatMode.valueOf(r100.readString());
            boolean r104 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r105 = true;
        L7:
            if (r100.readInt() == 0) goto L10;
            r104 = true;
        L10:
            return new LaunchInputParam(r101, r102, r103, r105, r104);
        L5:
            r105 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final LaunchInputParam[] newArray(int r100) {
            return new LaunchInputParam[r100];
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
        if ((r100 instanceof LaunchInputParam) == true) goto L8;
        return false;
    L8:
        LaunchInputParam r101 = (LaunchInputParam) r100;
        if (Intrinsics.areEqual(this.f409982a, r101.f409982a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409983b, r101.f409983b) == true) goto L15;
        return false;
    L15:
        if (this.f409984c == r101.f409984c) goto L18;
        return false;
    L18:
        if (this.f409985d == r101.f409985d) goto L21;
        return false;
    L21:
        if (this.f409986e == r101.f409986e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f409982a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f409983b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (((r103 + r101) * 31) + this.f409984c.hashCode()) * 31;
        int r106 = 1231;
        if (this.f409985d == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.f409986e == true) goto L19;
        r106 = 1237;
    L19:
        return r108 + r106;
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "LaunchInputParam(chatId=" + this.f409982a + ", chatterId=" + this.f409983b + ", chatMode=" + this.f409984c + ", isSecret=" + this.f409985d + ", isChatMember=" + this.f409986e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f409982a);
        r100.writeString(this.f409983b);
        r100.writeString(this.f409984c.name());
        r100.writeInt(this.f409985d ? 1 : 0);
        r100.writeInt(this.f409986e ? 1 : 0);
    }

    public LaunchInputParam(String r100, String r101, Chat.ChatMode r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r102, "chatMode");
        this.f409982a = r100;
        this.f409983b = r101;
        this.f409984c = r102;
        this.f409985d = r103;
        this.f409986e = r104;
    }
}
