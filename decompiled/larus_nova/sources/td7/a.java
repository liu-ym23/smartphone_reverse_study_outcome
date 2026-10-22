package td7;

import android.net.Uri;
import com.obric.miniapp.alarm.AccountType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static final Uri a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter("com.bytedance", "account");
        Intrinsics.checkNotNullParameter(AccountType.LOCAL, "accountType");
        return r100.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", "com.bytedance").appendQueryParameter("account_type", AccountType.LOCAL).build();
    }
}
