package u32;

import com.bytedance.android.livesdk.message.model.d4;
import com.bytedance.android.livesdkapi.message.Text;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface l {

    public interface a {
        void b(l r100, com.bytedance.android.livesdk.interactivity.api.like.model.a r101);

        void d(l r100, int r101, int r102, Text r103, Text r104);

        void e(l r100, int r101);

        void k(l r100, List<d4> r101);

        void l(l r100, com.bytedance.android.livesdk.interactivity.api.like.model.a r101);
    }

    void addListener(a r100, boolean r101);

    void onLocalLike(int r100);

    void onLocalLikeResult(int r100, boolean r101, boolean r102);

    void removeListener(a r100);

    void setDoubleLikeEnable(boolean r100);
}
