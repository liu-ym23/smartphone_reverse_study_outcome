package com.bytedance.ee.bear.doc.cover;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0011\u001a\u00020\u0012R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/doc/cover/CurrentCoverData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "type", "", "getType$annotations", "getType", "()I", "setType", "(I)V", "isExistCover", "", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CurrentCoverData implements NonProguard {
    private String token;
    private int type;

    public CurrentCoverData() {
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public final boolean isExistCover() {
        int r0 = this.type;
        if (r0 != 1) goto L5;
        return true;
    L5:
        if (r0 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public final String getToken() {
        return this.token;
    }

    public final int getType() {
        return this.type;
    }

    public final void setToken(String r1) {
        this.token = r1;
    }

    public final void setType(int r1) {
        this.type = r1;
    }
}
