package com.bytedance.ee.bear.bitable.filter.step.impl.valueedit;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldType;

/* JADX INFO: loaded from: classes15.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f211994a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f211995a = null;

        static {
            int[] r100 = new int[EFieldType.values().length];
            r100[EFieldType.NUMBER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L20
        L53:
            r100[EFieldType.AUTO_NUMBER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L21
        L63:
            r100[EFieldType.PHONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L22
        L39:
            r100[EFieldType.DATE_TIME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L23
        L41:
            r100[EFieldType.CREATED_TIME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L24
        L49:
            r100[EFieldType.MODIFIED_TIME.ordinal()] = 6;     // Catch: NoSuchFieldError -> L25
        L59:
            r100[EFieldType.SINGLE_SELECT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L26
        L45:
            r100[EFieldType.MULTI_SELECT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L27
        L55:
            r100[EFieldType.STAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L28
        L57:
            r100[EFieldType.USER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L29
        L37:
            r100[EFieldType.CREATED_USER.ordinal()] = 11;     // Catch: NoSuchFieldError -> L30
        L51:
            r100[EFieldType.MODIFIED_USER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L31
        L61:
            r100[EFieldType.GROUP.ordinal()] = 13;     // Catch: NoSuchFieldError -> L32
        L35:
            r100[EFieldType.SINGLE_LINK.ordinal()] = 14;     // Catch: NoSuchFieldError -> L33
        L43:
            r100[EFieldType.DUPLEX_LINK.ordinal()] = 15;     // Catch: NoSuchFieldError -> L34
        L18:
            f211995a = r100;
        }
    }

    static {
    }
}
