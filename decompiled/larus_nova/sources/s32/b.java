package s32;

import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.config.d8;
import com.bytedance.android.livesdk.config.e8;
import com.bytedance.android.livesdk.config.y00;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.StreamRecognitionCandidate;
import com.bytedance.android.livesdkapi.depend.model.live.StreamRecognitionContainers;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.android.livesdkapi.imagerecognition.ScaleConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f540445a = 0;

    static {
    }

    public static ImageRecognitionButton b(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        RoomAuthStatus r101 = z.o(r100).getRoomAuthStatus();
        if (r101 != null) goto L5;
    L7:
        e("RoomAuth", ImageRecognitionEntry.ClearScreen);
        return null;
    L5:
        if (r101.isEnableClearEntranceOption() != true) goto L7;
        return a(r100, ImageRecognitionEntry.ClearScreen);
    }

    public static ImageRecognitionButton c(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        RoomAuthStatus r101 = z.o(r100).getRoomAuthStatus();
        if (r101 != null) goto L5;
    L7:
        e("RoomAuth", ImageRecognitionEntry.LongPressPanel);
        return null;
    L5:
        if (r101.isEnableLongPressOption() != true) goto L7;
        return a(r100, ImageRecognitionEntry.LongPressPanel);
    }

    public static ScaleConfig d(int r100) {
        Map<Integer, e8> r101 = y00.f121644a.getValue().e();
        if (r101 == null) goto L7;
        e8 r102 = r101.get(Integer.valueOf(r100));
        if (r102 == null) goto L7;
        return new ScaleConfig(r102.d(), r102.b(), r102.a(), r102.c());
    L7:
        return null;
    }

    public static ImageRecognitionButton a(DataCenter r100, ImageRecognitionEntry r101) {
        IUserService r102 = (IUserService) k.f(IUserService.class);
        if (r102 == null) goto L50;
        com.bytedance.android.livesdk.user.f r103 = r102.user();
        if (r103 == null) goto L50;
        if (r103.isLogin() != true) goto L50;
        boolean r104 = false;
        if (((Number) r100.get("data_link_state", 0)).intValue() <= 2) goto L13;
        e("link state", r101);
        return null;
    L13:
        d8 r105 = y00.f121644a.getValue();
        List<Integer> r106 = r105.f();
        if (r106 != null) goto L17;
        r106 = CollectionsKt.emptyList();
    L17:
        if (r105.a() == true) goto L20;
        e("setting", r101);
        return null;
    L20:
        RoomOthersData r107 = z.o(r100).others;
        if (r107 == null) goto L25;
        StreamRecognitionContainers r108 = r107.getRecognitionContainers();
        if (r108 == null) goto L25;
        List<StreamRecognitionCandidate> r109 = r108.recognitionCandidates;
    L26:
        List<StreamRecognitionCandidate> r110 = r109;
        if (r110 != null) goto L29;
    L30:
        r104 = true;
    L31:
        if (r104 == false) goto L34;
        e("no server data", r101);
        return null;
    L34:
        Iterator<StreamRecognitionCandidate> r111 = r109.iterator();
    L36:
        if (r111.hasNext() == false) goto L48;
        StreamRecognitionCandidate r112 = r111.next();
        if (r106.contains(Integer.valueOf(r112.scene)) == true) goto L39;
        Map<Integer, ImageRecognitionBusiness> r113 = c.f540446a;
        int r114 = r112.scene;
        ImageRecognitionBusiness r115 = (ImageRecognitionBusiness) ((HashMap) c.f540446a).get(Integer.valueOf(r114));
        if (r115 == null) goto L43;
        ImageRecognitionButton r116 = r115.provide(r101);
    L44:
        if (r116 == null) goto L36;
        if (r116.canShow() != true) goto L36;
        return r116;
    L43:
        r116 = null;
        goto L44
    L39:
        e("in block list", r101);
        goto L36
    L48:
        e("no available candidate. candidate num is " + r109.size(), r101);
        return null;
    L29:
        if (r110.isEmpty() == false) goto L31;
    L25:
        r109 = null;
    L50:
        e("not login", r101);
        return null;
    }

    public static void e(String r100, ImageRecognitionEntry r101) {
        int r102 = f.f540454a;
        f.a("disabled entry=" + r101 + " reason=" + r100);
    }
}
