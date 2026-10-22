package p32;

import com.bytedance.android.livesdk.wrds.syncdata.highlight.HighlightItem;

/* JADX INFO: loaded from: classes9.dex */
public interface d {
    boolean b(HighlightItem r100);

    boolean canShow();

    void f(b r100);

    String getId();

    int getPriority();

    void h(c r100);

    boolean j();

    void l(b r100);

    void onDestroy();
}
