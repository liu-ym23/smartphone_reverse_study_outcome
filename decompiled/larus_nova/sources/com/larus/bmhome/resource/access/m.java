package com.larus.bmhome.resource.access;

import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class m extends DelegatingResourceNode {
    public m() {
        super("remote_download", ResourcePhase.REMOTE_FALLBACK, CollectionsKt.listOf("remote_direct"), true, 16);
    }
}
