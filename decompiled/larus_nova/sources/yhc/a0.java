package yhc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.update.IUpdateConfig;
import java.io.File;

/* JADX INFO: loaded from: classes40.dex */
public final class a0 {
    public static void a(Context r100, File r101) {
        if (r100 == null) goto L25;
        int r102 = Build.VERSION.SDK_INT;     // Catch: Exception -> L21
        if (r102 < 24) goto L14;
        IUpdateConfig r103 = f0.f567692a;     // Catch: Exception -> L21
        if (r103 == null) goto L12;
        v r104 = r103.getUpdateConfig();     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r104.f567739c) == true) goto L11;
        String r105 = r104.f567739c;     // Catch: Exception -> L21
    L13:
        Uri r106 = FileProvider.getUriForFile(r100, r105, r101);     // Catch: Exception -> L21
    L15:
        Intent r107 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: Exception -> L21
        r107.setDataAndType(r106, "application/vnd.android.package-archive");     // Catch: Exception -> L21
        if (r102 < 24) goto L18;
        int r108 = 268435457;
    L19:
        r107.addFlags(r108);     // Catch: Exception -> L21
        r100.startActivity(r107);     // Catch: Exception -> L21
        return;
    L18:
        r108 = 268435456;
        goto L19
    L11:
        throw new IllegalArgumentException("formalAuthority can not empty");     // Catch: Exception -> L21
    L12:
        r105 = "com.ss.android.uri.key";
        goto L13
    L14:
        r106 = Uri.fromFile(r101);     // Catch: Exception -> L21
    L21:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
