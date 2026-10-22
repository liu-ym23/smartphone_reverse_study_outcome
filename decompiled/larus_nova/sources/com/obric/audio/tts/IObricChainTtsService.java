package com.obric.audio.tts;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u0000 \r2\u00020\u0001:\u0001\rJ,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/obric/audio/tts/IObricChainTtsService;", "", "startByText", "", "ttsText", "", "conversationId", "messageId", "allowDuringDora", "", "hasActiveTts", "interruptTts", "reason", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricChainTtsService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f395811a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f395812a = null;

        static {
            f395812a = new a();
        }

        public a() {
        }

        public static IObricChainTtsService a() {
            return (IObricChainTtsService) ServiceManager.get().getService(IObricChainTtsService.class, false, false);
        }
    }

    static {
        f395811a = a.f395812a;
    }

    void a(String r100, String r101, String r102, boolean r103);

    boolean b();

    void c(String r100);
}
