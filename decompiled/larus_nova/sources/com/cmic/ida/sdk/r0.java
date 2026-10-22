package com.cmic.ida.sdk;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes22.dex */
public class r0 {
    public static String a() {
        Date r100 = new Date(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(r100);
    }
}
