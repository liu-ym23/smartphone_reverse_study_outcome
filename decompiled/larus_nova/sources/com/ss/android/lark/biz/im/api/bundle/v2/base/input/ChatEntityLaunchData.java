package com.ss.android.lark.biz.im.api.bundle.v2.base.input;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 \u001e2\u00020\u00012\u00020\u0002:\u0001\u001eB\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0011HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ChatEntityLaunchData;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput;", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "type", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/input/ILaunchDataInput$LaunchDataType;", "writeToParcel", "", "flags", "", "describeContents", "isValid", "", "toDesc", "", "component1", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatEntityLaunchData implements Parcelable, ILaunchDataInput {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chat f409976a;

    public static final class a implements Parcelable.Creator<ChatEntityLaunchData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ChatEntityLaunchData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ChatEntityLaunchData(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ChatEntityLaunchData[] newArray(int r100) {
            return new ChatEntityLaunchData[r100];
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
        if ((r100 instanceof ChatEntityLaunchData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f409976a, ((ChatEntityLaunchData) r100).f409976a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Chat r100 = this.f409976a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "ChatEntityLaunchData(chat=" + this.f409976a + ')';
    }

    @Override // com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput
    public final boolean isValid() {
        Chat r100 = this.f409976a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (TextUtils.isEmpty(r100.getId()) == true) goto L7;
        return true;
    }

    @Override // com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput
    public final String x0() {
        Chat r100 = this.f409976a;
        if (r100 == null) goto L6;
        String r101 = r100.getId();
        if (r101 == null) goto L6;
    L8:
        return "chatId: ".concat(r101);
    L6:
        r101 = "nil";
        goto L8
    }

    @Override // com.ss.android.lark.biz.im.api.bundle.v2.base.input.ILaunchDataInput
    public final ILaunchDataInput.LaunchDataType type() {
        return ILaunchDataInput.LaunchDataType.CHAT;
    }

    public ChatEntityLaunchData(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (Build.VERSION.SDK_INT < 33) goto L5;
        Chat r101 = (Chat) r100.readSerializable(Chat.class.getClassLoader(), Chat.class);
    L6:
        this.f409976a = r101;
        return;
    L5:
        r101 = (Chat) r100.readSerializable();
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeSerializable(this.f409976a);
    }
}
