package com.ss.android.lark.appreciablelib;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/appreciablelib/Biz;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Messenger", "Search", "Calendar", "Docs", "Driver", "Mail", "OpenPlatform", "UserGrowth", "VideoConference", "Moments", "Core", "Todo", "KnowledgeAI", "appreciablelib_release"}, k = 1, mv = {1, 1, 15})
public final enum Biz extends Enum<Biz> {
    private static final /* synthetic */ Biz[] $VALUES = null;
    public static final Biz Calendar = null;
    public static final Biz Core = null;
    public static final Biz Docs = null;
    public static final Biz Driver = null;
    public static final Biz KnowledgeAI = null;
    public static final Biz Mail = null;
    public static final Biz Messenger = null;
    public static final Biz Moments = null;
    public static final Biz OpenPlatform = null;
    public static final Biz Search = null;
    public static final Biz Todo = null;
    public static final Biz UserGrowth = null;
    public static final Biz VideoConference = null;
    private final int value;

    public static Biz valueOf(String r100) {
        return (Biz) a.a(Biz.class, r100);
    }

    public static Biz[] values() {
        return (Biz[]) $VALUES.clone();
    }

    static {
        Biz r100 = new Biz("Messenger", 0, 1);
        Messenger = r100;
        Biz r101 = new Biz("Search", 1, 2);
        Search = r101;
        Biz r102 = new Biz("Calendar", 2, 3);
        Calendar = r102;
        Biz r103 = new Biz("Docs", 3, 4);
        Docs = r103;
        Biz r104 = new Biz("Driver", 4, 5);
        Driver = r104;
        Biz r105 = new Biz("Mail", 5, 6);
        Mail = r105;
        Biz r106 = new Biz("OpenPlatform", 6, 7);
        OpenPlatform = r106;
        Biz r107 = new Biz("UserGrowth", 7, 8);
        UserGrowth = r107;
        Biz r108 = new Biz("VideoConference", 8, 9);
        VideoConference = r108;
        Biz r109 = new Biz("Moments", 9, 10);
        Moments = r109;
        Biz r110 = new Biz("Core", 10, 11);
        Core = r110;
        Biz r111 = new Biz("Todo", 11, 12);
        Todo = r111;
        Biz r112 = new Biz("KnowledgeAI", 12, 13);
        KnowledgeAI = r112;
        $VALUES = new Biz[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final int getValue() {
        return this.value;
    }

    private Biz(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
