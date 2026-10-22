package com.bytedance.ee.bear.middleground.comment.export.config;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@AppConfig(key = CommentDraftConfig.KEY)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/config/CommentDraftConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "draftValidityPeriod", "", "getDraftValidityPeriod", "()I", "setDraftValidityPeriod", "(I)V", "Companion", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommentDraftConfig implements NonProguard {
    public static final a Companion = null;
    public static final String KEY = "ccm_comment_draft_config";
    private int draftValidityPeriod;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CommentDraftConfig() {
        this.draftValidityPeriod = 2592000;
    }

    public final int getDraftValidityPeriod() {
        return this.draftValidityPeriod;
    }

    public final void setDraftValidityPeriod(int r1) {
        this.draftValidityPeriod = r1;
    }
}
