package uc5;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d1 {
    public static k a(Fragment r3) {
        if (r3 != null) goto L5;
        Fragment r4 = null;
    L6:
        if (r4 == null) goto L13;
        if ((r4 instanceof k) == false) goto L12;
        k r1 = (k) r4;
        if (r1.wO() == false) goto L12;
        return r1;
    L12:
        r4 = r4.getParentFragment();
        goto L6
    L13:
        return null;
    L5:
        r4 = r3.getParentFragment();
        goto L6
    }

    public static boolean b(Fragment r1) {
        if (r1 != null) goto L4;
        Bundle r2 = null;
    L5:
        if (r2 != null) goto L7;
    L11:
        return false;
    L7:
        if (r2.containsKey("office_list_tab") == false) goto L9;
    L10:
        return true;
    L9:
        if (r2.containsKey("office_list_runtime_id") == false) goto L11;
    L4:
        r2 = r1.getArguments();
        goto L5
    }

    public static String d(Document r1) {
        if (TextUtils.isEmpty(r1.d) == false) goto L5;
        String r2 = r1.c;
        if (r2 != null) goto L10;
        return "";
    L10:
        return r2;
    L5:
        return r1.d;
    }

    public static boolean c(Fragment r2, Document r3, String r4) {
        k r0 = a(r2);
        if (r0 == null) goto L10;
        if (r2 == null) goto L10;
        return r0.Qz(r2, r3, r4);
    L8:
        th = move-exception;
        tt5.a.e("FolderHostSceneHelper", "open folder from host failed", th, false);
    L10:
        return false;
    }
}
