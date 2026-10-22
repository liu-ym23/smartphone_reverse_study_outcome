package hy9;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.view.AttachmentInfo;
import com.ss.android.cert.manager.constants.EventConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ny9.u;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f487642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f487643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f487644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f487645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f487646e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final u f487647f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f487648g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f487649h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final u7 f487650i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IChatDoubleTabAbility f487651j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ICoreInputAbility f487652k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f487653l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AttachmentInfo f487654m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<String> f487655n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f487656o;

    public f(Fragment r110, String r111, String r112, String r113, String r114, u r115, Map r116, String r117, u7 r118, IChatDoubleTabAbility r210, ICoreInputAbility r211, AttachmentInfo r212, String r213, int r214) {
        String r100 = null;
        if ((r214 & 2) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r214 & 4096) == 0) goto L9;
        AttachmentInfo r102 = null;
    L11:
        if ((r214 & 16384) == 0) goto L13;
        ArrayList r103 = new ArrayList();
    L15:
        if ((r214 & 32768) != 0) goto L18;
        r100 = r213;
    L18:
        Intrinsics.checkNotNullParameter(r110, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r112, "cvsId");
        Intrinsics.checkNotNullParameter(r113, EventConstant.Key.RETAIN_PROMPT);
        Intrinsics.checkNotNullParameter("coco_instruction", "actionBarKey");
        Intrinsics.checkNotNullParameter(r103, "inputFilePaths");
        this.f487642a = r110;
        this.f487643b = r101;
        this.f487644c = r112;
        this.f487645d = r113;
        this.f487646e = r114;
        this.f487647f = r115;
        this.f487648g = r116;
        this.f487649h = r117;
        this.f487650i = r118;
        this.f487651j = r210;
        this.f487652k = r211;
        this.f487653l = "coco_instruction";
        this.f487654m = r102;
        this.f487655n = r103;
        this.f487656o = r100;
        return;
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = r212;
        goto L11
    L5:
        r101 = r111;
        goto L7
    }
}
