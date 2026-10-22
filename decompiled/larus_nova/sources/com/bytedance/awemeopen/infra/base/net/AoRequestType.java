package com.bytedance.awemeopen.infra.base.net;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0087\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/awemeopen/infra/base/net/AoRequestType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OK", HTTP.HOST, "ao_base_core_release"}, k = 1, mv = {1, 7, 1})
public final enum AoRequestType extends Enum<AoRequestType> {
    private static final /* synthetic */ AoRequestType[] $VALUES = null;
    public static final a Companion = null;
    public static final AoRequestType HOST = null;
    public static final AoRequestType OK = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ AoRequestType[] $values() {
        return new AoRequestType[]{OK, HOST};
    }

    public static AoRequestType valueOf(String r100) {
        return (AoRequestType) r27.a.a(AoRequestType.class, r100);
    }

    public static AoRequestType[] values() {
        return (AoRequestType[]) $VALUES.clone();
    }

    static {
        OK = new AoRequestType("OK", 0, "okhttp");
        HOST = new AoRequestType(HTTP.HOST, 1, "host");
        $VALUES = $values();
        Companion = new a();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final AoRequestType from(String r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "requestType");
        if (StringsKt.equals(r100, TrafficMetrics.FRPM_TTNET, true) == true) goto L9;
        if (StringsKt.equals(r100, "host", true) == true) goto L9;
        return OK;
    L9:
        return HOST;
    }

    private AoRequestType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
