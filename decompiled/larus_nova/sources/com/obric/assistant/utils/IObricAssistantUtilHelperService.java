package com.obric.assistant.utils;

import android.content.Intent;
import com.huawei.hms.api.FailedBinderCallBack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\\\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000528\u0010\u0006\u001a4\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00030\u00072\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000eH&JI\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H&¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/utils/IObricAssistantUtilHelperService;", "", "startActivityForResult", "", "intent", "Landroid/content/Intent;", "onSucceeded", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "result", "onFailed", "Lkotlin/Function0;", "mobClickTalkEnter", "botId", "", "conversationId", FailedBinderCallBack.CALLER_ID, "enterMethod", "duration", "params", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lorg/json/JSONObject;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAssistantUtilHelperService {
    void a(String r100, String r101, String r102, String r103, Integer r104, JSONObject r105);

    void startActivityForResult(Intent r100, Function2<? super Integer, ? super Intent, Unit> r101, Function0<Unit> r102);
}
