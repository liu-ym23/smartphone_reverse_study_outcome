package com.larus.common_ui.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/common_ui/presentation/UiPresentationChannel;", "", "<init>", "(Ljava/lang/String;I)V", "REACH", "LEGACY_ACTIVITY_NOTIFICATION", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UiPresentationChannel extends Enum<UiPresentationChannel> {
    public static final UiPresentationChannel LEGACY_ACTIVITY_NOTIFICATION = null;
    public static final UiPresentationChannel REACH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UiPresentationChannel[] f327770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f327771b = null;

    public static EnumEntries<UiPresentationChannel> getEntries() {
        return f327771b;
    }

    static {
        UiPresentationChannel r100 = new UiPresentationChannel("REACH", 0);
        REACH = r100;
        UiPresentationChannel r101 = new UiPresentationChannel("LEGACY_ACTIVITY_NOTIFICATION", 1);
        LEGACY_ACTIVITY_NOTIFICATION = r101;
        UiPresentationChannel[] r102 = {r100, r101};
        f327770a = r102;
        f327771b = EnumEntriesKt.enumEntries(r102);
    }

    public static UiPresentationChannel[] values() {
        return (UiPresentationChannel[]) f327770a.clone();
    }

    public static UiPresentationChannel valueOf(String r100) {
        return (UiPresentationChannel) a.a(UiPresentationChannel.class, r100);
    }

    public UiPresentationChannel(String r100, int r101) {
        super(r100, r101);
    }
}
