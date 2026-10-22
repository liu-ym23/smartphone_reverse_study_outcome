package com.larus.tts;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000 \n2\u00020\u0001:\u0001\nJ$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/larus/tts/IChatTtsService;", "", "getTtsSwitchStatus", "", "ttsSwitch", "", "isMainBot", "cvsId", "", "getGlobalTtsSwitchStatus", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IChatTtsService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f370172a = null;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/larus/tts/IChatTtsService$Companion;", "Lcom/larus/tts/IChatTtsService;", "<init>", "()V", "_delegate", "get_delegate", "()Lcom/larus/tts/IChatTtsService;", "getTtsSwitchStatus", "", "ttsSwitch", "", "isMainBot", "cvsId", "", "getGlobalTtsSwitchStatus", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements IChatTtsService {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ Companion f370173b = null;

        static {
            f370173b = new Companion();
        }

        private Companion() {
        }

        @Override // com.larus.tts.IChatTtsService
        public final boolean a(int r100) {
            IChatTtsService r101 = (IChatTtsService) ServiceManager.get().getService(IChatTtsService.class);
            if (r101 != null) goto L6;
            r101 = new ChatTtsServiceNoop();
        L6:
            return r101.a(r100);
        }

        @Override // com.larus.tts.IChatTtsService
        public final boolean b(int r100, boolean r101, String r102) {
            IChatTtsService r103 = (IChatTtsService) ServiceManager.get().getService(IChatTtsService.class);
            if (r103 != null) goto L6;
            r103 = new ChatTtsServiceNoop();
        L6:
            return r103.b(r100, r101, r102);
        }
    }

    static {
        f370172a = Companion.f370173b;
    }

    boolean a(int r100);

    boolean b(int r100, boolean r101, String r102);
}
