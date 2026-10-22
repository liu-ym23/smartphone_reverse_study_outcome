package uc5;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: classes18.dex */
public final class d1 {
    public static k a(Fragment r100) {
        if (r100 != null) goto L5;
        Fragment r101 = null;
    L6:
        if (r101 == null) goto L13;
        if ((r101 instanceof k) == false) goto L12;
        k r102 = (k) r101;
        if (r102.wO() == false) goto L12;
        return r102;
    L12:
        r101 = r101.getParentFragment();
        goto L6
    L13:
        return null;
    L5:
        r101 = r100.getParentFragment();
        goto L6
    }

    public static boolean b(Fragment r100) {
        if (r100 != null) goto L4;
        Bundle r101 = null;
    L5:
        if (r101 != null) goto L7;
    L11:
        return false;
    L7:
        if (r101.containsKey("office_list_tab") == false) goto L9;
    L10:
        return true;
    L9:
        if (r101.containsKey("office_list_runtime_id") == false) goto L11;
    L4:
        r101 = r100.getArguments();
        goto L5
    }

    public static String d(Document r100) {
        if (TextUtils.isEmpty(r100.f227873d) == false) goto L5;
        String r101 = r100.f227872c;
        if (r101 != null) goto L10;
        return "";
    L10:
        return r101;
    L5:
        return r100.f227873d;
    }

    public static boolean c(Fragment r100, Document r101, String r102) {
        k r103 = a(r100);
        if (r103 == null) goto L10;
        if (r100 == null) goto L10;
        return r103.Qz(r100, r101, r102);
    L8:
        th = move-exception;
        tt5.a.e("FolderHostSceneHelper", "open folder from host failed", th, false);
    L10:
        return false;
    }
}
