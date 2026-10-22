package mk5;

import com.bytedance.ee.bear.bitable.newform.NewLarkFormPlugin;
import com.ss.android.lark.officesdk.container.OfficeSDKUserScope;
import gk5.c;
import gk5.d;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import ok5.b;
import ok5.h;
import ok5.i;
import ok5.j;
import pk5.e;
import pk5.f;

/* JADX INFO: loaded from: classes18.dex */
@OfficeSDKUserScope
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, c> f514306a;

    @Inject
    public a() {
        this.f514306a = MapsKt.mapOf(new Pair[]{TuplesKt.to(NewLarkFormPlugin.FORM_BRIDGE_CONFIGURATION, new nk5.a()), TuplesKt.to("biz.forms.getPhoneContacts", new qk5.a()), TuplesKt.to("biz.forms.makePhoneCall", new qk5.c()), TuplesKt.to("biz.bitable.getLocation", new pk5.c()), TuplesKt.to("biz.bitable.reverseGeocodeLocation", new f()), TuplesKt.to("biz.bitable.openLocation", new e()), TuplesKt.to("biz.bitable.chooseLocation", new pk5.a()), TuplesKt.to("biz.bitable.chooseAttachment", new ok5.c()), TuplesKt.to("biz.bitable.checkAttachmentValid", new b()), TuplesKt.to("biz.bitable.previewAttachment", new i()), TuplesKt.to("biz.bitable.deleteAttachment", new h()), TuplesKt.to("biz.bitable.uploadAttachment", new j()), TuplesKt.to("biz.forms.audioStartRecord", new com.bytedance.ee.bear.office.h5jsb.handler.audio.b(new com.bytedance.ee.bear.office.h5jsb.handler.audio.a())), TuplesKt.to("biz.forms.audioStopRecord", new com.bytedance.ee.bear.office.h5jsb.handler.audio.c())});
    }

    @Override // gk5.d
    public final c Y5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "jsbName");
        return this.f514306a.get(r100);
    }
}
