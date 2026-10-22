package com.ss.android.lark.todo_api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bytedance.i18n.claymore.ClaymoreNoop;
import com.bytedance.lark.pb.todo.v1.Todo;
import com.ss.android.lark.chat.entity.message.content.TodoContent;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import wqb.a;

/* JADX INFO: loaded from: classes38.dex */
@Singleton
@ClaymoreNoop(ITodoApi.class)
public class TodoApiMock implements ITodoApi {
    @Inject
    public TodoApiMock() {
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
        return "";
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public Intent getTodoIntentForWsChannelOfflinePush(String r100) {
        return null;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public String getTodoPageName() {
        return "";
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void goCreateTaskActivityWithData(Context r100, Todo r101) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void initProcessorDoInit(String r100) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public boolean isTaskListUrl(String r100) {
        return false;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public boolean isTodoFlutterEnable() {
        return false;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public boolean isTodoTabEnable() {
        return false;
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void onTodoDrawerClose(Fragment r100) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void onTodoDrawerWillShow(Fragment r100) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void packageLaunchTodoTransPageIntent(Bundle r100, String r101) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void packageTodoOfflinePushNotice(Bundle r100, String r101) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void showTodoGuideDialog(Context r100, String r101) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void startTodoAddAssigneeActivity(Fragment r100, int r101) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void startTodoCreateActivity(Fragment r100, String r101, int r102) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void startTodoDisplayAssigneeActivity(Fragment r100, String r101, int r102) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public void startTodoSettingActivity(Activity r100) {
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public Map<String, String> getAutoInitModuleConfigMap() {
        return new HashMap();
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public Map<String, String> getThirdPartyModuleConfigMap() {
        return new HashMap();
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public Map<String, String> getThirdPartyPrefixModuleConfigMap() {
        return new HashMap();
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public Fragment getTodoDrawerFragment(a r100) {
        return new Fragment();
    }

    @Override // com.ss.android.lark.todo_api.ITodoApi
    public View getSendToChatView(Context r100, Drawable r101, String r102, View.OnClickListener r103) {
        return new View(r100);
    }
}
