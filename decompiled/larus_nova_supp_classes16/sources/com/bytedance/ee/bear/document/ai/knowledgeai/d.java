package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final KVRepo a;

    public static final class a {
    }

    static {
    }

    public d(KVRepo r2) {
        Intrinsics.checkNotNullParameter(r2, "kvRepo");
        this.a = r2;
        new LinkedHashMap();
    }
}
