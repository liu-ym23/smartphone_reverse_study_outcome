package g58;

import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes24.dex */
public final class p extends com.larus.audio.call.p {
    @Override // com.larus.audio.call.p
    public final void c(long r100) {
    }

    @Override // com.larus.audio.call.p
    public final void b() {
        FLogger.f375446a.i("AiAsrManager", "Empty data expire time reached, end asr");
        com.larus.audio.ainotes.a.f288325a.a("emptyDataExpireTimer finish");
    }

    public p() {
        super(1800000, 1800000);
    }
}
