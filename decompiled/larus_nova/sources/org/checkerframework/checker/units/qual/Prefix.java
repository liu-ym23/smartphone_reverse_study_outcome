package org.checkerframework.checker.units.qual;

import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum Prefix extends Enum<Prefix> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Prefix[] f525624a = null;
    public static final Prefix atto = null;
    public static final Prefix centi = null;
    public static final Prefix deca = null;
    public static final Prefix deci = null;

    /* JADX INFO: renamed from: exa, reason: collision with root package name */
    public static final Prefix f525625exa = null;
    public static final Prefix femto = null;
    public static final Prefix giga = null;
    public static final Prefix hecto = null;
    public static final Prefix kilo = null;
    public static final Prefix mega = null;
    public static final Prefix micro = null;
    public static final Prefix milli = null;
    public static final Prefix nano = null;
    public static final Prefix one = null;
    public static final Prefix peta = null;
    public static final Prefix pico = null;
    public static final Prefix tera = null;
    public static final Prefix yocto = null;
    public static final Prefix yotta = null;
    public static final Prefix zepto = null;
    public static final Prefix zetta = null;

    static {
        Prefix r100 = new Prefix("yotta", 0);
        yotta = r100;
        Prefix r101 = new Prefix("zetta", 1);
        zetta = r101;
        Prefix r102 = new Prefix("exa", 2);
        f525625exa = r102;
        Prefix r103 = new Prefix("peta", 3);
        peta = r103;
        Prefix r104 = new Prefix("tera", 4);
        tera = r104;
        Prefix r105 = new Prefix("giga", 5);
        giga = r105;
        Prefix r110 = new Prefix("mega", 6);
        mega = r110;
        Prefix r111 = new Prefix("kilo", 7);
        kilo = r111;
        Prefix r112 = new Prefix("hecto", 8);
        hecto = r112;
        Prefix r113 = new Prefix("deca", 9);
        deca = r113;
        Prefix r114 = new Prefix(IPortraitService.TYPE_ONE_PORTRAIT, 10);
        one = r114;
        Prefix r115 = new Prefix("deci", 11);
        deci = r115;
        Prefix r106 = new Prefix("centi", 12);
        centi = r106;
        Prefix r107 = new Prefix("milli", 13);
        milli = r107;
        Prefix r108 = new Prefix("micro", 14);
        micro = r108;
        Prefix r109 = new Prefix("nano", 15);
        nano = r109;
        Prefix r116 = new Prefix("pico", 16);
        pico = r116;
        Prefix r117 = new Prefix("femto", 17);
        femto = r117;
        Prefix r118 = new Prefix("atto", 18);
        atto = r118;
        Prefix r119 = new Prefix("zepto", 19);
        zepto = r119;
        Prefix r120 = new Prefix("yocto", 20);
        yocto = r120;
        f525624a = new Prefix[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120};
    }

    public static Prefix[] values() {
        return (Prefix[]) f525624a.clone();
    }

    public static Prefix valueOf(String r100) {
        return (Prefix) a.a(Prefix.class, r100);
    }

    public Prefix(String r100, int r101) {
        super(r100, r101);
    }
}
