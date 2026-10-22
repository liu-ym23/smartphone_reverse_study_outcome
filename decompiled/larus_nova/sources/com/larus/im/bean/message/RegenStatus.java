package com.larus.im.bean.message;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/im/bean/message/RegenStatus;", "", "Companion", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface RegenStatus {
    public static final a Companion = null;
    public static final int STATUS_CENTER = 2;
    public static final int STATUS_EMPTY = 0;
    public static final int STATUS_FIRST = 1;
    public static final int STATUS_LAST = 3;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f346700a = null;

        static {
            f346700a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f346700a;
    }
}
