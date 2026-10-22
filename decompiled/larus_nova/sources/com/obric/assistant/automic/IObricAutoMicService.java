package com.obric.assistant.automic;

import android.os.Parcelable;
import com.obric.assistant.voice.ContentScene;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bg\u0018\u0000 %2\u00020\u0001:\u0001%J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J&\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00020\u000fH&J\u001e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0014H¦@¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u000fH&J \u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H&J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u0005H&¨\u0006&"}, d2 = {"Lcom/obric/assistant/automic/IObricAutoMicService;", "", "initService", "", "isSupportFeatureOfAutoMic", "", "tryInterruptAssistant", "scene", "Lcom/obric/assistant/voice/ContentScene;", "data", "Landroid/os/Parcelable;", "tryTurnOnMic", "autoStartTimeout", "tryTurnOffMic", DBDefinition.TASK_ID, "", "startCountDownTimer", "stopCountDownTimer", "setRelativeContent", "history", "Lcom/obric/assistant/voice/HistoryContent;", "getRelativeContent", "checkRelativeContent", "asrContent", "content", "(Ljava/lang/String;Lcom/obric/assistant/voice/HistoryContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPolishContent", "onTrackerEventStart", "onTrackerEventAsrEnd", "reason", "onTrackerEventVoiceAuthenResult", "result", "", "svScore", "", "onTrackerEventRelavance", "relavance", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAutoMicService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f385842a = null;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f385843a = null;

        static {
            f385843a = new a();
        }

        public a() {
        }

        public static IObricAutoMicService a() {
            return (IObricAutoMicService) ServiceManager.get().getService(IObricAutoMicService.class, false, false);
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b {
        public static /* synthetic */ boolean a(IObricAutoMicService r100, ContentScene r101, Parcelable r102) {
            return r100.d(r101, true, r102);
        }
    }

    static {
        f385842a = a.f385843a;
    }

    void a();

    com.obric.assistant.voice.a b(String r100);

    void c();

    boolean d(ContentScene r100, boolean r101, Parcelable r102);

    void e(ContentScene r100, Parcelable r101);

    boolean f();

    Object g(String r100, com.obric.assistant.voice.a r101, Continuation<? super String> r102);

    void h(String r100);

    void i(ContentScene r100, String r101);

    Object j(String r100, com.obric.assistant.voice.a r101, Continuation<? super Boolean> r102);

    void k(ContentScene r100, boolean r101);

    void l(ContentScene r100);

    void m(String r100, com.obric.assistant.voice.a r101);
}
