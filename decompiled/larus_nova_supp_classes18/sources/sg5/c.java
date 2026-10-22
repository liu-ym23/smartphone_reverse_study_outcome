package sg5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberParam;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.ExistMemberResult;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.existmember.Member;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {

    public static final class a<T, R> implements Function {
        public final /* synthetic */ boolean a;

        public a(boolean r1) {
            this.a = r1;
        }

        public final Object apply(Object r6) {
            ExistMemberResult r7 = (ExistMemberResult) r6;
            Intrinsics.checkNotNullParameter(r7, "result");
            if (this.a == false) goto L11;
            List<Member> r0 = r7.getExistMembers();
            ArrayList r1 = new ArrayList();
            Iterator<T> r2 = r0.iterator();
        L6:
            if (r2.hasNext() == false) goto L10;
            T r3 = r2.next();
            DocUserPermission.a r4 = DocUserPermission.Companion;
            int r5 = ((Member) r3).getPerm();
            r4.getClass();
            if (DocUserPermission.a.a(r5) == false) goto L6;
            r1.add(r3);
            goto L6
        L10:
            r7.setExistMembers(r1);
        L11:
            return r7;
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            tt5.a.d("ExistMemberUtils", "getExistMember error: " + r4);
            return new ExistMemberResult();
        }
    }

    /* JADX INFO: renamed from: sg5.c$c, reason: collision with other inner class name */
    public static final class C0305c<T, R> implements Function {
        public static final C0305c<T, R> a = null;

        static {
            a = new C0305c();
        }

        public C0305c() {
        }

        public final Object apply(Object r3) {
            Throwable r4 = (Throwable) r3;
            Intrinsics.checkNotNullParameter(r4, "it");
            tt5.a.d("ExistMemberUtils", "getExistMember error: " + r4);
            return new ExistMemberResult();
        }
    }

    static {
    }

    @JvmStatic
    public static final Flowable<ExistMemberResult> b(String r5, boolean r6, ArrayList<Member> r7) {
        Intrinsics.checkNotNullParameter(r5, "objToken");
        Intrinsics.checkNotNullParameter(r7, "members");
        if (r7.isEmpty() == true) goto L13;
        if (r6 == true) goto L13;
        NetService.f r8 = new NetService.f("/space/api/suite/permission/space/collaborators/exist/");
        ((NetService.e) r8).c = 1;
        JSONObject r0 = new JSONObject();
        r0.put(ResourceData.KEY_TOKEN, r5);
        JSONArray r9 = new JSONArray();
        Iterator<Member> r10 = r7.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        Member r1 = r10.next();
        JSONObject r2 = new JSONObject();
        r2.put("collaborator_id", r1.getMemberId());
        r2.put("collaborator_type", Integer.valueOf(r1.getMemberType()));
        r9.add(r2);
        goto L8
    L10:
        r0.put("collaborators", r9);
        ((NetService.e) r8).j = r0.toJSONString();
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new sg5.a()).a(r8).onErrorReturn(C0305c.a);
    L13:
        return Flowable.just(new ExistMemberResult());
    }

    @JvmStatic
    public static final Flowable<ExistMemberResult> a(String r2, int r3, boolean r4, ArrayList<Member> r5) {
        Intrinsics.checkNotNullParameter(r2, "objToken");
        Intrinsics.checkNotNullParameter(r5, "members");
        NetService.f r0 = new NetService.f("/space/api/suite/permission/members/exist.v2/");
        ((NetService.e) r0).c = 1;
        ((NetService.e) r0).j = JSON.toJSONString(new ExistMemberParam(r3, r2, r5));
        return ((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new sg5.b()).a(r0).map(new a(r4)).onErrorReturn(b.a);
    }
}
