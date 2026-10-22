package com.ss.android.lark.inline.ai.api.knowledgeai;

import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewModelStoreOwner f426829a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<ulb.c> f426830b;

    public b(PluginHost r100, com.bytedance.ee.bear.document.ai.knowledgeai.d r101, com.bytedance.ee.bear.document.ai.knowledgeai.c r102, com.bytedance.ee.bear.document.ai.knowledgeai.e r103, Function0 r104) {
        Intrinsics.checkNotNullParameter(r100, "viewModelStoreOwner");
        Intrinsics.checkNotNullParameter(r101, "kvRepoAbility");
        Intrinsics.checkNotNullParameter(r102, "clipboardAbility");
        Intrinsics.checkNotNullParameter(r103, "docPermissionAbility");
        Intrinsics.checkNotNullParameter(r104, "htmlToDocxRecordProvider");
        this.f426829a = r100;
        this.f426830b = r104;
    }
}
