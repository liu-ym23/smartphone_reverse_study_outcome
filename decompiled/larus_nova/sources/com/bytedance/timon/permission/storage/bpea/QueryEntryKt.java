package com.bytedance.timon.permission.storage.bpea;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import com.bytedance.timon.result.timon.TimonResultManager;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class QueryEntryKt {
    public static final Cursor query(final ContentResolver r100, String r101, final Uri r110, final String[] r111, final Bundle r112, final CancellationSignal r113) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r110, "uri");
        Intrinsics.checkNotNullParameter(r112, "queryBundle");
        Function2<? super String, ? super Function0<? extends Object>, ? extends Object> r102 = TimonResultManager.f270695a;
        return (Cursor) TimonResultManager.f270695a.invoke(r101, new AnonymousClass2(r100, r110, r111, r112, r113));
    }

    public static final Cursor query(final ContentResolver r110, String r111, final Uri r112, final String[] r113, final String r114, final String[] r115, final String r116, final CancellationSignal r117) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r111, TextureRenderKeys.KEY_IS_CERT);
        Intrinsics.checkNotNullParameter(r112, "uri");
        Function2<? super String, ? super Function0<? extends Object>, ? extends Object> r100 = TimonResultManager.f270695a;
        return (Cursor) TimonResultManager.f270695a.invoke(r111, new AnonymousClass1(r110, r112, r113, r114, r115, r116, r117));
    }
}
