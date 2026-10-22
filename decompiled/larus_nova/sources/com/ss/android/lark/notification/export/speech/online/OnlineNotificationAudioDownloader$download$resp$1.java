package com.ss.android.lark.notification.export.speech.online;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.lark.pb.media.v1.GetResourcePathResponse;
import com.bytedance.lark.pb.media.v1.LocalResource;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", TemplateNodeType.RAW, "Lcom/bytedance/lark/pb/media/v1/GetResourcePathResponse;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class OnlineNotificationAudioDownloader$download$resp$1 extends Lambda implements Function1<GetResourcePathResponse, String> {
    public static final OnlineNotificationAudioDownloader$download$resp$1 INSTANCE = null;

    static {
        INSTANCE = new OnlineNotificationAudioDownloader$download$resp$1();
    }

    public OnlineNotificationAudioDownloader$download$resp$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2(GetResourcePathResponse r100) {
        if (r100 == null) goto L7;
        LocalResource r101 = r100.resource;
        if (r101 == null) goto L7;
        String r102 = r101.path;
        if (r102 == null) goto L7;
        return r102;
    L7:
        return "";
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ String invoke(GetResourcePathResponse r100) {
        return invoke2(r100);
    }
}
