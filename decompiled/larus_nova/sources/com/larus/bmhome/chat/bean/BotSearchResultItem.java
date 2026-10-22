package com.larus.bmhome.chat.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001J\u0016\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001cR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006)"}, d2 = {"Lcom/larus/bmhome/chat/bean/BotSearchResultItem;", "Landroid/os/Parcelable;", "bot", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "highlightInfos", "", "Lcom/larus/bmhome/chat/bean/SearchHighlightInfo;", "title", "", "<init>", "(Lcom/larus/bmhome/chat/bean/RecommendBot;Ljava/util/List;Ljava/lang/CharSequence;)V", "getBot", "()Lcom/larus/bmhome/chat/bean/RecommendBot;", "setBot", "(Lcom/larus/bmhome/chat/bean/RecommendBot;)V", "getHighlightInfos", "()Ljava/util/List;", "setHighlightInfos", "(Ljava/util/List;)V", "getTitle", "()Ljava/lang/CharSequence;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/CharSequence;)V", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotSearchResultItem implements Parcelable {
    public static final Parcelable.Creator<BotSearchResultItem> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f297403a;

    @SerializedName("bot_info")
    private RecommendBot bot;

    @SerializedName("search_high_light_infos")
    private List<SearchHighlightInfo> highlightInfos;

    public static final class a implements Parcelable.Creator<BotSearchResultItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotSearchResultItem createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ArrayList r101 = null;
            if (r100.readInt() != 0) goto L5;
            RecommendBot r102 = null;
        L6:
            RecommendBot r103 = r102;
            if (r100.readInt() == 0) goto L18;
            int r104 = r100.readInt();
            ArrayList r105 = new ArrayList(r104);
            int r106 = 0;
        L10:
            if (r106 == r104) goto L16;
            if (r100.readInt() != 0) goto L14;
            SearchHighlightInfo r107 = null;
        L15:
            r105.add(r107);
            r106 = r106 + 1;
            goto L10
        L14:
            r107 = SearchHighlightInfo.CREATOR.createFromParcel(r100);
            goto L15
        L16:
            r101 = r105;
        L18:
            return new BotSearchResultItem(r103, r101, (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r100));
        L5:
            r102 = RecommendBot.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final BotSearchResultItem[] newArray(int r100) {
            return new BotSearchResultItem[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotSearchResultItem() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotSearchResultItem) == true) goto L8;
        return false;
    L8:
        BotSearchResultItem r101 = (BotSearchResultItem) r100;
        if (Intrinsics.areEqual(this.bot, r101.bot) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.highlightInfos, r101.highlightInfos) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f297403a, r101.f297403a) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        RecommendBot r100 = this.bot;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<SearchHighlightInfo> r104 = this.highlightInfos;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        CharSequence r107 = this.f297403a;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotSearchResultItem(bot=" + this.bot + ", highlightInfos=" + this.highlightInfos + ", title=" + this.f297403a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        RecommendBot r102 = this.bot;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        List<SearchHighlightInfo> r103 = this.highlightInfos;
        if (r103 != null) goto L9;
        r100.writeInt(0);
    L16:
        TextUtils.writeToParcel(this.f297403a, r100, r101);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<SearchHighlightInfo> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L16;
        SearchHighlightInfo r105 = r104.next();
        if (r105 == null) goto L14;
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        goto L11
    L14:
        r100.writeInt(0);
        goto L11
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public BotSearchResultItem(RecommendBot r100, List<SearchHighlightInfo> r101, CharSequence r102) {
        this.bot = r100;
        this.highlightInfos = r101;
        this.f297403a = r102;
    }
}
