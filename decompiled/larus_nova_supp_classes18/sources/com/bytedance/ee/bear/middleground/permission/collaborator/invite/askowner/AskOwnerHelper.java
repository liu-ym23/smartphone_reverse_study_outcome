package com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import io.reactivex.Flowable;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AskOwnerHelper {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001BC\u00120\b\u0002\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR9\u0010\u0002\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/AskOwnerHelper$AskOwner;", "Ljava/io/Serializable;", "failMembers", "Ljava/util/HashMap;", "", "", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/AskOwnerHelper$FailMember;", "Lkotlin/collections/HashMap;", "failCount", "", "<init>", "(Ljava/util/HashMap;I)V", "getFailMembers", "()Ljava/util/HashMap;", "getFailCount", "()I", "setFailCount", "(I)V", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AskOwner implements Serializable {
        private int failCount;
        private final HashMap<String, List<FailMember>> failMembers;

        public AskOwner() {
            HashMap r2 = null;
            this(r2, 0, 3, r2);
        }

        public final int getFailCount() {
            return this.failCount;
        }

        public final HashMap<String, List<FailMember>> getFailMembers() {
            return this.failMembers;
        }

        public final void setFailCount(int r1) {
            this.failCount = r1;
        }

        public AskOwner(HashMap<String, List<FailMember>> r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, "failMembers");
            this.failMembers = r2;
            this.failCount = r3;
        }

        public /* synthetic */ AskOwner(HashMap r1, int r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = new HashMap();
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = 0;
        L8:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/AskOwnerHelper$AskOwnerSendResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/AskOwnerHelper$AskOwner;", "<init>", "()V", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AskOwnerSendResult extends Result<AskOwner> {
        public AskOwnerSendResult() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/collaborator/invite/askowner/AskOwnerHelper$FailMember;", "Ljava/io/Serializable;", ResourceData.KEY_ID, "", "<init>", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "setId", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class FailMember implements Serializable {
        private String id;

        public final String getId() {
            return this.id;
        }

        public FailMember(String r2) {
            Intrinsics.checkNotNullParameter(r2, ResourceData.KEY_ID);
            this.id = r2;
        }

        public final void setId(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.id = r2;
        }
    }

    public static final class a implements NetService.c<AskOwnerSendResult> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.invite.askowner.AskOwnerHelper$a$a, reason: collision with other inner class name */
        public static final class C0089a {
        }

        static {
        }

        public a() {
        }

        public final Result parse(String r12) {
            Intrinsics.checkNotNullParameter(r12, "json");
            AskOwnerSendResult r0 = new AskOwnerSendResult();
            int r1 = 0;
            JSONObject r2 = new JSONObject(r12);     // Catch: Exception -> L14
            ((Result) r0).code = r2.optInt("code");     // Catch: Exception -> L14
            ((Result) r0).msg = r2.optString("msg");     // Catch: Exception -> L14
            if (((Result) r0).code != 0) goto L16;
            HashMap r4 = null;
            ((Result) r0).data = new AskOwner(r4, r1, 3, r4);     // Catch: Exception -> L14
            JSONObject r13 = JSONObjectProtectorUtils.getJSONObject(JSONObjectProtectorUtils.getJSONObject(r2, WikiFolderPushPlugin.DATA), "fail_members");     // Catch: Exception -> L14
            Iterator<String> r3 = r13.keys();     // Catch: Exception -> L14
        L7:
            if (r3.hasNext() == false) goto L16;
            String r5 = r3.next();     // Catch: Exception -> L14
            ArrayList r6 = new ArrayList();     // Catch: Exception -> L14
            JSONArray r7 = JSONObjectProtectorUtils.getJSONArray(r13, r5);     // Catch: Exception -> L14
            int r8 = r7.length();     // Catch: Exception -> L14
            int r9 = 0;
        L10:
            if (r9 >= r8) goto L12;
            FailMember r10 = new FailMember(r7.optJSONObject(r9).optString("owner_id"));     // Catch: Exception -> L14
            AskOwner r11 = (AskOwner) ((Result) r0).data;     // Catch: Exception -> L14
            r11.setFailCount(r11.getFailCount() + 1);     // Catch: Exception -> L14
            r6.add(r10);     // Catch: Exception -> L14
            r9 = r9 + 1;     // Catch: Exception -> L14
            goto L10
        L12:
            ((AskOwner) ((Result) r0).data).getFailMembers().put(r5, r6);     // Catch: Exception -> L14
        L16:
            return r0;
        L14:
            e = move-exception;
            tt5.a.f("AskerOwnerResultParser", e, false);
            goto L16
        }
    }

    static {
    }

    public static Flowable a(String r5, int r6, ArrayList r7, String r8) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r7, "invitedUsers");
        Intrinsics.checkNotNullParameter(r8, "notes");
        if (hu5.a.d(r7) == true) goto L5;
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        NetService.f r1 = new NetService.f("/space/api/suite/permission/ask_owner/members/create/");
        ((NetService.e) r1).c = 1;
        AskOwnerParams r2 = new AskOwnerParams();
        r2.setToken(r5);
        r2.setType(Integer.valueOf(r6));
        ArrayList r9 = new ArrayList();
        Iterator r10 = r7.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        UserInfo r11 = (UserInfo) r10.next();
        AskOwnerParams.MembersBean r3 = new AskOwnerParams.MembersBean();
        r3.setOwner_id(r11.getId());
        r3.setOwner_type(Integer.valueOf(r11.getOwnerType()));
        r3.setPermission(Integer.valueOf(r11.getPermission()));
        r9.add(r3);
        goto L8
    L10:
        r2.setMembers(r9);
        r2.setRemark(r8);
        ((NetService.e) r1).j = JSON.toJSONString(r2);
        return r0.Vc(new a()).a(r1);
    L5:
        return Flowable.error(new Throwable("users is empty"));
    }
}
