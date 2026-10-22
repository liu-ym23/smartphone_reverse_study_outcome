package com.ss.android.lark.todo.impl.features.remind.notification.offline.pass_through;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.notification.export.AbstractNotification;
import com.ss.android.lark.notification.export.offline.IOfflineExtraParser;
import com.ss.android.lark.todo.dependency.TodoDependencyHolder;
import com.ss.android.lark.utils.LarkContext;
import dtb.b;
import dtb.c;
import q8c.a;

/* JADX INFO: loaded from: classes38.dex */
@ClaymoreImpl(IOfflineExtraParser.class)
public class TodoOfflineExtraParser implements IOfflineExtraParser {
    private static final String KEY_EXTRA_STR = "extra_str";
    private static final String KEY_USER_ID = "user_id";
    private static final String TAG = "TodoOfflineExtraParser";
    private String mBizExtraStr;
    private final String mSid;
    private String mUserId;

    public /* bridge */ /* synthetic */ String getChannelId() {
        return AbstractNotification.CHANNEL_TYPE.NORMAL;
    }

    public String getParserType() {
        return IOfflineExtraParser.ParserType.TODO;
    }

    public int getNotificationId() {
        return c.a(this.mSid, TAG);
    }

    public Intent getTargetIntent() {
        Intent r100 = getLaunchTodoTransPageIntent(this.mBizExtraStr);
        r100.putExtra("user_id", this.mUserId);
        return r100;
    }

    public TodoOfflineExtraParser(b r100) {
        this.mUserId = "";
        throw null;
    }

    private Intent getLaunchTodoTransPageIntent(String r100) {
        Intent r101 = a.a(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        Intent r102 = TodoDependencyHolder.a().mainModuleDependency().c(LarkContext.getApplication());
        if (TextUtils.isEmpty(r100) == true) goto L8;
        Bundle r103 = new Bundle();
        packageLaunchTodoTransPageIntent(r103, r100);
        r102.putExtras(r103);
    L8:
        return r102;
    }

    private void packageLaunchTodoTransPageIntent(Bundle r100, String r101) {
        r100.putBoolean("enter_todo_tab_from_offline_push", true);
        r100.putString("key_offline_push_todo_data", r101);
    }
}
