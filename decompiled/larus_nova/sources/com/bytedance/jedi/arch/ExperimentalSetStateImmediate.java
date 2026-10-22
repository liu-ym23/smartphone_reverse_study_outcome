package com.bytedance.jedi.arch;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes19.dex */
@Deprecated(level = DeprecationLevel.WARNING, message = "use ExperimentalAccessStateImmediate instead", replaceWith = @ReplaceWith(expression = "ExperimentalAccessStateImmediate", imports = {"com.bytedance.jedi.arch.ExperimentalAccessStateImmediate"}))
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/jedi/arch/ExperimentalSetStateImmediate;", "", "arch_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public @interface ExperimentalSetStateImmediate {
}
