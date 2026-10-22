package r0c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.Contexts;

/* JADX INFO: loaded from: classes37.dex */
public final class e {
    public static void a(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == false) goto L11;
        Log.e("PhotoEditorOutputDelegate", "image path is empty");
        return;
    L11:
        Activity r103 = Contexts.requireActivity(r100);     // Catch: Exception -> L8
        Intent r104 = new Intent();     // Catch: Exception -> L8
        r104.putExtra(r101, true);     // Catch: Exception -> L8
        r104.putExtra("key_result_path", r102);     // Catch: Exception -> L8
        r103.setResult(-1, r104);     // Catch: Exception -> L8
        r103.finish();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        Log.e("PhotoEditorOutputDelegate", "failed to return output result", e);
    }
}
