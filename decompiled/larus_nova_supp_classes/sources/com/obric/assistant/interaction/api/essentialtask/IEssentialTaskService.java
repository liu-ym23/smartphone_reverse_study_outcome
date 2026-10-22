package com.obric.assistant.interaction.api.essentialtask;

import android.app.Application;
import android.content.Context;
import android.util.EventsUtils;
import androidx.fragment.app.FragmentManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.i1;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\nH\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\fH&J\u001e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0016H&¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/interaction/api/essentialtask/IEssentialTaskService;", XmlPullParser.NO_NAMESPACE, "preInit", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "init", "Landroid/app/Application;", "startExecute", "isExecuteSucceed", XmlPullParser.NO_NAMESPACE, "isExecuteSucceedState", "Lkotlinx/coroutines/flow/StateFlow;", "doAfterExecuteSucceed", "action", "Ljava/lang/Runnable;", "getExecuteState", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState;", "showLoadingUI", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "onLoadSucceed", "Lkotlin/Function0;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IEssentialTaskService {
    void doAfterExecuteSucceed(Runnable r1);

    i1<ExecuteState> getExecuteState();

    void init(Application r1);

    boolean isExecuteSucceed();

    i1<Boolean> isExecuteSucceedState();

    void preInit(Context r1);

    void showLoadingUI(FragmentManager r1, Function0<Unit> r2);

    void startExecute();
}
