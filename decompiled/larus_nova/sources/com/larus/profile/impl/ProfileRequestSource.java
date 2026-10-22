package com.larus.profile.impl;

import com.bytedance.android.shopping.mall.feed.help.GYLFetchType;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/profile/impl/ProfileRequestSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "MINE_INIT", "OTHERS_INIT", "RETRY", "REFRESH", "LOAD_MORE", "BLOCK_USER_UPDATE", "LAZY_LOAD", "HOT_LAUNCH", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ProfileRequestSource extends Enum<ProfileRequestSource> {
    public static final ProfileRequestSource BLOCK_USER_UPDATE = null;
    public static final ProfileRequestSource HOT_LAUNCH = null;
    public static final ProfileRequestSource LAZY_LOAD = null;
    public static final ProfileRequestSource LOAD_MORE = null;
    public static final ProfileRequestSource MINE_INIT = null;
    public static final ProfileRequestSource OTHERS_INIT = null;
    public static final ProfileRequestSource REFRESH = null;
    public static final ProfileRequestSource RETRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ProfileRequestSource[] f366054a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f366055b = null;
    private final String value;

    public static EnumEntries<ProfileRequestSource> getEntries() {
        return f366055b;
    }

    static {
        ProfileRequestSource r100 = new ProfileRequestSource("MINE_INIT", 0, "mine_init");
        MINE_INIT = r100;
        ProfileRequestSource r101 = new ProfileRequestSource("OTHERS_INIT", 1, "others_init");
        OTHERS_INIT = r101;
        ProfileRequestSource r102 = new ProfileRequestSource("RETRY", 2, EventConstant.Value.RETRY);
        RETRY = r102;
        ProfileRequestSource r103 = new ProfileRequestSource("REFRESH", 3, "refresh");
        REFRESH = r103;
        ProfileRequestSource r104 = new ProfileRequestSource("LOAD_MORE", 4, GYLFetchType.LOAD_MORE);
        LOAD_MORE = r104;
        ProfileRequestSource r105 = new ProfileRequestSource("BLOCK_USER_UPDATE", 5, "block_user_update");
        BLOCK_USER_UPDATE = r105;
        ProfileRequestSource r110 = new ProfileRequestSource("LAZY_LOAD", 6, "lazy_load");
        LAZY_LOAD = r110;
        ProfileRequestSource r111 = new ProfileRequestSource("HOT_LAUNCH", 7, "hot_launch");
        HOT_LAUNCH = r111;
        ProfileRequestSource[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f366054a = r112;
        f366055b = EnumEntriesKt.enumEntries(r112);
    }

    public static ProfileRequestSource[] values() {
        return (ProfileRequestSource[]) f366054a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ProfileRequestSource valueOf(String r100) {
        return (ProfileRequestSource) r27.a.a(ProfileRequestSource.class, r100);
    }

    public ProfileRequestSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
