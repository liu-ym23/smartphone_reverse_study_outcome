package nc0;

import com.bytedance.android.livesdkapi.depend.model.live.linker.LinkerKickOutContent;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f518617a = null;

    static {
        int[] r100 = new int[LinkerKickOutContent.KickOutSource.values().length];
        f518617a = r100;
        r100[LinkerKickOutContent.KickOutSource.Unknown.ordinal()] = 1;
        r100[LinkerKickOutContent.KickOutSource.FromOrganizer.ordinal()] = 2;
        r100[LinkerKickOutContent.KickOutSource.General.ordinal()] = 3;
        r100[LinkerKickOutContent.KickOutSource.RTCLeave.ordinal()] = 4;
        r100[LinkerKickOutContent.KickOutSource.RTCUnLink.ordinal()] = 5;
    }
}
