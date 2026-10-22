package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0004J\u0013\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/bean/ChatUserContextParam;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "type", "", PerfLog.PARAM_KEY_CONTEXT_ID, "", "<init>", "(ILjava/lang/String;)V", "getType", "()I", "getContext", "()Ljava/lang/String;", "isNotEmpty", "", "component1", "component2", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatUserContextParam implements Parcelable, Serializable {
    public static final Parcelable.Creator<ChatUserContextParam> CREATOR = null;
    private final String context;
    private final int type;

    public static final class a implements Parcelable.Creator<ChatUserContextParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatUserContextParam createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ChatUserContextParam(r100.readInt(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ChatUserContextParam[] newArray(int r100) {
            return new ChatUserContextParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public static /* synthetic */ ChatUserContextParam copy$default(ChatUserContextParam r100, int r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.context;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.context;
    }

    public final ChatUserContextParam copy(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new ChatUserContextParam(r100, r101);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatUserContextParam) == true) goto L8;
        return false;
    L8:
        ChatUserContextParam r101 = (ChatUserContextParam) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.context, r101.context) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.type * 31) + this.context.hashCode();
    }

    public String toString() {
        return "ChatUserContextParam(type=" + this.type + ", context=" + this.context + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.type);
        r100.writeString(this.context);
    }

    public final boolean isNotEmpty() {
        if (this.type > 0) goto L5;
        return false;
    L5:
        if (this.context.length() <= 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r100 = false;
        goto L8
    }

    public final String getContext() {
        return this.context;
    }

    public final int getType() {
        return this.type;
    }

    public ChatUserContextParam(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.type = r100;
        this.context = r101;
    }
}
