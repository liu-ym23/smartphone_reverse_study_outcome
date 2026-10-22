package sj3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lsj3/n;", "", "", "text", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "", "textSize", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "setTextSize", "(Ljava/lang/Integer;)V", "textColor", "c", "setTextColor", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "a", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setImage", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "textFont", "I", "d", "()I", "setTextFont", "(I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n {

    @SerializedName("bg_img")
    private ECUrlModel image;

    @SerializedName("text")
    private String text;

    @SerializedName("text_color")
    private String textColor;

    @SerializedName("font_weight")
    private int textFont;

    @SerializedName("text_size")
    private Integer textSize;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n) == false) goto L16;
        n r4 = (n) r3;
        if (Intrinsics.areEqual(this.text, r4.text) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textSize, r4.textSize) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.textColor, r4.textColor) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.image, r4.image) == true) goto L14;
        return false;
    L14:
        if (this.textFont == r4.textFont) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.textSize;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.textColor;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ECUrlModel r10 = this.image;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return ((r9 + r1) * 31) + this.textFont;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "TextLabelItem(text=" + this.text + ", textSize=" + this.textSize + ", textColor=" + this.textColor + ", image=" + this.image + ", textFont=" + this.textFont + ")";
    }

    public n() {
        this.text = null;
        this.textSize = null;
        this.textColor = null;
        this.image = null;
        this.textFont = 400;
    }

    public final ECUrlModel a() {
        return this.image;
    }

    public final String b() {
        return this.text;
    }

    public final String c() {
        return this.textColor;
    }

    public final int d() {
        return this.textFont;
    }

    public final Integer e() {
        return this.textSize;
    }
}
