package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BC\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0003j\b\u0012\u0004\u0012\u00020\u0007`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/SearchContactIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "sendChat", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/intent/export/entity/output/SendChat;", "Lkotlin/collections/ArrayList;", "sendChatter", "Lcom/ss/android/lark/intent/export/entity/output/SendChatter;", "msg", "", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;)V", "getSendChat", "()Ljava/util/ArrayList;", "getSendChatter", "getMsg", "()Ljava/lang/String;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchContactIntentOutput extends CommonSuccessIntentOutput {
    public static final Parcelable.Creator<SearchContactIntentOutput> CREATOR = null;
    private final String msg;
    private final ArrayList<SendChat> sendChat;
    private final ArrayList<SendChatter> sendChatter;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SearchContactIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SearchContactIntentOutput createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            int r101 = r100.readInt();
            ArrayList r102 = new ArrayList(r101);
            int r103 = 0;
            int r104 = 0;
        L3:
            if (r104 == r101) goto L5;
            r102.add(SendChat.CREATOR.createFromParcel(r100));
            r104 = r104 + 1;
            goto L3
        L5:
            int r105 = r100.readInt();
            ArrayList r106 = new ArrayList(r105);
        L6:
            if (r103 == r105) goto L9;
            r106.add(SendChatter.CREATOR.createFromParcel(r100));
            r103 = r103 + 1;
            goto L6
        L9:
            return new SearchContactIntentOutput(r102, r106, r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchContactIntentOutput createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SearchContactIntentOutput[] newArray(int r100) {
            return new SearchContactIntentOutput[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SearchContactIntentOutput[] newArray(int r100) {
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
        ArrayList<SendChat> r102 = this.sendChat;
        r100.writeInt(r102.size());
        Iterator<SendChat> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().writeToParcel(r100, r101);
        goto L4
    L6:
        ArrayList<SendChatter> r104 = this.sendChatter;
        r100.writeInt(r104.size());
        Iterator<SendChatter> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        r105.next().writeToParcel(r100, r101);
        goto L8
    L10:
        r100.writeString(this.msg);
    }

    public final String getMsg() {
        return this.msg;
    }

    public final ArrayList<SendChat> getSendChat() {
        return this.sendChat;
    }

    public final ArrayList<SendChatter> getSendChatter() {
        return this.sendChatter;
    }

    public SearchContactIntentOutput(ArrayList<SendChat> r100, ArrayList<SendChatter> r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "sendChat");
        Intrinsics.checkNotNullParameter(r101, "sendChatter");
        super(Direction.CALLBACK_SEARCH_CONTACT, r102);
        this.sendChat = r100;
        this.sendChatter = r101;
        this.msg = r102;
    }

    public /* synthetic */ SearchContactIntentOutput(ArrayList r100, ArrayList r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
