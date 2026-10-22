package com.larus.bmhome.chat.bubble.floating.runtime;

import android.content.Context;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerDismissReason;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerEnterTrigger;
import com.larus.bmhome.chat.bubble.floating.BubbleBannerRenderPart;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bH&J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bH&J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bH&J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0018\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH&J \u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 H&J\u0012\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050#2\u0006\u0010\u0011\u001a\u00020\bH&J\u0012\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\bH&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH&J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010'\u001a\u00020(H&J\u0018\u0010)\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010'\u001a\u00020(H&¨\u0006*"}, d2 = {"Lcom/larus/bmhome/chat/bubble/floating/runtime/IBubbleBannerRuntimeService;", "", "add", "", EventConstant.Key.RETAIN_PROMPT, "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerModel;", "resolveRenderPlan", "promptId", "", "anchorMessageId", "markEnterTriggerReady", "", "trigger", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerEnterTrigger;", "onPromptShownOnScreen", "markEnterAnimationConsumed", "onPageEnter", "conversationId", "onPageLeave", "onHostUnavailable", "ensureAutoDismissScheduled", "onPromptClick", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "dismiss", "reason", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerDismissReason;", "clear", "completeDismiss", "markExitPartFinished", "transitionId", "part", "Lcom/larus/bmhome/chat/bubble/floating/BubbleBannerRenderPart;", MonitorConstants.CONNECT_TYPE_GET, "getPrompts", "", "getWinnerPrompt", "hasPrompts", "attachRefreshListener", "listener", "Lcom/larus/bmhome/chat/bubble/floating/runtime/BubbleBannerRuntime$RefreshListener;", "detachRefreshListener", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBubbleBannerRuntimeService {
    void a(String r100);

    void b(String r100);

    boolean c(String r100);

    void d(String r100, BubbleBannerEnterTrigger r101);

    void e(String r100);

    void f(String r100);

    pc8.e g(String r100, String r101);

    pc8.e get(String r100);

    boolean h(String r100, BubbleBannerDismissReason r101);

    void i(String r100);

    void j(Context r100, String r101);

    void k(String r100, String r101, BubbleBannerRenderPart r102);

    void l(String r100, k.a r101);

    void m(String r100, BubbleBannerDismissReason r101);

    void n(String r100);

    void o(String r100);

    boolean p(pc8.e r100);

    pc8.e q(String r100);

    void r(String r100, k.a r101);
}
