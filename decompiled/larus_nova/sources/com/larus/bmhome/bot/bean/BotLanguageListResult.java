package com.larus.bmhome.bot.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0006\u0010\f\u001a\u00020\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rR(\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/bot/bean/BotLanguageListResult;", "Landroid/os/Parcelable;", "supportLanguageList", "", "Lcom/larus/bmhome/bot/bean/BotLanguage;", "<init>", "(Ljava/util/List;)V", "getSupportLanguageList", "()Ljava/util/List;", "setSupportLanguageList", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotLanguageListResult implements Parcelable {
    public static final Parcelable.Creator<BotLanguageListResult> CREATOR = null;

    @SerializedName("support_language_list")
    private List<BotLanguage> supportLanguageList;

    public static final class a implements Parcelable.Creator<BotLanguageListResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotLanguageListResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ArrayList r101 = null;
            if (r100.readInt() == 0) goto L14;
            int r102 = r100.readInt();
            ArrayList r103 = new ArrayList(r102);
            int r104 = 0;
        L6:
            if (r104 == r102) goto L12;
            if (r100.readInt() != 0) goto L10;
            BotLanguage r105 = null;
        L11:
            r103.add(r105);
            r104 = r104 + 1;
            goto L6
        L10:
            r105 = BotLanguage.CREATOR.createFromParcel(r100);
            goto L11
        L12:
            r101 = r103;
        L14:
            return new BotLanguageListResult(r101);
        }

        @Override // android.os.Parcelable.Creator
        public final BotLanguageListResult[] newArray(int r100) {
            return new BotLanguageListResult[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotLanguageListResult() {
        this(null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotLanguageListResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.supportLanguageList, ((BotLanguageListResult) r100).supportLanguageList) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        List<BotLanguage> r100 = this.supportLanguageList;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "BotLanguageListResult(supportLanguageList=" + this.supportLanguageList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        List<BotLanguage> r102 = this.supportLanguageList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<BotLanguage> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L19;
        BotLanguage r104 = r103.next();
        if (r104 == null) goto L10;
        r100.writeInt(1);
        r104.writeToParcel(r100, r101);
        goto L7
    L10:
        r100.writeInt(0);
        goto L7
    }

    public BotLanguageListResult(List<BotLanguage> r100) {
        this.supportLanguageList = r100;
    }
}
