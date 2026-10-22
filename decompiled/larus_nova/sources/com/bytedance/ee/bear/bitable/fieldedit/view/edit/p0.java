package com.bytedance.ee.bear.bitable.fieldedit.view.edit;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;

/* JADX INFO: loaded from: classes15.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f211517a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f211518a = null;

        static {
            int[] r100 = new int[EFieldUIType.values().length];
            r100[EFieldUIType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L71:
            r100[EFieldUIType.BARCODE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L83:
            r100[EFieldUIType.EMAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L53:
            r100[EFieldUIType.NUMBER.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[EFieldUIType.SINGLE_SELECT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L29
        L65:
            r100[EFieldUIType.MULTI_SELECT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L30
        L77:
            r100[EFieldUIType.MODIFIED_TIME.ordinal()] = 7;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[EFieldUIType.DATE_TIME.ordinal()] = 8;     // Catch: NoSuchFieldError -> L32
        L73:
            r100[EFieldUIType.CREATED_TIME.ordinal()] = 9;     // Catch: NoSuchFieldError -> L33
        L75:
            r100[EFieldUIType.SINGLE_LINK.ordinal()] = 10;     // Catch: NoSuchFieldError -> L34
        L47:
            r100[EFieldUIType.DUPLEX_LINK.ordinal()] = 11;     // Catch: NoSuchFieldError -> L35
        L69:
            r100[EFieldUIType.USER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L36
        L81:
            r100[EFieldUIType.GROUP.ordinal()] = 13;     // Catch: NoSuchFieldError -> L37
        L45:
            r100[EFieldUIType.ATTACHMENT.ordinal()] = 14;     // Catch: NoSuchFieldError -> L38
        L59:
            r100[EFieldUIType.SIGNATURE.ordinal()] = 15;     // Catch: NoSuchFieldError -> L39
        L79:
            r100[EFieldUIType.AUTO_NUMBER.ordinal()] = 16;     // Catch: NoSuchFieldError -> L40
        L51:
            r100[EFieldUIType.LOCATION.ordinal()] = 17;     // Catch: NoSuchFieldError -> L41
        L55:
            r100[EFieldUIType.CURRENCY.ordinal()] = 18;     // Catch: NoSuchFieldError -> L42
        L67:
            r100[EFieldUIType.PROGRESS.ordinal()] = 19;     // Catch: NoSuchFieldError -> L43
        L49:
            r100[EFieldUIType.RATING.ordinal()] = 20;     // Catch: NoSuchFieldError -> L44
        L23:
            f211518a = r100;
        }
    }

    static {
    }
}
