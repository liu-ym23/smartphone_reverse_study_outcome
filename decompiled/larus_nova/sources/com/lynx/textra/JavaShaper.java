package com.lynx.textra;

import android.graphics.Paint;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public class JavaShaper {

    /* JADX INFO: renamed from: bs, reason: collision with root package name */
    private BBufferOutputStream f384118bs;
    private JavaFontManager mFontManager;
    private HashMap<Integer, JavaTypeface> mFontMap;
    private Paint mPaint;

    public JavaShapeResult OnShapeTextNew(String r100, JavaTypeface r101, float r102, boolean r103, boolean r104) {
        return null;
    }

    public JavaShaper(JavaFontManager r100) {
        this.mFontMap = new HashMap(10);
        this.mFontManager = null;
        this.f384118bs = null;
        this.mPaint = new Paint();
        this.mFontManager = r100;
    }

    public float[] OnShapeText(String r100, JavaTypeface r101, float r102, boolean r103, boolean r104) {
        float[] r105 = new float[r100.length()];
        this.mPaint.setTypeface(r101.mTypeface);
        this.mPaint.setTextSize(TTTextUtils.Dp2Px(r102));
        this.mPaint.getTextWidths(r100, r105);
        int r106 = 0;
    L4:
        if (r106 >= r100.length()) goto L6;
        r105[r106] = TTTextUtils.Px2Dp(r105[r106]);
        r106 = r106 + 1;
        goto L4
    L6:
        r101.GetFontMetrics(r102);
        return r105;
    }
}
