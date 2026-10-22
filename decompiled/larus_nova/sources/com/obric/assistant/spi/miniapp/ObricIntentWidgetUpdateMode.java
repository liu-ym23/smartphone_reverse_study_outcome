package com.obric.assistant.spi.miniapp;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/spi/miniapp/ObricIntentWidgetUpdateMode;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "UPDATE_IN_PLACE", "RECREATE", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricIntentWidgetUpdateMode extends Enum<ObricIntentWidgetUpdateMode> {
    public static final ObricIntentWidgetUpdateMode DEFAULT = null;
    public static final ObricIntentWidgetUpdateMode RECREATE = null;
    public static final ObricIntentWidgetUpdateMode UPDATE_IN_PLACE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricIntentWidgetUpdateMode[] f392899a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f392900b = null;

    public static EnumEntries<ObricIntentWidgetUpdateMode> getEntries() {
        return f392900b;
    }

    static {
        ObricIntentWidgetUpdateMode r100 = new ObricIntentWidgetUpdateMode("DEFAULT", 0);
        DEFAULT = r100;
        ObricIntentWidgetUpdateMode r101 = new ObricIntentWidgetUpdateMode("UPDATE_IN_PLACE", 1);
        UPDATE_IN_PLACE = r101;
        ObricIntentWidgetUpdateMode r102 = new ObricIntentWidgetUpdateMode("RECREATE", 2);
        RECREATE = r102;
        ObricIntentWidgetUpdateMode[] r103 = {r100, r101, r102};
        f392899a = r103;
        f392900b = EnumEntriesKt.enumEntries(r103);
    }

    public static ObricIntentWidgetUpdateMode[] values() {
        return (ObricIntentWidgetUpdateMode[]) f392899a.clone();
    }

    public static ObricIntentWidgetUpdateMode valueOf(String r100) {
        return (ObricIntentWidgetUpdateMode) a.a(ObricIntentWidgetUpdateMode.class, r100);
    }

    public ObricIntentWidgetUpdateMode(String r100, int r101) {
        super(r100, r101);
    }
}
