package com.larus.network.quota;

import android.util.EventsUtils;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.xmlpull.v1.XmlPullParser;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/network/quota/AppStartState;", XmlPullParser.NO_NAMESPACE, "value", XmlPullParser.NO_NAMESPACE, "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "NormalStart", "ColdStart", "HotStart", "WarmStart", "ttnet_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final enum AppStartState extends Enum<AppStartState> {
    public static final AppStartState ColdStart = null;
    public static final AppStartState HotStart = null;
    public static final AppStartState NormalStart = null;
    public static final AppStartState WarmStart = null;
    public static final /* synthetic */ AppStartState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static EnumEntries<AppStartState> getEntries() {
        return b;
    }

    static {
        AppStartState r0 = new AppStartState("NormalStart", 0, -1);
        NormalStart = r0;
        AppStartState r1 = new AppStartState("ColdStart", 1, 0);
        ColdStart = r1;
        AppStartState r2 = new AppStartState("HotStart", 2, 1);
        HotStart = r2;
        AppStartState r5 = new AppStartState("WarmStart", 3, 2);
        WarmStart = r5;
        AppStartState[] r7 = {r0, r1, r2, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static AppStartState[] values() {
        return (AppStartState[]) a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static AppStartState valueOf(String r1) {
        return (AppStartState) a.a(AppStartState.class, r1);
    }

    public AppStartState(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
