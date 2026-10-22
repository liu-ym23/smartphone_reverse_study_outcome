package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0003J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0003R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/bean/BotAction;", "Landroid/os/Parcelable;", ReportConstant.COMMON_ACTION_TYPE, "", "actionPath", "", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getActionType", "()Ljava/lang/Integer;", "setActionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getActionPath", "()Ljava/lang/String;", "setActionPath", "(Ljava/lang/String;)V", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/bmhome/chat/bean/BotAction;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotAction implements Parcelable {
    public static final Parcelable.Creator<BotAction> CREATOR = null;

    @SerializedName("action_path")
    private String actionPath;

    @SerializedName("action_type")
    private Integer actionType;

    public static final class a implements Parcelable.Creator<BotAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotAction createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() != 0) goto L5;
            Integer r101 = null;
        L7:
            return new BotAction(r101, r100.readString());
        L5:
            r101 = Integer.valueOf(r100.readInt());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BotAction[] newArray(int r100) {
            return new BotAction[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotAction() {
        this(null, 3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotAction) == true) goto L8;
        return false;
    L8:
        BotAction r101 = (BotAction) r100;
        if (Intrinsics.areEqual(this.actionType, r101.actionType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.actionPath, r101.actionPath) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.actionType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.actionPath;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotAction(actionType=" + this.actionType + ", actionPath=" + this.actionPath + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Integer r102 = this.actionType;
        if (r102 != null) goto L5;
        int r103 = 0;
    L6:
        r100.writeInt(r103);
        r100.writeString(this.actionPath);
        return;
    L5:
        r100.writeInt(1);
        r103 = r102.intValue();
        goto L6
    }

    public final Integer a() {
        return this.actionType;
    }

    public /* synthetic */ BotAction(Integer r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r101 & 2) == 0) goto L8;
        String r102 = "";
    L9:
        this(r100, r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public BotAction(Integer r100, String r101) {
        this.actionType = r100;
        this.actionPath = r101;
    }
}
