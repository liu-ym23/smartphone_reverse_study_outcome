package com.bytedance.ee.bear.document.render.preload;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/document/render/preload/LarkDocsPreloadOptimize;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "onlyPreloadCurrentType", "", "getOnlyPreloadCurrentType", "()Z", "setOnlyPreloadCurrentType", "(Z)V", "preloadWithUserBehavior", "getPreloadWithUserBehavior", "setPreloadWithUserBehavior", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LarkDocsPreloadOptimize implements NonProguard {

    @SerializedName("enable_only_preload_current_docs_type")
    private boolean onlyPreloadCurrentType;

    @SerializedName("enable_preload_with_user_behavior")
    private boolean preloadWithUserBehavior;

    public LarkDocsPreloadOptimize() {
    }

    public final boolean getOnlyPreloadCurrentType() {
        return this.onlyPreloadCurrentType;
    }

    public final boolean getPreloadWithUserBehavior() {
        return this.preloadWithUserBehavior;
    }

    public final void setOnlyPreloadCurrentType(boolean r1) {
        this.onlyPreloadCurrentType = r1;
    }

    public final void setPreloadWithUserBehavior(boolean r1) {
        this.preloadWithUserBehavior = r1;
    }
}
