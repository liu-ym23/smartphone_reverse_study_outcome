package kec;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u00013Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\t\u0010'\u001a\u00020\u000bHÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003Jw\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\u0010\u001a\u00020\tHÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\tHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u0016\u0010\u000f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u00064"}, d2 = {"Lcom/ss/android/lark/widget/richtext/json/property/MediaPropertyParser$MediaPropertyBean;", "", "key", "", "name", "size", "", "mime", "source", "", "originImage", "Lcom/ss/android/lark/widget/richtext/json/property/MediaPropertyParser$MediaPropertyBean$ImageBean;", "duration", "url", "cryptoToken", "width", "height", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILcom/ss/android/lark/widget/richtext/json/property/MediaPropertyParser$MediaPropertyBean$ImageBean;ILjava/lang/String;Ljava/lang/String;II)V", "getKey", "()Ljava/lang/String;", "getName", "getSize", "()J", "getMime", "getSource", "()I", "getOriginImage", "()Lcom/ss/android/lark/widget/richtext/json/property/MediaPropertyParser$MediaPropertyBean$ImageBean;", "getDuration", "getUrl", "getCryptoToken", "getWidth", "getHeight", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "", "other", "hashCode", "toString", "ImageBean", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("cryptoToken")
    private final String cryptoToken;

    @SerializedName("duration")
    private final int duration;

    @SerializedName("height")
    private final int height;

    @SerializedName("key")
    private final String key;

    @SerializedName("mime")
    private final String mime;

    @SerializedName("name")
    private final String name;

    @SerializedName("originImage")
    private final a originImage;

    @SerializedName("size")
    private final long size;

    @SerializedName("source")
    private final int source;

    @SerializedName("url")
    private final String url;

    @SerializedName("width")
    private final int width;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0007HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\""}, d2 = {"Lcom/ss/android/lark/widget/richtext/json/property/MediaPropertyParser$MediaPropertyBean$ImageBean;", "", "key", "", "urls", "", "width", "", "height", "token", "type", "<init>", "(Ljava/lang/String;Ljava/util/List;IILjava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getUrls", "()Ljava/util/List;", "getWidth", "()I", "getHeight", "getToken", "getType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("height")
        private final int height;

        @SerializedName("key")
        private final String key;

        @SerializedName("token")
        private final String token;

        @SerializedName("type")
        private final int type;

        @SerializedName("urls")
        private final List<String> urls;

        @SerializedName("width")
        private final int width;

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.urls, r101.urls) == true) goto L15;
            return false;
        L15:
            if (this.width == r101.width) goto L18;
            return false;
        L18:
            if (this.height == r101.height) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.token, r101.token) == true) goto L24;
            return false;
        L24:
            if (this.type == r101.type) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.key.hashCode() * 31) + this.urls.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.token.hashCode()) * 31) + this.type;
        }

        public final String toString() {
            return "ImageBean(key=" + this.key + ", urls=" + this.urls + ", width=" + this.width + ", height=" + this.height + ", token=" + this.token + ", type=" + this.type + ')';
        }

        public final int getType() {
            return this.type;
        }

        public a(Object r100) {
            List<String> r101 = CollectionsKt.emptyList();
            Intrinsics.checkNotNullParameter("", "key");
            Intrinsics.checkNotNullParameter(r101, "urls");
            Intrinsics.checkNotNullParameter("", "token");
            this.key = "";
            this.urls = r101;
            this.width = 0;
            this.height = 0;
            this.token = "";
            this.type = 0;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L15;
        return false;
    L15:
        if (this.size == r101.size) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.mime, r101.mime) == true) goto L21;
        return false;
    L21:
        if (this.source == r101.source) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.originImage, r101.originImage) == true) goto L27;
        return false;
    L27:
        if (this.duration == r101.duration) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.cryptoToken, r101.cryptoToken) == true) goto L36;
        return false;
    L36:
        if (this.width == r101.width) goto L39;
        return false;
    L39:
        if (this.height == r101.height) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.key.hashCode() * 31) + this.name.hashCode()) * 31;
        long r101 = this.size;
        return ((((((((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.mime.hashCode()) * 31) + this.source) * 31) + this.originImage.hashCode()) * 31) + this.duration) * 31) + this.url.hashCode()) * 31) + this.cryptoToken.hashCode()) * 31) + this.width) * 31) + this.height;
    }

    public final String toString() {
        return "MediaPropertyBean(key=" + this.key + ", name=" + this.name + ", size=" + this.size + ", mime=" + this.mime + ", source=" + this.source + ", originImage=" + this.originImage + ", duration=" + this.duration + ", url=" + this.url + ", cryptoToken=" + this.cryptoToken + ", width=" + this.width + ", height=" + this.height + ')';
    }

    public d() {
        a r100 = new a(null);
        Intrinsics.checkNotNullParameter("", "key");
        Intrinsics.checkNotNullParameter("", "name");
        Intrinsics.checkNotNullParameter("", "mime");
        Intrinsics.checkNotNullParameter(r100, "originImage");
        Intrinsics.checkNotNullParameter("", "url");
        Intrinsics.checkNotNullParameter("", "cryptoToken");
        this.key = "";
        this.name = "";
        this.size = 0;
        this.mime = "";
        this.source = 0;
        this.originImage = r100;
        this.duration = 0;
        this.url = "";
        this.cryptoToken = "";
        this.width = 0;
        this.height = 0;
    }
}
