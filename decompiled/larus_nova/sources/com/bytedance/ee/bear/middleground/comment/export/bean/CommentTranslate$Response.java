package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$Response;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "business", "", "getBusiness", "()Ljava/lang/String;", "setBusiness", "(Ljava/lang/String;)V", "data", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$ResponseData;", "getData", "()Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$ResponseData;", "setData", "(Lcom/bytedance/ee/bear/middleground/comment/export/bean/CommentTranslate$ResponseData;)V", "Companion", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentTranslate$Response implements NonProguard {
    public static final a Companion = null;
    private static final String TAG = "CommentTranslate.Response";
    private String business;
    private CommentTranslate$ResponseData data;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CommentTranslate$Response() {
    }

    public final String getBusiness() {
        return this.business;
    }

    public final CommentTranslate$ResponseData getData() {
        return this.data;
    }

    @JvmStatic
    public static final CommentTranslate$Response parseFrom(String r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "json");
        Object r101 = JSON.parseObject(r100, CommentTranslate$Response.class);     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r101);     // Catch: Exception -> L5
        return (CommentTranslate$Response) r101;
    L6:
        return new CommentTranslate$Response();
    }

    public final void setBusiness(String r100) {
        this.business = r100;
    }

    public final void setData(CommentTranslate$ResponseData r100) {
        this.data = r100;
    }
}
