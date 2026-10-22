package com.ss.android.lark.chameleon;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0010\u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/chameleon/WebMediaPermissionResources;", "", "<init>", "()V", "AUDIO_CAPTURE", "", "VIDEO_CAPTURE", "webToAndroid", "", "grantableWebResources", "", "requested", "", "([Ljava/lang/String;)Ljava/util/List;", "androidPermissions", "webResources", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WebMediaPermissionResources {
    public static final String AUDIO_CAPTURE = "android.webkit.resource.AUDIO_CAPTURE";
    public static final WebMediaPermissionResources INSTANCE = null;
    public static final String VIDEO_CAPTURE = "android.webkit.resource.VIDEO_CAPTURE";
    private static final Map<String, String> webToAndroid = null;

    private WebMediaPermissionResources() {
    }

    static {
        INSTANCE = new WebMediaPermissionResources();
        webToAndroid = MapsKt.mapOf(new Pair[]{TuplesKt.to(AUDIO_CAPTURE, "android.permission.RECORD_AUDIO"), TuplesKt.to(VIDEO_CAPTURE, "android.permission.CAMERA")});
    }

    @JvmStatic
    public static final List<String> androidPermissions(Collection<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "webResources");
        Map<String, String> r101 = webToAndroid;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        String r104 = r101.get((String) r103.next());
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L9:
        return CollectionsKt.distinct(r102);
    }

    @JvmStatic
    public static final List<String> grantableWebResources(String[] r100) {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L11;
        String r104 = r100[r103];
        if (webToAndroid.containsKey(r104) == false) goto L10;
        r101.add(r104);
    L10:
        r103 = r103 + 1;
        goto L6
    L11:
        return r101;
    L4:
        return CollectionsKt.emptyList();
    }
}
