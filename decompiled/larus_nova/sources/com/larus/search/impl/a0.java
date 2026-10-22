package com.larus.search.impl;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import com.larus.platform.service.z2;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ActivityResultLauncher<Intent> f367468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Boolean> f367469b;

    public static final class a {
    }

    static {
    }

    public a0() {
        this.f367469b = new LinkedHashMap();
    }

    public final void a(boolean r100, boolean r101, boolean r102, boolean r103) {
        ActivityResultLauncher<Intent> r104 = this.f367468a;
        if (r104 == null) goto L21;
        Intent r105 = new Intent();
        r105.setAction("android.intent.action.GET_CONTENT");
        ArrayList r106 = new ArrayList();
        if (r102 == false) goto L7;
        r105.setType("audio/*");
        r106.add("audio/*");
    L17:
        if ((!r106.isEmpty()) == false) goto L19;
        r105.putExtra("android.intent.extra.MIME_TYPES", (String[]) r106.toArray(new String[0]));
    L19:
        r105.putExtra("android.intent.extra.ALLOW_MULTIPLE", r103);
        r105.addCategory("android.intent.category.OPENABLE");
        v19.b.a(r104, r105);
        return;
    L7:
        r105.setType("*/*");
        List<String> r107 = z2.f365865a.getFlowMultiUploadConfig().k();
        if (r107 == null) goto L10;
        List r108 = CollectionsKt.filterNotNull(r107);
    L11:
        if (r100 == true) goto L13;
        r106.addAll(FileMimeTypeUtils.a(r108));
    L14:
        if (r101 == false) goto L17;
        r106.add("audio/*");
        goto L17
    L13:
        r106.addAll(FileMimeTypeUtils.a(r108));
        r106.add("image/*");
        goto L14
    L10:
        r108 = null;
        goto L11
    }
}
