package com.ss.android.ugc.aweme.mvp.model;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LiveDataWrapper$STATUS extends Enum<LiveDataWrapper$STATUS> {
    public static final LiveDataWrapper$STATUS ERROR = null;
    public static final LiveDataWrapper$STATUS INIT = null;
    public static final LiveDataWrapper$STATUS LOADING = null;
    public static final LiveDataWrapper$STATUS PROGRESS = null;
    public static final LiveDataWrapper$STATUS SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LiveDataWrapper$STATUS[] f451292a = null;

    static {
        LiveDataWrapper$STATUS r100 = new LiveDataWrapper$STATUS(ErrorCode.INIT, 0);
        INIT = r100;
        LiveDataWrapper$STATUS r101 = new LiveDataWrapper$STATUS("SUCCESS", 1);
        SUCCESS = r101;
        LiveDataWrapper$STATUS r102 = new LiveDataWrapper$STATUS("ERROR", 2);
        ERROR = r102;
        LiveDataWrapper$STATUS r103 = new LiveDataWrapper$STATUS("LOADING", 3);
        LOADING = r103;
        LiveDataWrapper$STATUS r104 = new LiveDataWrapper$STATUS("PROGRESS", 4);
        PROGRESS = r104;
        f451292a = new LiveDataWrapper$STATUS[]{r100, r101, r102, r103, r104};
    }

    public static LiveDataWrapper$STATUS[] values() {
        return (LiveDataWrapper$STATUS[]) f451292a.clone();
    }

    public static LiveDataWrapper$STATUS valueOf(String r100) {
        return (LiveDataWrapper$STATUS) a.a(LiveDataWrapper$STATUS.class, r100);
    }

    public LiveDataWrapper$STATUS(String r100, int r101) {
        super(r100, r101);
    }
}
