package com.ss.android.lark.chameleonv2.container.webcontainer.plugin.biz.blankcheck;

import com.alibaba.gaiax.model.GXAnimation;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/plugin/biz/blankcheck/LoadState;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", UserProfileEvent.POSITION_NONE, GXAnimation.STATE_START, "PAGE_STARTED", "SUCCESS", "FAIL", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LoadState extends Enum<LoadState> {
    public static final LoadState FAIL = null;
    public static final LoadState NONE = null;
    public static final LoadState PAGE_STARTED = null;
    public static final LoadState START = null;
    public static final LoadState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LoadState[] f411221a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f411222b = null;
    private final String type;

    public static EnumEntries<LoadState> getEntries() {
        return f411222b;
    }

    static {
        LoadState r100 = new LoadState(UserProfileEvent.POSITION_NONE, 0, "none");
        NONE = r100;
        LoadState r101 = new LoadState(GXAnimation.STATE_START, 1, "start");
        START = r101;
        LoadState r102 = new LoadState("PAGE_STARTED", 2, "page_start");
        PAGE_STARTED = r102;
        LoadState r103 = new LoadState("SUCCESS", 3, "success");
        SUCCESS = r103;
        LoadState r104 = new LoadState("FAIL", 4, "fail");
        FAIL = r104;
        LoadState[] r105 = {r100, r101, r102, r103, r104};
        f411221a = r105;
        f411222b = EnumEntriesKt.enumEntries(r105);
    }

    public static LoadState[] values() {
        return (LoadState[]) f411221a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static LoadState valueOf(String r100) {
        return (LoadState) r27.a.a(LoadState.class, r100);
    }

    public LoadState(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
