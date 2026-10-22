package s22;

import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.ContainerType;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.ChannelInviteMessageItem;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.h;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.j;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.model.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager.PublicScreenAreaPageChangeSource;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelData;
import com.bytedance.android.livesdkapi.depend.model.live.roomchannel.RoomChannelInfo;
import io.reactivex.Observable;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public interface e {

    public static abstract class a implements c {
        public a() {
        }

        @Override // s22.e.c
        public final void Df() {
        }

        @Override // s22.e.c
        public final void Ij(long r100, long r101, Long r102, Long r103, Throwable r104) {
        }

        @Override // s22.e.c
        public final void Nc() {
        }

        @Override // s22.e.c
        public final void Oo() {
        }

        @Override // s22.e.c
        public final void Va(long r100) {
        }

        public abstract void a(s22.a r100, boolean r101);

        @Override // s22.e.c
        public final void a3(long r100, Throwable r101) {
        }

        public abstract void b(long r100);

        public void c(s22.a r100) {
            Intrinsics.checkNotNullParameter(r100, "newChatChannel");
        }

        @Override // s22.e.c
        public final void vg(s22.a r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
        }

        @Override // s22.e.c
        public final void Dm(s22.a r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            a(r100, true);
        }

        @Override // s22.e.c
        public final void W5(s22.a r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            a(r100, false);
        }

        @Override // s22.e.c
        public final void Y9(long r100) {
            b(r100);
        }

        @Override // s22.e.c
        public final void d8(s22.a r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            a(r100, true);
        }

        @Override // s22.e.c
        public final void gf(s22.a r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            a(r100, false);
        }

        @Override // s22.e.c
        public final void hb(List<? extends s22.a> r100) {
            Intrinsics.checkNotNullParameter(r100, "channels");
            Iterator<T> r101 = r100.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            a((s22.a) r101.next(), false);
            goto L4
        }

        @Override // s22.e.c
        public final void kf(s22.a r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            c(r100);
        }

        @Override // s22.e.c
        public final void p6(long r100) {
            b(r100);
        }

        @Override // s22.e.c
        public final void t9(long r100) {
            b(r100);
        }

        @Override // s22.e.c
        public final void D9(s22.a r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r101) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            a(r100, true);
        }

        @Override // s22.e.c
        public void Gh(s22.a r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            Intrinsics.checkNotNullParameter(r100, "channel");
        }

        @Override // s22.e.c
        public final void Hh(long r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g r101) {
            Intrinsics.checkNotNullParameter(r101, "response");
            b(r100);
        }

        @Override // s22.e.c
        public final void Rn(long r100, k r101) {
            Intrinsics.checkNotNullParameter(r101, "response");
            b(r100);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ContainerType f540280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f540281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f540282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f540283d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f540284e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f540285f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f540286g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<String> f540287h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f540288i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f540289j;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L26;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f540280a, r101.f540280a) == true) goto L8;
            return false;
        L8:
            if (this.f540281b == r101.f540281b) goto L10;
            return false;
        L10:
            if (this.f540282c == r101.f540282c) goto L12;
            return false;
        L12:
            if (this.f540283d == r101.f540283d) goto L14;
            return false;
        L14:
            if (this.f540284e == r101.f540284e) goto L16;
            return false;
        L16:
            if (this.f540285f == r101.f540285f) goto L18;
            return false;
        L18:
            if (this.f540286g == r101.f540286g) goto L20;
            return false;
        L20:
            if (Intrinsics.areEqual(this.f540287h, r101.f540287h) == true) goto L22;
            return false;
        L22:
            if (this.f540288i == r101.f540288i) goto L24;
            return false;
        L24:
            if (this.f540289j == r101.f540289j) goto L40;
            return false;
        L40:
            return true;
        L26:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r0v20, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v23 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public final int hashCode() {
            ContainerType r100 = this.f540280a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            boolean r104 = this.f540281b;
            ?? r105 = 1;
            ?? r106 = r104;
            if (r104 == false) goto L9;
            r106 = 1;
        L9:
            int r107 = (r103 + r106) * 31;
            boolean r108 = this.f540282c;
            ?? r109 = r108;
            if (r108 == false) goto L12;
            r109 = 1;
        L12:
            int r110 = (r107 + r109) * 31;
            boolean r111 = this.f540283d;
            ?? r112 = r111;
            if (r111 == false) goto L15;
            r112 = 1;
        L15:
            int r113 = (r110 + r112) * 31;
            boolean r114 = this.f540284e;
            ?? r115 = r114;
            if (r114 == false) goto L18;
            r115 = 1;
        L18:
            int r116 = (r113 + r115) * 31;
            boolean r117 = this.f540285f;
            ?? r118 = r117;
            if (r117 == false) goto L21;
            r118 = 1;
        L21:
            int r119 = (r116 + r118) * 31;
            boolean r120 = this.f540286g;
            ?? r121 = r120;
            if (r120 == false) goto L24;
            r121 = 1;
        L24:
            int r122 = (r119 + r121) * 31;
            List<String> r123 = this.f540287h;
            if (r123 == null) goto L27;
            r101 = r123.hashCode();
        L27:
            int r124 = (r122 + r101) * 31;
            boolean r125 = this.f540288i;
            ?? r126 = r125;
            if (r125 == false) goto L30;
            r126 = 1;
        L30:
            int r127 = (r124 + r126) * 31;
            boolean r128 = this.f540289j;
            if (r128 == true) goto L35;
            r105 = r128;
        L35:
            return r127 + r105;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Config(containerType=" + this.f540280a + ", showLandscapeCreateEntry=" + this.f540281b + ", showLandscapeDialogEntry=" + this.f540282c + ", enableExtendHeight=" + this.f540283d + ", hideGiftAndEnterAnim=" + this.f540284e + ", enableMention=" + this.f540285f + ", enableGreeting=" + this.f540286g + ", greetingEmojiNames=" + this.f540287h + ", enableLinkMic=" + this.f540288i + ", showRecommendUser=" + this.f540289j + ")";
        }

        public b(ContainerType r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, List<String> r107, boolean r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r100, "containerType");
            Intrinsics.checkNotNullParameter(r107, "greetingEmojiNames");
            this.f540280a = r100;
            this.f540281b = r101;
            this.f540282c = r102;
            this.f540283d = r103;
            this.f540284e = r104;
            this.f540285f = r105;
            this.f540286g = r106;
            this.f540287h = r107;
            this.f540288i = r110;
            this.f540289j = r111;
        }
    }

    public interface c {
        void D9(s22.a r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.f r101);

        void Df();

        void Dm(s22.a r100);

        void Gh(s22.a r100, int r101);

        void Hh(long r100, com.bytedance.android.livesdk.interactivity.api.chatchannel.model.g r101);

        void Ij(long r100, long r101, Long r102, Long r103, Throwable r104);

        void Nc();

        void Oo();

        void Rn(long r100, k r101);

        void Va(long r100);

        void W5(s22.a r100);

        void Y9(long r100);

        void a3(long r100, Throwable r101);

        void d8(s22.a r100);

        void gf(s22.a r100);

        void hb(List<? extends s22.a> r100);

        void kf(s22.a r100);

        void p6(long r100);

        void t9(long r100);

        void vg(s22.a r100);
    }

    void addListener(c r100);

    void addListenerFirst(c r100);

    void applyAnchorFansChannel(long r100, Long r101, Long r102, Long r103);

    boolean changeCurrentChannel(long r100);

    s22.a createChannel(RoomChannelInfo r100);

    void createChannel(com.bytedance.android.livesdk.interactivity.api.chatchannel.model.e r100);

    void deleteAnchorFansChannel(long r100);

    void dissolveChannel(long r100);

    List<s22.a> getAllChannel();

    com.bytedance.android.livesdk.interactivity.api.b getAnimManager();

    s22.a getChannel(long r100);

    Observable<Response<h>> getChannelUserList(long r100, int r101, int r102);

    b getConfig();

    com.bytedance.android.live.core.arch.mvvm.d<sh6.b<s22.a>> getCurrentChannel();

    s22.b getEmojiManager();

    s22.c getGreetingManager();

    /* JADX INFO: renamed from: getIMManager */
    d mo8239getIMManager();

    Observable<Response<j>> getInviteId(long r100);

    s22.a getLatestChannel();

    f getToolbarManager();

    g getWidgetManager();

    void insertLocalMessage(y32.a r100);

    void joinAnchorFansChannel(long r100, long r101, Long r102, Long r103);

    void joinChannel(long r100);

    Observable<Response<Object>> kickOutChannel(long r100, String r101, String r102);

    void notifyChannelUnreadCountChanged(s22.a r100, int r101);

    void notifyInviteResult(long r100, List<? extends ChannelInviteMessageItem> r101);

    void onLoginSuccess();

    void onRoomDestroy(String r100);

    void onRoomEnter(RoomChannelData r100, String r101);

    void quitChannel(long r100);

    void recordChatChannelDialog(String r100, Object r101);

    void removeListener(c r100);

    void trySwitchToChannelPage(long r100, PublicScreenAreaPageChangeSource r101);

    void updateSetting(long r100, boolean r101, boolean r102);
}
