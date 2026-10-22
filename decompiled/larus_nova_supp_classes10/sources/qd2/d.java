package qd2;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.message.model.g0;
import com.bytedance.android.livesdk.message.model.l8;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.message.TextFormat;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends g<a, Object> {
    public final o a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lqd2/d$a;", "", "", "chatContent", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "color", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        @SerializedName("chat_content")
        private final String chatContent;

        @SerializedName("color")
        private final String color;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.chatContent, r4.chatContent) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.color, r4.color) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.chatContent;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.color;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(chatContent=" + this.chatContent + ", color=" + this.color + ")";
        }

        public final String a() {
            return this.chatContent;
        }

        public final String b() {
            return this.color;
        }
    }

    public d(o r2) {
        Intrinsics.checkNotNullParameter(r2, "roomContext");
        this.a = r2;
    }

    public final Object invoke(Object r9, CallContext r10) {
        a r11 = (a) r9;
        Intrinsics.checkNotNullParameter(r11, "p0");
        Intrinsics.checkNotNullParameter(r10, "p1");
        l8 r12 = f.c(l8.class);
        r12.setMessageType(3);
        g0 r0 = new g0();
        m r1 = this.a.getRoom();
        if (r1 == null) goto L7;
        IRoom r2 = (IRoom) r1.getValue();
        if (r2 == null) goto L7;
        long r3 = r2.getId();
    L8:
        r12.setBaseMessage(CommonMessageData.fake(r3, true));
        IInteractService r4 = k.f(IInteractService.class);
        if (r4 == null) goto L61;
        IMiddlewareUserService r5 = k.f(IMiddlewareUserService.class);
        if (r5 == null) goto L15;
        e r6 = r5.user();
        if (r6 == null) goto L15;
        String r7 = r6.n();
    L17:
        if (r4.isAnonymousUser(r7) != true) goto L61;
        IInteractService r8 = k.f(IInteractService.class);
        if (r8 == null) goto L23;
        i r13 = r8.getLinkUserInfoCenter();
        if (r13 == null) goto L23;
        List r14 = r13.getOnlineUserList();
    L24:
        if (r14 == null) goto L53;
        Iterator r15 = r14.iterator();
    L27:
        if (r15.hasNext() == false) goto L49;
        Object r16 = r15.next();
        ILinkPlayerInfoBridge r17 = (ILinkPlayerInfoBridge) r16;
        if (r17 != null) goto L31;
    L46:
        boolean r18 = false;
    L47:
        if (r18 == false) goto L27;
    L50:
        ILinkPlayerInfoBridge r19 = (ILinkPlayerInfoBridge) r16;
        if (r19 == null) goto L53;
        IBaseUser r20 = r19.getUser();
    L54:
        r0.userInfo = r20;
        if (r20 != null) goto L64;
        IBaseUser r21 = k.n(IMiddlewareUserService.class).user().b();
        if (r21 == null) goto L60;
        r0.userInfo = r21;
        goto L64
    L60:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUser");
    L64:
        Text r22 = new Text();
        r22.setDefaultPattern(r11.a());
        TextFormat r23 = new TextFormat();
        r23.setColor(r11.b());
        Unit r24 = Unit.INSTANCE;
        r22.setDefaultFormat(r23);
        r0.displayText = r22;
        r12.setAudienceOrderSongChatContent(r0);
        j r25 = this.a.getMessageManager();
        if (r25 == null) goto L69;
        vlc.d r26 = (vlc.d) r25.getValue();
        if (r26 == null) goto L69;
        r26.j(r12, true);
    L69:
        return null;
    L31:
        if (r17.isAnonymous() != true) goto L46;
        IBaseUser r27 = r17.getUser();
        if (r27 == null) goto L35;
        String r28 = r27.getIdString();
    L36:
        IMiddlewareUserService r29 = k.f(IMiddlewareUserService.class);
        if (r29 == null) goto L42;
        e r30 = r29.user();
        if (r30 == null) goto L42;
        String r31 = r30.n();
        if (r31 == null) goto L42;
    L44:
        if (Intrinsics.areEqual(r28, r31) == false) goto L46;
        r18 = true;
    L42:
        r31 = "";
        goto L44
    L35:
        r28 = null;
        goto L36
    L49:
        r16 = null;
    L53:
        r20 = null;
    L23:
        r14 = null;
    L15:
        r7 = null;
    L61:
        IBaseUser r32 = k.n(IMiddlewareUserService.class).user().b();
        if (r32 == null) goto L71;
        r0.userInfo = r32;
        goto L64
    L71:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.IBaseUser");
    L7:
        r3 = 0;
        goto L8
    }
}
