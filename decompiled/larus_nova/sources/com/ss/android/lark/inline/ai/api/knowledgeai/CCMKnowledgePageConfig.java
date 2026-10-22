package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class CCMKnowledgePageConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<String> f426817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Map<String, String>> f426818b;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f426819a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Function0<String> f426820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Function0<? extends Map<String, String>> f426821c;

        public Builder() {
            this.f426820b = CCMKnowledgePageConfig$Builder$docTokenProvider$1.INSTANCE;
        }
    }

    public CCMKnowledgePageConfig(b r100, Function0 r101, Function0 r102) {
        Intrinsics.checkNotNullParameter(r100, "abilityDependencies");
        Intrinsics.checkNotNullParameter(r101, "docTokenProvider");
        this.f426817a = r101;
        this.f426818b = r102;
    }
}
