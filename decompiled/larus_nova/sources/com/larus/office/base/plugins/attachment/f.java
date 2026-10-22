package com.larus.office.base.plugins.attachment;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSONObject;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.ee.bear.document.matermark.CCMWatermarkManager;
import com.bytedance.ee.permission.PermissionSdk;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.bigimg.BigImagePhotoViewerDialog;
import com.larus.bmhome.bigimg.n1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import okio.ByteString;
import uo8.k;

/* JADX INFO: loaded from: classes29.dex */
public final class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f360705g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final xm9.a f360706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f360707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f360708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ImageDataModel f360709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigImagePhotoViewerDialog f360710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f360711f;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f360712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f360713b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f360712a == r101.f360712a) goto L12;
            return false;
        L12:
            if (this.f360713b == r101.f360713b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f360712a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f360713b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "PermissionResult(downloadAllowed=" + this.f360712a + ", copyAllowed=" + this.f360713b + ')';
        }

        public b(boolean r100, boolean r101) {
            this.f360712a = r100;
            this.f360713b = r101;
        }
    }

    public static final class c implements com.larus.bmhome.bigimg.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Map<String, String>, Unit> f360714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageDataModel f360715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f360716c;

        @Override // com.larus.bmhome.bigimg.e
        public final void b(int r100, zo8.a r101) {
            Function1<Map<String, String>, Unit> r102 = this.f360714a;
            if (r102 == null) goto L13;
            Pair[] r103 = new Pair[2];
            r103[0] = TuplesKt.to("type", com.bytedance.android.ec.core.event.a.VALUE_ACTION_TYPE_SWIPE);
            ImageDataModel r104 = this.f360715b;
            if (r104 == null) goto L11;
            List<ImageData.Image> r105 = r104.imageList;
            if (r105 == null) goto L11;
            ImageData.Image r106 = (ImageData.Image) ListProtector.get(r105, r100);
            if (r106 == null) goto L11;
            String r107 = r106.getUuid();
        L12:
            r103[1] = TuplesKt.to(ST.UUID_DEVICE, r107);
            r102.invoke(MapsKt.mapOf(r103));
        L11:
            r107 = null;
        L13:
            f r108 = this.f360716c;
            r108.f360708c = Integer.valueOf(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Map<String, String>, Unit> r100, ImageDataModel r101, f r102) {
            this.f360714a = r100;
            this.f360715b = r101;
            this.f360716c = r102;
        }
    }

    public static final class d implements IGetWaterMarkResourceCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, String, Unit> f360717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f360718b;

        @Override // com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback
        public final void onGetFailed() {
            FLogger.f375446a.i("CML_TAG_AbsChameleonPlugin", "onGetFailed original path: " + this.f360718b);
            this.f360717a.invoke(Boolean.TRUE, "");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function2<? super Boolean, ? super String, Unit> r100, String r101) {
            this.f360717a = r100;
            this.f360718b = r101;
        }

        @Override // com.ss.android.lark.watermark.core.IGetWaterMarkResourceCallback
        public final void onGetSuccess(String r100, ByteString r101) {
            Intrinsics.checkNotNullParameter(r101, HTTP.CONTENT_RANGE_BYTES);
            FLogger.f375446a.i("CML_TAG_AbsChameleonPlugin", "onGetSuccess watermark path: " + r100);
            this.f360717a.invoke(Boolean.FALSE, r100);
        }
    }

    static {
    }

    public f(xm9.a r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "tag");
        this.f360706a = r100;
        this.f360707b = r101;
        this.f360711f = LazyKt.lazy(new com.larus.office.base.plugins.attachment.b(this));
    }

    public final void c(ImageDataModel r110, final Function1<? super JSONObject, Unit> r111) {
        Function1<? super Map<String, String>, Unit> r100 = new com.larus.office.base.plugins.attachment.c(r111);
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L61
        if (r110 == null) goto L11;
        List<ImageData.Image> r102 = r110.imageList;     // Catch: Exception -> L61
        if (r102 == null) goto L11;
        Iterator<T> r103 = r102.iterator();     // Catch: Exception -> L61
    L9:
        if (r103.hasNext() == false) goto L11;
        r101.add(new n1(((ImageData.Image) r103.next()).getSrc()));     // Catch: Exception -> L61
    L11:
        FLogger r104 = FLogger.f375446a;     // Catch: Exception -> L61
        StringBuilder r105 = new StringBuilder();     // Catch: Exception -> L61
        r105.append("open image url is ");     // Catch: Exception -> L61
        List<ImageData.Image> r106 = null;
        if (r110 == null) goto L16;
        ImageData.Image r107 = r110.image;     // Catch: Exception -> L61
        if (r107 == null) goto L16;
        String r108 = r107.getSrc();     // Catch: Exception -> L61
    L17:
        r105.append(r108);     // Catch: Exception -> L61
        r104.i("OpenImageHandler", r105.toString());     // Catch: Exception -> L61
        boolean r109 = true;
        if ((!r101.isEmpty()) == false) goto L68;
        Ref.IntRef r112 = new Ref.IntRef();     // Catch: Exception -> L61
        if (r110 == null) goto L22;
        ImageData.Image r113 = r110.image;     // Catch: Exception -> L61
    L23:
        if (r110 == null) goto L26;
        r106 = r110.imageList;     // Catch: Exception -> L61
    L26:
        if (r113 == null) goto L37;
        if (r106 == null) goto L37;
        Iterator<ImageData.Image> r114 = r106.iterator();     // Catch: Exception -> L61
        int r115 = 0;
    L31:
        if (r114.hasNext() == false) goto L36;
        if (Intrinsics.areEqual(r114.next().getSrc(), r113.getSrc()) == true) goto L38;
        r115 = r115 + 1;     // Catch: Exception -> L61
    L38:
        r112.element = r115;     // Catch: Exception -> L61
        if (r115 >= 0) goto L41;
    L42:
        r112.element = 0;     // Catch: Exception -> L61
    L43:
        BigImagePhotoViewerDialog r116 = this.f360710e;     // Catch: Exception -> L61
        if (r116 != null) goto L46;
    L48:
        boolean r117 = false;
    L49:
        if (r117 == true) goto L69;
        xm9.a r118 = this.f360706a;     // Catch: Exception -> L61
        if (r118 != null) goto L54;
    L56:
        r109 = false;
    L57:
        if (r109 == false) goto L59;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new OpenImageHandler$handleInternal$1(this, r110, r101, r112, r100, null), 2, null);     // Catch: Exception -> L61
        return;
    L59:
        b(r110, r101, r112.element, true, true, true, r100);     // Catch: Exception -> L61
        return;
    L54:
        if (r118.isIntegratedVersion() != true) goto L56;
    L69:
        return;
    L46:
        if (r116.isShowing() != true) goto L48;
        r117 = true;
        goto L49
    L41:
        if (r115 < r101.size()) goto L43;
    L36:
        r115 = -1;
    L37:
        r115 = 0;
        goto L38
    L22:
        r113 = null;
        goto L23
    L68:
        return;
    L16:
        r108 = null;
    L61:
        e = move-exception;
        FLogger.f375446a.e("OpenImageHandler", "Open image fail: " + e.getMessage(), e);
    }

    public static final Object a(f r100, com.bytedance.ee.permission.a r101, String r102, int r103, String r104, Continuation r105) {
        r100.getClass();
        kotlinx.coroutines.j r106 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r105), 1);
        r106.C();
        if (r101 == null) goto L7;
        com.bytedance.ee.permission.b r107 = ((PermissionSdk) r101).a();
        if (r107 == null) goto L7;
        r107.b(r102, r103, r104, new g(r104, r106));
    L7:
        Object r108 = r106.B();
        if (r108 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        DebugProbesKt.probeCoroutineSuspended(r105);
    L10:
        return r108;
    }

    public final void b(final ImageDataModel r210, List<n1> r211, int r212, boolean r213, boolean r214, boolean r215, final Function1<? super Map<String, String>, Unit> r216) {
        this.f360708c = Integer.valueOf(r212);
        xm9.a r100 = this.f360706a;
        if (r100 == null) goto L17;
        Context r101 = r100.getContext();
        if (r101 == null) goto L22;
        BigImagePhotoViewerDialog r102 = new BigImagePhotoViewerDialog(r101, r211, null, new k(MapsKt.mapOf(new Pair[]{TuplesKt.to("source", "send_img_holder"), TuplesKt.to("user_type", "user"), TuplesKt.to("enter_picture_method", "chat")}), CollectionsKt.emptyList()), false, null, null, null, null, null, null, r213, r214, r215, 4080);
        r102.f295915p0 = new c(r216, r210, this);
        r102.setOnDismissListener(new com.larus.office.base.plugins.attachment.a(r216, this, r210));
        r102.P0 = (Function2) this.f360711f.getValue();
        this.f360710e = r102;
        View r103 = this.f360706a.getContentView();
        if (r103 == null) goto L18;
        FragmentActivity r104 = this.f360706a.getActivity();
        String r105 = this.f360706a.getFileToken();
        Integer r106 = this.f360706a.getFileObjectType();
        BigImagePhotoViewerDialog r107 = this.f360710e;
        if (r107 == null) goto L12;
        r107.v(r212, r103, this.f360707b);
    L12:
        if (r106 == null) goto L19;
        if (r105 == null) goto L20;
        if (r104 == null) goto L21;
        Lazy<zo5.b> r108 = CCMWatermarkManager.f220231a;
        CCMWatermarkManager.f220231a.getValue().j(r105, r106.intValue(), this.f360710e);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L22:
        return;
    }
}
