package com.obric.assistant.network.api.bean;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/network/api/bean/IntentShortLinkType;", "", "<init>", "(Ljava/lang/String;I)V", "COMPENSATION", "ASYNC_NOTIFY", EffectConstants.NORMAL, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IntentShortLinkType extends Enum<IntentShortLinkType> {
    public static final IntentShortLinkType ASYNC_NOTIFY = null;
    public static final IntentShortLinkType COMPENSATION = null;
    public static final IntentShortLinkType NORMAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IntentShortLinkType[] f390307a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f390308b = null;

    public static EnumEntries<IntentShortLinkType> getEntries() {
        return f390308b;
    }

    static {
        IntentShortLinkType r100 = new IntentShortLinkType("COMPENSATION", 0);
        COMPENSATION = r100;
        IntentShortLinkType r101 = new IntentShortLinkType("ASYNC_NOTIFY", 1);
        ASYNC_NOTIFY = r101;
        IntentShortLinkType r102 = new IntentShortLinkType(EffectConstants.NORMAL, 2);
        NORMAL = r102;
        IntentShortLinkType[] r103 = {r100, r101, r102};
        f390307a = r103;
        f390308b = EnumEntriesKt.enumEntries(r103);
    }

    public static IntentShortLinkType[] values() {
        return (IntentShortLinkType[]) f390307a.clone();
    }

    public static IntentShortLinkType valueOf(String r100) {
        return (IntentShortLinkType) a.a(IntentShortLinkType.class, r100);
    }

    public IntentShortLinkType(String r100, int r101) {
        super(r100, r101);
    }
}
