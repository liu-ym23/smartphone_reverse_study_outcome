package com.vivo.push;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: classes41.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f462613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Uri f462614b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Uri f462615c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Uri f462616d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Uri f462617e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Uri f462618f = null;

    public static String a(int r100) {
        switch(r100) {
            case 2002: goto L17;
            case 2003: goto L15;
            case 2004: goto L13;
            case 2005: goto L11;
            case 2006: goto L9;
            case 2007: goto L7;
            case 2008: goto L5;
            default: goto L3;
        };
    L3:
        return null;
    L5:
        return "method_stop";
    L7:
        return "method_sdk_unbind";
    L9:
        return "method_sdk_bind";
    L11:
        return "method_tag_unbind";
    L13:
        return "method_tag_bind";
    L15:
        return "method_alias_unbind";
    L17:
        return "method_alias_bind";
    }

    static {
        f462613a = UriProtector.parse("content://com.vivo.push.sdk.service.SystemPushConfig/config");
        f462614b = UriProtector.parse("content://com.vivo.push.sdk.service.SystemPushConfig/permission");
        f462615c = UriProtector.parse("content://com.vivo.push.sdk.service.SystemPushConfig/clientState");
        f462616d = UriProtector.parse("content://com.vivo.push.sdk.service.SystemPushConfig/debugInfo");
        f462617e = UriProtector.parse("content://com.vivo.push.sdk.service.SystemPushConfig/agreePrivacyStatement");
        f462618f = UriProtector.parse("content://com.vivo.push.sdk.service.SystemPushConfig/queryAppState");
    }
}
