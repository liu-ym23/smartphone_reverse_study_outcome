package com.bytedance.security.android.polaris;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002J$\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0013H\u0007J*\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/security/android/polaris/PolarisIntent;", "", "()V", "IMMUTABLE_FLAGS", "", "blockActions", "", "", "getTargetsUid", "intent", "Landroid/content/Intent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "isActionSecure", "", "isExternalTargetSecure", "isFlagsSecure", "isInternalTargetSecure", "allowedClass", "Ljava/lang/Class;", "allowedClassList", "polaris_release"}, k = 1, mv = {1, 1, 15})
public final class PolarisIntent {
    private static final int IMMUTABLE_FLAGS = 195;
    public static final PolarisIntent INSTANCE = null;
    private static final List<String> blockActions = null;

    private PolarisIntent() {
    }

    static {
        INSTANCE = new PolarisIntent();
        blockActions = CollectionsKt.listOf(new String[]{"android.intent.action.CHOOSER", "android.intent.action.SEND", "android.intent.action.SEND_MULTIPLE", "android.media.action.IMAGE_CAPTURE", "android.media.action.IMAGE_CAPTURE_SECURE", "android.media.action.VIDEO_CAPTURE"});
    }

    private final boolean isActionSecure(Intent r100) {
        return !CollectionsKt.contains(blockActions, r100.getAction());
    }

    private final boolean isFlagsSecure(Intent r100) {
        if ((r100.getFlags() & 195) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final List<Integer> getTargetsUid(Intent r100, Context r101) {
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.getPackageManager().queryIntentActivities(r100, 0).iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(Integer.valueOf(((ResolveInfo) r103.next()).activityInfo.applicationInfo.uid));
        goto L4
    L6:
        Iterator<T> r104 = r101.getPackageManager().queryIntentServices(r100, 0).iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r102.add(Integer.valueOf(((ResolveInfo) r104.next()).serviceInfo.applicationInfo.uid));
        goto L8
    L10:
        Iterator<T> r105 = r101.getPackageManager().queryBroadcastReceivers(r100, 0).iterator();
    L12:
        if (r105.hasNext() == false) goto L15;
        r102.add(Integer.valueOf(((ResolveInfo) r105.next()).activityInfo.applicationInfo.uid));
        goto L12
    L15:
        return CollectionsKt.distinct(r102);
    }

    @JvmStatic
    public static final boolean isExternalTargetSecure(Intent r100, Context r101) {
        List<Integer> r102 = INSTANCE.getTargetsUid(r100, r101);
        boolean r103 = true;
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r104 = r102.iterator();
    L9:
        if (r104.hasNext() == false) goto L16;
        if (((Number) r104.next()).intValue() != r101.getApplicationInfo().uid) goto L13;
        boolean r105 = true;
    L14:
        if (r105 == false) goto L9;
        r103 = false;
        goto L16
    L13:
        r105 = false;
    L16:
        PolarisIntent r106 = INSTANCE;
        boolean r107 = r106.isFlagsSecure(r100) & r103;
        return r106.isActionSecure(r100) & r107;
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }

    @JvmStatic
    public static final boolean isInternalTargetSecure(Intent r100, Context r101, List<? extends Class<?>> r102) {
        ComponentName r103 = r100.getComponent();
        boolean r104 = false;
        if (r103 == null) goto L32;
        List<? extends Class<?>> r105 = r102;
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator<T> r107 = r105.iterator();
    L6:
        if (r107.hasNext() == false) goto L9;
        r106.add(((Class) r107.next()).getName());
        goto L6
    L9:
        if (r106.isEmpty() == false) goto L11;
    L10:
        boolean r108 = false;
    L17:
        List<Integer> r109 = INSTANCE.getTargetsUid(r100, r101);
        if ((r109 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r110 = r109.iterator();
    L24:
        if (r110.hasNext() == false) goto L21;
        if (((Number) r110.next()).intValue() != r101.getApplicationInfo().uid) goto L28;
        boolean r111 = true;
    L29:
        if (r111 == true) goto L24;
    L31:
        return r104 & r108;
    L28:
        r111 = false;
    L21:
        r104 = true;
        goto L31
    L20:
        if (r109.isEmpty() == false) goto L22;
    L11:
        Iterator r112 = r106.iterator();
    L13:
        if (r112.hasNext() == false) goto L10;
        if (Intrinsics.areEqual((String) r112.next(), r103.getClassName()) == false) goto L13;
        r108 = true;
        goto L17
    L32:
        return false;
    }

    @JvmStatic
    public static final boolean isInternalTargetSecure(Intent r100, Context r101, Class<?> r102) {
        ComponentName r103 = r100.getComponent();
        boolean r104 = false;
        if (r103 == null) goto L19;
        boolean r105 = Intrinsics.areEqual(r102.getName(), r103.getClassName());
        List<Integer> r106 = INSTANCE.getTargetsUid(r100, r101);
        if ((r106 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r107 = r106.iterator();
    L11:
        if (r107.hasNext() == false) goto L8;
        if (((Number) r107.next()).intValue() != r101.getApplicationInfo().uid) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L11;
    L18:
        return r104 & r105;
    L15:
        r108 = false;
    L8:
        r104 = true;
        goto L18
    L7:
        if (r106.isEmpty() == false) goto L9;
    L19:
        return false;
    }
}
