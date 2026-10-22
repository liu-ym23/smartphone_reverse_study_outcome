package zdc;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.ss.android.lark.chat.chatwindow.biz.component.keyboard.coordinate.SceneCoordinateRecyclerView;

/* JADX INFO: loaded from: classes38.dex */
public final class h {
    public static void a(RecyclerView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((SimpleItemAnimator) r100.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    public static void b(RecyclerView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.getItemAnimator().setAddDuration(0);
        r100.getItemAnimator().setChangeDuration(0);
        r100.getItemAnimator().setMoveDuration(0);
        r100.getItemAnimator().setRemoveDuration(0);
        ((SimpleItemAnimator) r100.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    public static boolean d(SceneCoordinateRecyclerView r100) {
        if ((r100.getLayoutManager() instanceof LinearLayoutManager) == false) goto L9;
        int r101 = ((LinearLayoutManager) r100.getLayoutManager()).findLastVisibleItemPosition();
        if (r100.getAdapter() != null) goto L7;
        return false;
    L7:
        if (r101 < (r100.getAdapter().getItemCount() - 1)) goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    public static boolean c(View r100, int r101, int r102) {
        int r103 = (int) (ViewCompat.getTranslationX(r100) + 0.5f);
        int r104 = (int) (ViewCompat.getTranslationY(r100) + 0.5f);
        int r105 = r100.getLeft() + r103;
        int r106 = r100.getRight() + r103;
        int r107 = r100.getTop() + r104;
        int r108 = r100.getBottom() + r104;
        if (r101 < r105) goto L8;
        if (r101 > r106) goto L8;
        if (r102 < r107) goto L8;
        if (r102 > r108) goto L8;
        return true;
    L8:
        return false;
    }
}
