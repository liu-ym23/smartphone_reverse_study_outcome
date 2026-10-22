package com.bytedance.bdp.appbase.network;

import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0087\u0001\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpHttpDnsScene;", "", "scene", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScene", "()Ljava/lang/String;", "TT_API", "PREFETCH", "CP_HTTP_SECURE", "PRECONNECT_CP", "DNS", "SDK", "Companion", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
public final enum BdpHttpDnsScene extends Enum<BdpHttpDnsScene> {
    private static final /* synthetic */ BdpHttpDnsScene[] $VALUES = null;
    public static final BdpHttpDnsScene CP_HTTP_SECURE = null;
    public static final Companion Companion = null;
    public static final BdpHttpDnsScene DNS = null;
    public static final BdpHttpDnsScene PRECONNECT_CP = null;
    public static final BdpHttpDnsScene PREFETCH = null;
    public static final BdpHttpDnsScene SDK = null;
    public static final BdpHttpDnsScene TT_API = null;
    private final String scene;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/bdp/appbase/network/BdpHttpDnsScene$Companion;", "", "()V", "fromSourceToHttpDnsScene", "Lcom/bytedance/bdp/appbase/network/BdpHttpDnsScene;", "from", "Lcom/bytedance/bdp/appbase/network/BdpFromSource;", "scene", "name", "", "bdp-infrastructure_release"}, k = 1, mv = {1, 1, 18})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final BdpHttpDnsScene fromSourceToHttpDnsScene(BdpFromSource r100) {
            switch(a.f200879a[r100.ordinal()]) {
                case 1: goto L10;
                case 2: goto L10;
                case 3: goto L10;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                default: goto L11;
            };
        L11:
            return BdpHttpDnsScene.SDK;
        L12:
            return BdpHttpDnsScene.DNS;
        L13:
            return BdpHttpDnsScene.PRECONNECT_CP;
        L14:
            return BdpHttpDnsScene.CP_HTTP_SECURE;
        L15:
            return BdpHttpDnsScene.PREFETCH;
        L10:
            return BdpHttpDnsScene.TT_API;
        }

        @JvmStatic
        public final BdpHttpDnsScene scene(String r100) {
            BdpHttpDnsScene[] r101 = BdpHttpDnsScene.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            BdpHttpDnsScene r104 = r101[r103];
            if (StringsKt.equals(r104.getScene(), r100, true) == true) goto L12;
            r103 = r103 + 1;
            goto L3
        L12:
            return r104;
        L8:
            return null;
        }
    }

    static {
        BdpHttpDnsScene r100 = new BdpHttpDnsScene("TT_API", 0, "tt_api");
        TT_API = r100;
        BdpHttpDnsScene r101 = new BdpHttpDnsScene("PREFETCH", 1, ErrorType.PREFETCH);
        PREFETCH = r101;
        BdpHttpDnsScene r102 = new BdpHttpDnsScene("CP_HTTP_SECURE", 2, "cp_http_secure");
        CP_HTTP_SECURE = r102;
        BdpHttpDnsScene r103 = new BdpHttpDnsScene("PRECONNECT_CP", 3, "preconnect_cp");
        PRECONNECT_CP = r103;
        BdpHttpDnsScene r104 = new BdpHttpDnsScene("DNS", 4, MultiProcessFileUtils.KEY_DNS);
        DNS = r104;
        BdpHttpDnsScene r105 = new BdpHttpDnsScene("SDK", 5, "sdk");
        SDK = r105;
        $VALUES = new BdpHttpDnsScene[]{r100, r101, r102, r103, r104, r105};
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final BdpHttpDnsScene fromSourceToHttpDnsScene(BdpFromSource r100) {
        return Companion.fromSourceToHttpDnsScene(r100);
    }

    @JvmStatic
    public static final BdpHttpDnsScene scene(String r100) {
        return Companion.scene(r100);
    }

    public static BdpHttpDnsScene valueOf(String r100) {
        return (BdpHttpDnsScene) r27.a.a(BdpHttpDnsScene.class, r100);
    }

    public static BdpHttpDnsScene[] values() {
        return (BdpHttpDnsScene[]) $VALUES.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    private BdpHttpDnsScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.scene = r102;
    }
}
