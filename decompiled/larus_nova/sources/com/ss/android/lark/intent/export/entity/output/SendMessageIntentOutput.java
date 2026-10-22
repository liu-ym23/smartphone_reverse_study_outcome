package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/SendMessageIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "message", "Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "chat", "Lcom/ss/android/lark/intent/export/entity/output/SendChat;", "<init>", "(Lcom/ss/android/lark/intent/export/entity/output/SendMessage;Lcom/ss/android/lark/intent/export/entity/output/SendChat;)V", "getMessage", "()Lcom/ss/android/lark/intent/export/entity/output/SendMessage;", "getChat", "()Lcom/ss/android/lark/intent/export/entity/output/SendChat;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SendMessageIntentOutput extends CommonSuccessIntentOutput {
    public static final Parcelable.Creator<SendMessageIntentOutput> CREATOR = null;
    private final SendChat chat;
    private final SendMessage message;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SendMessageIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendMessageIntentOutput createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new SendMessageIntentOutput(SendMessage.CREATOR.createFromParcel(r100), SendChat.CREATOR.createFromParcel(r100));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendMessageIntentOutput createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SendMessageIntentOutput[] newArray(int r100) {
            return new SendMessageIntentOutput[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SendMessageIntentOutput[] newArray(int r100) {
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
        this.message.writeToParcel(r100, r101);
        this.chat.writeToParcel(r100, r101);
    }

    public final SendChat getChat() {
        return this.chat;
    }

    public final SendMessage getMessage() {
        return this.message;
    }

    public SendMessageIntentOutput(SendMessage r100, SendChat r101) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "chat");
        super(Direction.SEND_MESSAGE, null, 2, null);
        this.message = r100;
        this.chat = r101;
    }
}
