package com.ss.android.lark.chat.preview.components.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.larus.nova.R;
import com.ss.android.shapeimage.ShaderImageView;
import egc.b;

/* JADX INFO: loaded from: classes35.dex */
public class CrescentPhotoImageView extends ShaderImageView {

    public static class a extends b {
        @Override // egc.a
        public final Bitmap a() {
            Drawable r100 = this.f472628i;
            if (r100 != null) goto L5;
        L7:
            Bitmap r101 = null;
        L8:
            if (r101 == null) goto L14;
            int r102 = r101.getWidth();
            int r103 = r101.getHeight();
            if (r102 <= 0) goto L14;
            if (r103 <= 0) goto L14;
            float r104 = Math.round(this.f472620a - (this.f472622c * 2.0f));
            float r105 = Math.round(this.f472621b - (this.f472622c * 2.0f));
            float r106 = r105 / r103;
            this.f472629j.setScale(r106, r106);
            Matrix r107 = this.f472629j;
            float r108 = this.f472622c;
            r107.postTranslate(r108, r108);
            c(r104, r105);
            return r101;
        L14:
            this.f472630k.reset();
            this.f472631l.reset();
            return null;
        L5:
            if ((r100 instanceof BitmapDrawable) == false) goto L7;
            r101 = ((BitmapDrawable) r100).getBitmap();
            goto L8
        }

        public a() {
            super(R.raw.crescent_photo_shape);
        }
    }

    @Override // com.ss.android.shapeimage.ShaderImageView
    public final egc.a a() {
        return new a();
    }

    public CrescentPhotoImageView(Context r100) {
        super(r100);
    }

    @Override // com.ss.android.shapeimage.ShaderImageView, android.widget.ImageView
    public void setImageBitmap(Bitmap r100) {
        super.setImageBitmap(r100);
        getPathHelper().b(getDrawable());
    }

    public CrescentPhotoImageView(Context r100, AttributeSet r101) {
        super(r100, r101);
    }

    public CrescentPhotoImageView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
