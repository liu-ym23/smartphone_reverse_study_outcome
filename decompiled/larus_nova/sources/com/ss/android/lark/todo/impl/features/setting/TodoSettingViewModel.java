package com.ss.android.lark.todo.impl.features.setting;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.lark.pb.todo.v1.TodoBadgeConfig;
import com.bytedance.lark.pb.todo.v1.TodoSetting;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.callback.CallbackManager;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\bJ\u000e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0011J\u001e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001b2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0*H\u0002J\u0006\u0010+\u001a\u00020!R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006-"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/setting/TodoSettingViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "isReminderShowLv", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "setReminderShowLv", "(Landroidx/lifecycle/MutableLiveData;)V", "defaultReminderLv", "", "getDefaultReminderLv", "setDefaultReminderLv", "defaultReminderChosenIndex", "", "getDefaultReminderChosenIndex", "setDefaultReminderChosenIndex", "badgeSettingShowLv", "getBadgeSettingShowLv", "setBadgeSettingShowLv", "errorToastLv", "getErrorToastLv", "setErrorToastLv", "todoSetting", "Lcom/bytedance/lark/pb/todo/v1/TodoSetting;", "getTodoSetting", "()Lcom/bytedance/lark/pb/todo/v1/TodoSetting;", "setTodoSetting", "(Lcom/bytedance/lark/pb/todo/v1/TodoSetting;)V", "initSettingData", "", "updateLocalTodoSetting", "updateReminderStatus", "status", "onReminderDialogItemClicked", "index", "updateRemoteTodoSetting", "targetSetting", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "onReminderContainerClicked", "Companion", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TodoSettingViewModel extends AndroidViewModel {
    public static final a Companion = null;
    private static final String TAG = "TodoSettingViewModel";
    private MutableLiveData<Integer> badgeSettingShowLv;
    private MutableLiveData<Integer> defaultReminderChosenIndex;
    private MutableLiveData<String> defaultReminderLv;
    private MutableLiveData<Boolean> errorToastLv;
    private MutableLiveData<Boolean> isReminderShowLv;
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

    public final void onReminderContainerClicked() {
        MutableLiveData<Integer> r100 = this.defaultReminderChosenIndex;
        ArrayList<Integer> r101 = com.ss.android.lark.todo.impl.features.detail.time.f.f443555a;
        ArrayList<Integer> r102 = com.ss.android.lark.todo.impl.features.detail.time.f.f443555a;
        TodoSetting r103 = this.todoSetting;
        if (r103 == null) goto L7;
        Integer r104 = r103.due_reminder_offset;
        if (r104 == null) goto L7;
        int r105 = r104.intValue();
    L8:
        r100.postValue(Integer.valueOf(r102.indexOf(Integer.valueOf(r105))));
        return;
    L7:
        r105 = -1;
        goto L8
    }

    public final MutableLiveData<Integer> getBadgeSettingShowLv() {
        return this.badgeSettingShowLv;
    }

    public final MutableLiveData<Integer> getDefaultReminderChosenIndex() {
        return this.defaultReminderChosenIndex;
    }

    public final MutableLiveData<String> getDefaultReminderLv() {
        return this.defaultReminderLv;
    }

    public final MutableLiveData<Boolean> getErrorToastLv() {
        return this.errorToastLv;
    }

    public final TodoSetting getTodoSetting() {
        return this.todoSetting;
    }

    public final MutableLiveData<Boolean> isReminderShowLv() {
        return this.isReminderShowLv;
    }

    public TodoSettingViewModel(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "application");
        super(r100);
        this.isReminderShowLv = new MutableLiveData();
        this.defaultReminderLv = new MutableLiveData();
        this.defaultReminderChosenIndex = new MutableLiveData();
        this.badgeSettingShowLv = new MutableLiveData();
        this.errorToastLv = new MutableLiveData();
    }

    public final void onReminderDialogItemClicked(int r100) {
        if (r100 < 0) goto L37;
        ArrayList<Integer> r101 = com.ss.android.lark.todo.impl.features.detail.time.f.f443555a;
        if (r100 >= r101.size()) goto L39;
        final int r102 = ((Number) ListProtector.get(r101, r100)).intValue();
        a9c.b r103 = a9c.b.f2313a;
        JSONObject r104 = new JSONObject().put("click", BitableAnalytic.SelectSceneClickType.COMPLETE).put(PickerReporterConstants.KEY.TARGET, "setting_todo_view");
        if (r102 == (-1)) goto L32;
        if (r102 != 0) goto L10;
        String r105 = "alert_task_due";
    L33:
        a9c.b.b(r103, "setting_todo_default_alert_time_click", r104.put("status", r105), 4);
        this.defaultReminderLv.postValue(com.ss.android.lark.todo.impl.features.detail.time.f.b(r102));
        final TodoSetting r106 = this.todoSetting;
        if (r106 == null) goto L38;
        TodoSetting r107 = r106.newBuilder().due_reminder_offset(Integer.valueOf(r102)).build();
        Intrinsics.checkNotNull(r107);
        updateRemoteTodoSetting(r107, new TodoSettingViewModel$onReminderDialogItemClicked$1$1(r102, this, r106));
        return;
    L38:
        return;
    L10:
        if (r102 != 5) goto L12;
        r105 = "alert_5min_before";
        goto L33
    L12:
        if (r102 != 15) goto L14;
        r105 = "alert_15min_before";
        goto L33
    L14:
        if (r102 != 30) goto L16;
        r105 = "alert_30min_before";
        goto L33
    L16:
        if (r102 != 60) goto L18;
        r105 = "alert_1hour_before";
        goto L33
    L18:
        if (r102 != 120) goto L20;
        r105 = "alert_2hour_before";
        goto L33
    L20:
        if (r102 != 1440) goto L22;
        r105 = "alert_1day_before";
        goto L33
    L22:
        if (r102 != 2880) goto L32;
        r105 = "alert_2day_before";
    L32:
        r105 = "no_alert";
        goto L33
    L39:
        return;
    }

    public final void setBadgeSettingShowLv(MutableLiveData<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.badgeSettingShowLv = r100;
    }

    public final void setDefaultReminderChosenIndex(MutableLiveData<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.defaultReminderChosenIndex = r100;
    }

    public final void setDefaultReminderLv(MutableLiveData<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.defaultReminderLv = r100;
    }

    public final void setErrorToastLv(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorToastLv = r100;
    }

    public final void setReminderShowLv(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.isReminderShowLv = r100;
    }

    public final void setTodoSetting(TodoSetting r100) {
        this.todoSetting = r100;
    }

    public final void updateLocalTodoSetting(TodoSetting r100) {
        Intrinsics.checkNotNullParameter(r100, "todoSetting");
        this.todoSetting = r100;
        int r101 = s8c.a.f541021a;
        s8c.a.f541021a = r100.due_reminder_offset.intValue();
        this.isReminderShowLv.postValue(r100.enable_daily_remind);
        MutableLiveData<String> r102 = this.defaultReminderLv;
        ArrayList<Integer> r103 = com.ss.android.lark.todo.impl.features.detail.time.f.f443555a;
        r102.postValue(com.ss.android.lark.todo.impl.features.detail.time.f.b(r100.due_reminder_offset.intValue()));
        TodoBadgeConfig r104 = r100.badge_config;
        if (r104 != null) goto L5;
        return;
    L5:
        if (r104.enable.booleanValue() == true) goto L7;
        this.badgeSettingShowLv.postValue(Integer.valueOf(R.string.Todo_Settings_BadgeCountNone));
        return;
    L7:
        TodoBadgeConfig.BadgeType r105 = r104.type;
        if (r105 != TodoBadgeConfig.BadgeType.OVERDUE) goto L11;
        this.badgeSettingShowLv.postValue(Integer.valueOf(R.string.Todo_Settings_BadgeCountOverdue));
        return;
    L11:
        if (r105 != TodoBadgeConfig.BadgeType.OVERDUE_AND_TODAY) goto L14;
        this.badgeSettingShowLv.postValue(Integer.valueOf(R.string.Todo_Settings_BadgeCountOverdueAndToday));
        return;
    L14:
        if (r105 == TodoBadgeConfig.BadgeType.OWNED_BY_ME_UNFINISHED) goto L16;
        return;
    L16:
        if (TodoDependencyHolder.b().f2210a.a("todo.red_bot_owned_unfinish", false) == false) goto L18;
        this.badgeSettingShowLv.postValue(Integer.valueOf(R.string.Todo_Settings_BadgeCountOngoingOwned_Option));
        return;
    L18:
        this.badgeSettingShowLv.postValue(Integer.valueOf(R.string.Todo_Settings_BadgeCountOverdue));
    }

    public final void updateReminderStatus(final boolean r100) {
        TodoSetting r101 = this.todoSetting;
        if (r101 == null) goto L6;
        TodoSetting r102 = r101.newBuilder().enable_daily_remind(Boolean.valueOf(r100)).build();
        Intrinsics.checkNotNull(r102);
        updateRemoteTodoSetting(r102, new TodoSettingViewModel$updateReminderStatus$1$1(this, r100));
        return;
    }

    private final void updateRemoteTodoSetting(TodoSetting r100, final IGetDataCallback<Boolean> r101) {
        final String r102 = String.valueOf(new Date().getTime());
        final String r103 = "updateTodoSetting";
        Log.i(TAG, com.ss.android.lark.todo.impl.utils.g.e(r102, "updateTodoSetting", new String[0]));
        int r104 = t.f443998a;
        t.a.b(r100, new CallbackManager().wrapAndAddGetDataCallback(new C122701(r102, r103, r101, this)));
    }
}
