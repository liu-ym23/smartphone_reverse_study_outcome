package ii5;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f489991a = null;

    @Override // ii5.b
    public final int a() {
        return R.layout.enter_link_password;
    }

    static {
        f489991a = new a();
    }

    public a() {
    }

    @Override // ii5.b
    public final RequestPasswordView b(Context r100) {
        return new RequestPasswordView(r100);
    }

    @Override // ii5.b
    public final com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.h c(FragmentActivity r100, View r101, boolean r102) {
        return new com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.h(r100, r101, r102);
    }
}
