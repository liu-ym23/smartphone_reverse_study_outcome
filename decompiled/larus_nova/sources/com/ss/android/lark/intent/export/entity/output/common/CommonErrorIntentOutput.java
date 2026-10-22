package com.ss.android.lark.intent.export.entity.output.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.intent.export.entity.output.Direction;
import com.ss.android.lark.intent.export.entity.output.IntentOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BY\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012$\b\u0002\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0017\u001a\u00020\u0004J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R-\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000bj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/common/CommonErrorIntentOutput;", "Lcom/ss/android/lark/intent/export/entity/output/IntentOutput;", "Landroid/os/Parcelable;", "errorCode", "", "isObricError", "", "errorMsg", "", "displayErrorMsg", "extra", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(IZLjava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "getErrorCode", "()I", "()Z", "getErrorMsg", "()Ljava/lang/String;", "getDisplayErrorMsg", "getExtra", "()Ljava/util/HashMap;", "describeContents", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonErrorIntentOutput extends IntentOutput {
    public static final Parcelable.Creator<CommonErrorIntentOutput> CREATOR = null;
    private final String displayErrorMsg;
    private final int errorCode;
    private final String errorMsg;
    private final HashMap<String, String> extra;
    private final boolean isObricError;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommonErrorIntentOutput> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonErrorIntentOutput createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            int r100 = r110.readInt();
            int r101 = 0;
            if (r110.readInt() == 0) goto L5;
            boolean r102 = true;
        L6:
            String r103 = r110.readString();
            String r104 = r110.readString();
            int r105 = r110.readInt();
            HashMap r106 = new HashMap(r105);
        L7:
            if (r101 == r105) goto L10;
            r106.put(r110.readString(), r110.readString());
            r101 = r101 + 1;
            goto L7
        L10:
            return new CommonErrorIntentOutput(r100, r102, r103, r104, r106);
        L5:
            r102 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonErrorIntentOutput createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CommonErrorIntentOutput[] newArray(int r100) {
            return new CommonErrorIntentOutput[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CommonErrorIntentOutput[] newArray(int r100) {
            return newArray(r100);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public CommonErrorIntentOutput() {
        this(0, false, null, null, null, 31, null);
    }

    @Override // com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.errorCode);
        r100.writeInt(this.isObricError ? 1 : 0);
        r100.writeString(this.errorMsg);
        r100.writeString(this.displayErrorMsg);
        HashMap<String, String> r102 = this.extra;
        r100.writeInt(r102.size());
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry<String, String> r104 = r103.next();
        r100.writeString(r104.getKey());
        r100.writeString(r104.getValue());
        goto L4
    }

    public final String getDisplayErrorMsg() {
        return this.displayErrorMsg;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final HashMap<String, String> getExtra() {
        return this.extra;
    }

    public final boolean isObricError() {
        return this.isObricError;
    }

    public CommonErrorIntentOutput(int r100, boolean r101, String r102, String r103, HashMap<String, String> r104) {
        Intrinsics.checkNotNullParameter(r104, "extra");
        super(Direction.ERROR);
        this.errorCode = r100;
        this.isObricError = r101;
        this.errorMsg = r102;
        this.displayErrorMsg = r103;
        this.extra = r104;
    }

    public /* synthetic */ CommonErrorIntentOutput(int r100, boolean r101, String r102, String r103, HashMap r104, int r105, DefaultConstructorMarker r110) {
        if ((r105 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r105 & 2) == 0) goto L8;
        boolean r111 = false;
    L9:
        String r106 = null;
        if ((r105 & 4) == 0) goto L12;
        String r107 = null;
    L14:
        if ((r105 & 8) != 0) goto L18;
        r106 = r103;
    L18:
        if ((r105 & 16) == 0) goto L20;
        r104 = new HashMap();
    L20:
        this(r100, r111, r107, r106, r104);
        return;
    L12:
        r107 = r102;
        goto L14
    L8:
        r111 = r101;
        goto L9
    }
}
