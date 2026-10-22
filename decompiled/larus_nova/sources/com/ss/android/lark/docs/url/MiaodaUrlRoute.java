package com.ss.android.lark.docs.url;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/docs/url/MiaodaUrlRoute;", "", "<init>", "(Ljava/lang/String;I)V", "PAGE", "App", "docs-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MiaodaUrlRoute extends Enum<MiaodaUrlRoute> {
    public static final MiaodaUrlRoute App = null;
    public static final MiaodaUrlRoute PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MiaodaUrlRoute[] f420521a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420522b = null;

    public static EnumEntries<MiaodaUrlRoute> getEntries() {
        return f420522b;
    }

    static {
        MiaodaUrlRoute r100 = new MiaodaUrlRoute("PAGE", 0);
        PAGE = r100;
        MiaodaUrlRoute r101 = new MiaodaUrlRoute("App", 1);
        App = r101;
        MiaodaUrlRoute[] r102 = {r100, r101};
        f420521a = r102;
        f420522b = EnumEntriesKt.enumEntries(r102);
    }

    public static MiaodaUrlRoute[] values() {
        return (MiaodaUrlRoute[]) f420521a.clone();
    }

    public static MiaodaUrlRoute valueOf(String r100) {
        return (MiaodaUrlRoute) a.a(MiaodaUrlRoute.class, r100);
    }

    public MiaodaUrlRoute(String r100, int r101) {
        super(r100, r101);
    }
}
