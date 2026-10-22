package com.bytedance.ee.bear.document.setting.model;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/document/setting/model/LeaderAutoAuthInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "autoAuthLeader", "", "startNet", "<init>", "(Ljava/lang/Boolean;Z)V", "getAutoAuthLeader", "()Ljava/lang/Boolean;", "setAutoAuthLeader", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getStartNet", "()Z", "setStartNet", "(Z)V", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LeaderAutoAuthInfo implements NonProguard {
    private Boolean autoAuthLeader;
    private boolean startNet;

    /* JADX WARN: Multi-variable type inference failed */
    public LeaderAutoAuthInfo() {
        Boolean r100 = null;
        this(r100, false, 3, 0 == true ? 1 : 0);
    }

    public final Boolean getAutoAuthLeader() {
        return this.autoAuthLeader;
    }

    public final boolean getStartNet() {
        return this.startNet;
    }

    public final void setAutoAuthLeader(Boolean r100) {
        this.autoAuthLeader = r100;
    }

    public final void setStartNet(boolean r100) {
        this.startNet = r100;
    }

    public LeaderAutoAuthInfo(Boolean r100, boolean r101) {
        this.autoAuthLeader = r100;
        this.startNet = r101;
    }

    public /* synthetic */ LeaderAutoAuthInfo(Boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Boolean.FALSE;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = true;
    L8:
        this(r100, r101);
    }
}
