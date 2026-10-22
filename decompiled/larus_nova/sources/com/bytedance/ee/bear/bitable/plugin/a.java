package com.bytedance.ee.bear.bitable.plugin;

import android.net.Uri;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.larksuite.framework.utils.i;
import com.obric.sva.sdk.controller.Global;
import io.reactivex.functions.Function;
import java.io.ByteArrayInputStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableDebugPlugin f214920a;

    public a(BitableDebugPlugin r100) {
        this.f214920a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        String r101 = (String) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        JSONObject r102 = new JSONObject(r101);
        String r103 = JSONObjectProtectorUtils.getString(r102, "fileName");
        String r104 = JSONObjectProtectorUtils.getString(r102, "data");
        Uri r105 = i.c(BitableDebugPlugin.access$getContext(this.f214920a), r103 + Global.SUFFIX_TXT_FILE, null, null);
        Intrinsics.checkNotNull(r104);
        return Boolean.valueOf(i.b(BitableDebugPlugin.access$getContext(this.f214920a), new ByteArrayInputStream(StringsKt.encodeToByteArray(r104)), r105));
    }
}
