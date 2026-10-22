package com.bytedance.ee.bear.lark.todoblock;

import android.content.Intent;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class TodoBlockViewModel extends ViewModel {
    private static final String RESULT_DATA_KEY = "todo_assignee_result_data";
    public static final int SHOW_CREATE_REQUEST_CODE = 3;
    public static final int SHOW_SEARCH_ASSIGNEE_REQUEST_CODE = 1;
    public static final int SHOW_TASK_ASSIGNEE_REQUEST_CODE = 2;
    private static final String TAG = "TodoBlockViewModel";
    private a mDelegate;

    public interface a {
    }

    public TodoBlockViewModel() {
    }

    public a getDelegate() {
        return this.mDelegate;
    }

    public void setDelegate(a r1) {
        this.mDelegate = r1;
    }

    public void onActivityResult(int r5, int r6, Intent r7) {
        if (r6 == (-1)) goto L6;
        tt5.a.d(TAG, "onActivityResult error: resultCode = " + r6);
        return;
    L6:
        if (r7 != null) goto L9;
        tt5.a.d(TAG, "onActivityResult error: data = null!! ");
        return;
    L9:
        String r8 = r7.getStringExtra(RESULT_DATA_KEY);
        if (this.mDelegate != null) goto L12;
        tt5.a.d(TAG, "onActivityResult mDelegate is null");
        return;
    L12:
        if (r5 != 1) goto L19;
        JSONObject r9 = JSON.parseObject(r8);
        TodoBlockPlugin.a r10 = (TodoBlockPlugin.a) this.mDelegate;
        if (TodoBlockPlugin.access$300(r10.a) == null) goto L16;
        TodoBlockPlugin.access$300(r10.a).b(r9);
        tt5.a.b("TodoBlockPlugin", "onShowSearchCallback mSearchCallBack " + r9.toJSONString());
    L17:
        TodoBlockPlugin.access$400(r10.a);
        tt5.a.b(TAG, "onActivityResult mSearchCallBack " + r9.toJSONString());
        return;
    L16:
        tt5.a.d("TodoBlockPlugin", "onShowSearchCallback mSearchCallBack null ");
        goto L17
    L19:
        if (r5 != 2) goto L26;
        JSONObject r11 = JSON.parseObject(r8);
        TodoBlockPlugin.a r12 = (TodoBlockPlugin.a) this.mDelegate;
        if (TodoBlockPlugin.access$500(r12.a) == null) goto L23;
        TodoBlockPlugin.access$500(r12.a).b(r11);
        tt5.a.b("TodoBlockPlugin", "mTaskCallBack " + r11.toJSONString());
    L24:
        TodoBlockPlugin.access$400(r12.a);
        tt5.a.b(TAG, "onActivityResult mTaskCallBack " + r11.toJSONString());
        return;
    L23:
        tt5.a.d("TodoBlockPlugin", "onShowTaskCallback mTaskCallBack null ");
        goto L24
    L26:
        if (r5 != 3) goto L34;
        JSONObject r13 = JSON.parseObject(r8);
        if (r13 == null) goto L39;
        TodoBlockPlugin.a r14 = (TodoBlockPlugin.a) this.mDelegate;
        if (TodoBlockPlugin.access$500(r14.a) == null) goto L32;
        TodoBlockPlugin.access$500(r14.a).b(r13);
        tt5.a.b("TodoBlockPlugin", "onCreateTaskCallback " + r13.toJSONString());
    L33:
        TodoBlockPlugin.access$400(r14.a);
        tt5.a.b(TAG, "onActivityResult mTaskCallBack " + r13.toJSONString());
        return;
    L32:
        tt5.a.d("TodoBlockPlugin", "onCreateTaskCallback mTaskCallBack null ");
        goto L33
    L39:
        return;
    L34:
        tt5.a.d(TAG, "onActivityResult unknown request code");
    }
}
