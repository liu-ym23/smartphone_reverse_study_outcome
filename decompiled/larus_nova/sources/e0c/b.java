package e0c;

import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.f0;
import dagger.BindsInstance;

/* JADX INFO: loaded from: classes37.dex */
public interface b {
    b a(@BindsInstance f0 r100);

    b b(@BindsInstance String r100);

    a build();

    b userSession(@BindsInstance UserSession r100);
}
