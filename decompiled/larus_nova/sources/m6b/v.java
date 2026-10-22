package m6b;

import com.bytedance.lark.pb.basic.v1.Message;
import com.larksuite.framework.utils.DeviceUtils;
import com.ss.android.lark.abtest.api.IABTestService;
import com.ss.android.lark.im.sdk.ImSdk;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.UIHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes35.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f512307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Integer, Double> f512308b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f512309a = null;

        static {
            f512309a = new v();
        }
    }

    public static int a() {
        List<iua.a<?>> r100 = com.ss.android.lark.monitor.abtest.a.f432336a;
        if (((Boolean) ((IABTestService) ApiUtils.getApi(IABTestService.class)).getAbTestValue(zrb.a.class, true)).booleanValue() == false) goto L5;
        float r101 = 55.0f;
    L7:
        return (DeviceUtils.getScreenHeight(ImSdk.f425890a.getContext()) / UIHelper.dp2px(r101)) + 1;
    L5:
        r101 = 20.0f;
        goto L7
    }

    public v() {
        this.f512307a = false;
        HashMap r100 = new HashMap();
        this.f512308b = r100;
        Integer r101 = Integer.valueOf(Message.Type.UNKNOWN.getValue());
        Double r102 = Double.valueOf(1.0d);
        r100.put(r101, r102);
        Integer r103 = Integer.valueOf(Message.Type.POST.getValue());
        Double r104 = Double.valueOf(2.0d);
        r100.put(r103, r104);
        Integer r105 = Integer.valueOf(Message.Type.FILE.getValue());
        Double r106 = Double.valueOf(1.5d);
        r100.put(r105, r106);
        r100.put(Integer.valueOf(Message.Type.TEXT.getValue()), r102);
        r100.put(Integer.valueOf(Message.Type.IMAGE.getValue()), r104);
        r100.put(Integer.valueOf(Message.Type.SYSTEM.getValue()), r102);
        r100.put(Integer.valueOf(Message.Type.AUDIO.getValue()), r102);
        Integer r107 = Integer.valueOf(Message.Type.SHARE_GROUP_CHAT.getValue());
        Double r108 = Double.valueOf(3.0d);
        r100.put(r107, r108);
        r100.put(Integer.valueOf(Message.Type.STICKER.getValue()), r104);
        r100.put(Integer.valueOf(Message.Type.MERGE_FORWARD.getValue()), r106);
        r100.put(Integer.valueOf(Message.Type.CALENDAR.getValue()), r108);
        r100.put(Integer.valueOf(Message.Type.CARD.getValue()), r108);
        r100.put(Integer.valueOf(Message.Type.MEDIA.getValue()), r104);
        r100.put(Integer.valueOf(Message.Type.SHARE_CALENDAR_EVENT.getValue()), r108);
        r100.put(Integer.valueOf(Message.Type.HONGBAO.getValue()), r104);
        r100.put(Integer.valueOf(Message.Type.VIDEO_CHAT.getValue()), Double.valueOf(2.5d));
        r100.put(Integer.valueOf(Message.Type.LOCATION.getValue()), Double.valueOf(3.5d));
        r100.put(Integer.valueOf(Message.Type.GENERAL_CALENDAR.getValue()), r108);
        r100.put(Integer.valueOf(Message.Type.TODO.getValue()), r108);
    }
}
