package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.baidu.platform.comapi.map.MapController;
import com.ss.android.downloadlib.constants.ComplianceConstants;
import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.cell.ListMode;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.MessageVisibleEntity;
import com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params.MessageVisibleHintPointParams;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.widget.photopicker.animation.activitytransition.ActivityTransitionLauncher;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class b implements t6b.e.a {

    public static final class a extends b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            ((a) r100).getClass();
            return true;
        }

        public final int hashCode() {
            return 1237;
        }

        public final String toString() {
            return "ChangeAudioPlayMode(isSpeakerMode=false)";
        }
    }

    public static final class a0 extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f413795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f413796b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a0) == true) goto L8;
            return false;
        L8:
            a0 r101 = (a0) r100;
            if (Intrinsics.areEqual(this.f413795a, r101.f413795a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413796b, r101.f413796b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f413795a.hashCode() * 31) + this.f413796b.hashCode();
        }

        public final String toString() {
            return "OnUrlClicked(messageId=" + this.f413795a + ", url=" + this.f413796b + ')';
        }

        public a0(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            Intrinsics.checkNotNullParameter(r101, "url");
            this.f413795a = r100;
            this.f413796b = r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.features.event.b$b, reason: collision with other inner class name */
    public static final class C4826b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f413797a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4826b) == true) goto L9;
            return false;
        L9:
            if (this.f413797a == ((C4826b) r100).f413797a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f413797a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "ChangeTitleAreaVisibility(showOrHide=" + this.f413797a + ')';
        }

        public C4826b() {
            this.f413797a = true;
        }
    }

    public static final class b0 extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ChatChatter f413798a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f413798a, ((b0) r100).f413798a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413798a.hashCode();
        }

        public final String toString() {
            return "P2PChatterUpdate(chatter=" + this.f413798a + ')';
        }

        public b0(ChatChatter r100) {
            Intrinsics.checkNotNullParameter(r100, "chatter");
            this.f413798a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Chat f413799a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f413799a, ((c) r100).f413799a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413799a.hashCode();
        }

        public final String toString() {
            return "ChatUpdate(chat=" + this.f413799a + ')';
        }

        public c(Chat r100) {
            Intrinsics.checkNotNullParameter(r100, "chat");
            this.f413799a = r100;
        }
    }

    public static final class c0 extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f413800a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c0) == true) goto L9;
            return false;
        L9:
            if (this.f413800a == ((c0) r100).f413800a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413800a;
        }

        public final String toString() {
            return "SelectedMessageChange(selectedCount=" + this.f413800a + ')';
        }

        public c0(int r100) {
            this.f413800a = r100;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f413801a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f413801a == ((d) r100).f413801a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f413801a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "FistFrameShown(time=" + this.f413801a + ')';
        }

        public d(long r100) {
            this.f413801a = r100;
        }
    }

    public static final class d0 extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadTopic f413802a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f413802a, ((d0) r100).f413802a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413802a.hashCode();
        }

        public final String toString() {
            return "ThreadTopicUpdate(threadTopic=" + this.f413802a + ')';
        }

        public d0(ThreadTopic r100) {
            Intrinsics.checkNotNullParameter(r100, "threadTopic");
            this.f413802a = r100;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y6b.c<?> f413803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MessageVisibleHintPointParams f413804b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f413803a, r101.f413803a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413804b, r101.f413804b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f413803a.hashCode() * 31;
            MessageVisibleHintPointParams r101 = this.f413804b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "MessageAppear(message=" + this.f413803a + ", messageAppearParams=" + this.f413804b + ')';
        }

        public e(y6b.c<?> r100, MessageVisibleHintPointParams r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f413803a = r100;
            this.f413804b = r101;
        }
    }

    public static final class e0 extends b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e0) == true) goto L8;
            return false;
        L8:
            ((e0) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "ToggleAudioText(messageId=null, shouldShow=false)";
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f413805a = null;

        static {
            f413805a = new f();
        }

        public f() {
        }
    }

    public static final class f0 extends b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f0) == true) goto L8;
            return false;
        L8:
            ((f0) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "TranslateMessage(view=null, message=null)";
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BasePageStore<MessageInfo, ? extends x4b.a<MessageInfo>> f413806a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f413806a, ((g) r100).f413806a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413806a.hashCode();
        }

        public final String toString() {
            return "MessageListDataStoreCreated(store=" + this.f413806a + ')';
        }

        public g(BasePageStore<MessageInfo, ? extends x4b.a<MessageInfo>> r100) {
            Intrinsics.checkNotNullParameter(r100, ComplianceConstants.ComplianceRequest.MARKET_STORE);
            this.f413806a = r100;
        }
    }

    public static final class g0 extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f413807a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g0) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f413807a, ((g0) r100).f413807a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413807a.hashCode();
        }

        public final String toString() {
            return "UrlInTextMessageDetected(messageId=" + this.f413807a + ')';
        }

        public g0(String r100) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            this.f413807a = r100;
        }
    }

    public static final class h extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f413808a = null;

        static {
            f413808a = new h();
        }

        public h() {
        }
    }

    public static final class i extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f413809a = null;

        static {
            f413809a = new i();
        }

        public i() {
        }
    }

    public static final class j extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListMode f413810a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            if (this.f413810a == ((j) r100).f413810a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413810a.hashCode();
        }

        public final String toString() {
            return "MessageSelectModeChange(mode=" + this.f413810a + ')';
        }

        public j(ListMode r100) {
            Intrinsics.checkNotNullParameter(r100, "mode");
            this.f413810a = r100;
        }
    }

    public static final class k extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MessageVisibleEntity f413811a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f413811a, ((k) r100).f413811a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            MessageVisibleEntity r100 = this.f413811a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "MessageVisible(messageVisibleEntity=" + this.f413811a + ')';
        }

        public k(MessageVisibleEntity r100) {
            this.f413811a = r100;
        }
    }

    public static final class l extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f413812a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L9;
            return false;
        L9:
            if (this.f413812a == ((l) r100).f413812a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413812a;
        }

        public final String toString() {
            return "MultiSelect(adapterPosition=" + this.f413812a + ')';
        }

        public l(int r100) {
            this.f413812a = r100;
        }
    }

    public static final class m extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<MessageInfo> f413813a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f413813a, ((m) r100).f413813a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413813a.hashCode();
        }

        public final String toString() {
            return "NewMessageAppended(messageList=" + this.f413813a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public m(List<? extends MessageInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "messageList");
            this.f413813a = r100;
        }
    }

    public static final class n extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<MessageInfo> f413814a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f413814a, ((n) r100).f413814a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413814a.hashCode();
        }

        public final String toString() {
            return "NewMessageArrived(messageList=" + this.f413814a + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public n(List<? extends MessageInfo> r100) {
            Intrinsics.checkNotNullParameter(r100, "messageList");
            this.f413814a = r100;
        }
    }

    public static final class o extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PhotoItem f413815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f413816b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L8;
            return false;
        L8:
            o r101 = (o) r100;
            if (Intrinsics.areEqual(this.f413815a, r101.f413815a) == true) goto L12;
            return false;
        L12:
            if (this.f413816b == r101.f413816b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f413815a.hashCode() * 31;
            if (this.f413816b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "OnClickEditImage(photoItem=" + this.f413815a + ", isClickTranslated=" + this.f413816b + ')';
        }

        public o(PhotoItem r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "photoItem");
            this.f413815a = r100;
            this.f413816b = r101;
        }
    }

    public static final class p extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ActivityTransitionLauncher.LocationInfo f413818b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PhotoItem f413819c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f413820d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f413821e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f413822f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Message.SourceType f413823g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L8;
            return false;
        L8:
            p r101 = (p) r100;
            if (Intrinsics.areEqual(this.f413817a, r101.f413817a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413818b, r101.f413818b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f413819c, r101.f413819c) == true) goto L18;
            return false;
        L18:
            if (this.f413820d == r101.f413820d) goto L21;
            return false;
        L21:
            if (this.f413821e == r101.f413821e) goto L24;
            return false;
        L24:
            if (this.f413822f == r101.f413822f) goto L27;
            return false;
        L27:
            if (this.f413823g == r101.f413823g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            View r100 = this.f413817a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            ActivityTransitionLauncher.LocationInfo r104 = this.f413818b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            PhotoItem r107 = this.f413819c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            int r110 = 1231;
            if (this.f413820d == false) goto L17;
            int r111 = 1231;
        L18:
            int r112 = (r109 + r111) * 31;
            if (this.f413821e == true) goto L22;
            r110 = 1237;
        L22:
            int r113 = (((r112 + r110) * 31) + this.f413822f) * 31;
            Message.SourceType r114 = this.f413823g;
            if (r114 == null) goto L27;
            r101 = r114.hashCode();
        L27:
            return r113 + r101;
        L17:
            r111 = 1237;
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnClickImage(itemView=" + this.f413817a + ", locationInfo=" + this.f413818b + ", photoItem=" + this.f413819c + ", isMutePlay=" + this.f413820d + ", isClickTranslated=" + this.f413821e + ", fromType=" + this.f413822f + ", sourceType=" + this.f413823g + ')';
        }

        public p(View r100, ActivityTransitionLauncher.LocationInfo r101, PhotoItem r102, boolean r103, boolean r104, int r105, Message.SourceType r106) {
            this.f413817a = r100;
            this.f413818b = r101;
            this.f413819c = r102;
            this.f413820d = r103;
            this.f413821e = r104;
            this.f413822f = r105;
            this.f413823g = r106;
        }
    }

    public static final class q extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final PhotoItem f413825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f413826c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof q) == true) goto L8;
            return false;
        L8:
            q r101 = (q) r100;
            if (Intrinsics.areEqual(this.f413824a, r101.f413824a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413825b, r101.f413825b) == true) goto L15;
            return false;
        L15:
            if (this.f413826c == r101.f413826c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            View r100 = this.f413824a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            PhotoItem r104 = this.f413825b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            int r105 = (r103 + r101) * 31;
            if (this.f413826c == false) goto L13;
            int r106 = 1231;
        L15:
            return r105 + r106;
        L13:
            r106 = 1237;
            goto L15
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnClickPreMedia(itemView=" + this.f413824a + ", photoItem=" + this.f413825b + ", isMutePlay=" + this.f413826c + ')';
        }

        public q(View r100, PhotoItem r101, boolean r102) {
            this.f413824a = r100;
            this.f413825b = r101;
            this.f413826c = r102;
        }
    }

    public static final class r extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f413827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f413828b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof r) == true) goto L8;
            return false;
        L8:
            r r101 = (r) r100;
            if (Intrinsics.areEqual(this.f413827a, r101.f413827a) == true) goto L12;
            return false;
        L12:
            if (this.f413828b == r101.f413828b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f413827a.hashCode() * 31) + this.f413828b;
        }

        public final String toString() {
            return "OnClickTextCell(messageId=" + this.f413827a + ", position=" + this.f413828b + ')';
        }

        public r(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            this.f413827a = r100;
            this.f413828b = r101;
        }
    }

    public static final class s extends b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof s) == true) goto L8;
            return false;
        L8:
            ((s) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "OnMessageBurned(messageId=null)";
        }
    }

    public static final class t extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f413829a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof t) == true) goto L9;
            return false;
        L9:
            if (this.f413829a == ((t) r100).f413829a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f413829a;
        }

        public final String toString() {
            return "OnMessageCleared(firstMessagePosition=" + this.f413829a + ')';
        }

        public t(int r100) {
            this.f413829a = r100;
        }
    }

    public static final class u extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v5b.c<v5b.a<?>> f413830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f413831b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r5b.a f413832c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof u) == true) goto L8;
            return false;
        L8:
            u r101 = (u) r100;
            if (Intrinsics.areEqual(this.f413830a, r101.f413830a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413831b, r101.f413831b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f413832c, r101.f413832c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            v5b.c<v5b.a<?>> r100 = this.f413830a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            View r104 = this.f413831b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            r5b.a r107 = this.f413832c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnOpenCellTranslateMoreBtnClick(item=" + this.f413830a + ", moreActionView=" + this.f413831b + ", chatContext=" + this.f413832c + ')';
        }

        public u(v5b.c r100, AppCompatImageView r101, r5b.a r102) {
            this.f413830a = r100;
            this.f413831b = r101;
            this.f413832c = r102;
        }
    }

    public static final class v extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f413834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Object> f413835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f413836d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof v) == true) goto L8;
            return false;
        L8:
            v r101 = (v) r100;
            if (Intrinsics.areEqual(this.f413833a, r101.f413833a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413834b, r101.f413834b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f413835c, r101.f413835c) == true) goto L18;
            return false;
        L18:
            if (this.f413836d == r101.f413836d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            View r100 = this.f413833a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f413834b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            List<Object> r107 = this.f413835c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return ((r106 + r101) * 31) + this.f413836d;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnOpenImageClick(itemView=" + this.f413833a + ", clickMessageId=" + this.f413834b + ", openFeishuGalleryPreviewItemList=" + this.f413835c + ", groupIndex=" + this.f413836d + ')';
        }

        public v(View r100, String r101, List<? extends Object> r102, int r103) {
            this.f413833a = r100;
            this.f413834b = r101;
            this.f413835c = r102;
            this.f413836d = r103;
        }
    }

    public static final class w extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y6b.a<?> f413837a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f413838b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f413839c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof w) == true) goto L8;
            return false;
        L8:
            w r101 = (w) r100;
            if (Intrinsics.areEqual(this.f413837a, r101.f413837a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413838b, r101.f413838b) == true) goto L15;
            return false;
        L15:
            if (this.f413839c == r101.f413839c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f413837a.hashCode() * 31) + this.f413838b.hashCode()) * 31) + this.f413839c;
        }

        public final String toString() {
            return "OnReactionClick(item=" + this.f413837a + ", reactionKey=" + this.f413838b + ", source=" + this.f413839c + ')';
        }

        public w(y6b.a<?> r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r101, "reactionKey");
            this.f413837a = r100;
            this.f413838b = r101;
            this.f413839c = r102;
        }
    }

    public static final class x extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f413841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f413842c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof x) == true) goto L8;
            return false;
        L8:
            x r101 = (x) r100;
            if (Intrinsics.areEqual(this.f413840a, r101.f413840a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413841b, r101.f413841b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f413842c, r101.f413842c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f413840a.hashCode() * 31;
            String r101 = this.f413841b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f413842c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "OnSwitchTranslateMenuClick(view=" + this.f413840a + ", targetLanguage=" + this.f413841b + ", messageId=" + this.f413842c + ')';
        }

        public x(View r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f413840a = r100;
            this.f413841b = r101;
            this.f413842c = r102;
        }
    }

    public static final class y extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f413843a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof y) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f413843a, ((y) r100).f413843a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f413843a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "OnTranslateFeedbackClick(messageId=" + this.f413843a + ')';
        }

        public y(String r100) {
            this.f413843a = r100;
        }
    }

    public static final class z extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f413844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final y6b.a<v5b.a<?>> f413845b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof z) == true) goto L8;
            return false;
        L8:
            z r101 = (z) r100;
            if (Intrinsics.areEqual(this.f413844a, r101.f413844a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f413845b, r101.f413845b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f413844a.hashCode() * 31) + this.f413845b.hashCode();
        }

        public final String toString() {
            return "OnTranslateShowOriginClick(itemView=" + this.f413844a + ", messageVO=" + this.f413845b + ')';
        }

        public z(View r100, y6b.a<v5b.a<?>> r101) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "messageVO");
            this.f413844a = r100;
            this.f413845b = r101;
        }
    }

    public b() {
    }
}
