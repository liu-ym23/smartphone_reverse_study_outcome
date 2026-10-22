package com.bytedance.ee.bear.drive.biz.feed;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import b95.l;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity;
import com.bytedance.ee.bear.contract.drive.sdk.entity.open.SpaceFileOpenEntity;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.drive.biz.comment.DriveCommentVM;
import com.bytedance.ee.bear.drive.biz.comment.data.m;
import com.bytedance.ee.bear.drive.biz.comment.q1;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.h;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.framework.utils.CollectionUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fo5.d;
import g55.e;
import g55.f;
import g55.g;
import g55.j;
import g55.k;
import g55.n;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import s45.p;
import t75.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends com.bytedance.ee.bear.drive.biz.feed.a implements m.b {
    public final Object g;
    public final i h;
    public final CompositeDisposable i;
    public c.a j;
    public MessageResultBean k;
    public final ArraySet l;
    public final List<String> m;
    public final n n;
    public final m o;
    public final q1 p;
    public final l q;
    public UDDialog r;
    public C0125b s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;

    public class a implements com.bytedance.ee.bear.middleground.feed.export.bean.i {
        public final /* synthetic */ b a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.feed.b$a$a, reason: collision with other inner class name */
        public class C0123a implements Consumer<CommentRectF> {
            public final /* synthetic */ String a;
            public final /* synthetic */ a b;

            public final void accept(Object r2) throws Exception {
                CommentRectF r3 = (CommentRectF) r2;
                String r0 = this.a;
                if (r0 == null) goto L5;
                r3.c = r0;
            L5:
                this.b.a.f.getLiveFeedSelectedComment().postValue(r3);
            }

            public C0123a(a r1, String r2) {
                this.b = r1;
                this.a = r2;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.feed.b$a$b, reason: collision with other inner class name */
        public class C0124b implements Consumer<Throwable> {
            public final /* synthetic */ a a;

            public C0124b(a r1) {
                this.a = r1;
            }

            public final void accept(Object r2) throws Exception {
                Throwable r3 = (Throwable) r2;
                this.a.a.f.getLiveFeedSelectedComment().postValue(null);
            }
        }

        public final void f(String r1) {
        }

        public final void j(boolean r1) {
        }

        public final /* synthetic */ void k() {
        }

        public a(b r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            this.a.i(r2);
        }

        public final void c(MessageResultBean r3) {
            tt5.a.h("DriveFeedManager", "###  MG data change: " + r3 + ", source =rn, current thread=" + ThreadMethodProxy.currentThread().getName());
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.getData() == null) goto L9;
            b r0 = this.a;
            r0.k = r3;
            r0.p(false);
            return;
        }

        public final boolean d(String r3) {
            tt5.a.b("DriveFeedManager", this.a.n() + "isSameLink url = [" + yu5.c.j(r3) + "]");
            f85.a r0 = (f85.a) this.a.d.getFileModel();
            BearUrl r4 = p.a().Z(r3);
            if (r0 == null) goto L9;
            if (r4 == null) goto L9;
            if (TextUtils.equals(r4.b, ((f85.a.C0229a) r0.a).a) == false) goto L9;
            FragmentActivity r5 = this.a.a;
            Toast.showFailureText(r5, r5.getString(2131888416), 0);
            return true;
        L9:
            return false;
        }

        public final void e(MessageBean r8) {
            tt5.a.h("DriveFeedManager", String.format("%s go to message messageId = [ %s ], commentId = [ %s ]", new Object[]{this.a.n(), r8.getMessageId(), r8.getComment_id()}));
            n r0 = this.a.n;
            if (r0.h == true) goto L6;
            r0.a(8);
        L6:
            if ("MESSAGE_DOC_COMMENT".equals(r8.getType()) == false) goto L30;
            String r1 = r8.getComment_id();
            String r3 = r8.getReply_id();
            if (this.a.p.get() == null) goto L25;
            this.a.p.get().showSelectedComment(r1);
        L25:
            Iterator<CommentRectF> r4 = this.a.o.g.iterator();     // Catch: Exception -> L16
        L12:
            if (r4.hasNext() == false) goto L18;
            CommentRectF r5 = r4.next();     // Catch: Exception -> L16
            if (r5.b.equals(r1) == false) goto L12;
        L19:
            if (r5 == null) goto L23;
            if (r3 == null) goto L22;
            r5.c = r3;
        L22:
            this.a.f.getLiveFeedSelectedComment().postValue(r5);
            return;
        L23:
            this.a.o.d(r8.getComment_id()).subscribe(new C0123a(this, r3), new C0124b(this));
            return;
        L18:
            r5 = null;
        L16:
            e = move-exception;
            tt5.a.f("DriveFeedManager", e, false);
            goto L18
        }

        public final void g(List<String> r5) {
            tt5.a.h("DriveFeedManager", this.a.n() + "unreadMessage  ids = " + Arrays.toString(this.a.l.toArray(new String[0])));
            tt5.a.h("DriveFeedManager", this.a.n() + "readMessage    ids = " + Arrays.toString(r5.toArray(new String[0])));
            this.a.l(Collections.unmodifiableList(r5));
        }

        public final void h(int r3) {
            tt5.a.h("DriveFeedManager", "### unReadBadgeCount:(current + history) " + r3);
        }

        public final void i(int r3) {
            tt5.a.b("DriveFeedManager", this.a.n() + "heightChange() called with: height = [" + r3 + "]");
            this.a.f.setCommentPanelDefaultHeight(Integer.valueOf(r3));
            com.bytedance.ee.bear.middleground.feed.a r4 = this.a.b;
            if (r4 != null) goto L5;
        L7:
            b r5 = this.a;
            if (r5.v == true) goto L13;
            r5.v = true;
            if (r5.p.get() == null) goto L14;
            this.a.p.get().showThumbnailPreview();
            return;
        L14:
            return;
        L13:
            return;
        L5:
            if (r4.c() == true) goto L7;
        }

        public final void b(boolean r2, boolean r3) {
            tt5.a.h("DriveFeedManager", this.a.n() + "statusChange show = [" + r2 + "]");
            if (r2 == false) goto L10;
            b r4 = this.a;
            if (r4.n.h == true) goto L8;
            r4.f.getCommentPanelShowing().setValue(Boolean.TRUE);
            this.a.n.a(8);
        L8:
            if (this.a.p.get() == null) goto L14;
            this.a.p.get().showThumbnailPreview();
            return;
        L14:
            return;
        L10:
            this.a.q();
            this.a.f.getCommentPanelShowing().setValue(Boolean.FALSE);
            this.a.n.a(0);
            if (this.a.p.get() == null) goto L16;
            this.a.p.get().onCommentListPanelClose();
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.feed.b$b, reason: collision with other inner class name */
    public class C0125b implements Observer<u55.b> {
        public final /* synthetic */ b a;

        public C0125b(b r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            u55.b r9 = (u55.b) r8;
            f85.a r0 = (f85.a) this.a.d.getFileModel();
            boolean r1 = true;
            if (r0 != null) goto L23;
            StringBuilder r2 = new StringBuilder();
            r2.append(this.a.n());
            r2.append("on permission changed: fileModel is null ");
            if (r9 != null) goto L7;
        L9:
            boolean r5 = false;
        L10:
            r2.append(r5);
            r2.append(" ");
            if (r9 != null) goto L13;
        L15:
            boolean r6 = false;
        L16:
            r2.append(r6);
            r2.append(" ");
            if (r9 != null) goto L19;
        L21:
            r1 = false;
        L22:
            r2.append(r1);
            tt5.a.k("DriveFeedManager", r2.toString());
        L42:
            UDDialog r3 = this.a.r;
            if (r3 != null) goto L45;
        L66:
            com.bytedance.ee.bear.middleground.feed.a r4 = this.a.b;
            if (r4 == null) goto L74;
            if (r9 == null) goto L75;
            com.bytedance.ee.bear.middleground.feed.a r7 = r4;
            r7.f(com.bytedance.ee.bear.drive.biz.feed.a.h(r9, false));
            com.bytedance.ee.bear.middleground.feed.a r10 = this.a.b;
            com.bytedance.ee.bear.middleground.feed.a r11 = r10;
            r11.d(r9.k(), "").subscribeOn(d.e()).subscribe(new k(), new g55.l());
            return;
        L75:
            return;
        L74:
            return;
        L45:
            if (r3.isShowing() == false) goto L66;
            if (r9 != null) goto L48;
        L49:
            tt5.a.d("DriveFeedManager", "onChanged dismiss");
            UDDialog r12 = this.a.r;
            Handler r13 = DialogLancet.resolveDialogHandler(r12);
            if (r13 != null) goto L52;
        L54:
            DialogLancet.beforeDialogDismiss(r12);
            r12.dismiss();     // Catch: Throwable -> L57 Exception -> L59
        L63:
            DialogLancet.afterDialogDismiss(r12);
            goto L66
        L57:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r12);
            throw th;
        L59:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L57
            Throwable r14 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L57
            if (r14 == null) goto L63;
            com.bytedance.crash.d.d(r14, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L57
            goto L63
        L52:
            if (Looper.myLooper() == r13.getLooper()) goto L54;
            r13.post(DialogLancet.createDismissRunnable(r12));
            goto L66
        L48:
            if (r9.e() == true) goto L66;
        L19:
            if (r9.k() == false) goto L21;
        L13:
            if (r9.a() == false) goto L15;
            r6 = true;
            goto L16
        L7:
            if (r9.e() == false) goto L9;
            r5 = true;
            goto L10
        L23:
            StringBuilder r16 = new StringBuilder();
            r16.append(this.a.n());
            r16.append("on permission changed: ");
            r16.append(du5.b.g(((f85.a.C0229a) r0.a).b));
            r16.append(" ");
            if (r9 != null) goto L26;
        L28:
            boolean r17 = false;
        L29:
            r16.append(r17);
            r16.append(" ");
            if (r9 != null) goto L32;
        L34:
            boolean r18 = false;
        L35:
            r16.append(r18);
            r16.append(" ");
            if (r9 != null) goto L38;
        L40:
            r1 = false;
        L41:
            r16.append(r1);
            tt5.a.k("DriveFeedManager", r16.toString());
            goto L42
        L38:
            if (r9.k() == false) goto L40;
        L32:
            if (r9.a() == false) goto L34;
            r18 = true;
            goto L35
        L26:
            if (r9.e() == false) goto L28;
            r17 = true;
            goto L29
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public final void attach() {
        tt5.a.h("DriveFeedManager", "attach feed start, manager=" + o(this) + ", feed=" + o(this.b) + ", aiContainerAbility=" + o(this.h));
        detach();
        j((u55.b) this.e.livePerm().getValue(), new a(this));
        this.s = new C0125b(this);
        this.e.livePerm().observeForever(this.s);
        this.o.b(this);
        tt5.a.h("DriveFeedManager", "attach feed finish, manager=" + o(this) + ", feed=" + o(this.b));
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public final void c() {
        tt5.a.h("DriveFeedManager", "showFeed, manager=" + o(this) + ", feed=" + o(this.b) + ", aiContainerAbility=" + o(this.h));
        com.bytedance.ee.bear.middleground.feed.a r0 = this.b;
        if (r0 == null) goto L6;
        this.t = true;
        r0.f(com.bytedance.ee.bear.drive.biz.feed.a.h((u55.b) this.e.livePerm().getValue(), true));
    L6:
        if (this.b != null) goto L8;
        tt5.a.h("DriveFeedManager", "showFeedAfterPreviewLayout skipped: feed is null, manager=" + o(this) + ", aiContainerAbility=" + o(this.h));
        q();
        return;
    L8:
        Runnable r1 = new g55.i(this);
        i r2 = this.h;
        if (r2 != null) goto L11;
        r1.run();
        return;
    L11:
        r2.E6(this.g, r1);
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public final void detach() {
        tt5.a.h("DriveFeedManager", "detach feed start, manager=" + o(this) + ", feed=" + o(this.b));
        if (this.s == null) goto L5;
        this.e.livePerm().removeObserver(this.s);
        this.s = null;
    L5:
        this.w = false;
        this.t = false;
        this.u = false;
        UDDialog r4 = this.r;
        if (r4 != null) goto L8;
    L26:
        this.k = null;
        this.l.clear();
        this.i.clear();
        ((ArrayList) this.m).clear();
        this.o.i.remove(this);
        q();
        tt5.a.h("DriveFeedManager", "destroyFeed start, manager=" + o(this) + ", feed=" + o(this.b));
        com.bytedance.ee.bear.middleground.feed.a r5 = this.b;
        if (r5 != null) goto L39;
    L35:
        tt5.a.h("DriveFeedManager", "destroyFeed finish, manager=" + o(this) + ", feed=" + o(this.b));
        tt5.a.h("DriveFeedManager", "detach feed finish, manager=" + o(this) + ", feed=" + o(this.b));
        return;
    L39:
        r5.a();     // Catch: Exception -> L32
        this.n.a(0);     // Catch: Exception -> L32
        if (this.p.get() == null) goto L34;
        this.p.get().onCommentListPanelClose();     // Catch: Exception -> L32
    L34:
        this.b = null;
    L32:
        e = move-exception;
        tt5.a.f("DriveFeedManager", e, false);
        goto L34
    L8:
        if (r4.isShowing() == false) goto L26;
        tt5.a.d("DriveFeedManager", "detach dismiss");
        UDDialog r6 = this.r;
        Handler r7 = DialogLancet.resolveDialogHandler(r6);
        if (r7 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(r6);
        r6.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(r6);
        goto L26
    L19:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r8 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r8 == null) goto L23;
        com.bytedance.crash.d.d(r8, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r6);
        throw th;
    L12:
        if (Looper.myLooper() == r7.getLooper()) goto L14;
        r7.post(DialogLancet.createDismissRunnable(r6));
        goto L26
    }

    public final MessageResultBean m() {
        tt5.a.h("DriveFeedManager", n() + " data changed: mMessageResultBean=" + this.k + " isDataReady " + this.o.d);
        if (this.k != null) goto L6;
        return null;
    L6:
        if (this.o.d == true) goto L8;
        return null;
    L8:
        MessageResultBean.Data r0 = this.k.getData();
        if (r0 != null) goto L11;
        return null;
    L11:
        List r1 = r0.getMessage();
        if (r1 != null) goto L14;
        ArrayList r2 = new ArrayList(0);
    L15:
        tt5.a.h("DriveFeedManager", String.format("%s data changed source: message=%d", new Object[]{n(), Integer.valueOf(r2.size())}));
        ArrayMap r4 = new ArrayMap(r2.size());
        Iterator<CommentRectF> r5 = this.o.g.iterator();
    L17:
        if (r5.hasNext() == false) goto L19;
        CommentRectF r7 = r5.next();
        r4.put(r7.b, r7);
        goto L17
    L19:
        this.l.clear();
        ((ArrayList) this.m).clear();
        Iterator r6 = r2.iterator();
    L21:
        if (r6.hasNext() == false) goto L37;
        MessageBean r8 = (MessageBean) r6.next();
        if ("MESSAGE_DOC_SHARE".equals(r8.getType()) == true) goto L30;
        if (r4.containsKey(r8.getComment_id()) == true) goto L30;
        if (r8.getReadStatus() != 1) goto L29;
        ((ArrayList) this.m).add(r8.getMessageId());
    L29:
        r6.remove();
    L30:
        FragmentActivity r9 = this.a;
        String r10 = com.bytedance.ee.bear.drive.biz.comment.data.c.b(r9, r8.getQuote());
        if (r10 != null) goto L34;
        r10 = r9.getString(2131888387);
    L34:
        r8.setQuote(r10);
        if (r8.getReadStatus() != 1) goto L21;
        this.l.add(r8.getMessageId());
        goto L21
    L37:
        tt5.a.h("DriveFeedManager", String.format("%s data changed result: message=%d unread_history_message=%d unread_message=%d", new Object[]{n(), Integer.valueOf(r2.size()), Integer.valueOf(((ArrayList) this.m).size()), Integer.valueOf(this.l.size())}));
        MessageResultBean r3 = new MessageResultBean();
        r3.setCode(this.k.getCode());
        r3.setMsg(this.k.getMsg());
        MessageResultBean.Data r11 = new MessageResultBean.Data();
        r11.setMessage(r2);
        r3.setData(r11);
        return r3;
    L14:
        r2 = new ArrayList(r1);
        goto L15
    }

    public final String n() {
        MessageResultBean r0 = this.k;
        if (r0 != null) goto L5;
        return "";
    L5:
        return Integer.toHexString(r0.hashCode()).concat(" ");
    }

    public final void q() {
        i r0 = this.h;
        if (r0 == null) goto L6;
        r0.G5(this.g);
        return;
    }

    public final void r() {
        BaseOpenEntity r0 = this.d.getOpenEntity();
        if (this.t == false) goto L5;
        return;
    L5:
        if ((r0 instanceof SpaceFileOpenEntity) == false) goto L13;
        SpaceFileOpenEntity r1 = (SpaceFileOpenEntity) r0;
        boolean r2 = ((h) org.koin.java.a.a(h.class)).i(r1.getUrl(), r1.getExtra());
        tt5.a.h("DriveFeedManager", "[AutoShowFeed]showFeedIfNeeded " + r2);
        if (r2 == false) goto L12;
        this.u = true;
        c();
        return;
    L12:
        return;
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public final void f() {
        q();
        tt5.a.h("DriveFeedManager", "closeFeed");
        com.bytedance.ee.bear.middleground.feed.a r0 = this.b;
        if (r0 == null) goto L8;
        r0.b();
        this.n.a(0);
        if (this.p.get() == null) goto L9;
        this.p.get().onCommentListPanelClose();
        return;
    L9:
        return;
    }

    public static String o(Object r2) {
        if (r2 != null) goto L6;
        return "null";
    L6:
        return r2.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(r2));
    }

    @Override // com.bytedance.ee.bear.drive.biz.comment.data.m.b
    public final void b(ArrayList<CommentRectF> r3) {
        tt5.a.h("DriveFeedManager", n() + " onDriveCommentDataReceived list = [" + Arrays.toString(r3.toArray(new CommentRectF[0])) + "]");
        p(true);
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.a, com.bytedance.ee.bear.drive.biz.feed.c
    public final void d(DriveFeedPlugin.b r1) {
        this.j = r1;
    }

    public final int l(List<String> r3) {
        if (CollectionUtils.isEmpty(r3) == true) goto L5;
        this.l.removeAll(r3);
    L5:
        int r4 = this.l.size();
        tt5.a.h("DriveFeedManager", n() + " updateFeedBadgeNumber: " + r4);
        c.a r0 = this.j;
        if (r0 == null) goto L9;
        r0.a(r4);
    L9:
        return this.l.size();
    }

    public final void p(boolean r3) {
        MessageResultBean r0 = m();     // Catch: Exception -> L24
        if (r0 == null) goto L5;
        s(r0);     // Catch: Exception -> L24
    L7:
        if (this.u == false) goto L29;
        if (r3 == false) goto L10;
        return;
    L10:
        if (r0 != null) goto L12;
    L19:
        boolean r1 = true;
    L20:
        if (r1 == false) goto L22;
        f();     // Catch: Exception -> L24
    L22:
        this.u = false;     // Catch: Exception -> L24
        return;
    L12:
        if (r0.getData() == null) goto L19;
        if (r0.getData().getMessage() == null) goto L19;
        if (r0.getData().getMessage().isEmpty() == true) goto L19;
        r1 = false;
        goto L20
    L29:
        return;
    L5:
        r();     // Catch: Exception -> L24
    L24:
        e = move-exception;
        e.printStackTrace();
        tt5.a.d("DriveFeedManager", e.toString());
    }

    public final void s(MessageResultBean r6) {
        com.bytedance.ee.bear.middleground.feed.a r0 = this.b;
        if (r0 != null) goto L6;
        tt5.a.h("DriveFeedManager", "can not update ui without mFeed");
        return;
    L6:
        r0.e(this.m);
        this.b.a.l.l(r6);
        l(Collections.emptyList());
        if (k() == false) goto L30;
        int r7 = ((ArrayList) this.m).size();
        r();
        u55.b r1 = (u55.b) this.e.livePerm().getValue();
        if (r1 != null) goto L12;
    L14:
        boolean r2 = false;
    L15:
        tt5.a.h("DriveFeedManager", "mUnreadHistoryMessageIdList size: " + r7 + " hasEditPermission: " + r2);
        if (r7 <= 0) goto L28;
        if (r2 == true) goto L19;
        return;
    L19:
        if (this.w == true) goto L31;
        this.w = true;
        ArrayList r8 = new ArrayList();
        Iterator r3 = ((ArrayList) this.m).iterator();
    L23:
        if (r3.hasNext() == false) goto L25;
        final String r4 = (String) r3.next();
        r8.add(this.o.d(r4).map(new g55.d()).onErrorResumeNext(new e(r4)));
        goto L23
    L25:
        this.i.add(Flowable.zip(r8, new f()).subscribe(new g(this), new g55.h()));
        return;
    L31:
        return;
    L28:
        return;
    L12:
        if (r1.c() == false) goto L14;
        r2 = true;
        goto L15
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.a, com.bytedance.ee.bear.drive.biz.feed.c
    public final void a(boolean r2, boolean r3) {
        if (r3 == false) goto L8;
        q();
        com.bytedance.ee.bear.middleground.feed.a r4 = this.b;
        if (r4 != null) goto L6;
        return;
    L6:
        if (r4.c() == false) goto L22;
        this.b.b();
        return;
    L22:
        return;
    L8:
        if (r2 == false) goto L13;
        com.bytedance.ee.bear.middleground.feed.a r5 = this.b;
        if (r5 == null) goto L24;
        r5.h(true);
        return;
    L24:
        return;
    L13:
        if (this.b != null) goto L16;
        q();
        return;
    L16:
        Runnable r6 = new j(this);
        i r7 = this.h;
        if (r7 != null) goto L19;
        r6.run();
        return;
    L19:
        r7.E6(this.g, r6);
    }

    public b(DriveFeedPlugin.d r1, FrameLayout r2, n r3, i r4) {
        super(r1, r2);
        this.g = new Object();
        this.l = new ArraySet();
        this.m = new ArrayList();
        this.v = false;
        this.i = new CompositeDisposable();
        this.o = ((DriveCommentVM) r1.a(DriveCommentVM.class)).getCommentDataManger();
        this.n = r3;
        this.p = r3.d;
        this.q = o75.b.a().H7();
        this.h = r4;
    }
}
