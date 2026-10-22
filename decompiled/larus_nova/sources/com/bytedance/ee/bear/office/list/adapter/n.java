package com.bytedance.ee.bear.office.list.adapter;

import kotlin.text.Regex;

/* JADX INFO: loaded from: classes18.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Regex f235810a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f235811b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f235812c = null;

    static {
        f235810a = new Regex("\"key\"\\s*:\\s*\"([^\"]+)\"");
        f235811b = new Regex("\"type\"\\s*:\\s*(-?\\d+)");
        f235812c = new Regex("\"obj_type\"\\s*:\\s*(-?\\d+)");
    }
}
