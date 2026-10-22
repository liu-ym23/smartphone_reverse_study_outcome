package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.intent.export.entity.input.SendChatInfo;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/OpenLarkIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "sendMessage", "Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "sendChatInfo", "Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;", "msg", "", "<init>", "(Lcom/ss/android/lark/intent/export/entity/output/SendMessage;Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;Ljava/lang/String;)V", "getSendMessage", "()Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "getSendChatInfo", "()Lcom/ss/android/lark/intent/export/entity/input/SendChatInfo;", "getMsg", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenLarkIntentOutput extends CommonSuccessIntentOutput {
    public static final Parcelable.Creator<OpenLarkIntentOutput> CREATOR = null;
    private final String msg;
    private final SendChatInfo sendChatInfo;
    private final SendMessage sendMessage;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<OpenLarkIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OpenLarkIntentOutput createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SendChatInfo r101 = null;
            if (r100.readInt() != 0) goto L5;
            SendMessage r102 = null;
        L6:
            SendMessage r103 = r102;
            if (r100.readInt() == 0) goto L11;
            r101 = SendChatInfo.CREATOR.createFromParcel(r100);
        L11:
            return new OpenLarkIntentOutput(r103, r101, r100.readString());
        L5:
            r102 = SendMessage.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OpenLarkIntentOutput createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OpenLarkIntentOutput[] newArray(int r100) {
            return new OpenLarkIntentOutput[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OpenLarkIntentOutput[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        SendMessage r102 = this.sendMessage;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        SendChatInfo r103 = this.sendChatInfo;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L10:
        r100.writeString(this.msg);
        return;
    L9:
        r100.writeInt(1);
        r103.writeToParcel(r100, r101);
        goto L10
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public final String getMsg() {
        return this.msg;
    }

    public final SendChatInfo getSendChatInfo() {
        return this.sendChatInfo;
    }

    public final SendMessage getSendMessage() {
        return this.sendMessage;
    }

    public OpenLarkIntentOutput(SendMessage r100, SendChatInfo r101, String r102) {
        super(Direction.MAIN_PAGE_MESSAGE, r102);
        this.sendMessage = r100;
        this.sendChatInfo = r101;
        this.msg = r102;
    }

    public /* synthetic */ OpenLarkIntentOutput(SendMessage r100, SendChatInfo r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
