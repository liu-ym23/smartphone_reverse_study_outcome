package com.bytedance.ee.bear.document.setting.model;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/document/setting/model/LeaderAutoAuthInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "autoAuthLeader", "", "startNet", "<init>", "(Ljava/lang/Boolean;Z)V", "getAutoAuthLeader", "()Ljava/lang/Boolean;", "setAutoAuthLeader", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getStartNet", "()Z", "setStartNet", "(Z)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LeaderAutoAuthInfo implements NonProguard {
    private Boolean autoAuthLeader;
    private boolean startNet;

    public LeaderAutoAuthInfo() {
        Boolean r2 = null;
        this(r2, false, 3, r2);
    }

    public final Boolean getAutoAuthLeader() {
        return this.autoAuthLeader;
    }

    public final boolean getStartNet() {
        return this.startNet;
    }

    public final void setAutoAuthLeader(Boolean r1) {
        this.autoAuthLeader = r1;
    }

    public final void setStartNet(boolean r1) {
        this.startNet = r1;
    }

    public LeaderAutoAuthInfo(Boolean r1, boolean r2) {
        this.autoAuthLeader = r1;
        this.startNet = r2;
    }

    public /* synthetic */ LeaderAutoAuthInfo(Boolean r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = Boolean.FALSE;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = true;
    L8:
        this(r1, r2);
    }
}
