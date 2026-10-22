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
public final class b implements UniPathProvider {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    public final FileStorage b() {
        return UniPathProvider.a.a(this);
    }

    public final UniPathProvider.SpaceType c() {
        return UniPathProvider.SpaceType.USER;
    }

    public final String a(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = c.a;
        return c.a.a(r4, "luban_disk_cache", Storage.Type.INNER_FILES, new String[0]);
    }

    public final VFSPath d(FileStorage r5) {
        Intrinsics.checkNotNullParameter(r5, "space");
        return r5.b(f.d, new d(new String[]{"ccm", "luban_disk_cache"}));
    }
}
