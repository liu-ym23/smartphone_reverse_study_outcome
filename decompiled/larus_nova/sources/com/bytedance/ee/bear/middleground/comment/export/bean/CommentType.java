package com.bytedance.ee.bear.middleground.comment.export.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes18.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentType;", "", "Companion", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface CommentType {
    public static final a Companion = null;
    public static final long LOCAL = 1;
    public static final long WHOLE = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f231359a = null;

        static {
            f231359a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f231359a;
    }
}
