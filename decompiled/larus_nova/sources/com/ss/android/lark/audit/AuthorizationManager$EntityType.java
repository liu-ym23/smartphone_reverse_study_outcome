package com.ss.android.lark.audit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes34.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface AuthorizationManager$EntityType {
    public static final int ANY = 1;
    public static final int CCM_BITABLE = 8;
    public static final int CCM_DOC = 6;
    public static final int CCM_FILE = 10;
    public static final int CCM_MINDNOTE = 9;
    public static final int CCM_SHEET = 7;
    public static final int CCM_SLIDE = 11;
    public static final int ENTITY_TYPE_UNKNOWN = 0;
    public static final int IM_FILE = 5;
    public static final int IM_IMAGE = 3;
    public static final int IM_VIDEO = 4;
    public static final int USER = 2;
}
