package com.bytedance.applog.log;

import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class k$a extends ThreadLocal<SimpleDateFormat> {
    @Override // java.lang.ThreadLocal
    public final SimpleDateFormat initialValue() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public k$a() {
    }
}
