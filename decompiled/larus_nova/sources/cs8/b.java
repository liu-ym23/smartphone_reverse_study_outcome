package cs8;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.bmhome.chat.bean.d;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.bmhome.taskskill.f;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.AgentTaskParam;
import com.larus.im.bean.message.AgentTaskParamChange;
import com.larus.im.bean.message.GeneralTaskParam;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import td8.c;
import v19.i5;
import zd9.i;

/* JADX INFO: loaded from: classes26.dex */
public final class b implements c {

    public static final class a {
        public static String a(GeneralTaskParam r100) {
            AgentTaskParam r101 = r100.getAgentTaskParam();
            if (r101 == null) goto L18;
            Integer r102 = r101.getRuntimeType();
            boolean r103 = true;
            if (r102 != null) goto L8;
        L10:
            String r104 = r101.getDeviceName();
            if (r104 != null) goto L13;
        L16:
            if (r103 == true) goto L18;
            return r101.getDeviceName();
        L13:
            if (StringsKt.isBlank(r104) == true) goto L16;
            r103 = false;
            goto L16
        L8:
            if (r102.intValue() != 1) goto L10;
            return AppHost.f326268a.getApplication().getString(R.string.larus_office_task_runtime_cloud_computer_cn);
        L18:
            return null;
        }

        public static String b(GeneralTaskParam r100, String r110) {
            AgentTaskParam r101 = r100.getAgentTaskParam();
            if (r101 == null) goto L5;
            String r102 = r101.getLocalAppId();
        L7:
            if (Intrinsics.areEqual(r102, "1044603") == false) goto L9;
            int r103 = cs8.a.f465187a;
            int r104 = R.string.larus_change_device_runtime_doubao_work_cn;
        L11:
            if (r110 != null) goto L13;
        L16:
            boolean r105 = true;
        L17:
            if (r105 == true) goto L20;
            return StringsKt.replace$default(AppHost.f326268a.getApplication().getString(r104, new Object[]{r110}), "{ label }", r110, false, 4, null);
        L20:
            return StringsKt.replace$default(AppHost.f326268a.getApplication().getString(r104, new Object[]{r110}), "{ label }", "", false, 4, null);
        L13:
            if (StringsKt.isBlank(r110) == true) goto L16;
            r105 = false;
            goto L17
        L9:
            int r106 = cs8.a.f465187a;
            r104 = R.string.larus_change_device_runtime_default_cn;
            goto L11
        L5:
            r102 = null;
            goto L7
        }
    }

    static {
    }

    public b() {
    }

    @Override // td8.c
    public final boolean a(int r100, xc8.b r101, xc8.b r102, List<? extends xc8.b> r103) {
        Intrinsics.checkNotNullParameter(r102, "current");
        Intrinsics.checkNotNullParameter(r103, "input");
        return true;
    }

    @Override // td8.c
    public final List<xc8.b> b(int r610, xc8.b r710, xc8.b r711, List<xc8.b> r712) {
        Intrinsics.checkNotNullParameter(r711, "current");
        Intrinsics.checkNotNullParameter(r712, "input");
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = r712.iterator();
    L3:
        boolean r102 = false;
        if (r101.hasNext() == false) goto L13;
        Object r103 = r101.next();
        Integer r104 = b0.c(((xc8.b) r103).getMessage());
        if (r104 != null) goto L9;
    L11:
        if (r102 == true) goto L3;
        r100.add(r103);
        goto L3
    L9:
        if (r104.intValue() != 15) goto L11;
        r102 = true;
        goto L11
    L13:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r100.iterator();
        int r107 = 0;
    L15:
        if (r106.hasNext() == false) goto L74;
        Object r108 = r106.next();
        int r109 = r107 + 1;
        if (r107 >= 0) goto L19;
        CollectionsKt.throwIndexOverflow();
    L19:
        xc8.b r110 = (xc8.b) r108;
        r105.add(r110);
        Message r111 = r110.getMessage();
        String r112 = null;
        if (d.G0(r111) == false) goto L43;
        Map<String, String> r113 = r111.getExt();
        if (r113 == null) goto L43;
        String r114 = r113.get("general_task_param");
        if (r114 == null) goto L43;
        if ((!StringsKt.isBlank(r114)) == true) goto L30;
        r114 = null;
    L30:
        if (r114 == null) goto L43;
        GeneralTaskParam r115 = (GeneralTaskParam) i.a(r114, GeneralTaskParam.Companion.serializer());
        if (r115 == null) goto L43;
        AgentTaskParamChange r116 = r115.getAgentTaskParamChange();
        if (r116 == null) goto L43;
        if (r116.getRuntimeChanged() != true) goto L41;
    L44:
        if (r115 == null) goto L73;
        if (r107 == CollectionsKt.getLastIndex(r100)) goto L73;
        FLogger.f375446a.i("Pipeline_List_DeviceOrRuntimeChangedTask", "add device/runtime changed tip for message id: " + r110.getMessage().getMessageId());
        Message r117 = r110.getMessage();
        String r310 = com.larus.im.internal.core.message.converter.a.a(new TextContent(a.b(r115, a.a(r115)), null, null, null, null, null, null, null, 254, null), TextContent.Companion.serializer());
        Message r118 = b0.j(new Message(r117.getConversationId(), null, null, 0, 21, null, 1001, false, null, r310, null, null, null, null, null, r117.getMessageId() + "-device-runtime-changed", r117.getLocalIndex() - 1, 0, false, r117.getSectionId(), null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -623186, 31, null), 15);
        Application r119 = AppHost.f326268a.getApplication();
        String r120 = a.a(r115);
        if (r120 == null) goto L51;
        r112 = "￼".concat(r120);
    L51:
        CharSequence r121 = a.b(r115, r112);
        int r122 = StringsKt.indexOf$default(r121, "￼", 0, false, 6, null);
        if (r122 < 0) goto L72;
        AgentTaskParam r123 = r115.getAgentTaskParam();
        if (r123 == null) goto L62;
        Integer r124 = r123.getRuntimeType();
        if (r124 == null) goto L62;
        if (r124.intValue() != 1) goto L62;
        boolean r125 = true;
    L63:
        if (r125 == false) goto L65;
        int r126 = R.drawable.larus_ic_runtime_cloud_computer;
    L66:
        Drawable r127 = ContextCompat.getDrawable(r119, r126);
        if (r127 == null) goto L72;
        Drawable r128 = r127.mutate();
        if (r128 == null) goto L72;
        DrawableCompat.setTint(r128, ContextCompat.getColor(r119, v19.c.b(R.attr.larus_neutral_50, r119, R.color.larus_neutral_50)));
        SpannableStringBuilder r129 = new SpannableStringBuilder(r121);
        r129.setSpan(new f(r128, i5.m(), i5.z()), r122, r122 + 1, 33);
        r121 = r129;
        goto L72
    L65:
        r126 = R.drawable.larus_ic_runtime_local_computer;
    L62:
        r125 = false;
    L72:
        r105.add(new zr8.b(r118, r121));
    L73:
        r107 = r109;
        goto L15
    L41:
        if (r116.getDeviceChanged() == true) goto L44;
    L43:
        r115 = null;
        goto L44
    L74:
        return r105;
    }
}
