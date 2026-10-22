package ug5;

import ax4.f;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends tg5.a {
    public final dh5.b b;
    public final String c;
    public final String d;
    public final ArrayList<UserInfo> e;
    public final cj5.c.a f;
    public Disposable g;

    /* JADX INFO: renamed from: ug5.a$a, reason: collision with other inner class name */
    public static final class C0315a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ax4.e<InviteResult> a;

        public b(ax4.e<InviteResult> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onSuccess(new InviteResult());     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ ax4.e<InviteResult> a;

        public c(ax4.e<InviteResult> r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.onFailed(new Throwable("error"));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ ax4.e<InviteResult> a;

        public d(ax4.e<InviteResult> r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            SimpleRequestResult r3 = (SimpleRequestResult) r2;
            tt5.a.h("BitableShareInviteMemberManagerModel", "inviteUsers()...succeed");
            this.a.onSuccess(new InviteResult());
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ ax4.e<InviteResult> a;

        public e(ax4.e<InviteResult> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Throwable r4 = (Throwable) r3;
            tt5.a.h("BitableShareInviteMemberManagerModel", "inviteUsers()...error = " + r4.getMessage());
            this.a.onFailed(r4);
        }
    }

    static {
    }

    @Override // tg5.a
    public final void destroy() {
        super.destroy();
        Disposable r0 = this.g;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L12;
        Disposable r2 = this.g;
        if (r2 == null) goto L13;
        r2.dispose();
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        r1 = true;
        goto L7
    }

    @Override // tg5.o
    public final void F1(String r2) {
        Intrinsics.checkNotNullParameter(r2, "notificationId");
        tt5.a.h("BitableShareInviteMemberManagerModel", "sendNotifyRequest()...");
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // tg5.o
    public final void c7(boolean r10, boolean r11, String r12, ax4.e<InviteResult> r13) {
        Intrinsics.checkNotNullParameter(r12, "notes");
        Intrinsics.checkNotNullParameter(r13, "callback");
        ArrayList<UserInfo> r14 = this.b.getSelected();
        tt5.a.h("BitableShareInviteMemberManagerModel", "inviteUsers()...size = " + r14.size() + ", notify = " + r10);
        cj5.c.a r15 = this.f;
        if (r15 == null) goto L19;
        ArrayList<UserInfo> r3 = this.e;
        JSONArray r4 = new JSONArray();
        Iterator<UserInfo> r5 = r3.iterator();     // Catch: JSONException -> L14
    L7:
        if (r5.hasNext() == false) goto L9;
        UserInfo r6 = r5.next();     // Catch: JSONException -> L14
        JSONObject r7 = new JSONObject();     // Catch: JSONException -> L14
        r7.put("memberId", r6.getId());     // Catch: JSONException -> L14
        r7.put("memberType", r6.getOwnerType());     // Catch: JSONException -> L14
        r4.put(r7);     // Catch: JSONException -> L14
        goto L7
    L9:
        Iterator<UserInfo> r16 = r14.iterator();     // Catch: JSONException -> L14
    L10:
        if (r16.hasNext() == false) goto L16;
        UserInfo r8 = r16.next();     // Catch: JSONException -> L14
        JSONObject r9 = new JSONObject();     // Catch: JSONException -> L14
        r9.put("memberId", r8.getId());     // Catch: JSONException -> L14
        r9.put("memberType", r8.getOwnerType());     // Catch: JSONException -> L14
        r4.put(r9);     // Catch: JSONException -> L14
    L16:
        r15.a(r4, new b(r13), new c(r13));
        return;
    L14:
        e = move-exception;
        tt5.a.f("BitableShareInviteMemberManagerModel", e, false);
        goto L16
    L19:
        if (hu5.a.d(r14) == false) goto L22;
        tt5.a.k("BitableShareInviteMemberManagerModel", "inviteUser()...users is empty");
        r13.onFailed(new Throwable("empty users"));
        return;
    L22:
        StringCompanionObject r17 = StringCompanionObject.INSTANCE;
        NetService.f r18 = new NetService.f(String.format("/space/api/bitable/roles/%s/update", Arrays.copyOf(new Object[]{this.c}, 1)));
        ((NetService.e) r18).c = 1;
        com.alibaba.fastjson.JSONObject r19 = new com.alibaba.fastjson.JSONObject();
        r19.put("roleId", this.d);
        ArrayList<UserInfo> r20 = this.e;
        com.alibaba.fastjson.JSONArray r21 = new com.alibaba.fastjson.JSONArray();
        Iterator<UserInfo> r22 = r20.iterator();     // Catch: JSONException -> L32
    L25:
        if (r22.hasNext() == false) goto L27;
        UserInfo r23 = r22.next();     // Catch: JSONException -> L32
        com.alibaba.fastjson.JSONObject r24 = new com.alibaba.fastjson.JSONObject();     // Catch: JSONException -> L32
        r24.put("memberId", r23.getId());     // Catch: JSONException -> L32
        r24.put("memberType", Integer.valueOf(r23.getOwnerType()));     // Catch: JSONException -> L32
        r21.add(r24);     // Catch: JSONException -> L32
        goto L25
    L27:
        Iterator<UserInfo> r110 = r14.iterator();     // Catch: JSONException -> L32
    L28:
        if (r110.hasNext() == false) goto L34;
        UserInfo r25 = r110.next();     // Catch: JSONException -> L32
        com.alibaba.fastjson.JSONObject r26 = new com.alibaba.fastjson.JSONObject();     // Catch: JSONException -> L32
        r26.put("memberId", r25.getId());     // Catch: JSONException -> L32
        r26.put("memberType", Integer.valueOf(r25.getOwnerType()));     // Catch: JSONException -> L32
        r21.add(r26);     // Catch: JSONException -> L32
    L34:
        r19.put("members", r21);
        com.alibaba.fastjson.JSONObject r111 = new com.alibaba.fastjson.JSONObject();
        r111.put("baseRole", r19);
        r111.put("needAddCollaborators", Boolean.TRUE);
        ((NetService.e) r18).j = r111.toJSONString();
        this.g = ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new f()).a(r18).subscribe(new d(r13), new e(r13));
        return;
    L32:
        e = move-exception;
        tt5.a.f("BitableShareInviteMemberManagerModel", e, false);
        goto L34
    }

    public a(dh5.b r2, String r3, String r4, ArrayList<UserInfo> r5, cj5.c.a r6) {
        Intrinsics.checkNotNullParameter(r2, "model");
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "roleId");
        Intrinsics.checkNotNullParameter(r5, "originUsers");
        super(r2);
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
