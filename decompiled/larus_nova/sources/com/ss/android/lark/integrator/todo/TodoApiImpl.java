package com.ss.android.lark.integrator.todo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.alibaba.fastjson.JSON;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.bytedance.lark.pb.todo.v1.ContainerSection;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.chat.entity.message.content.TodoContent;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.todo.impl.features.center.v3.entity.TodoSceneType;
import com.ss.android.lark.todo.impl.features.center.v3.sidebar.TodoSidebarFragment;
import com.ss.android.lark.todo.impl.features.detail.assignee.display.AssigneeBaseMeta;
import com.ss.android.lark.todo.impl.features.detail.create.CreateTodoDocxParams;
import com.ss.android.lark.todo.impl.features.detail.viewmodel.data.SimpleSubTodoData;
import com.ss.android.lark.todo_api.ITodoApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONObject;
import ova.d;
import ova.f;
import pva.b;

/* JADX INFO: loaded from: classes36.dex */
@ClaymoreImpl(ITodoApi.class)
@Singleton
public class TodoApiImpl implements ITodoApi {
    private static final String TAG = "TodoApiImpl";

    public class a implements b {
        @Override // pva.b
        public final Map<String, d> a(Context r100) {
            return TodoModuleProvider.a().g();
        }
    }

    @Inject
    public TodoApiImpl() {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void bindViewWithShareTodoMsg(TextView r100, TextView r101, ImageView r102, TodoContent r103) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public String getFormatTodoTaskViewInChatText(String r100) {
        return "";
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public String getOpenTodoFromNoticeKey() {
        return "enter_todo_tab_from_offline_push";
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public boolean isTodoTabEnable() {
        return true;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public String getTodoPageName() {
        return TodoModuleProvider.a().getPageName();
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public boolean isTodoFlutterEnable() {
        return TodoDependencyHolder.b().a();
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public Map<String, String> getAutoInitModuleConfigMap() {
        return xrb.a.f564929a;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public Map<String, String> getThirdPartyModuleConfigMap() {
        return xrb.a.f564930b;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public Map<String, String> getThirdPartyPrefixModuleConfigMap() {
        return xrb.a.f564931c;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public Fragment getTodoDrawerFragment(wqb.a r100) {
        return new TodoSidebarFragment();
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public Intent getTodoIntentForWsChannelOfflinePush(String r100) {
        return TodoModuleProvider.a().d(r100);
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void initProcessorDoInit(String r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.equals("com.ss.android.lark.integrator.todo.wrapper.TodoModuleWrapper") == false) goto L10;
        jnb.a r101 = TodoModuleProvider.f428135a.getValue();
        return;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public boolean isTaskListUrl(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        Uri r101 = UriProtector.parse(r100);
        if (r101 != null) goto L8;
        return false;
    L8:
        f.m().getClass();
        if (f.q(r101) == true) goto L12;
        return false;
    L12:
        if (r101.getPath().equalsIgnoreCase("/client/todo/task_list") == true) goto L15;
        return false;
    L15:
        return !TextUtils.isEmpty(UriProtector.getQueryParameter(r101, "guid"));
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void onTodoDrawerClose(Fragment r100) {
        if ((r100 instanceof TodoSidebarFragment) == false) goto L8;
        TodoSidebarFragment r101 = (TodoSidebarFragment) r100;
        if (r101.isActive() == false) goto L9;
        r101.ba0().onDrawerClose();
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void onTodoDrawerWillShow(Fragment r100) {
        if ((r100 instanceof TodoSidebarFragment) == false) goto L8;
        TodoSidebarFragment r101 = (TodoSidebarFragment) r100;
        r101.getClass();
        int r102 = a9c.a.f2310a;
        a9c.a.c("todo_mobile_container_menu_view", new JSONObject());
        if (r101.isActive() == false) goto L9;
        r101.ba0().onDrawerWillShow();
        return;
    L9:
        return;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void startTodoSettingActivity(Activity r100) {
        TodoModuleProvider.a().startTodoSettingActivity(r100);
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void goCreateTaskActivityWithData(Context r110, Todo r111) {
        com.ss.android.lark.todo.impl.features.detail.a.a(r110, null, new SimpleSubTodoData(r111), "", "", false, "", TodoSceneType.INTERFACE, false, "", -1);
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void packageLaunchTodoTransPageIntent(Bundle r100, String r101) {
        r100.putBoolean("enter_todo_tab_from_offline_push", true);
        r100.putString("key_offline_push_todo_data", r101);
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void packageTodoOfflinePushNotice(Bundle r100, String r101) {
        r100.putBoolean("enter_todo_tab_from_offline_push", true);
        r100.putString("key_offline_push_todo_data", r101);
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void showTodoGuideDialog(Context r100, String r101) {
        TodoModuleProvider.a().c(r100);
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void startTodoAddAssigneeActivity(Fragment r100, int r101) {
        TodoModuleProvider.a().h(r100, r101);
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void startTodoCreateActivity(Fragment r100, String r101, int r110) {
        Log.i(TAG, "startTodoCreateActivity");
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L14
        String r103 = r102.optJSONObject(IOfflineExtraParser.ParserType.TODO).optJSONArray("relatedTaskListGuids").optString(0);     // Catch: Exception -> L14
        JSONArray r104 = r102.optJSONArray("taskListSections");     // Catch: Exception -> L14
        int r105 = 0;
    L5:
        if (r105 >= r104.length()) goto L11;
        JSONObject r106 = r104.optJSONObject(0);     // Catch: Exception -> L14
        if (TextUtils.equals(r106.optString("containerGuid"), r103) == true) goto L8;
        r105 = r105 + 1;
        goto L5
    L8:
        String r107 = r106.optString("sectionGuid");     // Catch: Exception -> L14
        String r108 = r106.optString("rank");     // Catch: Exception -> L14
    L12:
        CreateTodoDocxParams r109 = new CreateTodoDocxParams();     // Catch: Exception -> L14
        r109.setTaskListSection(new ContainerSection.Builder().container_guid(r103).section_guid(r107).rank(r108).build());     // Catch: Exception -> L14
        TodoModuleProvider.a().a(r100, r109, r110);     // Catch: Exception -> L14
        return;
    L11:
        r107 = "";
        r108 = "";
    L14:
        e = move-exception;
        TodoModuleProvider.a().a(r100, null, r110);
        Log.w(TAG, "startTodoCreateActivity", e);
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void startTodoDisplayAssigneeActivity(Fragment r110, String r111, int r112) {
        com.alibaba.fastjson.JSONObject r113 = JSON.parseObject(r111);     // Catch: Exception -> L11
        boolean r100 = r113.getBooleanValue("editable");     // Catch: Exception -> L11
        int r101 = 0;
        if (r113.getBooleanValue("enableMultiAssignee") == false) goto L9;
        com.alibaba.fastjson.JSONArray r114 = r113.getJSONArray("users");     // Catch: Exception -> L11
        ArrayList r102 = new ArrayList();     // Catch: Exception -> L11
    L6:
        if (r101 >= r114.size()) goto L8;
        com.alibaba.fastjson.JSONObject r103 = r114.getJSONObject(r101);     // Catch: Exception -> L11
        r102.add(new AssigneeBaseMeta(r103.getString("id"), r103.getString("name"), r103.getLongValue("completedMilliTime")));     // Catch: Exception -> L11
        r101 = r101 + 1;     // Catch: Exception -> L11
        goto L6
    L8:
        TodoModuleProvider.a().b(r110, r102, r100, r112);     // Catch: Exception -> L11
        return;
    L9:
        List<String> r115 = Arrays.asList((String[]) r113.getJSONArray("userIds").toArray(new String[0]));     // Catch: Exception -> L11
        TodoModuleProvider.a().f(r110, r115, r100, r112);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Log.w(TAG, "startTodoDisplayAssigneeActivity", e);
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public View getSendToChatView(Context r100, Drawable r101, String r102, View.OnClickListener r103) {
        return TodoModuleProvider.a().getSendToChatView(r100, r101, r102, r103);
    }
}
