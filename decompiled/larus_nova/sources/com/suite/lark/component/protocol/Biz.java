package com.suite.lark.component.protocol;

import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/suite/lark/component/protocol/Biz;", "", "name", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Passport", "Core", "IM", "KA", "Performance", "Mail", "Meego", "OpenPlatform", "Search", "Security", ServiceType.BASIC_TEC, "Todo", "VC", "UG", "Minutes", "Calendar", "CCM", "Common", "lark-protocol_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Biz extends Enum<Biz> {
    public static final Biz CCM = null;
    public static final Biz Calendar = null;
    public static final Biz Common = null;
    public static final Biz Core = null;
    public static final Biz IM = null;
    public static final Biz Infra = null;
    public static final Biz KA = null;
    public static final Biz Mail = null;
    public static final Biz Meego = null;
    public static final Biz Minutes = null;
    public static final Biz OpenPlatform = null;
    public static final Biz Passport = null;
    public static final Biz Performance = null;
    public static final Biz Search = null;
    public static final Biz Security = null;
    public static final Biz Todo = null;
    public static final Biz UG = null;
    public static final Biz VC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Biz[] f460418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f460419b = null;

    public static EnumEntries<Biz> getEntries() {
        return f460419b;
    }

    static {
        Biz r100 = new Biz("Passport", 0);
        Passport = r100;
        Biz r101 = new Biz("Core", 1);
        Core = r101;
        Biz r102 = new Biz("IM", 2);
        IM = r102;
        Biz r103 = new Biz("KA", 3);
        KA = r103;
        Biz r104 = new Biz("Performance", 4);
        Performance = r104;
        Biz r105 = new Biz("Mail", 5);
        Mail = r105;
        Biz r110 = new Biz("Meego", 6);
        Meego = r110;
        Biz r111 = new Biz("OpenPlatform", 7);
        OpenPlatform = r111;
        Biz r112 = new Biz("Search", 8);
        Search = r112;
        Biz r113 = new Biz("Security", 9);
        Security = r113;
        Biz r114 = new Biz(ServiceType.BASIC_TEC, 10);
        Infra = r114;
        Biz r115 = new Biz("Todo", 11);
        Todo = r115;
        Biz r106 = new Biz("VC", 12);
        VC = r106;
        Biz r107 = new Biz("UG", 13);
        UG = r107;
        Biz r108 = new Biz("Minutes", 14);
        Minutes = r108;
        Biz r109 = new Biz("Calendar", 15);
        Calendar = r109;
        Biz r116 = new Biz("CCM", 16);
        CCM = r116;
        Biz r117 = new Biz("Common", 17);
        Common = r117;
        Biz[] r118 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117};
        f460418a = r118;
        f460419b = EnumEntriesKt.enumEntries(r118);
    }

    public static Biz[] values() {
        return (Biz[]) f460418a.clone();
    }

    public static Biz valueOf(String r100) {
        return (Biz) a.a(Biz.class, r100);
    }

    public Biz(String r100, int r101) {
        super(r100, r101);
    }
}
