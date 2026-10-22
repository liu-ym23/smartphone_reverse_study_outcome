package rj0;

import android.content.Context;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.videotalk.MultiLinkVideoTalkRoomAnchorWidget;
import com.bytedance.android.live.liveinteract.videotalk.MultiLinkVideoTalkRoomGuestWidget;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.google.gson.JsonObject;
import dq2.w;
import gd0.p;
import hh1.v0;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Pair;
import tf0.q;
import tf0.v;
import w20.xc;

/* JADX INFO: loaded from: classes46.dex */
public interface m extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f537957a = null;

    void A(w.a r100);

    boolean C(boolean r100, String r101);

    Observable<Boolean> D();

    v E();

    com.bytedance.android.live.liveinteract.videotalk.ui.a F();

    boolean G();

    int H();

    boolean I(boolean r100, User r101);

    void J(Context r100, IRoom r101, b r102);

    int K(boolean r100);

    Pair<Boolean, Long> M(String r100);

    void N(String r100, int r101, LinkApplyType r102, tf0.b r103);

    void Q();

    BehaviorSubject<Boolean> U4();

    void a(q r100);

    void b3();

    void c(Context r100, String r101);

    boolean d(String r100, boolean r101);

    boolean e(boolean r100, String r101);

    void f(String r100);

    boolean finishVideoTalk(String r100);

    void forceReverseCamera();

    MultiLinkVideoTalkRoomAnchorWidget g(v0 r100, com.bytedance.android.live.pushstream.d r101);

    JsonObject getLinkmicAreaFrameInfo();

    JsonObject getLinkmicSeatListInfo();

    boolean isRtcEngineOn();

    com.bytedance.android.live.liveinteract.api.data.a j();

    void k(int r100, int r101, boolean r102, boolean r103, int r104, xc.a r105);

    void l(String r100);

    int m();

    void o(h80.a r100);

    void openEmojiDialog(String r100, String r101);

    void r();

    String s();

    void s3();

    int t();

    boolean u(boolean r100, String r101);

    void x(String r100, LinkApplyType r101);

    MultiLinkVideoTalkRoomGuestWidget y(p r100);

    boolean z();

    static {
        f537957a = new v();
    }
}
