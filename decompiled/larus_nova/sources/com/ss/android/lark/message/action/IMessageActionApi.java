package com.ss.android.lark.message.action;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.lark.message.action.model.ActionContext;
import com.ss.android.lark.plugin.annotation.ScopeType;
import com.ss.android.lark.plugin.annotation.TrimisScope;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@TrimisScope(ScopeType.USER)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000eÀ\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/message/action/IMessageActionApi;", "", "getIcon", "Landroid/graphics/drawable/Drawable;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getLabel", "", "isVisible", "", "actionContext", "Lcom/ss/android/lark/message/action/model/ActionContext;", SendEventContainerMethodParamModel.EventKinds.onClick, "", "message-action-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IMessageActionApi {
    Drawable getIcon(Context r100);

    String getLabel(Context r100);

    boolean isVisible(Context r100, ActionContext r101);

    void onClick(Context r100, ActionContext r101);
}
