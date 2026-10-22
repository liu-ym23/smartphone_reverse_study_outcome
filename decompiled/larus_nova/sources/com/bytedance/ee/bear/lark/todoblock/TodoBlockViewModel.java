package com.bytedance.ee.bear.lark.todoblock;

import android.content.Intent;
import androidx.lifecycle.ViewModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
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

    public void setDelegate(a r100) {
        this.mDelegate = r100;
    }

    public void onActivityResult(int r100, int r101, Intent r102) {
        if (r101 == (-1)) goto L6;
        tt5.a.d(TAG, "onActivityResult error: resultCode = " + r101);
        return;
    L6:
        if (r102 != null) goto L9;
        tt5.a.d(TAG, "onActivityResult error: data = null!! ");
        return;
    L9:
        String r103 = r102.getStringExtra(RESULT_DATA_KEY);
        if (this.mDelegate != null) goto L12;
        tt5.a.d(TAG, "onActivityResult mDelegate is null");
        return;
    L12:
        if (r100 != 1) goto L19;
        JSONObject r104 = JSON.parseObject(r103);
        TodoBlockPlugin.a r105 = (TodoBlockPlugin.a) this.mDelegate;
        if (TodoBlockPlugin.access$300(r105.f227584a) == null) goto L16;
        TodoBlockPlugin.access$300(r105.f227584a).b(r104);
        tt5.a.b("TodoBlockPlugin", "onShowSearchCallback mSearchCallBack " + r104.toJSONString());
    L17:
        TodoBlockPlugin.access$400(r105.f227584a);
        tt5.a.b(TAG, "onActivityResult mSearchCallBack " + r104.toJSONString());
        return;
    L16:
        tt5.a.d("TodoBlockPlugin", "onShowSearchCallback mSearchCallBack null ");
        goto L17
    L19:
        if (r100 != 2) goto L26;
        JSONObject r106 = JSON.parseObject(r103);
        TodoBlockPlugin.a r107 = (TodoBlockPlugin.a) this.mDelegate;
        if (TodoBlockPlugin.access$500(r107.f227584a) == null) goto L23;
        TodoBlockPlugin.access$500(r107.f227584a).b(r106);
        tt5.a.b("TodoBlockPlugin", "mTaskCallBack " + r106.toJSONString());
    L24:
        TodoBlockPlugin.access$400(r107.f227584a);
        tt5.a.b(TAG, "onActivityResult mTaskCallBack " + r106.toJSONString());
        return;
    L23:
        tt5.a.d("TodoBlockPlugin", "onShowTaskCallback mTaskCallBack null ");
        goto L24
    L26:
        if (r100 != 3) goto L34;
        JSONObject r108 = JSON.parseObject(r103);
        if (r108 == null) goto L39;
        TodoBlockPlugin.a r109 = (TodoBlockPlugin.a) this.mDelegate;
        if (TodoBlockPlugin.access$500(r109.f227584a) == null) goto L32;
        TodoBlockPlugin.access$500(r109.f227584a).b(r108);
        tt5.a.b("TodoBlockPlugin", "onCreateTaskCallback " + r108.toJSONString());
    L33:
        TodoBlockPlugin.access$400(r109.f227584a);
        tt5.a.b(TAG, "onActivityResult mTaskCallBack " + r108.toJSONString());
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
