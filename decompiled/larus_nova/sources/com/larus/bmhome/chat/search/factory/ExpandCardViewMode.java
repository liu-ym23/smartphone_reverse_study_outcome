package com.larus.bmhome.chat.search.factory;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/bmhome/chat/search/factory/ExpandCardViewMode;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "EXPAND", "NORMAL_SHARE", "EXPAND_SHARE", "NORMAL_PIC", "EXPAND_PIC", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExpandCardViewMode extends Enum<ExpandCardViewMode> {
    public static final ExpandCardViewMode EXPAND = null;
    public static final ExpandCardViewMode EXPAND_PIC = null;
    public static final ExpandCardViewMode EXPAND_SHARE = null;
    public static final ExpandCardViewMode NORMAL = null;
    public static final ExpandCardViewMode NORMAL_PIC = null;
    public static final ExpandCardViewMode NORMAL_SHARE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExpandCardViewMode[] f308629a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308630b = null;

    public static EnumEntries<ExpandCardViewMode> getEntries() {
        return f308630b;
    }

    static {
        ExpandCardViewMode r100 = new ExpandCardViewMode(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        ExpandCardViewMode r101 = new ExpandCardViewMode("EXPAND", 1);
        EXPAND = r101;
        ExpandCardViewMode r102 = new ExpandCardViewMode("NORMAL_SHARE", 2);
        NORMAL_SHARE = r102;
        ExpandCardViewMode r103 = new ExpandCardViewMode("EXPAND_SHARE", 3);
        EXPAND_SHARE = r103;
        ExpandCardViewMode r104 = new ExpandCardViewMode("NORMAL_PIC", 4);
        NORMAL_PIC = r104;
        ExpandCardViewMode r105 = new ExpandCardViewMode("EXPAND_PIC", 5);
        EXPAND_PIC = r105;
        ExpandCardViewMode[] r110 = {r100, r101, r102, r103, r104, r105};
        f308629a = r110;
        f308630b = EnumEntriesKt.enumEntries(r110);
    }

    public static ExpandCardViewMode[] values() {
        return (ExpandCardViewMode[]) f308629a.clone();
    }

    public static ExpandCardViewMode valueOf(String r100) {
        return (ExpandCardViewMode) a.a(ExpandCardViewMode.class, r100);
    }

    public ExpandCardViewMode(String r100, int r101) {
        super(r100, r101);
    }
}
