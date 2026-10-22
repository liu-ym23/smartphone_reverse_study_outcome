package lo;

import android.graphics.Rect;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"Llo/c;", "", "", "left", "Ljava/lang/Integer;", "getLeft", "()Ljava/lang/Integer;", "top", "getTop", "right", "getRight", "bottom", "getBottom", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("bottom")
    private final Integer bottom;

    @SerializedName("left")
    private final Integer left;

    @SerializedName("right")
    private final Integer right;

    @SerializedName("top")
    private final Integer top;

    public final Rect a() {
        Integer r100 = this.left;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = com.bytedance.android.shopping.extensions.b.b(r100);
    L6:
        Integer r103 = this.top;
        if (r103 == null) goto L9;
        int r104 = com.bytedance.android.shopping.extensions.b.b(r103);
    L10:
        Integer r105 = this.right;
        if (r105 == null) goto L13;
        int r106 = com.bytedance.android.shopping.extensions.b.b(r105);
    L14:
        Integer r107 = this.bottom;
        if (r107 == null) goto L18;
        r101 = com.bytedance.android.shopping.extensions.b.b(r107);
    L18:
        return new Rect(r102, r104, r106, r101);
    L13:
        r106 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }
}
