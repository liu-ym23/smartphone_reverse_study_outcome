package com.larus.dora.impl.core;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes27.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/dora/impl/core/DoraLinkServiceStartReason;", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface DoraLinkServiceStartReason {
    public static final int APP_BACKGROUND = 2;
    public static final int APP_START = 1;
    public static final a Companion = null;
    public static final int LINK_STATE_CHANGED = 3;
    public static final int ONGOING_NOTIFICATION_SWITCH_OPEN = 4;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f332155a = null;

        static {
            f332155a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f332155a;
    }
}
