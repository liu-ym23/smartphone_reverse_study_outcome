package mq1;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes8.dex */
public interface a0 {

    public static final class a {
        public static /* synthetic */ void a(a0 r100, String r101, String r110, String r111, DataCenter r112) {
            r100.logReport(false, r101, "", r110, r111, r112, null);
        }
    }

    void a(Long r100, long r101, long r102, String r103, String r104, long r105, String r110, String r111, DataCenter r112, Context r113);

    boolean c(Episode r100, Context r101, String r102, boolean r103, vk1.a r104, IBaseUser r105, DataCenter r106);

    void logReport(boolean r100, String r101, String r102, String r103, String r104, ViewModel r105, String r106);
}
