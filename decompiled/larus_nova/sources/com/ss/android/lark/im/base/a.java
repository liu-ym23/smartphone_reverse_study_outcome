package com.ss.android.lark.im.base;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.h;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f425879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.ss.android.lark.storage.a f425880b = null;

    static {
        f425879a = new com.ss.android.lark.storage.a("IM");
        f425880b = new com.ss.android.lark.storage.a("Common");
    }

    public static com.ss.android.lark.storage.kv.repo.a a() {
        return LarkKVStorage.q(f425879a, true);
    }

    @JvmStatic
    public static final h b() {
        VFSFiles.f444819b.getClass();
        return VFSFiles.b(true);
    }
}
