package com.larus.avlink.api.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes23.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/avlink/api/model/QuickNoteAction;", "", "Companion", "dora_avlink_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface QuickNoteAction {
    public static final a Companion = null;
    public static final String RECORD_OR_QUERY = "record_or_query";
    public static final String SINGLE_CLICK = "SINGLE_CLICK";
    public static final String VOICE_REMINDER = "voice_reminder";

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f291648a = null;

        static {
            f291648a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f291648a;
    }
}
