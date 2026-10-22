package com.bytedance.cloudplay.xplay2.api;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/bytedance/cloudplay/xplay2/api/XplayConstants$NetworkQuality", "", "Lcom/bytedance/cloudplay/xplay2/api/XplayConstants$NetworkQuality;", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "GREAT", "GOOD", "MEDIUM", "BAD", "TERRIBLE", "xplay2-api_release"}, k = 1, mv = {1, 8, 0})
public final enum XplayConstants$NetworkQuality extends Enum<XplayConstants$NetworkQuality> {
    public static final XplayConstants$NetworkQuality BAD = null;
    public static final XplayConstants$NetworkQuality GOOD = null;
    public static final XplayConstants$NetworkQuality GREAT = null;
    public static final XplayConstants$NetworkQuality MEDIUM = null;
    public static final XplayConstants$NetworkQuality TERRIBLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XplayConstants$NetworkQuality[] f202794a = null;
    private final String desc;

    public static XplayConstants$NetworkQuality valueOf(String r100) {
        return (XplayConstants$NetworkQuality) a.a(XplayConstants$NetworkQuality.class, r100);
    }

    public static XplayConstants$NetworkQuality[] values() {
        return (XplayConstants$NetworkQuality[]) f202794a.clone();
    }

    static {
        XplayConstants$NetworkQuality r100 = new XplayConstants$NetworkQuality("GREAT", 0, "网络极佳");
        GREAT = r100;
        XplayConstants$NetworkQuality r101 = new XplayConstants$NetworkQuality("GOOD", 1, "网络良好");
        GOOD = r101;
        XplayConstants$NetworkQuality r102 = new XplayConstants$NetworkQuality("MEDIUM", 2, "网络一般");
        MEDIUM = r102;
        XplayConstants$NetworkQuality r103 = new XplayConstants$NetworkQuality("BAD", 3, "网络差");
        BAD = r103;
        XplayConstants$NetworkQuality r104 = new XplayConstants$NetworkQuality("TERRIBLE", 4, "网络极差");
        TERRIBLE = r104;
        f202794a = new XplayConstants$NetworkQuality[]{r100, r101, r102, r103, r104};
    }

    public final String getDesc() {
        return this.desc;
    }

    public XplayConstants$NetworkQuality(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
