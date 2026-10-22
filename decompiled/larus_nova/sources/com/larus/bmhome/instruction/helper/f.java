package com.larus.bmhome.instruction.helper;

import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public interface f {

    public static final class a {
        public static /* synthetic */ void a(f r100, FragmentActivity r101, int r102) {
            if ((r102 & 1) == 0) goto L5;
            r101 = null;
        L5:
            r100.a(r101, false, 0);
        }
    }

    void a(FragmentActivity r100, boolean r101, int r102);

    void b(Function1<? super Uri, Unit> r100);

    void c(Function1<? super List<? extends Uri>, Unit> r100);

    void onDestroy();
}
