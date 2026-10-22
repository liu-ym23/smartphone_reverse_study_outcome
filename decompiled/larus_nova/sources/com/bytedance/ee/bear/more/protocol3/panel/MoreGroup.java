package com.bytedance.ee.bear.more.protocol3.panel;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/more/protocol3/panel/MoreGroup;", "", "<init>", "(Ljava/lang/String;I)V", "TOP", EffectConstants.NORMAL, "DANGER", "features-more-panel-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MoreGroup extends Enum<MoreGroup> {
    public static final MoreGroup DANGER = null;
    public static final MoreGroup NORMAL = null;
    public static final MoreGroup TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MoreGroup[] f234913a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f234914b = null;

    public static EnumEntries<MoreGroup> getEntries() {
        return f234914b;
    }

    static {
        MoreGroup r100 = new MoreGroup("TOP", 0);
        TOP = r100;
        MoreGroup r101 = new MoreGroup(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        MoreGroup r102 = new MoreGroup("DANGER", 2);
        DANGER = r102;
        MoreGroup[] r103 = {r100, r101, r102};
        f234913a = r103;
        f234914b = EnumEntriesKt.enumEntries(r103);
    }

    public static MoreGroup[] values() {
        return (MoreGroup[]) f234913a.clone();
    }

    public static MoreGroup valueOf(String r100) {
        return (MoreGroup) r27.a.a(MoreGroup.class, r100);
    }

    public MoreGroup(String r100, int r101) {
        super(r100, r101);
    }
}
