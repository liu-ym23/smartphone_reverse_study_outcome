package com.ss.android.lark.todo.impl.features.setting;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.lark.pb.todo.v1.TodoBadgeConfig;
import com.bytedance.lark.pb.todo.v1.TodoSetting;
import com.larksuite.framework.callback.CallbackManager;
import com.ss.android.lark.log.Log;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u0012J\u001a\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0018R\"\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/setting/TodoBadgeSettingViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "badgeSettingShowLv", "Landroidx/lifecycle/MutableLiveData;", "Lcom/bytedance/lark/pb/todo/v1/TodoBadgeConfig;", "getBadgeSettingShowLv", "()Landroidx/lifecycle/MutableLiveData;", "setBadgeSettingShowLv", "(Landroidx/lifecycle/MutableLiveData;)V", "errorToastLv", "", "getErrorToastLv", "setErrorToastLv", "todoSetting", "Lcom/bytedance/lark/pb/todo/v1/TodoSetting;", "getTodoSetting", "()Lcom/bytedance/lark/pb/todo/v1/TodoSetting;", "setTodoSetting", "(Lcom/bytedance/lark/pb/todo/v1/TodoSetting;)V", "storeBadgeType", "Lcom/bytedance/lark/pb/todo/v1/TodoBadgeConfig$BadgeType;", "getStoreBadgeType", "()Lcom/bytedance/lark/pb/todo/v1/TodoBadgeConfig$BadgeType;", "setStoreBadgeType", "(Lcom/bytedance/lark/pb/todo/v1/TodoBadgeConfig$BadgeType;)V", "initSettingData", "", "updateTodoSetting", "updateBadgeSetting", "enable", "badgeType", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoBadgeSettingViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final String TAG = "TodoBadgeSettingViewModel";
    private MutableLiveData<TodoBadgeConfig> badgeSettingShowLv;
    private MutableLiveData<Boolean> errorToastLv;
    private TodoBadgeConfig.BadgeType storeBadgeType;
    private TodoSetting todoSetting;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final void initSettingData() {
        final String r100 = String.valueOf(new Date().getTime());
        final String r101 = "getTodoSetting";
        Log.i(TAG, com.ss.android.lark.todo.impl.utils.g.e(r100, "getTodoSetting", new String[0]));
        int r102 = t.f443998a;
        t.a.a(new AnonymousClass1(r100, r101, this), false);
    }

    public final MutableLiveData<TodoBadgeConfig> getBadgeSettingShowLv() {
        return this.badgeSettingShowLv;
    }

    public final MutableLiveData<Boolean> getErrorToastLv() {
        return this.errorToastLv;
    }

    public final TodoBadgeConfig.BadgeType getStoreBadgeType() {
        return this.storeBadgeType;
    }

    public final TodoSetting getTodoSetting() {
        return this.todoSetting;
    }

    public TodoBadgeSettingViewModel(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        super(r100);
        this.badgeSettingShowLv = new MutableLiveData();
        this.errorToastLv = new MutableLiveData();
        this.storeBadgeType = TodoBadgeConfig.BadgeType.OVERDUE;
    }

    public final void setBadgeSettingShowLv(MutableLiveData<TodoBadgeConfig> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.badgeSettingShowLv = r100;
    }

    public final void setErrorToastLv(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorToastLv = r100;
    }

    public final void setStoreBadgeType(TodoBadgeConfig.BadgeType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.storeBadgeType = r100;
    }

    public final void setTodoSetting(TodoSetting r100) {
        this.todoSetting = r100;
    }

    public final void updateTodoSetting(TodoSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "todoSetting");
        this.todoSetting = r100;
        TodoBadgeConfig r101 = r100.badge_config;
        if (r101 == null) goto L6;
        TodoBadgeConfig.BadgeType r102 = r101.type;
        if (r102 == null) goto L6;
    L7:
        this.storeBadgeType = r102;
        this.badgeSettingShowLv.postValue(r101);
        return;
    L6:
        r102 = TodoBadgeConfig.BadgeType.OVERDUE;
        goto L7
    }

    public final void updateBadgeSetting(boolean r100, TodoBadgeConfig.BadgeType r101) {
        if (r101 == null) goto L4;
        this.storeBadgeType = r101;
    L4:
        TodoSetting r102 = this.todoSetting;
        if (r102 == null) goto L11;
        final TodoBadgeConfig r103 = r102.badge_config;
        TodoBadgeConfig.Builder r104 = new TodoBadgeConfig.Builder().enable(Boolean.valueOf(r100));
        if (r101 != null) goto L9;
        r101 = this.storeBadgeType;
    L9:
        final TodoBadgeConfig r105 = r104.type(r101).build();
        TodoSetting r106 = r102.newBuilder().badge_config(r105).build();
        int r107 = t.f443998a;
        Intrinsics.checkNotNull(r106);
        t.a.b(r106, new CallbackManager().wrapAndAddGetDataCallback(new TodoBadgeSettingViewModel$updateBadgeSetting$1$1(this, r105, r103)));
        return;
    }

    public static /* synthetic */ void updateBadgeSetting$default(TodoBadgeSettingViewModel r100, boolean r101, TodoBadgeConfig.BadgeType r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.updateBadgeSetting(r101, r102);
    }
}
