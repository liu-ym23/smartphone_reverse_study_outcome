package com.bytedance.ee.bear.diskmanager.dirs;

import android.content.Context;
import com.ss.android.lark.diskmanage.storage.Storage;
import com.ss.android.lark.diskmanage.storage.c;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.storage.file.FileStorage;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.dirs.UniPathProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a implements UniPathProvider {
    public final f a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.diskmanager.dirs.a$a, reason: collision with other inner class name */
    public static final class C0043a {
    }

    static {
    }

    public final FileStorage b() {
        return UniPathProvider.a.a(this);
    }

    public a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "volume");
        this.a = r2;
    }

    public final String a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        f r0 = this.a;
        if (Intrinsics.areEqual(r0, f.d) == false) goto L6;
        Storage.Type r1 = Storage.Type.INNER_FILES;
    L15:
        int r2 = c.a;
        return c.a.a(r4, "ccm", r1, new String[0]);
    L6:
        if (Intrinsics.areEqual(r0, f.e) == false) goto L9;
        r1 = Storage.Type.INNER_CACHE;
        goto L15
    L9:
        if (Intrinsics.areEqual(r0, f.g) == false) goto L12;
        r1 = Storage.Type.FILES;
        goto L15
    L12:
        if (Intrinsics.areEqual(r0, f.h) == false) goto L14;
        r1 = Storage.Type.CACHE;
        goto L15
    L14:
        r1 = Storage.Type.STORAGE_LARK;
        goto L15
    }

    public final VFSPath d(FileStorage r4) {
        Intrinsics.checkNotNullParameter(r4, "space");
        return r4.b(this.a, new d(new String[]{"ccm"}));
    }
}
