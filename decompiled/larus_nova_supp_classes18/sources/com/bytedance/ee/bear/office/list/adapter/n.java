package com.bytedance.ee.bear.office.list.adapter;

import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n {
    public static final Regex a = null;
    public static final Regex b = null;
    public static final Regex c = null;

    static {
        a = new Regex("\"key\"\\s*:\\s*\"([^\"]+)\"");
        b = new Regex("\"type\"\\s*:\\s*(-?\\d+)");
        c = new Regex("\"obj_type\"\\s*:\\s*(-?\\d+)");
    }
}
