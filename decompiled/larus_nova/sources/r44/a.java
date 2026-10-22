package r44;

import android.widget.ImageView;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a {
    private int borderColor;
    private int borderWidth;
    private int overlayColor;
    private ImageView.ScaleType scaleType;
    private int targetHeight;
    private int targetWidth;
    private List<String> urlList;

    public a() {
        this.scaleType = ImageView.ScaleType.CENTER_CROP;
        this.urlList = CollectionsKt.emptyList();
        this.targetWidth = -1;
        this.targetHeight = -1;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final int getBorderWidth() {
        return this.borderWidth;
    }

    public final int getOverlayColor() {
        return this.overlayColor;
    }

    public final ImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    public final int getTargetHeight() {
        return this.targetHeight;
    }

    public final int getTargetWidth() {
        return this.targetWidth;
    }

    public final List<String> getUrlList() {
        return this.urlList;
    }

    public final void setBorderColor(int r100) {
        this.borderColor = r100;
    }

    public final void setBorderWidth(int r100) {
        this.borderWidth = r100;
    }

    public final void setOverlayColor(int r100) {
        this.overlayColor = r100;
    }

    public final void setScaleType(ImageView.ScaleType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scaleType = r100;
    }

    public final void setTargetHeight(int r100) {
        this.targetHeight = r100;
    }

    public final void setTargetWidth(int r100) {
        this.targetWidth = r100;
    }

    public final void setUrlList(List<String> r100) {
        this.urlList = r100;
    }
}
