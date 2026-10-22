package com.bytedance.lego.init;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/bytedance/lego/init/IdleTaskConfig;", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "uiThreadTaskNum", "I", "getUiThreadTaskNum", "()I", "nonUIThreadTaskNum", "getNonUIThreadTaskNum", XmlPullParser.NO_NAMESPACE, "autoIdleTask", "Z", "getAutoIdleTask", "()Z", XmlPullParser.NO_NAMESPACE, "bootFinishTimeOut", "J", "getBootFinishTimeOut", "()J", "<init>", "(IIZJ)V", "Companion", "a", "initscheduler_release"}, k = 1, mv = {1, 4, 0})
public final class IdleTaskConfig {
    public static final a Companion = null;
    private static final IdleTaskConfig DEFAULT_IDLETASK_CONFIG = null;
    private static final long IDLE_START_TIME_OUT = 15000;
    private final boolean autoIdleTask;
    private final long bootFinishTimeOut;
    private final int nonUIThreadTaskNum;
    private final int uiThreadTaskNum;

    public static final class a {
        public a() {
        }
    }

    public IdleTaskConfig() {
        this(0, 0, false, 0, 15, null);
    }

    static {
        Companion = new a();
        DEFAULT_IDLETASK_CONFIG = new IdleTaskConfig(0, 0, false, 0, 15, null);
    }

    public static final /* synthetic */ IdleTaskConfig access$getDEFAULT_IDLETASK_CONFIG$cp() {
        return DEFAULT_IDLETASK_CONFIG;
    }

    public final boolean getAutoIdleTask() {
        return this.autoIdleTask;
    }

    public final long getBootFinishTimeOut() {
        return this.bootFinishTimeOut;
    }

    public final int getNonUIThreadTaskNum() {
        return this.nonUIThreadTaskNum;
    }

    public final int getUiThreadTaskNum() {
        return this.uiThreadTaskNum;
    }

    public IdleTaskConfig(int r1, int r2, boolean r3, long r4) {
        this.uiThreadTaskNum = r1;
        this.nonUIThreadTaskNum = r2;
        this.autoIdleTask = r3;
        this.bootFinishTimeOut = r4;
    }

    public /* synthetic */ IdleTaskConfig(int r3, int r4, boolean r5, long r6, int r8, DefaultConstructorMarker r9) {
        int r0 = 1;
        if ((r8 & 1) == 0) goto L5;
        int r10 = 1;
    L7:
        if ((r8 & 2) != 0) goto L11;
        r0 = r4;
    L11:
        if ((r8 & 4) == 0) goto L13;
        boolean r1 = false;
    L15:
        if ((r8 & 8) == 0) goto L17;
        r6 = IDLE_START_TIME_OUT;
    L17:
        long r7 = r6;
        this(r10, r0, r1, r7);
        return;
    L13:
        r1 = r5;
        goto L15
    L5:
        r10 = r3;
        goto L7
    }
}
