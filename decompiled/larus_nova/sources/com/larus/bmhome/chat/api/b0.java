package com.larus.bmhome.chat.api;

import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.utils.CubicBezierInterpolator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public interface b0 {

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a {
        public static /* synthetic */ void b(b0 r100, boolean r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r101 = false;
        L6:
            if ((r102 & 4) == 0) goto L8;
            boolean r103 = true;
        L9:
            r100.l(r101, 0, r103, null);
            return;
        L8:
            r103 = false;
            goto L9
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(b0 r100, boolean r101, int r102, Function0 r103, CubicBezierInterpolator r104, int r105, int r106) {
            if ((r106 & 1) == 0) goto L6;
            r101 = false;
        L6:
            if ((r106 & 2) == 0) goto L9;
            r102 = 0;
        L9:
            if ((r106 & 4) == 0) goto L12;
            r103 = null;
        L12:
            if ((r106 & 8) == 0) goto L15;
            r104 = null;
        L15:
            if ((r106 & 16) == 0) goto L17;
            r105 = Integer.MIN_VALUE;
        L17:
            r100.c(r101, r102, r103, r104, r105);
        }
    }

    void c(boolean r100, int r101, Function0<Unit> r102, Interpolator r103, int r104);

    void e(int r100);

    Long getChatUniqueKey();

    boolean i();

    void l(boolean r100, int r101, boolean r102, Function0<Unit> r103);

    RecyclerView m();

    void setBottomReached(boolean r100);
}
