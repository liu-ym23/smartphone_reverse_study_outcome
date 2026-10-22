package com.bytedance.ee.bear.document.ai.knowledgeai;

import com.ss.android.lark.storage.kv.repo.KVRepo;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KVRepo f218847a;

    public static final class a {
    }

    static {
    }

    public d(KVRepo r100) {
        Intrinsics.checkNotNullParameter(r100, "kvRepo");
        this.f218847a = r100;
        new LinkedHashMap();
    }
}
