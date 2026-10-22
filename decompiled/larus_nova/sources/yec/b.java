package yec;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.ViewPager;
import com.larksuite.framework.utils.Reflect;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    public static class a extends EdgeEffect {
        @Override // android.widget.EdgeEffect
        public final boolean draw(Canvas r100) {
            return false;
        }

        @Override // android.widget.EdgeEffect
        public final void onAbsorb(int r100) {
        }

        @Override // android.widget.EdgeEffect
        public final void onPull(float r100, float r101) {
        }

        @Override // android.widget.EdgeEffect
        public final void onRelease() {
        }

        public a(Context r100) {
            super(r100);
        }
    }

    public static void a(ViewPager r100, String r101, a r102) {
        new Reflect(r100).i(r101, r102);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.d(e.toString());
        new Reflect((EdgeEffectCompat) new Reflect(r100).e(r101, new Class[]{EdgeEffectCompat.class}).f285916a).i("mEdgeEffect", r102);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.d(e.toString());
    }
}
