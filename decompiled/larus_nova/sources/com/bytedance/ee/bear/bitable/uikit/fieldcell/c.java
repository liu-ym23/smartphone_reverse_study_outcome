package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public class c implements g0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f216163a = null;

        static {
            int[] r100 = new int[EFieldUIType.values().length];
            r100[EFieldUIType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L32
        L75:
            r100[EFieldUIType.SINGLE_SELECT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L33
        L85:
            r100[EFieldUIType.MULTI_SELECT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L34
        L91:
            r100[EFieldUIType.USER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L35
        L95:
            r100[EFieldUIType.CREATED_USER.ordinal()] = 5;     // Catch: NoSuchFieldError -> L36
        L99:
            r100[EFieldUIType.MODIFIED_USER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L37
        L109:
            r100[EFieldUIType.GROUP.ordinal()] = 7;     // Catch: NoSuchFieldError -> L38
        L67:
            r100[EFieldUIType.DATE_TIME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L39
        L77:
            r100[EFieldUIType.MODIFIED_TIME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L40
        L79:
            r100[EFieldUIType.CREATED_TIME.ordinal()] = 10;     // Catch: NoSuchFieldError -> L41
        L87:
            r100[EFieldUIType.URL.ordinal()] = 11;     // Catch: NoSuchFieldError -> L42
        L103:
            r100[EFieldUIType.NUMBER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L43
        L111:
            r100[EFieldUIType.AUTO_NUMBER.ordinal()] = 13;     // Catch: NoSuchFieldError -> L44
        L59:
            r100[EFieldUIType.BARCODE.ordinal()] = 14;     // Catch: NoSuchFieldError -> L45
        L65:
            r100[EFieldUIType.LOCATION.ordinal()] = 15;     // Catch: NoSuchFieldError -> L46
        L83:
            r100[EFieldUIType.CURRENCY.ordinal()] = 16;     // Catch: NoSuchFieldError -> L47
        L89:
            r100[EFieldUIType.PHONE.ordinal()] = 17;     // Catch: NoSuchFieldError -> L48
        L93:
            r100[EFieldUIType.EMAIL.ordinal()] = 18;     // Catch: NoSuchFieldError -> L49
        L101:
            r100[EFieldUIType.BUTTON.ordinal()] = 19;     // Catch: NoSuchFieldError -> L50
        L63:
            r100[EFieldUIType.STAGE.ordinal()] = 20;     // Catch: NoSuchFieldError -> L51
        L71:
            r100[EFieldUIType.DUPLEX_LINK.ordinal()] = 21;     // Catch: NoSuchFieldError -> L52
        L73:
            r100[EFieldUIType.SINGLE_LINK.ordinal()] = 22;     // Catch: NoSuchFieldError -> L53
        L81:
            r100[EFieldUIType.CHECKBOX.ordinal()] = 23;     // Catch: NoSuchFieldError -> L54
        L97:
            r100[EFieldUIType.ATTACHMENT.ordinal()] = 24;     // Catch: NoSuchFieldError -> L55
        L105:
            r100[EFieldUIType.SIGNATURE.ordinal()] = 25;     // Catch: NoSuchFieldError -> L56
        L107:
            r100[EFieldUIType.PROGRESS.ordinal()] = 26;     // Catch: NoSuchFieldError -> L57
        L61:
            r100[EFieldUIType.RATING.ordinal()] = 27;     // Catch: NoSuchFieldError -> L58
        L30:
            f216163a = r100;
        }
    }

    public c() {
    }

    @Override // com.bytedance.ee.bear.bitable.uikit.fieldcell.g0
    public b<h0> a(EFieldUIType r100, iv4.b r101) {
        Intrinsics.checkNotNullParameter(r100, "fieldUIType");
        switch(a.f216163a[r100.ordinal()]) {
            case 1: goto L47;
            case 2: goto L43;
            case 3: goto L39;
            case 4: goto L75;
            case 5: goto L74;
            case 6: goto L73;
            case 7: goto L72;
            case 8: goto L71;
            case 9: goto L70;
            case 10: goto L69;
            case 11: goto L68;
            case 12: goto L67;
            case 13: goto L66;
            case 14: goto L65;
            case 15: goto L64;
            case 16: goto L63;
            case 17: goto L62;
            case 18: goto L61;
            case 19: goto L60;
            case 20: goto L19;
            case 21: goto L15;
            case 22: goto L11;
            case 23: goto L53;
            case 24: goto L52;
            case 25: goto L51;
            case 26: goto L50;
            case 27: goto L49;
            default: goto L48;
        };
    L48:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.x(r101);
    L49:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.p(r101);
    L50:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.o(r101);
    L51:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.t(r101);
    L52:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.a(r101);
    L53:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.c(r101);
    L11:
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L55;
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.n(r101);
    L55:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.m(r101);
    L15:
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L57;
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.n(r101);
    L57:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.m(r101);
    L19:
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L59;
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.w(r101);
    L59:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.v(r101);
    L60:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.b(r101);
    L61:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.u(r101);
    L62:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.u(r101);
    L63:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.u(r101);
    L64:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.u(r101);
    L65:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.u(r101);
    L66:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.u(r101);
    L67:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.u(r101);
    L68:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.u(r101);
    L69:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.d(r101);
    L70:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.d(r101);
    L71:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.d(r101);
    L72:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.y(r101);
    L73:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.y(r101);
    L74:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.y(r101);
    L75:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.y(r101);
    L39:
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L77;
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.s(r101);
    L77:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.r(r101);
    L43:
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L79;
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.s(r101);
    L79:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.r(r101);
    L47:
        return new com.bytedance.ee.bear.bitable.uikit.fieldcell.creator.q(r101);
    }
}
