package com.larus.audio.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0005J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006!"}, d2 = {"Lcom/larus/audio/bean/TtsFeedbackItem;", "Landroid/os/Parcelable;", "feedbackTitle", "", "feedbackType", "", "itemList", "", "Lcom/larus/audio/bean/FeedbackItem;", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "getFeedbackTitle", "()Ljava/lang/String;", "getFeedbackType", "()I", "getItemList", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TtsFeedbackItem implements Parcelable {
    public static final Parcelable.Creator<TtsFeedbackItem> CREATOR = null;

    @SerializedName("feedback_title")
    private final String feedbackTitle;

    @SerializedName("feedback_type")
    private final int feedbackType;

    @SerializedName("item_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<FeedbackItem> itemList;

    public static final class a implements Parcelable.Creator<TtsFeedbackItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TtsFeedbackItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            int r102 = r100.readInt();
            if (r100.readInt() != 0) goto L5;
            ArrayList r103 = null;
        L10:
            return new TtsFeedbackItem(r101, r102, r103);
        L5:
            int r104 = r100.readInt();
            ArrayList r105 = new ArrayList(r104);
            int r106 = 0;
        L6:
            if (r106 == r104) goto L8;
            r105.add(FeedbackItem.CREATOR.createFromParcel(r100));
            r106 = r106 + 1;
            goto L6
        L8:
            r103 = r105;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public final TtsFeedbackItem[] newArray(int r100) {
            return new TtsFeedbackItem[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public TtsFeedbackItem() {
        this(null, 0, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TtsFeedbackItem) == true) goto L8;
        return false;
    L8:
        TtsFeedbackItem r101 = (TtsFeedbackItem) r100;
        if (Intrinsics.areEqual(this.feedbackTitle, r101.feedbackTitle) == true) goto L12;
        return false;
    L12:
        if (this.feedbackType == r101.feedbackType) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.itemList, r101.itemList) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.feedbackTitle;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.feedbackType) * 31;
        List<FeedbackItem> r104 = this.itemList;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "TtsFeedbackItem(feedbackTitle=" + this.feedbackTitle + ", feedbackType=" + this.feedbackType + ", itemList=" + this.itemList + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.feedbackTitle);
        r100.writeInt(this.feedbackType);
        List<FeedbackItem> r102 = this.itemList;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.size());
        Iterator<FeedbackItem> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        r103.next().writeToParcel(r100, r101);
        goto L7
    }

    public final String a() {
        return this.feedbackTitle;
    }

    public final int b() {
        return this.feedbackType;
    }

    public final List<FeedbackItem> c() {
        return this.itemList;
    }

    public TtsFeedbackItem(String r100, int r101, List<FeedbackItem> r102) {
        this.feedbackTitle = r100;
        this.feedbackType = r101;
        this.itemList = r102;
    }
}
