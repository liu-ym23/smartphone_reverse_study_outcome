package kf9;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.im.internal.trace.manager.definition.AVCommonError;
import com.larus.im.internal.trace.manager.definition.AVMediaDeviceError;
import com.larus.im.internal.trace.manager.definition.AVTraceModalType;
import com.larus.im.internal.trace.manager.definition.AVTraceStatus;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f503197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f503198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f503199c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f503200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f503201e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f503202f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f503203g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f503204h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f503205i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f503206j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Object> f503207k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f503208l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AVCommonError f503209m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AVMediaDeviceError f503210n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public lf9.a f503211o;

    public a() {
        this.f503203g = AVTraceModalType.AUDIO.getValue();
        this.f503207k = new LinkedHashMap();
    }

    public final void b(String r100) {
        if (Intrinsics.areEqual(r100, this.f503206j) == true) goto L10;
        this.f503206j = r100;
        Map<String, Object> r101 = g.c(sf9.a.f(r100));
        if ((!r101.isEmpty()) == false) goto L12;
        Iterator r102 = ((LinkedHashMap) r101).entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        Map.Entry r103 = (Map.Entry) r102.next();
        this.f503207k.put((String) r103.getKey(), r103.getValue());
        goto L8
    L13:
        return;
    L12:
        return;
    }

    public final Map<String, Object> a(AVCommonError r100, Map<String, Object> r101) {
        if (r101 != null) goto L4;
        r101 = new LinkedHashMap();
    L4:
        g.a(r101, BdpAppEventConstant.PARAMS_UNIQUEID, this.f503197a);
        g.a(r101, BindCardPayConfirmConstants.Key.TRACE_ID, this.f503198b);
        g.a(r101, AudienceGamePromoteDetailActionHandler.PARA_BIZ_ID, this.f503199c);
        g.a(r101, "ab_vids", this.f503200d);
        g.a(r101, com.bytedance.android.ec.core.event.a.KEY_QUESTION_ID, this.f503201e);
        g.a(r101, "conversation_id", this.f503202f);
        g.a(r101, "bot_id", this.f503205i);
        Iterator r102 = ((LinkedHashMap) this.f503207k).entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        Object r105 = r103.getValue();
        if (r101.containsKey(r104) == true) goto L6;
        g.a(r101, r104, r105);
        goto L6
    L10:
        g.a(r101, "modal_type", Integer.valueOf(this.f503203g));
        g.a(r101, "session_type", this.f503204h);
        if (CollectionsKt.contains(CollectionsKt.listOf(new AVCommonError[]{AVCommonError.Interrupt, AVCommonError.Client_Interrupt, AVCommonError.Scene_Switched, AVCommonError.Image_Triggered}), r100) == false) goto L14;
        int r106 = AVTraceStatus.Interrupt.getValue();
    L19:
        g.a(r101, "status", Integer.valueOf(r106));
        if (r100 == null) goto L22;
        g.a(r101, "status_code", Integer.valueOf(r100.getCode()));
        g.a(r101, "status_msg", r100.getMsg());
        g.a(r101, "sub_status_code", r100.getSubCode());
        g.a(r101, "sub_status_msg", r100.getSubMsg());
    L22:
        return r101;
    L14:
        if (r100 != AVCommonError.Session_End) goto L16;
        r106 = AVTraceStatus.Session_End.getValue();
        goto L19
    L16:
        if (r100 == null) goto L18;
        r106 = AVTraceStatus.Fail.getValue();
        goto L19
    L18:
        r106 = AVTraceStatus.Success.getValue();
        goto L19
    }
}
