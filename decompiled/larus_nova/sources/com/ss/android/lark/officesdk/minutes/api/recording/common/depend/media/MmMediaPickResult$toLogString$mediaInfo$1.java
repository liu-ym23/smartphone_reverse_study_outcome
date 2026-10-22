package com.ss.android.lark.officesdk.minutes.api.recording.common.depend.media;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/depend/media/MmPickedMedia;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class MmMediaPickResult$toLogString$mediaInfo$1 extends Lambda implements Function1<f, CharSequence> {
    public static final MmMediaPickResult$toLogString$mediaInfo$1 INSTANCE = null;

    static {
        INSTANCE = new MmMediaPickResult$toLogString$mediaInfo$1();
    }

    public MmMediaPickResult$toLogString$mediaInfo$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(f r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        r100.getClass();
        return "path=null, mimeType=null, isVideo=false, duration=0, width=0, height=0, size=0";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(f r100) {
        return invoke2(r100);
    }
}
