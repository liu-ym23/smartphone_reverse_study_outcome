package com.obric.assistant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Deprecated(message = "https://meego.larkoffice.com/new_ocean/story/detail/6793099338 这个需求上线后过时")
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/obric/assistant/AutoGuiSettingStatus;", "", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface AutoGuiSettingStatus {
    public static final int ALLOWED = 1;
    public static final int ALLOWED_FOREVER = 2;
    public static final a Companion = null;
    public static final int DISALLOWED = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f385113a = null;

        static {
            f385113a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f385113a;
    }
}
