package com.ss.android.lark.officewebview.networkproxy;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officewebview/networkproxy/InjectScript;", "", "<init>", "(Ljava/lang/String;I)V", "HTTP_TRAFFIC", "WSS", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InjectScript extends Enum<InjectScript> {
    public static final InjectScript HTTP_TRAFFIC = null;
    public static final InjectScript WSS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ InjectScript[] f437474a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437475b = null;

    public static EnumEntries<InjectScript> getEntries() {
        return f437475b;
    }

    static {
        InjectScript r100 = new InjectScript("HTTP_TRAFFIC", 0);
        HTTP_TRAFFIC = r100;
        InjectScript r101 = new InjectScript("WSS", 1);
        WSS = r101;
        InjectScript[] r102 = {r100, r101};
        f437474a = r102;
        f437475b = EnumEntriesKt.enumEntries(r102);
    }

    public static InjectScript[] values() {
        return (InjectScript[]) f437474a.clone();
    }

    public static InjectScript valueOf(String r100) {
        return (InjectScript) a.a(InjectScript.class, r100);
    }

    public InjectScript(String r100, int r101) {
        super(r100, r101);
    }
}
