package com.larus.uaigc.helper;

import com.ss.android.lark.image.entity.LoadParams;
import java.util.Map;
import java.util.Set;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes31.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f373022a = null;

    static {
        f373022a = SetsKt.setOf(new String[]{"jpg", LoadParams.ImageFormat.JPEG, LoadParams.ImageFormat.PNG, "webp", "heic", "heif"});
    }

    public static final Map a(CreationLocalDetectState r100) {
        return MapsKt.mapOf(TuplesKt.to("local_detect", r100.getValue()));
    }
}
