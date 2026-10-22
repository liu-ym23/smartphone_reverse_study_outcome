package com.ss.android.lark.todo.impl.features.chatlist.mvvm;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.lark.pb.todo.v1.GetPagingTaskListMembersResponse;
import com.bytedance.lark.pb.todo.v1.TaskContainerPermission;
import com.bytedance.lark.pb.todo.v1.TaskItemMember;
import com.bytedance.lark.pb.todo.v1.TaskListMember;
import com.bytedance.lark.pb.todo.v1.TodoChat;
import com.bytedance.lark.pb.todo.v1.TodoDoc;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberRole;
import com.bytedance.lark.pb.todo.v1.TodoItemMemberType;
import com.bytedance.lark.pb.todo.v1.TodoUser;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.center.v3.entity.TodoFetchStatus;
import com.ss.android.lark.todo.impl.rustadapter.service.RustLog;
import com.ss.android.lark.todo.impl.rustadapter.service.TaskContainerService;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0007J(\u0010%\u001a\u00020#2\u0016\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)2\u0006\u0010 \u001a\u00020!H\u0002J\u0016\u0010*\u001a\u00020#2\u0006\u0010+\u001a\u00020!2\u0006\u0010,\u001a\u00020\u000bJ\u0006\u0010-\u001a\u00020#J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u00020\u001aH\u0002J\u0010\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u001aH\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\u001a2\u0006\u0010,\u001a\u00020\u000bH\u0002J\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000b0'j\b\u0012\u0004\u0012\u00020\u000b`)R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R'\u00105\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001a0'j\b\u0012\u0004\u0012\u00020\u001a`)06¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0017\u00109\u001a\b\u0012\u0004\u0012\u00020:06¢\u0006\b\n\u0000\u001a\u0004\b;\u00108R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000706¢\u0006\b\n\u0000\u001a\u0004\b=\u00108R\u0017\u0010>\u001a\b\u0012\u0004\u0012\u00020\u000706¢\u0006\b\n\u0000\u001a\u0004\b?\u00108R\u001f\u0010@\u001a\u0010\u0012\f\u0012\n A*\u0004\u0018\u00010\u00070\u000706¢\u0006\b\n\u0000\u001a\u0004\b@\u00108¨\u0006B"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/chatlist/mvvm/TaskListMembersViewModel;", "Landroidx/lifecycle/ViewModel;", "bundle", "Landroid/os/Bundle;", "<init>", "(Landroid/os/Bundle;)V", "isInvite", "", "owner", "Lcom/bytedance/lark/pb/todo/v1/TodoUser;", "note", "", "getNote", "()Ljava/lang/String;", "setNote", "(Ljava/lang/String;)V", "sendNote", "getSendNote", "()Z", "setSendNote", "(Z)V", "taskListId", "pageSize", "", "lastPageToken", "ownerMember", "Lcom/bytedance/lark/pb/todo/v1/TaskListMember;", "getOwnerMember", "()Lcom/bytedance/lark/pb/todo/v1/TaskListMember;", "setOwnerMember", "(Lcom/bytedance/lark/pb/todo/v1/TaskListMember;)V", "operatorId", "operatorRole", "Lcom/bytedance/lark/pb/todo/v1/TodoItemMemberRole;", "loadMembers", "", "isFirstPage", "initInviteMembers", "searchBaseInfos", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "Lkotlin/collections/ArrayList;", "setMemberRole", "role", "memberId", "inviteMembers", "getServerTaskListMember", "Lcom/ss/android/lark/pb/todo_entities/TaskListMember;", "taskListMember", "reviseServerMember", "member", "getTaskListMember", "getMemberIds", "members", "Landroidx/lifecycle/MutableLiveData;", "getMembers", "()Landroidx/lifecycle/MutableLiveData;", "loadingStatus", "Lcom/ss/android/lark/todo/impl/features/center/v3/entity/TodoFetchStatus;", "getLoadingStatus", "hasMore", "getHasMore", VideoEventOneOutSync.END_TYPE_FINISH, "getFinish", "isInviteBtnEnable", "kotlin.jvm.PlatformType", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskListMembersViewModel extends ViewModel {
    private final MutableLiveData<Boolean> finish;
    private final MutableLiveData<Boolean> hasMore;
    private boolean isInvite;
    private final MutableLiveData<Boolean> isInviteBtnEnable;
    private String lastPageToken;
    private final MutableLiveData<TodoFetchStatus> loadingStatus;
    private final MutableLiveData<ArrayList<TaskListMember>> members;
    private String note;
    private String operatorId;
    private TodoItemMemberRole operatorRole;
    private TodoUser owner;
    private TaskListMember ownerMember;
    private final int pageSize;
    private boolean sendNote;
    private String taskListId;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f442308a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f442309b = null;

        static {
            int[] r100 = new int[TodoItemMemberType.values().length];
            r100[TodoItemMemberType.USER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r100[TodoItemMemberType.GROUP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r100[TodoItemMemberType.DOCS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            f442308a = r100;
            int[] r101 = new int[TodoItemMemberRole.values().length];
            r101[TodoItemMemberRole.READER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r101[TodoItemMemberRole.WRITER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r101[TodoItemMemberRole.OWNER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[TodoItemMemberRole.INHERIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            f442309b = r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.chatlist.mvvm.TaskListMembersViewModel$inviteMembers$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.todo.impl.features.chatlist.mvvm.TaskListMembersViewModel$inviteMembers$1", f = "TaskListMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<TaskListMember> $taskListMembers;
        int label;
        final /* synthetic */ TaskListMembersViewModel this$0;

        public AnonymousClass1(TaskListMembersViewModel r100, ArrayList<TaskListMember> r101, Continuation<? super AnonymousClass1> r102) {
            this.this$0 = r100;
            this.$taskListMembers = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$taskListMembers, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L16;
            ResultKt.throwOnFailure(r100);
            TaskContainerService r101 = TaskContainerService.f444240a;
            String r102 = TaskListMembersViewModel.access$getTaskListId$p(this.this$0);
            HashMap r103 = new HashMap();
            ArrayList<TaskListMember> r104 = this.$taskListMembers;
            TaskListMembersViewModel r105 = this.this$0;
            Iterator<T> r106 = r104.iterator();
        L6:
            if (r106.hasNext() == false) goto L13;
            TaskListMember r107 = (TaskListMember) r106.next();
            if (r107.role == TodoItemMemberRole.OWNER) goto L6;
            com.ss.android.lark.pb.todo_entities.TaskListMember r108 = TaskListMembersViewModel.access$getServerTaskListMember(r105, r107);
            if (r108 == null) goto L6;
            r103.put(Boxing.boxLong(CastLongProtector.parseLong(r108.mmember_id)), r108);
            goto L6
        L13:
            Unit r109 = Unit.INSTANCE;
            boolean r110 = this.this$0.getSendNote();
            String r111 = this.this$0.getNote();
            final TaskListMembersViewModel r112 = this.this$0;
            TaskContainerService.h(r102, r103, r110, r111, new UIGetDataCallback(new AnonymousClass2(r112)));
            return Unit.INSTANCE;
        L16:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.chatlist.mvvm.TaskListMembersViewModel$loadMembers$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.todo.impl.features.chatlist.mvvm.TaskListMembersViewModel$loadMembers$1", f = "TaskListMembersViewModel.kt", i = {0}, l = {72}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class C122171 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isFirstPage;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TaskListMembersViewModel this$0;

        public C122171(TaskListMembersViewModel r100, boolean r101, Continuation<? super C122171> r102) {
            this.this$0 = r100;
            this.$isFirstPage = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C122171 r102 = new C122171(this.this$0, this.$isFirstPage, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C122171) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            CoroutineScope r103 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r100);
        L11:
            RustLog.b r104 = (RustLog.b) r100;
            if (r104 == null) goto L54;
            GetPagingTaskListMembersResponse r105 = (GetPagingTaskListMembersResponse) r104.f444238a;
            if (r105 == null) goto L54;
            TaskListMembersViewModel r106 = this.this$0;
            TaskListMembersViewModel.access$setLastPageToken$p(r106, r105.last_token);
            r106.getHasMore().postValue(r105.has_more);
            r106.getLoadingStatus().postValue(TodoFetchStatus.SUCCESS);
            ArrayList<TaskListMember> r107 = new ArrayList();
            ArrayList<TaskListMember> r108 = r106.getMembers().getValue();
            if (r108 == null) goto L18;
            r107.addAll(r108);
        L18:
            Iterator<TaskListMember> r109 = r105.task_list_members.iterator();
        L20:
            if (r109.hasNext() == false) goto L53;
            TaskListMember r110 = r109.next();
            TaskItemMember r111 = r110.member;
            String r112 = "";
            if (r111 == null) goto L27;
            TodoUser r113 = r111.user;
            if (r113 == null) goto L27;
            String r114 = r113.user_id;
            if (r114 == null) goto L27;
        L29:
            if (TaskListMembersViewModel.access$getTaskListMember(r106, r114) != null) goto L20;
            TaskItemMember r115 = r110.member;
            if (r115 == null) goto L36;
            TodoChat r116 = r115.chat;
            if (r116 == null) goto L36;
            String r117 = r116.chat_id;
            if (r117 == null) goto L36;
        L38:
            if (TaskListMembersViewModel.access$getTaskListMember(r106, r117) != null) goto L20;
            TaskItemMember r118 = r110.member;
            if (r118 == null) goto L48;
            TodoDoc r119 = r118.f253777doc;
            if (r119 == null) goto L48;
            String r120 = r119.f253781id;
            if (r120 == null) goto L48;
            r112 = r120;
        L48:
            if (TaskListMembersViewModel.access$getTaskListMember(r106, r112) != null) goto L20;
            if (r110.role == TodoItemMemberRole.OWNER) goto L51;
            Intrinsics.checkNotNull(r110);
            Boxing.boxBoolean(r107.add(TaskListMembersViewModel.access$reviseServerMember(r106, r110)));
            goto L20
        L51:
            r106.setOwnerMember(r110);
            ListProtector.add(r107, 0, r110);
        L36:
            r117 = "";
        L27:
            r114 = "";
            goto L29
        L53:
            r106.getMembers().postValue(r107);
        L59:
            return Unit.INSTANCE;
        L54:
            boolean r121 = this.$isFirstPage;
            TaskListMembersViewModel r122 = this.this$0;
            if (r121 == false) goto L57;
            r122.getLoadingStatus().postValue(TodoFetchStatus.FIRST_PAGE_FAILED);
            goto L59
        L57:
            r122.getLoadingStatus().postValue(TodoFetchStatus.NEXT_PAGE_FAILED);
            goto L59
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CoroutineScope r123 = (CoroutineScope) this.L$0;
            TaskContainerService r124 = TaskContainerService.f444240a;
            String r125 = TaskListMembersViewModel.access$getTaskListId$p(this.this$0);
            String r126 = TaskListMembersViewModel.access$getLastPageToken$p(this.this$0);
            int r127 = TaskListMembersViewModel.access$getPageSize$p(this.this$0);
            this.L$0 = r123;
            this.label = 1;
            r100 = TaskContainerService.f(r125, r126, r127, this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.todo.impl.features.chatlist.mvvm.TaskListMembersViewModel$setMemberRole$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.ss.android.lark.todo.impl.features.chatlist.mvvm.TaskListMembersViewModel$setMemberRole$1", f = "TaskListMembersViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C122181 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TaskListMember $member;
        final /* synthetic */ String $memberId;
        final /* synthetic */ TaskListMember $newMember;
        final /* synthetic */ TodoItemMemberRole $role;
        final /* synthetic */ com.ss.android.lark.pb.todo_entities.TaskListMember $serverMember;
        final /* synthetic */ ArrayList<TaskListMember> $taskListMembers;
        int label;
        final /* synthetic */ TaskListMembersViewModel this$0;

        public C122181(TaskListMembersViewModel r100, com.ss.android.lark.pb.todo_entities.TaskListMember r101, ArrayList<TaskListMember> r102, TaskListMember r103, TodoItemMemberRole r104, String r105, TaskListMember r106, Continuation<? super C122181> r107) {
            this.this$0 = r100;
            this.$serverMember = r101;
            this.$taskListMembers = r102;
            this.$member = r103;
            this.$role = r104;
            this.$memberId = r105;
            this.$newMember = r106;
            super(2, r107);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
            return new C122181(this.this$0, this.$serverMember, this.$taskListMembers, this.$member, this.$role, this.$memberId, this.$newMember, r111);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C122181) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r110);
            TaskContainerService r111 = TaskContainerService.f444240a;
            String r112 = TaskListMembersViewModel.access$getTaskListId$p(this.this$0);
            HashMap r100 = new HashMap();
            com.ss.android.lark.pb.todo_entities.TaskListMember r101 = this.$serverMember;
            r100.put(Boxing.boxLong(CastLongProtector.parseLong(r101.mmember_id)), r101);
            Unit r102 = Unit.INSTANCE;
            boolean r103 = this.this$0.getSendNote();
            String r104 = this.this$0.getNote();
            final ArrayList<TaskListMember> r105 = this.$taskListMembers;
            final TaskListMember r106 = this.$member;
            final TodoItemMemberRole r107 = this.$role;
            final String r108 = this.$memberId;
            final TaskListMembersViewModel r109 = this.this$0;
            final TaskListMember r113 = this.$newMember;
            TaskContainerService.h(r112, r100, r103, r104, new UIGetDataCallback(new AnonymousClass2(r105, r106, r107, r108, r109, r113)));
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final ArrayList<String> getMemberIds() {
        ArrayList<String> r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        ArrayList<TaskListMember> r102 = this.members.getValue();
        if (r102 == null) goto L5;
        r101.addAll(r102);
    L5:
        Iterator r103 = r101.iterator();
    L7:
        if (r103.hasNext() == false) goto L49;
        TaskListMember r104 = (TaskListMember) r103.next();
        TaskItemMember r105 = r104.member;
        if (r105 == null) goto L11;
        TodoItemMemberType r106 = r105.type;
    L12:
        if (r106 != null) goto L14;
        int r107 = -1;
    L15:
        String r108 = "";
        if (r107 != 1) goto L18;
        TaskItemMember r109 = r104.member;
        if (r109 == null) goto L48;
        TodoUser r110 = r109.user;
        if (r110 == null) goto L48;
        String r111 = r110.user_id;
        if (r111 == null) goto L48;
        r108 = r111;
    L48:
        r100.add(r108);
        goto L7
    L18:
        if (r107 != 2) goto L20;
        TaskItemMember r112 = r104.member;
        if (r112 == null) goto L39;
        TodoChat r113 = r112.chat;
        if (r113 == null) goto L39;
        String r114 = r113.chat_id;
        if (r114 == null) goto L39;
        r108 = r114;
    L39:
        r100.add(r108);
        goto L7
    L20:
        if (r107 != 3) goto L7;
        TaskItemMember r115 = r104.member;
        if (r115 == null) goto L30;
        TodoDoc r116 = r115.f253777doc;
        if (r116 == null) goto L30;
        String r117 = r116.f253781id;
        if (r117 == null) goto L30;
        r108 = r117;
    L30:
        r100.add(r108);
        goto L7
    L14:
        r107 = a.f442308a[r106.ordinal()];
        goto L15
    L11:
        r106 = null;
        goto L12
    L49:
        return r100;
    }

    public final void inviteMembers() {
        ArrayList r100 = new ArrayList();
        ArrayList<TaskListMember> r101 = this.members.getValue();
        if (r101 == null) goto L5;
        r100.addAll(r101);
    L5:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(this, r100, null), 3, null);
    }

    public final MutableLiveData<Boolean> getFinish() {
        return this.finish;
    }

    public final MutableLiveData<Boolean> getHasMore() {
        return this.hasMore;
    }

    public final MutableLiveData<TodoFetchStatus> getLoadingStatus() {
        return this.loadingStatus;
    }

    public final MutableLiveData<ArrayList<TaskListMember>> getMembers() {
        return this.members;
    }

    public final String getNote() {
        return this.note;
    }

    public final TaskListMember getOwnerMember() {
        return this.ownerMember;
    }

    public final boolean getSendNote() {
        return this.sendNote;
    }

    public final MutableLiveData<Boolean> isInviteBtnEnable() {
        return this.isInviteBtnEnable;
    }

    public TaskListMembersViewModel(Bundle r110) {
        String r100 = "";
        this.note = "";
        this.taskListId = "";
        this.pageSize = 30;
        this.lastPageToken = "";
        this.operatorId = TodoDependencyHolder.a().loginDependency().getUserId();
        TodoItemMemberRole r101 = TodoItemMemberRole.NONE;
        this.operatorRole = r101;
        this.members = new MutableLiveData();
        this.loadingStatus = new MutableLiveData();
        this.hasMore = new MutableLiveData();
        this.finish = new MutableLiveData();
        this.isInviteBtnEnable = new MutableLiveData(Boolean.TRUE);
        if (r110 == null) goto L5;
        boolean r102 = r110.getBoolean("task_list_members_is_invite", false);
    L6:
        this.isInvite = r102;
        if (r110 == null) goto L9;
        Serializable r103 = r110.getSerializable("task_list_container_owner");
    L11:
        if ((r103 instanceof TodoUser) == false) goto L13;
        TodoUser r104 = (TodoUser) r103;
    L14:
        this.owner = r104;
        if (r110 == null) goto L20;
        String r105 = r110.getString("task_list_members_container_id");
        if (r105 == null) goto L20;
        r100 = r105;
    L20:
        this.taskListId = r100;
        if (r110 == null) goto L23;
        int r106 = r110.getInt("task_list_operator_role_type", 0);
    L24:
        TodoItemMemberRole r107 = TodoItemMemberRole.fromValue(r106);
        if (r107 == null) goto L28;
        r101 = r107;
    L28:
        this.operatorRole = r101;
        if (r110 == null) goto L31;
        Serializable r108 = r110.getSerializable("task_list_members_roles");
    L33:
        if ((r108 instanceof ArrayList) == false) goto L35;
        ArrayList<SearchBaseInfo> r109 = (ArrayList) r108;
    L36:
        TodoUser r111 = this.owner;
        if (r111 == null) goto L40;
        this.ownerMember = new TaskListMember.Builder().role(TodoItemMemberRole.OWNER).member(new TaskItemMember.Builder().type(TodoItemMemberType.USER).user(new TodoUser.Builder().user_id(r111.user_id).name(r111.name).avatar_key(r111.avatar_key).build()).build()).build();
    L40:
        if (this.isInvite == false) goto L50;
        if (r109 == null) goto L50;
        if (r110 == null) goto L44;
        int r112 = r110.getInt("task_list_operator_role_type", 0);
    L45:
        TodoItemMemberRole r113 = TodoItemMemberRole.fromValue(r112);
        if (r113 != null) goto L48;
        r113 = TodoItemMemberRole.READER;
    L48:
        initInviteMembers(r109, r113);
        goto L50
    L44:
        r112 = 0;
    L50:
        if (this.isInvite == false) goto L52;
        return;
    L52:
        if (TextUtils.isEmpty(this.taskListId) == true) goto L56;
        loadMembers$default(this, false, 1, null);
        return;
    L56:
        return;
    L35:
        r109 = null;
        goto L36
    L31:
        r108 = null;
        goto L33
    L23:
        r106 = 0;
        goto L24
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L11
    L5:
        r102 = false;
        goto L6
    }

    public static final /* synthetic */ String access$getLastPageToken$p(TaskListMembersViewModel r100) {
        return r100.lastPageToken;
    }

    public static final /* synthetic */ String access$getOperatorId$p(TaskListMembersViewModel r100) {
        return r100.operatorId;
    }

    public static final /* synthetic */ int access$getPageSize$p(TaskListMembersViewModel r100) {
        return r100.pageSize;
    }

    public static final /* synthetic */ String access$getTaskListId$p(TaskListMembersViewModel r100) {
        return r100.taskListId;
    }

    private final com.ss.android.lark.pb.todo_entities.TaskListMember getServerTaskListMember(TaskListMember r100) {
        TaskItemMember r101 = r100.member;
        if (r101 == null) goto L5;
        TodoItemMemberType r102 = r101.type;
    L6:
        int r103 = -1;
        if (r102 != null) goto L9;
        int r104 = -1;
    L11:
        if (r104 == 1) goto L25;
        if (r104 == 2) goto L20;
        if (r104 == 3) goto L15;
    L14:
        String r105 = null;
    L30:
        if (r105 != null) goto L32;
        return null;
    L32:
        TaskItemMember r106 = r100.member;
        if (r106 == null) goto L35;
        TodoItemMemberType r107 = r106.type;
    L36:
        if (r107 != null) goto L38;
        int r108 = -1;
    L39:
        if (r108 == 1) goto L45;
        if (r108 == 2) goto L44;
        if (r108 == 3) goto L43;
        com.ss.android.lark.pb.todo_entities.TodoItemMemberType r109 = null;
    L46:
        if (r109 != null) goto L48;
        return null;
    L48:
        TodoItemMemberRole r110 = r100.role;
        if (r110 == null) goto L52;
        r103 = a.f442309b[r110.ordinal()];
    L52:
        if (r103 == 1) goto L61;
        if (r103 == 2) goto L60;
        if (r103 != 3) goto L56;
        com.ss.android.lark.pb.todo_entities.TodoItemMemberRole r111 = com.ss.android.lark.pb.todo_entities.TodoItemMemberRole.OWNER;
    L63:
        return new com.ss.android.lark.pb.todo_entities.TaskListMember.Builder().member_id(r105).role(r111).type(r109).build();
    L56:
        if (r103 == 4) goto L58;
        r111 = com.ss.android.lark.pb.todo_entities.TodoItemMemberRole.NONE;
        goto L63
    L58:
        r111 = com.ss.android.lark.pb.todo_entities.TodoItemMemberRole.INHERIT;
        goto L63
    L60:
        r111 = com.ss.android.lark.pb.todo_entities.TodoItemMemberRole.WRITER;
        goto L63
    L61:
        r111 = com.ss.android.lark.pb.todo_entities.TodoItemMemberRole.READER;
        goto L63
    L43:
        r109 = com.ss.android.lark.pb.todo_entities.TodoItemMemberType.DOCS;
        goto L46
    L44:
        r109 = com.ss.android.lark.pb.todo_entities.TodoItemMemberType.GROUP;
        goto L46
    L45:
        r109 = com.ss.android.lark.pb.todo_entities.TodoItemMemberType.USER;
        goto L46
    L38:
        r108 = a.f442308a[r107.ordinal()];
        goto L39
    L35:
        r107 = null;
        goto L36
    L15:
        TaskItemMember r112 = r100.member;
        if (r112 == null) goto L14;
        TodoDoc r113 = r112.f253777doc;
        if (r113 == null) goto L14;
        r105 = r113.f253781id;
        goto L30
    L20:
        TaskItemMember r114 = r100.member;
        if (r114 == null) goto L14;
        TodoChat r115 = r114.chat;
        if (r115 == null) goto L14;
        r105 = r115.chat_id;
        goto L30
    L25:
        TaskItemMember r116 = r100.member;
        if (r116 == null) goto L14;
        TodoUser r117 = r116.user;
        if (r117 == null) goto L14;
        r105 = r117.user_id;
        goto L30
    L9:
        r104 = a.f442308a[r102.ordinal()];
        goto L11
    L5:
        r102 = null;
        goto L6
    }

    private final TaskListMember getTaskListMember(String r100) {
        ArrayList r101 = new ArrayList();
        ArrayList<TaskListMember> r102 = this.members.getValue();
        if (r102 == null) goto L5;
        r101.addAll(r102);
    L5:
        Iterator r103 = r101.iterator();
    L6:
        String r104 = null;
        if (r103.hasNext() == false) goto L34;
        TaskListMember r105 = (TaskListMember) r103.next();
        TaskItemMember r106 = r105.member;
        if (r106 == null) goto L13;
        TodoChat r107 = r106.chat;
        if (r107 == null) goto L13;
        String r108 = r107.chat_id;
    L15:
        if (Intrinsics.areEqual(r108, r100) == true) goto L16;
        TaskItemMember r109 = r105.member;
        if (r109 == null) goto L22;
        TodoUser r110 = r109.user;
        if (r110 == null) goto L22;
        String r111 = r110.user_id;
    L24:
        if (Intrinsics.areEqual(r111, r100) == true) goto L25;
        TaskItemMember r112 = r105.member;
        if (r112 == null) goto L32;
        TodoDoc r113 = r112.f253777doc;
        if (r113 == null) goto L32;
        r104 = r113.f253781id;
    L32:
        if (Intrinsics.areEqual(r104, r100) == false) goto L6;
        return r105;
    L25:
        return r105;
    L22:
        r111 = null;
        goto L24
    L16:
        return r105;
    L13:
        r108 = null;
        goto L15
    L34:
        return null;
    }

    private final TaskListMember reviseServerMember(TaskListMember r100) {
        TaskItemMember r101 = r100.member;
        if (r101 == null) goto L7;
        TodoUser r102 = r101.user;
        if (r102 == null) goto L7;
        String r103 = r102.user_id;
    L9:
        if (Intrinsics.areEqual(r103, this.operatorId) == true) goto L11;
        return r100;
    L11:
        if (this.operatorRole == TodoItemMemberRole.WRITER) goto L13;
        return r100;
    L13:
        if (r100.role != TodoItemMemberRole.READER) goto L18;
        TaskListMember.Builder r104 = r100.newBuilder();
        HashMap r105 = new HashMap();
        r105.putAll(r100.permissions);
        r105.put(Integer.valueOf(TaskContainerPermission.Action.MANAGE_EDITOR.getValue()), Boolean.TRUE);
        return r104.permissions(r105).build();
    L18:
        return r100;
    L7:
        r103 = null;
        goto L9
    }

    public final void loadMembers(boolean r100) {
        if (r100 == false) goto L4;
        this.loadingStatus.postValue(TodoFetchStatus.LOADING);
    L4:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C122171(this, r100, null), 3, null);
    }

    public final void setNote(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.note = r100;
    }

    public final void setOwnerMember(TaskListMember r100) {
        this.ownerMember = r100;
    }

    public final void setSendNote(boolean r100) {
        this.sendNote = r100;
    }

    public static final /* synthetic */ com.ss.android.lark.pb.todo_entities.TaskListMember access$getServerTaskListMember(TaskListMembersViewModel r100, TaskListMember r101) {
        return r100.getServerTaskListMember(r101);
    }

    public static final /* synthetic */ TaskListMember access$getTaskListMember(TaskListMembersViewModel r100, String r101) {
        return r100.getTaskListMember(r101);
    }

    public static final /* synthetic */ TaskListMember access$reviseServerMember(TaskListMembersViewModel r100, TaskListMember r101) {
        return r100.reviseServerMember(r101);
    }

    public static final /* synthetic */ void access$setLastPageToken$p(TaskListMembersViewModel r100, String r101) {
        r100.lastPageToken = r101;
    }

    private final void initInviteMembers(ArrayList<SearchBaseInfo> r100, TodoItemMemberRole r101) {
        ArrayList<TaskListMember> r102 = new ArrayList();
        Iterator<SearchBaseInfo> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L27;
        SearchBaseInfo r104 = r103.next();
        SearchChatInfo r105 = null;
        if ((r104 instanceof SearchChatterInfo) == false) goto L8;
        SearchChatterInfo r106 = (SearchChatterInfo) r104;
    L9:
        if (r106 != null) goto L11;
    L13:
        TaskItemMember r107 = null;
    L15:
        if ((r104 instanceof SearchChatInfo) == false) goto L17;
        r105 = (SearchChatInfo) r104;
    L17:
        if (r105 != null) goto L19;
    L21:
        if (r107 == null) goto L4;
        TaskListMember.Builder r108 = new TaskListMember.Builder();
        TodoItemMemberRole r109 = TodoItemMemberRole.READER;
        if (r101 == r109) goto L26;
        r109 = TodoItemMemberRole.WRITER;
    L26:
        r102.add(r108.role(r109).member(r107).build());
        goto L4
    L19:
        if (r105.getChatType() != Chat.Type.GROUP) goto L21;
        r107 = new TaskItemMember.Builder().type(TodoItemMemberType.GROUP).chat(new TodoChat.Builder().chat_id(r105.getId()).avatar_key(r105.getAvatarKey()).name(r105.getTitle()).build()).build();
        goto L21
    L11:
        if (r106.getChatterType() != Chatter.ChatterType.USER) goto L13;
        r107 = new TaskItemMember.Builder().type(TodoItemMemberType.USER).user(new TodoUser.Builder().user_id(r106.getId()).avatar_key(r106.getAvatarKey()).name(r106.getTitle()).build()).build();
        goto L15
    L8:
        r106 = null;
        goto L9
    L27:
        this.members.postValue(r102);
    }

    public final void setMemberRole(TodoItemMemberRole r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "role");
        Intrinsics.checkNotNullParameter(r111, "memberId");
        ArrayList<TaskListMember> r100 = new ArrayList();
        ArrayList<TaskListMember> r101 = this.members.getValue();
        if (r101 == null) goto L5;
        r100.addAll(r101);
    L5:
        TaskListMember r102 = getTaskListMember(r111);
        if (r102 != null) goto L8;
        return;
    L8:
        TaskListMember r103 = r102.newBuilder().role(r110).build();
        if (this.isInvite == false) goto L17;
        int r104 = r100.indexOf(r102);
        r100.remove(r102);
        if (r110 != TodoItemMemberRole.NONE) goto L13;
    L16:
        this.members.postValue(r100);
        return;
    L13:
        if (r104 == (-1)) goto L15;
        ListProtector.add(r100, r104, r103);
        goto L16
    L15:
        r100.add(r103);
        goto L16
    L17:
        Intrinsics.checkNotNull(r103);
        com.ss.android.lark.pb.todo_entities.TaskListMember r105 = getServerTaskListMember(r103);
        if (r105 != null) goto L20;
        return;
    L20:
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C122181(this, r105, r100, r102, r110, r111, r103, null), 3, null);
    }

    public static /* synthetic */ void loadMembers$default(TaskListMembersViewModel r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = true;
    L5:
        r100.loadMembers(r101);
    }
}
