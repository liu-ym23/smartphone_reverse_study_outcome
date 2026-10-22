package com.bytedance.ee.bear.middleground.comment.permission;

import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.middleground.comment.export.bean.PermMember;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$BlockMember;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$FailMember;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$ResultData;
import com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel$SendResult;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005J2\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J*\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0011J\u0018\u0010\u0015\u001a\u00020\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/permission/AskOwnerViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "netService", "Lcom/bytedance/ee/bear/contract/NetService;", "init", "", "askOwnerFlow", "Lio/reactivex/Flowable;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/askowner/AskOwnerModel$SendResult;", ResourceData.KEY_TOKEN, "", ResourceData.KEY_TYPE, "", "commentId", "permissionMembers", "", "Lcom/bytedance/ee/bear/middleground/comment/export/bean/PermMember;", "askDocumentOwnerFlow", "userIds", "getSelectUserList", "Lcom/alibaba/fastjson/JSONArray;", "selectedUsers", "Companion", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AskOwnerViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String REQUEST_ASK_OWNER_URL = "/space/api/suite/permission/ask_owner/members/create/";
    private NetService netService;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T, R> implements Function {
        public static final b<T, R> a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final Object apply(Object r14) {
            Object[] r15 = (Object[]) r14;
            Intrinsics.checkNotNullParameter(r15, "results");
            HashMap r0 = new HashMap();
            HashMap r1 = new HashMap();
            int r2 = r15.length;
            int r4 = 0;
            int r5 = 0;
            int r6 = 0;
        L3:
            if (r4 >= r2) goto L21;
            Object r7 = r15[r4];
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground.permission.collaborator.askowner.AskOwnerModel.SendResult");
            AskOwnerModel$ResultData r8 = (AskOwnerModel$ResultData) ((Result) ((AskOwnerModel$SendResult) r7)).data;
            if (r8 == null) goto L20;
            Iterator<Map.Entry<String, List<AskOwnerModel$FailMember>>> r9 = r8.getFailMembers().entrySet().iterator();
        L8:
            if (r9.hasNext() == false) goto L13;
            Map.Entry<String, List<AskOwnerModel$FailMember>> r10 = r9.next();
            String r11 = r10.getKey();
            List<AskOwnerModel$FailMember> r12 = r10.getValue();
            List r13 = (List) r0.get(r11);
            if (r13 != null) goto L12;
            r13 = CollectionsKt.emptyList();
        L12:
            r0.put(r11, CollectionsKt.plus(r13, r12));
            r5 = r5 + r12.size();
            goto L8
        L13:
            Iterator<Map.Entry<String, List<AskOwnerModel$BlockMember>>> r16 = r8.getBlockMembers().entrySet().iterator();
        L15:
            if (r16.hasNext() == false) goto L20;
            Map.Entry<String, List<AskOwnerModel$BlockMember>> r17 = r16.next();
            String r18 = r17.getKey();
            List<AskOwnerModel$BlockMember> r19 = r17.getValue();
            List r110 = (List) r1.get(r18);
            if (r110 != null) goto L19;
            r110 = CollectionsKt.emptyList();
        L19:
            r1.put(r18, CollectionsKt.plus(r110, r19));
            r6 = r6 + r19.size();
        L20:
            r4 = r4 + 1;
            goto L3
        L21:
            AskOwnerModel$SendResult r111 = new AskOwnerModel$SendResult();
            ((Result) r111).code = 0;
            ((Result) r111).data = new AskOwnerModel$ResultData(r0, r5, r1, r6);
            return r111;
        }
    }

    static {
        Companion = new a();
    }

    public AskOwnerViewModel() {
    }

    private final JSONArray getSelectUserList(List<PermMember> r6) {
        JSONArray r0 = new JSONArray();
        if (r6 == null) goto L8;
        Iterator<T> r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        PermMember r1 = (PermMember) r7.next();
        JSONObject r2 = new JSONObject();
        r2.put("owner_id", r1.getOwnerId());
        r2.put("owner_type", r1.getOwnerType());
        r2.put("permission", 1);
        r0.add(r2);
    L8:
        return r0;
    }

    public final void init(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        this.netService = r2;
    }

    public final Flowable<AskOwnerModel$SendResult> askDocumentOwnerFlow(String r11, int r12, List<String> r13) {
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r13, "userIds");
        if (r13.isEmpty() == false) goto L6;
        AskOwnerModel$SendResult r14 = new AskOwnerModel$SendResult();
        ((Result) r14).code = 0;
        ((Result) r14).data = new AskOwnerModel$ResultData(null, 0, null, 0, 15, null);
        return Flowable.just(r14);
    L6:
        List r15 = CollectionsKt.chunked(r13, 10);
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10));
        Iterator r16 = r15.iterator();
    L8:
        if (r16.hasNext() == false) goto L18;
        List r4 = (List) r16.next();
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = r4.iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        String r7 = (String) r6.next();
        PermMember r8 = new PermMember();
        r8.setOwnerId(r7);
        r8.setOwnerType(1);
        r8.setPermission(1);
        r5.add(r8);
        goto L11
    L13:
        NetService.f r9 = new NetService.f(REQUEST_ASK_OWNER_URL);
        ((NetService.e) r9).c = 1;
        JSONObject r10 = new JSONObject();
        r10.put(ResourceData.KEY_TOKEN, r11);
        r10.put(ResourceData.KEY_TYPE, Integer.valueOf(r12));
        r10.put("ask_mode", 0);
        r10.put("members", getSelectUserList(r5));
        r10.put("allow_partial_success", Boolean.TRUE);
        ((NetService.e) r9).j = r10.toJSONString();
        NetService r17 = this.netService;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("netService");
        r17 = null;
    L16:
        r3.add(r17.Vc(new qg5.a()).a(r9));
        goto L8
    L18:
        return Flowable.zip(r3, b.a);
    }

    public final Flowable<AskOwnerModel$SendResult> askOwnerFlow(String r4, int r5, String r6, List<PermMember> r7) {
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "commentId");
        Intrinsics.checkNotNullParameter(r7, "permissionMembers");
        if (TextUtils.isEmpty(r6) == true) goto L13;
        if (hu5.a.d(r7) == true) goto L13;
        NetService.f r1 = new NetService.f(REQUEST_ASK_OWNER_URL);
        ((NetService.e) r1).c = 1;
        JSONObject r2 = new JSONObject();
        r2.put(ResourceData.KEY_TOKEN, r4);
        r2.put(ResourceData.KEY_TYPE, Integer.valueOf(r5));
        r2.put("block_id", r6);
        r2.put("block_type", 21);
        r2.put("ask_mode", 0);
        r2.put("members", getSelectUserList(r7));
        ((NetService.e) r1).j = r2.toJSONString();
        NetService r8 = this.netService;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("netService");
        r8 = null;
    L11:
        return r8.Vc(new qg5.a()).a(r1);
    L13:
        return Flowable.error(new Throwable("users is empty"));
    }
}
