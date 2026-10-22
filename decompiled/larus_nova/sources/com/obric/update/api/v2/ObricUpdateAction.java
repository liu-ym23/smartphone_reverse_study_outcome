package com.obric.update.api.v2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/update/api/v2/ObricUpdateAction;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface ObricUpdateAction {
    public static final int ACTION_CANCEL_DOWNLOAD = 3;
    public static final int ACTION_INSTALL = 4;
    public static final int ACTION_PAUSE_DOWNLOAD = 2;
    public static final int ACTION_RESUME_DOWNLOAD = 6;
    public static final int ACTION_RETRY_DOWNLOAD = 5;
    public static final int ACTION_START_DOWNLOAD = 1;
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f404036a = null;

        static {
            f404036a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f404036a;
    }
}
