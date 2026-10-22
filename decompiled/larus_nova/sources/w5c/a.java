package w5c;

import com.ss.android.lark.chat.core.api.ChatCoreModule;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f558385a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        boolean r102 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L19;
        if (r101 != null) goto L12;
    L15:
        if (r102 == true) goto L19;
        ChatCoreModule.a().getAuditDependency().e(r100, r101, "image", "image");
        return;
    L12:
        if (r101.length() == 0) goto L15;
        r102 = false;
    L19:
        Log.e("ChatImageHitPoint", "send StartPhotoPreviewHitPoint failed");
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
