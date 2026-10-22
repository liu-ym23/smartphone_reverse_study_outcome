package com.obric.assistant.state.api.multitask.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;", "", "<init>", "(Ljava/lang/String;I)V", "NullMode", "DefaultMode", "TextMode", "RealtimeCallMode", "ManualHalfDuplex", "AutoHalfDuplex", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricInteractionType extends Enum<ObricInteractionType> {
    public static final ObricInteractionType AutoHalfDuplex = null;
    public static final ObricInteractionType DefaultMode = null;
    public static final ObricInteractionType ManualHalfDuplex = null;
    public static final ObricInteractionType NullMode = null;
    public static final ObricInteractionType RealtimeCallMode = null;
    public static final ObricInteractionType TextMode = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricInteractionType[] f392957a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392958b = null;

    public static EnumEntries<ObricInteractionType> getEntries() {
        return f392958b;
    }

    static {
        ObricInteractionType r100 = new ObricInteractionType("NullMode", 0);
        NullMode = r100;
        ObricInteractionType r101 = new ObricInteractionType("DefaultMode", 1);
        DefaultMode = r101;
        ObricInteractionType r102 = new ObricInteractionType("TextMode", 2);
        TextMode = r102;
        ObricInteractionType r103 = new ObricInteractionType("RealtimeCallMode", 3);
        RealtimeCallMode = r103;
        ObricInteractionType r104 = new ObricInteractionType("ManualHalfDuplex", 4);
        ManualHalfDuplex = r104;
        ObricInteractionType r105 = new ObricInteractionType("AutoHalfDuplex", 5);
        AutoHalfDuplex = r105;
        ObricInteractionType[] r110 = {r100, r101, r102, r103, r104, r105};
        f392957a = r110;
        f392958b = EnumEntriesKt.enumEntries(r110);
    }

    public static ObricInteractionType[] values() {
        return (ObricInteractionType[]) f392957a.clone();
    }

    public static ObricInteractionType valueOf(String r100) {
        return (ObricInteractionType) a.a(ObricInteractionType.class, r100);
    }

    public ObricInteractionType(String r100, int r101) {
        super(r100, r101);
    }
}
