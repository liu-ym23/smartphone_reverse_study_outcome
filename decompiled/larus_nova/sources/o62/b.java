package o62;

import com.bytedance.android.live.fifa.core.IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel;
import com.bytedance.android.livesdk.interactivity.chatchannel.model.ChannelLinkUserInfo;

/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f522168a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f522169b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f522170c = null;

    static {
        int[] r100 = new int[IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.values().length];
        f522168a = r100;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r101 = IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.SILENT;
        r100[r101.ordinal()] = 1;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r102 = IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.LEVEL_1;
        r100[r102.ordinal()] = 2;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r103 = IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.LEVEL_2;
        r100[r103.ordinal()] = 3;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r104 = IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.LEVEL_3;
        r100[r104.ordinal()] = 4;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r105 = IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.LEVEL_4;
        r100[r105.ordinal()] = 5;
        IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel r110 = IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.LEVEL_5;
        r100[r110.ordinal()] = 6;
        int[] r106 = new int[IChannelLinkService$IOnlineUserLinkerStatus$VolumeLevel.values().length];
        f522169b = r106;
        r106[r101.ordinal()] = 1;
        r106[r102.ordinal()] = 2;
        r106[r103.ordinal()] = 3;
        r106[r104.ordinal()] = 4;
        r106[r105.ordinal()] = 5;
        r106[r110.ordinal()] = 6;
        int[] r107 = new int[ChannelLinkUserInfo.ChannelUserRole.values().length];
        f522170c = r107;
        r107[ChannelLinkUserInfo.ChannelUserRole.LinkApplicant.ordinal()] = 1;
        r107[ChannelLinkUserInfo.ChannelUserRole.LinkInvitee.ordinal()] = 2;
    }
}
