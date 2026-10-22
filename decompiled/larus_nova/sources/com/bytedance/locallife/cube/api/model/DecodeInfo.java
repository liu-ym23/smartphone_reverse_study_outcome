package com.bytedance.locallife.cube.api.model;

import com.lynx.tasm.TemplateBundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/DecodeInfo;", "Lcom/bytedance/locallife/cube/api/model/DecodeRecord;", "version", "", "bundle", "Lcom/lynx/tasm/TemplateBundle;", "codeCached", "", "(JLcom/lynx/tasm/TemplateBundle;Z)V", "getBundle", "()Lcom/lynx/tasm/TemplateBundle;", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DecodeInfo extends DecodeRecord {
    private final TemplateBundle bundle;

    public final TemplateBundle getBundle() {
        return this.bundle;
    }

    public DecodeInfo(long r100, TemplateBundle r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "bundle");
        super(r100, r102);
        this.bundle = r101;
    }
}
