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
import com.bytedance.lark.pb.todo.v1.Todo;
import com.ss.android.lark.chat.entity.message.content.TodoContent;
import java.util.Map;
import wqb.a;

/* JADX INFO: loaded from: classes38.dex */
public interface ITodoApi {
    void bindViewWithShareTodoMsg(TextView r100, TextView r101, ImageView r102, TodoContent r103);

    Map<String, String> getAutoInitModuleConfigMap();

    String getFormatTodoTaskViewInChatText(String r100);

    String getOpenTodoFromNoticeKey();

    View getSendToChatView(Context r100, Drawable r101, String r102, View.OnClickListener r103);

    Map<String, String> getThirdPartyModuleConfigMap();

    Map<String, String> getThirdPartyPrefixModuleConfigMap();

    Fragment getTodoDrawerFragment(a r100);

    Intent getTodoIntentForWsChannelOfflinePush(String r100);

    String getTodoPageName();

    void goCreateTaskActivityWithData(Context r100, Todo r101);

    void initProcessorDoInit(String r100);

    boolean isTaskListUrl(String r100);

    boolean isTodoFlutterEnable();

    boolean isTodoTabEnable();

    void onTodoDrawerClose(Fragment r100);

    void onTodoDrawerWillShow(Fragment r100);

    void packageLaunchTodoTransPageIntent(Bundle r100, String r101);

    void packageTodoOfflinePushNotice(Bundle r100, String r101);

    void showTodoGuideDialog(Context r100, String r101);

    void startTodoAddAssigneeActivity(Fragment r100, int r101);

    void startTodoCreateActivity(Fragment r100, String r101, int r102);

    void startTodoDisplayAssigneeActivity(Fragment r100, String r101, int r102);

    void startTodoSettingActivity(Activity r100);
}
