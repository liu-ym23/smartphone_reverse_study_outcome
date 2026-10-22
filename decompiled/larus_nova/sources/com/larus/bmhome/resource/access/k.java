package com.larus.bmhome.resource.access;

import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class k extends DelegatingResourceNode {
    public k() {
        super("remote_detect", ResourcePhase.DETECT, CollectionsKt.listOf("remote_resolve"), true, ResourceNodeCompletionMode.DETACHED);
    }
}
