package com.bytedance.awemeopen.infra.base.net.mime;

import com.bytedance.awemeopen.infra.base.net.AoRequestHelper;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends a {
    public d(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(AoRequestHelper.INSTANCE.convertToBytes(r100.toString()));
    }
}
