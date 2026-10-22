package com.bytedance.frameworks.baselib.network.http.util;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f244783a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f244784b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f244785c = null;

    static {
        f244783a = PatternProtector.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        f244784b = PatternProtector.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f244785c = PatternProtector.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }
}
