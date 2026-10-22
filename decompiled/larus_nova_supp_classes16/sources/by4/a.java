package by4;

import android.text.TextUtils;
import com.bytedance.ee.bear.diskmanager.Biz;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import javax.inject.Inject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@UserScope
public final class a implements c {
    public final FileStorage a;

    /* JADX INFO: renamed from: by4.a$a, reason: collision with other inner class name */
    public static final class C0009a {
    }

    static {
    }

    @Inject
    public a(String r3) {
        tt5.a.h("CCMUserFileStorage", "uid=" + r3);
        if (TextUtils.equals(r3, "absent_user") == false) goto L5;
        FileStorage r4 = LarkFileStorage.d("");
    L8:
        this.a = r4;
        return;
    L5:
        if (r3 != null) goto L7;
        r3 = "absent_user";
    L7:
        r4 = LarkFileStorage.d(r3);
        goto L8
    }

    @Override // by4.c
    public final VFSPath a(Biz r7, String r8, boolean r9) {
        FileStorage r0 = this.a;
        f r1 = f.e;
        String[] r3 = new String[3];
        r3[0] = "ccm";
        if (r7 == null) goto L6;
        String r10 = r7.getBizRootDir();
        if (r10 == null) goto L6;
    L7:
        r3[1] = r10;
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        r3[2] = r8;
        VFSPath r11 = r0.b(r1, new com.ss.android.lark.storage.d(r3));
        if (r9 == true) goto L13;
        return r11;
    L13:
        return ay4.d.a().z(r11.getRealPath());
    L6:
        r10 = "";
        goto L7
    }

    @Override // by4.c
    public final VFSPath b(Biz r7, String r8, boolean r9) {
        FileStorage r0 = this.a;
        f r1 = f.d;
        String[] r3 = new String[3];
        r3[0] = "ccm";
        if (r7 == null) goto L6;
        String r10 = r7.getBizRootDir();
        if (r10 == null) goto L6;
    L7:
        r3[1] = r10;
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        r3[2] = r8;
        VFSPath r11 = r0.b(r1, new com.ss.android.lark.storage.d(r3));
        if (r9 == true) goto L13;
        return r11;
    L13:
        return ay4.d.a().z(r11.getRealPath());
    L6:
        r10 = "";
        goto L7
    }
}
