package com.larus.bmhome.chat.search;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.video.Content;
import com.larus.im.bean.message.SearchImageInfo;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0004/012BC\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u000bHÆ\u0003JE\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020.HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00063"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchResult;", "", "videoCard", "Lcom/larus/bmhome/chat/search/SearchResult$VideoCard;", "textCard", "Lcom/larus/bmhome/chat/search/SearchResult$TextCard;", "imageCard", "Lcom/larus/bmhome/chat/search/SearchResult$ImageCard;", "mixedMediaCard", "Lcom/larus/bmhome/chat/search/SearchResult$MixedMediaCard;", "cardParam", "Lcom/larus/bmhome/chat/search/CardParam;", "<init>", "(Lcom/larus/bmhome/chat/search/SearchResult$VideoCard;Lcom/larus/bmhome/chat/search/SearchResult$TextCard;Lcom/larus/bmhome/chat/search/SearchResult$ImageCard;Lcom/larus/bmhome/chat/search/SearchResult$MixedMediaCard;Lcom/larus/bmhome/chat/search/CardParam;)V", "getVideoCard", "()Lcom/larus/bmhome/chat/search/SearchResult$VideoCard;", "setVideoCard", "(Lcom/larus/bmhome/chat/search/SearchResult$VideoCard;)V", "getTextCard", "()Lcom/larus/bmhome/chat/search/SearchResult$TextCard;", "setTextCard", "(Lcom/larus/bmhome/chat/search/SearchResult$TextCard;)V", "getImageCard", "()Lcom/larus/bmhome/chat/search/SearchResult$ImageCard;", "setImageCard", "(Lcom/larus/bmhome/chat/search/SearchResult$ImageCard;)V", "getMixedMediaCard", "()Lcom/larus/bmhome/chat/search/SearchResult$MixedMediaCard;", "setMixedMediaCard", "(Lcom/larus/bmhome/chat/search/SearchResult$MixedMediaCard;)V", "getCardParam", "()Lcom/larus/bmhome/chat/search/CardParam;", "setCardParam", "(Lcom/larus/bmhome/chat/search/CardParam;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "VideoCard", "TextCard", "ImageCard", "MixedMediaCard", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("card_params")
    private oi8.c cardParam;

    @SerializedName("image_card")
    private a imageCard;

    @SerializedName("mixed_media_card")
    private C4070b mixedMediaCard;

    @SerializedName("text_card")
    private c textCard;

    @SerializedName("video_card")
    private d videoCard;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchResult$ImageCard;", "", "cardList", "", "Lcom/larus/im/bean/message/SearchImageInfo;", "<init>", "(Ljava/util/List;)V", "getCardList", "()Ljava/util/List;", "setCardList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("card_list")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<SearchImageInfo> cardList;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.cardList, ((a) r100).cardList) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<SearchImageInfo> r100 = this.cardList;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ImageCard(cardList=" + this.cardList + ')';
        }

        public a() {
            this.cardList = null;
        }

        public final List<SearchImageInfo> a() {
            return this.cardList;
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.chat.search.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchResult$MixedMediaCard;", "", "cardList", "", "Lcom/larus/bmhome/video/Content;", "<init>", "(Ljava/util/List;)V", "getCardList", "()Ljava/util/List;", "setCardList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C4070b {

        @SerializedName("card_list")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<Content> cardList;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4070b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.cardList, ((C4070b) r100).cardList) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<Content> r100 = this.cardList;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "MixedMediaCard(cardList=" + this.cardList + ')';
        }

        public C4070b() {
            this.cardList = null;
        }

        public final List<Content> a() {
            return this.cardList;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchResult$TextCard;", "", "cardList", "", "Lcom/larus/bmhome/chat/search/ArticleInfo;", "<init>", "(Ljava/util/List;)V", "getCardList", "()Ljava/util/List;", "setCardList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        @SerializedName("card_list")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<ArticleInfo> cardList;

        public c() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.cardList, ((c) r100).cardList) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<ArticleInfo> r100 = this.cardList;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "TextCard(cardList=" + this.cardList + ')';
        }

        public final List<ArticleInfo> a() {
            return this.cardList;
        }

        public c(List<ArticleInfo> r100) {
            this.cardList = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\u000b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R&\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchResult$VideoCard;", "", "cardList", "", "Lcom/larus/bmhome/chat/search/VideoInfo;", "<init>", "(Ljava/util/List;)V", "getCardList", "()Ljava/util/List;", "setCardList", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d {

        @SerializedName("card_list")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private List<VideoInfo> cardList;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.cardList, ((d) r100).cardList) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<VideoInfo> r100 = this.cardList;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "VideoCard(cardList=" + this.cardList + ')';
        }

        public d() {
            this.cardList = null;
        }

        public final List<VideoInfo> a() {
            return this.cardList;
        }
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.videoCard, r101.videoCard) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textCard, r101.textCard) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageCard, r101.imageCard) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mixedMediaCard, r101.mixedMediaCard) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.cardParam, r101.cardParam) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        d r100 = this.videoCard;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c r104 = this.textCard;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        a r107 = this.imageCard;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        C4070b r110 = this.mixedMediaCard;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        oi8.c r113 = this.cardParam;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchResult(videoCard=" + this.videoCard + ", textCard=" + this.textCard + ", imageCard=" + this.imageCard + ", mixedMediaCard=" + this.mixedMediaCard + ", cardParam=" + this.cardParam + ')';
    }

    public final oi8.c b() {
        return this.cardParam;
    }

    public final a c() {
        return this.imageCard;
    }

    public final C4070b d() {
        return this.mixedMediaCard;
    }

    public final c e() {
        return this.textCard;
    }

    public final d f() {
        return this.videoCard;
    }

    public /* synthetic */ b(int r100) {
        this(null, null, null, null, null);
    }

    public final void g(oi8.c r100) {
        this.cardParam = r100;
    }

    public static b a(b r100, c r101, int r110) {
        oi8.c r102 = null;
        if ((r110 & 1) == 0) goto L5;
        d r103 = r100.videoCard;
    L7:
        if ((r110 & 2) == 0) goto L9;
        r101 = r100.textCard;
    L9:
        c r104 = r101;
        if ((r110 & 4) == 0) goto L12;
        a r105 = r100.imageCard;
    L14:
        if ((r110 & 8) == 0) goto L16;
        C4070b r106 = r100.mixedMediaCard;
    L18:
        if ((r110 & 16) == 0) goto L21;
        r102 = r100.cardParam;
    L21:
        return new b(r103, r104, r105, r106, r102);
    L16:
        r106 = null;
        goto L18
    L12:
        r105 = null;
        goto L14
    L5:
        r103 = null;
        goto L7
    }

    public b(d r100, c r101, a r102, C4070b r103, oi8.c r104) {
        this.videoCard = r100;
        this.textCard = r101;
        this.imageCard = r102;
        this.mixedMediaCard = r103;
        this.cardParam = r104;
    }
}
