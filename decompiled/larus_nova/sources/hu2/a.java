package hu2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002\u000b\fB\u0007¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lhu2/a;", "", "Lhu2/a$b;", "hotSoon", "Lhu2/a$b;", "getHotSoon", "()Lhu2/a$b;", "setHotSoon", "(Lhu2/a$b;)V", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("hotsoon")
    private b hotSoon;

    /* JADX INFO: renamed from: hu2.a$a, reason: collision with other inner class name */
    public static final class C6198a {
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lhu2/a$b;", "", "", "certificationProtocol", "Ljava/lang/String;", "getCertificationProtocol", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "anchorProtocol", "getAnchorProtocol", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("anchor_protocol")
        private String anchorProtocol;

        @SerializedName("certification_protocol")
        private String certificationProtocol;

        public final void a() {
            Intrinsics.checkNotNullParameter("https://webcast.huoshan.com/falcon/webcast_huoshan/page/anchor_agreement/index.html?type=fullscreen&title=&hide_more=0&hide_nav_bar=0&hide_status_bar=0", "<set-?>");
            this.anchorProtocol = "https://webcast.huoshan.com/falcon/webcast_huoshan/page/anchor_agreement/index.html?type=fullscreen&title=&hide_more=0&hide_nav_bar=0&hide_status_bar=0";
        }

        public final void b() {
            Intrinsics.checkNotNullParameter("https://lf3-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/huoshan/97064efc-f54c-4111-9954-c2c9cfac5798.html", "<set-?>");
            this.certificationProtocol = "https://lf3-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/huoshan/97064efc-f54c-4111-9954-c2c9cfac5798.html";
        }

        public b() {
            this.certificationProtocol = "";
            this.anchorProtocol = "";
        }
    }

    static {
    }

    public a() {
        b r100 = new b();
        r100.b();
        r100.a();
        Unit r101 = Unit.INSTANCE;
        this.hotSoon = r100;
    }
}
