package com.larus.platform.model.comment;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/larus/platform/model/comment/NoticeType;", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface NoticeType {
    public static final int COMMENT_LIKE_NOTICE_TYPE = 5;
    public static final int COMMENT_NOTICE_TYPE = 4;
    public static final a Companion = null;
    public static final int FOLLOW_NOTICE_TYPE = 3;
    public static final int LIKE_NOTICE_TYPE = 1;
    public static final int PLAYED_NOTICE_TYPE = 2;
    public static final int REPLY_COMMENT_NOTICE_TYPE = 6;
    public static final int UNKNOWN = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f365618a = null;

        static {
            f365618a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f365618a;
    }
}
