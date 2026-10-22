package com.larus.bmhome.taskskill;

import com.larus.bmhome.instruction.core.model.ActionBarInstructionKey;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
import com.larus.im.internal.jni.bean.DispatchCommand;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f314334a = null;

    static {
        f314334a = CollectionsKt.listOf(new Integer[]{Integer.valueOf(DispatchCommand.GET_META_REQUEST.value), Integer.valueOf(DispatchCommand.COMPLETION_REQUEST.value)});
    }

    public static boolean c() {
        return com.larus.platform.service.p1.f365785a.a();
    }

    public static boolean a(com.larus.bmhome.instruction.g r100) {
        Intrinsics.checkNotNullParameter(r100, "instructionInputAbility");
        List<com.larus.bmhome.actionbar.model.z0> r101 = r100.tq();
        if (r101 == null) goto L16;
        Iterator<T> r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((com.larus.bmhome.actionbar.model.z0) r103).f295606b, ActionBarInstructionKey.COCO_DEEP_THINKING.getKey()) == false) goto L6;
    L11:
        com.larus.bmhome.actionbar.model.z0 r104 = (com.larus.bmhome.actionbar.model.z0) r103;
        if (r104 == null) goto L16;
        com.larus.bmhome.actionbar.model.p0 r105 = r104.f295619o;
        if (r105 == null) goto L16;
        return Intrinsics.areEqual(r105.f295376k, Boolean.TRUE);
    L10:
        r103 = null;
    L16:
        return false;
    }

    public static boolean b(String r110) {
        String r100 = com.larus.platform.service.p1.f365785a.c();
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L36;
        List r102 = StringsKt.split$default(StringsKt.substringBefore$default(StringsKt.trim(r110).toString(), '-', null, 2, null), new char[]{'.'}, false, 0, 6, null);
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator r104 = r102.iterator();
    L13:
        if (r104.hasNext() == false) goto L17;
        Integer r111 = StringsKt.toIntOrNull((String) r104.next());
        if (r111 == null) goto L36;
        r103.add(Integer.valueOf(r111.intValue()));
        goto L13
    L17:
        List r105 = StringsKt.split$default(StringsKt.substringBefore$default(r100, '-', null, 2, null), new char[]{'.'}, false, 0, 6, null);
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L19:
        if (r107.hasNext() == false) goto L23;
        Integer r108 = StringsKt.toIntOrNull((String) r107.next());
        if (r108 == null) goto L36;
        r106.add(Integer.valueOf(r108.intValue()));
        goto L19
    L23:
        int r109 = Math.max(r103.size(), r106.size());
        int r112 = 0;
    L24:
        if (r112 >= r109) goto L46;
        Integer r113 = (Integer) CollectionsKt.getOrNull(r103, r112);
        if (r113 == null) goto L28;
        int r114 = r113.intValue();
    L29:
        Integer r115 = (Integer) CollectionsKt.getOrNull(r106, r112);
        if (r115 == null) goto L32;
        int r116 = r115.intValue();
    L33:
        if (r114 != r116) goto L34;
        r112 = r112 + 1;
        goto L24
    L34:
        if (r114 <= r116) goto L36;
        return true;
    L32:
        r116 = 0;
        goto L33
    L28:
        r114 = 0;
        goto L29
    L46:
        return true;
    L36:
        return false;
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r101 = false;
        goto L9
    }

    public static String d(bs8.a r100, AllDeviceResponse r101) {
        String r102 = null;
        if (r100 != null) goto L6;
        FLogger.f375446a.i("TaskUtils", "[resolvePcDeviceId] miss, branch=empty_task_param");
        return null;
    L6:
        String r103 = r100.f20300e;
        if (r103 != null) goto L9;
    L11:
        r103 = null;
    L12:
        if (r103 == null) goto L15;
        FLogger.f375446a.i("TaskUtils", "[resolvePcDeviceId] hit, branch=local_pc_device_id");
        return r103;
    L15:
        String r104 = r100.f20296a;
        if (r104 != null) goto L18;
    L20:
        r104 = null;
    L21:
        if (r104 != null) goto L24;
        FLogger.f375446a.i("TaskUtils", "[resolvePcDeviceId] miss, branch=empty_device_name");
        return null;
    L24:
        if (r101 != null) goto L26;
        GetAllDevicesRepo r105 = GetAllDevicesRepo.f330842a;
        r101 = GetAllDevicesRepo.d();
    L26:
        if (r101 == null) goto L43;
        List<PcDevice> r106 = r101.getDevices();
        if (r106 == null) goto L43;
        Iterator<T> r107 = r106.iterator();
    L31:
        if (r107.hasNext() == false) goto L39;
        Object r108 = r107.next();
        PcDevice r109 = (PcDevice) r108;
        if (r109 == null) goto L35;
        String r110 = r109.d();
    L37:
        if (Intrinsics.areEqual(r110, r104) == false) goto L31;
    L40:
        PcDevice r111 = (PcDevice) r108;
        if (r111 == null) goto L43;
        String r112 = r111.getDeviceId();
    L44:
        if (r112 != null) goto L46;
    L48:
        if (r102 == null) goto L50;
        FLogger.f375446a.i("TaskUtils", "[resolvePcDeviceId] hit, branch=device_name_fallback");
    L51:
        return r102;
    L50:
        FLogger.f375446a.i("TaskUtils", "[resolvePcDeviceId] miss, branch=device_name_fallback");
        goto L51
    L46:
        if ((!StringsKt.isBlank(r112)) == false) goto L48;
        r102 = r112;
        goto L48
    L35:
        r110 = null;
        goto L37
    L39:
        r108 = null;
    L43:
        r112 = null;
        goto L44
    L18:
        if ((!StringsKt.isBlank(r104)) == false) goto L20;
    L9:
        if ((!StringsKt.isBlank(r103)) == false) goto L11;
        goto L11
    }
}
