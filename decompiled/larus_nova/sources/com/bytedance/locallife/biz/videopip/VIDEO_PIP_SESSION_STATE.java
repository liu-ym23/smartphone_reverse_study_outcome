package com.bytedance.locallife.biz.videopip;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/biz/videopip/VIDEO_PIP_SESSION_STATE;", "", "NOT_INITIAL", "SHOW", "HIDE", "EXIT", "CLICK", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum VIDEO_PIP_SESSION_STATE extends Enum<VIDEO_PIP_SESSION_STATE> {
    public static final VIDEO_PIP_SESSION_STATE CLICK = null;
    public static final VIDEO_PIP_SESSION_STATE EXIT = null;
    public static final VIDEO_PIP_SESSION_STATE HIDE = null;
    public static final VIDEO_PIP_SESSION_STATE NOT_INITIAL = null;
    public static final VIDEO_PIP_SESSION_STATE SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VIDEO_PIP_SESSION_STATE[] f257007a = null;

    public static VIDEO_PIP_SESSION_STATE valueOf(String r100) {
        return (VIDEO_PIP_SESSION_STATE) r27.a.a(VIDEO_PIP_SESSION_STATE.class, r100);
    }

    public static VIDEO_PIP_SESSION_STATE[] values() {
        return (VIDEO_PIP_SESSION_STATE[]) f257007a.clone();
    }

    static {
        VIDEO_PIP_SESSION_STATE r100 = new VIDEO_PIP_SESSION_STATE("NOT_INITIAL", 0);
        NOT_INITIAL = r100;
        VIDEO_PIP_SESSION_STATE r101 = new VIDEO_PIP_SESSION_STATE("SHOW", 1);
        SHOW = r101;
        VIDEO_PIP_SESSION_STATE r102 = new VIDEO_PIP_SESSION_STATE("HIDE", 2);
        HIDE = r102;
        VIDEO_PIP_SESSION_STATE r103 = new VIDEO_PIP_SESSION_STATE("EXIT", 3);
        EXIT = r103;
        VIDEO_PIP_SESSION_STATE r104 = new VIDEO_PIP_SESSION_STATE("CLICK", 4);
        CLICK = r104;
        f257007a = new VIDEO_PIP_SESSION_STATE[]{r100, r101, r102, r103, r104};
    }

    public VIDEO_PIP_SESSION_STATE(String r100, int r101) {
        super(r100, r101);
    }
}
