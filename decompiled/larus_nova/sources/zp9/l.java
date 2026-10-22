package zp9;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.platform.api.creation.UserCreation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes31.dex */
public interface l extends t1a.a {

    public static final class a {
        public static /* synthetic */ void a(l r100, boolean r101, boolean r102, Long r103, boolean r104, boolean r105, int r106) {
            if ((r106 & 1) == 0) goto L6;
            r101 = false;
        L6:
            if ((r106 & 2) == 0) goto L9;
            r102 = false;
        L9:
            if ((r106 & 4) == 0) goto L12;
            r103 = null;
        L12:
            if ((r106 & 8) == 0) goto L15;
            r104 = false;
        L15:
            if ((r106 & 16) == 0) goto L17;
            r105 = false;
        L17:
            r100.L90(r101, r102, r103, r104, r105);
        }
    }

    void CO(UserCreation r100);

    void Eo(p r100);

    void L90(boolean r100, boolean r101, Long r102, boolean r103, boolean r104);

    void X20(Function0<? extends View> r100);

    void addOnScrollListener(RecyclerView.OnScrollListener r100);

    Integer computeVerticalScrollOffset();

    void deleteUserCreation(String r100, boolean r101);

    void fQ(UserCreation r100);

    RecyclerView getRecyclerView();

    void nh(f r100, e r101);

    LiveData<Boolean> og();

    void xc(UserCreation r100);
}
