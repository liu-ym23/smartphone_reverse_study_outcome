package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.ss.android.lark.pb.recognition.GetSpeechConfigResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f429924a = null;

    static {
        f429924a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return GetSpeechConfigResponse.ADAPTER.decode(r100);
    }
}
