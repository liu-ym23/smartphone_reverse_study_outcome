package com.bytedance.bdp.appbase.network;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.monitor.traffic.TrafficMetrics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0087\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpRequestType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OK", HTTP.HOST, "PURETTNET", "bdp-infrastructure_release"}, k = 1, mv = {1, 4, 0})
public final enum BdpRequestType extends Enum<BdpRequestType> {
    private static final /* synthetic */ BdpRequestType[] $VALUES = null;
    public static final a Companion = null;
    public static final BdpRequestType HOST = null;
    public static final BdpRequestType OK = null;
    public static final BdpRequestType PURETTNET = null;
    private final String value;

    public static final class a {
        public a() {
        }
    }

    static {
        BdpRequestType r100 = new BdpRequestType("OK", 0, "okhttp");
        OK = r100;
        BdpRequestType r101 = new BdpRequestType(HTTP.HOST, 1, "host");
        HOST = r101;
        BdpRequestType r102 = new BdpRequestType("PURETTNET", 2, "purettnet");
        PURETTNET = r102;
        $VALUES = new BdpRequestType[]{r100, r101, r102};
        Companion = new a();
    }

    public static BdpRequestType valueOf(String r100) {
        return (BdpRequestType) r27.a.a(BdpRequestType.class, r100);
    }

    public static BdpRequestType[] values() {
        return (BdpRequestType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @JvmStatic
    public static final BdpRequestType from(String r100) {
        Companion.getClass();
        if (StringsKt.equals(r100, "purettnet", true) == false) goto L6;
        return PURETTNET;
    L6:
        if (StringsKt.equals(r100, TrafficMetrics.FRPM_TTNET, true) == true) goto L12;
        if (StringsKt.equals(r100, "host", true) == true) goto L12;
        return OK;
    L12:
        return HOST;
    }

    private BdpRequestType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
