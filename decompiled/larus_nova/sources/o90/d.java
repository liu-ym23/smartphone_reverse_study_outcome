package o90;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.PropsBGData")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\u000e"}, d2 = {"Lo90/d;", "", "", "imageUri", "Ljava/lang/String;", "", "imgType", "I", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "imageThumbnail", "<init>", "()V", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d implements h {

    @SerializedName("image")
    public ImageModel image;

    @SerializedName("imageThumbnail")
    public ImageModel imageThumbnail;

    @SerializedName("image_uri")
    public String imageUri;

    @SerializedName("img_type")
    public int imgType;

    public d() {
        this.imageUri = "";
        this.imgType = -1;
    }

    public d(g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L17;
        if (r103 != 1) goto L7;
        this.imageUri = am3.h.c(r100);
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.imgType = r100.i();
        r102 = r102 | true;
        goto L3
    L9:
        if (r103 != 3) goto L11;
        this.image = x.a(r100);
        goto L3
    L11:
        if (r103 != 4) goto L12;
        this.imageThumbnail = x.a(r100);
        goto L3
    L12:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.imageUri != null) goto L21;
        this.imageUri = "";
    L21:
        if ((r102 & true) == true) goto L39;
        this.imgType = -1;
        return;
    }
}
