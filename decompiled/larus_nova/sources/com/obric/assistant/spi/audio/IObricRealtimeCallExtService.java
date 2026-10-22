package com.obric.assistant.spi.audio;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.obric.assistant.session.singleton.r;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH&J$\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010H&J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\nH&J\b\u0010\u0016\u001a\u00020\u0012H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J<\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010!H¦@¢\u0006\u0002\u0010\"J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u0018H&J\b\u0010&\u001a\u00020\u0012H&¨\u0006'"}, d2 = {"Lcom/obric/assistant/spi/audio/IObricRealtimeCallExtService;", "", "init", "", "setShowWhenLockedForExistingRealtimeCallActivity", "onRealtimeCallActivityFinish", "activity", "Landroidx/fragment/app/FragmentActivity;", "onRealtimeCallActivityOnNewIntent", "newIntent", "Landroid/content/Intent;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "getNotificationPendingIntent", "Landroid/app/PendingIntent;", "packageContext", "Landroid/content/Context;", "isGoToChatPage", "", "currentContext", "isRealtimeCallActivity", "intent", "hasRealtimeCallActivity", "getCurrentCallType", "Lcom/obric/assistant/spi/audio/CallType;", "launchRealtimeCall", "Lcom/obric/assistant/spi/audio/LaunchRealtimeCallResult;", "callType", "from", "", "delayJumpMS", "", "onPreJump", "Lkotlin/Function0;", "(Lcom/obric/assistant/spi/audio/CallType;Ljava/lang/String;JLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "changeCallType", "currentCallType", "targetCallType", "isAssistantListening", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricRealtimeCallExtService {

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a {
        public static /* synthetic */ Object a(IObricRealtimeCallExtService r100, CallType r101, String r102, long r110, r r111, Continuation r112, int r113) {
            if ((r113 & 2) == 0) goto L5;
            r102 = "obric_ai_key";
        L5:
            String r103 = r102;
            if ((r113 & 4) == 0) goto L8;
            r110 = 0;
        L8:
            long r104 = r110;
            if ((r113 & 8) == 0) goto L12;
            r111 = null;
        L12:
            return r100.launchRealtimeCall(r101, r103, r104, r111, r112);
        }
    }

    CallType getCurrentCallType();

    PendingIntent getNotificationPendingIntent(Context r100, boolean r101, Context r102);

    boolean hasRealtimeCallActivity();

    void init();

    boolean isAssistantListening();

    Object launchRealtimeCall(CallType r100, String r101, long r102, Function0<Unit> r103, Continuation<? super com.obric.assistant.spi.audio.a> r104);

    void onRealtimeCallActivityFinish(FragmentActivity r100);

    void onRealtimeCallActivityOnNewIntent(FragmentActivity r100, Intent r101, Fragment r102);

    void setShowWhenLockedForExistingRealtimeCallActivity();
}
