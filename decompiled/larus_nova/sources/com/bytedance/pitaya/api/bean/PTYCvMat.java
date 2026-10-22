package com.bytedance.pitaya.api.bean;

import android.graphics.Bitmap;
import com.bytedance.pitaya.media.GraphicByte;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/pitaya/api/bean/PTYCvMat;", "Lcom/bytedance/pitaya/api/bean/PTYClass;", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "graphicByte", "Lcom/bytedance/pitaya/media/GraphicByte;", "(Landroid/graphics/Bitmap;Lcom/bytedance/pitaya/media/GraphicByte;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "getGraphicByte", "()Lcom/bytedance/pitaya/media/GraphicByte;", "setGraphicByte", "(Lcom/bytedance/pitaya/media/GraphicByte;)V", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PTYCvMat extends PTYClass {
    private Bitmap bitmap;
    private GraphicByte graphicByte;

    /* JADX WARN: Multi-variable type inference failed */
    public PTYCvMat() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final GraphicByte getGraphicByte() {
        return this.graphicByte;
    }

    public final void setBitmap(Bitmap r100) {
        this.bitmap = r100;
    }

    public final void setGraphicByte(GraphicByte r100) {
        this.graphicByte = r100;
    }

    public PTYCvMat(Bitmap r100, GraphicByte r101) {
        super(2);
        this.bitmap = r100;
        this.graphicByte = r101;
    }

    public /* synthetic */ PTYCvMat(Bitmap r100, GraphicByte r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
