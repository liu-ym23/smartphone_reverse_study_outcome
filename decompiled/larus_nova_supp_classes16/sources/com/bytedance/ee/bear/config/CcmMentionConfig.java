package com.bytedance.ee.bear.config;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = CcmMentionConfig.KEY)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/config/CcmMentionConfig;", "Lcom/bytedance/ee/util/io/NonProguard;", "authorMaxCount", "", "<init>", "(I)V", "getAuthorMaxCount", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "features-at_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CcmMentionConfig implements NonProguard {
    public static final a Companion = null;
    public static final int DEFAULT_AUTHOR_MAX_COUNT = 30;
    public static final String KEY = "ccm_mention_config";
    private final int authorMaxCount;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CcmMentionConfig() {
        int r2 = 0;
        this(r2, 1, null);
    }

    public static /* synthetic */ CcmMentionConfig copy$default(CcmMentionConfig r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.authorMaxCount;
    L6:
        return r0.copy(r1);
    }

    public final int component1() {
        return this.authorMaxCount;
    }

    public final CcmMentionConfig copy(int r2) {
        return new CcmMentionConfig(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CcmMentionConfig) == true) goto L9;
        return false;
    L9:
        if (this.authorMaxCount == ((CcmMentionConfig) r4).authorMaxCount) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.authorMaxCount;
    }

    public String toString() {
        return "CcmMentionConfig(authorMaxCount=" + this.authorMaxCount + ')';
    }

    public final int getAuthorMaxCount() {
        return this.authorMaxCount;
    }

    public CcmMentionConfig(int r1) {
        this.authorMaxCount = r1;
    }

    public /* synthetic */ CcmMentionConfig(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 30;
    L5:
        this(r1);
    }
}
