package he3;

import com.amap.api.col.s.ce;
import com.bytedance.android.shopping.infeed.data.idl.ImageURL;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lhe3/h;", "", "Lhe3/n;", "title", "Lhe3/n;", "f", "()Lhe3/n;", "", "titleType", "Ljava/lang/Integer;", ce.f26391f, "()Ljava/lang/Integer;", "Lhe3/f;", "content", "Lhe3/f;", "b", "()Lhe3/f;", "", "Lhe3/g;", "images", "Ljava/util/List;", "c", "()Ljava/util/List;", "Lhe3/p;", "impressionWord", "Lhe3/p;", "d", "()Lhe3/p;", "", "jumpSchema", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "bgImg", "Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/shopping/infeed/data/idl/ImageURL;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("bg_img")
    private final ImageURL bgImg;

    @SerializedName("content")
    private final f content;

    @SerializedName("images")
    private final List<g> images;

    @SerializedName("impression_word")
    private final p impressionWord;

    @SerializedName("jump_schema")
    private final String jumpSchema;

    @SerializedName("title")
    private final n title;

    @SerializedName("title_type")
    private final Integer titleType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L20;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.titleType, r101.titleType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.images, r101.images) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.impressionWord, r101.impressionWord) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.jumpSchema, r101.jumpSchema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.bgImg, r101.bgImg) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        n r100 = this.title;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.titleType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        f r107 = this.content;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<g> r110 = this.images;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        p r113 = this.impressionWord;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.jumpSchema;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        ImageURL r119 = this.bgImg;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "DeepFeedCommentTabInfo(title=" + this.title + ", titleType=" + this.titleType + ", content=" + this.content + ", images=" + this.images + ", impressionWord=" + this.impressionWord + ", jumpSchema=" + this.jumpSchema + ", bgImg=" + this.bgImg + ")";
    }

    public h() {
        this.title = null;
        this.titleType = null;
        this.content = null;
        this.images = null;
        this.impressionWord = null;
        this.jumpSchema = null;
        this.bgImg = null;
    }

    public final ImageURL a() {
        return this.bgImg;
    }

    public final f b() {
        return this.content;
    }

    public final List<g> c() {
        return this.images;
    }

    public final p d() {
        return this.impressionWord;
    }

    public final String e() {
        return this.jumpSchema;
    }

    public final n f() {
        return this.title;
    }

    public final Integer g() {
        return this.titleType;
    }
}
