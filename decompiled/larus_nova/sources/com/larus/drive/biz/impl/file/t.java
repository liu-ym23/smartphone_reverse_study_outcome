package com.larus.drive.biz.impl.file;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.keva.Keva;
import com.larus.drive.biz.api.model.DriveUploadStatus;
import com.larus.drive.biz.impl.sdk.DriveSdkService;
import com.larus.utils.logger.FLogger;
import hq9.c2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f341214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f341215b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f341216c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f341217d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f341218e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final MutableLiveData f341219f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicBoolean f341220g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f341221h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f341222i;

    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f341223a;

        public a(r r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f341223a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f341223a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f341223a.invoke(r100);
        }
    }

    public t() {
    }

    static {
        Lazy r100 = LazyKt.lazy(new j());
        f341214a = r100;
        f341215b = LazyKt.lazy(new k());
        f341216c = LazyKt.lazy(new l());
        f341217d = LazyKt.lazy(new m());
        f341218e = LazyKt.lazy(new n());
        f341219f = f();
        f341220g = new AtomicBoolean(false);
        ((Handler) r100.getValue()).post(new o());
        f341221h = LazyKt.lazy(new p());
    }

    public static Keva c() {
        return (Keva) f341216c.getValue();
    }

    public static CopyOnWriteArrayList d() {
        return (CopyOnWriteArrayList) f341221h.getValue();
    }

    public static List e() {
        return (List) f341217d.getValue();
    }

    public static MutableLiveData f() {
        return (MutableLiveData) f341218e.getValue();
    }

    public static void b() {
        Map r100 = (Map) f().getValue();
        if (r100 == null) goto L11;
        Collection r101 = r100.values();
        if (r101 == null) goto L11;
        Collection r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r103.add(((com.larus.drive.biz.api.model.a) r104.next()).f341029b);
        goto L8
    L10:
        DriveSdkService.f341224a.S(r103);
    L11:
        Map r105 = (Map) f().getValue();
        if (r105 == null) goto L14;
        r105.clear();
    L14:
        f().postValue(f().getValue());
        g((Map) f().getValue());
        c().clear();
        e().clear();
        c().storeStringArray("drive_upload_order_keys", new String[0]);
    }

    public static boolean i() {
        Map r100 = (Map) f().getValue();
        if (r100 == null) goto L5;
        int r101 = r100.size();
    L7:
        if (r101 < ((c2) f341215b.getValue()).j()) goto L10;
        return true;
    L10:
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    public static final void a(com.larus.drive.biz.api.model.a r100) {
        if (k(r100, false) == true) goto L9;
        Map r101 = (Map) f().getValue();
        if (r101 == null) goto L7;
        com.larus.drive.biz.api.model.a r102 = (com.larus.drive.biz.api.model.a) r101.put(r100.f341028a, r100);
    L7:
        f().postValue(f().getValue());
        g((Map) f().getValue());
        return;
    }

    public static void g(Map r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L27;
        Collection r101 = r100.values();
        if ((r101 instanceof Collection) == true) goto L9;
    L11:
        Iterator r102 = r101.iterator();
    L13:
        if (r102.hasNext() == false) goto L20;
        if (((com.larus.drive.biz.api.model.a) r102.next()).f341033f == DriveUploadStatus.FINISH) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == false) goto L13;
        boolean r104 = false;
    L21:
        if (r104 == false) goto L27;
        if (f341222i == false) goto L25;
        return;
    L25:
        f341222i = true;
        ((Handler) f341214a.getValue()).postDelayed(new q(), 3000);
        return;
    L17:
        r103 = false;
    L20:
        r104 = true;
        goto L21
    L9:
        if (r101.isEmpty() == false) goto L11;
    L27:
        if (f341222i == false) goto L36;
        f341222i = false;
        ((Handler) f341214a.getValue()).removeCallbacksAndMessages(null);
        return;
    }

    public static boolean h(int r100) {
        Map r101 = (Map) f().getValue();
        if (r101 == null) goto L5;
        int r102 = r101.size();
    L7:
        if ((r102 + r100) > ((c2) f341215b.getValue()).j()) goto L10;
        return true;
    L10:
        return false;
    L5:
        r102 = 0;
        goto L7
    }

    public static void j(com.larus.drive.biz.api.model.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        DriveUploadStatus r102 = DriveUploadStatus.UNSTARTED;
        List r103 = CollectionsKt.mutableListOf(new DriveUploadStatus[]{DriveUploadStatus.UPLOADING, r102});
        if (r101 == true) goto L6;
        r103.add(DriveUploadStatus.FAILED);
    L6:
        if (r103.contains(r100.f341033f) == true) goto L8;
        return;
    L8:
        String r104 = DriveSdkService.f341224a.I(r100.f341029b, new s());
        FLogger.f375446a.i("DriveUploadManager", "resumeUpload itemId = " + r100.f341028a + ", taskId = " + r100.f341029b + ", newTaskId = " + r104);
        if (r104 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L17;
        com.larus.drive.biz.api.model.a r106 = r100.a();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r106.f341029b = r104;
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r106.f341033f = r102;
        k(r106, false);
        return;
    L17:
        k(r100, true);
        return;
    L11:
        if (StringsKt.isBlank(r104) == true) goto L14;
        r105 = false;
        goto L15
    }

    public static boolean k(com.larus.drive.biz.api.model.a r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Map r101 = (Map) f().getValue();
        DriveUploadStatus r102 = null;
        if (r101 == null) goto L5;
        com.larus.drive.biz.api.model.a r103 = (com.larus.drive.biz.api.model.a) r101.get(r100.f341028a);
    L6:
        if (r103 == null) goto L9;
        r102 = r103.f341033f;
    L9:
        if (r102 != r100.f341033f) goto L15;
        if (r110 == true) goto L15;
        if (Intrinsics.areEqual(r103.f341029b, r100.f341029b) == false) goto L15;
        return false;
    L15:
        if (r110 == false) goto L25;
        if (r103 == null) goto L47;
        c().erase(r100.f341028a);
        Map r111 = (Map) f().getValue();
        if (r111 == null) goto L21;
        com.larus.drive.biz.api.model.a r112 = (com.larus.drive.biz.api.model.a) r111.remove(r100.f341028a);
    L21:
        if (e().remove(r100.f341028a) == false) goto L23;
        c().storeStringArray("drive_upload_order_keys", (String[]) e().toArray(new String[0]));
    L23:
        f().getValue();
        f().postValue(f().getValue());
        g((Map) f().getValue());
        DriveSdkService.f341224a.S(CollectionsKt.listOf(r100.f341029b));
        return true;
    L47:
        return false;
    L25:
        Keva r113 = c();
        String r104 = r100.f341028a;
        JSONObject r105 = new JSONObject();
        r105.put("item_id", r100.f341028a);
        r105.put("task_id", r100.f341029b);
        r105.put("file_name", r100.f341030c);
        r105.put("file_type", r100.f341031d.getValue());
        r105.put("parent_drive_token", r100.f341032e);
        r105.put("status", r100.f341033f.getValue());
        Integer r106 = r100.f341034g;
        if (r106 == null) goto L28;
        r105.put("error_tip_res_id", r106.intValue());
    L28:
        Long r107 = r100.f341035h;
        if (r107 == null) goto L31;
        r105.put("bytes_total", r107.longValue());
    L31:
        Long r108 = r100.f341036i;
        if (r108 == null) goto L34;
        r105.put("bytes_transferred", r108.longValue());
    L34:
        r105.put("event_params", r100.f341037j);
        r113.storeString(r104, r105.toString());
        if (r103 != null) goto L37;
        boolean r114 = true;
    L38:
        Map r109 = (Map) f().getValue();
        if (r109 == null) goto L41;
        com.larus.drive.biz.api.model.a r115 = (com.larus.drive.biz.api.model.a) r109.put(r100.f341028a, r100);
    L41:
        if (r114 == true) goto L43;
    L45:
        f().postValue(f().getValue());
        g((Map) f().getValue());
        return true;
    L43:
        if (e().contains(r100.f341028a) == true) goto L45;
        e().add(r100.f341028a);
        c().storeStringArray("drive_upload_order_keys", (String[]) e().toArray(new String[0]));
        goto L45
    L37:
        r114 = false;
        goto L38
    L5:
        r103 = null;
        goto L6
    }
}
