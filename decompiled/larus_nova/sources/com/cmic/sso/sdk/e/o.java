package com.cmic.sso.sdk.e;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes22.dex */
public class o {
    public static String a() {
        Date r100 = new Date(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(r100);
    }
}
