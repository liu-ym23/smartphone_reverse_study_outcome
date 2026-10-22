package com.ss.android.lark.biz.im.api.bundle.v2.biz.ai;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.biz.im.api.bundle.ChatAIBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.annotation.BundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@BundleKey("data_ai_key")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001f\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0016\u001a\u00020\u0004J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0016\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/ai/AIBizData;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/IBundle;", "aiChatType", "", "aiBundle", "Lcom/ss/android/lark/biz/im/api/bundle/ChatAIBundle;", "<init>", "(ILcom/ss/android/lark/biz/im/api/bundle/ChatAIBundle;)V", "getAiChatType", "()I", "setAiChatType", "(I)V", "getAiBundle", "()Lcom/ss/android/lark/biz/im/api/bundle/ChatAIBundle;", "putInBundle", "", "bundle", "Landroid/os/Bundle;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIBizData implements Parcelable {
    public static final Parcelable.Creator<AIBizData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f410029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ChatAIBundle f410030b;

    public static final class a implements Parcelable.Creator<AIBizData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AIBizData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            if (r100.readInt() != 0) goto L5;
            ChatAIBundle r102 = null;
        L7:
            return new AIBizData(r101, r102);
        L5:
            r102 = ChatAIBundle.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final AIBizData[] newArray(int r100) {
            return new AIBizData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public AIBizData() {
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
        if ((r100 instanceof AIBizData) == true) goto L8;
        return false;
    L8:
        AIBizData r101 = (AIBizData) r100;
        if (this.f410029a == r101.f410029a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f410030b, r101.f410030b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f410029a * 31;
        ChatAIBundle r101 = this.f410030b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "AIBizData(aiChatType=" + this.f410029a + ", aiBundle=" + this.f410030b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f410029a);
        ChatAIBundle r102 = this.f410030b;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
    }

    public /* synthetic */ AIBizData(int r100) {
        this(0, null);
    }

    public AIBizData(int r100, ChatAIBundle r101) {
        this.f410029a = r100;
        this.f410030b = r101;
    }
}
