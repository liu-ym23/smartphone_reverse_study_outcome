package ub2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.i;
import com.bytedance.android.livesdk.interactivity.service.textrender.utils.f;
import com.bytedance.android.livesdk.utils.m4;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a implements i {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final boolean c(ITextPieceImage r100) {
        Intrinsics.checkNotNullParameter(r100, "image");
        if (r100.getResourceType() != ITextPieceImage.ResourceType.Local) goto L5;
        return true;
    L5:
        return false;
    }

    public static Drawable d(ITextPieceImage r100, float r110) {
        Context r101 = s1.getContext();
        int r102 = r100.getLocalResId();
        int r103 = r100.getWidth();
        int r104 = r100.getHeight();
        WeakHashMap<Integer, Bitmap> r105 = m4.f159079a;
        Bitmap r106 = r105.get(Integer.valueOf(r102));
        if (r106 != null) goto L5;
    L7:
        Bitmap r107 = BitmapFactory.decodeResource(r101.getResources(), r102);
        if (r107 == null) goto L16;
        if (r103 > 0) goto L12;
        r103 = r107.getWidth();
    L12:
        if (r104 > 0) goto L14;
        r104 = r107.getHeight();
    L14:
        r106 = Bitmap.createScaledBitmap(r107, r103, r104, false);
        if (r106 == null) goto L16;
        r105.put(Integer.valueOf(r102), r106);
    L18:
        if (r106 != null) goto L21;
        return null;
    L21:
        if (r100.getWidth() > 0) goto L23;
        int r108 = r106.getWidth();
    L25:
        if (r100.getHeight() > 0) goto L27;
        int r109 = r106.getHeight();
    L28:
        int r111 = (int) f.a(r108, r110);
        int r112 = (int) f.a(r109, r110);
        BitmapDrawable r113 = new BitmapDrawable(s1.getResources(), r106);
        r113.setBounds(0, 0, r111, r112);
        return r113;
    L27:
        r109 = r100.getHeight();
        goto L28
    L23:
        r108 = r100.getWidth();
    L16:
        r106 = null;
        goto L18
    L5:
        if (r106.isRecycled() == true) goto L7;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final Drawable a(ITextPieceImage r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "image");
        return d(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.i
    public final void b(ITextPieceImage r100, float r101, Function1<? super Drawable, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "image");
        Intrinsics.checkNotNullParameter(r102, "callback");
        r102.invoke(d(r100, r101));
    }
}
