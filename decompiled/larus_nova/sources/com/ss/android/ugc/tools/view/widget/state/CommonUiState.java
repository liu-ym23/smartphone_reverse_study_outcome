package com.ss.android.ugc.tools.view.widget.state;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/ugc/tools/view/widget/state/CommonUiState;", "", UserProfileEvent.POSITION_NONE, "LOADING", "EMPTY", "ERROR", "lib-runtime_release"}, k = 1, mv = {1, 4, 1})
public final enum CommonUiState extends Enum<CommonUiState> {
    public static final CommonUiState EMPTY = null;
    public static final CommonUiState ERROR = null;
    public static final CommonUiState LOADING = null;
    public static final CommonUiState NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonUiState[] f455139a = null;

    static {
        CommonUiState r100 = new CommonUiState(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        CommonUiState r101 = new CommonUiState("LOADING", 1);
        LOADING = r101;
        CommonUiState r102 = new CommonUiState("EMPTY", 2);
        EMPTY = r102;
        CommonUiState r103 = new CommonUiState("ERROR", 3);
        ERROR = r103;
        f455139a = new CommonUiState[]{r100, r101, r102, r103};
    }

    public static CommonUiState valueOf(String r100) {
        return (CommonUiState) r27.a.a(CommonUiState.class, r100);
    }

    public static CommonUiState[] values() {
        return (CommonUiState[]) f455139a.clone();
    }

    public CommonUiState(String r100, int r101) {
        super(r100, r101);
    }
}
