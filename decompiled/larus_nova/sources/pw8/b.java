package pw8;

import android.content.Context;
import android.view.ViewGroup;
import lw8.h;

/* JADX INFO: loaded from: classes26.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ pw8.a a(b r100, Context r101, int r102, uvc.b r103, Boolean r110) {
            return r100.a(r101, r102, r103, r110, null);
        }
    }

    pw8.a a(Context r100, int r101, uvc.b r102, Boolean r103, h r104);

    pw8.a b(Context r100, int r101, int r102, ViewGroup r103, uvc.b r104, Boolean r105, h r106);

    boolean c(uvc.b r100);

    int priority();
}
