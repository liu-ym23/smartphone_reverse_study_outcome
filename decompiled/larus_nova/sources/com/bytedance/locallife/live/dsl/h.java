package com.bytedance.locallife.live.dsl;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.LiveLocalLifeUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f259460a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<TemplateLoader.a> f259461b = null;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f259462a = null;

        static {
            f259462a = new a();
        }

        public a() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Iterator<T> r101 = ((List) r100).iterator();
        L4:
            if (r101.hasNext() == false) goto L17;
            TemplateLoader.a r102 = (TemplateLoader.a) r101.next();
            Iterator r103 = ((ArrayList) h.f259461b).iterator();
            int r104 = 0;
        L7:
            if (r103.hasNext() == false) goto L12;
            if (Intrinsics.areEqual(((TemplateLoader.a) r103.next()).f259415a, r102.f259415a) == true) goto L13;
            r104 = r104 + 1;
        L13:
            if (r104 >= 0) goto L15;
            ((ArrayList) h.f259461b).add(r102);
        L16:
            LiveLifeSaaSUtil.t().i("LiveLocalLiveDSLSourceProvider", "templateLoadState id:" + r102.f259415a + " result:" + r102.f259417c + " version:" + r102.f259416b);
            goto L4
        L15:
            ListProtector.set(h.f259461b, r104, r102);
            goto L16
        L12:
            r104 = -1;
            goto L13
        }
    }

    static {
        f259460a = CollectionsKt.listOf(new String[]{"live_life_shelf_item", "live_life_expound_card"});
        f259461b = new ArrayList();
    }

    public static String c() {
        String r100 = String.valueOf(LiveLifeSaaSUtil.u().e(LiveLifeSaaSUtil.q()));
        if (r100 != null) goto L6;
        return "-1";
    L6:
        return r100;
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "oriTemplateId");
        Object r101 = LiveLocalLifeUtil.b(r100);
        if ((r101 instanceof String) == false) goto L13;
        String r102 = (String) r101;
        String r103 = b(r102);
        if (r103 != null) goto L7;
        boolean r104 = false;
    L8:
        if (r104 == true) goto L11;
        r102 = r100;
    L11:
        LiveLifeSaaSUtil.t().d("LiveLocalLiveDSLSourceProvider", "ori_id " + r100 + ", final_id " + r102);
        return r102;
    L7:
        r104 = new PolarisFileWrapper(r103).exists();
        goto L8
    L13:
        return r100;
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_TEMPLATE_ID);
        String r101 = LiveLifeSaaSUtil.u().getChannelPath(LiveLifeSaaSUtil.q());
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return null;
    L5:
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101 + "/gaiaX_resource/" + r100);
        if (r102.exists() == true) goto L9;
        return null;
    L9:
        return r102.getAbsolutePath();
    }

    public static void d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        List<String> r101 = f259460a;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(a((String) r103.next()));
        goto L4
    L6:
        ArrayList r104 = new ArrayList();
        Iterator r105 = r102.iterator();
    L8:
        if (r105.hasNext() == false) goto L27;
        Object r106 = r105.next();
        String r107 = (String) r106;
        Iterator r108 = ((ArrayList) f259461b).iterator();
    L11:
        if (r108.hasNext() == false) goto L15;
        Object r109 = r108.next();
        if (Intrinsics.areEqual(((TemplateLoader.a) r109).f259415a, r107) == false) goto L11;
    L16:
        TemplateLoader.a r110 = (TemplateLoader.a) r109;
        if (r110 != null) goto L19;
    L24:
        boolean r111 = true;
    L25:
        if (r111 == false) goto L8;
        r104.add(r106);
        goto L8
    L19:
        if (r110.f259417c == false) goto L24;
        if (Intrinsics.areEqual(r110.f259416b, c()) == false) goto L24;
        r111 = false;
        goto L25
    L15:
        r109 = null;
        goto L16
    L27:
        LiveLifeSaaSUtil.t().i("LiveLocalLiveDSLSourceProvider", "id list " + r104);
        boolean r112 = TemplateLoader.f259411a;
        Intrinsics.checkNotNullParameter(r104, "templateIds");
        if (TemplateLoader.f259411a == false) goto L31;
        MutableLiveData<List<TemplateLoader.a>> r113 = TemplateLoader.f259412b;
    L37:
        if (r113 == null) goto L49;
        r113.observeForever(a.f259462a);
        return;
    L49:
        return;
    L31:
        if (r104.isEmpty() == false) goto L33;
        r113 = TemplateLoader.f259412b;
        goto L37
    L33:
        j r114 = TemplateLoader.f259413c;
        if (r114 == null) goto L36;
        ((Handler) TemplateLoader.f259414d.getValue()).removeCallbacks(r114);
    L36:
        TemplateLoader.f259412b = new MutableLiveData();
        TemplateLoader.f259413c = new j(r104);
        Handler r115 = (Handler) TemplateLoader.f259414d.getValue();
        j r116 = TemplateLoader.f259413c;
        Intrinsics.checkNotNull(r116);
        r115.post(r116);
        r113 = TemplateLoader.f259412b;
        goto L37
    }
}
