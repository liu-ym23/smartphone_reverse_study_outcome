package ii5;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.RequestPasswordView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements b {
    public static final a a = null;

    @Override // ii5.b
    public final int a() {
        return 2131561079;
    }

    static {
        a = new a();
    }

    public a() {
    }

    @Override // ii5.b
    public final RequestPasswordView b(Context r2) {
        return new RequestPasswordView(r2);
    }

    @Override // ii5.b
    public final com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.h c(FragmentActivity r2, View r3, boolean r4) {
        return new com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.h(r2, r3, r4);
    }
}
