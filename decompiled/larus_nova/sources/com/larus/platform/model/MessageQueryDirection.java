package com.larus.platform.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/platform/model/MessageQueryDirection;", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface MessageQueryDirection {
    public static final a Companion = null;
    public static final long MESSAGE_QUERY_DIRECTION_UNSPECIFIED = 0;
    public static final long MSG_QUERY_DIRECTION_NEWER = 2;
    public static final long MSG_QUERY_DIRECTION_OLDER = 1;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f365472a = null;

        static {
            f365472a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f365472a;
    }
}
