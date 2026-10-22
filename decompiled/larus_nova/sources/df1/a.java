package df1;

import android.content.Context;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.larus.nova.R;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f468195a = 0;

    public static boolean a() {
        if (((IInteractService) k.n(IInteractService.class)).isLinkerUser(((IUserService) k.n(IUserService.class)).user().b()) == false) goto L9;
        if (((IInteractService) k.n(IInteractService.class)).isLinkerUserUnSilence(((IUserService) k.n(IUserService.class)).user().b()) == false) goto L9;
        boolean r100 = true;
    L10:
        if (r100 == false) goto L12;
    L13:
        return true;
    L12:
        if (b() == true) goto L13;
        return false;
    L9:
        r100 = false;
        goto L10
    }

    public static boolean b() {
        IInteractService r100 = (IInteractService) k.f(IInteractService.class);
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.enableCaptureAudioOnBackground(false) != true) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d() {
        Integer r100 = (Integer) hd0.c.f().f481009b;
        if (r100 != null) goto L6;
    L8:
        IInteractService r101 = (IInteractService) k.f(IInteractService.class);
        if (r101 != null) goto L11;
        return false;
    L11:
        if (r101.isAudienceLinkEngineOn() != true) goto L15;
        return true;
    L15:
        return false;
    L6:
        if (r100.intValue() != 2) goto L8;
        return true;
    }

    static {
    }

    public static String c(Context r100, Room r101) {
        String r102 = r101.getTitle();
        if (r102 != null) goto L12;
        if (r100 == null) goto L11;
        Object[] r103 = new Object[1];
        User r104 = r101.mo8271getOwner();
        if (r104 == null) goto L9;
        String r105 = r104.getNickName();
        if (r105 == null) goto L9;
    L10:
        r103[0] = r105;
        r102 = r100.getString(R.string.ttlive_audio_live_notification_default_title, r103);
    L9:
        r105 = "";
        goto L10
    L11:
        r102 = null;
    L12:
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102;
    }
}
