package e92;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.livesdk.chatroom.model.interact.LinkReplyResult;
import com.bytedance.android.livesdk.link.model.bridge.s1;
import com.bytedance.android.livesdkapi.depend.model.live.linker.MultiChannelInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f471466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f471467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f471468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f471469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f471470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MultiChannelInfo f471471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f471472g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f471473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f471474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f471475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public MultiChannelInfo f471476d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f471477e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f471478f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f471479g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f471480h;

        public a() {
            this.f471475c = "0";
            this.f471478f = "";
            this.f471479g = "";
        }

        public final void b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "source");
            this.f471473a = 0;
            this.f471474b = 0;
            this.f471475c = "0";
            this.f471476d = null;
            c(0);
            this.f471478f = "";
            this.f471479g = "";
            this.f471480h = null;
            ALogger.e("MediaLinkTracer", "MultiLinkLaunchParameters.Record reset from " + r100);
        }

        public final void c(int r100) {
            this.f471477e = r100;
            if (r100 != 1) goto L5;
        L12:
            String r101 = "mutual_follow";
        L13:
            this.f471478f = r101;
            return;
        L5:
            if (r100 != 2) goto L7;
        L11:
            r101 = "recommend";
            goto L13
        L7:
            if (r100 == 101) goto L12;
            if (r100 == 102) goto L11;
            r101 = UserListInviteType.a(r100, null);
            goto L13
        }

        public final void a(LinkReplyResult r100, fy.a r101) {
            Intrinsics.checkNotNullParameter(r100, "replyResult");
            Intrinsics.checkNotNullParameter(r101, "replyParams");
            String r102 = r100.getLinkMicIdStr();
            boolean r103 = true;
            if (r102 != null) goto L5;
        L8:
            boolean r104 = true;
        L9:
            if (r104 == false) goto L11;
            String r105 = String.valueOf(r100.getLinkMicId().longValue());
        L12:
            this.f471479g = r105;
            this.f471480h = r100.getRtcExtInfo();
            s1 r106 = r100.getMultiChannelInfo();
            if (r106 != null) goto L15;
            return;
        L15:
            if (r106.getUseMultiChannel() == false) goto L25;
            Map<Long, String> r107 = r106.getChannelMap();
            if (r107 != null) goto L19;
        L22:
            if (r103 == true) goto L25;
            this.f471476d = r100.getMMultiChannelInfo();
            goto L25
        L19:
            if (r107.isEmpty() == true) goto L22;
            r103 = false;
        L25:
            if (Intrinsics.areEqual(r101.f479148k, this.f471475c) == false) goto L29;
            this.f471475c = "0";
            return;
        L29:
            return;
        L11:
            r105 = String.valueOf(r100.getLinkMicIdStr());
            goto L12
        L5:
            if (r102.length() == 0) goto L8;
            r104 = false;
            goto L9
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L20;
        l r101 = (l) r100;
        if (this.f471466a == r101.f471466a) goto L8;
        return false;
    L8:
        if (this.f471467b == r101.f471467b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f471468c, r101.f471468c) == true) goto L12;
        return false;
    L12:
        if (this.f471469d == r101.f471469d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f471470e, r101.f471470e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f471471f, r101.f471471f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f471472g, r101.f471472g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f471466a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f471467b) * 31;
        String r102 = this.f471468c;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (((r101 + r104) * 31) + this.f471469d) * 31;
        String r106 = this.f471470e;
        if (r106 == null) goto L9;
        int r107 = r106.hashCode();
    L10:
        int r108 = (r105 + r107) * 31;
        MultiChannelInfo r109 = this.f471471f;
        if (r109 == null) goto L13;
        int r110 = r109.hashCode();
    L14:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f471472g;
        if (r112 == null) goto L18;
        r103 = r112.hashCode();
    L18:
        return r111 + r103;
    L13:
        r110 = 0;
        goto L14
    L9:
        r107 = 0;
        goto L10
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "MediaMultiLinkLaunchParameters(channelID=" + this.f471466a + ", matchType=" + this.f471467b + ", linkerID=" + this.f471468c + ", inviteType=" + this.f471469d + ", inviteeList=" + this.f471470e + ", multiChannelInfo=" + this.f471471f + ", rtcInfo=" + this.f471472g + ")";
    }

    public l(a r100) {
        long r101 = r100.f471473a;
        int r102 = r100.f471474b;
        String r103 = r100.f471479g;
        int r104 = r100.f471477e;
        String r105 = r100.f471478f;
        MultiChannelInfo r106 = r100.f471476d;
        String r107 = r100.f471480h;
        Intrinsics.checkNotNullParameter(r103, "linkerID");
        Intrinsics.checkNotNullParameter(r105, "inviteeList");
        this.f471466a = r101;
        this.f471467b = r102;
        this.f471468c = r103;
        this.f471469d = r104;
        this.f471470e = r105;
        this.f471471f = r106;
        this.f471472g = r107;
    }
}
