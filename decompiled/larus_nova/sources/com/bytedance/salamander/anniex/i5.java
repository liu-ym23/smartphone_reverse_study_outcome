package com.bytedance.salamander.anniex;

import com.bytedance.android.annie.Annie;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f268119a = 0;

    public static final class a {
        public a() {
        }

        public static void a(String r100, int r101, JSONObject r102, JSONObject r110, JSONObject r111) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(Annie.ANNIE_TAG, "bid");
            i1.a(r100, Annie.ANNIE_TAG, Integer.valueOf(r101), r102, r110, r111, null);
        }
    }

    static {
        new a();
    }
}
