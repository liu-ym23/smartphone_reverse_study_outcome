package com.bytedance.lark.policy.decision;

import com.bytedance.lark.policy.model.ValidateRequest;
import java.util.Iterator;
import java.util.Map;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes20.dex */
public final class c implements Sequence<Map.Entry<? extends String, ? extends ValidateRequest>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map f253797a;

    @Override // kotlin.sequences.Sequence
    public final Iterator<Map.Entry<? extends String, ? extends ValidateRequest>> iterator() {
        return this.f253797a.entrySet().iterator();
    }

    public c(Map r100) {
        this.f253797a = r100;
    }
}
