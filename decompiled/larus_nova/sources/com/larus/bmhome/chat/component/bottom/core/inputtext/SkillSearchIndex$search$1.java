package com.larus.bmhome.chat.component.bottom.core.inputtext;

import com.larus.platform.model.SlashMentionConfig;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.core.inputtext.SkillSearchIndex", f = "SkillSearchIndex.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {70, 71}, m = "search", n = {PerfLog.PARAM_KEY_CONTEXT_ID, "keyword", "$this$search_u24lambda_u246", SlashMentionConfig.SLASH_CONTENT_SKILL, "key", "requestEpoch", PerfLog.PARAM_KEY_CONTEXT_ID, "keyword", "$this$search_u24lambda_u246", SlashMentionConfig.SLASH_CONTENT_SKILL, "key", "requestEpoch"}, s = {"L$0", "L$1", "L$3", "L$5", "L$6", "J$0", "L$0", "L$1", "L$3", "L$5", "L$6", "J$0"})
public final class SkillSearchIndex$search$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkillSearchIndex this$0;

    public SkillSearchIndex$search$1(SkillSearchIndex r100, Continuation<? super SkillSearchIndex$search$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, null, null, this);
    }
}
