package kv1;

import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.ies.utility.SharedPrefHelper;
import jc1.k;

/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f506232a;

    public a() {
        SharedPrefHelper.c(((IHostContext) k.f(IHostContext.class)).context(), "live_fans_comment_guide");
    }
}
