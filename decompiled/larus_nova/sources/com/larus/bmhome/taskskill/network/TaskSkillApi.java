package com.larus.bmhome.taskskill.network;

import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.POST;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015J\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\b\b\u0001\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\b\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\b\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\b\u001a\u00020\u0011H§@¢\u0006\u0002\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/taskskill/network/TaskSkillApi;", "", "listUserAndFeatured", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/taskskill/network/TaskSkillListResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentExposedSkills", "Lcom/larus/bmhome/taskskill/model/RecentExposedSkillResponse;", "request", "Lcom/larus/bmhome/taskskill/model/GetExposedSkillRequest;", "(Lcom/larus/bmhome/taskskill/model/GetExposedSkillRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportExposedSkills", "Lcom/larus/bmhome/taskskill/model/RecordExposedSkillResponse;", "Lcom/larus/bmhome/taskskill/model/ReportExposedSkillRequest;", "(Lcom/larus/bmhome/taskskill/model/ReportExposedSkillRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addRecentlyUsedSkill", "Lcom/larus/bmhome/taskskill/network/AddRecentlyUsedSkillResponse;", "Lcom/larus/bmhome/taskskill/network/RecentlyUsedSkillRequest;", "(Lcom/larus/bmhome/taskskill/network/RecentlyUsedSkillRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeRecentlyUsedSkill", "Lcom/larus/bmhome/taskskill/network/RemoveRecentlyUsedSkillResponse;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TaskSkillApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f314357a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f314358a = null;

        static {
            f314358a = new a();
        }

        public a() {
        }

        public static Object a(Function2 r110, ContinuationImpl r111) {
            FlowHttpConnection r100 = FlowHttpConnection.f359975a;
            return FlowHttpConnection.g(ServiceType.BASIC_SERVICE, TaskSkillApi.class, r110, false, null, null, null, r111, 248);
        }
    }

    static {
        f314357a = a.f314358a;
    }

    @POST("/alice/office/skills/suggestion/add")
    Object addRecentlyUsedSkill(@Body f r100, Continuation<? super BizResponse<com.larus.bmhome.taskskill.network.a>> r101);

    @POST("/alice/office/skills/get_exposed")
    Object getRecentExposedSkills(@Body bs8.d r100, Continuation<? super BizResponse<bs8.i>> r101);

    @POST("/alice/office/skills/list_user_and_featured")
    Object listUserAndFeatured(Continuation<? super BizResponse<k>> r100);

    @POST("/alice/office/skills/suggestion/remove")
    Object removeRecentlyUsedSkill(@Body f r100, Continuation<? super BizResponse<h>> r101);

    @POST("/alice/office/skills/record_exposed")
    Object reportExposedSkills(@Body bs8.l r100, Continuation<? super BizResponse<bs8.k>> r101);
}
