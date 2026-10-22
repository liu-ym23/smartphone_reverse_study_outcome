package com.bytedance.lego.init.model;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
public final enum ExecutionPeriod extends Enum<ExecutionPeriod> {
    public static final ExecutionPeriod MAIN_ON_ANY = null;
    public static final ExecutionPeriod MAIN_ON_CREATE = null;
    public static final ExecutionPeriod MAIN_ON_DESTROY = null;
    public static final ExecutionPeriod MAIN_ON_PAUSE = null;
    public static final ExecutionPeriod MAIN_ON_RESUME = null;
    public static final ExecutionPeriod MAIN_ON_START = null;
    public static final ExecutionPeriod MAIN_ON_STOP = null;
    public static final ExecutionPeriod SPLASH_ON_ANY = null;
    public static final ExecutionPeriod SPLASH_ON_CREATE = null;
    public static final ExecutionPeriod SPLASH_ON_DESTROY = null;
    public static final ExecutionPeriod SPLASH_ON_PAUSE = null;
    public static final ExecutionPeriod SPLASH_ON_RESUME = null;
    public static final ExecutionPeriod SPLASH_ON_START = null;
    public static final ExecutionPeriod SPLASH_ON_STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExecutionPeriod[] f254534a = null;

    static {
        ExecutionPeriod r100 = new ExecutionPeriod("SPLASH_ON_CREATE", 0);
        SPLASH_ON_CREATE = r100;
        ExecutionPeriod r101 = new ExecutionPeriod("SPLASH_ON_START", 1);
        SPLASH_ON_START = r101;
        ExecutionPeriod r102 = new ExecutionPeriod("SPLASH_ON_RESUME", 2);
        SPLASH_ON_RESUME = r102;
        ExecutionPeriod r103 = new ExecutionPeriod("SPLASH_ON_PAUSE", 3);
        SPLASH_ON_PAUSE = r103;
        ExecutionPeriod r104 = new ExecutionPeriod("SPLASH_ON_STOP", 4);
        SPLASH_ON_STOP = r104;
        ExecutionPeriod r105 = new ExecutionPeriod("SPLASH_ON_DESTROY", 5);
        SPLASH_ON_DESTROY = r105;
        ExecutionPeriod r110 = new ExecutionPeriod("SPLASH_ON_ANY", 6);
        SPLASH_ON_ANY = r110;
        ExecutionPeriod r111 = new ExecutionPeriod("MAIN_ON_CREATE", 7);
        MAIN_ON_CREATE = r111;
        ExecutionPeriod r112 = new ExecutionPeriod("MAIN_ON_START", 8);
        MAIN_ON_START = r112;
        ExecutionPeriod r113 = new ExecutionPeriod("MAIN_ON_RESUME", 9);
        MAIN_ON_RESUME = r113;
        ExecutionPeriod r114 = new ExecutionPeriod("MAIN_ON_PAUSE", 10);
        MAIN_ON_PAUSE = r114;
        ExecutionPeriod r115 = new ExecutionPeriod("MAIN_ON_STOP", 11);
        MAIN_ON_STOP = r115;
        ExecutionPeriod r106 = new ExecutionPeriod("MAIN_ON_DESTROY", 12);
        MAIN_ON_DESTROY = r106;
        ExecutionPeriod r107 = new ExecutionPeriod("MAIN_ON_ANY", 13);
        MAIN_ON_ANY = r107;
        f254534a = new ExecutionPeriod[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107};
    }

    public static ExecutionPeriod[] values() {
        return (ExecutionPeriod[]) f254534a.clone();
    }

    public static ExecutionPeriod from(String r100) {
        r100.getClass();
        byte r101 = -1;
        switch(r100.hashCode()) {
            case -1604499520: goto L58;
            case -364577614: goto L54;
            case 236883538: goto L50;
            case 735015050: goto L46;
            case 901014614: goto L42;
            case 1307299406: goto L38;
            case 1310616762: goto L34;
            case 1318882183: goto L30;
            case 1514603396: goto L26;
            case 1583537628: goto L22;
            case 1824808004: goto L18;
            case 1841695548: goto L14;
            case 1845012904: goto L10;
            case 1932470965: goto L6;
            default: goto L61;
        };
    L61:
        switch(r101) {
            case 0: goto L91;
            case 1: goto L89;
            case 2: goto L87;
            case 3: goto L85;
            case 4: goto L83;
            case 5: goto L81;
            case 6: goto L79;
            case 7: goto L77;
            case 8: goto L75;
            case 9: goto L73;
            case 10: goto L71;
            case 11: goto L69;
            case 12: goto L67;
            case 13: goto L65;
            default: goto L62;
        };
    L62:
        return null;
    L65:
        return SPLASH_ON_RESUME;
    L67:
        return MAIN_ON_START;
    L69:
        return MAIN_ON_PAUSE;
    L71:
        return SPLASH_ON_ANY;
    L73:
        return MAIN_ON_STOP;
    L75:
        return SPLASH_ON_CREATE;
    L77:
        return MAIN_ON_RESUME;
    L79:
        return SPLASH_ON_START;
    L81:
        return SPLASH_ON_PAUSE;
    L83:
        return MAIN_ON_CREATE;
    L85:
        return SPLASH_ON_STOP;
    L87:
        return SPLASH_ON_DESTROY;
    L89:
        return MAIN_ON_ANY;
    L91:
        return MAIN_ON_DESTROY;
    L6:
        if (r100.equals("SPLASH_ON_RESUME") == false) goto L61;
        r101 = HTTP.CR;
        goto L61
    L10:
        if (r100.equals("MAIN_ON_START") == false) goto L61;
        r101 = 12;
        goto L61
    L14:
        if (r100.equals("MAIN_ON_PAUSE") == false) goto L61;
        r101 = 11;
        goto L61
    L18:
        if (r100.equals("SPLASH_ON_ANY") == false) goto L61;
        r101 = 10;
        goto L61
    L22:
        if (r100.equals("MAIN_ON_STOP") == false) goto L61;
        r101 = 9;
        goto L61
    L26:
        if (r100.equals("SPLASH_ON_CREATE") == false) goto L61;
        r101 = 8;
        goto L61
    L30:
        if (r100.equals("MAIN_ON_RESUME") == false) goto L61;
        r101 = 7;
        goto L61
    L34:
        if (r100.equals("SPLASH_ON_START") == false) goto L61;
        r101 = 6;
        goto L61
    L38:
        if (r100.equals("SPLASH_ON_PAUSE") == false) goto L61;
        r101 = 5;
        goto L61
    L42:
        if (r100.equals("MAIN_ON_CREATE") == false) goto L61;
        r101 = 4;
        goto L61
    L46:
        if (r100.equals("SPLASH_ON_STOP") == false) goto L61;
        r101 = 3;
        goto L61
    L50:
        if (r100.equals("SPLASH_ON_DESTROY") == false) goto L61;
        r101 = 2;
        goto L61
    L54:
        if (r100.equals("MAIN_ON_ANY") == false) goto L61;
        r101 = 1;
        goto L61
    L58:
        if (r100.equals("MAIN_ON_DESTROY") == false) goto L61;
        r101 = 0;
        goto L61
    }

    public static ExecutionPeriod valueOf(String r100) {
        return (ExecutionPeriod) a.a(ExecutionPeriod.class, r100);
    }

    public ExecutionPeriod(String r100, int r101) {
        super(r100, r101);
    }
}
