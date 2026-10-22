package com.larus.bmhome.instruction.monitor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes26.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/bmhome/instruction/monitor/SuggestPromptErrorType;", "", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface SuggestPromptErrorType {
    public static final a Companion = null;
    public static final String ERROR_TYPE_CRASH = "CRASH";
    public static final String ERROR_TYPE_DEFAULT = "DEFAULT";
    public static final String ERROR_TYPE_SERIOUS_PROBLEMS = "SERIOUS_PROBLEMS";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f312182a = null;

        static {
            f312182a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f312182a;
    }
}
