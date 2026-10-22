package kc8;

import android.view.View;
import com.larus.bmhome.chat.layout.holder.helper.LongClickSource;

/* JADX INFO: loaded from: classes25.dex */
public interface z {

    public static final class a {
        public static /* synthetic */ void a(z r100, View r101, st8.a r102, int r103) {
            LongClickSource r104 = null;
            if ((r103 & 1) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = null;
        L9:
            if ((r103 & 4) == 0) goto L11;
            r104 = LongClickSource.Content;
        L11:
            r100.b(r101, r102, r104);
        }
    }

    void a(View r100);

    void b(View r100, st8.a r101, LongClickSource r102);
}
