package com.larus.home.impl.main.side_bar.view.group.render;

import com.larus.nova.R;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/larus/home/impl/main/side_bar/view/group/render/SkeletonSection;", "", "titleRes", "", "skeletonRowCount", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;I)V", "getTitleRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSkeletonRowCount", "()I", "ARCHIVED", "PINNED", "SOCIAL", "SOCIAL_ENTERPRISE", "PROJECT", "CONVERSATION", "TODAY", "YESTERDAY", FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SkeletonSection extends Enum<SkeletonSection> {
    public static final SkeletonSection ARCHIVED = null;
    public static final SkeletonSection CONVERSATION = null;
    public static final SkeletonSection DEVICE = null;
    public static final SkeletonSection PINNED = null;
    public static final SkeletonSection PROJECT = null;
    public static final SkeletonSection SOCIAL = null;
    public static final SkeletonSection SOCIAL_ENTERPRISE = null;
    public static final SkeletonSection TODAY = null;
    public static final SkeletonSection YESTERDAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SkeletonSection[] f345600a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f345601b = null;
    private final int skeletonRowCount;
    private final Integer titleRes;

    public static EnumEntries<SkeletonSection> getEntries() {
        return f345601b;
    }

    static {
        SkeletonSection r100 = new SkeletonSection("ARCHIVED", 0, Integer.valueOf(R.string.larus_infra_archiveChat_navBar_groupOption_hidden), 2);
        ARCHIVED = r100;
        SkeletonSection r101 = new SkeletonSection("PINNED", 1, Integer.valueOf(R.string.larus_pin_chat), 2);
        PINNED = r101;
        SkeletonSection r102 = new SkeletonSection("SOCIAL", 2, Integer.valueOf(R.string.larus_groupChats_navBar_header_convo), 2);
        SOCIAL = r102;
        SkeletonSection r103 = new SkeletonSection("SOCIAL_ENTERPRISE", 3, Integer.valueOf(R.string.larus_groupChats_navBar_header_feishuChat), 2);
        SOCIAL_ENTERPRISE = r103;
        SkeletonSection r104 = new SkeletonSection("PROJECT", 4, Integer.valueOf(R.string.larus_groupChats_navBar_entry_group_byProject), 3);
        PROJECT = r104;
        SkeletonSection r105 = new SkeletonSection("CONVERSATION", 5, Integer.valueOf(R.string.larus_groupChats_navBar_chatGroup_recents), 5);
        CONVERSATION = r105;
        SkeletonSection r110 = new SkeletonSection("TODAY", 6, Integer.valueOf(R.string.larus_LarkIM_Common_Today_Text), 3);
        TODAY = r110;
        SkeletonSection r111 = new SkeletonSection("YESTERDAY", 7, Integer.valueOf(R.string.larus_LarkIM_Common_Yesterday_Text), 4);
        YESTERDAY = r111;
        SkeletonSection r112 = new SkeletonSection(FeatureConfigInfo.DEVICE_FEATURE_TYPE_ID, 8, null, 3);
        DEVICE = r112;
        SkeletonSection[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f345600a = r113;
        f345601b = EnumEntriesKt.enumEntries(r113);
    }

    public static SkeletonSection[] values() {
        return (SkeletonSection[]) f345600a.clone();
    }

    public final int getSkeletonRowCount() {
        return this.skeletonRowCount;
    }

    public final Integer getTitleRes() {
        return this.titleRes;
    }

    public static SkeletonSection valueOf(String r100) {
        return (SkeletonSection) r27.a.a(SkeletonSection.class, r100);
    }

    public SkeletonSection(String r100, int r101, Integer r102, int r103) {
        super(r100, r101);
        this.titleRes = r102;
        this.skeletonRowCount = r103;
    }
}
