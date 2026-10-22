package com.ss.android.lark.biz.im.api.bundle.v2.base.input;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ChatIdLaunchData;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput;", "chatId", "", "<init>", "(Ljava/lang/String;)V", "getChatId", "()Ljava/lang/String;", "type", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput$LaunchDataType;", "isValid", "", "toDesc", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatIdLaunchData implements ILaunchDataInput {
    public static final Parcelable.Creator<ChatIdLaunchData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f409977a;

    public static final class a implements Parcelable.Creator<ChatIdLaunchData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatIdLaunchData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ChatIdLaunchData(r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ChatIdLaunchData[] newArray(int r100) {
            return new ChatIdLaunchData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatIdLaunchData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f409977a, ((ChatIdLaunchData) r100).f409977a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f409977a.hashCode();
    }

    public final String toString() {
        return "ChatIdLaunchData(chatId=" + this.f409977a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f409977a);
    }

    @Override // com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput
    public final boolean isValid() {
        return !TextUtils.isEmpty(this.f409977a);
    }

    @Override // com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput
    public final String x0() {
        StringBuilder r100 = new StringBuilder("chatId: ");
        String r101 = this.f409977a;
        if (StringsKt.isBlank(r101) == false) goto L5;
        r101 = "nil";
    L5:
        r100.append(r101);
        return r100.toString();
    }

    @Override // com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput
    public final ILaunchDataInput.LaunchDataType type() {
        return ILaunchDataInput.LaunchDataType.CHAT_ID;
    }

    public ChatIdLaunchData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "chatId");
        this.f409977a = r100;
    }
}
