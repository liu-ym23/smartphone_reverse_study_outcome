package com.bytedance.lynx.service.text;

import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.shadow.text.g;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.textra.TTText;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes21.dex */
public class TextResourceLoader {
    private static final AtomicInteger sIdGenerator = null;
    private static final Map<Integer, com.bytedance.lynx.service.text.b> sImages = null;

    public static class a implements com.bytedance.lynx.service.text.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f264989a;

        public a(long r100) {
            this.f264989a = r100;
        }
    }

    public static class b implements g.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile long f264990a;

        public b(long r100) {
            this.f264990a = r100;
        }

        @Override // com.lynx.tasm.behavior.shadow.text.g.c
        public final void a(Typeface r100, int r101) {
            long r102 = this.f264990a;
            if (r102 != 0) goto L5;
            return;
        L5:
            TextResourceLoader.access$000(r102);
            this.f264990a = 0;
        }
    }

    public TextResourceLoader() {
    }

    private static native void onFontLoaded(long r100);

    private static native void onImageError(long r100);

    private static native void onImageLoaded(long r100);

    private static long packIntPair(int r100, int r101) {
        long r102 = ((long) r100) << 32;
        return (((long) r101) & BodyPartID.bodyIdMax) | r102;
    }

    static {
        sImages = new ConcurrentHashMap();
        sIdGenerator = new AtomicInteger(1);
    }

    public static void ReleaseImage(int r100) {
        sImages.remove(Integer.valueOf(r100));
    }

    public static /* synthetic */ void access$000(long r100) {
        onFontLoaded(r100);
    }

    public static /* synthetic */ void access$100(long r100) {
        onImageLoaded(r100);
    }

    public static /* synthetic */ void access$200(long r100) {
        onImageError(r100);
    }

    public static long LoadFont(Object r100, String r101, int r102, long r103) {
        if ((r100 instanceof LynxContext) == false) goto L5;
        LynxContext r104 = (LynxContext) r100;
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        int r105 = 1;
        if (r102 <= 400) goto L12;
        int r106 = 1;
    L14:
        if (r101.isEmpty() == false) goto L16;
        Typeface r107 = Typeface.defaultFromStyle(r106);
    L17:
        if (r107 == null) goto L22;
        if (Build.VERSION.SDK_INT < 28) goto L22;
        r107 = Typeface.create(r107, r102, false);
    L22:
        if (r101.isEmpty() == true) goto L29;
        if (r107 != null) goto L29;
        if (r104.getFontFace(r101) == null) goto L29;
        b r108 = new b(r103);
        Typeface r109 = FontFaceManager.g.f383410a.g(r104, r101, r106, r108);
        if (r109 == null) goto L30;
        r108.f264990a = 0;
        r105 = 0;
        r107 = r109;
    L30:
        if (r107 != null) goto L34;
        return packIntPair(r105, 0);
    L34:
        return packIntPair(r105, TTText.mFontManager.CreateOrRegisterTypeface(r107, r101, r102, false).mIndex);
    L29:
        r105 = 0;
        goto L30
    L16:
        r107 = g.d(r104, r101, r106);
        goto L17
    L12:
        r106 = 0;
        goto L14
    L5:
        return packIntPair(0, 0);
    }

    public static int LoadImage(Object r100, String r101, float r102, float r103, long r110) {
        if ((r100 instanceof LynxContext) == true) goto L6;
        return 0;
    L6:
        com.bytedance.lynx.service.text.b r104 = new com.bytedance.lynx.service.text.b(r101, r102, r103, (LynxContext) r100, new a(r110));
        int r105 = sIdGenerator.getAndIncrement();
        sImages.put(Integer.valueOf(r105), r104);
        return r105;
    }

    public static void DrawImage(int r100, Canvas r101, float r102, float r103, float r104, float r105, Drawable.Callback r106) {
        com.bytedance.lynx.service.text.b r107 = sImages.get(Integer.valueOf(r100));
        if (r107 == null) goto L8;
        if (r106 == null) goto L6;
        r107.f264994c = new WeakReference(r106);
    L6:
        r101.save();
        r101.translate((int) r102, (int) r103);
        r107.f264992a.i(r101);
        r101.restore();
        return;
    }
}
