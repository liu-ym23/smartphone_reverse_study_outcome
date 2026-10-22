package com.ss.android.lark.biz.im.api.bundle.v2.biz.flow;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.biz.im.api.bundle.v2.annotation.BundleKey;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@BundleKey("data_flow_chat_key")
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0016\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0014R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/flow/FlowChatBizData;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/IBundle;", "overrideChatMode", "Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "isEmbedded", "", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;Z)V", "getOverrideChatMode", "()Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "()Z", "putInBundle", "", "bundle", "Landroid/os/Bundle;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowChatBizData implements Parcelable {
    public static final Parcelable.Creator<FlowChatBizData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chat.ChatMode f410049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f410050b;

    public static final class a implements Parcelable.Creator<FlowChatBizData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FlowChatBizData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Chat.ChatMode r101 = null;
        L7:
            if (r100.readInt() == 0) goto L9;
            boolean r102 = true;
        L11:
            return new FlowChatBizData(r101, r102);
        L9:
            r102 = false;
            goto L11
        L5:
            r101 = Chat.ChatMode.valueOf(r100.readString());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FlowChatBizData[] newArray(int r100) {
            return new FlowChatBizData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FlowChatBizData() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FlowChatBizData) == true) goto L8;
        return false;
    L8:
        FlowChatBizData r101 = (FlowChatBizData) r100;
        if (this.f410049a == r101.f410049a) goto L12;
        return false;
    L12:
        if (this.f410050b == r101.f410050b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Chat.ChatMode r100 = this.f410049a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        if (this.f410050b == false) goto L9;
        int r103 = 1231;
    L11:
        return r102 + r103;
    L9:
        r103 = 1237;
        goto L11
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowChatBizData(overrideChatMode=" + this.f410049a + ", isEmbedded=" + this.f410050b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Chat.ChatMode r102 = this.f410049a;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        r100.writeInt(this.f410050b ? 1 : 0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeString(r102.name());
        goto L6
    }

    public /* synthetic */ FlowChatBizData(int r100) {
        this(null, false);
    }

    public FlowChatBizData(Chat.ChatMode r100, boolean r101) {
        this.f410049a = r100;
        this.f410050b = r101;
    }
}
